package org.ga4gh.ctk.systests.core;

/**
 * <p>This test fetches the target server landing page as evidence of connectivity;
 * the test also scrapes the supplied HTML as fodder for the eventual report.</p>
 * <p>Created by Wayne Stidolph on 6/7/2015.</p>
 */

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.request.GetRequest;
import junitparams.JUnitParamsRunner;
import org.ga4gh.ctk.control.testcategories.CoreTests;
import org.ga4gh.ctk.transport.URLMAPPING;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;

import java.net.URL;

import static org.slf4j.LoggerFactory.getLogger;

@Category(CoreTests.class)
@RunWith(JUnitParamsRunner.class)
public class LandingPageIT {
    private static org.slf4j.Logger log = getLogger(LandingPageIT.class);

    /**
     * <p>Landing pages should exist.</p>
     * <p>This test verifies the environmental "urlRoot" is a valid URL
     * and then tries to fetch the page at that root. A response of '200'
     * is adequate for passing the test.</p>
     *
     * @throws Exception the exception
     */
    @Test
    public static void landingPagesShouldExist() throws Exception {
        String theUrlString = URLMAPPING.getUrlRoot();

        URL url = new URL(theUrlString);
        String finalUrl = url.getProtocol() + "://" + url.getAuthority();

        log.debug("Fetch from " + finalUrl);
        GetRequest request = Unirest.get(finalUrl);
        HttpResponse<String> response = request.asString();
        org.assertj.core.api.Assertions.assertThat(response.getStatus()).isEqualTo(200);
    }

}
