package org.ga4gh.ctk.control;

import com.fasterxml.jackson.databind.JsonNode;

/**
 * Used to signal need for wire-format difference measurement
 * of the Avro-defined objects used in a given interaction
 * Created by Wayne Stidolph on 5/27/2015.
 */
public class WireDiff {
    JsonNode expDiff;
    JsonNode refDiff;
    JsonNode expJson;
}
