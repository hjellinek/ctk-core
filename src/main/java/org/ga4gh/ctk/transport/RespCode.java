package org.ga4gh.ctk.transport;

/**
 * <p>Define subset of all HttpStatus codes for specific use in a GA4GH server.
 * Return of status codes not in this list will be flagged as a test failure.</p>
 * <p>Created by Wayne Stidolph on 6/8/2015.</p>
 */
public enum RespCode {
    /**
     * Request accepted and response provided.
     */
    OK(200),
    /**
     * Request accepted but doesn't match any data.
     */
    NO_DATA_FOUND(404),
    /**
     * Request violates semantic constraints.
     */
    NONSENSICAL_REQUEST(400),
    /**
     * Request invokes facility not implemented.
     */
    NOT_IMPLEMENTED(501);

    private int code;

    private RespCode(int value){
        this.code=value;
    }
}
