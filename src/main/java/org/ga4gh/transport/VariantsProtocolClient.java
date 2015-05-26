package org.ga4gh.transport;

import org.apache.avro.AvroRemoteException;
import org.ga4gh.methods.*;
import org.ga4gh.models.Allele;
import org.ga4gh.models.CallSet;
import org.ga4gh.models.Variant;
import org.ga4gh.models.VariantSet;

/**
 * Created by Wayne Stidolph on 5/25/2015.
 */
public class VariantsProtocolClient implements org.ga4gh.methods.VariantMethods {
    /**
     * Gets a list of `VariantSet` matching the search criteria.
     * <p>
     * `POST /variantsets/search` must accept a JSON version of
     * `SearchVariantSetsRequest` as the post body and will return a JSON version
     * of `SearchVariantSetsResponse`.
     *
     * @param request
     */
    @Override
    public SearchVariantSetsResponse searchVariantSets(SearchVariantSetsRequest request) throws AvroRemoteException, GAException {
        return null;
    }

    /**
     * Gets a `VariantSet` by ID.
     * `GET /variantsets/{id}` will return a JSON version of `VariantSet`.
     *
     * @param id
     */
    @Override
    public VariantSet getVariantSet(String id) throws AvroRemoteException, GAException {
        return null;
    }

    /**
     * Gets a list of `Variant` matching the search criteria.
     * <p>
     * `POST /variants/search` must accept a JSON version of `SearchVariantsRequest`
     * as the post body and will return a JSON version of `SearchVariantsResponse`.
     *
     * @param request
     */
    @Override
    public SearchVariantsResponse searchVariants(SearchVariantsRequest request) throws AvroRemoteException, GAException {
        return null;
    }

    /**
     * Gets a `Variant` by ID.
     * `GET /variants/{id}` will return a JSON version of `Variant`.
     *
     * @param id
     */
    @Override
    public Variant getVariant(String id) throws AvroRemoteException, GAException {
        return null;
    }

    /**
     * Gets a list of `Allele`s matching the search criteria.
     * <p>
     * `POST /alleles/search` must accept a JSON version of `SearchAllelesRequest` as
     * the post body and will return a JSON version of `SearchAllelesResponse`.
     *
     * @param request
     */
    @Override
    public SearchAllelesResponse searchAlleles(SearchAllelesRequest request) throws AvroRemoteException, GAException {
        return null;
    }

    /**
     * Gets an `Allele` by ID.
     * `GET /alleles/{id}` will return a JSON version of `Allele`.
     *
     * @param id
     */
    @Override
    public Allele getAllele(String id) throws AvroRemoteException, GAException {
        return null;
    }

    /**
     * Gets a list of `CallSet` matching the search criteria.
     * <p>
     * `POST /callsets/search` must accept a JSON version of `SearchCallSetsRequest`
     * as the post body and will return a JSON version of `SearchCallSetsResponse`.
     *
     * @param request
     */
    @Override
    public SearchCallSetsResponse searchCallSets(SearchCallSetsRequest request) throws AvroRemoteException, GAException {
        return null;
    }

    /**
     * Gets a `CallSet` by ID.
     * `GET /callsets/{id}` will return a JSON version of `CallSet`.
     *
     * @param id
     */
    @Override
    public CallSet getCallSet(String id) throws AvroRemoteException, GAException {
        return null;
    }

    /**
     * Gets a list of `Call` matching the search criteria.
     * `POST /calls/search` must accept a JSON version of
     * `SearchCallsRequest` as the post body and will return a JSON version of
     * `SearchCallsResponse`.
     *
     * @param request
     */
    @Override
    public SearchCallsResponse searchCalls(SearchCallsRequest request) throws AvroRemoteException, GAException {
        return null;
    }

    /**
     * Gets a list of `AlleleCall` matching the search criteria.
     * `POST /allelecalls/search` must accept a JSON version of
     * `SearchAlleleCallsRequest` as the post body and will return a JSON version of
     * `SearchAlleleCallsResponse`.
     *
     * @param request
     */
    @Override
    public SearchAlleleCallsResponse searchAlleleCalls(SearchAlleleCallsRequest request) throws AvroRemoteException, GAException {
        return null;
    }
}
