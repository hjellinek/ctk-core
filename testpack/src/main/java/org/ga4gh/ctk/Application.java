package org.ga4gh.ctk;

import com.google.common.collect.Table;
import org.ga4gh.ctk.transport.avrojson.AvroJson;
import org.junit.runner.JUnitCore;
import org.junit.runner.Request;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.tap4j.ext.junit.listener.TapListenerClass;
import org.tap4j.ext.junit.listener.TapListenerSuite;

import java.net.URL;
import java.util.Arrays;
import java.util.Set;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * <p>The Application - this is the main entry point for the CTK for running the entire CTK
 * from a command line or an IDE, and is the CTK entry point if running from the executable jar
 * packaging.</p>
 * <p>(You can also run the CTK using {@code mvn spring-boot:run}, or you can run tests/suites one at a time
 * in your IDE.)</p>
 * <p>This entry is a Spring Boot app, so you can refer to their documention for alternative run-methods.
 *
 * @see <a href="http://docs.spring.io/spring-boot/docs/current/reference/html/using-boot-running-your-application.html">
 * SpringBoot: Running Your Application</a></p>
 * <p>Created by Wayne Stidolph</p>
 */
@SpringBootApplication
public class Application implements CommandLineRunner {

    private static org.slf4j.Logger log = getLogger(Application.class);
    private static org.slf4j.Logger testlog = getLogger("SYSTEST");
    static String TRAFFICLOG = "SYSTEST.TRAFFIC";
    private static org.slf4j.Logger trafficlog = getLogger(TRAFFICLOG);

    @Autowired
    Config cfg;
    public void setCfg(Config cfg){
        this.cfg = cfg;
    }

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(Application.class, args);
    }

    /**
     * Callback used to execute the actual app (run the CTK tests).
     *
     * @param args incoming main method arguments
     * @throws Exception on error
     */
    @Override
    public void run(String... args) throws Exception {

        // log some path-debug info for "why aren't my tests seen?"
        URL location = Application.class.getProtectionDomain().getCodeSource().getLocation();
        log.debug("Application launched from " + location.getFile());
        log.debug("command line args: " + Arrays.toString(args));

        // temp hack until I add cmd-line param or use the props
        String matchStrIT = ".*IT.*";
        String matchStrSuite = ".*TestSuite.*";

        String matchStr = matchStrIT;
        log.debug("seeking test classes that match < " + matchStr + " >");

        TestFinder testFinder = new TestFinder();
        Set<Class<?>> testClasses = testFinder.findTestClasses(matchStr);

        if (testClasses.isEmpty()) {
            testlog.warn("Didn't do any testing");
            System.exit(-1);
        }

        runTestClasses(testClasses);

        // post-Test reporting

        // just log the traffic, until I get the coverage-tests written
        for (Table.Cell<String, String, Integer> cell : AvroJson.getMessages().cellSet()) {
            trafficlog.info(cell.getRowKey() + " " + cell.getColumnKey() + " " + cell.getValue());
        }
    }

    /**
     * <p>Run the testClasses.</p>
     * <p>Execute the test(s), and generate outputs.
     * Any failures go to the testlog at a WARN level.
     * All results are output using Test Anything Protocol listeners.</p>
     *
     * @param testClasses Classes to be executed using JUnit runners
     * @see <a href="http://tap4j.org/tap4j-ext/junit_support.html">Test Anything Protocol tap4j extension</a>
     */
    private void runTestClasses(Set<Class<?>> testClasses) {

        JUnitCore junit = new JUnitCore();

        Request req = Request.classes(
                // the Request wants an array (a Vararg) of classes
                testClasses.toArray(new Class[testClasses.size()]));

        TapListenerSuite tapsuite = new TapListenerSuite();// TAP outputs per Suite
        junit.addListener(tapsuite);

        TapListenerClass tapclass = new TapListenerClass();// TAP outputs per class
        junit.addListener(tapclass);

        Result result = junit.run(req);

        testlog.info("Test run count: " + result.getRunCount());
        testlog.info("Test ignore count: " + result.getIgnoreCount());
        testlog.info("Test failure count: " + result.getFailureCount());
        for (Failure failure : result.getFailures()) {
            testlog.warn(failure.toString());
        }
    }
}