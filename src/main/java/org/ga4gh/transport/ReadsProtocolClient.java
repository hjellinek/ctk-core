package org.ga4gh.transport;

import org.apache.avro.AvroRemoteException;
import org.apache.avro.Schema;
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

    public String urlRoot = URLMAPPING.urlRoot; //"http://192.168.2.115:8000/v0.5.1/"; // public for test code access clarity

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
        String path = URLMAPPING.searchReads;
        SearchReadsResponse response = new SearchReadsResponse();
        AvroJson aj =
                new AvroJson<>(request, response, urlRoot, path );
        response = (SearchReadsResponse) aj.doPostResp();
        return response;
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
        String path = URLMAPPING.searchReadGroupSets;
        // we use an empty concrete response class to pass into the Parameterized AvroJson
        // as a quickway to get the class name and such; this bject actually gets replaced
        // with the filled-in Repsonse object constructed in AvroJson and passed back
        SearchReadGroupSetsResponse response = new SearchReadGroupSetsResponse();
        AvroJson aj =
            new AvroJson<>(request, response, urlRoot, path );
        aj.setAvroDeserializer(AvroJson.DESER_MODE.JACKSON_RELAXED); // optional, JACKSON_RELAXED is default
        response = (SearchReadGroupSetsResponse) aj.doPostResp();

        return response;
    }

    /**
     * Gets a `org.ga4gh.models.ReadGroupSet` by ID.
     * `GET /readgroupsets/{id}` will return a JSON version of `ReadGroupSet`.
     *
     * @param id
     */
    @Override
    public ReadGroupSet getReadGroupSet(String id) throws AvroRemoteException, GAException {
        String path = URLMAPPING.getReadGroupSet;
        ReadGroupSet response = new ReadGroupSet();
        ReadGroupSetsRequest request = new ReadGroupSetsRequest(); // a dummy, for reusing the POST-oriented AJ class
        AvroJson aj =
                new AvroJson<>(request, response, urlRoot, path );
        response = (ReadGroupSet) aj.doGetResp(id);

        return response;
    }


    /**
     * Gets a `org.ga4gh.models.ReadGroup` by ID.
     * `GET /readgroups/{id}` will return a JSON version of `ReadGroup`.
     *
     * @param id
     */
    @Override
    public ReadGroup getReadGroup(String id) throws AvroRemoteException, GAException {
        String path = URLMAPPING.getReadGroup;
        ReadGroup response = new ReadGroup();
        ReadGroupRequest dummyRequest = new ReadGroupRequest(); // a dummy, for reusing the POST-oriented AJ class
        AvroJson aj =
                new AvroJson<>(dummyRequest, response, urlRoot, path );
        response = (ReadGroup) aj.doGetResp(id);
        return response;
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
        String path = URLMAPPING.searchDatasets;
        SearchDatasetsResponse response = new SearchDatasetsResponse();

        AvroJson aj =
                new AvroJson<>(request, response, urlRoot, path );
        response = (SearchDatasetsResponse) aj.doPostResp();

        return response;
    }

    /**
     * Gets a `Dataset` by ID.
     * `GET /datasets/{id}` will return a JSON version of `Dataset`.
     *
     * @param id
     */
    @Override
    public Dataset getDataset(String id) throws AvroRemoteException, GAException {
        String path = URLMAPPING.getDataset;
        Dataset response = new Dataset();
        DatasetRequest dummyRequest = new DatasetRequest();

        AvroJson aj =
                new AvroJson<>(dummyRequest, response,urlRoot, path);
        response = (Dataset) aj.doGetResp(id);

        return response;
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

class DummyRequest implements org.apache.avro.generic.GenericContainer {

    /**
     * The schema of this instance.
     */
    @Override
    public Schema getSchema() {
        return null;
    }
}
class ReadGroupRequest extends DummyRequest{};
class ReadGroupSetsRequest extends DummyRequest{};
class DatasetRequest extends DummyRequest{}
