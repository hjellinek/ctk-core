package org.ga4gh.ctk.asserts;

import static org.assertj.core.groups.Properties.extractProperty;

import java.util.List;
import org.assertj.core.internal.cglib.proxy.Enhancer;

import org.assertj.core.api.ErrorCollector;
import org.assertj.core.api.SoftAssertionError;

/**
 * Entry point for assertions of different data types. Each method in this class is a static factory for the
 * type-specific assertion objects.
 */
public class SoftAssertions {

  /** Collects error messages of all AssertionErrors thrown by the proxied method. */
  protected final ErrorCollector collector = new ErrorCollector();

  /** Creates a new </code>{@link SoftAssertions}</code>. */
  public SoftAssertions() {
  }

  /**
   * Verifies that no proxied assertion methods have failed.
   *
   * @throws SoftAssertionError if any proxied assertion objects threw
   */
  public void assertAll() {
    List<Throwable> errors = collector.errors();
    if (!errors.isEmpty()) {
      throw new SoftAssertionError(extractProperty("message", String.class).from(errors));
    }
  }

  @SuppressWarnings("unchecked")
  protected <T, V> V proxy(Class<V> assertClass, Class<T> actualClass, T actual) {
    Enhancer enhancer = new Enhancer();
    enhancer.setSuperclass(assertClass);
    enhancer.setCallback(collector);
    return (V) enhancer.create(new Class[] { actualClass }, new Object[] { actual });
  }

  /**
   * Creates a new "soft" instance of <code>{@link org.ga4gh.GAAnalysisAssert}</code>.
   *
   * @param actual the actual value.
   * @return the created "soft" assertion object.
   */
  public org.ga4gh.GAAnalysisAssert assertThat(org.ga4gh.GAAnalysis actual) {
    return proxy(org.ga4gh.GAAnalysisAssert.class, org.ga4gh.GAAnalysis.class, actual);
  }

  /**
   * Creates a new "soft" instance of <code>{@link org.ga4gh.GACallAssert}</code>.
   *
   * @param actual the actual value.
   * @return the created "soft" assertion object.
   */
  public org.ga4gh.GACallAssert assertThat(org.ga4gh.GACall actual) {
    return proxy(org.ga4gh.GACallAssert.class, org.ga4gh.GACall.class, actual);
  }

  /**
   * Creates a new "soft" instance of <code>{@link org.ga4gh.GACallSetAssert}</code>.
   *
   * @param actual the actual value.
   * @return the created "soft" assertion object.
   */
  public org.ga4gh.GACallSetAssert assertThat(org.ga4gh.GACallSet actual) {
    return proxy(org.ga4gh.GACallSetAssert.class, org.ga4gh.GACallSet.class, actual);
  }

  /**
   * Creates a new "soft" instance of <code>{@link org.ga4gh.GACigarOperationAssert}</code>.
   *
   * @param actual the actual value.
   * @return the created "soft" assertion object.
   */
  public org.ga4gh.GACigarOperationAssert assertThat(org.ga4gh.GACigarOperation actual) {
    return proxy(org.ga4gh.GACigarOperationAssert.class, org.ga4gh.GACigarOperation.class, actual);
  }

  /**
   * Creates a new "soft" instance of <code>{@link org.ga4gh.GACigarUnitAssert}</code>.
   *
   * @param actual the actual value.
   * @return the created "soft" assertion object.
   */
  public org.ga4gh.GACigarUnitAssert assertThat(org.ga4gh.GACigarUnit actual) {
    return proxy(org.ga4gh.GACigarUnitAssert.class, org.ga4gh.GACigarUnit.class, actual);
  }

  /**
   * Creates a new "soft" instance of <code>{@link org.ga4gh.GACommonAssert}</code>.
   *
   * @param actual the actual value.
   * @return the created "soft" assertion object.
   */
  public org.ga4gh.GACommonAssert assertThat(org.ga4gh.GACommon actual) {
    return proxy(org.ga4gh.GACommonAssert.class, org.ga4gh.GACommon.class, actual);
  }

  /**
   * Creates a new "soft" instance of <code>{@link org.ga4gh.GADatasetAssert}</code>.
   *
   * @param actual the actual value.
   * @return the created "soft" assertion object.
   */
  public org.ga4gh.GADatasetAssert assertThat(org.ga4gh.GADataset actual) {
    return proxy(org.ga4gh.GADatasetAssert.class, org.ga4gh.GADataset.class, actual);
  }

