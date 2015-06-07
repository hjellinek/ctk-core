package org.ga4gh.ctk.sut;

import com.google.common.collect.Table;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.ga4gh.*;
import org.ga4gh.ctk.transport.ReadsProtocolClient;
import org.ga4gh.ctk.transport.avrojson.AvroJson;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.net.InetSocketAddress;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.slf4j.LoggerFactory.getLogger;

/**
 * Created by wstidolph on 5/20/15.
 */
@RunWith(JUnitParamsRunner.class)
public class ReadMethodsIT {

    private static org.slf4j.Logger log = getLogger(ReadMethodsIT.class);

    private static ReadsProtocolClient client;


    // commenting out @Test because the Runner seems to be ignoring @Ignore!
    @Ignore("datasetId not supported in v0.5.1 server")
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
            "low-coverage:HG00533.mapped.ILLUMINA.bwa.CHS.low_coverage.20120522" ,
            "low-coverage:HG00096.mapped.ILLUMINA.bwa.GBR.low_coverage.20120522",
            "low-coverage:HG00534.mapped.ILLUMINA.bwa.CHS.low_coverage.20120522"
    })
    public void goodReadgroupNameShouldRetrieveMatchingReadGroupSet(String rgName) throws Exception {
        // IDL: "Only return read group sets for which a substring of the name
        // matches this string.
        log.info("");
        GASearchReadGroupSetsRequest reqb = GASearchReadGroupSetsRequest.newBuilder()
                .setName(rgName)
                .build();

        log.info("SearchReadGroupSetsRequest: " + reqb.toString());
        GASearchReadGroupSetsResponse rtnVal = client.searchReadGroupSets(reqb);
        log.info("searchReadGroupSets " + rgName + " returned: " + String.valueOf(rtnVal));

        List<GAReadGroupSet> rgs = rtnVal.getReadGroupSets();

        //org.ga4gh.GASearchReadGroupSetsResponset(rtnVal).hasName("low-coverage");

                /*
                rgs.get(0))

                .isNotNull()
                .hasName(rgName);
                */
    }
    /*
    In any Reads response, the alignedSequence field can only contain [ACTGN]+.
    No spaces, no other letters, no lowercase, no null. This is dataset specific
    at this point, but we might be able to extend it to all datasets later
     */

    /*
    If a reference is specified, all queried `GAReadGroup`s must be aligned
    to `GAReferenceSet`s containing that same `GAReference`. If no reference is
    specified, all `GAReadGroup`s must be aligned to the same `GAReferenceSet`.
     */
    @Test
    public void readsResponseMatchesACTGNPattern() throws Exception {
        // do a readsearch
        GASearchReadsRequest gsrr = GASearchReadsRequest.newBuilder()
                .build();
        GASearchReadsResponse grtn = client.searchReads(gsrr);
        log.info("send SearchReadsRequest <" + gsrr.toString() + "> RTN is < "+ grtn );

/*
        assertThat(grtn.getAlignments())
                .extracting("alignedSequence")
                .matches("[ACTGN]+");
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
