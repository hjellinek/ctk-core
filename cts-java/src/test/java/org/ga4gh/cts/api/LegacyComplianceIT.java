package org.ga4gh.cts.api;

import junitparams.JUnitParamsRunner;
import org.apache.avro.AvroRemoteException;
import org.ga4gh.*;
import org.ga4gh.ctk.CtkLogs;
import org.ga4gh.ctk.transport.URLMAPPING;
import org.ga4gh.ctk.transport.protocols.ReadsProtocolClient;
import org.ga4gh.ctk.transport.protocols.VariantsProtocolClient;
import org.ga4gh.cts.api.reads.ReadsTests;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;

import java.util.List;

import static java.util.Collections.singletonList;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * These tests are equivalents of the ones in <a href="https://github.com/ga4gh/compliance">the ga4gh compliance repo</a>.
 * Those were written in JavaScript and were meant to execute against a predefined set of servers, user-selectable at runtime.
 *
 * @author Herb Jellinek
 */
@Category(ReadsTests.class)
@RunWith(JUnitParamsRunner.class)
public class LegacyComplianceIT implements CtkLogs {

    private static final String DATASET_ID = "1";

    private static ReadsProtocolClient readsClient;

    private static VariantsProtocolClient variantsClient;

    @BeforeClass
    public static void setupTransport() throws Exception {
        URLMAPPING.doInit(); // reload defaults
        readsClient = new ReadsProtocolClient();
        variantsClient = new VariantsProtocolClient();
    }

    /**
     * Search read group sets.  Fetches read group sets from the specified dataset.
     * <ul>
     * <li>Query 1: <pre>/readgroupsets/search <dataset ID></pre>
     * <li>Test 1: assert that we received a result of type {@link GASearchReadGroupSetsResponse}, and that every
     * {@link GASearchReadGroupSet} it contains has field datasetId == &lt;dataset ID&gt;</li>
     * <li>Test 2: every {@link GAReadGroup} in that {@link GASearchReadGroupSet} has: an 'experiment' of type GAExperiment
     * with datasetId == &lt;dataset ID&gt; AND a program of type {@link GAProgram} which is not empty
     * </ul>
     */
    @Test
    public void searchReadGroupSets() {
        // XXX GASearchReadGroupSet doesn't exist
    }

    /**
     * Search variant sets. Fetches variant sets from the specified dataset.
     * <ul>
     * <li>Query 1: <pre>/variantsets/search &lt;dataset ID&gt;</re></li>
     * <li>Test 1: assert that we received a {@link GASearchVariantSetsResponse} containing an array of
     * {@link GAVariantSet} of length > 0 (should have a definite #, actually)</li>
     * <li>Test 2: assert that the 'metadata' field of that {@link GAVariantSet} is of type {@link GAVariantSetMetadata}.</li>
     * </ul>
     */
    @Test
    public void searchVariantSets() throws AvroRemoteException {
        final GASearchVariantSetsRequest req =
                GASearchVariantSetsRequest.newBuilder().setDatasetIds(singletonList(DATASET_ID)).build();
        final GASearchVariantSetsResponse resp = variantsClient.searchVariantSets(req);

        final List<GAVariantSet> sets = resp.getVariantSets();
        assertThat(sets).isNotEmpty();
        for (GAVariantSet vs : sets) {
            final List<GAVariantSetMetadata> metadata = vs.getMetadata();
            assertThat(metadata).isNotEmpty();
            assertThat(metadata).isInstanceOf(GAVariantSetMetadata.class);
        }
    }

