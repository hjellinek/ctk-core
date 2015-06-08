package org.ga4gh.ctk.sut.reads;

import com.google.common.collect.Table;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.ga4gh.*;
import org.ga4gh.ctk.control.testcategories.API.ReadsTests;
import org.ga4gh.ctk.transport.ReadsProtocolClient;
import org.ga4gh.ctk.transport.avrojson.AvroJson;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;

import java.net.InetSocketAddress;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.slf4j.LoggerFactory.getLogger;

/**
 * <p>This test class verifies basic sanity of the reads/search API.</p>
 *
 * <p>The test invokes a search request with null, default, and error parameters
 * on the endpoint and verifies the response. For tests with more insight into
 * the data returned (complex queries, etc) refer to the ReadsSearchingIT tests.</p>
 *
 * <p>The {@code READS} API (as defined by the readmethods.avdl) exchanges messages:</p>
 * <ul>
 *     <li>POST reads/search of GASearchReadsRequest yields GASearchReadsResponse</li>
 *     <li>POST /readgroupsets/search of GASearchReadGroupSetsRequest yields GASearchReadGroupSetsResponse</li>
 * </ul>
 * <p>Created by wstidolph on 5/20/15.</p>
 */
@Category(ReadsTests.class)
@RunWith(JUnitParamsRunner.class)
public class ReadMethodsIT {

    private static org.slf4j.Logger log = getLogger(ReadMethodsIT.class);

    private static ReadsProtocolClient client;


    // commenting out @Test because the Runner seems to be ignoring @Ignore!
    @Ignore("datasetId not yet supported in v0.5.1 server")
    // @Test
    public void srgsForDumbDatasetidShouldBeEmpty() throws Exception {
        GASearchReadGroupSetsRequest reqb = GASearchReadGroupSetsRequest.newBuilder()
                .setName(null)
                .setDatasetIds(Arrays.asList("realyUnlikelyQQQ"))
                .build();
        GASearchReadGroupSetsResponse rtnVal = client.searchReadGroupSets(reqb);
        // avro says always get a 200
        GASearchReadGroupSetsResponseAssert.assertThat(rtnVal)
                .isNotNull()
                .hasNoReadGroupSets();
    }


    // commenting out @Test because the Runner seems to be ignoring @Ignore!
    @Ignore("datasetId not supported in v0.5.1 server")
    // @Test
    @Parameters({
            "",
            "foo"
    })
    public void badReadgroupIdShouldReturnErrors(String datasetid) throws Exception {
        log.info("testing searchReadGroupSets");

        //  Builder does validation and sets defaults
        // this is based on  the example from the demo writeup:
        // curl --data '{"datasetIds":[], "name":null}' --header 'Content-Type: application/json' \
        //       http://localhost:8000/v0.5.1/readgroupsets/search
        GASearchReadGroupSetsRequest reqb = GASearchReadGroupSetsRequest.newBuilder()
                .setName(null)
                .setDatasetIds(Arrays.asList(datasetid.split(":")))
                .build();

        log.debug("SearchReadGroupSetsRequest: " + reqb.toString());
        GASearchReadGroupSetsResponse rtnVal = client.searchReadGroupSets(reqb);
        log.debug("searchReadGroupSets " + datasetid + " returned: " + String.valueOf(rtnVal));
        GASearchReadGroupSetsResponseAssert.assertThat(rtnVal)
                .isNotNull();

        List<GAReadGroupSet> rgs = rtnVal.getReadGroupSets();

        org.ga4gh.GAReadGroupSetAssert.assertThat(rgs.get(0)).hasDatasetId(datasetid);
    }


    @Test
    @Parameters({
            "low-coverage:HG00533.mapped.ILLUMINA.bwa.CHS.low_coverage.20120522"
    })
    public void goodReadgroupsetsNameShouldRetrieveMatchingReadGroupSet(String rgName) throws Exception {
        // IDL: "Only return read group sets for which a substring of the name
        // matches this string.
        GASearchReadGroupSetsRequest reqb = GASearchReadGroupSetsRequest.newBuilder()
                .setName(rgName)
                .build();

        log.debug("SearchReadGroupSetsRequest: " + reqb.toString());
        GASearchReadGroupSetsResponse rtnVal = client.searchReadGroupSets(reqb);
        log.debug("searchReadGroupSets " + rgName + " returned: " + String.valueOf(rtnVal));

        List<GAReadGroupSet> rgs = rtnVal.getReadGroupSets();

        //org.ga4gh.GASearchReadGroupSetsResponset(rtnVal).hasName("low-coverage");

                /*
                rgs.get(0))

                .isNotNull()
                .hasName(rgName);
                */
    }


    @Test
    public void defaultReadsRequestGetsNullAlignments() throws Exception {
        // do a readsearch
        GASearchReadsRequest gsrr = GASearchReadsRequest.newBuilder()
                .build();
        GASearchReadsResponse grtn = client.searchReads(gsrr);
        assertThat(grtn.getAlignments()).isNull();
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
            log.info("ReadMethodIT TRAFFIC:" + cell.getRowKey() + " " + cell.getColumnKey() + " " +cell.getValue());
        }
    }

}