  /**
   * Creates a new "soft" instance of <code>{@link org.ga4gh.GAExceptionAssert}</code>.
   *
   * @param actual the actual value.
   * @return the created "soft" assertion object.
   */
  public org.ga4gh.GAExceptionAssert assertThat(org.ga4gh.GAException actual) {
    return proxy(org.ga4gh.GAExceptionAssert.class, org.ga4gh.GAException.class, actual);
  }

  /**
   * Creates a new "soft" instance of <code>{@link org.ga4gh.GAExperimentAssert}</code>.
   *
   * @param actual the actual value.
   * @return the created "soft" assertion object.
   */
  public org.ga4gh.GAExperimentAssert assertThat(org.ga4gh.GAExperiment actual) {
    return proxy(org.ga4gh.GAExperimentAssert.class, org.ga4gh.GAExperiment.class, actual);
  }

  /**
   * Creates a new "soft" instance of <code>{@link org.ga4gh.GAIndividualAssert}</code>.
   *
   * @param actual the actual value.
   * @return the created "soft" assertion object.
   */
  public org.ga4gh.GAIndividualAssert assertThat(org.ga4gh.GAIndividual actual) {
    return proxy(org.ga4gh.GAIndividualAssert.class, org.ga4gh.GAIndividual.class, actual);
  }

  /**
   * Creates a new "soft" instance of <code>{@link org.ga4gh.GAIndividualGroupAssert}</code>.
   *
   * @param actual the actual value.
   * @return the created "soft" assertion object.
   */
  public org.ga4gh.GAIndividualGroupAssert assertThat(org.ga4gh.GAIndividualGroup actual) {
    return proxy(org.ga4gh.GAIndividualGroupAssert.class, org.ga4gh.GAIndividualGroup.class, actual);
  }

  /**
   * Creates a new "soft" instance of <code>{@link org.ga4gh.GALinearAlignmentAssert}</code>.
   *
   * @param actual the actual value.
   * @return the created "soft" assertion object.
   */
  public org.ga4gh.GALinearAlignmentAssert assertThat(org.ga4gh.GALinearAlignment actual) {
    return proxy(org.ga4gh.GALinearAlignmentAssert.class, org.ga4gh.GALinearAlignment.class, actual);
  }

  /**
   * Creates a new "soft" instance of <code>{@link org.ga4gh.GAListReferenceBasesRequestAssert}</code>.
   *
   * @param actual the actual value.
   * @return the created "soft" assertion object.
   */
  public org.ga4gh.GAListReferenceBasesRequestAssert assertThat(org.ga4gh.GAListReferenceBasesRequest actual) {
    return proxy(org.ga4gh.GAListReferenceBasesRequestAssert.class, org.ga4gh.GAListReferenceBasesRequest.class, actual);
  }

  /**
   * Creates a new "soft" instance of <code>{@link org.ga4gh.GAListReferenceBasesResponseAssert}</code>.
   *
   * @param actual the actual value.
   * @return the created "soft" assertion object.
   */
  public org.ga4gh.GAListReferenceBasesResponseAssert assertThat(org.ga4gh.GAListReferenceBasesResponse actual) {
    return proxy(org.ga4gh.GAListReferenceBasesResponseAssert.class, org.ga4gh.GAListReferenceBasesResponse.class, actual);
  }

  /**
   * Creates a new "soft" instance of <code>{@link org.ga4gh.GAMetadataAssert}</code>.
   *
   * @param actual the actual value.
   * @return the created "soft" assertion object.
   */
  public org.ga4gh.GAMetadataAssert assertThat(org.ga4gh.GAMetadata actual) {
    return proxy(org.ga4gh.GAMetadataAssert.class, org.ga4gh.GAMetadata.class, actual);
  }

  /**
   * Creates a new "soft" instance of <code>{@link org.ga4gh.GAMetadataMethodsAssert}</code>.
   *
   * @param actual the actual value.
   * @return the created "soft" assertion object.
   */
  public org.ga4gh.GAMetadataMethodsAssert assertThat(org.ga4gh.GAMetadataMethods actual) {
    return proxy(org.ga4gh.GAMetadataMethodsAssert.class, org.ga4gh.GAMetadataMethods.class, actual);
  }

