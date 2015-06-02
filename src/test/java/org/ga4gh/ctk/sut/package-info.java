/**
 * <p>The actual conformance-verifying tests.
 *</p>
 * <p>
 * These tests are normally run by the maven 'surefire' plugin, as configured
 * in the pom.xml file. They are normal JUnit4 java tests, or Spock groovy tests.
 * </p>
 * <p>
 * To create a new test:
 * <ul>
 * <li>name your test (following the behavior-naming model, such as 'badDatsetidShouldGet404')</li>
 * <li>annotate  it with '@Test'</li>
 * </ul>
 *</p>
 * <p>
 * To parameterize your test, so that it gets run in a data-driven style, you'll need to
 * have it in a class executed using @RunWith(JUnitParamsRunner.class), and then annotate
 * your test methods with @Parameters(...)
 * @see <a href="https://github.com/Pragmatists/JUnitParams">JUnitParams github site</a>
 * </p>
 * Created by Wayne Stidolph on 6/2/2015.
 */
package org.ga4gh.ctk.sut;

