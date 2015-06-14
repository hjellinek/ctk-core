package org.ga4gh.ctk;

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

@SpringBootApplication
public class Application implements CommandLineRunner {

    private static String TESTPACKAGE = "org.ga4gh.ctk.systests";

    private static org.slf4j.Logger log = getLogger(Application.class);
    private static org.slf4j.Logger testlog = getLogger("SYSTEST");

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(Application.class, args);
    }

    /**
     * Callback used to execute test cases.
     *
     * @param args incoming main method arguments
     * @throws Exception on error
     */
    @Override
    public void run(String... args) throws Exception {

        URL location = Application.class.getProtectionDomain().getCodeSource().getLocation();
        log.warn("Application launched from " + location.getFile());
        log.debug("command line args: " + Arrays.toString(args));



        String matchStrIT = ".*IT.*";
        String matchStrSuite = ".*TestSuite.*";

        String matchStr = matchStrIT;
        log.debug("seeking test classes that match < " + matchStr + " >");

        Set<Class<?>> testClasses = findTestClasses(matchStr);

        for (Class testClass : testClasses) {
                runTestClass(testClass);
        }
    }

    /*
    -Dsuite=<foo> matches <foo>TestSuite
    -Dcategory=<foo> matches any org.ga4gh.ctk.systests test annotated with @Test and @<foo>.class
    -Dtest=<foo> matches org.ga4gh.ctk.systests/<0 or more dirs>/<foo>
     */

    /**
     * find test classes (classes in org.ga4gh.ctk.systests/** with name ending in IT
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
        // old style

        JUnitCore junit = new JUnitCore();
        Request req = Request.aClass(testClass);
        Result result = junit.run(req);

        for (Failure failure : result.getFailures()) {
           testlog.warn(failure.toString());
        }
    }
}