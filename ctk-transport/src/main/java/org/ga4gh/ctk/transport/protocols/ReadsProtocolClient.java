package org.ga4gh.ctk.transport.protocols;

import org.apache.avro.AvroRemoteException;
import org.ga4gh.*;
import org.ga4gh.ctk.transport.URLMAPPING;
import org.ga4gh.ctk.transport.WireTracker;
import org.ga4gh.ctk.transport.avrojson.AvroJson;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * Created by Wayne Stidolph on 5/21/2015.
 */
public class ReadsProtocolClient implements org.ga4gh.GAReadMethods {

    private org.slf4j.Logger log = getLogger(ReadsProtocolClient.class);

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
     * the post body and will return a JSON version of `GASearchReadsResponse`.</p>
     *
     * @param request filled-in Avro object to be serialized as JSON to the server
     * @throws AvroRemoteException
     * @throws GAException
     */
    @Override
    public GASearchReadsResponse searchReads(GASearchReadsRequest request) throws AvroRemoteException, GAException {
        String path = URLMAPPING.getSearchReads();
        GASearchReadsResponse response = new GASearchReadsResponse();
        AvroJson aj =
                new AvroJson<>(request, response, URLMAPPING.getUrlRoot(), path, wireTracker);
        response = (GASearchReadsResponse) aj.doPostResp();
        return response;
    }

    /**
     * Gets a list of `GAReadAlignment` matching the search criteria.
     * <p>
     * `POST /reads/search` must accept a JSON version of `GASearchReadsRequest` as
     * the post body and will return a JSON version of `GASearchReadsResponse`.</p>
     *
     * @param request  filled-in Avro object to be serialized as JSON to the server
     * @param wt      {@code WireTracker} control whether WireDiffs are use for test support
     *
     * @return the server's response (deserialized into an Avro-defined object)
     * @throws AvroRemoteException
     * @throws GAException
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
     * version of `GASearchReadGroupSetsResponse`.</p>
     *
     * @param request filled-in Avro object to be serialized as JSON to the server
     * @throws AvroRemoteException
     * @throws GAException
     */
    @Override
    public GASearchReadGroupSetsResponse searchReadGroupSets(GASearchReadGroupSetsRequest request) throws AvroRemoteException, GAException {
        String path = URLMAPPING.getSearchReadGroupSets();
        // we use an empty concrete response class to pass into the Parameterized AvroJson
        // as a quick way to get the class name and such; this object actually gets replaced
        // with the filled-in Response object constructed in AvroJson and passed back
        GASearchReadGroupSetsResponse response = new GASearchReadGroupSetsResponse();
        AvroJson aj =
                new AvroJson<>(request, response, URLMAPPING.getUrlRoot(), path, wireTracker);
        //aj.setDeserMode(AvroJson.DESER_MODE.AVRO_DIRECT);
        response = (GASearchReadGroupSetsResponse) aj.doPostResp();

        return response;
    }

    /**
     * Gets a list of `GAReadGroupSet` matching the search criteria.
     * <p>
     * `POST /readgroupsets/search` must accept a JSON version of
     * `GASearchReadGroupSetsRequest` as the post body and will return a JSON
     * version of `GASearchReadGroupSetsResponse`.</p>
     *
     * @param request filled-in Avro object to be serialized as JSON to the server
     * @param wt      {@code WireTracker} control whether WireDiffs are use for test support
     * @throws AvroRemoteException
     * @throws GAException
     */
    public GASearchReadGroupSetsResponse searchReadGroupSets(GASearchReadGroupSetsRequest request, WireTracker wt) throws AvroRemoteException, GAException {
        this.wireTracker = wt;
        return searchReadGroupSets(request);
    }
}