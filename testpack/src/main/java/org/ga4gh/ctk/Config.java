package org.ga4gh.ctk;

import org.springframework.context.annotation.Configuration;

/**
 * <p>Configuration entry point for the runtime environment.</p>
 * <p>This class collects the config values supplied via Spring's
 * normal configuration precedence order:</p>
 * <ul>
 * <li>command line arguments (anything starting with double-dash,
 * e.g., --server.url=192.168.2.115:8000 creates or overrides a
 * property 'server.url)</li>
 * <li>NDI attributes from java:comp/env</li>
 * <li>Java System properties (System.getProperties())</li>
 * <li>OS environment variables</li>
 * <li>A RandomValuePropertySource that only has properties in random.*</li>
 * <li>Profile-specific application properties outside of the packaged jar
 * (application-{profile}.properties and YAML variants</li>
 * <li>Profile-specific application properties packaged inside the jar
 * (application-{profile}.properties and YAML variants)</li>
 * <li>Application properties outside of your packaged jar
 * (application.properties and YAML variants)</li>
 * <li>Application properties packaged inside your jar
 * (application.properties and YAML variants)</li>
 * <li>@PropertySource annotations on @Configuration classes (such as this class)</li>
 * <li>Default properties (specified using SpringApplication.setDefaultProperties)</li>
 * </ul>
 *
 * <p>YAML files seem to take precedence over .properties files of the same name.</p>
 * <p>Profiles used in the CTK:</p>
 * <ul><li>none so far</li></ul>
 * <p>Created by Wayne Stidolph on 6/13/2015.</p>
 */
@Configuration
public class Config {
}
