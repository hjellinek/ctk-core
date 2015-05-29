package org.ga4gh.ctk.tests;

import com.google.common.collect.Table;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.ga4gh.methods.SearchDatasetsRequest;
import org.ga4gh.methods.SearchDatasetsResponse;
import org.ga4gh.methods.SearchReadGroupSetsRequest;
import org.ga4gh.methods.SearchReadGroupSetsResponse;
import org.ga4gh.models.ReadGroupSet;
import org.ga4gh.transport.AvroJson;
import org.ga4gh.transport.ReadsProtocolClient;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.net.InetSocketAddress;
import java.util.Arrays;

import static org.junit.Assert.assertNotNull;
import static org.slf4j.LoggerFactory.getLogger;

/**
 * Created by wstidolph on 5/20/15.
 */
@RunWith(JUnitParamsRunner.class)
public class ReadsTest {

    private static org.slf4j.Logger log = getLogger(ReadsTest.class);
    /*
    ReadGroupSet >--< ReadGroup --< fragment --< read --< alignment --< linear/graph alignment
     */
    // private static SimpleOrderServiceEndpoint service; // use real server
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
        SearchReadGroupSetsRequest reqb = SearchReadGroupSetsRequest.newBuilder()
                .setName(null)
                .setDatasetIds(Arrays.asList(datasetid.split(":")))
                .build();

        log.info("generating SearchReadGroupSetsRequest: " + reqb.toString());
        SearchReadGroupSetsResponse rtnVal = client.searchReadGroupSets(reqb);

        org.ga4gh.methods.SearchReadGroupSetsResponseAssert.assertThat(rtnVal).isNotNull();
        log.info("searchReadGroupSets " + datasetid+" returned: " + String.valueOf(rtnVal));

        assertNotNull("should get a not-null SearchReadGroupSetsResponse", rtnVal);
        org.ga4gh.methods.SearchReadGroupSetsResponseAssert.assertThat(rtnVal)
                .hasSchema(SearchReadGroupSetsResponse.SCHEMA$);
        //ReadGroupSetAssert.assertThat(rtnVal.getReadGroupSets().get(0)).hasReadGroups()
    }

    @Test
    @Parameters({
            "low-coverage:HG00533.mapped.ILLUMINA.bwa.CHS.low_coverage.20120522",
            "low-coverage:HG00096.mapped.ILLUMINA.bwa.GBR.low_coverage.20120522",
            "low-coverage:HG00534.mapped.ILLUMINA.bwa.CHS.low_coverage.20120522"
    })
    public void getReadGroupSet(String id) throws Exception {
        log.info("testing searchReadGroupSets");

        ReadGroupSet rgs = client.getReadGroupSet(id);
        log.info("getReadGroupSet(" + id + ") got " + String.valueOf(rgs));

        assertNotNull("should get a valid ReadGroupSet", rgs);

    }

    @Test
    public void checkDatasets() throws Exception {
        log.info("testing getDataSets");
        SearchDatasetsRequest sdrQ = SearchDatasetsRequest.newBuilder()
                // put params here, what are they?
                .build();
        SearchDatasetsResponse rtnVal = client.searchDatasets(sdrQ);
        assertNotNull("should get a not-null SearchDatasetsResponse", rtnVal);
        log.info(String.valueOf(rtnVal));
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
        for(Table.Cell<String, String, Integer> cell : AvroJson.getMessages().cellSet()){
            log.info("TRAFFIC " + cell.getRowKey() + " " + cell.getColumnKey() + " " +cell.getValue());
        }
        //log.info("total message traffic: "+ AvroJson.getMessages().toString());
        client.stop();

        // service.stop();
    }
}
