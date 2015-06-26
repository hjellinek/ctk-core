package org.ga4gh.ctk.asserts;

/**
 * Entry point for BDD assertions of different data types. Each method in this class is a static factory for the
 * type-specific assertion objects.
 */
public class BddAssertions {

  /**
   * Creates a new instance of <code>{@link org.ga4gh.GAAnalysisAssert}</code>.
   *
   * @param actual the actual value.
   * @return the created assertion object.
   */
  public static org.ga4gh.GAAnalysisAssert then(org.ga4gh.GAAnalysis actual) {
    return new org.ga4gh.GAAnalysisAssert(actual);
  }

  /**
   * Creates a new instance of <code>{@link org.ga4gh.GACallAssert}</code>.
   *
   * @param actual the actual value.
   * @return the created assertion object.
   */
  public static org.ga4gh.GACallAssert then(org.ga4gh.GACall actual) {
    return new org.ga4gh.GACallAssert(actual);
  }

  /**
   * Creates a new instance of <code>{@link org.ga4gh.GACallSetAssert}</code>.
   *
   * @param actual the actual value.
   * @return the created assertion object.
   */
  public static org.ga4gh.GACallSetAssert then(org.ga4gh.GACallSet actual) {
    return new org.ga4gh.GACallSetAssert(actual);
  }

  /**
   * Creates a new instance of <code>{@link org.ga4gh.GACigarOperationAssert}</code>.
   *
   * @param actual the actual value.
   * @return the created assertion object.
   */
  public static org.ga4gh.GACigarOperationAssert then(org.ga4gh.GACigarOperation actual) {
    return new org.ga4gh.GACigarOperationAssert(actual);
  }

  /**
   * Creates a new instance of <code>{@link org.ga4gh.GACigarUnitAssert}</code>.
   *
   * @param actual the actual value.
   * @return the created assertion object.
   */
  public static org.ga4gh.GACigarUnitAssert then(org.ga4gh.GACigarUnit actual) {
    return new org.ga4gh.GACigarUnitAssert(actual);
  }

  /**
   * Creates a new instance of <code>{@link org.ga4gh.GACommonAssert}</code>.
   *
   * @param actual the actual value.
   * @return the created assertion object.
   */
  public static org.ga4gh.GACommonAssert then(org.ga4gh.GACommon actual) {
    return new org.ga4gh.GACommonAssert(actual);
  }

  /**
   * Creates a new instance of <code>{@link org.ga4gh.GADatasetAssert}</code>.
   *
   * @param actual the actual value.
   * @return the created assertion object.
   */
  public static org.ga4gh.GADatasetAssert then(org.ga4gh.GADataset actual) {
    return new org.ga4gh.GADatasetAssert(actual);
  }

  /**
   * Creates a new instance of <code>{@link org.ga4gh.GAExceptionAssert}</code>.
   *
   * @param actual the actual value.
   * @return the created assertion object.
   */
  public static org.ga4gh.GAExceptionAssert then(org.ga4gh.GAException actual) {
    return new org.ga4gh.GAExceptionAssert(actual);
  }

  /**
   * Creates a new instance of <code>{@link org.ga4gh.GAExperimentAssert}</code>.
   *
   * @param actual the actual value.
   * @return the created assertion object.
   */
  public static org.ga4gh.GAExperimentAssert then(org.ga4gh.GAExperiment actual) {
    return new org.ga4gh.GAExperimentAssert(actual);
  }

  /**
   * Creates a new instance of <code>{@link org.ga4gh.GAIndividualAssert}</code>.
   *
   * @param actual the actual value.
   * @return the created assertion object.
   */
  public static org.ga4gh.GAIndividualAssert then(org.ga4gh.GAIndividual actual) {
    return new org.ga4gh.GAIndividualAssert(actual);
  }

  /**
   * Creates a new instance of <code>{@link org.ga4gh.GAIndividualGroupAssert}</code>.
   *
   * @param actual the actual value.
   * @return the created assertion object.
   */
  public static org.ga4gh.GAIndividualGroupAssert then(org.ga4gh.GAIndividualGroup actual) {
    return new org.ga4gh.GAIndividualGroupAssert(actual);
  }

