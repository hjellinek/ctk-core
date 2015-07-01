package org.ga4gh.ctk;

/**
 * Appropriated by Wayne Stidolph on 6/27/2015.
 */

import org.apache.tools.ant.*;
import org.ga4gh.ctk.config.*;
import org.ga4gh.ctk.transport.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import java.io.*;

/**
 * @author srccodes.com
 * @version 1.0
 */
@Component
public class AntExecutor implements CtkLogs {

    // private static org.slf4j.Logger log = getLogger(AntExecutor.class);

    @Value("${ctk.antfile}")
    private File antFile; // use direct invjection; let Spring convert the String to a File
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
        return executeAntTask(""); // invokes default target
    }

    /**
     * Execute teh tests under ant build script (runAntTests.xml)
     *
     * @param testjar tests jar to unpack/run in Ant
     */
    public boolean executeAntTask(String testjar) {

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
            project.setUserProperty("ctk.reporttitle", expandedReportTitle);
            project.addBuildListener(antExecListener);

            project.fireBuildStarted();
            project.init();
            ProjectHelper projectHelper = ProjectHelper.getProjectHelper();
            project.addReference("ant.projectHelper", projectHelper);
            projectHelper.parse(project, buildFile);
        } catch (Exception e) {
            log.warn("Exception setting up ant project based on " + antFile, e.getCause());
            e.printStackTrace();
        }


        log.debug("ctk.antlog.consolelogger is " + props.ctk_antlog_consolelogger);
        if("ON".equals(props.ctk_antlog_consolelogger)) {
            log.debug("enabling ConsoleLogger");
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
            testlog.info("Overall: " + TestExecListener.getTestReport());
        } catch (BuildException buildException) {
            project.fireBuildFinished(buildException);
            success = false;
            log.warn("Failed attempt to run " + targetToExecute + " due to " + buildException.getMessage());
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
