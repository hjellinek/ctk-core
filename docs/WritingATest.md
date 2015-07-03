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
- adding (and using) a domain object custom assertion
- adding (and using) a new domain Condition

## Adding a simple test method to existing test class
- name can be anything, so describe the end goal in domain terms e.g., "allSequencesShouldMatchPattern"
- annotate the method with @Test
- simplest method signature is `@Test public void <testname>() throws Exception {...}`
- use javadoc to explain the test
- if your Runner is JUnitParams, you'll need to annotate with one of the forms of @Parameter, and add the parameters to the test method signature
- use `log` to report behavior of your test class, use `testlog` to report test results if you want (other than simple pass/fail, those are automatic based on whether you fail any assertions)
- Try to structure tests as setup, action, assertion
- Usually you'll want to have just one assertion, and most commonly it will start with `org.assertj.core.api.Assertions.assertThat(*actual result*).`...; but in some cases you can fruitfully use "SoftAssertion" facility to report multiple failures in one test. More on this later! 

## Assertions, heart of the test
Motivational - see the [AssertJ website](http://joel-costigliola.github.io/assertj/), we're using Version 3.1.0 (or later) of that (and generated custom assertions for the GA4GH IDL-defined classes).

One of the key ways the CTK will be useful is as we build up libraries of domain-specific assertions and encode them in reusable Java 8 Predicates or Conditions to power the assertions. Keep this in mind as you write tests: can you extract and contribute a core Predicate or Condition?

There will be more details in [Predicates and Conditions for GA4GH](PredicatesAndConditions.md)

Although the custom Predicates and Conditions will add great reusability and conciseness over time, even as we start we have a lot of tools in the core assertions. The core begins with the org.assertj.core.api.Assertions.assertThat() method (usually you'll want to static import that, so you can just write `assertThat(...)`

The argument you pass to `assertThat` is the thing you want to make assertions about, and the machinery will look at the Java type of that argument to make sure you're calling applicable assertions on it.

Let's say you have a ...  

## Adding a new test class
- Add the class in the **`src/test/java`** tree of the `cts-java` module ... repeat, add to the TEST tree.
- Put test in some subpackage of `org.ga4gh.cts`. Ensure the class name either starts or ends with "IT" (e.g., `org.ga4gh.cts.api.reads.MyReadsAreBetterIT.java`
- Add "implements CtkLogs" (or directly establish the logger static vars, see the org.ga4gh.ctk.CtkLogs javadoc)
- Add the @BeforeClass to set up a protocol client, and to re-initialize the URLMAPPER
- `import static org.assertj.core.api.Assertions.*;`

### Choosing a TestRunner
Your test class is going to be run by a junit Runner; all themethods in teh class will be run by the same Runner. Different runners provide different capabilities, so you need to know about your possibilities, and you might need to split your tests into different test classes to run under different Runners.

You select the Runner with an @RunWith annotation at the class level (see ) The CTK-available Runners are:
- (default, no @RunWith) BlockJUnit4ClassRunner
- @RunWith(JUnitParams.class) has flexible ways to pass parameters to you test methods; see the [JUnitParams github site](https://github.com/Pragmatists/JUnitParams)
- - @RunWith(Theories.class) - not used yet, but expected soon, see [Theories javadoc](http://junit.org/apidocs/org/junit/experimental/theories/Theories.html) or the [JavaCodeGeeks writeup](http://www.javacodegeeks.com/2013/12/introduction-to-junit-theories.html)

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
