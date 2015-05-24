package org.ga4gh.models;

import junitparams.JUnitParamsRunner;
import org.ga4gh.methods.SearchReadGroupSetsRequest;
import org.ga4gh.methods.SearchReadGroupSetsResponse;
import org.ga4gh.transport.ReadsProtocolClient;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.net.InetSocketAddress;
import java.util.Arrays;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * Created by wstidolph on 5/20/15.
 */
@RunWith(JUnitParamsRunner.class)
public class ReadsTest {

    private org.slf4j.Logger log = getLogger(ReadsTest.class);
/*
ReadGroupSet >--< ReadGroup --< fragment --< read --< alignment --< linear/graph alignment
 */
    // private static SimpleOrderServiceEndpoint service; // use real server
    private static ReadsProtocolClient client;


    @Test
    public void searchReadGroupSets() throws Exception {
        log.info("testing searchReadGroupSets");

        // but Builder does validation and sets defaults, so that's better
        // this is based on  the example from the demo writeup:
        // curl --data '{"datasetIds":[], "name":null}' --header 'Content-Type: application/json' \
        //       http://localhost:8000/v0.5.1/readgroupsets/search
        SearchReadGroupSetsRequest reqb = SearchReadGroupSetsRequest.newBuilder()
                .setName(null)
                .setDatasetIds(Arrays.asList())
                .build();

        log.info("generating: " + reqb.toString());
        SearchReadGroupSetsResponse rtnVal = client.searchReadGroupSets(reqb);
        // make asserts about the rtnVal
        org.ga4gh.methods.SearchReadGroupSetsResponseAssert.assertThat(rtnVal).isNotNull();
        log.info(rtnVal.toString());
    }

    @BeforeClass
    public static void setupTransport() throws Exception {
        InetSocketAddress endpointAddress = new InetSocketAddress("127.0.0.1", 8000);
        // service = new SimpleOrderServiceEndpoint(endpointAddress);
        client = new ReadsProtocolClient(endpointAddress);

        // service.start();
        client.start();
    }

    @AfterClass
    public static void shutdownTransport() throws Exception {
        client.stop();
        // service.stop();
    }
}
