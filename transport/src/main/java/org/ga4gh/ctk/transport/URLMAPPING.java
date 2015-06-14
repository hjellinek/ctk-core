package org.ga4gh.ctk.transport;

import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * <p>Mapping support to get from an IDL enpoint to an implementation endpoint.</p>
 * <p>Created by Wayne Stidolph on 5/25/2015.</p>
 */
public class URLMAPPING {
    public static String urlRoot = "http://192.168.2.115:8000/v0.5.1/";
    /**
     * <p>Map IDL message name to target server endpoint.</p>
     * <p>This Map,is initialized inn code with defaults from the
     * IDL (hand-copied, might not be up to date). On startup of the
     * URLMAPPING class, an initializer reads in an UrlMapping.properties
     * file and merges it with this Map, which allows for extension or
     * overwrite.</p>
     *<p>The Map is public and mutable so it can be easily examined or
     * replaced in test code</p>
     * <p>Design note - why not an Enum? For extensibility-without-compiling.
     * This lets a test writer/API developer add or change URLs without having
     * to repackage the transport module.</p>
     */
    public static Map<String, String> endpoints = new HashMap<>();

    private static Properties propsFromFile;

    /* **** DEFAULT ENDPOINTS *** */
    static {
        endpoints.put("searchReads","reads/search");
        endpoints.put("searchReadGroupSets","readgroupsets/search");
        endpoints.put("getReadGroupSet","readgroupsets/{id}");
        endpoints.put("getReferences","references/{id}");
        endpoints.put("searchReferencesets","referencesets/search");
        endpoints.put("getReferencesBases","references/{id}/bases");
        endpoints.put("searchReferences","references/search");
        endpoints.put("getReferencesets","referencesets/{id}");
        endpoints.put("getReadGroup","readgroups/{id}");
        endpoints.put("searchDatasets","datasets/search");
        endpoints.put("getDataset","datasets/{id}");
        endpoints.put("searchVariantSets","variantsets/search");
        endpoints.put("getVariantSet","variantsets/{id}");
        endpoints.put("searchVariants","variants/search");
        endpoints.put("getVariant","variants/{id}");
        endpoints.put("searchAlleles","alleles/search");
        endpoints.put("getAllele","alleles/{id}");
        endpoints.put("getCallSet","callsets/{id}");
        endpoints.put("searchCallsets","callsets/search");
        endpoints.put("searchCalls","calls/search");
        endpoints.put("searchAlleleCalls", "allelecalls/search");

        loadProps("UrlMapping.properties");
        if(propsFromFile != null){
            mergePropertiesIntoMap(propsFromFile, endpoints);
        }
    }

    public static String getUrlRoot() {
        return urlRoot;
    }

    public static void setUrlRoot(String urlRoot) {
        URLMAPPING.urlRoot = urlRoot;
    }

    public static Properties loadProps(String resName) {
        String resourceName="UrlMapping.properties";
        Properties props = new Properties();
        InputStream instream = Thread.currentThread().getContextClassLoader().getResourceAsStream(resName);
        if(instream != null) try {
            props.load(instream);
        } catch (IOException e) {
            // maybe there's nothing to load, but that's OK we have the defaults already
        }
        return props;
    }

    public static void mergePropertiesIntoMap(Properties props, Map map) {
        if (map != null && props != null) {
            for (Enumeration en = props.propertyNames(); en.hasMoreElements();) {
                String key = (String) en.nextElement();
                map.put(key, props.getProperty(key));
            }
        }
    }

    // syntactic suger, mostly to help IDEs autocomplete
    // incomplete list, I just added them when I needed them. You can
    // always just do URLMAPPING.endpoints.get("getVariant") etc
    public static String getSearchReads() {
        return endpoints.get("searchReads");
    }

    public static void setSearchReads(String searchReads) {
        endpoints.put("searchReads",searchReads);
    }

    public static String getSearchReadGroupSets() {
        return endpoints.get("searchReadGroupSets");
    }

    public static void setSearchReadGroupSets(String searchReadGroupSets) {
        endpoints.put("searchReadGroupSets",searchReadGroupSets);
    }

    public static String getSearchReferencesets() {
        return endpoints.get("searchReferencesets");
    }

    public static void setSearchReferencesets(String searchReferencesets) {
        endpoints.put("searchReferencesets",searchReferencesets);
    }

    public static String getSearchVariantSets() {
        return endpoints.get("searchVariantSets");
    }

    public static void setSearchVariantSets(String searchVariantSets) {
        endpoints.put("searchVariantSets",searchVariantSets);
    }

    public static String getSearchVariants() {
        return endpoints.get("searchVariants");
    }

    public static void setSearchVariants(String searchVariants) {
        endpoints.put("searchVariants",searchVariants);
    }

    public static String getSearchCallsets() {
        return endpoints.get("searchCallsets");
    }

    public static void setSearchCallsets(String searchCallsets) {
        endpoints.put("searchCallsets", searchCallsets);
    }
}
