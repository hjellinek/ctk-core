package org.ga4gh.ctk.systests.api.variants;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.ga4gh.GASearchVariantsRequest;
import org.ga4gh.GASearchVariantsResponse;
import org.ga4gh.GASearchVariantsResponseAssert;
import org.ga4gh.ctk.control.testcategories.API.VariantsTests;
import org.ga4gh.ctk.transport.VariantsProtocolClient;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;

import java.net.InetSocketAddress;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;
import static org.slf4j.LoggerFactory.getLogger;

/**
 * Created by Wayne Stidolph on 6/7/2015.
 */
@RunWith(JUnitParamsRunner.class)
@Category(VariantsTests.class)
public class VariantsSearchResponseCheckIT {
    private static org.slf4j.Logger log = getLogger(VariantsSearchResponseCheckIT.class);

    private static VariantsProtocolClient client;
    /**
     * Method: searchVariants(GASearchVariantsRequest request)
     */
    @Test
    @Parameters({
            // "In the testdataset 1kg-phase1, a query for all variants on chr22
            // between coordinates 16050408 and 16052159 should have exactly 16 results
            // This is one example, feel free to add more!
            "1kg-phase1, 22, 16050408, 16052159, 16"
    })
    public void SearchVariantsRequestResultSizeAsExpected(String vsetIds, String refName, long start, long end, int expLength) throws Exception {
        GASearchVariantsRequest request = GASearchVariantsRequest.newBuilder()
                // I ‘split’ the vsetIds param, if we’re given a first param with
                // semicolons the split sections become individual (multiple)
                // variantSetIds entries
                .setVariantSetIds(Arrays.asList(vsetIds.split(";")))
                .setReferenceName(refName)
                .setStart(start)
                .setEnd(end)
                .build();

        GASearchVariantsResponse response = client.searchVariants(request);

        GASearchVariantsResponseAssert.assertThat(response).isNotNull();
        assertThat(response.getVariants()).hasSize(expLength);
    }


    @BeforeClass
    public static void setupTransport() throws Exception {
        InetSocketAddress endpointAddress = new InetSocketAddress("127.0.0.1", 8000);
        // service = new SimpleOrderServiceEndpoint(endpointAddress);
        client = new VariantsProtocolClient();
        // TODO verify correct data installed


        //client.start(); start binary transceiver to Server Under Test
    }
}