  /**
   * Creates a new "soft" instance of <code>{@link org.ga4gh.GAOntologyTermAssert}</code>.
   *
   * @param actual the actual value.
   * @return the created "soft" assertion object.
   */
  public org.ga4gh.GAOntologyTermAssert assertThat(org.ga4gh.GAOntologyTerm actual) {
    return proxy(org.ga4gh.GAOntologyTermAssert.class, org.ga4gh.GAOntologyTerm.class, actual);
  }

  /**
   * Creates a new "soft" instance of <code>{@link org.ga4gh.GAPositionAssert}</code>.
   *
   * @param actual the actual value.
   * @return the created "soft" assertion object.
   */
  public org.ga4gh.GAPositionAssert assertThat(org.ga4gh.GAPosition actual) {
    return proxy(org.ga4gh.GAPositionAssert.class, org.ga4gh.GAPosition.class, actual);
  }

  /**
   * Creates a new "soft" instance of <code>{@link org.ga4gh.GAProgramAssert}</code>.
   *
   * @param actual the actual value.
   * @return the created "soft" assertion object.
   */
  public org.ga4gh.GAProgramAssert assertThat(org.ga4gh.GAProgram actual) {
    return proxy(org.ga4gh.GAProgramAssert.class, org.ga4gh.GAProgram.class, actual);
  }

  /**
   * Creates a new "soft" instance of <code>{@link org.ga4gh.GAReadAlignmentAssert}</code>.
   *
   * @param actual the actual value.
   * @return the created "soft" assertion object.
   */
  public org.ga4gh.GAReadAlignmentAssert assertThat(org.ga4gh.GAReadAlignment actual) {
    return proxy(org.ga4gh.GAReadAlignmentAssert.class, org.ga4gh.GAReadAlignment.class, actual);
  }

  /**
   * Creates a new "soft" instance of <code>{@link org.ga4gh.GAReadGroupAssert}</code>.
   *
   * @param actual the actual value.
   * @return the created "soft" assertion object.
   */
  public org.ga4gh.GAReadGroupAssert assertThat(org.ga4gh.GAReadGroup actual) {
    return proxy(org.ga4gh.GAReadGroupAssert.class, org.ga4gh.GAReadGroup.class, actual);
  }

  /**
   * Creates a new "soft" instance of <code>{@link org.ga4gh.GAReadGroupSetAssert}</code>.
   *
   * @param actual the actual value.
   * @return the created "soft" assertion object.
   */
  public org.ga4gh.GAReadGroupSetAssert assertThat(org.ga4gh.GAReadGroupSet actual) {
    return proxy(org.ga4gh.GAReadGroupSetAssert.class, org.ga4gh.GAReadGroupSet.class, actual);
  }

  /**
   * Creates a new "soft" instance of <code>{@link org.ga4gh.GAReadMethodsAssert}</code>.
   *
   * @param actual the actual value.
   * @return the created "soft" assertion object.
   */
  public org.ga4gh.GAReadMethodsAssert assertThat(org.ga4gh.GAReadMethods actual) {
    return proxy(org.ga4gh.GAReadMethodsAssert.class, org.ga4gh.GAReadMethods.class, actual);
  }

  /**
   * Creates a new "soft" instance of <code>{@link org.ga4gh.GAReadsAssert}</code>.
   *
   * @param actual the actual value.
   * @return the created "soft" assertion object.
   */
  public org.ga4gh.GAReadsAssert assertThat(org.ga4gh.GAReads actual) {
    return proxy(org.ga4gh.GAReadsAssert.class, org.ga4gh.GAReads.class, actual);
  }

  /**
   * Creates a new "soft" instance of <code>{@link org.ga4gh.GAReferenceAssert}</code>.
   *
   * @param actual the actual value.
   * @return the created "soft" assertion object.
   */
  public org.ga4gh.GAReferenceAssert assertThat(org.ga4gh.GAReference actual) {
    return proxy(org.ga4gh.GAReferenceAssert.class, org.ga4gh.GAReference.class, actual);
  }

  /**
   * Creates a new "soft" instance of <code>{@link org.ga4gh.GAReferenceMethodsAssert}</code>.
   *
   * @param actual the actual value.
   * @return the created "soft" assertion object.
   */
  public org.ga4gh.GAReferenceMethodsAssert assertThat(org.ga4gh.GAReferenceMethods actual) {
    return proxy(org.ga4gh.GAReferenceMethodsAssert.class, org.ga4gh.GAReferenceMethods.class, actual);
  }

