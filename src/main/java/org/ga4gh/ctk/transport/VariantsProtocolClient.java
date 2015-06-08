package org.ga4gh.ctk.transport;

import org.apache.avro.AvroRemoteException;
import org.ga4gh.*;
import org.ga4gh.ctk.control.WireDiff;
import org.ga4gh.ctk.transport.avrojson.AvroJson;

/**
 * Created by Wayne Stidolph on 5/25/2015.
 */
public class VariantsProtocolClient implements org.ga4gh.GAVariantMethods {


    public String urlRoot = URLMAPPING.urlRoot; //"http://192.168.2.115:8000/v0.5.1/"; // public for test code access clarity

    public WireDiff wireDiff = null;

    public VariantsProtocolClient(){

    }

    public VariantsProtocolClient(WireDiff wd){
        this.wireDiff = wd;
    }

    /**
     * Gets a list of `GAVariantSet` matching the search criteria.
     * <p>
     * `POST /variantsets/search` must accept a JSON version of
     * `GASearchVariantSetsRequest` as the post body and will return a JSON version
     * of `GASearchVariantSetsResponse`.
     *
     * @param request
     */
    @Override
    public GASearchVariantSetsResponse searchVariantSets(GASearchVariantSetsRequest request) throws AvroRemoteException, GAException {
        String path = URLMAPPING.searchVariantSets;
        GASearchVariantSetsResponse response = new GASearchVariantSetsResponse();
        AvroJson aj =
                new AvroJson<>(request, response, urlRoot, path, wireDiff);
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
     * @param request
     * @param wd the WireDiff control/recording support object
     */
    public GASearchVariantSetsResponse searchVariantSets(GASearchVariantSetsRequest request, WireDiff wd) throws AvroRemoteException, GAException {
        this.wireDiff = wd;
        return searchVariantSets(request);
    }

    /**
     * Gets a list of `GAVariant` matching the search criteria.
     * <p>
     * `POST /variants/search` must accept a JSON version of `GASearchVariantsRequest`
     * as the post body and will return a JSON version of `GASearchVariantsResponse`.
     *
     * @param request
     */
    @Override
    public GASearchVariantsResponse searchVariants(GASearchVariantsRequest request) throws AvroRemoteException, GAException {
        String path = URLMAPPING.searchVariants;
        GASearchVariantsResponse response = new GASearchVariantsResponse();
        AvroJson aj =
                new AvroJson<>(request, response, urlRoot, path, wireDiff);
        response = (GASearchVariantsResponse) aj.doPostResp();
        return response;
    }

    /**
     * Gets a list of `GAVariant` matching the search criteria.
     * <p>
     * `POST /variants/search` must accept a JSON version of `GASearchVariantsRequest`
     * as the post body and will return a JSON version of `GASearchVariantsResponse`.
     *
     * @param request
     * @param wd the WireDiff contro/recording support object
     */

    public GASearchVariantsResponse searchVariants(GASearchVariantsRequest request, WireDiff wd) throws AvroRemoteException, GAException {
        this.wireDiff = wd;
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
        return null;
    }
}
