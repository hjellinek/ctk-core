package org.ga4gh.ctk.config;

import org.reflections.*;
import org.reflections.scanners.*;
import org.reflections.util.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import java.net.*;
import java.util.*;

import static org.slf4j.LoggerFactory.*;

/**
 * <p>Find test classes based on name pattern-match</p>
 * <p>Created by Wayne Stidolph on 6/15/2015.</p>
 */
@Component
public class TestFinder {
    private static org.slf4j.Logger log = getLogger(TestFinder.class);

    @Autowired
    private Props props;
    public void setProps(Props props) {
        this.props = props;
    }

    public Set<Class<?>> findTestClasses(String matchStr) {
        String TESTPACKAGE = props.ctk_testpackage; // "org.ga4gh.ctk.systests";//
        Collection<URL> urls = ClasspathHelper.forPackage(TESTPACKAGE);

        Reflections reflections =
                new Reflections(new ConfigurationBuilder()
                        .setUrls(urls)
                        .setScanners(new SubTypesScanner(false)) // false means do NOT exclude direct child of Object
                        .filterInputsBy(new FilterBuilder().include(matchStr))
                );

        boolean foundTests = reflections.getConfiguration().getUrls().size() > 0;
        if (!foundTests) {
            log.warn("No tests found on classpath, looked for classes in package: " + TESTPACKAGE);
            ClassLoader cl = Thread.currentThread().getContextClassLoader();
            URL[] allurls = ((URLClassLoader) cl).getURLs();
            for (URL url : allurls) log.info("URL " + url.toString());

            return new HashSet<>(); // just toss back an empty set
        }

        Set<Class<? extends Object>> testClasses =
                reflections.getSubTypesOf(Object.class);

        return testClasses;
    }
}
