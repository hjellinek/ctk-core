package org.ga4gh.cts.api.callsets;

import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.apache.avro.AvroRemoteException;
import org.ga4gh.*;
import org.ga4gh.ctk.CtkLogs;
import org.ga4gh.ctk.testcategories.CoreTests;
import org.ga4gh.ctk.transport.URLMAPPING;
import org.ga4gh.ctk.transport.protocols.VariantsProtocolClient;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;

import java.net.HttpURLConnection;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.StrictAssertions.assertThat;

/**
 * Callsets-related integration tests.
 * <p>
 * TODO merge this with CallsetsSearchResponseCheckIT.
 * <p>
 * Created by Herb Jellinek on 7/10/15.
 */
@Category(CoreTests.class)
@RunWith(JUnitParamsRunner.class)
public class CallsetsIT implements CtkLogs {

    private static final VariantsProtocolClient client = new VariantsProtocolClient();

    private static String makeUrl(String partialUrl) {
        return URLMAPPING.getUrlRoot() + "/" + partialUrl;
    }

    /**
     * Test that the basic server verbs/methods work as expected.
     *
     * @param fullUrl the URL to test
     */
    private void testHttpMethods(String fullUrl) throws UnirestException {
        assertThat(Unirest.get(fullUrl).asBinary().getStatus()).isEqualTo(HttpURLConnection.HTTP_BAD_METHOD);
        assertThat(Unirest.options(fullUrl).asBinary().getStatus()).isEqualTo(HttpURLConnection.HTTP_OK);
        assertThat(Unirest.post(fullUrl).asBinary().getStatus()).isEqualTo(HttpURLConnection.HTTP_UNSUPPORTED_TYPE);
    }

    /**
     * Test that searches' verbs/methods work as expected.
     *
     * @param fullUrl the URL to test
     */
    private void testSearchRouting(final String fullUrl) throws UnirestException {
        // send some malformed requests and expect status == HTTP_BAD_REQUEST
        final String[] badJson = {"", "JSON", "<xml/>", "{", "}", "{\"bad:\"", "{]"};
        for (String datum : badJson) {
            assertThat(Unirest.post(fullUrl).header("Content-type", "application/json").
                    body(datum).asBinary().getStatus()).isEqualTo(HttpURLConnection.HTTP_BAD_REQUEST);
        }
    }

    /**
     * Test the status codes we're supposed to receive from the GET, POST, and OPTIONS methods on
     * <tt>/callsets/search</tt>.
     * <p>
     * <p>See server/tests/unit/test_views.py: testRouteCallsets</p>
     *
     * @throws Exception if there's a connection problem
     */
    @Test
    public void checkCallSetsRouting() throws Exception {
        String callsetsPartialUrl = URLMAPPING.getSearchCallsets();

        testHttpMethods(makeUrl(callsetsPartialUrl));
    }

    /**
     * Test the status codes we're supposed to receive from the GET, POST, and OPTIONS methods on
     * <tt>/variants/search</tt>.
     * <p>
     * <p>See server/tests/unit/test_views.py: testRouteCallsets</p>
     *
     * @throws Exception if there's a connection problem
     */
    @Test
    public void checkVariantSearchMethods() throws Exception {
        String partialUrl = URLMAPPING.getSearchVariants();

        testHttpMethods(makeUrl(partialUrl));
    }

    private String[] allSearchUrls() {
        return new String[] {
                makeUrl(URLMAPPING.getSearchCallsets()),
                makeUrl(URLMAPPING.getSearchReadGroupSets()),
                makeUrl(URLMAPPING.getSearchReads()),
                makeUrl(URLMAPPING.getSearchReferencesets()), // this fails (404 instead of 405)
                makeUrl(URLMAPPING.getSearchVariants()),
                makeUrl(URLMAPPING.getSearchVariantSets())
        };
    }

    /**
     * Test search routing and the handling of bad data.
     */
    @Test
    @Parameters(method = "allSearchUrls")
    public void checkSearchRouting(String fullUrl) throws UnirestException {
        testSearchRouting(fullUrl);
    }

    @Test
    @Parameters("1kg-phase1, 22, 16050408, 16052159")
    public void checkCallsetsSearch(String variantSetName, String referenceName, long start, long end) throws AvroRemoteException {
        GASearchVariantsRequest variantsRequest =
                GASearchVariantsRequest.newBuilder().
                        setVariantSetIds(Collections.singletonList(variantSetName)).
                                               setReferenceName(referenceName).
                                               setStart(start).setEnd(end).build();
        GASearchVariantsResponse variantsResponse = client.searchVariants(variantsRequest);
        List<GAVariant> variants = variantsResponse.getVariants();
        GASearchCallSetsRequest req = GASearchCallSetsRequest.newBuilder().
                setVariantSetIds(Collections.<String>emptyList()).build();

        GASearchCallSetsResponse callSetsResponse = client.searchCallSets(req);
        List<GACallSet> sets = callSetsResponse.getCallSets();
        log.debug("checkCallsetsSearch", sets);
        // XXX to be completed!
    }

}
