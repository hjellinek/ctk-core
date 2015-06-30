package org.ga4gh.ctk;

import com.google.common.collect.*;
import org.ga4gh.ctk.config.*;
import org.ga4gh.ctk.transport.*;
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
 * <p>Test tracking to TESTLOG is:
 * <ul>
 *     <li>warn: test failure reports</li>
 *     <li>info: summary line (failed, passed, skipped, time)</li>
 *     <li>debug: test name-matching info, count of test classes, count of test cases to run, test cases as they complete</li>
 *     <li>trace: show test case start as well as complete (helpful if hang)</li>
 * </ul>
 * <p>Test Anything Protocol (TAP) files are output to target/ dir.</p>
 * @see <a href="http://docs.spring.io/spring-boot/docs/current/reference/html/using-boot-running-your-application.html">
 * SpringBoot: Running Your Application</a>
 * @see <a href="https://testanything.org">Test Anything Protocol</a>
 *
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

    public void setTestExecListener(TestExecListener testExecListener) {
        this.testExecListener = testExecListener;
    }

    @Autowired
    private TestExecListener testExecListener;

    @Autowired
    private AntExecutor antExecutor;

    @Value("${ctk.tgt.urlRoot}")
    String urlroot;

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

        // patch through config to URLMAPPING
        if(urlroot != null){
            log.debug("Setting urlroot to " + urlroot);
            URLMAPPING.setUrlRoot(urlroot);
        }

        /* ********* PRE-TEST SCRIPT ******* */
        String scriptBefore = props.ctk_scripts_before;
        if(scriptBefore != null && !scriptBefore.isEmpty()){
            scriptRunner(scriptBefore);
        }

        /* ********* TEST SELECTION ******** */
/* commenting out out DIY loop while migrate to ant-driven
        String matchStr = props.ctk_matchstr;
        log.debug("matchstr: " + matchStr);

        // work through each clause one at a time, even though it might mean re-run tests
        // alternative is to get the classes all into a Set and run that

        for(String mstr : matchStr.split(",")) {
            log.debug("seeking test classes that match < " + mstr + " >");

            Set<Class<?>> testClasses = testFinder.findTestClasses(mstr);

            if (testClasses.isEmpty()) {
                testlog.warn("Didn't do any testing for matchStr " + mstr);
            } else {
                testlog.debug("Matched classes count (can be >1 test in a class): " + testClasses.size());
                testlog.trace("Matched test classes are " + testClasses.toString());
                runTestClasses(testClasses);
            }
        }
*/

        /* ****** MAIN RUN-THE-TESTS *********** */
        antExecutor.executeAntTask(props.ctk_testjar);

        /* ******* post-Test reporting ********* */

        // just log the traffic, until I get the coverage-tests written
        for (Table.Cell<String, String, Integer> cell : AvroJson.getMessages().cellSet()) {
            trafficlog.info(cell.getRowKey() + " " + cell.getColumnKey() + " " + cell.getValue());
        }
    }

    /**
     * <p>Run the testClasses.</p>
     * <p>Execute the test(s), and generate outputs.</p>

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

        junit.addListener(testExecListener); // attaches logging

        long starttime = System.currentTimeMillis();
        Result result = junit.run(req);
        long endtime = System.currentTimeMillis();

        int passed = result.getRunCount() - result.getFailureCount() -result.getIgnoreCount();
        testlog.info(result.getFailureCount() + " failed, "
                + passed + " passed, "
                + result.getIgnoreCount() + " skipped, "
                + result.getRunTime() + " ms");
        for (Failure failure : result.getFailures()) {
            testlog.warn("FAIL: " + failure.toString());
        }
    }

    void antRun(String buildXmlFileFullPath) {
        // the buildfile might be null

    }

    private void scriptRunner(String str){

        // use Apache Commons Exec, launch in seperate thread (non-block)
    }
}