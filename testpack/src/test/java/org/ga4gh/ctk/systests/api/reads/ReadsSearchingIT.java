package org.ga4gh.ctk.systests.api.reads;

import com.google.common.collect.Table;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.ga4gh.GAReadAlignment;
import org.ga4gh.GASearchReadsRequest;
import org.ga4gh.GASearchReadsResponse;
import org.ga4gh.ctk.control.testcategories.API.ReadsTests;
import org.ga4gh.ctk.transport.avrojson.AvroJson;
import org.ga4gh.ctk.transport.protocols.ReadsProtocolClient;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;

import java.net.InetSocketAddress;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;
import static org.slf4j.LoggerFactory.getLogger;

/**
 * <p>Verify data returned from reads/search queries
 * meet expectations.</p>
 * <p>
 * <p>Created by Wayne Stidolph on 6/7/2015.</p>
 */
@Category(ReadsTests.class)
@RunWith(JUnitParamsRunner.class)
public class ReadsSearchingIT {
    private static org.slf4j.Logger log = getLogger(ReadsSearchingIT.class);

    private static ReadsProtocolClient client;


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

    /*
    If a reference is specified, all queried `GAReadGroup`s must be aligned
    to `GAReferenceSet`s containing that same `GAReference`. If no reference is
    specified, all `GAReadGroup`s must be aligned to the same `GAReferenceSet`.
     */

    /**
    In any ReadsTests response, the alignedSequence field can only contain [ACTGN]+.
    No spaces, no other letters, no lowercase, no null. This is dataset specific
    at this point, but we might be able to extend it to all datasets later - Jeltje email
     @param rgid the readgroup ID passed from Parameters
    */
    @Test
    @Parameters({
            "low-coverage:HG00533.mapped.ILLUMINA.bwa.CHS.low_coverage.20120522"
    })
    public void readsResponseMatchesACTGNPattern(String rgid) throws Exception {
        // do a readsearch
        GASearchReadsRequest gsrr = GASearchReadsRequest.newBuilder()
                .setReadGroupIds(Arrays.asList(rgid))
                .build();
        GASearchReadsResponse grtn = client.searchReads(gsrr);
        // GASearchReadsResponse
        //    array<GAReadAlignment> alignments = [];
        //       GAReadAlignement field alignedSequence is null || string

        for (GAReadAlignment gar : grtn.getAlignments()) {
            assertThat(gar.getAlignedSequence()).isNotNull()
                    .matches("[ACTGN]+");
        }
    }
}
