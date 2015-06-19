package org.ga4gh.ctk;

import com.google.common.collect.*;
import org.ga4gh.ctk.config.*;
import org.ga4gh.ctk.transport.avrojson.*;
import org.junit.runner.*;
import org.junit.runner.notification.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.context.*;
import org.tap4j.ext.junit.listener.*;

import java.net.*;
import java.util.*;

import static org.slf4j.LoggerFactory.*;

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
    static String SYSTEST = "TESTLOG";
    private static org.slf4j.Logger testlog = getLogger(SYSTEST);
    static String TRAFFICLOG=SYSTEST + ".TRAFFIC";
    private static org.slf4j.Logger trafficlog = getLogger(TRAFFICLOG);

    @Autowired
    private Props props;
    public void setProps(Props props){
        this.props = props;
    }

    @Autowired
    private TestFinder testFinder;
    public void setTestFinder(TestFinder testFinder) {
        this.testFinder = testFinder;
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

        // log some startup path-debug info for "why aren't my tests seen?"
        URL location = Application.class.getProtectionDomain().getCodeSource().getLocation();
        log.debug("Application launched from " + location.getFile());
        log.debug("command line args: " + Arrays.toString(args));

        // run a 'before' script if it exists
        String scriptBefore = props.ctk_scripts_before;
        if(scriptBefore != null && !scriptBefore.isEmpty()){
            scriptRunner(scriptBefore);
        }

        String matchStr = props.ctk_matchstr;
        log.debug("matchstr: " + matchStr);

        // work through each clause one at a time, even though it might mean re-run tests
        // alternative is to get the classes all into a Set and run that
        for(String mstr : matchStr.split(",")) {
            log.info("seeking test classes that match < " + mstr + " >");

            Set<Class<?>> testClasses = testFinder.findTestClasses(mstr);

            if (testClasses.isEmpty()) {
                testlog.warn("Didn't do any testing for matchStr " + mstr);
            } else {
                testlog.info("matched count: " + testClasses.size());
                testlog.debug(testClasses.toString());
                runTestClasses(testClasses);
            }
        }
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

        long starttime = System.currentTimeMillis();
        Result result = junit.run(req);
        long endtime = System.currentTimeMillis();

        testlog.info("test run took (ms): " + (endtime - starttime));
        testlog.info("Test run count: " + result.getRunCount());
        testlog.info("Test ignore count: " + result.getIgnoreCount());
        testlog.info("Test failure count: " + result.getFailureCount());
        for (Failure failure : result.getFailures()) {
            testlog.warn(failure.toString());
        }
    }

    private void scriptRunner(String str){

        // use Apache Commons Exec, launch in seperate thread (non-block)
    }
}