  /**
   * Creates a new instance of <code>{@link org.ga4gh.GALinearAlignmentAssert}</code>.
   *
   * @param actual the actual value.
   * @return the created assertion object.
   */
  public static org.ga4gh.GALinearAlignmentAssert then(org.ga4gh.GALinearAlignment actual) {
    return new org.ga4gh.GALinearAlignmentAssert(actual);
  }

  /**
   * Creates a new instance of <code>{@link org.ga4gh.GAListReferenceBasesRequestAssert}</code>.
   *
   * @param actual the actual value.
   * @return the created assertion object.
   */
  public static org.ga4gh.GAListReferenceBasesRequestAssert then(org.ga4gh.GAListReferenceBasesRequest actual) {
    return new org.ga4gh.GAListReferenceBasesRequestAssert(actual);
  }

  /**
   * Creates a new instance of <code>{@link org.ga4gh.GAListReferenceBasesResponseAssert}</code>.
   *
   * @param actual the actual value.
   * @return the created assertion object.
   */
  public static org.ga4gh.GAListReferenceBasesResponseAssert then(org.ga4gh.GAListReferenceBasesResponse actual) {
    return new org.ga4gh.GAListReferenceBasesResponseAssert(actual);
  }

  /**
   * Creates a new instance of <code>{@link org.ga4gh.GAMetadataAssert}</code>.
   *
   * @param actual the actual value.
   * @return the created assertion object.
   */
  public static org.ga4gh.GAMetadataAssert then(org.ga4gh.GAMetadata actual) {
    return new org.ga4gh.GAMetadataAssert(actual);
  }

  /**
   * Creates a new instance of <code>{@link org.ga4gh.GAMetadataMethodsAssert}</code>.
   *
   * @param actual the actual value.
   * @return the created assertion object.
   */
  public static org.ga4gh.GAMetadataMethodsAssert then(org.ga4gh.GAMetadataMethods actual) {
    return new org.ga4gh.GAMetadataMethodsAssert(actual);
  }

  /**
   * Creates a new instance of <code>{@link org.ga4gh.GAOntologyTermAssert}</code>.
   *
   * @param actual the actual value.
   * @return the created assertion object.
   */
  public static org.ga4gh.GAOntologyTermAssert then(org.ga4gh.GAOntologyTerm actual) {
    return new org.ga4gh.GAOntologyTermAssert(actual);
  }

  /**
   * Creates a new instance of <code>{@link org.ga4gh.GAPositionAssert}</code>.
   *
   * @param actual the actual value.
   * @return the created assertion object.
   */
  public static org.ga4gh.GAPositionAssert then(org.ga4gh.GAPosition actual) {
    return new org.ga4gh.GAPositionAssert(actual);
  }

  /**
   * Creates a new instance of <code>{@link org.ga4gh.GAProgramAssert}</code>.
   *
   * @param actual the actual value.
   * @return the created assertion object.
   */
  public static org.ga4gh.GAProgramAssert then(org.ga4gh.GAProgram actual) {
    return new org.ga4gh.GAProgramAssert(actual);
  }

  /**
   * Creates a new instance of <code>{@link org.ga4gh.GAReadAlignmentAssert}</code>.
   *
   * @param actual the actual value.
   * @return the created assertion object.
   */
  public static org.ga4gh.GAReadAlignmentAssert then(org.ga4gh.GAReadAlignment actual) {
    return new org.ga4gh.GAReadAlignmentAssert(actual);
  }

  /**
   * Creates a new instance of <code>{@link org.ga4gh.GAReadGroupAssert}</code>.
   *
   * @param actual the actual value.
   * @return the created assertion object.
   */
  public static org.ga4gh.GAReadGroupAssert then(org.ga4gh.GAReadGroup actual) {
    return new org.ga4gh.GAReadGroupAssert(actual);
  }

