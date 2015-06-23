# Writing Tests

This covers the mechanics of adding tests to the `cts-java` module.

## Prerequisites
- A reachable GA4GH Server; the CTK framework assumes this is available at the URL provided by the `ctk.tgt.urlRoot` property (e.g., `http://192.168.2.115:8000/v0.5.1/`)
- The CTK source installed (see [Installing The CTK](InstallingTheCTK.md))
- You're familiar with the [CTK Test Architecture and Conventions](TestArchAndConventions.md)

You'll find it's much easier if you are also using maven3 as your runner, so we'll assume that.

Scenarios:
- adding a test (method) to an existing TestClass
- adding a new TestClass to an existing package or protocol
- adding a new protocol

## Adding a simple test method
xxx


## Adding a new test class
- Add the class in some subpackage of `org.ga4gh.cts`, in the `cts-jav`a module. Ensure the class name either starts or ends with "IT" (e.g., `org.ga4gh.cts.api.reads.MyReadsAreBetterIT.java`
- Add the logger static
- Add the @BeforeClass to set up a protocol client, and to re-initialize the URLMAPPER

## Adding A New API: `Foo`
Creating a new API has two major steps - creating the FooProtocolClient which communicates with the new endpoints, and creating the classes and/or marker interfaces that we can use to control which tests get executed (the test-control infrastructure). Then we just write normal JUnit tests.

### Creating a FooProtocolClient
>**Design note**: this is going to be pretty much a cut/paste, but making a code-gen facility doesn't seem worth the overhead for the few clients we'll need... and concrete inheritance or even genericizing seems a bit premature for the payoff, since we won't make many ProtocolCients and we don't know that the evolving GA4GH APIs will follow the pattern we have used to date. So we'll leave these as disconnected classes for now.

The FooProtocolClient exists in the `transport` package:

- Create a new `org.ga4gh.ctk.transport.FooProtocolClient` in `transport` module, in `org.ga4gh.ctk.transport.protocols` (don't forget to add description to `package-info.java`)
- FooProtocolClient should `implements org.ga4gh.GAFooMethods`
(hint - your IDE will probably offer implement the defined methods to get messages stubbed; after you fill
these in, don't forget to create an overload method for each that takes the additional WireAssert parameter,
as you see in ReadsProtocolClient or VariantsProtocolClient)

### Creating Infrastructure for Foo

Tests (and infrastructure) go in the **`test/`** subtree of the `testpack` module. Here is the suggested (but not mandatory) pattern:

- Add a java package `org.ga4gh.ctk.systests.api.Foo` in the **test** tree of the `testpack` module
- Add a test class `FooMethodsEndpointAliveIT.java` in that package (see examples) to verify the Foo endpoint is reachable and responsive
- optionally create marker interface for test control, in the **test** tree of `testpack` at `org.ga4gh.ctk.control.API.FooTests.java`
- optionally create `org.ga4gh.ctk.systests.FooTestSuite.java`