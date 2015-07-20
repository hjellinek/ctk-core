package org.ga4gh.ctk.server;

import org.ga4gh.ctk.*;
import org.ga4gh.ctk.config.*;
import org.ga4gh.ctk.transport.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.*;
import org.springframework.web.servlet.view.*;

import java.io.*;
import java.net.*;
import java.nio.file.*;
import java.util.concurrent.*;

/**
 * Created by Wayne Stidolph on 7/15/2015.
 */
@Controller
@RequestMapping("/servertest")
public class ServerTestController implements CtkLogs {

    @Autowired
    private TestRunner testrunner;

    public void setTestrunner(TestRunner testrunner) {
        this.testrunner = testrunner;
    }

    @Autowired
    public Props props;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView runTests(@RequestParam(value = "urlRoot", required = false) String urlRoot,
                                 @RequestParam(value = "matchstr", required = false) String mstr) {
        if (urlRoot == null)
            urlRoot = URLMAPPING.getInstance().getUrlRoot();
        if (mstr == null)
            mstr = props.ctk_matchstr;
        String resultsDir = getResultsDir(urlRoot);
        if (!resultsDir.isEmpty()) {
            // we have a place to put results
            log.info("about to run tests " + urlRoot + " " + mstr + " " + props.ctk_testjar);
            Future<String> futureTestResultIndexPage =
                    testrunner.doTestRun(urlRoot, mstr, props.ctk_testjar, resultsDir);
            String testResultIndexPage = null;
            try { // wait for results
                testResultIndexPage = futureTestResultIndexPage.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
            log.info("test complete, results to " + testResultIndexPage);

            // TODO check for empty testResultsIndexPage, if so return error (need error page)
            // see http://docs.spring.io/spring/docs/current/javadoc-api/org/springframework/web/servlet/view/RedirectView.html
            return new ModelAndView(new RedirectView(testResultIndexPage,
                    true, // redirect is context-relative
                    false)); // don't bother staying http 1.0 compatible
        }
        return new ModelAndView("Couldn't build results dir for " + urlRoot);
    }

    /**
     * <p>Get results dir.</p>
     * <p>Results fo in a directory named after the target server,
     * and each result goes in its own directory. The result directory is
     * just named with an integer, so we have, for example,
     * testresults/192.168.2.214_8000/1, testresults/192.168.2.214:8000/2, ...</p>
     *
     *
     * @param urlRoot the target server's url root
     * @return the string name for the just-created target directory
     */
    synchronized String getResultsDir(String urlRoot) {
        // we could cut down the synchronized size a lot, or even
        // do a temp dir and just rebame it when done, but no need yet
        String resultsbase = "testresults/"; // TODO move to property
        File resultDir = null;
        URL tgt;
        try {
            tgt = new URL(urlRoot);
        } catch (MalformedURLException e) {
            log.warn("Malformed urlRoot " + urlRoot);
            return "";
        }
        int maxseen = 0;
        Path dir = Paths.get(resultsbase + tgt.getAuthority().replace(":", "_"));
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(dir)) {
            for (Path path : stream) {
                log.trace("testing file named " + path.getFileName());
                String name = path.getName(path.getNameCount() - 1).toString();
                try {
                    int thisDir = Integer.parseInt(name);
                    if (thisDir > maxseen && path.toFile().isDirectory())
                        maxseen = thisDir;
                } catch (Exception e) {
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        String paddedMax = String.format("%05d", maxseen+1);
        String tgtdir = dir.toString() + "/" + paddedMax + "/";
        new File(tgtdir).mkdir();
        log.debug("calculated test results dir of " + tgtdir);
        return tgtdir;
    }
}