package org.ga4gh.ctk.transport.avrojson;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.apache.avro.Schema;
import org.apache.avro.io.DatumWriter;
import org.apache.avro.specific.SpecificDatumWriter;
import org.apache.avro.specific.SpecificRecordBase;
import org.apache.http.HttpStatus;
import org.ga4gh.ctk.WireTracker;
import org.ga4gh.ctk.transport.RespCode;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * Provide Avro/Json communications layer specific to GA4GH and with extensive logging in support of CTK use.
 * Created by Wayne Stidolph on 5/22/2015.
 */
public class AvroJson<Q extends SpecificRecordBase, P extends SpecificRecordBase> {
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
    String jsonStr;
    HttpResponse<JsonNode> httpResp;
    AvroMaker.DESER_MODE deserMode = AvroMaker.DESER_MODE.GSON_RELAXED; // default
    private P theResp;
    private WireTracker wireTracker;

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
        this.wireTracker = null;
    }

    /**
     * Construct an AvroJson for a particular request/response interaction.
     * The req and resp types parameterize this interaction object.
     *
     * @param req      an instance of the avro *Request method object
     * @param resp     an instance of the avro *Response method object
     * @param urlRoot  String the server base (often includes a version number)
     * @param path     String the request target path as identified in the avdl
     * @param wireTracker {@code WireTracker} control and transfer of on-the-wire difference measure
     */
    public AvroJson(Q req, P resp, String urlRoot, String path, WireTracker wireTracker) {
        this(req, resp, urlRoot, path);
        this.wireTracker = wireTracker;
    }

    /*
     * table cells are | request (class, post/get, body/id) | response class  | response status code|
     */
    public static Table<String, String, Integer> getMessages() {
        return messages;
    }

    public AvroMaker.DESER_MODE getDeserMode() {
        return deserMode;
    }

    public void setDeserMode(AvroMaker.DESER_MODE deserialization_mode) {
        this.deserMode = deserialization_mode;
    }

    /**
     * Getter for the WireTracker (if present, triggers JSON collection).
     *
     * @return the {@code WireTracker}
     */
    public WireTracker getWireTracker() {
        return wireTracker;
    }

    /**
     * Setter for the WireTracker (if present, tiggers JSON collection).
     *
     * @param wireTracker
     */
    public void setWireTracker(WireTracker wireTracker) {
        this.wireTracker = wireTracker;
    }

    /**
     * Perform POST (according the data stored in this object at construction).
     * <p>
     * If this object has a WireTracker then the return JSON (if any) is copied into that.
     * This method also tracks all message types sent and received, in the 'messages' Table.
     *
     * @return an instance of the response type (as set during onbject construction), can be null.
     */
    public P doPostResp() {
        reqSchema = theAvroReq.getSchema();

        //jsonBytes = JsonMaker.avroToJsonBytes(dw, reqSchema, theAvroReq);
        //jsonBytes = JsonMaker.JacksonToJsonBytes(theAvroReq);
        jsonStr = JsonMaker.GsonToJsonBytes(theAvroReq);

        httpResp = jsonPost(urlRoot + path);
        if(wireTracker != null){
            wireTracker.setResponseStatus(RespCode.fromInt(httpResp.getStatus()));
            //wireTracker.setActJson(json);
        }
        if (httpResp.getStatus() == HttpStatus.SC_OK) {
            String json = httpResp.getBody().toString();
            if (wireTracker != null) {
                wireTracker.setActJson(json);
            }

            theResp = new AvroMaker<>(theResp).makeAvroFromJson(json, urlRoot + path, deserMode); // URL just for logging
        }
        // track all message types sent/received for simple "test coverage" indication
        String respName = theResp != null ? theResp.getClass().getSimpleName()  : "null";
        messages.put(theAvroReq.getClass().getSimpleName() + " POST <" + jsonStr + ">", respName, httpResp.getStatus());

        return theResp;
    }

    /**
     * Perform GET (according the data stored in this object at construction).
     * <p>
     * If this object has a WireTracker then the return JSON (if any) is copied into that.
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
            theResp = new AvroMaker<>(theResp).makeAvroFromJson(json, urlRoot + path + "/" + id, deserMode);
        }
        // track all message types sent/received for simple "test coverage" indication
        String respName = theResp != null ? theResp.getClass().getSimpleName() : "null";
        messages.put(theAvroReq.getClass().getSimpleName() + " GET <" + id + ">", respName, httpResp.getStatus());

        return theResp;
    }

    HttpResponse<JsonNode> jsonPost(String theURL) {
        if (log.isDebugEnabled()) {
            log.debug("begin jsonPost to " + theURL + " of " + jsonStr);
        }
        HttpResponse<JsonNode> jsonResponse = null;
        try {
            jsonResponse = Unirest.post(theURL)
                    .header("Content-Type", "application/json")
                    .header("accept", "application/json")
                    .body(jsonStr)
                    .asJson();
        } catch (UnirestException e) {
            log.warn("problem communicating JSON with " + theURL, e);
        }
        if (log.isDebugEnabled()) {
            log.debug("exit jsonPost to " + theURL + " with status " + jsonResponse.getStatusText());
        }
        if (wireTracker != null) {
            wireTracker.theUrl = theURL;
            wireTracker.bodySent = jsonStr;
            wireTracker.bodyReceived = jsonResponse.getBody().toString();
            wireTracker.setResponseStatus(RespCode.fromInt(jsonResponse.getStatus()));
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
        if (wireTracker != null) {
            wireTracker.theUrl = theUrl + "/ " + id;
            wireTracker.bodySent = "";
            wireTracker.bodyReceived = jsonResponse.getBody().toString();
            wireTracker.setResponseStatus(RespCode.fromInt(jsonResponse.getStatus()));
        }
        return jsonResponse;
    }
}