  /**
   * Creates a new "soft" instance of <code>{@link org.ga4gh.GAReferenceSetAssert}</code>.
   *
   * @param actual the actual value.
   * @return the created "soft" assertion object.
   */
  public org.ga4gh.GAReferenceSetAssert assertThat(org.ga4gh.GAReferenceSet actual) {
    return proxy(org.ga4gh.GAReferenceSetAssert.class, org.ga4gh.GAReferenceSet.class, actual);
  }

  /**
   * Creates a new "soft" instance of <code>{@link org.ga4gh.GAReferencesAssert}</code>.
   *
   * @param actual the actual value.
   * @return the created "soft" assertion object.
   */
  public org.ga4gh.GAReferencesAssert assertThat(org.ga4gh.GAReferences actual) {
    return proxy(org.ga4gh.GAReferencesAssert.class, org.ga4gh.GAReferences.class, actual);
  }

  /**
   * Creates a new "soft" instance of <code>{@link org.ga4gh.GASampleAssert}</code>.
   *
   * @param actual the actual value.
   * @return the created "soft" assertion object.
   */
  public org.ga4gh.GASampleAssert assertThat(org.ga4gh.GASample actual) {
    return proxy(org.ga4gh.GASampleAssert.class, org.ga4gh.GASample.class, actual);
  }

  /**
   * Creates a new "soft" instance of <code>{@link org.ga4gh.GASearchAnalysesRequestAssert}</code>.
   *
   * @param actual the actual value.
   * @return the created "soft" assertion object.
   */
  public org.ga4gh.GASearchAnalysesRequestAssert assertThat(org.ga4gh.GASearchAnalysesRequest actual) {
    return proxy(org.ga4gh.GASearchAnalysesRequestAssert.class, org.ga4gh.GASearchAnalysesRequest.class, actual);
  }

  /**
   * Creates a new "soft" instance of <code>{@link org.ga4gh.GASearchAnalysesResponseAssert}</code>.
   *
   * @param actual the actual value.
   * @return the created "soft" assertion object.
   */
  public org.ga4gh.GASearchAnalysesResponseAssert assertThat(org.ga4gh.GASearchAnalysesResponse actual) {
    return proxy(org.ga4gh.GASearchAnalysesResponseAssert.class, org.ga4gh.GASearchAnalysesResponse.class, actual);
  }

  /**
   * Creates a new "soft" instance of <code>{@link org.ga4gh.GASearchCallSetsRequestAssert}</code>.
   *
   * @param actual the actual value.
   * @return the created "soft" assertion object.
   */
  public org.ga4gh.GASearchCallSetsRequestAssert assertThat(org.ga4gh.GASearchCallSetsRequest actual) {
    return proxy(org.ga4gh.GASearchCallSetsRequestAssert.class, org.ga4gh.GASearchCallSetsRequest.class, actual);
  }

  /**
   * Creates a new "soft" instance of <code>{@link org.ga4gh.GASearchCallSetsResponseAssert}</code>.
   *
   * @param actual the actual value.
   * @return the created "soft" assertion object.
   */
  public org.ga4gh.GASearchCallSetsResponseAssert assertThat(org.ga4gh.GASearchCallSetsResponse actual) {
    return proxy(org.ga4gh.GASearchCallSetsResponseAssert.class, org.ga4gh.GASearchCallSetsResponse.class, actual);
  }

  /**
   * Creates a new "soft" instance of <code>{@link org.ga4gh.GASearchExperimentsRequestAssert}</code>.
   *
   * @param actual the actual value.
   * @return the created "soft" assertion object.
   */
  public org.ga4gh.GASearchExperimentsRequestAssert assertThat(org.ga4gh.GASearchExperimentsRequest actual) {
    return proxy(org.ga4gh.GASearchExperimentsRequestAssert.class, org.ga4gh.GASearchExperimentsRequest.class, actual);
  }

  /**
   * Creates a new "soft" instance of <code>{@link org.ga4gh.GASearchExperimentsResponseAssert}</code>.
   *
   * @param actual the actual value.
   * @return the created "soft" assertion object.
   */
  public org.ga4gh.GASearchExperimentsResponseAssert assertThat(org.ga4gh.GASearchExperimentsResponse actual) {
    return proxy(org.ga4gh.GASearchExperimentsResponseAssert.class, org.ga4gh.GASearchExperimentsResponse.class, actual);
  }

