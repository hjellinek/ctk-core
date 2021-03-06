package org.ga4gh;

import org.assertj.core.api.AbstractAssert;
import org.assertj.core.api.Assertions;
import org.assertj.core.internal.Iterables;
import org.assertj.core.util.Objects;

/**
 * {@link GAReference.Builder} specific assertions - Generated by CustomAssertionGenerator.
 */
public class GAReferenceBuilderAssert extends AbstractAssert<GAReferenceBuilderAssert, GAReference.Builder> {

  /**
   * Creates a new <code>{@link GAReferenceBuilderAssert}</code> to make assertions on actual GAReference.Builder.
   * @param actual the GAReference.Builder we want to make assertions on.
   */
  public GAReferenceBuilderAssert(GAReference.Builder actual) {
    super(actual, GAReferenceBuilderAssert.class);
  }

  /**
   * An entry point for GAReferenceBuilderAssert to follow AssertJ standard <code>assertThat()</code> statements.<br>
   * With a static import, one can write directly: <code>assertThat(myGAReference.Builder)</code> and get specific assertion with code completion.
   * @param actual the GAReference.Builder we want to make assertions on.
   * @return a new <code>{@link GAReferenceBuilderAssert}</code>
   */
  public static GAReferenceBuilderAssert assertThat(GAReference.Builder actual) {
    return new GAReferenceBuilderAssert(actual);
  }

  /**
   * Verifies that the actual GAReference.Builder's id is equal to the given one.
   * @param id the given id to compare the actual GAReference.Builder's id to.
   * @return this assertion object.
   * @throws AssertionError - if the actual GAReference.Builder's id is not equal to the given one.
   */
  public GAReferenceBuilderAssert hasId(String id) {
    // check that actual GAReference.Builder we want to make assertions on is not null.
    isNotNull();

    // overrides the default error message with a more explicit one
    String assertjErrorMessage = "\nExpecting id of:\n  <%s>\nto be:\n  <%s>\nbut was:\n  <%s>";
    
    // null safe check
    String actualId = actual.getId();
    if (!Objects.areEqual(actualId, id)) {
      failWithMessage(assertjErrorMessage, actual, id, actualId);
    }

    // return the current assertion for method chaining
    return this;
  }

  /**
   * Verifies that the actual GAReference.Builder's isDerived is equal to the given one.
   * @param isDerived the given isDerived to compare the actual GAReference.Builder's isDerived to.
   * @return this assertion object.
   * @throws AssertionError - if the actual GAReference.Builder's isDerived is not equal to the given one.
   */
  public GAReferenceBuilderAssert hasIsDerived(Boolean isDerived) {
    // check that actual GAReference.Builder we want to make assertions on is not null.
    isNotNull();

    // overrides the default error message with a more explicit one
    String assertjErrorMessage = "\nExpecting isDerived of:\n  <%s>\nto be:\n  <%s>\nbut was:\n  <%s>";
    
    // null safe check
    Boolean actualIsDerived = actual.getIsDerived();
    if (!Objects.areEqual(actualIsDerived, isDerived)) {
      failWithMessage(assertjErrorMessage, actual, isDerived, actualIsDerived);
    }

    // return the current assertion for method chaining
    return this;
  }

  /**
   * Verifies that the actual GAReference.Builder's length is equal to the given one.
   * @param length the given length to compare the actual GAReference.Builder's length to.
   * @return this assertion object.
   * @throws AssertionError - if the actual GAReference.Builder's length is not equal to the given one.
   */
  public GAReferenceBuilderAssert hasLength(Long length) {
    // check that actual GAReference.Builder we want to make assertions on is not null.
    isNotNull();

    // overrides the default error message with a more explicit one
    String assertjErrorMessage = "\nExpecting length of:\n  <%s>\nto be:\n  <%s>\nbut was:\n  <%s>";
    
    // null safe check
    Long actualLength = actual.getLength();
    if (!Objects.areEqual(actualLength, length)) {
      failWithMessage(assertjErrorMessage, actual, length, actualLength);
    }

    // return the current assertion for method chaining
    return this;
  }

  /**
   * Verifies that the actual GAReference.Builder's md5checksum is equal to the given one.
   * @param md5checksum the given md5checksum to compare the actual GAReference.Builder's md5checksum to.
   * @return this assertion object.
   * @throws AssertionError - if the actual GAReference.Builder's md5checksum is not equal to the given one.
   */
  public GAReferenceBuilderAssert hasMd5checksum(String md5checksum) {
    // check that actual GAReference.Builder we want to make assertions on is not null.
    isNotNull();

    // overrides the default error message with a more explicit one
    String assertjErrorMessage = "\nExpecting md5checksum of:\n  <%s>\nto be:\n  <%s>\nbut was:\n  <%s>";
    
    // null safe check
    String actualMd5checksum = actual.getMd5checksum();
    if (!Objects.areEqual(actualMd5checksum, md5checksum)) {
      failWithMessage(assertjErrorMessage, actual, md5checksum, actualMd5checksum);
    }

    // return the current assertion for method chaining
    return this;
  }

