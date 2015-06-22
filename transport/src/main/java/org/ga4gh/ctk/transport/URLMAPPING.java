package org.ga4gh.ctk.transport;

import java.io.*;
import java.util.*;

import static org.slf4j.LoggerFactory.*;

/**
 * <p>Mapping support to get from an IDL enpoint to an implementation endpoint.</p>
 * <p>Created by Wayne Stidolph on 5/25/2015.</p>
 */

public class URLMAPPING {
    private static org.slf4j.Logger log = getLogger(URLMAPPING.class);
    /**
     * <p>Map IDL message name to target server endpoint.</p>
     * <p>This Map,is initialized inn code with defaults from the
     * IDL (hand-copied, might not be up to date). On startup of the
     * URLMAPPING class, an initializer reads in an UrlMapping.properties
     * file and merges it with this Map, which allows for extension or
     * overwrite.</p>
     * <p>The Map is public and mutable so it can be easily examined or
     * replaced in test code</p>
     * <p>Design note - why not an Enum? For extensibility-without-compiling.
     * This lets a test writer/API developer add or change URLs without having
     * to repackage the transport module.</p>
     */
    public static Map<String, String> endpoints = new HashMap<>();

    private static Properties tempProps;

    /* **** DEFAULT ENDPOINTS no matter what, we have these *** */
    static {
        endpoints.put("ctk.tgt.urlRoot", "http://localhost:8000/v0.5.1");
        endpoints.put("ctk.tgt.searchReadGroupSets", "readgroupsets/search");
        endpoints.put("ctk.tgt.searchReads", "reads/search");
        endpoints.put("ctk.tgt.getReadGroupSet", "readgroupsets/{id}");
        endpoints.put("ctk.tgt.getReferences", "references/{id}");
        endpoints.put("ctk.tgt.searchReferencesets", "referencesets/search");
        endpoints.put("ctk.tgt.getReferencesBases", "references/{id}/bases");
        endpoints.put("ctk.tgt.searchReferences", "references/search");
        endpoints.put("ctk.tgt.getReferencesets", "referencesets/{id}");
        endpoints.put("ctk.tgt.getReadGroup", "readgroups/{id}");
        endpoints.put("ctk.tgt.searchDatasets", "datasets/search");
        endpoints.put("ctk.tgt.getDataset", "datasets/{id}");
        endpoints.put("ctk.tgt.searchVariantSets", "variantsets/search");
        endpoints.put("ctk.tgt.getVariantSet", "variantsets/{id}");
        endpoints.put("ctk.tgt.searchVariants", "variants/search");
        endpoints.put("ctk.tgt.getVariant", "variants/{id}");
        endpoints.put("ctk.tgt.searchAlleles", "alleles/search");
        endpoints.put("ctk.tgt.getAllele", "alleles/{id}");
        endpoints.put("ctk.tgt.getCallSet", "callsets/{id}");
        endpoints.put("ctk.tgt.searchCallsets", "callsets/search");
        endpoints.put("ctk.tgt.searchCalls", "calls/search");
        endpoints.put("ctk.tgt.searchAlleleCalls", "allelecalls/search");

        log.debug("process defaulttransport.properties");
        tempProps = loadPropsFile("defaulttransport.properties");
        if (!tempProps.isEmpty()) {
            mergePropertiesIntoMap(tempProps, endpoints);
        }
        log.debug("\nprocess Env");
        tempProps = loadPropsEnv("ctk.tgt.");
        if (!tempProps.isEmpty()) {
            mergePropertiesIntoMap(tempProps, endpoints);
        }
        log.debug("\nprocess Sys");
        tempProps = loadPropsSystem("ctk.tgt.");
        if (!tempProps.isEmpty()) {
            mergePropertiesIntoMap(tempProps, endpoints);
        }
        log.info("set URLMAPPING urlRoot to " + URLMAPPING.getUrlRoot());
    }

    public static Properties loadPropsFile(String resName) {
        Properties props = new Properties();
        InputStream instream = Thread.currentThread().getContextClassLoader().getResourceAsStream(resName);

        if (instream != null) try {
            props.load(instream);
        } catch (IOException e) {
            // maybe there's nothing to load, but that's OK we have the defaults already
        }
        else {
            log.info("Did not find property file " + resName);
        }
        return props;
    }

    public static Properties loadPropsSystem(String prefix) {
        Properties props = new Properties();
        for (Object key : System.getProperties().keySet()) {
            String ks = key.toString();
            log.trace("Sys prop has key " + ks);
            if (ks.startsWith(prefix))
                props.put(ks, System.getProperty(ks));
        }
        return props;
    }

    public static Properties loadPropsEnv(String prefix) {
        Map<String, String> env = System.getenv();
        // copy over the env vals with right name
        Properties props = new Properties();
        for (String key : env.keySet()) {
            log.trace("env has " + key);
            if (key.startsWith(prefix))
                props.put(key, env.get(key));
        }
        return props;

    }

    public static void mergePropertiesIntoMap(Properties props, Map map) {
        if (map != null && props != null) {
            for (Enumeration en = props.propertyNames(); en.hasMoreElements(); ) {
                String key = (String) en.nextElement();
                map.put(key, props.getProperty(key));
                log.debug(key + " => " + props.getProperty(key));
            }
        }
    }


    public static String getUrlRoot() {
        return endpoints.get("ctk.tgt.urlRoot");
    }

    public static void setUrlRoot(String urlRoot) {
        if(urlRoot != null && !urlRoot.isEmpty()) {
            if(!urlRoot.endsWith("/"))
                urlRoot = urlRoot + "/";
            endpoints.put("ctk.tgt.urlRoot", urlRoot);
        }
        else {
            log.warn("setUrlRoot got null/empty argument, not making change");
        }
    }

    // Syntactic suger, mostly to help IDEs autocomplete
    // These methods are an incomplete list, I just added them when
    // I needed them. You can always just do
    // URLMAPPING.endpoints.get("mykey") etc
    public static String getSearchReads() {
        return endpoints.get("ctk.tgt.searchReads");
    }

    public static void setSearchReads(String searchReads) {
        endpoints.put("ctk.tgt.searchReads", searchReads);
    }

    public static String getSearchReadGroupSets() {
        return endpoints.get("ctk.tgt.searchReadGroupSets");
    }

    public static void setSearchReadGroupSets(String searchReadGroupSets) {
        endpoints.put("ctk.tgt.searchReadGroupSets", searchReadGroupSets);
    }

    public static String getSearchReferencesets() {
        return endpoints.get("ctk.tgt.searchReferencesets");
    }

    public static void setSearchReferencesets(String searchReferencesets) {
        endpoints.put("ctk.tgt.searchReferencesets", searchReferencesets);
    }

    public static String getSearchVariantSets() {
        return endpoints.get("ctk.tgt.searchVariantSets");
    }

    public static void setSearchVariantSets(String searchVariantSets) {
        endpoints.put("ctk.tgt.searchVariantSets", searchVariantSets);
    }

    public static String getSearchVariants() {
        return endpoints.get("ctk.tgt.searchVariants");
    }

    public static void setSearchVariants(String searchVariants) {
        endpoints.put("ctk.tgt.searchVariants", searchVariants);
    }

    public static String getSearchCallsets() {
        return endpoints.get("ctk.tgt.searchCallsets");
    }

    public static void setSearchCallsets(String searchCallsets) {
        endpoints.put("ctk.tgt.searchCallsets", searchCallsets);
    }
}
