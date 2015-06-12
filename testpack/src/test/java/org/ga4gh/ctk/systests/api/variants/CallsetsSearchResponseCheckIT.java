package org.ga4gh.ctk.systests.api.variants;

import junitparams.JUnitParamsRunner;
import org.ga4gh.ctk.control.testcategories.API.VariantsTests;
import org.ga4gh.ctk.transport.protocols.VariantsProtocolClient;
import org.junit.BeforeClass;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;

import java.net.InetSocketAddress;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * Created by Wayne Stidolph on 6/11/2015.
 */
@RunWith(JUnitParamsRunner.class)
@Category(VariantsTests.class)
public class CallsetsSearchResponseCheckIT {
    private static org.slf4j.Logger log = getLogger(CallsetsSearchResponseCheckIT.class);

    private static VariantsProtocolClient client;

    /*
     REF MATERIAL from the  variantmethods IDL re GASearchCallSetRequest
     This request maps to the body of `POST /callsets/search` as JSON

     If specified, will restrict the query to call sets within the given variant sets.
     array<string> variantSetIds = [];

     Only return call sets for which a substring of the name matches this string.
     union { null, string } name = null;
     */

    @BeforeClass
    public static void setupTransport() throws Exception {
        InetSocketAddress endpointAddress = new InetSocketAddress("127.0.0.1", 8000);
        // service = new SimpleOrderServiceEndpoint(endpointAddress);
        client = new VariantsProtocolClient();
    }
}
