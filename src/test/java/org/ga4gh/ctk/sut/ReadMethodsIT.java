package org.ga4gh.ctk.sut;

import com.google.common.collect.Table;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.ga4gh.GASearchReadGroupSetsRequest;
import org.ga4gh.GASearchReadGroupSetsResponse;
import org.ga4gh.ctk.transport.AvroJson;
import org.ga4gh.ctk.transport.ReadsProtocolClient;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.net.InetSocketAddress;
import java.util.Arrays;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.slf4j.LoggerFactory.getLogger;

/**
 * Created by wstidolph on 5/20/15.
 */
@RunWith(JUnitParamsRunner.class)
public class ReadMethodsIT {

    private static org.slf4j.Logger log = getLogger(ReadMethodsIT.class);

    private static ReadsProtocolClient client;


    @Test
    @Parameters({
            "",
            "foo",
            "1kg-phase1",
            "1kg-phase3",
            "1kg-phase1:1kg-phase3"
    })
    public void searchReadGroupSets(String datasetid) throws Exception {
        log.info("testing searchReadGroupSets");

        // but Builder does validation and sets defaults, so that's better
        // this is based on  the example from the demo writeup:
        // curl --data '{"datasetIds":[], "name":null}' --header 'Content-Type: application/json' \
        //       http://localhost:8000/v0.5.1/readgroupsets/search
        GASearchReadGroupSetsRequest reqb = GASearchReadGroupSetsRequest.newBuilder()
                .setName(null)
                .setDatasetIds(Arrays.asList(datasetid.split(":")))
                .build();

        log.info("generating SearchReadGroupSetsRequest: " + reqb.toString());
        GASearchReadGroupSetsResponse rtnVal = client.searchReadGroupSets(reqb);

        org.ga4gh.GASearchReadGroupSetsResponseAssert.assertThat(rtnVal).isNotNull();
        log.info("searchReadGroupSets " + datasetid+" returned: " + String.valueOf(rtnVal));

        assertNotNull("should get a not-null SearchReadGroupSetsResponse", rtnVal);
        org.ga4gh.GASearchReadGroupSetsResponseAssert.assertThat(rtnVal)
                .hasSchema(GASearchReadGroupSetsResponse.SCHEMA$);
        //ReadGroupSetAssert.assertThat(rtnVal.getReadGroupSets().get(0)).hasReadGroups()
    }

    @Test
    public static void dippyTest() throws Exception{
        assertTrue(true);
    }

    @BeforeClass
    public static void setupTransport() throws Exception {
        InetSocketAddress endpointAddress = new InetSocketAddress("127.0.0.1", 8000);
        // service = new SimpleOrderServiceEndpoint(endpointAddress);
        client = new ReadsProtocolClient();

        //client.start(); start binary transceiver to Server Under Test
    }

    @AfterClass
    public static void shutdownTransport() throws Exception {
        for(Table.Cell<String, String, Integer> cell : AvroJson.getMessages().cellSet()){
            log.info("TRAFFIC " + cell.getRowKey() + " " + cell.getColumnKey() + " " +cell.getValue());
        }
    }
}
