package org.ga4gh.ctk;

/**
 * Appropriated by Wayne Stidolph on 6/27/2015.
 */

import org.apache.tools.ant.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import java.io.*;

import static org.slf4j.LoggerFactory.*;

/**
 * @author srccodes.com
 * @version 1.0
 */
@Component
public class AntExecutor {

    private static org.slf4j.Logger log = getLogger(AntExecutor.class);

    @Value("${ctk.antfile}")
    private File antFile;
    public void setAntfile(File theFile){
        antFile = theFile;
    }

    /**
     * To execute the default target specified in the Ant build.xml file
     *
     */
    public boolean executeAntTask() {
        return executeAntTask(""); // invokes default target
    }

    /**
     * To execute a target specified in the Ant build.xml file
     *
     * @param target
     */
    public boolean executeAntTask(String target) {

        boolean success = false;
        DefaultLogger consoleLogger = getConsoleLogger();

        // Prepare Ant project
        Project project = new Project();
        InputStream buildInputStream;
        try {
            File buildFile = antFile;
            project.setUserProperty("ant.file", buildFile.getName());
            project.fireBuildStarted();
            project.init();
            ProjectHelper projectHelper = ProjectHelper.getProjectHelper();
            project.addReference("ant.projectHelper", projectHelper);
            projectHelper.parse(project, buildFile);
        } catch (Exception e) {
            log.warn("Exception setting up ant project based on " + antFile, e.getCause());
            e.printStackTrace();
        }

        project.addBuildListener(consoleLogger);
        String targetToExecute = "";

        // Capture event for Ant script build start / stop / failure
        try {

            // If no target specified then default target will be executed.
            targetToExecute = (target != null && target.trim().length() > 0) ? target.trim() : project.getDefaultTarget();
            project.executeTarget(targetToExecute);
            project.fireBuildFinished(null);
        } catch (BuildException buildException) {
            project.fireBuildFinished(buildException);
            success = false;
            log.warn("Failed attempt to run " + targetToExecute + " due to " + buildException.getMessage());
        }

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
