/**
 * <p>The actual conformance-verifying tests.
 *</p>
 * <p>
 * These tests are normally run by the maven 'surefire' plugin, as configured
 * in the pom.xml file. They are normal JUnit4 java tests, or Spock groovy tests.
 * </p>

 * <h2>Creating Tests</h2>
 * <ul>
 * <li>name your test (following the behavior-naming model, such as 'badDatsetidShouldGet404')</li>
 * <li>annotate  it with '@Test'</li>
 * </ul>

 * <p>
 * To parameterize your test, so that it gets run in a data-driven style, you'll need to
 * have it in a class executed using @RunWith(JUnitParamsRunner.class), and then annotate
 * your test methods with @Parameters(...) - and you may want to use a
 * @see <a href="https://github.com/Pragmatists/JUnitParams">JUnitParams github site</a>
 * </p>
 * <h2>Running Tests</h2>
 * <p>
 * Created by Wayne Stidolph on 6/2/2015.
 * </p>
 */
package org.ga4gh.ctk.api;

