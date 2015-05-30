package org.ga4gh.ctk.transport;

import org.apache.avro.AvroRemoteException;
import org.ga4gh.*;
import org.ga4gh.ctk.control.WireDiff;

import java.net.InetSocketAddress;

/**
 * Created by Wayne Stidolph on 5/25/2015.
 */
public class VariantsProtocolClient implements org.ga4gh.GAVariantMethods {


    public WireDiff wireDiff = null;

    public VariantsProtocolClient(InetSocketAddress endpointAddress){

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
        return null;
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
        return null;
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