  /**
   * Creates a new instance of <code>{@link org.ga4gh.GAReadGroupSetAssert}</code>.
   *
   * @param actual the actual value.
   * @return the created assertion object.
   */
  public static org.ga4gh.GAReadGroupSetAssert then(org.ga4gh.GAReadGroupSet actual) {
    return new org.ga4gh.GAReadGroupSetAssert(actual);
  }

  /**
   * Creates a new instance of <code>{@link org.ga4gh.GAReadMethodsAssert}</code>.
   *
   * @param actual the actual value.
   * @return the created assertion object.
   */
  public static org.ga4gh.GAReadMethodsAssert then(org.ga4gh.GAReadMethods actual) {
    return new org.ga4gh.GAReadMethodsAssert(actual);
  }

  /**
   * Creates a new instance of <code>{@link org.ga4gh.GAReadsAssert}</code>.
   *
   * @param actual the actual value.
   * @return the created assertion object.
   */
  public static org.ga4gh.GAReadsAssert then(org.ga4gh.GAReads actual) {
    return new org.ga4gh.GAReadsAssert(actual);
  }

  /**
   * Creates a new instance of <code>{@link org.ga4gh.GAReferenceAssert}</code>.
   *
   * @param actual the actual value.
   * @return the created assertion object.
   */
  public static org.ga4gh.GAReferenceAssert then(org.ga4gh.GAReference actual) {
    return new org.ga4gh.GAReferenceAssert(actual);
  }

  /**
   * Creates a new instance of <code>{@link org.ga4gh.GAReferenceMethodsAssert}</code>.
   *
   * @param actual the actual value.
   * @return the created assertion object.
   */
  public static org.ga4gh.GAReferenceMethodsAssert then(org.ga4gh.GAReferenceMethods actual) {
    return new org.ga4gh.GAReferenceMethodsAssert(actual);
  }

  /**
   * Creates a new instance of <code>{@link org.ga4gh.GAReferenceSetAssert}</code>.
   *
   * @param actual the actual value.
   * @return the created assertion object.
   */
  public static org.ga4gh.GAReferenceSetAssert then(org.ga4gh.GAReferenceSet actual) {
    return new org.ga4gh.GAReferenceSetAssert(actual);
  }

  /**
   * Creates a new instance of <code>{@link org.ga4gh.GAReferencesAssert}</code>.
   *
   * @param actual the actual value.
   * @return the created assertion object.
   */
  public static org.ga4gh.GAReferencesAssert then(org.ga4gh.GAReferences actual) {
    return new org.ga4gh.GAReferencesAssert(actual);
  }

  /**
   * Creates a new instance of <code>{@link org.ga4gh.GASampleAssert}</code>.
   *
   * @param actual the actual value.
   * @return the created assertion object.
   */
  public static org.ga4gh.GASampleAssert then(org.ga4gh.GASample actual) {
    return new org.ga4gh.GASampleAssert(actual);
  }

  /**
   * Creates a new instance of <code>{@link org.ga4gh.GASearchAnalysesRequestAssert}</code>.
   *
   * @param actual the actual value.
   * @return the created assertion object.
   */
  public static org.ga4gh.GASearchAnalysesRequestAssert then(org.ga4gh.GASearchAnalysesRequest actual) {
    return new org.ga4gh.GASearchAnalysesRequestAssert(actual);
  }

  /**
   * Creates a new instance of <code>{@link org.ga4gh.GASearchAnalysesResponseAssert}</code>.
   *
   * @param actual the actual value.
   * @return the created assertion object.
   */
  public static org.ga4gh.GASearchAnalysesResponseAssert then(org.ga4gh.GASearchAnalysesResponse actual) {
    return new org.ga4gh.GASearchAnalysesResponseAssert(actual);
  }

  /**
   * Creates a new instance of <code>{@link org.ga4gh.GASearchCallSetsRequestAssert}</code>.
   *
   * @param actual the actual value.
   * @return the created assertion object.
   */
  public static org.ga4gh.GASearchCallSetsRequestAssert then(org.ga4gh.GASearchCallSetsRequest actual) {
    return new org.ga4gh.GASearchCallSetsRequestAssert(actual);
  }

