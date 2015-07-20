package org.ga4gh.cts.api;

import org.ga4gh.ctk.*;
import org.ga4gh.ctk.transport.*;
import org.junit.*;

import static org.junit.Assert.*;

/**
 * <p>Stupidly named 'zz...' so it runs last, this test class will evaluate
 * integration test completeness (are all messages, data type,and endpoints exercised)</p>
 * <p>Created by Wayne Stidolph on 5/30/2015.</p>
 */
public class zzCheckCoverageIT implements CtkLogs {
    /* These first two rules set up Spring (4.2.0RC1+) injection support
       without having to adopt the SpringJUnit4ClassRunner, so we can use
       Runners such as the WildcardPatternSuite, or Parameterized, etc

       See http://docs.spring.io/spring/docs/4.2.0.RC1/spring-framework-reference/htmlsingle/#testing
       specifically Section 5.6
    */
    /*@ClassRule
    public static final SpringClassRule SPRING_CLASS_RULE = new SpringClassRule();

    @Rule
    public final SpringMethodRule springMethodRule = new SpringMethodRule();*/

    @Ignore("Unimplemented")
    @Test
    public void allIdlMessagesShouldBeUsed() throws Exception {
        // plan is to attach the Tables of what-was-used to the
        // TestContext, then here to refer to that and make assertions
        //
        // So the setup phase of this test is to collect all the messages,
        // defined in the IDL

        assertEquals(1, 1);
    }

    @Ignore("Unimplemented")
    @Test
    public void allIdlDatatypesShouldBeUsed() throws Exception {
        // plan is to attach the Tables of what-was-used to the
        // TestContext, then here to refer to that and make assertions
    }

    @Ignore("Unimplemented")
    @Test
    public void allEndpointsShouldBeUsed() throws Exception {
        // plan is to attach the Tables of what-was-used to the
        // TestContext, then here to refer to that and make assertions

    }

    @BeforeClass
    public static void setupTransport() throws Exception {
        //InetSocketAddress endpointAddress = new InetSocketAddress("127.0.0.1", 8000);
        // service = new SimpleOrderServiceEndpoint(endpointAddress);
        URLMAPPING.doInit(); // reload defaults
        //client = new Client();
    }
}
