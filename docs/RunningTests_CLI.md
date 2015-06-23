# Testing from the command line

In this mode you are simply executing the CTS tests. The first generation CTK packages the CTS tests in a jar file which is separate from the main CTK framework jar. These two jars are named:

- `ctk-testpack-0.5.1-SNAPSHOT.jar`
- `cts-java-0.5.1-SNAPSHOT-tests.jar` 

Choose or create a directory to run the test from, and put the CTK jar there.

Create a subdirectory named `lib` and put the CTS jar there. Also, create a directory `target` for the test reports to go into. NOTE: You will not get junit .txt or .xml files from this process, as you do when running from Maven.

And, you will may want to configure the test environment, so extract the controlling properties files

- `jar xf ctk-testpack-0.5.1-SNAPSHOT.jar application.properties`
- `jar xf ctk-testpack-0.5.1-SNAPSHOT.jar log4j2.xml`
- `mv log4j2.xml lib/`

So you end up with:

```
    <launch dir>/
      | - ctk-testpack-0.5.1-SNAPSHOT.jar
      | - application.properties
      | - lib/
      |       |- cts-java-0.5.1-SNAPSHOT-tests.jar
      |       |- log4j2.xml
      | - target/

```

The simplest way to run is to simply execute all tests from the launch dir, passing in the address of your target server:

`java -jar ctk-testpack-0.5.1-SNAPSHOT.jar --ctk.tgt.urlRoot=http://myserver:8000/v0.5.1`
 
If you want to attach a debugger to the CTK, use:

    java -Xdebug -Xrunjdwp:server=y,transport=dt_socket,address=8000,suspend=n \
         -jar ctk-testpack-0.5.1-SNAPSHOT.jar

## Altering the run 

If you want to alter the test selection strings, you can do that on the command line (or using environment variables):

```

    G:\Projects\playground\temp>java -jar ctk-testpack-0.5.1-SNAPSHOT.jar --ctk.matchstr=.*ReadMethodsEndpointAliveIT.* --ctk.tgt.urlRoot=http://192.168.2.115:8000/v0.5.1/
    [TESTLOG] 4 failed, 6 passed, 0 skipped, 1068 ms
    [TESTLOG] FAIL: [0] TWO_GOOD, NOT_IMPLEMENTED (multipleReadGroupsNotSupported)(org.ga4gh.cts.api.reads.ReadMethodsEndpointAliveIT):
    ...


```

**NOTE**: 19 June 2015 there is a known problem running TestSuites (e.g., `...ReadsTestSuite): URI is not hierarchical`)

When the tests are done, the TAP reports will be in the `target/` dir.

You might want Desktop notifications about the results of these tests; check into the [ShoulderTap](https://github.com/ryandoyle/shouldertap) project

## Using the command line output

You can use `lib/log4j2.xml` to adjust logger levels, direct the output to log files, etc. With the default setting in log4j2.xml, you'll get one line of console output when the tests complete:

`[TESTLOG] 0 failed, 11 passed, 8 skipped, 1511 ms`

If any tests fail, you'll get additional failure-specific logging at a WARN level; for example (**not a real failure**):

```

    [TESTLOG] 8 failed, 3 passed, 8 skipped, 1217 ms
    [TESTLOG] FAIL: testSearchCallSetsRequestWDEndpointAlive(org.ga4gh.cts.api.variants.VariantsMethodsEndpointAliveIT): expected:<NOT_[IMPLEMENTE]D> but was:<NOT_[FOUN]D>
    [TESTLOG] FAIL: testSearchVariantsForRequestWdEndpointAlive(org.ga4gh.cts.api.variants.VariantsMethodsEndpointAliveIT):
    expected:<NOT_[IMPLEMENTE]D> but was:<NOT_[FOUN]D>
    [TESTLOG] FAIL: [0] VALID_READGROUPID (readsResponseMatchesACTGNPattern)(org.ga4gh.cts.api.reads.ReadsSearchIT): null
    [TESTLOG] FAIL: [0] TWO_GOOD, NOT_IMPLEMENTED (multipleReadGroupsNotSupported)(org.ga4gh.cts.api.reads.ReadMethodsEndpointAliveIT):
    Expecting responseStatus of: <org.ga4gh.ctk.transport.WireTracker@5c4a90b>
    to be:
    <NOT_IMPLEMENTED>
    but was:
    <NOT_FOUND>
    ...

```
