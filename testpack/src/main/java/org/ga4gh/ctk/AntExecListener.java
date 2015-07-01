package org.ga4gh.ctk;

import org.apache.tools.ant.*;

/**
 * <p>Bridge ant-generated events to CTK logs</p>
 *
 * <p>Created by Wayne Stidolph on 6/30/2015.</p>
 */
public class AntExecListener implements BuildListener, CtkLogs {
    /**
     * Signals that a build has started. This event
     * is fired before any targets have started.
     * <p>
     * <p>This event is fired before the project instance is fully
     * configured.  In particular no properties have been set and the
     * project may not know its name or default target, yet.</p>
     *
     * @param event An event with any relevant extra information.
     *              Must not be <code>null</code>.
     */
    @Override
    public void buildStarted(BuildEvent event) {
        testlog.debug(eventToString(event) + " ant build start");
        log.info(eventToString(event)+ " ant build start");
    }

    /**
     * Signals that the last target has finished. This event
     * will still be fired if an error occurred during the build.
     *
     * @param event An event with any relevant extra information.
     *              Must not be <code>null</code>.
     * @see BuildEvent#getException()
     */
    @Override
    public void buildFinished(BuildEvent event) {
        testlog.debug(eventToString(event) + " ant build finish");
        log.info(eventToString(event)+ " ant build finish");
    }

    /**
     * Signals that a target is starting.
     *
     * @param event An event with any relevant extra information.
     *              Must not be <code>null</code>.
     * @see BuildEvent#getTarget()
     */
    @Override
    public void targetStarted(BuildEvent event) {
        log.trace(eventToString(event)+ " ant target start");

    }

    /**
     * Signals that a target has finished. This event will
     * still be fired if an error occurred during the build.
     *
     * @param event An event with any relevant extra information.
     *              Must not be <code>null</code>.
     * @see BuildEvent#getException()
     */
    @Override
    public void targetFinished(BuildEvent event) {
        log.trace(eventToString(event)+ " ant target finish");

    }

    /**
     * Signals that a task is starting.
     *
     * @param event An event with any relevant extra information.
     *              Must not be <code>null</code>.
     * @see BuildEvent#getTask()
     */
    @Override
    public void taskStarted(BuildEvent event) {
        log.trace(eventToString(event)+ " ant task start");

    }

    /**
     * Signals that a task has finished. This event will still
     * be fired if an error occurred during the build.
     *
     * @param event An event with any relevant extra information.
     *              Must not be <code>null</code>.
     * @see BuildEvent#getException()
     */
    @Override
    public void taskFinished(BuildEvent event) {
        log.trace(eventToString(event)+ " ant task finish");

    }

    /**
     * Signals a message logging event.
     *
     * @param event An event with any relevant extra information.
     *              Must not be <code>null</code>.
     * @see BuildEvent#getMessage()
     * @see BuildEvent#getException()
     * @see BuildEvent#getPriority()
     */
    @Override
    public void messageLogged(BuildEvent event) {
        switch (event.getPriority()){
            case Project.MSG_VERBOSE:
                log.trace(eventToString(event) + " msg: " + event.getMessage());
                break;
            case Project.MSG_DEBUG:
                log.debug(eventToString(event) + " msg: " + event.getMessage());
                break;
            case Project.MSG_INFO:
                log.info(eventToString(event) + " msg: " + event.getMessage());
                break;
            case Project.MSG_ERR:
                log.error(eventToString(event) + " msg: " + event.getMessage());
                testlog.error(eventToString(event) + " msg: " + event.getMessage());
                break;
            case Project.MSG_WARN:
                log.warn(eventToString(event) + " msg: " + event.getMessage());
                testlog.warn(eventToString(event) + " msg: " + event.getMessage());
                break;
        }
    }

    private String eventToString(BuildEvent event){
        if(event == null) return "[null] [null]";

        String tgtName = event.getTarget() != null? event.getTarget().getName() : "null";
        String taskName = event.getTask() != null ? event.getTask().getTaskName() : "null";
        return String.format("task [%s] tgt [%s]",taskName,tgtName );
    }
}
