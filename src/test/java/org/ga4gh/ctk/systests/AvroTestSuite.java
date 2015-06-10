package org.ga4gh.ctk.systests;

import org.ga4gh.ctk.systests.transport.avrojson.AvroMakerTest;
import org.ga4gh.ctk.systests.transport.avrojson.JsonMakerTest;
import org.ga4gh.ctk.control.testcategories.CTK.AvroTests;
import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Tests closely connected to Avro behavior.
 * Created by Wayne Stidolph on 6/7/2015.
 */
@RunWith(Categories.class)
@Categories.IncludeCategory(AvroTests.class)
@Suite.SuiteClasses({AvroMakerTest.class, JsonMakerTest.class})
public class AvroTestSuite {
}
