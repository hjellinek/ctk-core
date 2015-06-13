package org.ga4gh.ctk.systests;

import com.googlecode.junittoolbox.IncludeCategories;
import com.googlecode.junittoolbox.SuiteClasses;
import com.googlecode.junittoolbox.WildcardPatternSuite;
import org.ga4gh.ctk.control.testcategories.API.ReferencesTests;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.rules.SpringClassRule;
import org.springframework.test.context.junit4.rules.SpringMethodRule;

/**
 * <p>This suite runs the "REFERENCES" category of tests.</p>
 * <p>Uses WildcardPattermSuite runner, so use junittoolbox's {@code @IncludeCategories}
 * or {@code ExcludeCategories} if you need to customize.</p>
 * <p>If there are no tests categorized as {@code ReferencesTests} then you'll get
 * a {@code NoTestsRemainException}</p>
 * Created by Wayne Stidolph on 6/7/2015.
 */
@RunWith(WildcardPatternSuite.class)
@IncludeCategories(ReferencesTests.class)
@SuiteClasses({"**/*IT.class","**/*Test.class"})
public class ReferencesTestSuite {

    /* These first two rules setup Spring (4.2.0RC1+) injection support
       without having to adopt the SpingJUnit4ClassRunner, so we can use
       Runners such as the WildcardPatternSuite, or Parameterized, etc

       See http://docs.spring.io/spring/docs/4.2.0.RC1/spring-framework-reference/htmlsingle/#testing
       specifically Section 5.6
     */
    @ClassRule
    public static final SpringClassRule SPRING_CLASS_RULE = new SpringClassRule();

    @Rule
    public final SpringMethodRule springMethodRule = new SpringMethodRule();
}
