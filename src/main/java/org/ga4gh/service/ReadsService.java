package org.ga4gh.service;

import org.apache.avro.AvroRemoteException;
import org.ga4gh.methods.*;
import org.ga4gh.models.Dataset;
import org.ga4gh.models.ReadGroup;
import org.ga4gh.models.ReadGroupSet;

/**
 * Created by Wayne Stidolph on 5/21/2015.
 */
public class ReadsService implements org.ga4gh.methods.ReadMethods {
    /**
     * Gets a list of `ReadAlignment` matching the search criteria.
     * <p>
     * `POST /reads/search` must accept a JSON version of `SearchReadsRequest` as
     * the post body and will return a JSON version of `SearchReadsResponse`.
     *
     * @param request
     */
    @Override
    public SearchReadsResponse searchReads(SearchReadsRequest request) throws AvroRemoteException, GAException {
        return null;
    }

    /**
     * Gets a list of `ReadGroupSet` matching the search criteria.
     * <p>
     * `POST /readgroupsets/search` must accept a JSON version of
     * `SearchReadGroupSetsRequest` as the post body and will return a JSON
     * version of `SearchReadGroupSetsResponse`.
     *
     * @param request
     */
    @Override
    public SearchReadGroupSetsResponse searchReadGroupSets(SearchReadGroupSetsRequest request) throws AvroRemoteException, GAException {
        return null;
    }

    /**
     * Gets a `org.ga4gh.models.ReadGroupSet` by ID.
     * `GET /readgroupsets/{id}` will return a JSON version of `ReadGroupSet`.
     *
     * @param id
     */
    @Override
    public ReadGroupSet getReadGroupSet(CharSequence id) throws AvroRemoteException, GAException {
        return null;
    }

    /**
     * Gets a `org.ga4gh.models.ReadGroup` by ID.
     * `GET /readgroups/{id}` will return a JSON version of `ReadGroup`.
     *
     * @param id
     */
    @Override
    public ReadGroup getReadGroup(CharSequence id) throws AvroRemoteException, GAException {
        return null;
    }

    /**
     * Gets a list of datasets accessible through the API.
     * <p>
     * TODO: Reads and variants both want to have datasets. Are they the same object?
     * <p>
     * `POST /datasets/search` must accept a JSON version of
     * `SearchDatasetsRequest` as the post body and will return a JSON version
     * of `SearchDatasetsResponse`.
     *
     * @param request
     */
    @Override
    public SearchDatasetsResponse searchDatasets(SearchDatasetsRequest request) throws AvroRemoteException, GAException {
        return null;
    }

    /**
     * Gets a `Dataset` by ID.
     * `GET /datasets/{id}` will return a JSON version of `Dataset`.
     *
     * @param id
     */
    @Override
    public Dataset getDataset(CharSequence id) throws AvroRemoteException, GAException {
        return null;
    }
}
