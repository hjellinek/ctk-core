package org.ga4gh.ctk.api.reads;

import com.google.common.collect.Table;
import junitparams.JUnitParamsRunner;
import org.ga4gh.*;
import org.ga4gh.ctk.control.testcategories.API.ReadsTests;
import org.ga4gh.ctk.transport.ReadsProtocolClient;
import org.ga4gh.ctk.transport.avrojson.AvroJson;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;

import java.net.InetSocketAddress;

import static org.assertj.core.api.Assertions.*;
import static org.slf4j.LoggerFactory.getLogger;

/**
 * <p>Verifies basic sanity of the reads/search API.</p>
 * <p>The {@code READS} API methods (as defined by the {@code readmethods.avdl}) are:</p>
 * <ul>
 *     <li>POST reads/search of GASearchReadsRequest yields GASearchReadsResponse</li>
 *     <li>POST /readgroupsets/search of GASearchReadGroupSetsRequest yields GASearchReadGroupSetsResponse</li>
 * </ul>
 *
 * <p>The test invokes a search request with null, default, and error parameters
 * on the endpoint and verifies the response. For tests with more insight into
 * the data returned (complex queries, etc) refer to the ReadsSearchingIT tests.</p>
 *
 * <p>As a demo, we show making an assertion about a field of the return (in {@code defaultReadsRequestGetsNullAlignments})
 * and simply making an assertion about the return itself (in {@code defaultReadgroupsetsRequestGetsResponse}). In each case,
 * the impartant element of the test is that the Response cam back and was
 * parsed without Exception.</p>
 *
 * <p>Created by wstidolph on 5/20/15.</p>
 */
@Category(ReadsTests.class)
@RunWith(JUnitParamsRunner.class)
public class ReadMethodsIT {

    private static org.slf4j.Logger log = getLogger(ReadMethodsIT.class);

    private static ReadsProtocolClient client;

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
        assertThat(grtn.getAlignments()).isNull();
    }


    @Test
    public void defaultReadgroupsetsRequestGetsResponse() throws Exception {
        GASearchReadGroupSetsRequest gsrgs = GASearchReadGroupSetsRequest.newBuilder()
                .build();
        GASearchReadGroupSetsResponse grtn = client.searchReadGroupSets(gsrgs);

        GASearchReadGroupSetsResponseAssert.assertThat(grtn).isNotNull();
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
