package org.ga4gh.ctk;

import org.junit.runner.JUnitCore;
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
        String matchStrIT = ".*IT.*";
        String matchStrSuite = ".*TestSuite/..*";
        Set<Class<?>> testCases = findTestClasses(matchStrIT);

        for (Class testCase : testCases) {
                runTestCase(testCase);
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

        Reflections reflections =
                new Reflections(new ConfigurationBuilder()
                .setUrls(ClasspathHelper.forPackage(TESTPACKAGE))
                .setScanners(new SubTypesScanner(false)) // false means do NOT exclude direct child of Object
                .filterInputsBy(new FilterBuilder().include(matchStr))
        );

        Set<Class<? extends Object>> testClasses =
                reflections.getSubTypesOf(Object.class);

        return testClasses;
    }

    private static void runTestCase(Class testCase) {

        JUnitCore junit = new JUnitCore();
        Result result = junit.run(testCase);

        for (Failure failure : result.getFailures()) {
           testlog.warn(failure.toString());
        }
    }
}