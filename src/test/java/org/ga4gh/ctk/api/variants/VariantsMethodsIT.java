package org.ga4gh.ctk.api.variants;

import com.google.common.collect.Table;
import junitparams.JUnitParamsRunner;
import org.apache.http.HttpStatus;
import org.ga4gh.GASearchVariantSetsRequest;
import org.ga4gh.GASearchVariantsRequest;
import org.ga4gh.GASearchVariantsResponse;
import org.ga4gh.GASearchVariantsResponseAssert;
import org.ga4gh.ctk.control.WireDiff;
import org.ga4gh.ctk.control.testcategories.API.VariantsTests;
import org.ga4gh.ctk.transport.VariantsProtocolClient;
import org.ga4gh.ctk.transport.avrojson.AvroJson;
import org.junit.*;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;

import java.net.InetSocketAddress;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * <p>Verifies basic sanity of the variants/search API.</p>
 *
 * <p>The {@code VARIANTS} API methods (as defined in {@code variantmethods.avdl}) are:</p>
 * <ul>
 *     <li>POST /variants/search GASearchVariantsRequest yields GASearchVariantsResponse [{@code searchVariants()}]</li>
 *     <li>POST /variantsets/search GASearchVariantSetsRequest yields GASearchVariantSetsResponse [{@code searchVariantSets()}]</li>
 *     <li>POST /callsets/search GASearchCallSetsRequest yields GASearchCallSetsResponse [{@code searchCallSets()}]</li>
 * </ul>
 *
 * <p>The test invokes a search request with null, default, and error parameters
 * on the endpoint and verifies the response. For tests with more insight into
 * the data returned (complex queries, etc) refer to the VariantsSearchingIT tests.</p>
 *
 * <p>This is @RunWith() the JUnitParamsRunner so you can paramaterize tests -
 * this is done here with simple @Parameter annotations, but normal
 * @Parameter behavior holds if you want to load from a file, DB, etc.</p>
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>Jun 6, 2015</pre>
 */
@RunWith(JUnitParamsRunner.class)
@Category(VariantsTests.class)
public class VariantsMethodsIT {

    private static org.slf4j.Logger log = getLogger(VariantsMethodsIT.class);

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
    public void defaultSearchVariantsRequestResultIsNotNull() throws Exception {
        GASearchVariantsRequest request = GASearchVariantsRequest.newBuilder()
                .setReferenceName("foo")
                .setStart(0L)
                .setEnd(1L)
                .build();

        WireDiff mywd = new WireDiff();
        GASearchVariantsResponse response = client.searchVariants(request, mywd);

        org.junit.Assert.assertTrue(mywd.getResponseStatus() == HttpStatus.SC_OK);

        GASearchVariantsResponseAssert.assertThat(response).isNotNull();

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

    @AfterClass
    public static void shutdownTransport() throws Exception {
        for(Table.Cell<String, String, Integer> cell : AvroJson.getMessages().cellSet()){
            // TODO either filter this to just this Test or move the extraction to zzCheckCoverage
            log.info("VariantsMethodIT TRAFFIC:" + cell.getRowKey() + " " + cell.getColumnKey() + " " +cell.getValue());
        }
    }

} 