  /**
   * Creates a new instance of <code>{@link org.ga4gh.GASearchCallSetsResponseAssert}</code>.
   *
   * @param actual the actual value.
   * @return the created assertion object.
   */
  public static org.ga4gh.GASearchCallSetsResponseAssert then(org.ga4gh.GASearchCallSetsResponse actual) {
    return new org.ga4gh.GASearchCallSetsResponseAssert(actual);
  }

  /**
   * Creates a new instance of <code>{@link org.ga4gh.GASearchExperimentsRequestAssert}</code>.
   *
   * @param actual the actual value.
   * @return the created assertion object.
   */
  public static org.ga4gh.GASearchExperimentsRequestAssert then(org.ga4gh.GASearchExperimentsRequest actual) {
    return new org.ga4gh.GASearchExperimentsRequestAssert(actual);
  }

  /**
   * Creates a new instance of <code>{@link org.ga4gh.GASearchExperimentsResponseAssert}</code>.
   *
   * @param actual the actual value.
   * @return the created assertion object.
   */
  public static org.ga4gh.GASearchExperimentsResponseAssert then(org.ga4gh.GASearchExperimentsResponse actual) {
    return new org.ga4gh.GASearchExperimentsResponseAssert(actual);
  }

  /**
   * Creates a new instance of <code>{@link org.ga4gh.GASearchIndividualGroupsRequestAssert}</code>.
   *
   * @param actual the actual value.
   * @return the created assertion object.
   */
  public static org.ga4gh.GASearchIndividualGroupsRequestAssert then(org.ga4gh.GASearchIndividualGroupsRequest actual) {
    return new org.ga4gh.GASearchIndividualGroupsRequestAssert(actual);
  }

  /**
   * Creates a new instance of <code>{@link org.ga4gh.GASearchIndividualGroupsResponseAssert}</code>.
   *
   * @param actual the actual value.
   * @return the created assertion object.
   */
  public static org.ga4gh.GASearchIndividualGroupsResponseAssert then(org.ga4gh.GASearchIndividualGroupsResponse actual) {
    return new org.ga4gh.GASearchIndividualGroupsResponseAssert(actual);
  }

  /**
   * Creates a new instance of <code>{@link org.ga4gh.GASearchIndividualsRequestAssert}</code>.
   *
   * @param actual the actual value.
   * @return the created assertion object.
   */
  public static org.ga4gh.GASearchIndividualsRequestAssert then(org.ga4gh.GASearchIndividualsRequest actual) {
    return new org.ga4gh.GASearchIndividualsRequestAssert(actual);
  }

  /**
   * Creates a new instance of <code>{@link org.ga4gh.GASearchIndividualsResponseAssert}</code>.
   *
   * @param actual the actual value.
   * @return the created assertion object.
   */
  public static org.ga4gh.GASearchIndividualsResponseAssert then(org.ga4gh.GASearchIndividualsResponse actual) {
    return new org.ga4gh.GASearchIndividualsResponseAssert(actual);
  }

  /**
   * Creates a new instance of <code>{@link org.ga4gh.GASearchReadGroupSetsRequestAssert}</code>.
   *
   * @param actual the actual value.
   * @return the created assertion object.
   */
  public static org.ga4gh.GASearchReadGroupSetsRequestAssert then(org.ga4gh.GASearchReadGroupSetsRequest actual) {
    return new org.ga4gh.GASearchReadGroupSetsRequestAssert(actual);
  }

  /**
   * Creates a new instance of <code>{@link org.ga4gh.GASearchReadGroupSetsResponseAssert}</code>.
   *
   * @param actual the actual value.
   * @return the created assertion object.
   */
  public static org.ga4gh.GASearchReadGroupSetsResponseAssert then(org.ga4gh.GASearchReadGroupSetsResponse actual) {
    return new org.ga4gh.GASearchReadGroupSetsResponseAssert(actual);
  }

