package org.ga4gh.ctk;

/**
 * <p>Executes ant to run junit tests from command line.</p>
 * <p>Created by Wayne Stidolph on 6/27/2015.</p>
 */

import org.apache.tools.ant.*;
import org.ga4gh.ctk.config.*;
import org.ga4gh.ctk.transport.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import java.io.*;

/**
 * <p>This class executes ant (ver 1.9.5 in the initial CTK) to do
 * junit testing controlled by an <a href="http://ant.apache.org/">Apache Ant</a> file.</p>
 * <p>This class is affected bt these properties (details below)</p>
 * <ul>
 *     <li>ctk.antfile</li>
 *     <li>ctk.testjar</li>
 *     <li>ctk.matchstr</li>
 *     <li>ctk.reporttitle</li>
 *     <li>ctk.antlog.clearstats</li>
 *     <li>ctk.antlog.consolelogger</li>
 * </ul>
 * <p>The ant file is set by the "ctk.antfile" property - normally it is the "lib/antRunTests.xml" file</p>
 * <p>The antfile is expected to do two main tasks:</p>
 * <ul>
 *     <li>&lt;junit> runs junit to execute tests (methods annotated with @Test) from test classes
 *     (classes selected a name regex-match from a test-classes jar; this junit task creates
 *     .xml and .txt. output files in the "target/" directory</li>
 *     <li>&lt;junitreport> evaluates the <junit> *.xml results and creates an HTML
 *     version in "target/report/html" tree</li>
 * </ul>
 * <p>This class sets properties to pass into the ant execution:
 * <ul>
 *     <li>"ctk.testjar" sets what jar to look inside for classes as candidate tests</li>
 *     <li>"ctk.matchstr" sets the pattern(s) to use to select tests by name, from the candidates</li>
 *     <li>"ctk.reporttitle" sets a header title prefix on the ant HTML reports</li>
 * </ul>
 * <p>The class starts
 * from the "ctk.matchstr" property, splits it on commas, and loops over the split-out
 * values passing each into the ant task as a separate ant run. (So, multiple comma-
 * separated values in ctk.matchstr cause multiple ant executions and independent reports)</p>
 * <p>As ant runs, it emits "build event" notices - that the run has started, or finished, etc. This
 * class attaches an {@link AntExecListener} to map those events into the application logs</p>
 * <p>The antfile's junit task also creates and attaches a {@link TestExecListener} to catch
 * the messages generated by the junit ant task (test starting, finishing, count of tests, time, etc)
 * and to put them each into the logging system; the TestExecListener also accumulates the totals. Then,
 * at the end of the run, this class reads out the totals and logs the "Overall" report.</p>
 * <p>This class can optionally clear the statistics accumulated by that TestExecListener. Whether
 * or not to clear between runs is controlled by the "ctk.antlog.clearstats" property ("ON" means
 * clear teh stats, anything else means don't clear the stats).</p>
 * <p>As ant runs, any task in the antfile might emit message to the ant notification system; those
 * are caught and routed into the logging system as described earlier, but this class also enables
 * attaching the a ConsoleLogger to catch these non-test messages, and simply routes them
 * to stdout and stderr for you to see or re-route. Whether to attach or not attache the
 * ConsoleLogger is controlled by the "ctk.antlog.consolelogger" property ("ON" means attach,
 * anything else means to not attach.)</p>
 * @author srccodes.com
 * @version 1.0
 */
@Component
public class AntExecutor implements CtkLogs {

    // private static org.slf4j.Logger log = getLogger(AntExecutor.class);

    @Value("${ctk.antfile}")
    private File antFile; // use direct injection; let Spring convert the String to a File
    public void setAntfile(File theFile){
        antFile = theFile;
    }

    @Autowired
    private Props props;
    public void setProps(Props props){
        this.props = props;
    }


    /**
     * To execute the default target specified in the Ant antRunTests.xml file
     *
     */
    public boolean executeAntTask() {
        return executeAntTask(props.ctk_testjar,props.ctk_matchstr);
    }

    /**
     * Execute the tests under ant build script (runAntTests.xml)
     *
     * @param testjar tests jar to unpack/run in Ant
     */
    public boolean executeAntTask(String testjar, String matchstr) {

        String expandedReportTitle = props.ctk_report_title + " " + URLMAPPING.getUrlRoot();

        boolean success = false;
        DefaultLogger consoleLogger = getConsoleLogger();
        AntExecListener antExecListener = new AntExecListener();
        // Prepare Ant project
        Project project = new Project();
        try {
            File buildFile = antFile;
            project.setUserProperty("ant.file", buildFile.getName());
            project.setUserProperty("ctk.testjar", testjar);
            project.setUserProperty("ctk.matchstr", matchstr);
            project.setUserProperty("ctk.reporttitle", expandedReportTitle);
            project.addBuildListener(antExecListener);

            project.fireBuildStarted();
            project.init();
            ProjectHelper projectHelper = ProjectHelper.getProjectHelper();
            project.addReference("ant.projectHelper", projectHelper);
            projectHelper.parse(project, buildFile);
        } catch (Exception e) {
            CtkLogs.log.warn("Exception setting up ant project based on " + antFile, e.getCause());
            e.printStackTrace();
        }


        CtkLogs.log.debug("ctk.antlog.consolelogger is " + props.ctk_antlog_consolelogger);
        if("ON".equals(props.ctk_antlog_consolelogger)) {
            CtkLogs.log.debug("enabling ConsoleLogger");
            project.addBuildListener(consoleLogger);
        }
        String targetToExecute = "";

        // Capture event for Ant script build start / stop / failure
        try {

            // If no target specified then default target will be executed.
           // targetToExecute = (target != null && target.trim().length() > 0) ? target.trim() : project.getDefaultTarget();
            targetToExecute = project.getDefaultTarget();
            project.executeTarget(targetToExecute);
            project.fireBuildFinished(null);
            CtkLogs.testlog.info("Overall: " + TestExecListener.getTestReport());
        } catch (BuildException buildException) {
            project.fireBuildFinished(buildException);
            success = false;
            CtkLogs.log.warn("Failed attempt to run " + targetToExecute + " due to " + buildException.getMessage());
        }
        if ("ON".equals(props.ctk_antlog_clearstats))
            TestExecListener.resetStats(); // these are static fields which accumulate results

        return success;
    }

    /**
     * Logger to log output generated while executing ant script in console
     *
     * @return
     */
    private DefaultLogger getConsoleLogger() {

        DefaultLogger consoleLogger = new DefaultLogger();
        consoleLogger.setErrorPrintStream(System.err);
        consoleLogger.setOutputPrintStream(System.out);
        consoleLogger.setMessageOutputLevel(Project.MSG_INFO);

        return consoleLogger;
    }
}