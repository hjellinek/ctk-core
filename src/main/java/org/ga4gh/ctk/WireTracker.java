package org.ga4gh.ctk;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jsonpatch.JsonPatch;
import com.github.fge.jsonpatch.diff.JsonDiff;
import com.google.gson.Gson;
import org.ga4gh.GAException;
import org.ga4gh.ctk.transport.RespCode;
import org.slf4j.Logger;

import java.io.IOException;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * Tracking and measurement of the on-the-wore transaction.
 * <p>
 * Used to signal need for wire-format difference measurement
 * of the Avro-defined objects used in a given interaction
 * Created by Wayne Stidolph on 5/27/2015.
 */
public class WireTracker {
    final static Logger log = getLogger(WireTracker.class);

    public String theUrl;
    public String bodySent;
    public String bodyReceived;

    RespCode responseStatus;
    // RANDOM CRAP HERE FROM START OF JSON COMPARISON
    // TODO REFACTOR INTO TEST UTIL (YAGNI?)
    JsonPatch expDiff;
    JsonPatch refDiff;
    // keep as String from the test definition
    String expJsonStr;
    JsonNode expJsonNode;
    // JSON from the outside word is just a String, no type assumptions
    String refJsonStr;
    JsonNode refJsonNode;
    String actJsonStr;
    JsonNode actJsonNode;
    boolean shouldDoRefCompare = false;
    private GAException gae;
    private String message;
    private int errorCode;

    public int getErrorCode() {
        return errorCode;
    }

    public String getMessage() {
        return message;
    }

    public GAException getGae() {
        if (responseStatus != RespCode.OK) {
            // parse the received body
            Gson gson = new Gson();
            gae = gson.fromJson(bodyReceived, GAException.class);
            message = gae.getMessage();
            errorCode = gae.getErrorCode();
        }
        return gae;
    }

    /**
     * Gets difference between the actual (rcd) and expected JSON.
     * <p>
     * If the expDiff has already been calculated, it is returned; if
     * it hasn't been calculated, then then it is calculated and stored first.
     *
     * @return the exp diff
     */
    public JsonPatch getExpDiff() {
        if (expDiff == null) {
            expDiff = JsonDiff.asJsonPatch(getActJsonNode(), getExpJsonNode());
        }
        return expDiff;
    }

    public JsonPatch getRefDiff() {
        if (refDiff == null) {
            refDiff = JsonDiff.asJsonPatch(getActJsonNode(), getRefJsonNode());
        }
        return refDiff;
    }

    public JsonNode getRefJsonNode() {
        if (refJsonStr == null) {
            // TODO get reference server json
            // didn't arrive yet, block here until refJson available
            // or times out and returns null
            log.warn("NO REF STRING TO COMPARE");
        }
        refJsonNode = makeJsonNode(refJsonStr);
        return refJsonNode;
    }

    public boolean isShouldDoRefCompare() {
        return shouldDoRefCompare;
    }

    public void setShouldDoRefCompare(boolean shouldDoRefCompare) {
        this.shouldDoRefCompare = shouldDoRefCompare;
    }

    public void setActJson(String theJson) {
        actJsonStr = theJson;
    }

    public JsonNode getExpJsonNode() {
        if (expJsonNode == null) {
            expJsonNode = makeJsonNode(expJsonStr);
        }
        return expJsonNode;
    }

    public JsonNode getActJsonNode() {
        if (actJsonNode == null) {
            actJsonNode = makeJsonNode(actJsonStr);
        }
        return actJsonNode;
    }

    private JsonNode makeJsonNode(String jsonStr) {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode rtnNode = null;
        try {
            rtnNode = mapper.readTree(jsonStr);
        } catch (IOException e) {
            log.warn("could not make JsonNode from string " + jsonStr, e);
        }
        return rtnNode;
    }

    public RespCode getResponseStatus() {
        return responseStatus;
    }

    public void setResponseStatus(RespCode responseStatus) {
        this.responseStatus = responseStatus;
    }
}
