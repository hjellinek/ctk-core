package org.ga4gh.ctk.testsuites;

import org.ga4gh.ctk.control.testcategories.CTK.AvroTests;
import org.ga4gh.ctk.transport.avrojson.AvroMakerTest;
import org.ga4gh.ctk.transport.avrojson.JsonMakerTest;
import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Tests cosely connected to Avro behavior.
 * Created by Wayne Stidolph on 6/7/2015.
 */
@RunWith(Categories.class)
@Categories.IncludeCategory(AvroTests.class)
@Suite.SuiteClasses({AvroMakerTest.class, JsonMakerTest.class})
public class AvroTestSuite {
}
