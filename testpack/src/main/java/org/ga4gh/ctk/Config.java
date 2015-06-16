package org.ga4gh.ctk;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

/**
 * <p>Configuration entry point for the runtime environment.</p>
 * <p>This class collects the config values supplied via Spring's
 * normal configuration precedence order:</p>
 * <ul>
 * <li>command line arguments (anything starting with double-dash,
 * e.g., --server.url=192.168.2.115:8000 creates or overrides a
 * property 'server.url)</li>
 * <li>NDI attributes from java:comp/env</li>
 * <li>JVM System properties (System.getProperties())</li>
 * <li>OS environment variables</li>
 * <li>A RandomValuePropertySource that only has properties in random.*</li>
 * <li>Profile-specific application properties outside of the packaged jar
 * (application-{profile}.properties and YAML variants</li>
 * <li>Profile-specific application properties packaged inside the jar
 * (application-{profile}.properties and YAML variants)</li>
 * <li>Application properties outside of the jars
 * (application.properties and YAML variants)</li>
 * <li>Application properties packaged inside the jars
 * (application.properties and YAML variants)</li>
 * <li>@PropertySource annotations on @Configuration classes (such as this class)</li>
 * <li>Default properties (specified using SpringApplication.setDefaultProperties)</li>
 * </ul>
 *
 * <p>Property/YAML files can be in 4 locations:</p>
 * <ul>
 *     <li>(highest priority) externally, in the {@code /config} directory under the app's start dir</li>
 *     <li>externally, directly in the app's start dir</li>
 *     <li>internally, in the /config package (not used in the CTK)</li>
 *     <li>(lowest priority) internally at the root of the classpath (from the "resources/" dir in the source tree)</li>
 * </ul>
 *
 * <p>YAML files seem to take precedence over .properties files of the same name.</p>
 * <p>Profiles used in the CTK:</p>
 * <ul><li>none so far</li></ul>
 * <p>Created by Wayne Stidolph on 6/13/2015.</p>
 */
@Configuration
@EnableAutoConfiguration
@ConfigurationProperties(prefix="ctk")
@Data
public class Config {
    @Value("${ctk.testproperty}")
    private String testproperty;

    // NOTE getters and setters are provided for us by Lombok

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer(){
        return new PropertySourcesPlaceholderConfigurer();
    }
}