  /**
   * Verifies that the actual GAReference.Builder's name is equal to the given one.
   * @param name the given name to compare the actual GAReference.Builder's name to.
   * @return this assertion object.
   * @throws AssertionError - if the actual GAReference.Builder's name is not equal to the given one.
   */
  public GAReferenceBuilderAssert hasName(String name) {
    // check that actual GAReference.Builder we want to make assertions on is not null.
    isNotNull();

    // overrides the default error message with a more explicit one
    String assertjErrorMessage = "\nExpecting name of:\n  <%s>\nto be:\n  <%s>\nbut was:\n  <%s>";
    
    // null safe check
    String actualName = actual.getName();
    if (!Objects.areEqual(actualName, name)) {
      failWithMessage(assertjErrorMessage, actual, name, actualName);
    }

    // return the current assertion for method chaining
    return this;
  }

  /**
   * Verifies that the actual GAReference.Builder's ncbiTaxonId is equal to the given one.
   * @param ncbiTaxonId the given ncbiTaxonId to compare the actual GAReference.Builder's ncbiTaxonId to.
   * @return this assertion object.
   * @throws AssertionError - if the actual GAReference.Builder's ncbiTaxonId is not equal to the given one.
   */
  public GAReferenceBuilderAssert hasNcbiTaxonId(Integer ncbiTaxonId) {
    // check that actual GAReference.Builder we want to make assertions on is not null.
    isNotNull();

    // overrides the default error message with a more explicit one
    String assertjErrorMessage = "\nExpecting ncbiTaxonId of:\n  <%s>\nto be:\n  <%s>\nbut was:\n  <%s>";
    
    // null safe check
    Integer actualNcbiTaxonId = actual.getNcbiTaxonId();
    if (!Objects.areEqual(actualNcbiTaxonId, ncbiTaxonId)) {
      failWithMessage(assertjErrorMessage, actual, ncbiTaxonId, actualNcbiTaxonId);
    }

    // return the current assertion for method chaining
    return this;
  }

  /**
   * Verifies that the actual GAReference.Builder's sourceAccessions contains the given String elements.
   * @param sourceAccessions the given elements that should be contained in actual GAReference.Builder's sourceAccessions.
   * @return this assertion object.
   * @throws AssertionError if the actual GAReference.Builder's sourceAccessions does not contain all given String elements.
   */
  public GAReferenceBuilderAssert hasSourceAccessions(String... sourceAccessions) {
    // check that actual GAReference.Builder we want to make assertions on is not null.
    isNotNull();

    // check that given String varargs is not null.
    if (sourceAccessions == null) failWithMessage("Expecting sourceAccessions parameter not to be null.");
    
    // check with standard error message, to set another message call: info.overridingErrorMessage("my error message");
    Iterables.instance().assertContains(info, actual.getSourceAccessions(), sourceAccessions);

    // return the current assertion for method chaining
    return this;
  }

  /**
   * Verifies that the actual GAReference.Builder's sourceAccessions contains <b>only<b> the given String elements and nothing else in whatever order.
   * @param sourceAccessions the given elements that should be contained in actual GAReference.Builder's sourceAccessions.
   * @return this assertion object.
   * @throws AssertionError if the actual GAReference.Builder's sourceAccessions does not contain all given String elements.
   */
  public GAReferenceBuilderAssert hasOnlySourceAccessions(String... sourceAccessions) {
    // check that actual GAReference.Builder we want to make assertions on is not null.
    isNotNull();

    // check that given String varargs is not null.
    if (sourceAccessions == null) failWithMessage("Expecting sourceAccessions parameter not to be null.");
    
    // check with standard error message, to set another message call: info.overridingErrorMessage("my error message");
    Iterables.instance().assertContainsOnly(info, actual.getSourceAccessions(), sourceAccessions);

    // return the current assertion for method chaining
    return this;
  }

