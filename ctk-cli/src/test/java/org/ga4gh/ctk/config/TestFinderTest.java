package org.ga4gh.ctk.config;

import org.junit.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.test.context.*;
import org.springframework.test.context.junit4.rules.*;

import java.util.*;

/**
 * TestFinder Tester.
 *
 * <p>Check that the TestFinder is properly selecting tests. Right now there's
 * no significant testing going on, because we don't have a mock classpath
 * set up for the Reflection library to evaluate.</p>
 *
 * @author Wayne Stidolph
 * @version 1.0
 * @since <pre>Jun 16, 2015</pre>
 */
@ContextConfiguration(classes = {TestFinder.class, Props.class})
// TestFinder needs the Props now to get the TESTPACGE to search for;
// when this test is filled out, we'll run  in a test context with test props.
public class TestFinderTest {
    @ClassRule
    public static final SpringClassRule SPRING_CLASS_RULE = new SpringClassRule();

    @Rule
    public final SpringMethodRule springMethodRule = new SpringMethodRule();

    @Autowired // let Spring give us a TestFinder to test
    TestFinder testFinder;

    Set<Class<?>> classes;

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: findTestClasses(String matchStr)
     */
    @Test
    public void findTestClassesReturnsSet() throws Exception {
        classes = testFinder.findTestClasses(".*IT..*");
        org.assertj.core.api.Assertions.assertThat(classes)
                .isNotNull();
    }


} 
