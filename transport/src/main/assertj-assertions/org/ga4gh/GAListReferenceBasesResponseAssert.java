package org.ga4gh;

import org.assertj.core.api.AbstractAssert;
import org.assertj.core.util.Objects;

/**
 * {@link GAListReferenceBasesResponse} specific assertions - Generated by CustomAssertionGenerator.
 */
public class GAListReferenceBasesResponseAssert extends AbstractAssert<GAListReferenceBasesResponseAssert, GAListReferenceBasesResponse> {

  /**
   * Creates a new <code>{@link GAListReferenceBasesResponseAssert}</code> to make assertions on actual GAListReferenceBasesResponse.
   * @param actual the GAListReferenceBasesResponse we want to make assertions on.
   */
  public GAListReferenceBasesResponseAssert(GAListReferenceBasesResponse actual) {
    super(actual, GAListReferenceBasesResponseAssert.class);
  }

  /**
   * An entry point for GAListReferenceBasesResponseAssert to follow AssertJ standard <code>assertThat()</code> statements.<br>
   * With a static import, one can write directly: <code>assertThat(myGAListReferenceBasesResponse)</code> and get specific assertion with code completion.
   * @param actual the GAListReferenceBasesResponse we want to make assertions on.
   * @return a new <code>{@link GAListReferenceBasesResponseAssert}</code>
   */
  public static GAListReferenceBasesResponseAssert assertThat(GAListReferenceBasesResponse actual) {
    return new GAListReferenceBasesResponseAssert(actual);
  }

  /**
   * Verifies that the actual GAListReferenceBasesResponse's classSchema is equal to the given one.
   * @param classSchema the given classSchema to compare the actual GAListReferenceBasesResponse's classSchema to.
   * @return this assertion object.
   * @throws AssertionError - if the actual GAListReferenceBasesResponse's classSchema is not equal to the given one.
   */
  public GAListReferenceBasesResponseAssert hasClassSchema(org.apache.avro.Schema classSchema) {
    // check that actual GAListReferenceBasesResponse we want to make assertions on is not null.
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
   * Verifies that the actual GAListReferenceBasesResponse's nextPageToken is equal to the given one.
   * @param nextPageToken the given nextPageToken to compare the actual GAListReferenceBasesResponse's nextPageToken to.
   * @return this assertion object.
   * @throws AssertionError - if the actual GAListReferenceBasesResponse's nextPageToken is not equal to the given one.
   */
  public GAListReferenceBasesResponseAssert hasNextPageToken(String nextPageToken) {
    // check that actual GAListReferenceBasesResponse we want to make assertions on is not null.
    isNotNull();

    // overrides the default error message with a more explicit one
    String assertjErrorMessage = "\nExpecting nextPageToken of:\n  <%s>\nto be:\n  <%s>\nbut was:\n  <%s>";
    
    // null safe check
    String actualNextPageToken = actual.getNextPageToken();
    if (!Objects.areEqual(actualNextPageToken, nextPageToken)) {
      failWithMessage(assertjErrorMessage, actual, nextPageToken, actualNextPageToken);
    }

    // return the current assertion for method chaining
    return this;
  }

  /**
   * Verifies that the actual GAListReferenceBasesResponse's offset is equal to the given one.
   * @param offset the given offset to compare the actual GAListReferenceBasesResponse's offset to.
   * @return this assertion object.
   * @throws AssertionError - if the actual GAListReferenceBasesResponse's offset is not equal to the given one.
   */
  public GAListReferenceBasesResponseAssert hasOffset(Long offset) {
    // check that actual GAListReferenceBasesResponse we want to make assertions on is not null.
    isNotNull();

    // overrides the default error message with a more explicit one
    String assertjErrorMessage = "\nExpecting offset of:\n  <%s>\nto be:\n  <%s>\nbut was:\n  <%s>";
    
    // null safe check
    Long actualOffset = actual.getOffset();
    if (!Objects.areEqual(actualOffset, offset)) {
      failWithMessage(assertjErrorMessage, actual, offset, actualOffset);
    }

    // return the current assertion for method chaining
    return this;
  }

  /**
   * Verifies that the actual GAListReferenceBasesResponse's schema is equal to the given one.
   * @param schema the given schema to compare the actual GAListReferenceBasesResponse's schema to.
   * @return this assertion object.
   * @throws AssertionError - if the actual GAListReferenceBasesResponse's schema is not equal to the given one.
   */
  public GAListReferenceBasesResponseAssert hasSchema(org.apache.avro.Schema schema) {
    // check that actual GAListReferenceBasesResponse we want to make assertions on is not null.
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
   * Verifies that the actual GAListReferenceBasesResponse's sequence is equal to the given one.
   * @param sequence the given sequence to compare the actual GAListReferenceBasesResponse's sequence to.
   * @return this assertion object.
   * @throws AssertionError - if the actual GAListReferenceBasesResponse's sequence is not equal to the given one.
   */
  public GAListReferenceBasesResponseAssert hasSequence(String sequence) {
    // check that actual GAListReferenceBasesResponse we want to make assertions on is not null.
    isNotNull();

    // overrides the default error message with a more explicit one
    String assertjErrorMessage = "\nExpecting sequence of:\n  <%s>\nto be:\n  <%s>\nbut was:\n  <%s>";
    
    // null safe check
    String actualSequence = actual.getSequence();
    if (!Objects.areEqual(actualSequence, sequence)) {
      failWithMessage(assertjErrorMessage, actual, sequence, actualSequence);
    }

    // return the current assertion for method chaining
    return this;
  }




}
