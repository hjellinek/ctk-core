package org.ga4gh.ctk.comparators;

import com.fasterxml.jackson.databind.JsonNode;

/**
 * Created by Wayne Stidolph on 5/27/2015.
 */
public class JsonPatchMaker {
    JsonNode patch;
    JsonNode fromNode;
    JsonNode toNode;

    /*
final JsonNode patchNode = JsonPatchMaker.asJson(firstNode, secondNode);
System.out.println("Diff=" + m.writeValueAsString(patchNode));
 */

    public JsonNode getFromNode() {
        return fromNode;
    }

    public void setFromNode(JsonNode fromNode) {
        this.fromNode = fromNode;
    }

    public JsonNode getPatch() {
        return patch;
    }

    public void setPatch(JsonNode patch) {
        this.patch = patch;
    }

}
