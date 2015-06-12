package org.ga4gh.ctk.systests;

import com.googlecode.junittoolbox.IncludeCategories;
import com.googlecode.junittoolbox.SuiteClasses;
import com.googlecode.junittoolbox.WildcardPatternSuite;
import org.ga4gh.ctk.control.testcategories.API.ReadsTests;
import org.ga4gh.ctk.control.testcategories.CoreTests;
import org.junit.runner.RunWith;



/**
 * <p>This suite runs the "READS" category of tests.</p>
 * <p>Uses WildcardPattermSuite runner, so use junittoolbox's {@code @IncludeCategories}
 * or {@code ExcludeCategories} if you need to customize.</p>
 * <p>If there are no tests categorized as {@code ReadsTests} then you'll get
 * a {@code NoTestsRemainException}</p>* Created by Wayne Stidolph on 6/7/2015.
 */
@RunWith(WildcardPatternSuite.class)
@IncludeCategories({CoreTests.class, ReadsTests.class})
@SuiteClasses({"**/*IT.class", "**/*Test.class"})
public class ReadsTestSuite {
}