  /**
   * Verifies that the actual GAReference.Builder's sourceAccessions does not contain the given String elements.
   *
   * @param sourceAccessions the given elements that should not be in actual GAReference.Builder's sourceAccessions.
   * @return this assertion object.
   * @throws AssertionError if the actual GAReference.Builder's sourceAccessions contains any given String elements.
   */
  public GAReferenceBuilderAssert doesNotHaveSourceAccessions(String... sourceAccessions) {
    // check that actual GAReference.Builder we want to make assertions on is not null.
    isNotNull();

    // check that given String varargs is not null.
    if (sourceAccessions == null) failWithMessage("Expecting sourceAccessions parameter not to be null.");
    
    // check with standard error message (use overridingErrorMessage before contains to set your own message).
    Iterables.instance().assertDoesNotContain(info, actual.getSourceAccessions(), sourceAccessions);

    // return the current assertion for method chaining
    return this;
  }

  /**
   * Verifies that the actual GAReference.Builder has no sourceAccessions.
   * @return this assertion object.
   * @throws AssertionError if the actual GAReference.Builder's sourceAccessions is not empty.
   */
  public GAReferenceBuilderAssert hasNoSourceAccessions() {
    // check that actual GAReference.Builder we want to make assertions on is not null.
    isNotNull();

    // we override the default error message with a more explicit one
    String assertjErrorMessage = "\nExpecting :\n  <%s>\nnot to have sourceAccessions but had :\n  <%s>";
    
    // check
    if (actual.getSourceAccessions().iterator().hasNext()) {
      failWithMessage(assertjErrorMessage, actual, actual.getSourceAccessions());
    }
    
    // return the current assertion for method chaining
    return this;
  }
  

  /**
   * Verifies that the actual GAReference.Builder's sourceDivergence is close to the given value by less than the given offset.
   * <p>
   * If difference is equal to the offset value, assertion is considered successful.
   * @param sourceDivergence the value to compare the actual GAReference.Builder's sourceDivergence to.
   * @param offset the given offset.
   * @return this assertion object.
   * @throws AssertionError - if the actual GAReference.Builder's sourceDivergence is not close enough to the given value.
   */
  public GAReferenceBuilderAssert hasSourceDivergence(Float sourceDivergence, Float offset) {
    // check that actual GAReference.Builder we want to make assertions on is not null.
    isNotNull();

    Float actualSourceDivergence = actual.getSourceDivergence();
    
    // overrides the default error message with a more explicit one
    String assertjErrorMessage = String.format("\nExpecting sourceDivergence:\n  <%s>\nto be close to:\n  <%s>\nby less than <%s> but difference was <%s>",
                                               actualSourceDivergence, sourceDivergence, offset, Math.abs(sourceDivergence - actualSourceDivergence));
    
    // check
    Assertions.assertThat(actualSourceDivergence).overridingErrorMessage(assertjErrorMessage).isCloseTo(sourceDivergence, Assertions.within(offset));

    // return the current assertion for method chaining
    return this;
  }

  /**
   * Verifies that the actual GAReference.Builder's sourceURI is equal to the given one.
   * @param sourceURI the given sourceURI to compare the actual GAReference.Builder's sourceURI to.
   * @return this assertion object.
   * @throws AssertionError - if the actual GAReference.Builder's sourceURI is not equal to the given one.
   */
  public GAReferenceBuilderAssert hasSourceURI(String sourceURI) {
    // check that actual GAReference.Builder we want to make assertions on is not null.
    isNotNull();

    // overrides the default error message with a more explicit one
    String assertjErrorMessage = "\nExpecting sourceURI of:\n  <%s>\nto be:\n  <%s>\nbut was:\n  <%s>";
    
    // null safe check
    String actualSourceURI = actual.getSourceURI();
    if (!Objects.areEqual(actualSourceURI, sourceURI)) {
      failWithMessage(assertjErrorMessage, actual, sourceURI, actualSourceURI);
    }

    // return the current assertion for method chaining
    return this;
  }

  /**
   * Verifies that the actual GAReference.Builder has id.
   * @return this assertion object.
   * @throws AssertionError - if the actual GAReference.Builder does not have id.
   */
  public GAReferenceBuilderAssert hasId() {
    // check that actual GAReference.Builder we want to make assertions on is not null.
    isNotNull();

    // check
    if (!actual.hasId()) {
      failWithMessage("\nExpecting that actual GAReference.Builder has id but does not have.");
    }
    
    // return the current assertion for method chaining
    return this;
  }

  /**
   * Verifies that the actual GAReference.Builder does not have id.
   * @return this assertion object.
   * @throws AssertionError - if the actual GAReference.Builder has id.
   */
  public GAReferenceBuilderAssert doesNotHaveId() {
    // check that actual GAReference.Builder we want to make assertions on is not null.
    isNotNull();

    // check
    if (actual.hasId()) {
      failWithMessage("\nExpecting that actual GAReference.Builder does not have id but has.");
    }
    
    // return the current assertion for method chaining
    return this;
  }

