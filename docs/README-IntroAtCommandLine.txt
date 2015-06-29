This is how to get to started running the command-line (binary) distribution of the GA4GH Conformance Test Kit.

1. Get the ga4gh-ctk-cli.zip distribution from github
(get latest ga4gh-ctk-cli.zip from https://github.com/wstidolph/ctk-core/releases)
2. Unzip the file in the directory you want to run from. This creates a "lib" and a "target" directory.
The target directory is empty (it will hold test-run results, and unpacked test classes, support jars).
The lib directory holds test classes, support jars and control files.

The CTK is runnable now (assuming your target server is running at http://localhost:8000/v0.5.1/), either
using java or using a bash wrapper script ('ctk').

If you want to use java, try
java -Dctg.tgt.urlRoot=http://localhost:8000/v0.5.1/ -jar ctk-testpack-v0.5.1-SNAPSHOT.jar

(replace with your target server URL, of course).

If you are on a bash command line, start with 'ctk -h'.

The CTK is controlled by properties - environment, system, or command-line settings all control properties
which the CTK observes.

and if your target server is OK you should see output such as:

NOTE -- CHANGING BELOW HERE DUE TO MOVE TO ANT RUNNER, DETAILS ARE VERY SUSPECT!

 [TESTLOG] 0 failed, 12 passed, 8 skipped, 1397 ms

 tests:
     [mkdir] Created dir: C:\temp\ctk\target\test-classes
     [unjar] Expanding: C:\temp\ctk\lib\cts-java-0.5.1-SNAPSHOT-tests.jar into C:\temp\ctk\target\test-classes
     [unjar] Expanding: C:\temp\ctk\ctk-testpack-0.5.1-SNAPSHOT.jar into C:\temp\ctk\target\test-classes
     [junit] Running org.ga4gh.cts.api.reads.ReadGroupSetsSearchIT
     [junit] Tests run: 3, Failures: 0, Errors: 0, Skipped: 3, Time elapsed: 0.018 sec
 ...

 reports:
     [mkdir] Created dir: C:\temp\ctk\target\report
 ...

 The first thing to note is that your test results are available in the target\report tree; there's txt, xml,
 and even html reports available there.

The next thing to note is the property being passed in directly to the CTK using command line "--<name>=<val>".
You can do this for almost any property; the exception is items which are controlled during static initialization,
like logging. So, for logging control you will need to edit a file the CTK will load early just for this purpose,
"lib/log4j2.xml"

The CTK has normal java class-oriented logging, but it also has a couple logs just for test results.
Let's turn up the data on the tests, just a bit. Edit the file lib/log4j2.xml, and look for the
TESTLOG logger ... it's on a line like this:

<Logger name="TESTLOG" level="info" additivity="false">

adjust the level to "debug" and save the file. Rerun the test, and now you see something like:

[TESTLOG] Matched classes count (can be >1 test in a class): 10
[TESTLOG] Number of testcases to execute : 29
[TESTLOG] Ignoring test case : allIdlMessagesShouldBeUsed
[TESTLOG] Ignoring test case : allIdlDatatypesShouldBeUsed
[TESTLOG] Ignoring test case : allEndpointsShouldBeUsed
[TESTLOG] Finished test case : [0] 1kg-phase1, 22, 16050408, 16052159, 16 (searchVariantsRequestResultSizeAsExpected)
...
[TESTLOG] Finished test case : propertyCanCauseTestFail
[TESTLOG] Number of testcases executed : 20
[TESTLOG] 0 failed, 12 passed, 8 skipped, 1782 ms

In that log4j2.xml file you can set up the Appenders to write to files, syslogs, network servers, etc. Check
out normal log4j2 controls (https://logging.apache.org/log4j/2.x/manual/index.html). For now, let's leave
TESTLOG at 'debug' and try failing a test. The "propertyCanCauseTestFail" test case is a dummy that
passes or fails based on a property, so let's trigger it ... we'll use a different mechanism to set that property,
the -D<name>=<val> so you can see what it looks like and that you can have multiple paths to setting a property.

java -Dcts.demofail=true -Dctg.tgt.urlRoot=http://localhost:8000/v0.5.1/ -jar ctk-testpack-v0.5.1-SNAPSHOT.jat

[TESTLOG] Matched classes count (can be >1 test in a class): 10
[TESTLOG] Number of testcases to execute : 29
[TESTLOG] Finished test case : landingPagesShouldExist
[TESTLOG] FAILED test case : expected:<[tru]e> but was:<[fals]e>
[TESTLOG] Finished test case : propertyCanCauseTestFail
[TESTLOG] ...
[TESTLOG] Finished test case : testSearchVariantsRequestEndpointAlive
[TESTLOG] Number of testcases executed : 20
[TESTLOG] 1 failed, 11 passed, 8 skipped, 1357 ms
[TESTLOG] FAIL: propertyCanCauseTestFail(org.ga4gh.cts.core.LandingPageIT): expected:<[tru]e> but was:<[fals]e>

The TESTLOG tells us:

* the name of the failing method ("propertyCanCauseTestFail")
* the name of the class that test case comes from ("org.ga4gh.cts.core.LandingPageIT")
* what assertion didn't pass ("expected:<[tru]e> but was:<[fals]e")

In a well-written test (clearly named, only one assertion per test case, and domain-specific assertions)
 this may be enough to tell us what the problem is; if you want more, you'll need to move on to using
  the CTK/CTS in one of the source/javadoc configurations (under maven or an IDE) so you can work easily
  with the test source itself.

Right now, the set of tests is small and runs quickly; but, as the test suite gets larger,
or the tests get slower, you may want to control which tests are run. Tests are selected
 primarily based on name-matching against the test class, and you can supply a property to
 be the match regex. So, the CTK/CTS also has a naming convention for tests; test classes
  end in "IT"

For example, the  test suite package includes the java package

 org.ga4gh.cts.api.reads

and in that we find:
    ReadGroupSetsSearchIT.java
    ReadMethodsEndpointAliveIT.java
    ReadsSearchIT.java
    ReadsTests.java
    ReadsTestSuite.java

The first three of these class hold tests, as "test methods" (each "test method" is an actual test case).

The other two classes are for a near-future capability that isn't quite ready for command-line use yet.
ReadsTests.java is a "marker" we use when writing a test to mark the test method as
"one of the Reads tests" ... then, ReadsTestSuite is a TestSuite that groups all of those, so
we can run the ReadsTestSuite to get a pre-defined set of tests to execute.
Since these aren't ready, we'll fall back to matching on the test name.

To run a selected test, we just match its name as a regex to the ctk.matchstr property:

 java -jar ctk-testpack-0.5.1-SNAPSHOT.jar --ctk.matchstr=.*ReadMethods.*

 or

 ctk -m ".*ReadMethods.*"

(ctk.matchstr allows a comma-separated string of regex'es but between the regex-ness and the command-line
escaping it's usually better to set anything complicated in the lib/application.properties file).

At the end of each run a set of text files that summarize the result are put into the target/ directory.
There are normal ant junitreport output (.txt, .xml, and .html).

NOTE - TAP NOT HOOKED UP TO ANT NOW
There should also be "Test Anything Protocol" (.tap) files which can be consumed by various monitoring and
notification systems. The files are named after the test class or suite that ran them,
so if you have a use for them you'll want to archive them or move them somewhere. The
CTK doesn't use these files at all, they are a pure "maybe useful" convenience.

There's a rudimentary bash script ("ctk") which will handle moving aside your existing target/ dir on successive runs
and running the CTK; you can also edit that to add property settings if you want to customize your setup.

What's Next: the maven-generated 'site' packaging generates cross-referenced/cross-linked source and test code
and javadoc in HTML, and adds in HTML test reports with links from the failre messages
 directly into that source tree. We'll have a quick on-ramp to that soon, but there
 may be enough information already avaliable in the docs on the github site