  /**
   * Creates a new instance of <code>{@link org.ga4gh.GASearchReadsRequestAssert}</code>.
   *
   * @param actual the actual value.
   * @return the created assertion object.
   */
  public static org.ga4gh.GASearchReadsRequestAssert then(org.ga4gh.GASearchReadsRequest actual) {
    return new org.ga4gh.GASearchReadsRequestAssert(actual);
  }

  /**
   * Creates a new instance of <code>{@link org.ga4gh.GASearchReadsResponseAssert}</code>.
   *
   * @param actual the actual value.
   * @return the created assertion object.
   */
  public static org.ga4gh.GASearchReadsResponseAssert then(org.ga4gh.GASearchReadsResponse actual) {
    return new org.ga4gh.GASearchReadsResponseAssert(actual);
  }

  /**
   * Creates a new instance of <code>{@link org.ga4gh.GASearchReferenceSetsRequestAssert}</code>.
   *
   * @param actual the actual value.
   * @return the created assertion object.
   */
  public static org.ga4gh.GASearchReferenceSetsRequestAssert then(org.ga4gh.GASearchReferenceSetsRequest actual) {
    return new org.ga4gh.GASearchReferenceSetsRequestAssert(actual);
  }

  /**
   * Creates a new instance of <code>{@link org.ga4gh.GASearchReferenceSetsResponseAssert}</code>.
   *
   * @param actual the actual value.
   * @return the created assertion object.
   */
  public static org.ga4gh.GASearchReferenceSetsResponseAssert then(org.ga4gh.GASearchReferenceSetsResponse actual) {
    return new org.ga4gh.GASearchReferenceSetsResponseAssert(actual);
  }

  /**
   * Creates a new instance of <code>{@link org.ga4gh.GASearchReferencesRequestAssert}</code>.
   *
   * @param actual the actual value.
   * @return the created assertion object.
   */
  public static org.ga4gh.GASearchReferencesRequestAssert then(org.ga4gh.GASearchReferencesRequest actual) {
    return new org.ga4gh.GASearchReferencesRequestAssert(actual);
  }

  /**
   * Creates a new instance of <code>{@link org.ga4gh.GASearchReferencesResponseAssert}</code>.
   *
   * @param actual the actual value.
   * @return the created assertion object.
   */
  public static org.ga4gh.GASearchReferencesResponseAssert then(org.ga4gh.GASearchReferencesResponse actual) {
    return new org.ga4gh.GASearchReferencesResponseAssert(actual);
  }

  /**
   * Creates a new instance of <code>{@link org.ga4gh.GASearchSamplesRequestAssert}</code>.
   *
   * @param actual the actual value.
   * @return the created assertion object.
   */
  public static org.ga4gh.GASearchSamplesRequestAssert then(org.ga4gh.GASearchSamplesRequest actual) {
    return new org.ga4gh.GASearchSamplesRequestAssert(actual);
  }

  /**
   * Creates a new instance of <code>{@link org.ga4gh.GASearchSamplesResponseAssert}</code>.
   *
   * @param actual the actual value.
   * @return the created assertion object.
   */
  public static org.ga4gh.GASearchSamplesResponseAssert then(org.ga4gh.GASearchSamplesResponse actual) {
    return new org.ga4gh.GASearchSamplesResponseAssert(actual);
  }

  /**
   * Creates a new instance of <code>{@link org.ga4gh.GASearchVariantSetsRequestAssert}</code>.
   *
   * @param actual the actual value.
   * @return the created assertion object.
   */
  public static org.ga4gh.GASearchVariantSetsRequestAssert then(org.ga4gh.GASearchVariantSetsRequest actual) {
    return new org.ga4gh.GASearchVariantSetsRequestAssert(actual);
  }

  /**
   * Creates a new instance of <code>{@link org.ga4gh.GASearchVariantSetsResponseAssert}</code>.
   *
   * @param actual the actual value.
   * @return the created assertion object.
   */
  public static org.ga4gh.GASearchVariantSetsResponseAssert then(org.ga4gh.GASearchVariantSetsResponse actual) {
    return new org.ga4gh.GASearchVariantSetsResponseAssert(actual);
  }

