package org.ga4gh.cts.api.reads;

import junitparams.*;
import org.ga4gh.*;
import org.ga4gh.ctk.transport.protocols.*;
import org.junit.*;
import org.junit.experimental.categories.*;
import org.junit.runner.*;

import java.net.*;
import java.util.*;

import static org.slf4j.LoggerFactory.*;

/**
 * <p>Validates data returned by readgroupsets/search.</p>
 * <p>Created by Wayne Stidolph on 6/7/2015.</p>
 */
@Category(ReadsTests.class)
@RunWith(JUnitParamsRunner.class)
public class ReadGroupSetsSearchIT {
    private static org.slf4j.Logger log = getLogger(ReadGroupSetsSearchIT.class);

    private static ReadsProtocolClient client;

    /**
     * <p>Good readgroup sets name should retrieve only matching read group sets.</p>
     * <p>IDL says a GASearchReadGroupSetsRequest should match based on a substring:</p>
     * <cite>"Only return read group sets for which a substring of the name matches this string.</cite>
     * <p>This test accepts a key, looks up the long readgroup name for a static map,
     * extracts a substring from that valid name, and uses the subsctring in a search then verifies that
     * all the returned ReadGroupSets match the substring.</p>
     *
     * @param rgName the rg name key
     * @throws Exception the exception
     */
    @Ignore("ReadGroupSets not yet supported, and returned 'name' is null")
    @Test
    @Parameters({ // key iinto the 'stringmap' variable
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

    /**
     * <p>Readgroup set response for a dumb datasetid should be empty.</p>
     *
     * <p>Pass in a syntactically valid but non-matching datasetID to a GASearchReadGroupSetsRequest
     * expect a valid GASearchReadGroupSetsResponse with no ReadGroupSets in it.</p>
     *
     * @throws Exception the exception
     */
/* ****************************************** */
    // DATASETID tests
    /* ****************************************** */
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
     * <p>Bad datasetID should return errors.</p>
     * <p>This test verifies the Server returns an expected error (NOT_FOUND)
     * for a syntactically valid but unused dataset ID</p>
     * <p>Test using an empty String, and an unused String</p>
     *
     *
     * @param datasetid the datasetid (actually, a key to the static 'stringmap')
     * @throws Exception possible exception, keep compiler happy
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
