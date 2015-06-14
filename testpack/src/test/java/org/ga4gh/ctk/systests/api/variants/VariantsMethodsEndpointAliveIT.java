package org.ga4gh.ctk.systests.api.variants;

import org.assertj.core.api.JUnitSoftAssertions;
import org.ga4gh.*;
import org.ga4gh.ctk.control.testcategories.API.VariantsTests;
import org.ga4gh.ctk.transport.RespCode;
import org.ga4gh.ctk.transport.WireTracker;
import org.ga4gh.ctk.transport.protocols.VariantsProtocolClient;
import org.junit.*;
import org.junit.experimental.categories.Category;

import java.net.InetSocketAddress;

import static org.assertj.core.api.Assertions.*;
import static org.slf4j.LoggerFactory.getLogger;

/**
 * <p>Verifies basic reachability of the variants, variantsets, and callsets, search enpoints, and parseable default responses.</p>
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
 * <p>Note this is RunWith the default JUnit runner, which means we can (and do) use
 * a JUnit4 @Rule to set up a JUnitSoftAssertions, which lets us make multiple
 * asserts and have them all automatically checked and group-reported at the end of each test.</p>
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>Jun 6, 2015</pre>
 */

@Category(VariantsTests.class)
public class VariantsMethodsEndpointAliveIT {

    private static org.slf4j.Logger log = getLogger(VariantsMethodsEndpointAliveIT.class);




    private static VariantsProtocolClient client;

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    @Rule
    public final JUnitSoftAssertions softly = new JUnitSoftAssertions();

    /**
     * Method: searchVariantSets(GASearchVariantSetsRequest request)
     */
    //@Ignore
    @Test
    public void testSearchVariantSetsRequestEndpointAlive() throws Exception {
        GASearchVariantSetsRequest svsr = GASearchVariantSetsRequest.newBuilder()
                .build();

        GASearchVariantSetsResponse response = client.searchVariantSets(svsr);
        assertThat(response).isNotNull();
    }

    /**
     * Method: searchVariantSets(GASearchVariantSetsRequest request, WireTracker wd)
     */
    //@Ignore
    @Test
    public void testSearchVariantSetsForRequestWdEndpointAlive() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: searchVariants(GASearchVariantsRequest request)
     */
    @Test
    public void testSearchVariantsRequestEndpointAlive() throws Exception {
        GASearchVariantsRequest request = GASearchVariantsRequest.newBuilder()
                .setReferenceName("foo")
                .setStart(0L)
                .setEnd(1L)
                .build();

        GASearchVariantsResponse response = client.searchVariants(request);

        assertThat(response).isNotNull();
    }

    /**
     * Method: searchVariants(GASearchVariantsRequest request, WireTracker wd)
     */
    //@Ignore
    @Test
    public void testSearchVariantsForRequestWdEndpointAlive() throws Exception {
        GASearchVariantsRequest request = GASearchVariantsRequest.newBuilder()
                .setReferenceName("foo")
                .setStart(0L)
                .setEnd(1L)
                .build();

        WireTracker mywt = new WireTracker();
        GASearchVariantsResponse response = client.searchVariants(request, mywt);

        // the JUnit4 Rule creates a SoftAssertion and we can do multiple asserts cleanly!
        assertThat(mywt.getResponseStatus()).isEqualTo(RespCode.NOT_IMPLEMENTED);
        assertThat(response).isNotNull();
    }

    /**
     * Method: searchCallSets(GASearchCallSetsRequest request)
     */
    @Test
    public void testSearchCallSetsRequestEndpointAlive() throws Exception {
        GASearchCallSetsRequest scsr = GASearchCallSetsRequest.newBuilder()
                .build();

        GASearchCallSetsResponse response = client.searchCallSets(scsr);

        assertThat(response).isNotNull();
    }

    /**
     * Method: searchCallSets(GASearchCallSetsRequest request)
     */
    @Test
    public void testSearchCallSetsRequestWDEndpointAlive() throws Exception {
        GASearchCallSetsRequest scsr = GASearchCallSetsRequest.newBuilder()
                .build();

        WireTracker mywt = new WireTracker();
        GASearchCallSetsResponse response = client.searchCallSets(scsr, mywt);

        assertThat(response).isNotNull();
        assertThat(mywt.getResponseStatus()).isEqualTo(RespCode.NOT_IMPLEMENTED);
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

    }

} 
