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