  /**
   * Verifies that the actual GAReference.Builder has is derived.
   * @return this assertion object.
   * @throws AssertionError - if the actual GAReference.Builder does not have is derived.
   */
  public GAReferenceBuilderAssert hasIsDerived() {
    // check that actual GAReference.Builder we want to make assertions on is not null.
    isNotNull();

    // check
    if (!actual.hasIsDerived()) {
      failWithMessage("\nExpecting that actual GAReference.Builder has is derived but does not have.");
    }
    
    // return the current assertion for method chaining
    return this;
  }

  /**
   * Verifies that the actual GAReference.Builder does not have is derived.
   * @return this assertion object.
   * @throws AssertionError - if the actual GAReference.Builder has is derived.
   */
  public GAReferenceBuilderAssert doesNotHaveIsDerived() {
    // check that actual GAReference.Builder we want to make assertions on is not null.
    isNotNull();

    // check
    if (actual.hasIsDerived()) {
      failWithMessage("\nExpecting that actual GAReference.Builder does not have is derived but has.");
    }
    
    // return the current assertion for method chaining
    return this;
  }

  /**
   * Verifies that the actual GAReference.Builder has length.
   * @return this assertion object.
   * @throws AssertionError - if the actual GAReference.Builder does not have length.
   */
  public GAReferenceBuilderAssert hasLength() {
    // check that actual GAReference.Builder we want to make assertions on is not null.
    isNotNull();

    // check
    if (!actual.hasLength()) {
      failWithMessage("\nExpecting that actual GAReference.Builder has length but does not have.");
    }
    
    // return the current assertion for method chaining
    return this;
  }

  /**
   * Verifies that the actual GAReference.Builder does not have length.
   * @return this assertion object.
   * @throws AssertionError - if the actual GAReference.Builder has length.
   */
  public GAReferenceBuilderAssert doesNotHaveLength() {
    // check that actual GAReference.Builder we want to make assertions on is not null.
    isNotNull();

    // check
    if (actual.hasLength()) {
      failWithMessage("\nExpecting that actual GAReference.Builder does not have length but has.");
    }
    
    // return the current assertion for method chaining
    return this;
  }

  /**
   * Verifies that the actual GAReference.Builder has md5checksum.
   * @return this assertion object.
   * @throws AssertionError - if the actual GAReference.Builder does not have md5checksum.
   */
  public GAReferenceBuilderAssert hasMd5checksum() {
    // check that actual GAReference.Builder we want to make assertions on is not null.
    isNotNull();

    // check
    if (!actual.hasMd5checksum()) {
      failWithMessage("\nExpecting that actual GAReference.Builder has md5checksum but does not have.");
    }
    
    // return the current assertion for method chaining
    return this;
  }

  /**
   * Verifies that the actual GAReference.Builder does not have md5checksum.
   * @return this assertion object.
   * @throws AssertionError - if the actual GAReference.Builder has md5checksum.
   */
  public GAReferenceBuilderAssert doesNotHaveMd5checksum() {
    // check that actual GAReference.Builder we want to make assertions on is not null.
    isNotNull();

    // check
    if (actual.hasMd5checksum()) {
      failWithMessage("\nExpecting that actual GAReference.Builder does not have md5checksum but has.");
    }
    
    // return the current assertion for method chaining
    return this;
  }

  /**
   * Verifies that the actual GAReference.Builder has name.
   * @return this assertion object.
   * @throws AssertionError - if the actual GAReference.Builder does not have name.
   */
  public GAReferenceBuilderAssert hasName() {
    // check that actual GAReference.Builder we want to make assertions on is not null.
    isNotNull();

    // check
    if (!actual.hasName()) {
      failWithMessage("\nExpecting that actual GAReference.Builder has name but does not have.");
    }
    
    // return the current assertion for method chaining
    return this;
  }

  /**
   * Verifies that the actual GAReference.Builder does not have name.
   * @return this assertion object.
   * @throws AssertionError - if the actual GAReference.Builder has name.
   */
  public GAReferenceBuilderAssert doesNotHaveName() {
    // check that actual GAReference.Builder we want to make assertions on is not null.
    isNotNull();

    // check
    if (actual.hasName()) {
      failWithMessage("\nExpecting that actual GAReference.Builder does not have name but has.");
    }
    
    // return the current assertion for method chaining
    return this;
  }

