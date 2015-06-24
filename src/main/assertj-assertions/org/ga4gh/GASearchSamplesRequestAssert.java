package org.ga4gh;

import org.assertj.core.api.*;
import org.assertj.core.internal.*;
import org.assertj.core.util.*;

/**
 * {@link GASearchSamplesRequest} specific assertions - Generated by CustomAssertionGenerator.
 */
public class GASearchSamplesRequestAssert extends AbstractAssert<GASearchSamplesRequestAssert, GASearchSamplesRequest> {

  /**
   * Creates a new <code>{@link GASearchSamplesRequestAssert}</code> to make assertions on actual GASearchSamplesRequest.
   * @param actual the GASearchSamplesRequest we want to make assertions on.
   */
  public GASearchSamplesRequestAssert(GASearchSamplesRequest actual) {
    super(actual, GASearchSamplesRequestAssert.class);
  }

  /**
   * An entry point for GASearchSamplesRequestAssert to follow AssertJ standard <code>assertThat()</code> statements.<br>
   * With a static import, one can write directly: <code>assertThat(myGASearchSamplesRequest)</code> and get specific assertion with code completion.
   * @param actual the GASearchSamplesRequest we want to make assertions on.
   * @return a new <code>{@link GASearchSamplesRequestAssert}</code>
   */
  public static GASearchSamplesRequestAssert assertThat(GASearchSamplesRequest actual) {
    return new GASearchSamplesRequestAssert(actual);
  }

  /**
   * Verifies that the actual GASearchSamplesRequest's classSchema is equal to the given one.
   * @param classSchema the given classSchema to compare the actual GASearchSamplesRequest's classSchema to.
   * @return this assertion object.
   * @throws AssertionError - if the actual GASearchSamplesRequest's classSchema is not equal to the given one.
   */
  public GASearchSamplesRequestAssert hasClassSchema(org.apache.avro.Schema classSchema) {
    // check that actual GASearchSamplesRequest we want to make assertions on is not null.
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
   * Verifies that the actual GASearchSamplesRequest's individualIds contains the given String elements.
   * @param individualIds the given elements that should be contained in actual GASearchSamplesRequest's individualIds.
   * @return this assertion object.
   * @throws AssertionError if the actual GASearchSamplesRequest's individualIds does not contain all given String elements.
   */
  public GASearchSamplesRequestAssert hasIndividualIds(String... individualIds) {
    // check that actual GASearchSamplesRequest we want to make assertions on is not null.
    isNotNull();

    // check that given String varargs is not null.
    if (individualIds == null) failWithMessage("Expecting individualIds parameter not to be null.");
    
    // check with standard error message, to set another message call: info.overridingErrorMessage("my error message");
    Iterables.instance().assertContains(info, actual.getIndividualIds(), individualIds);

    // return the current assertion for method chaining
    return this;
  }

  /**
   * Verifies that the actual GASearchSamplesRequest's individualIds contains <b>only<b> the given String elements and nothing else in whatever order.
   * @param individualIds the given elements that should be contained in actual GASearchSamplesRequest's individualIds.
   * @return this assertion object.
   * @throws AssertionError if the actual GASearchSamplesRequest's individualIds does not contain all given String elements.
   */
  public GASearchSamplesRequestAssert hasOnlyIndividualIds(String... individualIds) {
    // check that actual GASearchSamplesRequest we want to make assertions on is not null.
    isNotNull();

    // check that given String varargs is not null.
    if (individualIds == null) failWithMessage("Expecting individualIds parameter not to be null.");
    
    // check with standard error message, to set another message call: info.overridingErrorMessage("my error message");
    Iterables.instance().assertContainsOnly(info, actual.getIndividualIds(), individualIds);

    // return the current assertion for method chaining
    return this;
  }

  /**
   * Verifies that the actual GASearchSamplesRequest's individualIds does not contain the given String elements.
   *
   * @param individualIds the given elements that should not be in actual GASearchSamplesRequest's individualIds.
   * @return this assertion object.
   * @throws AssertionError if the actual GASearchSamplesRequest's individualIds contains any given String elements.
   */
  public GASearchSamplesRequestAssert doesNotHaveIndividualIds(String... individualIds) {
    // check that actual GASearchSamplesRequest we want to make assertions on is not null.
    isNotNull();

    // check that given String varargs is not null.
    if (individualIds == null) failWithMessage("Expecting individualIds parameter not to be null.");
    
    // check with standard error message (use overridingErrorMessage before contains to set your own message).
    Iterables.instance().assertDoesNotContain(info, actual.getIndividualIds(), individualIds);

    // return the current assertion for method chaining
    return this;
  }

  /**
   * Verifies that the actual GASearchSamplesRequest has no individualIds.
   * @return this assertion object.
   * @throws AssertionError if the actual GASearchSamplesRequest's individualIds is not empty.
   */
  public GASearchSamplesRequestAssert hasNoIndividualIds() {
    // check that actual GASearchSamplesRequest we want to make assertions on is not null.
    isNotNull();

    // we override the default error message with a more explicit one
    String assertjErrorMessage = "\nExpecting :\n  <%s>\nnot to have individualIds but had :\n  <%s>";
    
    // check
    if (actual.getIndividualIds().iterator().hasNext()) {
      failWithMessage(assertjErrorMessage, actual, actual.getIndividualIds());
    }
    
    // return the current assertion for method chaining
    return this;
  }
  

  /**
   * Verifies that the actual GASearchSamplesRequest's name is equal to the given one.
   * @param name the given name to compare the actual GASearchSamplesRequest's name to.
   * @return this assertion object.
   * @throws AssertionError - if the actual GASearchSamplesRequest's name is not equal to the given one.
   */
  public GASearchSamplesRequestAssert hasName(String name) {
    // check that actual GASearchSamplesRequest we want to make assertions on is not null.
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
   * Verifies that the actual GASearchSamplesRequest's pageSize is equal to the given one.
   * @param pageSize the given pageSize to compare the actual GASearchSamplesRequest's pageSize to.
   * @return this assertion object.
   * @throws AssertionError - if the actual GASearchSamplesRequest's pageSize is not equal to the given one.
   */
  public GASearchSamplesRequestAssert hasPageSize(Integer pageSize) {
    // check that actual GASearchSamplesRequest we want to make assertions on is not null.
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
   * Verifies that the actual GASearchSamplesRequest's pageToken is equal to the given one.
   * @param pageToken the given pageToken to compare the actual GASearchSamplesRequest's pageToken to.
   * @return this assertion object.
   * @throws AssertionError - if the actual GASearchSamplesRequest's pageToken is not equal to the given one.
   */
  public GASearchSamplesRequestAssert hasPageToken(String pageToken) {
    // check that actual GASearchSamplesRequest we want to make assertions on is not null.
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
   * Verifies that the actual GASearchSamplesRequest's schema is equal to the given one.
   * @param schema the given schema to compare the actual GASearchSamplesRequest's schema to.
   * @return this assertion object.
   * @throws AssertionError - if the actual GASearchSamplesRequest's schema is not equal to the given one.
   */
  public GASearchSamplesRequestAssert hasSchema(org.apache.avro.Schema schema) {
    // check that actual GASearchSamplesRequest we want to make assertions on is not null.
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





}
