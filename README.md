# Conformance Test Kit (CTK) for a GA4GH Server
## Purpose
A Conformance Test Kit for evaluating a GA4GH Server against the data and messages defined
in the IDL of the schemas repository. CTK tests are currently written as JUnit/Java tests using a
fluent assertions library ([AssertJ](http://joel-costigliola.github.io/assertj/)) with assertions
customized to the GA4GH domain objects, like this:

```java

    public void readsResponseMatchesACTGNPattern(String rgid) throws Exception {
        // do a readsearch
        GASearchReadsRequest gsrr = GASearchReadsRequest.newBuilder()
                .setReadGroupIds(Arrays.asList(rgid))
                .build();
        GASearchReadsResponse grtn = client.searchReads(gsrr);

        for (GAReadAlignment gar : grtn.getAlignments()) {
            assertThat(gar.getAlignedSequence()).isNotNull()
                    .matches("[ACTGN]+");
```

(The design is intended to allow for other JVM test frameworks such as [Spock](https://code.google.com/p/spock/).

The CTK communicates with a running target server (it doesn't manage the target server's lifecycle). The CTK outputs:

- common [xUnit]() output text files (.txt,.xml) and .tap (for [Test Anything Protocol](https://testanything.org/) users)
- console output (including any test logs until you configure them to accumulate in files)
- HTML files of test results, linked to test source/javadoc
- HTML 'site' of contributor, dependency reports, source code, javadoc, etc


The name "CTK" refers to the test framework and transport layers.
The term "CTS" (for "Compliance Test Suite") refers to the actual server-communicating tests. These tests are in
a maven module specific to the implementationlanguage (so far, we have only "cts-java")

### Use Cases
This effort has two primary use cases:

- helping a developer **create new tests** as they develop new APIs and related server implementations: for this,
the developer uses the CTK under the Maven build tool (maven 3 and java 8). This works particularly well in an IDE
with Maven test reporting (as, for example, IntelliJ or Eclipse). See the
 [Getting Started as a test writer](##getting-started-as-a-test-writer) section below.
- helping a server developer **track against the standard APIs**: for this, we build an executable file (a java 'jar')
and a 'tests' jar file; the executable jar is controlled either from a command line or from properties files or
environment variables. The jar file includes the stable set of schema/tests, so it is easy to script as a quick
server-sanity check. This approach generates test results to log files (defaulting to console out) and returns an
exit status which indicates if all tests passed. It does not require a build tool, just java 8.

## Status
(June 17 2015) The CTK is able to execute and report on tests written in Java against the v0.5.1 schema. The collection of tests is currently small, and only attempts to use the *reads*, *references*, and *variants* endpoints.
The tests presume the server has been configured with a data set as described in the
[GA4GH API Demo instructions](http://ga4gh-reference-implementation.readthedocs.org/en/stable/demo.html). The user can generate cross-referenced
javadoc and source for the framework and for server tests but the result is default-styled and deployed on their local
machine.

## Build Status
(For building the CTK/CTS, not referrinmg to the results of a Server "integration test" run of compliance)
[![Build Status](https://travis-ci.org/wstidolph/ctk-core.svg?branch=SplitOutFramework)](https://travis-ci.org/wstidolph/ctk-core)

## Getting Started as a test writer

### Prerequisites
Installed Java 8, Maven 3, git 1.8+

### Installation

- `git clone https://github.com/wstidolph/ctk-core.git` (checkout this project)
- `cd ctk-core`
- `git submodule init` (to register the `schemas` directory as a git submodule)
- `git submodule update` (to clone the schema from git; you may want to cd into the schema directory and check out a specific branch or tag such as `git checkout v0.5.1` to develop tests against)
- `mvn clean install` (this will run the clean and package maven goals from the aggregator POM in ctk-core, which will then run those goals in the `schema`, `transport` and `testpack` modules for you; this puts the resulting artifacts into your local Maven repository. When those modules run they will pick up dependency and plugin information from `parent`)

(Temporary workaround: if you run into a compile problem with the assertion generator,
cd into the `transport` directory and run `mvn package install` directly from there.)

### Writing A Test

some text

### Configuring the CTK

Edit `testpack\src\main\resources\application.properties`

or, extract that file from the packaged jar file and have it in the dir where the jar runs from
(`jar xvf ctk-testpack-v.0.5.1-SNAPSHOT.jar application.properties`)


### Running A Test
Note about classpaths being different in running from jar-on-command-line vs maven vs in an IDE.

#### Run From Maven
cd into cts-java
`mvn failsafe:integration-test` runs the collection of all CTK tests of the target GA4GH server.

Modify the command line using Maven, or the `application.properties` file,  to alter which tests are run by default.
Modify `log4j2.xml` to alter logging behavior.

#### Run From IDE
Each test class can be run as a standalone JUnit test, each TestSuite can be run as a standalone JUnit TestSuite.

Some IDEs have a Maven runner; in this case, run the `cts-java failsafe:integration-test`
plugin goa to execute just the cts-java tests, or run the `ctk-core failsafe:integration-test` goal to execute all test
packages'

### Run From CLI
You need two jars from the build process:
- `ctk-testpack-0.5.1-SNAPSHOT.jar` (about 23MBm includes all the launcher, dependencies, etc)
- `cts-java-0.5.1-SNAPSHOT.jar` (about 3KBm is the class and resource files for the tests themselves)

The tests jars (in this case, just `cts-java-0.5.1-SNAPSHOT.jar`) go in a `lib` directory underneath the launch directory
from which you execute:
`java -jar ctk-testpack-0.5.1-SNAPSHOT.jar`

<discussion of where to put application.properties>

### Reviewing Results
After the integration tests run, see the `ctk-core\testpack\target\failsafe-reports` directory for HTML reports. Or
run the mvn site command from the top directory, launch the site from `ctk-core\target\site` and see the
 surefire reports.

### Adding a New Test

some text about adding JUnit @Test methods, and `MyNewTestClassIT.java` ... and advice on choosing the right JUnit Runner (default, params runner, etc). Also notes about using Spring for dependency injection if desired.

### Adding A New API Foo
Creating a new API has two major steps - creating the ProtocolClient which communicates with the new endpoints, and creating the classes and/or interfaces that hold and control the actual tests,
#### Creating a FooProtocolClient
The FooProtocolClient exists in the `transport` package
- Create a new `org.ga4gh.ctk.transport.FooProtocolClient` in `transport` module (don't forget to add description to `package-info.java`)
- implement FooMethods to get messages stubbed (mostly generated and repetitive code)
#### Creating Infrastructure for Foo
Tests (and infrastructure) go in the **test* subtree of the `testpack` module. This is the suggested (but not mandatory) )pattern:
- Add a java package `org.ga4gh.ctk.systests.api.Foo` in the **test** tree of the `testpack` module
- Add a test class `FooMethodsEndpointAliveIT.java` in that package (see examples) to verify the Foo endpoint is reachale and responsive
- optionally create marker interface for test control, in the **test** tree of `testpack` at `org.ga4gh.ctk.control.API.FooTests.java`
- optionally create `org.ga4gh.ctk.systests.FooTestSuite.java`

## Using The Executable Jars
some text

## Design Overview
The CTK is structured as a set of Maven modules:

- **parent** is the common dependency management POM module
- **schemas** is some fork or branch of the GA4GH [schemas](https://github.com/ga4gh/schemas) repository
- **transport** is the JSON/HTTP/Avro connection module
- **testpack** is the framework and general dependencies
- **cts-java** is the tests of the server (all in the src\test tree, treated as integration tests)
- **ctk-core** is an aggregator POM which provides common lifecycle and cross-module operations (such as building out a 'site')