  /**
   * Verifies that the actual GAReference.Builder has ncbi taxon id.
   * @return this assertion object.
   * @throws AssertionError - if the actual GAReference.Builder does not have ncbi taxon id.
   */
  public GAReferenceBuilderAssert hasNcbiTaxonId() {
    // check that actual GAReference.Builder we want to make assertions on is not null.
    isNotNull();

    // check
    if (!actual.hasNcbiTaxonId()) {
      failWithMessage("\nExpecting that actual GAReference.Builder has ncbi taxon id but does not have.");
    }
    
    // return the current assertion for method chaining
    return this;
  }

  /**
   * Verifies that the actual GAReference.Builder does not have ncbi taxon id.
   * @return this assertion object.
   * @throws AssertionError - if the actual GAReference.Builder has ncbi taxon id.
   */
  public GAReferenceBuilderAssert doesNotHaveNcbiTaxonId() {
    // check that actual GAReference.Builder we want to make assertions on is not null.
    isNotNull();

    // check
    if (actual.hasNcbiTaxonId()) {
      failWithMessage("\nExpecting that actual GAReference.Builder does not have ncbi taxon id but has.");
    }
    
    // return the current assertion for method chaining
    return this;
  }

  /**
   * Verifies that the actual GAReference.Builder has source accessions.
   * @return this assertion object.
   * @throws AssertionError - if the actual GAReference.Builder does not have source accessions.
   */
  public GAReferenceBuilderAssert hasSourceAccessions() {
    // check that actual GAReference.Builder we want to make assertions on is not null.
    isNotNull();

    // check
    if (!actual.hasSourceAccessions()) {
      failWithMessage("\nExpecting that actual GAReference.Builder has source accessions but does not have.");
    }
    
    // return the current assertion for method chaining
    return this;
  }

  /**
   * Verifies that the actual GAReference.Builder does not have source accessions.
   * @return this assertion object.
   * @throws AssertionError - if the actual GAReference.Builder has source accessions.
   */
  public GAReferenceBuilderAssert doesNotHaveSourceAccessions() {
    // check that actual GAReference.Builder we want to make assertions on is not null.
    isNotNull();

    // check
    if (actual.hasSourceAccessions()) {
      failWithMessage("\nExpecting that actual GAReference.Builder does not have source accessions but has.");
    }
    
    // return the current assertion for method chaining
    return this;
  }

  /**
   * Verifies that the actual GAReference.Builder has source divergence.
   * @return this assertion object.
   * @throws AssertionError - if the actual GAReference.Builder does not have source divergence.
   */
  public GAReferenceBuilderAssert hasSourceDivergence() {
    // check that actual GAReference.Builder we want to make assertions on is not null.
    isNotNull();

    // check
    if (!actual.hasSourceDivergence()) {
      failWithMessage("\nExpecting that actual GAReference.Builder has source divergence but does not have.");
    }
    
    // return the current assertion for method chaining
    return this;
  }

  /**
   * Verifies that the actual GAReference.Builder does not have source divergence.
   * @return this assertion object.
   * @throws AssertionError - if the actual GAReference.Builder has source divergence.
   */
  public GAReferenceBuilderAssert doesNotHaveSourceDivergence() {
    // check that actual GAReference.Builder we want to make assertions on is not null.
    isNotNull();

    // check
    if (actual.hasSourceDivergence()) {
      failWithMessage("\nExpecting that actual GAReference.Builder does not have source divergence but has.");
    }
    
    // return the current assertion for method chaining
    return this;
  }

  /**
   * Verifies that the actual GAReference.Builder has source u r i.
   * @return this assertion object.
   * @throws AssertionError - if the actual GAReference.Builder does not have source u r i.
   */
  public GAReferenceBuilderAssert hasSourceURI() {
    // check that actual GAReference.Builder we want to make assertions on is not null.
    isNotNull();

    // check
    if (!actual.hasSourceURI()) {
      failWithMessage("\nExpecting that actual GAReference.Builder has source u r i but does not have.");
    }
    
    // return the current assertion for method chaining
    return this;
  }

  /**
   * Verifies that the actual GAReference.Builder does not have source u r i.
   * @return this assertion object.
   * @throws AssertionError - if the actual GAReference.Builder has source u r i.
   */
  public GAReferenceBuilderAssert doesNotHaveSourceURI() {
    // check that actual GAReference.Builder we want to make assertions on is not null.
    isNotNull();

    // check
    if (actual.hasSourceURI()) {
      failWithMessage("\nExpecting that actual GAReference.Builder does not have source u r i but has.");
    }
    
    // return the current assertion for method chaining
    return this;
  }

}
