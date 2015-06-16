package org.ga4gh.ctk.systests.api.reads;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.ga4gh.GAReadGroupSet;
import org.ga4gh.GASearchReadGroupSetsRequest;
import org.ga4gh.GASearchReadGroupSetsResponse;
import org.ga4gh.GASearchReadGroupSetsResponseAssert;
import org.ga4gh.ctk.control.testcategories.API.ReadsTests;
import org.ga4gh.ctk.transport.protocols.ReadsProtocolClient;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;

import java.net.InetSocketAddress;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * <p>Validates data returned by readgroupsets/search.</p>
 * <p>Created by Wayne Stidolph on 6/7/2015.</p>
 */
@Category(ReadsTests.class)
@RunWith(JUnitParamsRunner.class)
public class ReadGroupSetsSearchIT {
    private static org.slf4j.Logger log = getLogger(ReadGroupSetsSearchIT.class);

    private static ReadsProtocolClient client;

    @Ignore("ReadGroupSets not yet supported, and returned 'name' is null")
    @Test
    @Parameters({
            "LO_COV_533_CHS",
            "LO_COV_096_GBR",
            "LO_COV_534_CHS"
    })
    public void goodReadgroupSetsNameShouldRetrieveOnlyMatchingReadGroupSets(String rgName) throws Exception {
        // IDL: "Only return read group sets for which a substring of the name
        // matches this string.

        String replacedRgName = stringmap.get(rgName);
        // build a substring of the input name
        String substr = replacedRgName.substring(3, 9);
        GASearchReadGroupSetsRequest reqb = GASearchReadGroupSetsRequest.newBuilder()
                .setName(substr)
                .build();

        log.debug("SearchReadGroupSetsRequest: " + reqb.toString());
        GASearchReadGroupSetsResponse rtnVal = client.searchReadGroupSets(reqb);
        log.debug("searchReadGroupSets " + rgName + " returned: " + String.valueOf(rtnVal));

        for (GAReadGroupSet rgs : rtnVal.getReadGroupSets()) {
                org.assertj.core.api.Assertions.assertThat(rgs.getName())
                        .matches(".*"+substr+".*");
        }
    }


    /* ****************************************** */
    // DATASETID tests
    /* ****************************************** */
    // commenting out @Test because the Runner seems to be ignoring @Ignore!
    @Ignore("datasetId not yet supported in v0.5.1 server")
    @Test
    public void readgroupSetResponseForDumbDatasetidShouldBeEmpty() throws Exception {
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



    /**
     * <p>Bad readgroup id should return errors.</p>
     * <p>This test verifies the Server returns an expected error (NOT_FOUND)
     * for a syntactically valid but unused dataset ID</p>
     * <p>Test using an empty String, and an unused String</p>
     *
     *
     * @param datasetid the datasetid
     * @throws Exception the exception
     */
    @Ignore("datasetId not supported in v0.5.1 server")
    @Test
    @Parameters({
            "EMPTY",
            "foo"
    })
    public void badDatasetidInSearchReadGroupSetsRequestShouldReturnErrors(String datasetid) throws Exception {
        log.info("testing searchReadGroupSets");

        //  Builder does validation and sets defaults
        // this is based on  the example from the demo writeup:
        // curl --data '{"datasetIds":[], "name":null}' --header 'Content-Type: application/json' \
        //       http://localhost:8000/v0.5.1/readgroupsets/search
        String replacedDatasetid = stringmap.get(datasetid);
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

    private static Map<String, String> stringmap;
    static {
        stringmap = new HashMap<>();
        stringmap.put("EMPTY", "");
        stringmap.put("foo", "foo");
        stringmap.put("LO_COV_533_CHS","low-coverage:HG00533.mapped.ILLUMINA.bwa.CHS.low_coverage.20120522");
        stringmap.put("LO_COV_096_GBR","low-coverage:HG00096.mapped.ILLUMINA.bwa.GBR.low_coverage.20120522");
        stringmap.put("LO_COV_534_CHS","low-coverage:HG00534.mapped.ILLUMINA.bwa.CHS.low_coverage.20120522");
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

    }
}
