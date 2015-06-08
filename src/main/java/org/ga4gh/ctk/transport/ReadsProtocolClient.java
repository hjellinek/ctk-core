package org.ga4gh.ctk.transport;

import org.apache.avro.AvroRemoteException;
import org.ga4gh.*;
import org.ga4gh.ctk.control.WireTracker;
import org.ga4gh.ctk.transport.avrojson.AvroJson;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * Created by Wayne Stidolph on 5/21/2015.
 */
public class ReadsProtocolClient implements org.ga4gh.GAReadMethods {

    private org.slf4j.Logger log = getLogger(ReadsProtocolClient.class);

    public String urlRoot = URLMAPPING.urlRoot; //"http://192.168.2.115:8000/v0.5.1/"; // public for test code access clarity

    public WireTracker wireTracker;

    public ReadsProtocolClient() {
    }

    public ReadsProtocolClient( WireTracker wt) {
        this.wireTracker = wt;
    }

    /**
     * Gets a list of `GAReadAlignment` matching the search criteria.
     * <p>
     * `POST /reads/search` must accept a JSON version of `GASearchReadsRequest` as
     * the post body and will return a JSON version of `GASearchReadsResponse`.
     *
     * @param request
     */
    @Override
    public GASearchReadsResponse searchReads(GASearchReadsRequest request) throws AvroRemoteException, GAException {
        String path = URLMAPPING.searchReads;
        GASearchReadsResponse response = new GASearchReadsResponse();
        AvroJson aj =
                new AvroJson<>(request, response, urlRoot, path, wireTracker);
        response = (GASearchReadsResponse) aj.doPostResp();
        return response;
    }

    /**
     * Gets a list of `GAReadAlignment` matching the search criteria.
     * <p>
     * `POST /reads/search` must accept a JSON version of `GASearchReadsRequest` as
     * the post body and will return a JSON version of `GASearchReadsResponse`.
     *
     * @param request
     * @param wt      {@code WireTracker} control whether WireDiffs are use for test support
     */
    public GASearchReadsResponse searchReads(GASearchReadsRequest request, WireTracker wt) throws AvroRemoteException, GAException {
        this.wireTracker = wt;
        return searchReads(request);
    }

    /**
     * Gets a list of `GAReadGroupSet` matching the search criteria.
     * <p>
     * `POST /readgroupsets/search` must accept a JSON version of
     * `GASearchReadGroupSetsRequest` as the post body and will return a JSON
     * version of `GASearchReadGroupSetsResponse`.
     *
     * @param request
     */
    @Override
    public GASearchReadGroupSetsResponse searchReadGroupSets(GASearchReadGroupSetsRequest request) throws AvroRemoteException, GAException {
        String path = URLMAPPING.searchReadGroupSets;
        // we use an empty concrete response class to pass into the Parameterized AvroJson
        // as a quickway to get the class name and such; this bject actually gets replaced
        // with the filled-in Repsonse object constructed in AvroJson and passed back
        GASearchReadGroupSetsResponse response = new GASearchReadGroupSetsResponse();
        AvroJson aj =
                new AvroJson<>(request, response, urlRoot, path, wireTracker);
        //aj.setDeserMode(AvroJson.DESER_MODE.AVRO_DIRECT);
        response = (GASearchReadGroupSetsResponse) aj.doPostResp();

        return response;
    }

    /**
     * Gets a list of `GAReadGroupSet` matching the search criteria.
     * <p>
     * `POST /readgroupsets/search` must accept a JSON version of
     * `GASearchReadGroupSetsRequest` as the post body and will return a JSON
     * version of `GASearchReadGroupSetsResponse`.
     *
     * @param request
     * @param wt      {@code WireTracker} control whether WireDiffs are use for test support
     */
    public GASearchReadGroupSetsResponse searchReadGroupSets(GASearchReadGroupSetsRequest request, WireTracker wt) throws AvroRemoteException, GAException {
        this.wireTracker = wt;
        return searchReadGroupSets(request);
    }
}