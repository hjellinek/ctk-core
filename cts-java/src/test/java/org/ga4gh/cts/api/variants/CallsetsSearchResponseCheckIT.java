package org.ga4gh.cts.api.variants;

import junitparams.*;
import org.ga4gh.ctk.*;
import org.ga4gh.ctk.transport.*;
import org.ga4gh.ctk.transport.protocols.*;
import org.junit.*;
import org.junit.experimental.categories.*;
import org.junit.runner.*;

/**
 * Created by Wayne Stidolph on 6/11/2015.
 */
@RunWith(JUnitParamsRunner.class)
@Category(VariantsTests.class)
public class CallsetsSearchResponseCheckIT implements CtkLogs {
    // implements CtkLogsprivate static org.slf4j.Logger log = getLogger(CallsetsSearchResponseCheckIT.class);

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
        //InetSocketAddress endpointAddress = new InetSocketAddress("127.0.0.1", 8000);
        // service = new SimpleOrderServiceEndpoint(endpointAddress);
        URLMAPPING.doInit(); // reload defaults
        client = new VariantsProtocolClient();
    }
}
