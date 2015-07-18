package org.ga4gh.ctk;

import com.google.common.collect.*;
import org.ga4gh.ctk.config.*;
import org.ga4gh.ctk.transport.*;
import org.ga4gh.ctk.transport.avrojson.*;
import org.slf4j.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

/**
 * <p>This class runs the tests; it can be invoked from the command line runner,
 * or from a server-runner.</p>
 * Created by Wayne Stidolph on 7/11/2015.
 */
@Component
public class TestRunner implements CtkLogs {
    static String SYSTEST = "TESTLOG";
    static String TRAFFICLOG=SYSTEST + ".TRAFFIC";
    private static org.slf4j.Logger trafficlog = LoggerFactory.getLogger(TRAFFICLOG);

    @Autowired
    private Props props;
    public void setProps(Props props){
        this.props = props;
    }

    public void setTestExecListener(TestExecListener testExecListener) {
        this.testExecListener = testExecListener;
    }

    @Autowired
    private TestExecListener testExecListener;

    @Autowired
    private AntExecutor antExecutor;

    @Value("${ctk.tgt.urlRoot}")
    String urlroot;

    /**
     * Do test run using properties ctk.tgt.urlRoot, ctk_matchstr, ctk_testjar;
     *
     * @return the string to use as a testrun identifier.
     */
    public String doTestRun() {

        String matchStr = props.ctk_matchstr;
        CtkLogs.log.debug("matchStr: " + matchStr);

        String testRunId = doTestRun(urlroot,matchStr,props.ctk_testjar,".");
        return testRunId;
    }

    /**
     * Do test run using specific parameters.
     *
     * @param urlRoot the url root
     * @param matchStr the match str
     * @param testJar the test jar
     * @param toDir the directory to put result into (default =".")
     * @return the string to use as a testrun identifier.
     */
    public String doTestRun(String urlRoot, String matchStr, String testJar, String toDir){
        URLMAPPING urls = URLMAPPING.getInstance();
        urls.setUrlRoot(urlRoot);

        AvroJson.shouldDoComms = true; // always start from assumption of goodness!

        // is there a pattern we should enforce?
        String tgtDir =
                ((null == toDir || toDir.isEmpty()) ? "target/" : toDir);
        // TODO ensure the toDir exists, create here

                    /* ****** MAIN RUN-THE-TESTS *********** */
        antExecutor.executeAntTask(testJar, matchStr, urls, tgtDir);


        /* ******* post-Test reporting ********* */
        // ant file runs junitreporter, so those reports are done

        // just log the traffic, until I get the coverage-tests written
        for (Table.Cell<String, String, Integer> cell : AvroJson.getMessages().cellSet()) {
            trafficlog.info(cell.getRowKey() + " " + cell.getColumnKey() + " " + cell.getValue());
        }

        return toDir+"report/index.html";

    }

}