  /**
   * Creates a new instance of <code>{@link org.ga4gh.GASearchVariantsRequestAssert}</code>.
   *
   * @param actual the actual value.
   * @return the created assertion object.
   */
  public static org.ga4gh.GASearchVariantsRequestAssert then(org.ga4gh.GASearchVariantsRequest actual) {
    return new org.ga4gh.GASearchVariantsRequestAssert(actual);
  }

  /**
   * Creates a new instance of <code>{@link org.ga4gh.GASearchVariantsResponseAssert}</code>.
   *
   * @param actual the actual value.
   * @return the created assertion object.
   */
  public static org.ga4gh.GASearchVariantsResponseAssert then(org.ga4gh.GASearchVariantsResponse actual) {
    return new org.ga4gh.GASearchVariantsResponseAssert(actual);
  }

  /**
   * Creates a new instance of <code>{@link org.ga4gh.GASexAssert}</code>.
   *
   * @param actual the actual value.
   * @return the created assertion object.
   */
  public static org.ga4gh.GASexAssert then(org.ga4gh.GASex actual) {
    return new org.ga4gh.GASexAssert(actual);
  }

  /**
   * Creates a new instance of <code>{@link org.ga4gh.GAVariantAssert}</code>.
   *
   * @param actual the actual value.
   * @return the created assertion object.
   */
  public static org.ga4gh.GAVariantAssert then(org.ga4gh.GAVariant actual) {
    return new org.ga4gh.GAVariantAssert(actual);
  }

  /**
   * Creates a new instance of <code>{@link org.ga4gh.GAVariantMethodsAssert}</code>.
   *
   * @param actual the actual value.
   * @return the created assertion object.
   */
  public static org.ga4gh.GAVariantMethodsAssert then(org.ga4gh.GAVariantMethods actual) {
    return new org.ga4gh.GAVariantMethodsAssert(actual);
  }

  /**
   * Creates a new instance of <code>{@link org.ga4gh.GAVariantSetAssert}</code>.
   *
   * @param actual the actual value.
   * @return the created assertion object.
   */
  public static org.ga4gh.GAVariantSetAssert then(org.ga4gh.GAVariantSet actual) {
    return new org.ga4gh.GAVariantSetAssert(actual);
  }

  /**
   * Creates a new instance of <code>{@link org.ga4gh.GAVariantSetMetadataAssert}</code>.
   *
   * @param actual the actual value.
   * @return the created assertion object.
   */
  public static org.ga4gh.GAVariantSetMetadataAssert then(org.ga4gh.GAVariantSetMetadata actual) {
    return new org.ga4gh.GAVariantSetMetadataAssert(actual);
  }

  /**
   * Creates a new instance of <code>{@link org.ga4gh.GAVariantsAssert}</code>.
   *
   * @param actual the actual value.
   * @return the created assertion object.
   */
  public static org.ga4gh.GAVariantsAssert then(org.ga4gh.GAVariants actual) {
    return new org.ga4gh.GAVariantsAssert(actual);
  }

  /**
   * Creates a new instance of <code>{@link org.ga4gh.ctk.transport.RespCodeAssert}</code>.
   *
   * @param actual the actual value.
   * @return the created assertion object.
   */
  public static org.ga4gh.ctk.transport.RespCodeAssert then(org.ga4gh.ctk.transport.RespCode actual) {
    return new org.ga4gh.ctk.transport.RespCodeAssert(actual);
  }

  /**
   * Creates a new instance of <code>{@link org.ga4gh.ctk.transport.WireTrackerAssert}</code>.
   *
   * @param actual the actual value.
   * @return the created assertion object.
   */
  public static org.ga4gh.ctk.transport.WireTrackerAssert then(org.ga4gh.ctk.transport.WireTracker actual) {
    return new org.ga4gh.ctk.transport.WireTrackerAssert(actual);
  }

  /**
   * Creates a new <code>{@link BddAssertions}</code>.
   */
  protected BddAssertions() {
    // empty
  }
}