    /**
     * Search variants.  Fetches variants from the specified dataset.
     * <ul>
     *     <li>Query 1: `/variantsets/search datasetIds: 1 `(passed in)</li>
     *     <li>Test 1: assert that we received a {@link GASearchVariantsResponse} containing (how many? > 0)
     *     {@link GAVariant} objects.  Get the ID of the first one.</li>
     *     <li>Query 2: <pre>/variants/search variantSetIds: [variantSetId] referenceName: '22' start:
     *     51005353 end: 51015354 pageSize: 1</pre></li>
     *     <li>Test 2: assert that the first result is of type {@link GAVariant} AND has reference name == "22".</li>
     *     <li>Test 3: assert that the <tt>calls</tt> field (a {@link GACall}) of that {@link GAVariant} is not null.</li>
     *     <li>Test 4: assert that the <tt>genotype</tt> field of the first {@link GACall} is an array of integers.</li>
     * </ul>
     */
    @Test
    public void searchVariants() throws AvroRemoteException {
        final String referenceName = "22";

        final GASearchVariantsRequest req =
                GASearchVariantsRequest.newBuilder().setDatasetIds(singletonList(DATASET_ID)).build();
        final GASearchVariantsResponse resp = variantsClient.searchVariants(req);

        final List<GAVariant> variants = resp.getVariants();
        assertThat(variants).isNotEmpty();
        final String id = variants.get(0).getId();

        final GASearchVariantsRequest vReq = GASearchVariantsRequest.newBuilder().
                setVariantSetIds(singletonList(id)).setReferenceName(referenceName).setStart(51005353).setEnd(51015354).
                setPageSize(1).build();
        final GASearchVariantsResponse vResp = variantsClient.searchVariants(vReq);
        final List<GAVariant> searchVariants = vResp.getVariants();
        final GAVariant firstVariant = searchVariants.get(0);
        assertThat(firstVariant).isNotNull();
        assertThat(firstVariant.getReferenceName()).isEqualTo(referenceName);

        assertThat(firstVariant.getCalls()).isNotNull();
        final GACall call = firstVariant.getCalls().get(0);
        assertThat(call).isNotNull();
        assertThat(call.getGenotype()).isNotEmpty();
    }

    /**
     * Search call sets.  Fetches call sets from the specified dataset.
     * <ul>
     *     <li>Query 1: <pre>/variantsets/search datasetIds: (passed in)</pre></li>
     *     <li>Test 1: assert that we received a {@link GASearchVariantSetsResponse} containing an array of
     *     {@link GAVariantSet} objects.  For each of the GAVariantSet objects, grab the `id` and pass it to....</li>
     *     <li>Query 2: <pre>/callsets/search variantSetIds: id</pre></li>
     *     <li>Test 2: assert that the returned object is a {@link GASearchCallSetsResponse}, and that it contains > 0
     *     {@link GACallSet} objects. We can check that the call sets have distinct ID values.</li>
     * </ul>
     */
    @Test
    public void searchCallSets() throws AvroRemoteException {
        final GASearchVariantSetsRequest vReq = GASearchVariantSetsRequest.newBuilder().setDatasetIds(singletonList(DATASET_ID)).
                build();
        final GASearchVariantSetsResponse vResp = variantsClient.searchVariantSets(vReq);

        assertThat(vResp.getVariantSets()).isNotEmpty();
        for (GAVariantSet set : vResp.getVariantSets()) {
            final String id = set.getId();

            final GASearchCallSetsRequest csReq = GASearchCallSetsRequest.newBuilder().setVariantSetIds(singletonList(id)).build();
            final GASearchCallSetsResponse csResp = variantsClient.searchCallSets(csReq);

            assertThat(csResp.getCallSets()).isNotEmpty();
        }
    }

    /**
     * Reference sets. Searches for reference set GRCh37 by accession (GCA_000001405.15) and then fetches that same
     * reference set by ID.
     * <ul>
     *     <li>Query 1: <pre>/referencesets/search accessions: ["GCA_000001405.15"] pageSize: 1</pre></li>
     *     <li>Test 1: assert that we received a {@link GASearchReferenceSetsResponse} object containing an array of
     *     {@link GAReferenceSet} objects.  For each one, assert that `ncbiTaxonId == 9606 AND assemblyId == GRCh38`.
     *     And do this for each ID in referenceIds:</li>
     *     <li>Query 2: <pre>/referencesets/<ref set ID></pre></li>
     *     <li>Test 2: assert that the ID of the returned object == ref set ID above.</li>
     * </ul>
     */
     @Test
     public void referenceSets() {
         final String accessionNumber = "GCA_000001405.15";

         final GASearchReferenceSetsRequest = // missing referenceClient

     }

}
