# Configuring the CTK

The CTK is controlled through properties to set up the target server information, and to control the test finding/selection mechanism. Logging is controlled by a standard log4j2.xml file.

You configure the CTK via the properties used by the:

- `transport` module to control target server URLS (see `/transport/src/main/resources/defaulttransport.properties/`
- `testpack` module to control:
	- test selection and some infrequently-changed items general operation (loader paths etc) (see `/testpack/src/main/resources/application.properties`)
	- logging behavior (see `/testpack/src/main/resources/log4j2.xml`)
- `cts-java` has its own copy of `defaulttransport.properties` to support running stand-alone tests under IDEs, this is still experimental and may be removed.


If you're working with CTK/CTS source (in an IDE or for a maven build) it's easiest to just edit `testpack/src/main/resources/application.properties` and `testpack/src/main/resources/application.properties` but these changes will have no effect until you rebuild. But, you can make temporary changes to the text properties files directly in the output build tree.

If you're working with the CTK/CTS at the command line, you can extract that file from the packaged jar file and have it in the dir where the jar runs from
(`jar xvf ctk-testpack-v.0.5.1-SNAPSHOT.jar application.properties`)

Note that individual test suites (`cts-java` etc) might have individual configuration mechanisms or properties files - refer to their documentation.

## Configuring Logging

The logging subsystem is provided by `log4j2.xml`, so the [Apache Documentation](https://logging.apache.org/log4j/2.x/manual/configuration.html) applies. In a build or development environment it is easy to edit the default log4j2.xml file (`testpack/src/main/resources/log4j2.xml`) before you recompile, or to directly edit the log4j2.xml file in your build classes tree if you want to make temporary changes that affect logging without having to recompile/repackage; in a command-line environment you can override the default at runtime by putting a replacement file in the `lib/` dir (see  [RunningTests_CLI](RunningTests_CLI.md)).

The CTK logs to loggers configured by the log-using class' name (e.g., the class `org.ga4gh.ctk.transport.AvroJson` would log to a logger named "org.ga4gh,ctk.transport.AvroJson").

The CTK also sends test-specific data to special logs so you can redirect that output to test-specific logs:

- `TESTLOG` gets basic test information (how many tests ran, what were the test selection criteria, how long the test session took, etc); most of this data is at "info" level, but any test failures are logged at "warn" level.
- `TESTLOG.TRAFFIC` gets information intended to support easy post-test session analysis of the coverage of the test run based on the traffic exchanged with the target server: what was sent, and type of object was received (not the entire body, just the data type), and what status was reported.

## What Properties exist

The Properties list is available by looking at the javadoc for the `transport/src/main/java/org.ga4gh/ctk/config/Props.java` class. 

> **NOTE**: The target server endpoints are controlled by a class `transport/src/main/java/org/ga4gh/ctk/transport/URLMAPPING.java` which loads the target server URL from the `ctk.tgt.urlRoot` property, which is set in the `transport/src/main/resources/defaulttransport.properties` file and can be overriden by replacing the properties file or with an external config element like an environment variable or on a command line.

## How a property is set
Properties can be set on the command line, from a properties file (in various locations), or from environment variables. The mechanism is provided by Spring, so all the alternatives described in Spring documentation on [Externalized Configuration](http://docs.spring.io/spring-boot/docs/current/reference/html/boot-features-external-config.html) are available. The important mechanisms for the CTS, in order of descending priority, are:

1. Command line arguments (anything starting with "--", so `--ctk.testpackage=...` will set the variable "`ctk.testpackage`)
1. OS environment variables
1. Application properties files outside of the packaged jar (`application.properties` and YAML variants); the highest priority would be a /config subdir of the current directory, and next would be in the current directory when the test is launched. (The Spring documentation describes other locations, and even ways to change the properties files names if you want.) 
1. Application properties packaged inside the jar to provide defaults (`application.properties` and YAML variants).

The easiest technique depends on whether you're using the CTK from a development environment, from Maven, or from a command line (the executable jar file). 

### Configuring in an IDE

xxx

### Configuring Maven


To set properties as a command line variable (the highest priority) for a maven invocation

### Configuring a Command Line invocation
In the directory where the executable jar is, run

`jar xvf application.properties`

to extract the default application.properties file. Edit it, and leave it in the launch directory or put it in a `config` subdirectory.

## How a property is accessed

 The properties are read in at test launch and used to set fields on the Java object at `transport/src/main/java/org.ga4gh/ctk/config/Props.java` and this Props object is then used as the run-time source of property values. The Props object has a field (with a setter) for each property, and these fields are set by the Spring framework's @Value annotation; e.g., the property named "ctk.testpackage" is injected as:

```java

    @Value("${ctk.testpackage}")
    public String ctk_testpackage;

```

This pattern allows an IDE do auto-complete on the properties.

Edit `testpack/src/main/resources/application.properties`

or, extract that file from the packaged jar file and have it in the dir where the jar runs from
(`jar xvf ctk-testpack-v.0.5.1-SNAPSHOT.jar application.properties`)