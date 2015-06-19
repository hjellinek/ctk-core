package org.ga4gh.cts.api;

import org.junit.ClassRule;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.springframework.test.context.junit4.rules.SpringClassRule;
import org.springframework.test.context.junit4.rules.SpringMethodRule;

import static org.junit.Assert.assertEquals;

/**
 * <p>Stupidly named 'zz...' so it runs last, this test class will evaluate
 * integration test completeness (are all messages, data type,and endpoints exercised)</p>
 * <p>Created by Wayne Stidolph on 5/30/2015.</p>
 */

public class zzCheckCoverageIT {

    /* These first two rules set up Spring (4.2.0RC1+) injection support
   without having to adopt the SpingJUnit4ClassRunner, so we can use
   Runners such as the WildcardPatternSuite, or Parameterized, etc

   See http://docs.spring.io/spring/docs/4.2.0.RC1/spring-framework-reference/htmlsingle/#testing
   specifically Section 5.6
 */
    @ClassRule
    public static final SpringClassRule SPRING_CLASS_RULE = new SpringClassRule();

    @Rule
    public final SpringMethodRule springMethodRule = new SpringMethodRule();

    @Ignore("Unimplemented")
    @Test
    public void allIdlMessagesShouldBeUsed() throws Exception {
        // plan is to attach the Tables of what-was-used to the
        // TestContext, then here to refer to that and make assertions
        //
        // So the setup phase of this test is to collect all the messages,
        // defined in the IDL

        assertEquals(1,1);
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
}
