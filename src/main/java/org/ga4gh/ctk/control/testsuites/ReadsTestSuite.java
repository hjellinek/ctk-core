package org.ga4gh.ctk.control.testsuites;

import org.ga4gh.ctk.control.testcategories.API.ReadsTests;
import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * This suite runs the "READS" category of tests.
 * Use @IncludeCategory, @ExcludeCategory, or {list} of SuiteClasses to customize.
 * Created by Wayne Stidolph on 6/7/2015.
 */
@RunWith(Categories.class)
@Suite.SuiteClasses(ReadsTests.class)
public class ReadsTestSuite {
}
