package org.ga4gh.cts.api.reads

import org.ga4gh.GASearchReadGroupSetsRequest
import org.ga4gh.ctk.CtkLogs
import org.ga4gh.ctk.transport.URLMAPPING
import org.ga4gh.ctk.transport.protocols.ReadsProtocolClient
import spock.lang.Specification


/**
 * Created by wstidolph on 7/6/15.
 */
class ReadGroupsSetsSeatchGroovyIT extends Specification implements CtkLogs {
    ReadsProtocolClient client

    def setupSpec() {
        URLMAPPING.doInit(); // reload defaults
        client = new ReadsProtocolClient();
    }

    def thisIsASpec() {
        GASearchReadGroupSetsRequest reqb = GASearchReadGroupSetsRequest.newBuilder()
                .setName(null)
                .setDatasetIds(Arrays.asList(datasetid.split(":")))
                .build();
    }

}