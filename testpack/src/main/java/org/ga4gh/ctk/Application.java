package org.ga4gh.ctk;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class Application implements CommandLineRunner {

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
        List<Class> testCases = new ArrayList();

        // we need the app classpath to include the test classes
        // and for them to e packaged in the app jar

       // testCases.add(ReadMethodsIT.class);

        for (Class testCase : testCases) {
            System.out.println("loop top");
            try {
                runTestCase(testCase);
            } catch (Throwable t) {
                t.printStackTrace();
            }


        }

    }

    private static void runTestCase(Class testCase) {
        JUnitCore junit = new JUnitCore();

        Result result = junit.run(testCase);

        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
    }
}