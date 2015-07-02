package org.ga4gh;

import org.assertj.core.api.AbstractAssert;
import org.assertj.core.internal.Iterables;
import org.assertj.core.util.Objects;

/**
 * {@link GASearchReferencesResponse} specific assertions - Generated by CustomAssertionGenerator.
 */
public class GASearchReferencesResponseAssert extends AbstractAssert<GASearchReferencesResponseAssert, GASearchReferencesResponse> {

  /**
   * Creates a new <code>{@link GASearchReferencesResponseAssert}</code> to make assertions on actual GASearchReferencesResponse.
   * @param actual the GASearchReferencesResponse we want to make assertions on.
   */
  public GASearchReferencesResponseAssert(GASearchReferencesResponse actual) {
    super(actual, GASearchReferencesResponseAssert.class);
  }

  /**
   * An entry point for GASearchReferencesResponseAssert to follow AssertJ standard <code>assertThat()</code> statements.<br>
   * With a static import, one can write directly: <code>assertThat(myGASearchReferencesResponse)</code> and get specific assertion with code completion.
   * @param actual the GASearchReferencesResponse we want to make assertions on.
   * @return a new <code>{@link GASearchReferencesResponseAssert}</code>
   */
  public static GASearchReferencesResponseAssert assertThat(GASearchReferencesResponse actual) {
    return new GASearchReferencesResponseAssert(actual);
  }

  /**
   * Verifies that the actual GASearchReferencesResponse's classSchema is equal to the given one.
   * @param classSchema the given classSchema to compare the actual GASearchReferencesResponse's classSchema to.
   * @return this assertion object.
   * @throws AssertionError - if the actual GASearchReferencesResponse's classSchema is not equal to the given one.
   */
  public GASearchReferencesResponseAssert hasClassSchema(org.apache.avro.Schema classSchema) {
    // check that actual GASearchReferencesResponse we want to make assertions on is not null.
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
   * Verifies that the actual GASearchReferencesResponse's nextPageToken is equal to the given one.
   * @param nextPageToken the given nextPageToken to compare the actual GASearchReferencesResponse's nextPageToken to.
   * @return this assertion object.
   * @throws AssertionError - if the actual GASearchReferencesResponse's nextPageToken is not equal to the given one.
   */
  public GASearchReferencesResponseAssert hasNextPageToken(String nextPageToken) {
    // check that actual GASearchReferencesResponse we want to make assertions on is not null.
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
   * Verifies that the actual GASearchReferencesResponse's references contains the given GAReference elements.
   * @param references the given elements that should be contained in actual GASearchReferencesResponse's references.
   * @return this assertion object.
   * @throws AssertionError if the actual GASearchReferencesResponse's references does not contain all given GAReference elements.
   */
  public GASearchReferencesResponseAssert hasReferences(GAReference... references) {
    // check that actual GASearchReferencesResponse we want to make assertions on is not null.
    isNotNull();

    // check that given GAReference varargs is not null.
    if (references == null) failWithMessage("Expecting references parameter not to be null.");
    
    // check with standard error message, to set another message call: info.overridingErrorMessage("my error message");
    Iterables.instance().assertContains(info, actual.getReferences(), references);

    // return the current assertion for method chaining
    return this;
  }

  /**
   * Verifies that the actual GASearchReferencesResponse's references contains <b>only<b> the given GAReference elements and nothing else in whatever order.
   * @param references the given elements that should be contained in actual GASearchReferencesResponse's references.
   * @return this assertion object.
   * @throws AssertionError if the actual GASearchReferencesResponse's references does not contain all given GAReference elements.
   */
  public GASearchReferencesResponseAssert hasOnlyReferences(GAReference... references) {
    // check that actual GASearchReferencesResponse we want to make assertions on is not null.
    isNotNull();

    // check that given GAReference varargs is not null.
    if (references == null) failWithMessage("Expecting references parameter not to be null.");
    
    // check with standard error message, to set another message call: info.overridingErrorMessage("my error message");
    Iterables.instance().assertContainsOnly(info, actual.getReferences(), references);

    // return the current assertion for method chaining
    return this;
  }

  /**
   * Verifies that the actual GASearchReferencesResponse's references does not contain the given GAReference elements.
   *
   * @param references the given elements that should not be in actual GASearchReferencesResponse's references.
   * @return this assertion object.
   * @throws AssertionError if the actual GASearchReferencesResponse's references contains any given GAReference elements.
   */
  public GASearchReferencesResponseAssert doesNotHaveReferences(GAReference... references) {
    // check that actual GASearchReferencesResponse we want to make assertions on is not null.
    isNotNull();

    // check that given GAReference varargs is not null.
    if (references == null) failWithMessage("Expecting references parameter not to be null.");
    
    // check with standard error message (use overridingErrorMessage before contains to set your own message).
    Iterables.instance().assertDoesNotContain(info, actual.getReferences(), references);

    // return the current assertion for method chaining
    return this;
  }

  /**
   * Verifies that the actual GASearchReferencesResponse has no references.
   * @return this assertion object.
   * @throws AssertionError if the actual GASearchReferencesResponse's references is not empty.
   */
  public GASearchReferencesResponseAssert hasNoReferences() {
    // check that actual GASearchReferencesResponse we want to make assertions on is not null.
    isNotNull();

    // we override the default error message with a more explicit one
    String assertjErrorMessage = "\nExpecting :\n  <%s>\nnot to have references but had :\n  <%s>";
    
    // check
    if (actual.getReferences().iterator().hasNext()) {
      failWithMessage(assertjErrorMessage, actual, actual.getReferences());
    }
    
    // return the current assertion for method chaining
    return this;
  }
  

  /**
   * Verifies that the actual GASearchReferencesResponse's schema is equal to the given one.
   * @param schema the given schema to compare the actual GASearchReferencesResponse's schema to.
   * @return this assertion object.
   * @throws AssertionError - if the actual GASearchReferencesResponse's schema is not equal to the given one.
   */
  public GASearchReferencesResponseAssert hasSchema(org.apache.avro.Schema schema) {
    // check that actual GASearchReferencesResponse we want to make assertions on is not null.
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
