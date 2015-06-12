package org.ga4gh.ctk.systests.api.variants;

import org.ga4gh.ctk.control.testcategories.API.VariantsTests;
import org.ga4gh.ctk.transport.protocols.VariantsProtocolClient;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import java.net.InetSocketAddress;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * <p>Verify the paging behavior of the /variants endpoint</p>
 * <p>Created by Wayne Stidolph on 6/11/2015.</p>
 */
@Category(VariantsTests.class)
public class VariantsMethodsPagingChecksIT {
    private static org.slf4j.Logger log = getLogger(VariantsMethodsPagingChecksIT.class);

    private static VariantsProtocolClient client;

    /**
     * <p>Page through big variants response.</p>
     *
     * <p>  The continuation token, which is used to page through large result sets.
     To get the next page of results, set this parameter to the value of
     `nextPageToken` from the previous response.</p>
     *
     * @throws Exception the exception
     */
    @Ignore
    @Test
    public void pageThroughBigVariantsResponse() throws Exception {
        //TODO write the test :)
    }

    @BeforeClass
    public static void setupTransport() throws Exception {
        InetSocketAddress endpointAddress = new InetSocketAddress("127.0.0.1", 8000);
        // service = new SimpleOrderServiceEndpoint(endpointAddress);
        client = new VariantsProtocolClient();

    }
}
