package org.ga4gh.transport;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.dataformat.avro.AvroFactory;
import com.fasterxml.jackson.dataformat.avro.AvroSchema;
import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.apache.avro.AvroTypeException;
import org.apache.avro.Schema;
import org.apache.avro.generic.GenericDatumReader;
import org.apache.avro.generic.GenericDatumWriter;
import org.apache.avro.generic.GenericRecord;
import org.apache.avro.io.*;
import org.apache.avro.specific.SpecificDatumWriter;
import org.apache.http.HttpStatus;

import java.io.*;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * Created by Wayne Stidolph on 5/22/2015.
 */
public class AvroJson<Q extends org.apache.avro.generic.GenericContainer,P extends org.apache.avro.generic.GenericContainer> {
    private static org.slf4j.Logger log;
    private static Table<String, String, Integer> messages;

    /*
     * table cells are | request (class, post/get, body/id) | response class  | response status code|
     */
    public static Table<String, String, Integer> getMessages() { return messages;}
    static {
        log = getLogger(AvroJson.class);
        messages = HashBasedTable.create();
    }

    public enum DESER_MODE {
        JACKSON_RELAXED,
        JACKSON_AVRO,
        AVRO_DIRECT
    }

    String urlRoot;
    String path;
    final DatumWriter<Q> dw;
    final Q theAvroReq;
    private P theResp;

    Schema reqSchema;
    Schema respSchema;

    ByteArrayOutputStream jsonBytes;
    HttpResponse<JsonNode> httpResp;

    DESER_MODE avroDeserializer = DESER_MODE.JACKSON_RELAXED; // default
    public DESER_MODE getAvroDeserializer() {
        return avroDeserializer;
    }

    public void setAvroDeserializer(DESER_MODE deserialization_mode) {
        this.avroDeserializer = deserialization_mode;
    }
    /*
     * Construct an AvroJson for a particular request/response pattern
     * @param req <Q> an instance of the avro *Request method object
     * @param resp <P> an instance of the avro *Response method object
     * @param urlRoot String the server base (often includes a version number)
     * @param path String the request target path as identified in the avdl
     */
    public AvroJson(Q req, P resp, String urlRoot, String path){
        this.theAvroReq = req;
        this.theResp = resp;
        this.dw = new SpecificDatumWriter<Q>();
        this.urlRoot = urlRoot;
        this.path = path;
    }

    public P doPostResp(){
        reqSchema = theAvroReq.getSchema();
        // split the json-build, the posting, and the resp-build into 3 method calls
        // just for ease of breakpointing
        jsonBytes = avroToJson(dw, reqSchema, theAvroReq);
        httpResp = jsonPost(urlRoot + path);
        theResp = makeAvroFromResponse(httpResp, urlRoot + path);

        // track all message types sent/received for simple "test coverage" indication
        String respName = theResp != null? theResp.getClass().getSimpleName() : "null";
        messages.put(theAvroReq.getClass().getSimpleName()+" POST <"+jsonBytes+">", respName, httpResp.getStatus());;

        return theResp;
    }

    public P doGetResp(String id) {

        // no request object to build, just GET from the endpoint with route param
        httpResp = jsonGet(urlRoot+path, id);
        theResp = makeAvroFromResponse(httpResp, urlRoot + path + "/" + id);

        // track all message types sent/received for simple "test coverage" indication
        String respName = theResp != null? theResp.getClass().getSimpleName() : "null";
        messages.put(theAvroReq.getClass().getSimpleName() + " GET <" + id + ">", respName, httpResp.getStatus());

        return theResp;
    }

    P makeAvroFromResponse(HttpResponse<JsonNode> respToBeConverted, String sourceForLog){
        P response = null;
        if (httpResp.getStatus() == HttpStatus.SC_OK){
            switch (avroDeserializer) {
                case JACKSON_AVRO:
                    try {
                        response = (P)jsonToObject(respToBeConverted.getBody().toString(), theResp.getClass(), theResp.getSchema());
                    } catch ( JsonMappingException jme){
                        response = null;
                        log.warn("deserializing via " + avroDeserializer + " returns null instead of a " + theResp.getClass().getName()
                                + " from: " + respToBeConverted.getBody(), jme);
                    }
                    break;
                case AVRO_DIRECT:
                    try{
                        response = (P) jsonToAvroObject(respToBeConverted.getBody().toString(),theResp.getSchema());
                    } catch ( AvroTypeException ate){
                        response = null;
                        log.warn("deserializing via " + avroDeserializer + " returns null instead of a " + theResp.getClass().getName()
                                + " from: " + respToBeConverted.getBody(), ate);
                    }
                    break;
                case JACKSON_RELAXED:
                    response = (P)jsonToObject(respToBeConverted.getBody().toString(), theResp.getClass());
                    break;
            }
        } else {
            log.warn("makeAvroFromResponse returns null instead of a " + theResp.getClass().getName()
                    + " because rcd status " + httpResp.getStatus()
                    + " with response_BODY < "+ httpResp.getBody() + " >"
                    + " from " + sourceForLog + "with request_BODY < " + String.valueOf(jsonBytes) + " >"
                    );
        }
        return response;
    }

