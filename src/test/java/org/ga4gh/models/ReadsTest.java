package org.ga4gh.models;

import junitparams.JUnitParamsRunner;
import org.ga4gh.methods.SearchReadsRequest;
import org.ga4gh.methods.SearchReadsResponse;
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
    public void searchReads() throws Exception {
        log.info("starting searchReads");

        /*
        // ctor approach is best performance ...
        List<CharSequence> readGroupIds = Arrays.asList("foo");
        String referenceId = "bar";
        Long start = 0L;
        Long end = 5L;
        Integer pageSize = 10;
        String pageToken = "";
        SearchReadsRequest req = new SearchReadsRequest(readGroupIds, referenceId,start,end,pageSize,pageToken);
*/
        // but Builder does validation and sets defaults, so that's better
        SearchReadsRequest reqb = SearchReadsRequest.newBuilder()
                .setReadGroupIds(Arrays.asList("foo"))
                .setReferenceId("bar")
                .build();

        SearchReadsResponse rtnVal = client.searchReads(reqb);
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
