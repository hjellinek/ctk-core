# Testing using Maven goals

You can run Maven from a command line, or from a maven runner in your build or development environments. With maven runs you will get JUnit .txt and .xml files and HTML summary files. You can also use maven to generate a complete `site` about the CTK - cross referenced source and javadoc, dependency reports on the CTK/CTS itself, and HTML reports on the most recent test execution.

> **Background**: in [Maven](https://maven.apache.org/), you run a 'goal' defined in a `pom.xml` file. Goals are implemented by `plugin`s. Each module has its own `pom.xml`,and its own plugins, and it can define which plugin 'goals' are attached to which 'phases' in the maven build lifecycles. (Maven has a handful of predefined lifecycles for things like "build a jar" and a lifecycle has phases, which may be used or vacant ... maven just executes whatever is bound to each predefined phase, in order.)
> 
> To run a maven goal, you cd into the directory holding the `pom.xml`, and enter a command which either identifies target phases in one of the maven lifecycles (`mvn clean test` or `mvn site`) or you enter a specific goal (`mvn failsafe:integration-test` runs the integration-test goal of the failsafe plugin ... maven runs all the phases to get to whatever phases that goal is bound to.)
>
The `ctk-core` module is an "aggregator" module, it takes a goal and invokes that goal on each of its submodules, then it aggregates the results of each of the submodules. It is mainly useful in running the `site` goal which tells each aggregated submodule to run its own `site` reports, then the `ctk-cre` combines those reports into a deployable "project website." We use this to create a CTK devloper-assistance site (cross-referenced source and javadoc for framework and for test code) and to include the most-recent server test report.
>
The `ctk-parent` module is a dependency management parent - the funtional modules (e.g., `transport`, `testpack`, `cts-java`) get plugin and dependency version information from the `parent` to ensure consistent information across the project. It doesn't have any independent goals to run.

If you're going to run the CTK via Maven, you'll be invoking one of three goals, in different modules:

1. `cts-java` module provides the [failsafe:integration-test](https://maven.apache.org/surefire/maven-failsafe-plugin/) goal as the primary entry point for running the tests; this goal requires you have already compiled the test source into test classes, so it won't work immediately after a `mvn clean` **TODO** set up test-compile bound to integration-test goal
1. `testpack` [spring-boot: run](http://docs.spring.io/spring-boot/docs/current/maven-plugin/run-mojo.html) is essentially equivalent to running the CTK from the command line without having the tests installed in the `lib` dir; will run the main Application class, so it's useful for testing the fraework itself
1.   `ctk-core` [site](https://maven.apache.org/plugins/maven-site-plugin/) or [failsafe:integration-test](https://maven.apache.org/surefire/maven-failsafe-plugin/)

The CTS tests are hooked into the maven "integration test" goal, not the normal "test" goal. This lets you build normal unit-style tests and run them as you want, using the maven Surefire test runner. But, the Surefire plugin in `cts-java` (where the server tests are located) is configured to ignore tests in classes with names starting or ending in "IT" - these are "Integration Tests" and will be picked up by the [Failsafe plugin](https://maven.apache.org/surefire/maven-failsafe-plugin/) when it scans the test classes directory.

So, in order to run the server (CTS) tests, you need to ensure the test class files are in place, and then run the failsafe integration-test goal. The easiest way to do this depends on your setup (IDE vs command line) but at the command line you could:

```

    cd cts-java
    mvn test
    mvn failsafe:integration-test

```

## Prerequisites

Java 8, Maven 3, [CTK source Installed](InstallingTheCTK.md)

## Altering the run 

If you want to alter the test selection strings:

**<TODO show altering maven POM>**


When the tests are done, the TAP reports will be in the top of the `cts/target` dir, and failsafe reports will be in `target/failsafe-reports/` dir.

## Reviewing Results
After the integration tests run, see the `ctk-core/testpack/target/failsafe-reports` directory for reports. Or run the `mvn site` command from the `ctk-core` directory; this will take a few minutes but then you can launch the site from `ctk-core/target/site/index.html` navigate to the Project Reports link and then the Surefire Reports link, for easily-readable HTML. (Or navigate directly to `ctk-core/target/site/GA4GH Server CTS Test Results.html`

