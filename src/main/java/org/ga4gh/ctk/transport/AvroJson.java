package org.ga4gh.ctk.transport;

import com.fasterxml.jackson.databind.DeserializationFeature;
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
import org.ga4gh.ctk.control.WireDiff;

import java.io.*;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * Provide Avro/Json communications layer specific to GA4GH and with extensive logging in support of CTK use.
 * Created by Wayne Stidolph on 5/22/2015.
 */
public class AvroJson<Q extends org.apache.avro.generic.GenericContainer, P extends org.apache.avro.generic.GenericContainer> {
    private static org.slf4j.Logger log;
    private static Table<String, String, Integer> messages;

    static {
        log = getLogger(AvroJson.class);
        messages = HashBasedTable.create();
    }

    final DatumWriter<Q> dw;
    final Q theAvroReq;
    /**
     * url root to system-under-test; e.g., "http://localhost:8000/v0.5.1/"
     */
    String urlRoot;
    /**
     * url root to live comparison server
     */
    String refRoot;
    /**
     * if true, duplicate request to refserver and compare results
     */
    boolean compareToRef = false;

    String path;
    Schema reqSchema;
    Schema respSchema;
    ByteArrayOutputStream jsonBytes;
    HttpResponse<JsonNode> httpResp;
    DESER_MODE avroDeserializer = DESER_MODE.JACKSON_RELAXED; // default
    private P theResp;
    private WireDiff wireDiff;

    /**
     * Construct an AvroJson for a particular request/response interaction.
     * The req and resp types parameterize this interaction object.
     *
     * @param req     an instance of the avro *Request method object
     * @param resp    an instance of the avro *Response method object
     * @param urlRoot String the server base (often includes a version number)
     * @param path    String the request target path as identified in the avdl
     */
    public AvroJson(Q req, P resp, String urlRoot, String path) {
        this.theAvroReq = req;
        this.theResp = resp;
        this.dw = new SpecificDatumWriter<Q>();
        this.urlRoot = urlRoot;
        this.path = path;
        this.wireDiff = null;
    }

    /**
     * Construct an AvroJson for a particular request/response interaction.
     * The req and resp types parameterize this interaction object.
     *
     * @param req      an instance of the avro *Request method object
     * @param resp     an instance of the avro *Response method object
     * @param urlRoot  String the server base (often includes a version number)
     * @param path     String the request target path as identified in the avdl
     * @param wireDiff {@code WireDiff} control and transfer of on-the-wire difference measure
     */
    public AvroJson(Q req, P resp, String urlRoot, String path, WireDiff wireDiff) {
        this(req, resp, urlRoot, path);
        this.wireDiff = wireDiff;
    }

    /*
     * table cells are | request (class, post/get, body/id) | response class  | response status code|
     */
    public static Table<String, String, Integer> getMessages() {
        return messages;
    }

    public DESER_MODE getAvroDeserializer() {
        return avroDeserializer;
    }

    public void setAvroDeserializer(DESER_MODE deserialization_mode) {
        this.avroDeserializer = deserialization_mode;
    }

    /**
     * Getter for the WireDiff (if present, triggers JSON collection).
     *
     * @return the {@code WireDiff}
     */
    public WireDiff getWireDiff() {
        return wireDiff;
    }

    /**
     * Setter for the WireDiff (if present, tiggers JSON collection).
     *
     * @param wireDiff
     */
    public void setWireDiff(WireDiff wireDiff) {
        this.wireDiff = wireDiff;
    }

    /**
     * Perform POST (according the data stored in this object at construction).
     * <p>
     * If this object has a WireDiff then the return JSON (if any) is copied into that.
     * This method also tracks all message types sent and received, in the 'messages' Table.
     *
     * @return an instance of the response type (as set during onbject construction), can be null.
     */
    public P doPostResp() {
        reqSchema = theAvroReq.getSchema();
        // split the json-build, the posting, and the resp-build into 3 method calls
        // just for ease of breakpointing
        jsonBytes = avroToJson(dw, reqSchema, theAvroReq);


        httpResp = jsonPost(urlRoot + path);
        if (httpResp.getStatus() == HttpStatus.SC_OK) {
            String json = httpResp.getBody().toString();
            if (wireDiff != null) wireDiff.setActJson(json);

            // will use current dummy theResp (as set by constructor), to get
            // schema info, then replace the dummy with the real response
            // as received and parsed
            theResp = makeAvroFromJson(json, urlRoot + path); // URL just for logging
        }
        // track all message types sent/received for simple "test coverage" indication
        String respName = theResp != null ? theResp.getClass().getSimpleName()  : "null";
        messages.put(theAvroReq.getClass().getSimpleName() + " POST <" + jsonBytes + ">", respName, httpResp.getStatus());


        return theResp;
    }

    /**
     * Perform GET (according the data stored in this object at construction).
     * <p>
     * If this object has a WireDiff then the return JSON (if any) is copied into that.
     * This method also tracks all message types sent and received, in the 'messages' Table. The
     * 'sent' message type (the Request type) is meaningless, except that it sets the target URL
     * during object construction - the Request type avro object isn't actually serialized.
     *
     * @return an instance of the response type (as set during onbject construction), can be null.
     */
    public P doGetResp(String id) {

        // no request object to build, just GET from the endpoint with route param
        httpResp = jsonGet(urlRoot + path, id);

        if (httpResp.getStatus() == HttpStatus.SC_OK) {
            String json = httpResp.getBody().toString();
            if (wireDiff != null) wireDiff.setActJson(json);

            theResp = makeAvroFromJson(json, urlRoot + path + "/" + id);
        }
        // track all message types sent/received for simple "test coverage" indication
        String respName = theResp != null ? theResp.getClass().getSimpleName() : "null";
        messages.put(theAvroReq.getClass().getSimpleName() + " GET <" + id + ">", respName, httpResp.getStatus());

        return theResp;
    }

