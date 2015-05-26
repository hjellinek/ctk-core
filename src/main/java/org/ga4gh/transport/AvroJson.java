package org.ga4gh.transport;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.*;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.apache.avro.Schema;
import org.apache.avro.io.DatumWriter;
import org.apache.avro.io.EncoderFactory;
import org.apache.avro.io.JsonEncoder;
import org.apache.avro.specific.SpecificDatumWriter;
import org.apache.http.HttpStatus;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * Created by Wayne Stidolph on 5/22/2015.
 */
public class AvroJson<Q extends org.apache.avro.generic.GenericContainer,P extends org.apache.avro.generic.GenericContainer> {
    private static org.slf4j.Logger log;
    private static Table<String, String, Integer> messages;

    public static Table<String, String, Integer> getMessages() { return messages;}
    static {
        log = getLogger(AvroJson.class);
        messages = HashBasedTable.create();
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

    boolean useAvroForDeserialize = false; // default to Jackson for now
    public boolean isUseAvroForDeserialize() {
        return useAvroForDeserialize;
    }

    public void setUseAvroForDeserialize(boolean useAvroForDeserialize) {
        this.useAvroForDeserialize = useAvroForDeserialize;
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
        theResp = makeAvroFromResponse(httpResp);

        // track all message types sent/received for simple "test coverage" indication
        String respName = theResp != null? theResp.getClass().getSimpleName() : "null";
        messages.put(theAvroReq.getClass().getSimpleName()+" POST", respName, httpResp.getStatus());;

        return theResp;
    }

    public P doGetResp(String id) {

        // no request object to build, just GET from the endpoint with route param
        httpResp = jsonGet(urlRoot+path, id);
        theResp = makeAvroFromResponse(httpResp);

        // track all message types sent/received for simple "test coverage" indication
        String respName = theResp != null? theResp.getClass().getSimpleName() : "null";
        messages.put(theAvroReq.getClass().getSimpleName() + " GET " + id, respName, httpResp.getStatus());

        return theResp;
    }

    P makeAvroFromResponse(HttpResponse<JsonNode> respToBeConverted){
        P response = null;
        if (httpResp.getStatus() == HttpStatus.SC_OK){
            if (!useAvroForDeserialize){
                response = (P)jsonToObject(respToBeConverted.getBody().toString(), theResp.getClass());
            } else {
                // use avro
                log.warn("Using Jackson because avro deserialization not yet supported");
                response = (P)jsonToObject(respToBeConverted.getBody().toString(), theResp.getClass()); // FIXME use avro here, not Jackson
            }
        } else {
            log.warn("return null instead of a " + theResp.getClass().getName()
                    + " because " + urlRoot + path
                    + " returned status " + httpResp.getStatus());
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
            log.debug(jsonBytes.toString());
        }
        return jsonBytes;
    }

    HttpResponse<JsonNode> jsonPost(String theURL) {
        HttpResponse<JsonNode> jsonResponse = null;
        try {
            jsonResponse = Unirest.post(theURL)
                    .header("Content-Type", "application/json")
                    .header("accept", "application/json")
                    .body(jsonBytes.toString())
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
        // return  target;
        return target;
    }

    // UNUSED BELOW: work-in-progress for Avro-specific deserialization
    /*
    public <T> T jsonToAvroObject(String theJson, Schema schema){
        byte[] avroByteArray = fromJsonToBytes(theJson, schema);
        DatumReader<GenericRecord> reader1 = new GenericDatumReader<GenericRecord>(schema);
        Decoder decoder1 = DecoderFactory.get().binaryDecoder(avroByteArray, null);
        try {
            GenericRecord result = reader1.read(null, decoder1);
            return (T) result;
        } catch (IOException e) {
            log.warn("Failed making GenericRecord result",e);
        }
        return null;
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
    */

    /*
    public Object jsonToObject( String jsonString, Class objClass, Schema schema){

        AvroSchema avSchema = new AvroSchema(schema);
        ObjectMapper om = new ObjectMapper(new AvroFactory());

        T obj = null;

        try {
            ObjectReader reader = om.reader(objClass).with(avSchema);
            obj = reader.readValue(jsonString.getBytes());
        } catch (IOException e) {
            log.warn("Used AvroFactory but failed to make new " + objClass.getName() + " from: " + jsonString, e);
        }
        return obj;
    }
    */
}
