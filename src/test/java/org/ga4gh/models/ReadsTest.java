package org.ga4gh.models;

import junitparams.JUnitParamsRunner;
import org.ga4gh.transport.ReadsProtocolClient;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.net.InetSocketAddress;

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
    public void verifyDataSets() throws Exception {
        log.info("starting verifyDataSets");
        Dataset rtnVal = client.getDataset("hi");
        log.info(rtnVal.toString());
    }

    @BeforeClass
    public static void setupTransport() throws Exception {
        InetSocketAddress endpointAddress = new InetSocketAddress("192.168.2.115", 8000);
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
