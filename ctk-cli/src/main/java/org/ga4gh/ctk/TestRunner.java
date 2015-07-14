package org.ga4gh.ctk;

import com.google.common.collect.*;
import org.ga4gh.ctk.config.*;
import org.ga4gh.ctk.transport.*;
import org.ga4gh.ctk.transport.avrojson.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * <p>This class runs the tests; it can be invoked from the command line runner,
 * or from a server-runner.</p>
 * Created by Wayne Stidolph on 7/11/2015.
 */
@Component
public class TestRunner implements CtkLogs {
    static String SYSTEST = "TESTLOG";
    static String TRAFFICLOG=SYSTEST + ".TRAFFIC";
    private static org.slf4j.Logger trafficlog = getLogger(TRAFFICLOG);

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

    public void doTestRun() {
        // patch through config to URLMAPPING
        if (urlroot != null) {
            log.debug("Setting urlroot to " + urlroot);
            URLMAPPING.setUrlRoot(urlroot);
        }

        /* ********* TEST SELECTION ******** */

        String matchStr = props.ctk_matchstr;
        log.debug("matchStr: " + matchStr);


                    /* ****** MAIN RUN-THE-TESTS *********** */
        antExecutor.executeAntTask(props.ctk_testjar, matchStr);


        /* ******* post-Test reporting ********* */
        // ant file runs junitreporter, so those reports are done

        // just log the traffic, until I get the coverage-tests written
        for (Table.Cell<String, String, Integer> cell : AvroJson.getMessages().cellSet()) {
            trafficlog.info(cell.getRowKey() + " " + cell.getColumnKey() + " " + cell.getValue());
        }
    }

}
