package org.ga4gh;

import org.assertj.core.api.AbstractAssert;
import org.assertj.core.internal.Iterables;
import org.assertj.core.util.Objects;

/**
 * {@link GASearchVariantsRequest} specific assertions - Generated by CustomAssertionGenerator.
 */
public class GASearchVariantsRequestAssert extends AbstractAssert<GASearchVariantsRequestAssert, GASearchVariantsRequest> {

  /**
   * Creates a new <code>{@link GASearchVariantsRequestAssert}</code> to make assertions on actual GASearchVariantsRequest.
   * @param actual the GASearchVariantsRequest we want to make assertions on.
   */
  public GASearchVariantsRequestAssert(GASearchVariantsRequest actual) {
    super(actual, GASearchVariantsRequestAssert.class);
  }

  /**
   * An entry point for GASearchVariantsRequestAssert to follow AssertJ standard <code>assertThat()</code> statements.<br>
   * With a static import, one can write directly: <code>assertThat(myGASearchVariantsRequest)</code> and get specific assertion with code completion.
   * @param actual the GASearchVariantsRequest we want to make assertions on.
   * @return a new <code>{@link GASearchVariantsRequestAssert}</code>
   */
  public static GASearchVariantsRequestAssert assertThat(GASearchVariantsRequest actual) {
    return new GASearchVariantsRequestAssert(actual);
  }

  /**
   * Verifies that the actual GASearchVariantsRequest's callSetIds contains the given String elements.
   * @param callSetIds the given elements that should be contained in actual GASearchVariantsRequest's callSetIds.
   * @return this assertion object.
   * @throws AssertionError if the actual GASearchVariantsRequest's callSetIds does not contain all given String elements.
   */
  public GASearchVariantsRequestAssert hasCallSetIds(String... callSetIds) {
    // check that actual GASearchVariantsRequest we want to make assertions on is not null.
    isNotNull();

    // check that given String varargs is not null.
    if (callSetIds == null) failWithMessage("Expecting callSetIds parameter not to be null.");
    
    // check with standard error message, to set another message call: info.overridingErrorMessage("my error message");
    Iterables.instance().assertContains(info, actual.getCallSetIds(), callSetIds);

    // return the current assertion for method chaining
    return this;
  }

  /**
   * Verifies that the actual GASearchVariantsRequest's callSetIds contains <b>only<b> the given String elements and nothing else in whatever order.
   * @param callSetIds the given elements that should be contained in actual GASearchVariantsRequest's callSetIds.
   * @return this assertion object.
   * @throws AssertionError if the actual GASearchVariantsRequest's callSetIds does not contain all given String elements.
   */
  public GASearchVariantsRequestAssert hasOnlyCallSetIds(String... callSetIds) {
    // check that actual GASearchVariantsRequest we want to make assertions on is not null.
    isNotNull();

    // check that given String varargs is not null.
    if (callSetIds == null) failWithMessage("Expecting callSetIds parameter not to be null.");
    
    // check with standard error message, to set another message call: info.overridingErrorMessage("my error message");
    Iterables.instance().assertContainsOnly(info, actual.getCallSetIds(), callSetIds);

    // return the current assertion for method chaining
    return this;
  }

  /**
   * Verifies that the actual GASearchVariantsRequest's callSetIds does not contain the given String elements.
   *
   * @param callSetIds the given elements that should not be in actual GASearchVariantsRequest's callSetIds.
   * @return this assertion object.
   * @throws AssertionError if the actual GASearchVariantsRequest's callSetIds contains any given String elements.
   */
  public GASearchVariantsRequestAssert doesNotHaveCallSetIds(String... callSetIds) {
    // check that actual GASearchVariantsRequest we want to make assertions on is not null.
    isNotNull();

    // check that given String varargs is not null.
    if (callSetIds == null) failWithMessage("Expecting callSetIds parameter not to be null.");
    
    // check with standard error message (use overridingErrorMessage before contains to set your own message).
    Iterables.instance().assertDoesNotContain(info, actual.getCallSetIds(), callSetIds);

    // return the current assertion for method chaining
    return this;
  }

  /**
   * Verifies that the actual GASearchVariantsRequest has no callSetIds.
   * @return this assertion object.
   * @throws AssertionError if the actual GASearchVariantsRequest's callSetIds is not empty.
   */
  public GASearchVariantsRequestAssert hasNoCallSetIds() {
    // check that actual GASearchVariantsRequest we want to make assertions on is not null.
    isNotNull();

    // we override the default error message with a more explicit one
    String assertjErrorMessage = "\nExpecting :\n  <%s>\nnot to have callSetIds but had :\n  <%s>";
    
    // check
    if (actual.getCallSetIds().iterator().hasNext()) {
      failWithMessage(assertjErrorMessage, actual, actual.getCallSetIds());
    }
    
    // return the current assertion for method chaining
    return this;
  }
  

