package org.ga4gh.cts.core;

/**
 * <p>This test fetches the target server landing page as evidence of connectivity;
 * the test also scrapes the supplied HTML as fodder for the eventual report.</p>
 * <p>Created by Wayne Stidolph on 6/7/2015.</p>
 */

import com.mashape.unirest.http.*;
import com.mashape.unirest.request.*;
import junitparams.*;
import org.ga4gh.ctk.testcategories.*;
import org.ga4gh.ctk.transport.*;
import org.junit.*;
import org.junit.experimental.categories.*;
import org.junit.runner.*;

import java.net.*;

import static org.assertj.core.api.Assertions.*;

@Category(CoreTests.class)
@RunWith(JUnitParamsRunner.class)
public class LandingPageIT implements CtkLogs {
    // private static org.slf4j.Logger log = getLogger(LandingPageIT.class);

    /**
     * <p>Landing pages should exist.</p>
     * <p>This test verifies the environmental "urlRoot" is a valid URL
     * and then tries to fetch the page at that root. A response of '200'
     * is adequate for passing the test.</p>
     *
     * @throws Exception the exception
     */
    @Test
    public void landingPagesShouldExist() throws Exception {
        String theUrlString = URLMAPPING.getUrlRoot();

        URL url = new URL(theUrlString);
        String finalUrl = url.getProtocol() + "://" + url.getAuthority();

        log.debug("Fetch from " + finalUrl);
        GetRequest request = Unirest.get(finalUrl);
        HttpResponse<String> response = request.asString();
        assertThat(response.getStatus()).isEqualTo(200);
    }

    /**
     * <p>Show that tests can fail.</p>
     * <p>By querying for a system property "cts.demofail" this
     * test shows that tests can fail. This optional failure thus demonstrates the CTK
     * capabilities of linking from the generated Surefire report directly
     * to the failing line of test code, and to the test-specific javadoc.</p>
     *
     * @throws Exception the exception
     */
    @Test
    public void propertyCanCauseTestFail() throws Exception {

        if(Boolean.getBoolean("cts.demofail")) {
            CtkLogs.testlog.warn("Dummying failure because cts.demofail is true");
            assertThat(false).isTrue();
        }
        else
            assertThat(false).isFalse();
    }
}
