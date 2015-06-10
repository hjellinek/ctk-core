package org.ga4gh.ctk.systests;

/**
 * <p>This test fetches the target server landing page as evidence of connectivity;
 * the test also scrapes the supplied HTML as fodder for the eventual report.</p>
 * Created by Wayne Stidolph on 6/7/2015.
 */

import junitparams.JUnitParamsRunner;
import org.ga4gh.ctk.control.testcategories.CTK.CoreTests;
import org.ga4gh.ctk.control.testcategories.WIP;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;

@Category(CoreTests.class)
@RunWith(JUnitParamsRunner.class)
public class LandingPageIT {

    @Test
    @Category(WIP.class)
    @Ignore("Placeholder until I integrate Spring support")
    public static void landingPagesShouldExist() throws Exception {

    }
}
