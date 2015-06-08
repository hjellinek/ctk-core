package org.ga4gh.ctk.sut.variants;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.ga4gh.GASearchVariantSetsRequest;
import org.ga4gh.GASearchVariantsRequest;
import org.ga4gh.GASearchVariantsResponse;
import org.ga4gh.GASearchVariantsResponseAssert;
import org.ga4gh.ctk.control.testcategories.API.VariantsTests;
import org.ga4gh.ctk.sut.reads.ReadMethodsIT;
import org.ga4gh.ctk.transport.VariantsProtocolClient;
import org.junit.*;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;

import java.net.InetSocketAddress;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;
import static org.slf4j.LoggerFactory.getLogger;

/**
 * VariantsProtocolClient Tester.
 *
 * This is @RunWith() the JUnitParamsRunner so you can paramaterize tests -
 * this is done here with simple @Parameter annotations, but normal
 * @Paramter behavior holds if you want to load from a file, DB, etc.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>Jun 6, 2015</pre>
 */
@RunWith(JUnitParamsRunner.class)
@Category(VariantsTests.class)
public class VariantsMethodsIT {

    private static org.slf4j.Logger log = getLogger(ReadMethodsIT.class);

    private static VariantsProtocolClient client;

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: searchVariantSets(GASearchVariantSetsRequest request)
     */
    @Ignore
    @Test
    public void testSearchVariantSetsRequest() throws Exception {
        GASearchVariantSetsRequest svsr = GASearchVariantSetsRequest.newBuilder()
                .build();

    }

    /**
     * Method: searchVariantSets(GASearchVariantSetsRequest request, WireDiff wd)
     */
    @Ignore
    @Test
    public void testSearchVariantSetsForRequestWd() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: searchVariants(GASearchVariantsRequest request)
     */
    @Test
    @Parameters({
            // "In the testdataset 1kg-phase1, a query for all variants on chr22
            // between coordinates 16050408 and 16052159 should have exactly 16 results
            "1kg-phase1, 22, 16050408, 16052159, 16"
    })
    public void SearchVariantsRequestResultSizeAsExpected(String vsetIds, String refName, long start, long end, int expLength) throws Exception {
        GASearchVariantsRequest request = GASearchVariantsRequest.newBuilder()
                .setVariantSetIds(Arrays.asList(vsetIds.split(",")))
                .setReferenceName(refName)
                .setStart(start)
                .setEnd(end)
                .build();

        GASearchVariantsResponse response = client.searchVariants(request);

        GASearchVariantsResponseAssert.assertThat(response).isNotNull();
        // List<GAVariant> variants = ;
        assertThat(response.getVariants()).hasSize(expLength);
    }

    /**
     * Method: searchVariants(GASearchVariantsRequest request, WireDiff wd)
     */
    @Ignore
    @Test
    public void testSearchVariantsForRequestWd() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: searchCallSets(GASearchCallSetsRequest request)
     */
    @Ignore
    @Test
    public void testSearchCallSetsRequest() throws Exception {
//TODO: Test goes here... 
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