    <T> ByteArrayOutputStream avroToJson(DatumWriter<T> dw, Schema schema, T srcBytes) {

        Boolean pretty = true;
        jsonBytes = new ByteArrayOutputStream();
        try {
            // use jsonEncoder to writer to 'out' byte stream
            JsonEncoder encoder = EncoderFactory.get().jsonEncoder(schema, jsonBytes, pretty);

            dw.setSchema(schema);
            dw.write(srcBytes, encoder); // actual write
            encoder.flush();
            jsonBytes.close();
        } catch (IOException e) {
            log.warn("problem creating JSON from avro for schema " + schema, e);
        }
        if (log.isDebugEnabled()) {
            log.debug("avroToJson generates: " + jsonBytes.toString());
        }
        return jsonBytes;
    }

    HttpResponse<JsonNode> jsonPost(String theURL) {
        HttpResponse<JsonNode> jsonResponse = null;
        try {
            jsonResponse = Unirest.post(theURL)
                    .header("Content-Type", "application/json")
                    .header("accept", "application/json")
                    .body(String.valueOf(jsonBytes))
                    .asJson();
        } catch (UnirestException e) {
            log.warn("problem communicating JSON with " + theURL, e);
        }
        return jsonResponse;
    }

    HttpResponse<JsonNode> jsonGet(String theUrl, String id){
        HttpResponse<JsonNode> jsonResponse = null;

        try {
            jsonResponse = Unirest.get(theUrl)
                    .header("accept", "application/json")
                    .routeParam("id",id)
                    .asJson();
        } catch (UnirestException e) {
            log.warn("problem communicating JSON with " + theUrl + " id: " + id, e);
        }
        return jsonResponse;
    }

    Object jsonToObject( String jsonString, Class objClass){
        Object target = null;

        try {
            ObjectMapper mapper = new ObjectMapper();
            target = mapper.readValue(httpResp.getBody().toString(), objClass);

        } catch (IOException e) {
            log.warn("Failed to make new " + objClass.getName() + " from: " + jsonString, e);
        }
        return target;
    }

    // UNUSED BELOW: work-in-progress for Avro-specific deserialization


    public Object jsonToObject( String jsonString, Class objClass, Schema schema) throws JsonMappingException {

        AvroSchema avSchema = new AvroSchema(schema);
        ObjectMapper om = new ObjectMapper(new AvroFactory());

        Object obj = null;

        try {
            ObjectReader reader = om.reader(objClass).with(avSchema);
            obj = reader.readValue(jsonString.getBytes());
        } catch (IOException e) {
            log.warn("Jackson with AvroFactory failed to make new " + objClass.getName() + " from: " + jsonString, e);
        }
        return obj;
    }



    public <T> T jsonToAvroObject(String theJson, Schema schema){
        byte[] avroByteArray = fromJsonToBytes(theJson, schema);
        if(avroByteArray == null || avroByteArray.length == 0){
            return null;
        }

        DatumReader<GenericRecord> reader1 = new GenericDatumReader<GenericRecord>(schema);
        Decoder decoder1 = DecoderFactory.get().binaryDecoder(avroByteArray, null);
        GenericRecord result = null;
        try {
            result = reader1.read(null, decoder1);
        } catch (IOException e) {
            log.warn("Avro reader failed to get bytes for Schema " + schema.getName(),e);
        }
        return (T) result;
    }

    public byte[] fromJsonToBytes(String theJson, Schema schema){
        ByteArrayOutputStream outputStream = null;

        InputStream input = new ByteArrayInputStream(theJson.getBytes());
        DataInputStream din = new DataInputStream(input);
        Decoder decoder = null;
        try {
            decoder = DecoderFactory.get().jsonDecoder(schema, din);
            DatumReader<Object> reader = new GenericDatumReader<Object>(schema);
            Object datum = reader.read(null, decoder);
            GenericDatumWriter<Object> w = new GenericDatumWriter<Object>(schema);
            outputStream = new ByteArrayOutputStream();

            Encoder e = EncoderFactory.get().binaryEncoder(outputStream, null);

            w.write(datum, e);
            e.flush();

        } catch (IOException e) {
            log.warn("IOException getting bytes", e);
        }
        catch (org.apache.avro.AvroTypeException te){
            log.warn("Failed fromJsonToBytes for " + schema.getName() + " on "+theJson, te);
        }
        byte[] outbytes = new byte[] {};
        if(outputStream != null){
            outbytes = outputStream.toByteArray();
        }
        return outbytes;
    }
}