  /**
   * Creates a new "soft" instance of <code>{@link org.ga4gh.GASearchIndividualGroupsRequestAssert}</code>.
   *
   * @param actual the actual value.
   * @return the created "soft" assertion object.
   */
  public org.ga4gh.GASearchIndividualGroupsRequestAssert assertThat(org.ga4gh.GASearchIndividualGroupsRequest actual) {
    return proxy(org.ga4gh.GASearchIndividualGroupsRequestAssert.class, org.ga4gh.GASearchIndividualGroupsRequest.class, actual);
  }

  /**
   * Creates a new "soft" instance of <code>{@link org.ga4gh.GASearchIndividualGroupsResponseAssert}</code>.
   *
   * @param actual the actual value.
   * @return the created "soft" assertion object.
   */
  public org.ga4gh.GASearchIndividualGroupsResponseAssert assertThat(org.ga4gh.GASearchIndividualGroupsResponse actual) {
    return proxy(org.ga4gh.GASearchIndividualGroupsResponseAssert.class, org.ga4gh.GASearchIndividualGroupsResponse.class, actual);
  }

  /**
   * Creates a new "soft" instance of <code>{@link org.ga4gh.GASearchIndividualsRequestAssert}</code>.
   *
   * @param actual the actual value.
   * @return the created "soft" assertion object.
   */
  public org.ga4gh.GASearchIndividualsRequestAssert assertThat(org.ga4gh.GASearchIndividualsRequest actual) {
    return proxy(org.ga4gh.GASearchIndividualsRequestAssert.class, org.ga4gh.GASearchIndividualsRequest.class, actual);
  }

  /**
   * Creates a new "soft" instance of <code>{@link org.ga4gh.GASearchIndividualsResponseAssert}</code>.
   *
   * @param actual the actual value.
   * @return the created "soft" assertion object.
   */
  public org.ga4gh.GASearchIndividualsResponseAssert assertThat(org.ga4gh.GASearchIndividualsResponse actual) {
    return proxy(org.ga4gh.GASearchIndividualsResponseAssert.class, org.ga4gh.GASearchIndividualsResponse.class, actual);
  }

  /**
   * Creates a new "soft" instance of <code>{@link org.ga4gh.GASearchReadGroupSetsRequestAssert}</code>.
   *
   * @param actual the actual value.
   * @return the created "soft" assertion object.
   */
  public org.ga4gh.GASearchReadGroupSetsRequestAssert assertThat(org.ga4gh.GASearchReadGroupSetsRequest actual) {
    return proxy(org.ga4gh.GASearchReadGroupSetsRequestAssert.class, org.ga4gh.GASearchReadGroupSetsRequest.class, actual);
  }

  /**
   * Creates a new "soft" instance of <code>{@link org.ga4gh.GASearchReadGroupSetsResponseAssert}</code>.
   *
   * @param actual the actual value.
   * @return the created "soft" assertion object.
   */
  public org.ga4gh.GASearchReadGroupSetsResponseAssert assertThat(org.ga4gh.GASearchReadGroupSetsResponse actual) {
    return proxy(org.ga4gh.GASearchReadGroupSetsResponseAssert.class, org.ga4gh.GASearchReadGroupSetsResponse.class, actual);
  }

  /**
   * Creates a new "soft" instance of <code>{@link org.ga4gh.GASearchReadsRequestAssert}</code>.
   *
   * @param actual the actual value.
   * @return the created "soft" assertion object.
   */
  public org.ga4gh.GASearchReadsRequestAssert assertThat(org.ga4gh.GASearchReadsRequest actual) {
    return proxy(org.ga4gh.GASearchReadsRequestAssert.class, org.ga4gh.GASearchReadsRequest.class, actual);
  }

  /**
   * Creates a new "soft" instance of <code>{@link org.ga4gh.GASearchReadsResponseAssert}</code>.
   *
   * @param actual the actual value.
   * @return the created "soft" assertion object.
   */
  public org.ga4gh.GASearchReadsResponseAssert assertThat(org.ga4gh.GASearchReadsResponse actual) {
    return proxy(org.ga4gh.GASearchReadsResponseAssert.class, org.ga4gh.GASearchReadsResponse.class, actual);
  }