    P makeAvroFromJson(String json, String sourceForLog) {
        assert httpResp.getStatus() == HttpStatus.SC_OK;
        P response = null;
        String theRespSchema = theResp.getSchema().toString(true);
        log.trace("AVRO EXPECTED-RESPONSE SCHEMA: " + theRespSchema);

        switch (avroDeserializer) { // TODO use polymorphic on jsonToObject instead of switch? Or is this clearer?
            case JACKSON_AVRO:
                try {
                    response = (P) jsonToObject(json, theResp.getClass(), theResp.getSchema());
                } catch (JsonMappingException jme) {
                    response = null;
                    log.warn("deserializing via " + avroDeserializer + " returns null instead of a " + theResp.getClass().getName()
                            + " from: " + json, jme);
                }
                break;
            case AVRO_DIRECT:
                try {
                    response = (P) jsonToAvroObject(json, theResp.getSchema());
                } catch (AvroTypeException ate) {
                    response = null;
                    log.warn("deserializing via " + avroDeserializer + " returns null instead of a " + theResp.getClass().getName()
                            + " from: " + json, ate);
                }
                break;
            case JACKSON_RELAXED:
                response = (P) jsonToObject(json, theResp.getClass());
                break;
        }

        if(response == null){
            log.info("makeAvroFromResponse returns null instead of requested " + theResp.getClass().getName()
                            + " with response_BODY < " + httpResp.getBody() + " >"
                            + " from " + sourceForLog + " for request_BODY < " + String.valueOf(jsonBytes) + " >"
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
        if (log.isDebugEnabled()) {
            log.debug("begin jsonPost to " + theURL + " of " + String.valueOf(jsonBytes));
        }
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
        if (log.isDebugEnabled()) {
            log.debug("exit jsonPost to " + theURL + " with status " + jsonResponse.getStatusText());
        }
        return jsonResponse;
    }

    HttpResponse<JsonNode> jsonGet(String theUrl, String id) {
        if (log.isDebugEnabled()) {
            log.debug("begin jsonGet to " + theUrl + " id=" + id);
        }
        HttpResponse<JsonNode> jsonResponse = null;

        try {
            jsonResponse = Unirest.get(theUrl)
                    .header("accept", "application/json")
                    .routeParam("id", id)
                    .asJson();
        } catch (UnirestException e) {
            log.warn("problem communicating JSON with " + theUrl + " id: " + id, e);
        }
        if (log.isDebugEnabled()) {
            log.debug("exit jsonGet to " + theUrl + " id=" + id + " with status " + jsonResponse.getStatusText());
        }
        if (wireDiff != null) {
            wireDiff.setActJson(jsonResponse.getBody().toString());
        }
        return jsonResponse;
    }

    public void jsonCompare() {

    }

    Object jsonToObject(String jsonString, Class objClass) {
        Object target = null;

        try {
            ObjectMapper mapper = new ObjectMapper()
                    .configure(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES, false);
            target = mapper.readValue(httpResp.getBody().toString(), objClass);

        } catch (IOException e) {
            log.warn("Failed to make new " + objClass.getName() + " from: " + jsonString, e);
        }
        return target;
    }

    public Object jsonToObject(String jsonString, Class objClass, Schema schema) throws JsonMappingException {

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

    public <T> T jsonToAvroObject(String theJson, Schema schema) {
        byte[] avroByteArray = fromJsonToBytes(theJson, schema);
        if (avroByteArray == null || avroByteArray.length == 0) {
            return null;
        }

        DatumReader<GenericRecord> reader1 = new GenericDatumReader<GenericRecord>(schema);
        Decoder decoder1 = DecoderFactory.get().binaryDecoder(avroByteArray, null);
        GenericRecord result = null;
        try {
            result = reader1.read(null, decoder1);
        } catch (IOException e) {
            log.warn("Avro reader failed to get bytes for Schema " + schema.getName(), e);
        }
        return (T) result;
    }

    public byte[] fromJsonToBytes(String theJson, Schema schema) {
        ByteArrayOutputStream outputStream = null;

        //InputStream input = new ByteArrayInputStream(theJson.getBytes());
        // DataInputStream din = new DataInputStream(input);
        // Decoder decoder = null;
        try {
            JsonDecoder decoder = DecoderFactory.get().jsonDecoder(schema, theJson);
            DatumReader<GenericRecord> reader = new GenericDatumReader<GenericRecord>(schema);
            GenericRecord datum = reader.read(null, decoder);
            GenericDatumWriter<Object> w = new GenericDatumWriter<Object>(schema);
            outputStream = new ByteArrayOutputStream();

            Encoder e = EncoderFactory.get().binaryEncoder(outputStream, null);

            w.write(datum, e);
            e.flush();

        } catch (IOException e) {
            log.warn("IOException getting bytes", e);
        } catch (org.apache.avro.AvroTypeException ate) {
            log.warn("Failed fromJsonToBytes for " + schema.getName() + " on " + theJson, ate);
        }
        byte[] outbytes = new byte[]{};
        if (outputStream != null) {
            outbytes = outputStream.toByteArray();
        }
        return outbytes;
    }

    public enum DESER_MODE {
        JACKSON_RELAXED,
        JACKSON_AVRO,
        AVRO_DIRECT
    }
}
