package org.ga4gh.ctk.systests;

import org.ga4gh.ctk.control.testcategories.CTK.TransportTests;
import org.ga4gh.ctk.systests.transport.avrojson.AvroMakerTest;
import org.ga4gh.ctk.systests.transport.avrojson.JsonMakerTest;
import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Created by Wayne Stidolph on 6/7/2015.
 */
@RunWith(Categories.class)
@Categories.IncludeCategory(TransportTests.class)
@Suite.SuiteClasses({AvroMakerTest.class, JsonMakerTest.class})
public class TransportTestSuite {
}