  /**
   * Creates a new "soft" instance of <code>{@link org.ga4gh.GASearchReferenceSetsRequestAssert}</code>.
   *
   * @param actual the actual value.
   * @return the created "soft" assertion object.
   */
  public org.ga4gh.GASearchReferenceSetsRequestAssert assertThat(org.ga4gh.GASearchReferenceSetsRequest actual) {
    return proxy(org.ga4gh.GASearchReferenceSetsRequestAssert.class, org.ga4gh.GASearchReferenceSetsRequest.class, actual);
  }

  /**
   * Creates a new "soft" instance of <code>{@link org.ga4gh.GASearchReferenceSetsResponseAssert}</code>.
   *
   * @param actual the actual value.
   * @return the created "soft" assertion object.
   */
  public org.ga4gh.GASearchReferenceSetsResponseAssert assertThat(org.ga4gh.GASearchReferenceSetsResponse actual) {
    return proxy(org.ga4gh.GASearchReferenceSetsResponseAssert.class, org.ga4gh.GASearchReferenceSetsResponse.class, actual);
  }

  /**
   * Creates a new "soft" instance of <code>{@link org.ga4gh.GASearchReferencesRequestAssert}</code>.
   *
   * @param actual the actual value.
   * @return the created "soft" assertion object.
   */
  public org.ga4gh.GASearchReferencesRequestAssert assertThat(org.ga4gh.GASearchReferencesRequest actual) {
    return proxy(org.ga4gh.GASearchReferencesRequestAssert.class, org.ga4gh.GASearchReferencesRequest.class, actual);
  }

  /**
   * Creates a new "soft" instance of <code>{@link org.ga4gh.GASearchReferencesResponseAssert}</code>.
   *
   * @param actual the actual value.
   * @return the created "soft" assertion object.
   */
  public org.ga4gh.GASearchReferencesResponseAssert assertThat(org.ga4gh.GASearchReferencesResponse actual) {
    return proxy(org.ga4gh.GASearchReferencesResponseAssert.class, org.ga4gh.GASearchReferencesResponse.class, actual);
  }

  /**
   * Creates a new "soft" instance of <code>{@link org.ga4gh.GASearchSamplesRequestAssert}</code>.
   *
   * @param actual the actual value.
   * @return the created "soft" assertion object.
   */
  public org.ga4gh.GASearchSamplesRequestAssert assertThat(org.ga4gh.GASearchSamplesRequest actual) {
    return proxy(org.ga4gh.GASearchSamplesRequestAssert.class, org.ga4gh.GASearchSamplesRequest.class, actual);
  }

  /**
   * Creates a new "soft" instance of <code>{@link org.ga4gh.GASearchSamplesResponseAssert}</code>.
   *
   * @param actual the actual value.
   * @return the created "soft" assertion object.
   */
  public org.ga4gh.GASearchSamplesResponseAssert assertThat(org.ga4gh.GASearchSamplesResponse actual) {
    return proxy(org.ga4gh.GASearchSamplesResponseAssert.class, org.ga4gh.GASearchSamplesResponse.class, actual);
  }

  /**
   * Creates a new "soft" instance of <code>{@link org.ga4gh.GASearchVariantSetsRequestAssert}</code>.
   *
   * @param actual the actual value.
   * @return the created "soft" assertion object.
   */
  public org.ga4gh.GASearchVariantSetsRequestAssert assertThat(org.ga4gh.GASearchVariantSetsRequest actual) {
    return proxy(org.ga4gh.GASearchVariantSetsRequestAssert.class, org.ga4gh.GASearchVariantSetsRequest.class, actual);
  }

  /**
   * Creates a new "soft" instance of <code>{@link org.ga4gh.GASearchVariantSetsResponseAssert}</code>.
   *
   * @param actual the actual value.
   * @return the created "soft" assertion object.
   */
  public org.ga4gh.GASearchVariantSetsResponseAssert assertThat(org.ga4gh.GASearchVariantSetsResponse actual) {
    return proxy(org.ga4gh.GASearchVariantSetsResponseAssert.class, org.ga4gh.GASearchVariantSetsResponse.class, actual);
  }

  /**
   * Creates a new "soft" instance of <code>{@link org.ga4gh.GASearchVariantsRequestAssert}</code>.
   *
   * @param actual the actual value.
   * @return the created "soft" assertion object.
   */
  public org.ga4gh.GASearchVariantsRequestAssert assertThat(org.ga4gh.GASearchVariantsRequest actual) {
    return proxy(org.ga4gh.GASearchVariantsRequestAssert.class, org.ga4gh.GASearchVariantsRequest.class, actual);
  }

