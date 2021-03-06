package org.ga4gh;

import org.assertj.core.api.AbstractAssert;
import org.assertj.core.internal.Iterables;
import org.assertj.core.util.Objects;

/**
 * {@link GASearchCallSetsRequest} specific assertions - Generated by CustomAssertionGenerator.
 */
public class GASearchCallSetsRequestAssert extends AbstractAssert<GASearchCallSetsRequestAssert, GASearchCallSetsRequest> {

  /**
   * Creates a new <code>{@link GASearchCallSetsRequestAssert}</code> to make assertions on actual GASearchCallSetsRequest.
   * @param actual the GASearchCallSetsRequest we want to make assertions on.
   */
  public GASearchCallSetsRequestAssert(GASearchCallSetsRequest actual) {
    super(actual, GASearchCallSetsRequestAssert.class);
  }

  /**
   * An entry point for GASearchCallSetsRequestAssert to follow AssertJ standard <code>assertThat()</code> statements.<br>
   * With a static import, one can write directly: <code>assertThat(myGASearchCallSetsRequest)</code> and get specific assertion with code completion.
   * @param actual the GASearchCallSetsRequest we want to make assertions on.
   * @return a new <code>{@link GASearchCallSetsRequestAssert}</code>
   */
  public static GASearchCallSetsRequestAssert assertThat(GASearchCallSetsRequest actual) {
    return new GASearchCallSetsRequestAssert(actual);
  }

  /**
   * Verifies that the actual GASearchCallSetsRequest's classSchema is equal to the given one.
   * @param classSchema the given classSchema to compare the actual GASearchCallSetsRequest's classSchema to.
   * @return this assertion object.
   * @throws AssertionError - if the actual GASearchCallSetsRequest's classSchema is not equal to the given one.
   */
  public GASearchCallSetsRequestAssert hasClassSchema(org.apache.avro.Schema classSchema) {
    // check that actual GASearchCallSetsRequest we want to make assertions on is not null.
    isNotNull();

    // overrides the default error message with a more explicit one
    String assertjErrorMessage = "\nExpecting classSchema of:\n  <%s>\nto be:\n  <%s>\nbut was:\n  <%s>";
    
    // null safe check
    org.apache.avro.Schema actualClassSchema = actual.getClassSchema();
    if (!Objects.areEqual(actualClassSchema, classSchema)) {
      failWithMessage(assertjErrorMessage, actual, classSchema, actualClassSchema);
    }

    // return the current assertion for method chaining
    return this;
  }

