package org.ga4gh.ctk.transport.protocols;

import org.apache.avro.AvroRemoteException;
import org.ga4gh.*;
import org.ga4gh.ctk.transport.*;
import org.ga4gh.ctk.transport.avrojson.AvroJson;

/**
 * Created by Wayne Stidolph on 5/25/2015.
 */
public class VariantsProtocolClient implements org.ga4gh.GAVariantMethods {

    public WireTracker wireTracker = null;

    URLMAPPING urls;
    public VariantsProtocolClient(URLMAPPING urls){
        this.urls = urls;
    }

    public VariantsProtocolClient(URLMAPPING urls, WireTracker wt){
        this.urls=urls;
        this.wireTracker = wt;
    }

    /**
     * Gets a list of `GAVariantSet` matching the search criteria.
     * <p>
     * `POST /variantsets/search` must accept a JSON version of
     * `GASearchVariantSetsRequest` as the post body and will return a JSON version
     * of `GASearchVariantSetsResponse`.
     *
     * @param request the GASearchVariantSetsRequest we're issuing
     */
    @Override
    public GASearchVariantSetsResponse searchVariantSets(GASearchVariantSetsRequest request) throws AvroRemoteException, GAException {
        String path = urls.getSearchVariantSets();
        GASearchVariantSetsResponse response = new GASearchVariantSetsResponse();
        AvroJson aj =
                new AvroJson<>(request, response, urls.getUrlRoot(), path, wireTracker);
        response = (GASearchVariantSetsResponse) aj.doPostResp();
        return response;
    }

    /**
     * Gets a list of `GAVariantSet` matching the search criteria.
     * <p>
     * `POST /variantsets/search` must accept a JSON version of
     * `GASearchVariantSetsRequest` as the post body and will return a JSON version
     * of `GASearchVariantSetsResponse`.
     *
     * @param request the GASearchVariantSetsRequest we're issuing
     * @param wt the WireTracker control/recording support object
     */
    public GASearchVariantSetsResponse searchVariantSets(GASearchVariantSetsRequest request, WireTracker wt) throws AvroRemoteException, GAException {
        this.wireTracker = wt;
        return searchVariantSets(request);
    }

    /**
     * Gets a list of `GAVariant` matching the search criteria.
     * <p>
     * `POST /variants/search` must accept a JSON version of `GASearchVariantsRequest`
     * as the post body and will return a JSON version of `GASearchVariantsResponse`.
     *
     * @param request the GASearchVariantsRequest we're issuing
     */
    @Override
    public GASearchVariantsResponse searchVariants(GASearchVariantsRequest request) throws AvroRemoteException, GAException {
        String path = urls.getSearchVariants();
        GASearchVariantsResponse response = new GASearchVariantsResponse();
        AvroJson aj =
                new AvroJson<>(request, response, urls.getUrlRoot(), path, wireTracker);
        response = (GASearchVariantsResponse) aj.doPostResp();
        return response;
    }

    /**
     * Gets a list of `GAVariant` matching the search criteria.
     * <p>
     * `POST /variants/search` must accept a JSON version of `GASearchVariantsRequest`
     * as the post body and will return a JSON version of `GASearchVariantsResponse`.
     *
     * @param request the GASearchVariantsRequest we're issuing
     * @param wt the WireTracker control/recording support object
     */

    public GASearchVariantsResponse searchVariants(GASearchVariantsRequest request, WireTracker wt) throws AvroRemoteException, GAException {
        this.wireTracker = wt;
        return searchVariants(request);
    }
        /**
         * Gets a list of `GACallSet` matching the search criteria.
         * <p>
         * `POST /callsets/search` must accept a JSON version of `GASearchCallSetsRequest`
         * as the post body and will return a JSON version of `GASearchCallSetsResponse`.
         *
         * @param request

         */
    @Override
    public GASearchCallSetsResponse searchCallSets(GASearchCallSetsRequest request) throws AvroRemoteException, GAException {
        String path = urls.getSearchCallsets();
        GASearchCallSetsResponse response = new GASearchCallSetsResponse();
        AvroJson aj =
                new AvroJson<>(request, response, urls.getUrlRoot(), path, wireTracker);
        response = (GASearchCallSetsResponse) aj.doPostResp();
        return response;
    }
    
    /**
     * Gets a list of `GACallSet` matching the search criteria.
     * <p>
     * `POST /callsets/search` must accept a JSON version of `GASearchCallSetsRequest`
     * as the post body and will return a JSON version of `GASearchCallSetsResponse`.
     *
     * @param request the GASearchVariantsRequest we're issuing
     * @param wt the WireTracker contro/recording support object
     */
    public GASearchCallSetsResponse searchCallSets(GASearchCallSetsRequest request, WireTracker wt) throws AvroRemoteException, GAException {
        this.wireTracker = wt;
        return searchCallSets(request);
    }
}