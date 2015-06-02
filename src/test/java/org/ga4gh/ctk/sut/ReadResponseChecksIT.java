package org.ga4gh.ctk.sut;

import org.junit.experimental.theories.DataPoint;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

/**
 * Created by Wayne Stidolph on 6/2/2015.
 */
@RunWith(Theories.class)
public class ReadResponseChecksIT {
    @DataPoint public static String GOOD_DATASETID = "GOODID";
    @DataPoint public static String BAD_DATASETID = "!";

    @Theory
    public void datasetidDoesNotIncludeExclamation(String datasetid){

    }
}
