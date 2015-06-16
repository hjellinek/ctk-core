package org.ga4gh.ctk;

import org.reflections.Reflections;
import org.reflections.scanners.SubTypesScanner;
import org.reflections.util.ClasspathHelper;
import org.reflections.util.ConfigurationBuilder;
import org.reflections.util.FilterBuilder;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.net.URLClassLoader;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * <p>Find test classes based on name pattern-match</p>
 * <p>Created by Wayne Stidolph on 6/15/2015.</p>
 */
@Component
public class TestFinder {
    private static org.slf4j.Logger log = getLogger(TestFinder.class);

    public String TESTPACKAGE = "org.ga4gh.ctk.systests";

    public Set<Class<?>> findTestClasses(String matchStr) {

        Collection<URL> urls = ClasspathHelper.forPackage(TESTPACKAGE);

        Reflections reflections =
                new Reflections(new ConfigurationBuilder()
                        .setUrls(urls)
                        .setScanners(new SubTypesScanner(false)) // false means do NOT exclude direct child of Object
                        .filterInputsBy(new FilterBuilder().include(matchStr))
                );

        boolean foundTests = reflections.getConfiguration().getUrls().size()>0;
        if(!foundTests){
            log.warn("No tests found on classpath, looked for classes in package: " + TESTPACKAGE);
            ClassLoader cl = Thread.currentThread().getContextClassLoader();
            URL[] allurls = ((URLClassLoader)cl).getURLs();
            for(URL url : allurls) log.info("URL " + url.toString());

            return new HashSet<Class<?>>(); // just toss back an empty set
        }

        Set<Class<? extends Object>> testClasses =
                reflections.getSubTypesOf(Object.class);

        return testClasses;
    }
}
