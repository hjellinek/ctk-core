package org.ga4gh.transport;

/**
 * Created by Wayne Stidolph on 5/25/2015.
 */
public class URLMAPPING {
    public static String urlRoot = "http://192.168.2.115:8000/v0.5.1/";

    static public String searchReads = "reads/search";
    static public String searchReadGroupSets = "readgroupsets/search";
    static public String getReadGroupSet = "readgroupsets/{id}";
    static public String getReadGroup = "readgroups/{id}";
    static public String searchDatasets = "datasets/search";
    static public String getDataset = "datasets/{id}";

    static public String searchVariantSets = "variantsets/search";
    static public String getVariantSet = "variantsets/{id}";
    static public String searchVariants = "variants/search";
    static public String getVariant = "variants/{id}";
    static public String searchAlleles = "alleles/search";
    static public String getAllele = "alleles/{id}";
    static public String searchCallSets = "callsets/search";
    static public String getCallSet = "callsets/{id}";
    static public String searchCalls = "calls/search";
    static public String searchAlleleCalls = "allelecalls/search";
    /*
POST	/v0.5.1/callsets/search
POST	/v0.5.1/readgroupsets/search
POST	/v0.5.1/reads/search
GET	/v0.5.1/references/<id>
GET	/v0.5.1/references/<id>/bases
POST	/v0.5.1/references/search
GET	/v0.5.1/referencesets/<id>
POST	/v0.5.1/referencesets/search
POST	/v0.5.1/variants/search
POST	/v0.5.1/variantsets/search

     */
}