  /**
   * Verifies that the actual GASearchCallSetsRequest's name is equal to the given one.
   * @param name the given name to compare the actual GASearchCallSetsRequest's name to.
   * @return this assertion object.
   * @throws AssertionError - if the actual GASearchCallSetsRequest's name is not equal to the given one.
   */
  public GASearchCallSetsRequestAssert hasName(String name) {
    // check that actual GASearchCallSetsRequest we want to make assertions on is not null.
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
   * Verifies that the actual GASearchCallSetsRequest's pageSize is equal to the given one.
   * @param pageSize the given pageSize to compare the actual GASearchCallSetsRequest's pageSize to.
   * @return this assertion object.
   * @throws AssertionError - if the actual GASearchCallSetsRequest's pageSize is not equal to the given one.
   */
  public GASearchCallSetsRequestAssert hasPageSize(Integer pageSize) {
    // check that actual GASearchCallSetsRequest we want to make assertions on is not null.
    isNotNull();

    // overrides the default error message with a more explicit one
    String assertjErrorMessage = "\nExpecting pageSize of:\n  <%s>\nto be:\n  <%s>\nbut was:\n  <%s>";
    
    // null safe check
    Integer actualPageSize = actual.getPageSize();
    if (!Objects.areEqual(actualPageSize, pageSize)) {
      failWithMessage(assertjErrorMessage, actual, pageSize, actualPageSize);
    }

    // return the current assertion for method chaining
    return this;
  }

  /**
   * Verifies that the actual GASearchCallSetsRequest's pageToken is equal to the given one.
   * @param pageToken the given pageToken to compare the actual GASearchCallSetsRequest's pageToken to.
   * @return this assertion object.
   * @throws AssertionError - if the actual GASearchCallSetsRequest's pageToken is not equal to the given one.
   */
  public GASearchCallSetsRequestAssert hasPageToken(String pageToken) {
    // check that actual GASearchCallSetsRequest we want to make assertions on is not null.
    isNotNull();

    // overrides the default error message with a more explicit one
    String assertjErrorMessage = "\nExpecting pageToken of:\n  <%s>\nto be:\n  <%s>\nbut was:\n  <%s>";
    
    // null safe check
    String actualPageToken = actual.getPageToken();
    if (!Objects.areEqual(actualPageToken, pageToken)) {
      failWithMessage(assertjErrorMessage, actual, pageToken, actualPageToken);
    }

    // return the current assertion for method chaining
    return this;
  }

  /**
   * Verifies that the actual GASearchCallSetsRequest's schema is equal to the given one.
   * @param schema the given schema to compare the actual GASearchCallSetsRequest's schema to.
   * @return this assertion object.
   * @throws AssertionError - if the actual GASearchCallSetsRequest's schema is not equal to the given one.
   */
  public GASearchCallSetsRequestAssert hasSchema(org.apache.avro.Schema schema) {
    // check that actual GASearchCallSetsRequest we want to make assertions on is not null.
    isNotNull();

    // overrides the default error message with a more explicit one
    String assertjErrorMessage = "\nExpecting schema of:\n  <%s>\nto be:\n  <%s>\nbut was:\n  <%s>";
    
    // null safe check
    org.apache.avro.Schema actualSchema = actual.getSchema();
    if (!Objects.areEqual(actualSchema, schema)) {
      failWithMessage(assertjErrorMessage, actual, schema, actualSchema);
    }

    // return the current assertion for method chaining
    return this;
  }

  /**
   * Verifies that the actual GASearchCallSetsRequest's variantSetIds contains the given String elements.
   * @param variantSetIds the given elements that should be contained in actual GASearchCallSetsRequest's variantSetIds.
   * @return this assertion object.
   * @throws AssertionError if the actual GASearchCallSetsRequest's variantSetIds does not contain all given String elements.
   */
  public GASearchCallSetsRequestAssert hasVariantSetIds(String... variantSetIds) {
    // check that actual GASearchCallSetsRequest we want to make assertions on is not null.
    isNotNull();

    // check that given String varargs is not null.
    if (variantSetIds == null) failWithMessage("Expecting variantSetIds parameter not to be null.");
    
    // check with standard error message, to set another message call: info.overridingErrorMessage("my error message");
    Iterables.instance().assertContains(info, actual.getVariantSetIds(), variantSetIds);

    // return the current assertion for method chaining
    return this;
  }

  /**
   * Verifies that the actual GASearchCallSetsRequest's variantSetIds contains <b>only<b> the given String elements and nothing else in whatever order.
   * @param variantSetIds the given elements that should be contained in actual GASearchCallSetsRequest's variantSetIds.
   * @return this assertion object.
   * @throws AssertionError if the actual GASearchCallSetsRequest's variantSetIds does not contain all given String elements.
   */
  public GASearchCallSetsRequestAssert hasOnlyVariantSetIds(String... variantSetIds) {
    // check that actual GASearchCallSetsRequest we want to make assertions on is not null.
    isNotNull();

    // check that given String varargs is not null.
    if (variantSetIds == null) failWithMessage("Expecting variantSetIds parameter not to be null.");
    
    // check with standard error message, to set another message call: info.overridingErrorMessage("my error message");
    Iterables.instance().assertContainsOnly(info, actual.getVariantSetIds(), variantSetIds);

    // return the current assertion for method chaining
    return this;
  }

  /**
   * Verifies that the actual GASearchCallSetsRequest's variantSetIds does not contain the given String elements.
   *
   * @param variantSetIds the given elements that should not be in actual GASearchCallSetsRequest's variantSetIds.
   * @return this assertion object.
   * @throws AssertionError if the actual GASearchCallSetsRequest's variantSetIds contains any given String elements.
   */
  public GASearchCallSetsRequestAssert doesNotHaveVariantSetIds(String... variantSetIds) {
    // check that actual GASearchCallSetsRequest we want to make assertions on is not null.
    isNotNull();

    // check that given String varargs is not null.
    if (variantSetIds == null) failWithMessage("Expecting variantSetIds parameter not to be null.");
    
    // check with standard error message (use overridingErrorMessage before contains to set your own message).
    Iterables.instance().assertDoesNotContain(info, actual.getVariantSetIds(), variantSetIds);

    // return the current assertion for method chaining
    return this;
  }

  /**
   * Verifies that the actual GASearchCallSetsRequest has no variantSetIds.
   * @return this assertion object.
   * @throws AssertionError if the actual GASearchCallSetsRequest's variantSetIds is not empty.
   */
  public GASearchCallSetsRequestAssert hasNoVariantSetIds() {
    // check that actual GASearchCallSetsRequest we want to make assertions on is not null.
    isNotNull();

    // we override the default error message with a more explicit one
    String assertjErrorMessage = "\nExpecting :\n  <%s>\nnot to have variantSetIds but had :\n  <%s>";
    
    // check
    if (actual.getVariantSetIds().iterator().hasNext()) {
      failWithMessage(assertjErrorMessage, actual, actual.getVariantSetIds());
    }
    
    // return the current assertion for method chaining
    return this;
  }
  





}
