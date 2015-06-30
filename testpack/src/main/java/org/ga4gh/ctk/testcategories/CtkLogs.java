package org.ga4gh.ctk.testcategories;

import static org.slf4j.LoggerFactory.*;

/**
 * <p>Utility interface to bring in the loggers.</p>
 * <p>If you "implements CtkLogs" then your class gets the
 * defaut 'log' and 'test' log to work with, saving you
 * a bit of typeing and increasing likelihood of using
 * consistent logger names. Recommended for integration
 * tests, but migt be a little slow for super lightweight
 * tests in a loop (getting a stacktrace isn't quick); if
 * you want to go faster or avoid inherited-method magic,
 * just use: </p>
 * <pre>
 * {@code
 *    static org.slf4j.Logger testlog = getLogger("TESTLOG");
 *    static org.slf4j.Logger log = getLogger(<myclass>.class);
 * }
 * </pre>
 * <p>Created by Wayne Stidolph on 6/29/2015.</p>
 */
public interface CtkLogs {
    static org.slf4j.Logger testlog = getLogger("TESTLOG");
    static org.slf4j.Logger log = getLogger(Thread.currentThread().getStackTrace()[1].getClassName());
}
