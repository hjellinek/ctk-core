# Prerequisites

Java 8, Maven 3, [CTK source Installed](InstallingTheCTK.md)

# Testing using Maven goals

You can run Maven from a command line, or from a maven runner in your build or development environments. With maven runs you will get JUnit .txt and .xml files and HTML summary files. You can also use maven to generate a complete `site` about the CTK - cross referenced source and javadoc, dependency reports on the CTK/CTS itself, and HTML reports on the most recent test execution.

The CTS tests are hooked into the maven "integration test" goal, not the normal "test" goal. This lets you build normal unit-style tests and run them as you want, using the maven Surefire test runner. But, the Surefire plugin in `cts-java` (where the server tests are located) is configured to ignore tests in classes with names starting or ending in "IT" - these are "Integration Tests" and will be picked up by the [Failsafe plugin](https://maven.apache.org/surefire/maven-failsafe-plugin/) when it scans the test classes directory.

So, in order to run the server (CTS) tests, you need to ensure the test class files are in place, and then run the failsafe integration-test goal. The easiest way to do this depends on your setup (IDE vs command line) but at the command line you could:

```

    cd cts-java
    mvn test
    mvn failsafe:integration-test

```

## Altering the run 

If you want to alter the test selection strings:

**<TODO show altering maven POM>**


When the tests are done, the TAP reports will be in the top of the `cts/target` dir, and failsafe reports will be in `target/failsafe-reports/` dir.

### Reviewing Results
After the integration tests run, see the `ctk-core/testpack/target/failsafe-reports` directory for HTML reports. Or run the `mvn site` command from the `ctk-core` directory; this will take a few minutes but then you can launch the site from `ctk-core/target/site/index.html` navigate to the Project Reports link and then the Surefire Reports link.

