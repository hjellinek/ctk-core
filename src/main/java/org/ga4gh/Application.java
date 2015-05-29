package org.ga4gh;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(Application.class, args);


        List<Class> testCases = new ArrayList();
        testCases.add(org.ga4gh.ctk.tests.ReadMethodsTests.class);

        for (Class testCase : testCases) {
            runTestCase(testCase);
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