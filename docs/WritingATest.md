# Writing Tests

This covers the mechanics of adding tests to the `cts-java` module.

## Prerequisites
Installed Java 8 and git 1.8+; you'll find it's much easier if you are also using maven3 as your runner, so we'll assume that.

Test running requires a reachable GA4GH Server; the CTK framework assumes this is available at the URL provided by the `ctk.tgt.urlRoot` property (e.g., `http://192.168.2.115:8000/v0.5.1/`)

The CTK source installed (see [Installing The CTK](InstallingTheCTK.md))

We assume you're familiar with the [CTK Test Architecture and Conventions](TestArchAndConventions.md)


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