  /**
   * Verifies that the actual GASearchVariantsRequest's classSchema is equal to the given one.
   * @param classSchema the given classSchema to compare the actual GASearchVariantsRequest's classSchema to.
   * @return this assertion object.
   * @throws AssertionError - if the actual GASearchVariantsRequest's classSchema is not equal to the given one.
   */
  public GASearchVariantsRequestAssert hasClassSchema(org.apache.avro.Schema classSchema) {
    // check that actual GASearchVariantsRequest we want to make assertions on is not null.
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
   * Verifies that the actual GASearchVariantsRequest's end is equal to the given one.
   * @param end the given end to compare the actual GASearchVariantsRequest's end to.
   * @return this assertion object.
   * @throws AssertionError - if the actual GASearchVariantsRequest's end is not equal to the given one.
   */
  public GASearchVariantsRequestAssert hasEnd(Long end) {
    // check that actual GASearchVariantsRequest we want to make assertions on is not null.
    isNotNull();

    // overrides the default error message with a more explicit one
    String assertjErrorMessage = "\nExpecting end of:\n  <%s>\nto be:\n  <%s>\nbut was:\n  <%s>";
    
    // null safe check
    Long actualEnd = actual.getEnd();
    if (!Objects.areEqual(actualEnd, end)) {
      failWithMessage(assertjErrorMessage, actual, end, actualEnd);
    }

    // return the current assertion for method chaining
    return this;
  }

  /**
   * Verifies that the actual GASearchVariantsRequest's pageSize is equal to the given one.
   * @param pageSize the given pageSize to compare the actual GASearchVariantsRequest's pageSize to.
   * @return this assertion object.
   * @throws AssertionError - if the actual GASearchVariantsRequest's pageSize is not equal to the given one.
   */
  public GASearchVariantsRequestAssert hasPageSize(Integer pageSize) {
    // check that actual GASearchVariantsRequest we want to make assertions on is not null.
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
   * Verifies that the actual GASearchVariantsRequest's pageToken is equal to the given one.
   * @param pageToken the given pageToken to compare the actual GASearchVariantsRequest's pageToken to.
   * @return this assertion object.
   * @throws AssertionError - if the actual GASearchVariantsRequest's pageToken is not equal to the given one.
   */
  public GASearchVariantsRequestAssert hasPageToken(String pageToken) {
    // check that actual GASearchVariantsRequest we want to make assertions on is not null.
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
   * Verifies that the actual GASearchVariantsRequest's referenceName is equal to the given one.
   * @param referenceName the given referenceName to compare the actual GASearchVariantsRequest's referenceName to.
   * @return this assertion object.
   * @throws AssertionError - if the actual GASearchVariantsRequest's referenceName is not equal to the given one.
   */
  public GASearchVariantsRequestAssert hasReferenceName(String referenceName) {
    // check that actual GASearchVariantsRequest we want to make assertions on is not null.
    isNotNull();

    // overrides the default error message with a more explicit one
    String assertjErrorMessage = "\nExpecting referenceName of:\n  <%s>\nto be:\n  <%s>\nbut was:\n  <%s>";
    
    // null safe check
    String actualReferenceName = actual.getReferenceName();
    if (!Objects.areEqual(actualReferenceName, referenceName)) {
      failWithMessage(assertjErrorMessage, actual, referenceName, actualReferenceName);
    }

    // return the current assertion for method chaining
    return this;
  }

  /**
   * Verifies that the actual GASearchVariantsRequest's schema is equal to the given one.
   * @param schema the given schema to compare the actual GASearchVariantsRequest's schema to.
   * @return this assertion object.
   * @throws AssertionError - if the actual GASearchVariantsRequest's schema is not equal to the given one.
   */
  public GASearchVariantsRequestAssert hasSchema(org.apache.avro.Schema schema) {
    // check that actual GASearchVariantsRequest we want to make assertions on is not null.
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
   * Verifies that the actual GASearchVariantsRequest's start is equal to the given one.
   * @param start the given start to compare the actual GASearchVariantsRequest's start to.
   * @return this assertion object.
   * @throws AssertionError - if the actual GASearchVariantsRequest's start is not equal to the given one.
   */
  public GASearchVariantsRequestAssert hasStart(Long start) {
    // check that actual GASearchVariantsRequest we want to make assertions on is not null.
    isNotNull();

    // overrides the default error message with a more explicit one
    String assertjErrorMessage = "\nExpecting start of:\n  <%s>\nto be:\n  <%s>\nbut was:\n  <%s>";
    
    // null safe check
    Long actualStart = actual.getStart();
    if (!Objects.areEqual(actualStart, start)) {
      failWithMessage(assertjErrorMessage, actual, start, actualStart);
    }

    // return the current assertion for method chaining
    return this;
  }

  /**
   * Verifies that the actual GASearchVariantsRequest's variantName is equal to the given one.
   * @param variantName the given variantName to compare the actual GASearchVariantsRequest's variantName to.
   * @return this assertion object.
   * @throws AssertionError - if the actual GASearchVariantsRequest's variantName is not equal to the given one.
   */
  public GASearchVariantsRequestAssert hasVariantName(String variantName) {
    // check that actual GASearchVariantsRequest we want to make assertions on is not null.
    isNotNull();

    // overrides the default error message with a more explicit one
    String assertjErrorMessage = "\nExpecting variantName of:\n  <%s>\nto be:\n  <%s>\nbut was:\n  <%s>";
    
    // null safe check
    String actualVariantName = actual.getVariantName();
    if (!Objects.areEqual(actualVariantName, variantName)) {
      failWithMessage(assertjErrorMessage, actual, variantName, actualVariantName);
    }

    // return the current assertion for method chaining
    return this;
  }

  /**
   * Verifies that the actual GASearchVariantsRequest's variantSetIds contains the given String elements.
   * @param variantSetIds the given elements that should be contained in actual GASearchVariantsRequest's variantSetIds.
   * @return this assertion object.
   * @throws AssertionError if the actual GASearchVariantsRequest's variantSetIds does not contain all given String elements.
   */
  public GASearchVariantsRequestAssert hasVariantSetIds(String... variantSetIds) {
    // check that actual GASearchVariantsRequest we want to make assertions on is not null.
    isNotNull();

    // check that given String varargs is not null.
    if (variantSetIds == null) failWithMessage("Expecting variantSetIds parameter not to be null.");
    
    // check with standard error message, to set another message call: info.overridingErrorMessage("my error message");
    Iterables.instance().assertContains(info, actual.getVariantSetIds(), variantSetIds);

    // return the current assertion for method chaining
    return this;
  }

  /**
   * Verifies that the actual GASearchVariantsRequest's variantSetIds contains <b>only<b> the given String elements and nothing else in whatever order.
   * @param variantSetIds the given elements that should be contained in actual GASearchVariantsRequest's variantSetIds.
   * @return this assertion object.
   * @throws AssertionError if the actual GASearchVariantsRequest's variantSetIds does not contain all given String elements.
   */
  public GASearchVariantsRequestAssert hasOnlyVariantSetIds(String... variantSetIds) {
    // check that actual GASearchVariantsRequest we want to make assertions on is not null.
    isNotNull();

    // check that given String varargs is not null.
    if (variantSetIds == null) failWithMessage("Expecting variantSetIds parameter not to be null.");
    
    // check with standard error message, to set another message call: info.overridingErrorMessage("my error message");
    Iterables.instance().assertContainsOnly(info, actual.getVariantSetIds(), variantSetIds);

    // return the current assertion for method chaining
    return this;
  }

  /**
   * Verifies that the actual GASearchVariantsRequest's variantSetIds does not contain the given String elements.
   *
   * @param variantSetIds the given elements that should not be in actual GASearchVariantsRequest's variantSetIds.
   * @return this assertion object.
   * @throws AssertionError if the actual GASearchVariantsRequest's variantSetIds contains any given String elements.
   */
  public GASearchVariantsRequestAssert doesNotHaveVariantSetIds(String... variantSetIds) {
    // check that actual GASearchVariantsRequest we want to make assertions on is not null.
    isNotNull();

    // check that given String varargs is not null.
    if (variantSetIds == null) failWithMessage("Expecting variantSetIds parameter not to be null.");
    
    // check with standard error message (use overridingErrorMessage before contains to set your own message).
    Iterables.instance().assertDoesNotContain(info, actual.getVariantSetIds(), variantSetIds);

    // return the current assertion for method chaining
    return this;
  }

  /**
   * Verifies that the actual GASearchVariantsRequest has no variantSetIds.
   * @return this assertion object.
   * @throws AssertionError if the actual GASearchVariantsRequest's variantSetIds is not empty.
   */
  public GASearchVariantsRequestAssert hasNoVariantSetIds() {
    // check that actual GASearchVariantsRequest we want to make assertions on is not null.
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
