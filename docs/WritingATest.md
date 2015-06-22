# Writing Tests

This covers the mechanics of adding tests to the `cts-java` module.

## Prerequisites
Installed Java 8 and git 1.8+; you'll find it's much easier if you are also using maven3 as your runner, so we'll assume that.

Test running requires a reachable GA4GH Server; the CTK framework assumes this is available at the URL provided by the `ctk.tgt.urlRoot` property (e.g., `http://192.168.2.115:8000/v0.5.1/`)

The CTK source installed (see [Installing The CTK](InstallingTheCTK.md))

# Test Architecture

Tests are JUnit tests - there are test classes, and in each class there are one or more test methods. The test methods are executed in an unspecified order, so the classes can (optionally) annotate methods to run `@Before` and `@After` each method to set up or tear down any test fixtures. Each test class also has a `@BeforeClass` and `@AfterClass` annotation available to distinguish a method to run once, before any tests or after all tests complete. 

Tests are grouped by "API" - e.g., the Reads, Variants, or References API. As a convention, each API gets a specific java test package, with a couple markers for test management. So, for the Reads API we have
`org.ga4gh.cts.api.reads` and in that we have a marker interfaces for the tests, and a class to bring together the ReadsTestSuite:

````

    ReadsTests.java:
    public interface ReadsTests { /* category marker */ }

    ReadsTestSuite.java:
    @RunWith(WildcardPatternSuite.class)
    @IncludeCategories({CoreTests.class, ReadsTests.class})
    @SuiteClasses({"**/*IT.class", "**/*Test.class"})
    public class ReadsTestSuite {}

````

Note that here the `ReadsTestSuite` is configured to select all the test classes with an IT or Test name suffix, and from that group to include the tests marked with the `CoreTests` or the `ReadsTests` markers. You define markers and Suites in code, to suit yourself.

Each API has a ProtocolClient class which is responsible for getting requests to the endpoints in the API and getting responses back. So, for example, there is a ReadsProtocolClient, which exposes methods such as `searchReads` taking a `GASearchReadsRequest` and returning a `GASearchReadsResponse.` A normal CTS test uses a @BeforeClass method to acquire the appropriate ProtocolClient as a class variable named 'client.'

```

    private static ReadsProtocolClient client;

    @BeforeClass
    public static void
    setupTransport() throws Exception {client = new ReadsProtocolClient();}

```

Each test class also hooks into the logging framework, with a class static:

    private static org.slf4j.Logger log = getLogger(ReadGroupSetsSearchIT.class);


When JUnit is told to run a class as a test class, it uses a "Runner" to do this; there is a default Runner, but there are alterbatives which give us varying extra capabilities ... but not all Runners have all capabilities. So, one way that test methods get grouped into different test classes is by the Runners they use. For example, the default JUnit Runner doesn't support parametrizing test methods with externally-supplied data, so we use a special runner by annotating the test class:

    @RunWith(JUnitParamsRunner.class)
    public class ReadGroupSetsSearchIT {


some text about adding JUnit @Test methods, and `MyNewTestClassIT.java` ... and advice on choosing the right JUnit Runner (default, params runner, etc). Also notes about using Spring for dependency injection if desired.

### Adding A New API Foo
Creating a new API has two major steps - creating the FooProtocolClient which communicates with the new endpoints, and creating the classes and/or interfaces that hold and control the actual tests,

#### Creating a FooProtocolClient
Yes, this could be code-gened, but it doesn't seem worth the overhead for the few clients we'll need...

The FooProtocolClient exists in the `transport` package:

- Create a new `org.ga4gh.ctk.transport.FooProtocolClient` in `transport` module, in `org.ga4gh.ctk.transport.protocols` (don't forget to add description to `package-info.java`)
- FooProtocolClient should `implements org.ga4gh.GAFooMethods`
(hint - your IDE will probably offer implement the defined methods to get messages stubbed; after you fill
these in, don't forget to create an overload method for each that takes the additional WireAssert parameter,
as you see in ReadsProtocolClient or VariantsProtocolClient)

#### Creating Infrastructure for Foo

Tests (and infrastructure) go in the **test* subtree of the `testpack` module. This is the suggested (but not mandatory) pattern:

- Add a java package `org.ga4gh.ctk.systests.api.Foo` in the **test** tree of the `testpack` module
- Add a test class `FooMethodsEndpointAliveIT.java` in that package (see examples) to verify the Foo endpoint is reachale and responsive
- optionally create marker interface for test control, in the **test** tree of `testpack` at `org.ga4gh.ctk.control.API.FooTests.java`
- optionally create `org.ga4gh.ctk.systests.FooTestSuite.java`
