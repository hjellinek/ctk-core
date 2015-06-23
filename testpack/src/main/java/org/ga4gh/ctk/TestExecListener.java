package org.ga4gh.ctk;

import org.junit.runner.*;
import org.junit.runner.notification.*;
import org.springframework.stereotype.*;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * Created by Wayne Stidolph on 6/23/2015.
 */
@Component
public class TestExecListener extends RunListener {
    static String SYSTEST = "TESTLOG";
    private static org.slf4j.Logger testlog = getLogger(SYSTEST);

    /**
     * Called before any tests have been run.
     */
    public void testRunStarted(Description description) throws java.lang.Exception {
        testlog.debug("Number of testcases to execute : " + description.testCount());
    }

    /**
     * Called when all tests have finished
     */
    public void testRunFinished(Result result) throws java.lang.Exception {
        testlog.debug("Number of testcases executed : " + result.getRunCount());
    }

    /**
     * Called when an atomic test is about to be started.
     */
    public void testStarted(Description description) throws java.lang.Exception {
        testlog.trace("Starting execution of test case : " + description.getMethodName());
    }

    /**
     * Called when an atomic test has finished, whether the test succeeds or fails.
     */
    public void testFinished(Description description) throws java.lang.Exception {
        testlog.debug("Finished execution of test case : " + description.getMethodName());
    }

    /**
     * Called when an atomic test fails.
     */
    public void testFailure(Failure failure) throws java.lang.Exception {
        testlog.debug("Execution of test case failed : " + failure.getMessage());
    }

    /**
     * Called when a test will not be run, generally because a test method is annotated with Ignore.
     */
    public void testIgnored(Description description) throws java.lang.Exception {
        testlog.debug("Execution of test case ignored : " + description.getMethodName());
    }

}
