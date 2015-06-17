package org.ga4gh.ctk.config;

import lombok.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.*;
import org.springframework.context.annotation.*;
import org.springframework.context.support.*;
import org.springframework.stereotype.*;

/**
 * <p>Access to runtime environment properties.</p>
 * <p>This class uses Spring @Value injection to get properties from the runtime
 * environment into simple strings bound to the class; the instance can then be
 * injected (by Spring) into ojects that want these control variables.</p>
 *
 * <p>To use the Props class, just inject it into your class, perhaps using a setter:</p>
 * <pre>
 * {@code
 *    &#64;Autowired
 *     Props props;
 *     public void setProps(Props cfg){this.cfg = cfg;}
 * }
 * </pre>
 * <p>Your IDE will now autocomplete uses of 'props' (or whatever you name it) with
 * the properties Props knows about.</p>
 * <p>Note that the properties can be supplied with dots or underscores, but will be
 * accessed via the java names (e.g., property "ctk.pattern.testclass"
 * is injected into the variable named "ctk_pattern_testclass" - there's no
 * mapping-magic here, this is a manual editing step you'll need to observe
 * if you add new properties to this mechanism.</p>
 * <p>This class collects the "ctk.*" config values supplied via Spring's
 * normal configuration precedence order:
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
 * <p>Property/YAML files can be in 4 locations:
 * <ul>
 * <li>(highest priority) externally, in the {@code /config} directory under the app's start dir</li>
 * <li>externally, directly in the app's start dir</li>
 * <li>internally, in the /config package (not used in the CTK)</li>
 * <li>(lowest priority) internally at the root of the classpath (from the "resources/" dir in the source tree)</li>
 * </ul>
 * <p>YAML files seem to take precedence over .properties files of the same name.</p>
 * <p>Profiles used in the CTK:</p>
 * <ul><li>none so far</li></ul>
 * <p>Created by Wayne Stidolph on 6/13/2015.</p>
 */
@Component
@ConfigurationProperties(prefix = "ctk")
@PropertySource("classpath:application.properties")
@Data
public class Props {

    // NOTE getters and setters, if needed, are provided for us by Lombok
    // but public variables don't need them and seem (to me) cleaner here

    @Value("${ctk.tgt.urlRoot}")
    public String ctk_tgt_urlRoot;

    @Value("${ctk.testpackage}")
    public String ctk_testpackage;
    @Value("${ctk.pattern.testclass}")
    public String ctk_pattern_testclass;
    @Value("${ctk.pattern.testsuite}")
    public String ctk_pattern_testsuite;
    @Value("${ctk.scripts.before}")
    public String ctk_scripts_before;
    @Value("${ctk.scripts.after}")
    public String ctk_scripts_after;

    /* search paths */
    @Value("${ctk.tgt.searchReads}")
    public String ctk_tgt_searchReads;
    @Value("${ctk.tgt.searchReadGroupSets}")
    public String ctk_tgt_searchReadGroupSets;
    @Value("${ctk.tgt.searchReferencesets}")
    public String ctk_tgt_searchReferencesets;
    @Value("${ctk.tgt.searchVariantSets}")
    public String ctk_tgt_searchVariantSets;
    @Value("${ctk.tgt.searchVariants}")
    public String ctk_tgt_searchVariants;
    @Value("${ctk.tgt.searchCallsets}")
    public String ctk_tgt_searchCallsets;
    @Value("${ctk.tgt.getReadGroupSet}")
    public String ctk_tgt_getReadGroupSet;
    @Value("${ctk.tgt.getReferences}")
    public String ctk_tgt_getReferences;
    @Value("${ctk.tgt.getReferencesBases}")
    public String ctk_tgt_getReferencesBases;
    @Value("${ctk.tgt.searchReferences}")
    public String ctk_tgt_searchReferences;
    @Value("${ctk.tgt.getReferencesets}")
    public String ctk_tgt_getReferencesets;
    @Value("${ctk.tgt.getReadGroup}")
    public String ctk_tgt_getReadGroup;
    @Value("${ctk.tgt.searchDatasets}")
    public String ctk_tgt_searchDatasets;
    @Value("${ctk.tgt.getDataset}")
    public String ctk_tgt_getDataset;
    @Value("${ctk.tgt.getVariantSet}")
    public String ctk_tgt_getVariantSet;
    @Value("${ctk.tgt.getVariant}")
    public String ctk_tgt_getVariant;
    @Value("${ctk.tgt.searchAlleleCalls}")
    public String ctk_tgt_searchAlleleCalls;
    @Value("${ctk.tgt.searchAlleles}")
    public String ctk_tgt_searchAlleles;
    @Value("${ctk.tgt.getAllele}")
    public String ctk_tgt_getAllele;
    @Value("${ctk.tgt.getCallSet}")
    public String ctk_tgt_getCallSet;
    @Value("${ctk.tgt.searchCalls}")
    public String ctk_tgt_searchCalls;

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }
}
