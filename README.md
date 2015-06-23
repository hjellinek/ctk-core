# Conformance Test Kit (CTK)/Compliance Test Suite (CTS) for a GA4GH Server

----------

## Purpose
A Conformance Test Kit for evaluating a GA4GH Server against the data and messages defined
in the IDL of the schemas repository. CTK tests are currently written as JUnit/Java tests using a
fluent assertions library ([AssertJ](http://joel-costigliola.github.io/assertj/)) with assertions
customized to the GA4GH domain objects, like this:

```java

	@Test
    @Parameters({{"low-coverage:HG00533.mapped.ILLUMINA.bwa.CHS.low_coverage.20120522"})
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

The CTK communicates with a running target server, but it doesn't (currently) manage the target server's lifecycle). The CTK outputs:

- common [xUnit]() output text files (.txt,.xml) and .tap (for [Test Anything Protocol](https://testanything.org/) users)
- console output (including any test logs until you configure them to accumulate in files)
- HTML files of test results, linked to test source/javadoc
- HTML 'site' of contributor, dependency reports, source code, javadoc, etc

The name "CTK" refers to the test framework and transport layers.
The term "CTS" (for "Compliance Test Suite") refers to the actual server-communicating tests. These tests are in
a maven module specific to the implementationlanguage (so far, we have only "cts-java")

(The design is intended to allow for other JVM test frameworks such as [Spock](https://code.google.com/p/spock/).

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

The CTK/CTS build status is [![Build Status](https://travis-ci.org/wstidolph/ctk-core.svg?branch=SplitOutFramework)](https://travis-ci.org/wstidolph/ctk-core)

>**This CTK defaults to using a slightly modified version of the GA4GH v0.5.1 Schema, which is not being updated; you need to point it at the Schema you care about, using standard git submodule techniques for the schema module.**

### Configuring the CTK

See [Configuring the CTK](ConfigTheCTK.md)

### Running Tests
There are three primary ways to run the CTK (jar-on-command-line vs maven vs in an IDE) and they each raise different classpath and environment issues. I hope the notes in these docs help, but each environment seems to involve some peculiarities ...

#### Run From Maven

For details see [RunningTests_maven](RunningTests_maven.md).

Short form:

- in `ctk-core`execute `mvn clean install` then
- in `cts-java` run `mvn failsafe:integration-test`

Modify the behavior using properties set in the `cts-java` maven `pom.xml`, or on the command line using `mvn -D<property=<value`, or provide the `application.properties` and/or `defaulttransport.properties` files in  to alter which tests are run by default.

To alter logging behavior: modify `log4j2.xml` in source/test for a build/run launch in your IDE or in maven, or modify `lib/log4j2.xml` for a command-line launch.


#### Run From IDE
Each test class can be run as a standalone JUnit test, each TestSuite can be run as a standalone JUnit TestSuite. Some IDEs provide a dedicated JUnit runner to execute and report on the tests, and include support features like "re-run failed tests."

### Run From CLI
You need two jars from the build process:
- `ctk-testpack-0.5.1-SNAPSHOT.jar` (about 23MBm includes all the launcher, dependencies, etc)
- `cts-java-0.5.1-SNAPSHOT.jar` (about 3KBm is the class and resource files for the tests themselves)

The tests jars (in this case, just `cts-java-0.5.1-SNAPSHOT.jar`) go in a `lib` directory underneath the launch directory
from which you execute:
`java -jar ctk-testpack-0.5.1-SNAPSHOT.jar`

For details, see [RunningTests_CLI](RunningTests_CLI.md)


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