  /**
   * Creates a new "soft" instance of <code>{@link org.ga4gh.GASearchVariantsResponseAssert}</code>.
   *
   * @param actual the actual value.
   * @return the created "soft" assertion object.
   */
  public org.ga4gh.GASearchVariantsResponseAssert assertThat(org.ga4gh.GASearchVariantsResponse actual) {
    return proxy(org.ga4gh.GASearchVariantsResponseAssert.class, org.ga4gh.GASearchVariantsResponse.class, actual);
  }

  /**
   * Creates a new "soft" instance of <code>{@link org.ga4gh.GASexAssert}</code>.
   *
   * @param actual the actual value.
   * @return the created "soft" assertion object.
   */
  public org.ga4gh.GASexAssert assertThat(org.ga4gh.GASex actual) {
    return proxy(org.ga4gh.GASexAssert.class, org.ga4gh.GASex.class, actual);
  }

  /**
   * Creates a new "soft" instance of <code>{@link org.ga4gh.GAVariantAssert}</code>.
   *
   * @param actual the actual value.
   * @return the created "soft" assertion object.
   */
  public org.ga4gh.GAVariantAssert assertThat(org.ga4gh.GAVariant actual) {
    return proxy(org.ga4gh.GAVariantAssert.class, org.ga4gh.GAVariant.class, actual);
  }

  /**
   * Creates a new "soft" instance of <code>{@link org.ga4gh.GAVariantMethodsAssert}</code>.
   *
   * @param actual the actual value.
   * @return the created "soft" assertion object.
   */
  public org.ga4gh.GAVariantMethodsAssert assertThat(org.ga4gh.GAVariantMethods actual) {
    return proxy(org.ga4gh.GAVariantMethodsAssert.class, org.ga4gh.GAVariantMethods.class, actual);
  }

  /**
   * Creates a new "soft" instance of <code>{@link org.ga4gh.GAVariantSetAssert}</code>.
   *
   * @param actual the actual value.
   * @return the created "soft" assertion object.
   */
  public org.ga4gh.GAVariantSetAssert assertThat(org.ga4gh.GAVariantSet actual) {
    return proxy(org.ga4gh.GAVariantSetAssert.class, org.ga4gh.GAVariantSet.class, actual);
  }

  /**
   * Creates a new "soft" instance of <code>{@link org.ga4gh.GAVariantSetMetadataAssert}</code>.
   *
   * @param actual the actual value.
   * @return the created "soft" assertion object.
   */
  public org.ga4gh.GAVariantSetMetadataAssert assertThat(org.ga4gh.GAVariantSetMetadata actual) {
    return proxy(org.ga4gh.GAVariantSetMetadataAssert.class, org.ga4gh.GAVariantSetMetadata.class, actual);
  }

  /**
   * Creates a new "soft" instance of <code>{@link org.ga4gh.GAVariantsAssert}</code>.
   *
   * @param actual the actual value.
   * @return the created "soft" assertion object.
   */
  public org.ga4gh.GAVariantsAssert assertThat(org.ga4gh.GAVariants actual) {
    return proxy(org.ga4gh.GAVariantsAssert.class, org.ga4gh.GAVariants.class, actual);
  }

  /**
   * Creates a new "soft" instance of <code>{@link org.ga4gh.ctk.transport.RespCodeAssert}</code>.
   *
   * @param actual the actual value.
   * @return the created "soft" assertion object.
   */
  public org.ga4gh.ctk.transport.RespCodeAssert assertThat(org.ga4gh.ctk.transport.RespCode actual) {
    return proxy(org.ga4gh.ctk.transport.RespCodeAssert.class, org.ga4gh.ctk.transport.RespCode.class, actual);
  }

  /**
   * Creates a new "soft" instance of <code>{@link org.ga4gh.ctk.transport.WireTrackerAssert}</code>.
   *
   * @param actual the actual value.
   * @return the created "soft" assertion object.
   */
  public org.ga4gh.ctk.transport.WireTrackerAssert assertThat(org.ga4gh.ctk.transport.WireTracker actual) {
    return proxy(org.ga4gh.ctk.transport.WireTrackerAssert.class, org.ga4gh.ctk.transport.WireTracker.class, actual);
  }

}
