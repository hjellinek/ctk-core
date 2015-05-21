package org.ga4gh.models;

import junitparams.JUnitParamsRunner;
import org.ga4gh.beacon.BeaconInformationResource;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.ga4gh.beacon.BeaconInformationResourceAssert.*;

/**
 * Created by wstidolph on 5/20/15.
 */
@RunWith(JUnitParamsRunner.class)
public class ReadsTest {
/*
ReadGroupSet >--< ReadGroup --< fragment --< read --< alignment --< linear/graph alignment
 */
    @Test
    public static void beaconInfoTest() throws Exception {
        BeaconInformationResource brb = new BeaconInformationResource();
        assertThat(brb).hasApi("foo");
    }
}
