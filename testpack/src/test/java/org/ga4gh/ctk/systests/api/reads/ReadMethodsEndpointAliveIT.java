package org.ga4gh.ctk.systests.api.reads;

import com.google.common.collect.Table;
import junitparams.Parameters;
import org.assertj.core.api.JUnitSoftAssertions;
import org.ga4gh.*;
import org.ga4gh.ctk.control.testcategories.API.ReadsTests;
import org.ga4gh.ctk.transport.RespCode;
import org.ga4gh.ctk.transport.WireTracker;
import org.ga4gh.ctk.transport.WireTrackerAssert;
import org.ga4gh.ctk.transport.avrojson.AvroJson;
import org.ga4gh.ctk.transport.protocols.ReadsProtocolClient;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import java.net.InetSocketAddress;
import java.util.Arrays;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * <p>Verifies basic sanity of the reads/search API.</p>
 * <p>The {@code READS} API methods (as defined by the {@code readmethods.avdl}) are:</p>
 * <ul>
 * <li>POST reads/search of GASearchReadsRequest yields GASearchReadsResponse</li>
 * <li>POST /readgroupsets/search of GASearchReadGroupSetsRequest yields GASearchReadGroupSetsResponse</li>
 * </ul>
 *
 * <p>The test invokes a search request with null, default, and error parameters
 * on the endpoint and verifies the response. For tests with more insight into
 * the data returned (complex queries, etc) refer to the ReadsSearchIT tests.</p>
 *
 * <p>Note this is RunWith the default JUnit runner, which means we can (and do) use
 * a JUnit4 @Rule to set up a JUnitSoftAssertions, which lets us make multiple
 * asserts and have them all automatically checked and group-reported at the end of each test.</p>
 *
 * <p>As a demo, we show making an assertion about a field of the return (in {@code defaultReadsRequestGetsNullAlignments})
 * and simply making an assertion about the return itself (in {@code defaultReadgroupsetsRequestGetsResponse}). In each case,
 * the impartant element of the test is that the Response cam back and was
 * parsed without Exception.</p>
 *
 * <p>Created by wstidolph on 5/20/15.</p>
 */
@Category(ReadsTests.class)
public class ReadMethodsEndpointAliveIT {

    private static org.slf4j.Logger log = getLogger(ReadMethodsEndpointAliveIT.class);

    private static ReadsProtocolClient client;

    @Rule
    public final JUnitSoftAssertions softly = new JUnitSoftAssertions();

    /**
     * <p>Show that a GASearchReadsRequest is accepted and
     * returns a parseable Response.</p>
     *
     * @throws Exception the exception
     */
    @Test
    public void defaultReadsRequestGetsNullAlignments() throws Exception {
        // do a readsearch
        GASearchReadsRequest gsrr = GASearchReadsRequest.newBuilder()
                .build();
        GASearchReadsResponse grtn = client.searchReads(gsrr);
        org.junit.Assert.assertNull(grtn.getAlignments());
    }


    @Test
    public void defaultReadgroupsetsRequestGetsResponse() throws Exception {
        GASearchReadGroupSetsRequest gsrgs = GASearchReadGroupSetsRequest.newBuilder()
                .build();
        GASearchReadGroupSetsResponse grtn = client.searchReadGroupSets(gsrgs);

        GASearchReadGroupSetsResponseAssert.assertThat(grtn).isNotNull();
    }

    @Test
    @Parameters({
            "myNonsenseId", "foo", ""
    })
    public void unmatchedReadgroupidElicitsErrorMsg(String rgid) throws Exception {
        GASearchReadsRequest gsrr = GASearchReadsRequest.newBuilder()
                .setReadGroupIds(Arrays.asList(rgid))
                .build();
        WireTracker mywt = new WireTracker();
        GASearchReadsResponse grtn = client.searchReads(gsrr, mywt);

        WireTrackerAssert.assertThat(mywt)
                .hasResponseStatus(RespCode.NOT_FOUND);
        // getting the GAE will verify the response is parseable and fits the schema
        // but we don't yet care what the actual error message or code is
        // yes, it's bad test-fu to have multiple assert statements,
        // but I'm more tolerant of that in higher-level tests than in unit-level
        GAExceptionAssert.assertThat(mywt.getGae()).isNotNull();
    }

    @Test
    @Parameters({
            "\"\", NOT_FOUND",
            "low-coverage:HG00534;low-coverage:HG00533, NOT_IMPLEMENTED"
    })
    public void multipleReadGroupsNotSupported(String rgid, RespCode expStatus) throws Exception {
        GASearchReadsRequest gsrr = GASearchReadsRequest.newBuilder()
                .setReadGroupIds(Arrays.asList(rgid.split(";")))
                .build();
        WireTracker mywt = new WireTracker();
        GASearchReadsResponse grtn = client.searchReads(gsrr, mywt);
        WireTrackerAssert.assertThat(mywt)
                .hasResponseStatus(expStatus);
        GAExceptionAssert.assertThat(mywt.getGae()).isNotNull();
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
        for (Table.Cell<String, String, Integer> cell : AvroJson.getMessages().cellSet()) {
            log.info("ReadMethodIT TRAFFIC:" + cell.getRowKey() + " " + cell.getColumnKey() + " " + cell.getValue());
        }
    }

}
