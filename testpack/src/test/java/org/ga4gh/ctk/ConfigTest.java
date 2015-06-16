package org.ga4gh.ctk;

import org.junit.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.rules.SpringClassRule;
import org.springframework.test.context.junit4.rules.SpringMethodRule;

import static org.assertj.core.api.Assertions.*;

/**
 * Config Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>Jun 16, 2015</pre>
 */
@SpringApplicationConfiguration(classes = Application.class)
public class ConfigTest {

    // These two Rules (new in Spring 4.2) let us use Spring facilities in a test
    // without using the Spring-specific SpringJUnit4ClassRunner
    @ClassRule
    public static final SpringClassRule SPRING_CLASS_RULE = new SpringClassRule();

    @Rule
    public final SpringMethodRule springMethodRule = new SpringMethodRule();

    @Autowired
    Config config;

    public void setConfig(Config cfg) {
        config = cfg;
    }

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: setTestproperty(String testproperty)
     */
    @Test
    public void testSetTestproperty() throws Exception {
//TODO: Test goes here... 
    }

    @Value("${ctk.testproperty")
    String theprop;

    /**
     * Method: getTestproperty()
     */
    @Test
    public void testGetTestproperty() throws Exception {

        assertThat(config).isNotNull();
        assertThat(theprop).isNotNull();

    }

    @Test
    public void toStringIsUseful() throws Exception {
        String tostr = config.toString();
        assertThat(tostr).isNotEmpty();
    }


} 
