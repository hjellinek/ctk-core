package org.ga4gh.ctk;

import com.google.common.collect.Table;
import org.ga4gh.ctk.transport.avrojson.AvroJson;
import org.junit.runner.JUnitCore;
import org.junit.runner.Request;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import org.reflections.Reflections;
import org.reflections.scanners.SubTypesScanner;
import org.reflections.util.ClasspathHelper;
import org.reflections.util.ConfigurationBuilder;
import org.reflections.util.FilterBuilder;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.net.URL;
import java.net.URLClassLoader;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * <p>The Application - this is the main entry point for the CTK for running the entire CTK
 * from a command line or an IDE, and is the CTK entry point if running from the executable jar
 * packaging.</p>
 * <p>(You can also run the CTK using {@code mvn spring-boot:run}, or you can run tests/suites one at a time
 * in your IDE.)</p>
 * <p>This entry is a Spring Boot app, so you can refer to their documention for alternative run-methods.
 * @see <a href="http://docs.spring.io/spring-boot/docs/current/reference/html/using-boot-running-your-application.html">
 *     SpringBoot: Running Your Application</a></p>
 * <p>Created by Wayne Stidolph</p>
 */
@SpringBootApplication
public class Application implements CommandLineRunner {

    private static String TESTPACKAGE = "org.ga4gh.ctk.systests";

    private static org.slf4j.Logger log = getLogger(Application.class);
    private static org.slf4j.Logger testlog = getLogger("SYSTEST");
    static String TRAFFICLOG="SYSTEST.TRAFFIC";
    private static org.slf4j.Logger trafficlog = getLogger(TRAFFICLOG);

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

        Set<Class<?>> testClasses = findTestClasses(matchStr);

        for (Class testClass : testClasses) {
                runTestClass(testClass); // will also output Failures to SYSTEST log
        }

        // just log the traffic, until I get the coverage-tests written
        for(Table.Cell<String, String, Integer> cell : AvroJson.getMessages().cellSet()){
            // TODO either filter this to just this Test or move the extraction to zzCheckCoverage
            trafficlog.info(cell.getRowKey() + " " + cell.getColumnKey() + " " + cell.getValue());
        }
    }


    /**
     * find test classes based on name pattern-match
    */
    private static Set<Class<?>> findTestClasses(String matchStr) {

        Collection<URL> urls = ClasspathHelper.forPackage(TESTPACKAGE);

        Reflections reflections =
                new Reflections(new ConfigurationBuilder()
                .setUrls(urls)
                .setScanners(new SubTypesScanner(false)) // false means do NOT exclude direct child of Object
                .filterInputsBy(new FilterBuilder().include(matchStr))
        );

        boolean foundTests = reflections.getConfiguration().getUrls().size()>0;
        if(!foundTests){
            log.warn("No tests found on classpath, looking for classes in package: " + TESTPACKAGE);
            ClassLoader cl = Thread.currentThread().getContextClassLoader();
            URL[] allurls = ((URLClassLoader)cl).getURLs();
            for(URL url : allurls) log.debug("URL " + url.toString());
            testlog.warn("Didn't do any testing");

            return new HashSet<Class<?>>(); // just toss back an empty set
        }

        Set<Class<? extends Object>> testClasses =
                reflections.getSubTypesOf(Object.class);

        return testClasses;
    }

    private static void runTestClass(Class testClass) {

        JUnitCore junit = new JUnitCore();
        Request req = Request.aClass(testClass);
        Result result = junit.run(req);

        for (Failure failure : result.getFailures()) {
           testlog.warn(failure.toString());
        }
    }
}