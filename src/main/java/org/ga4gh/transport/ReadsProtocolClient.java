package org.ga4gh.transport;

import org.apache.avro.AvroRemoteException;
import org.apache.avro.ipc.HttpTransceiver;
import org.apache.avro.ipc.Transceiver;
import org.apache.avro.ipc.specific.SpecificRequestor;
import org.ga4gh.methods.*;
import org.ga4gh.models.Dataset;
import org.ga4gh.models.ReadGroup;
import org.ga4gh.models.ReadGroupSet;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.URL;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * Created by Wayne Stidolph on 5/21/2015.
 */
public class ReadsProtocolClient implements org.ga4gh.methods.ReadMethods {

    private org.slf4j.Logger log = getLogger(ReadsProtocolClient.class);

    private InetSocketAddress endpointAddress;

    private Transceiver transceiver; // comms channel

    private ReadMethods protocolProxy; // actually talks to Server

    public String urlRoot = "http://192.168.2.115:8000/v0.5.1/"; // public for test code access clarity



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
     */
    @Override
    public SearchReadGroupSetsResponse searchReadGroupSets(SearchReadGroupSetsRequest request) throws AvroRemoteException, GAException {
        SearchReadGroupSetsResponse response = new SearchReadGroupSetsResponse();
        return AvroJson.avroReqRespJson(request, response,urlRoot, "readgroupsets/search" );
    }

    /**
     * Gets a `org.ga4gh.models.ReadGroupSet` by ID.
     * `GET /readgroupsets/{id}` will return a JSON version of `ReadGroupSet`.
     *
     * @param id
     */
    @Override
    public ReadGroupSet getReadGroupSet(String id) throws AvroRemoteException, GAException {
        return null;
    }

    /**
     * Gets a `org.ga4gh.models.ReadGroup` by ID.
     * `GET /readgroups/{id}` will return a JSON version of `ReadGroup`.
     *
     * @param id
     */
    @Override
    public ReadGroup getReadGroup(String id) throws AvroRemoteException, GAException {
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

        return protocolProxy.searchDatasets(request);
    }

    /**
     * Gets a `Dataset` by ID.
     * `GET /datasets/{id}` will return a JSON version of `Dataset`.
     *
     * @param id
     */
    @Override
    public Dataset getDataset(String id) throws AvroRemoteException, GAException {
        return null;
    }

    // support
    public ReadsProtocolClient(InetSocketAddress endpointAddress) {
        this.endpointAddress = endpointAddress;
    }

    public synchronized void start() throws IOException {
        if (log.isInfoEnabled()) {
            log.info("Starting Simple Reads client on '{}'", endpointAddress);
        }
        // transceiver = new HttpTransceiver(new URL("http://127.0.0.1:8000/v0.5.1")); // comms channel
        transceiver = new HttpTransceiver(new URL("http://192.168.2.115:8000/v0.5.1")); // comms channel
        protocolProxy = SpecificRequestor.getClient(ReadMethods.class, transceiver);

    }

    public void stop() throws IOException {
        if (log.isInfoEnabled()) {
            log.info("Stopping Simple Reads client on '{}'", endpointAddress);
        }
        if (transceiver != null && transceiver.isConnected()) {
            transceiver.close();
        }
    }
}
