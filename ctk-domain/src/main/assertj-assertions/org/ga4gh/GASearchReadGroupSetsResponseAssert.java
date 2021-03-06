package org.ga4gh;

import org.assertj.core.api.AbstractAssert;
import org.assertj.core.internal.Iterables;
import org.assertj.core.util.Objects;

/**
 * {@link GASearchReadGroupSetsResponse} specific assertions - Generated by CustomAssertionGenerator.
 */
public class GASearchReadGroupSetsResponseAssert extends AbstractAssert<GASearchReadGroupSetsResponseAssert, GASearchReadGroupSetsResponse> {

  /**
   * Creates a new <code>{@link GASearchReadGroupSetsResponseAssert}</code> to make assertions on actual GASearchReadGroupSetsResponse.
   * @param actual the GASearchReadGroupSetsResponse we want to make assertions on.
   */
  public GASearchReadGroupSetsResponseAssert(GASearchReadGroupSetsResponse actual) {
    super(actual, GASearchReadGroupSetsResponseAssert.class);
  }

  /**
   * An entry point for GASearchReadGroupSetsResponseAssert to follow AssertJ standard <code>assertThat()</code> statements.<br>
   * With a static import, one can write directly: <code>assertThat(myGASearchReadGroupSetsResponse)</code> and get specific assertion with code completion.
   * @param actual the GASearchReadGroupSetsResponse we want to make assertions on.
   * @return a new <code>{@link GASearchReadGroupSetsResponseAssert}</code>
   */
  public static GASearchReadGroupSetsResponseAssert assertThat(GASearchReadGroupSetsResponse actual) {
    return new GASearchReadGroupSetsResponseAssert(actual);
  }

  /**
   * Verifies that the actual GASearchReadGroupSetsResponse's classSchema is equal to the given one.
   * @param classSchema the given classSchema to compare the actual GASearchReadGroupSetsResponse's classSchema to.
   * @return this assertion object.
   * @throws AssertionError - if the actual GASearchReadGroupSetsResponse's classSchema is not equal to the given one.
   */
  public GASearchReadGroupSetsResponseAssert hasClassSchema(org.apache.avro.Schema classSchema) {
    // check that actual GASearchReadGroupSetsResponse we want to make assertions on is not null.
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
   * Verifies that the actual GASearchReadGroupSetsResponse's nextPageToken is equal to the given one.
   * @param nextPageToken the given nextPageToken to compare the actual GASearchReadGroupSetsResponse's nextPageToken to.
   * @return this assertion object.
   * @throws AssertionError - if the actual GASearchReadGroupSetsResponse's nextPageToken is not equal to the given one.
   */
  public GASearchReadGroupSetsResponseAssert hasNextPageToken(String nextPageToken) {
    // check that actual GASearchReadGroupSetsResponse we want to make assertions on is not null.
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
   * Verifies that the actual GASearchReadGroupSetsResponse's readGroupSets contains the given GAReadGroupSet elements.
   * @param readGroupSets the given elements that should be contained in actual GASearchReadGroupSetsResponse's readGroupSets.
   * @return this assertion object.
   * @throws AssertionError if the actual GASearchReadGroupSetsResponse's readGroupSets does not contain all given GAReadGroupSet elements.
   */
  public GASearchReadGroupSetsResponseAssert hasReadGroupSets(GAReadGroupSet... readGroupSets) {
    // check that actual GASearchReadGroupSetsResponse we want to make assertions on is not null.
    isNotNull();

    // check that given GAReadGroupSet varargs is not null.
    if (readGroupSets == null) failWithMessage("Expecting readGroupSets parameter not to be null.");
    
    // check with standard error message, to set another message call: info.overridingErrorMessage("my error message");
    Iterables.instance().assertContains(info, actual.getReadGroupSets(), readGroupSets);

    // return the current assertion for method chaining
    return this;
  }

  /**
   * Verifies that the actual GASearchReadGroupSetsResponse's readGroupSets contains <b>only<b> the given GAReadGroupSet elements and nothing else in whatever order.
   * @param readGroupSets the given elements that should be contained in actual GASearchReadGroupSetsResponse's readGroupSets.
   * @return this assertion object.
   * @throws AssertionError if the actual GASearchReadGroupSetsResponse's readGroupSets does not contain all given GAReadGroupSet elements.
   */
  public GASearchReadGroupSetsResponseAssert hasOnlyReadGroupSets(GAReadGroupSet... readGroupSets) {
    // check that actual GASearchReadGroupSetsResponse we want to make assertions on is not null.
    isNotNull();

    // check that given GAReadGroupSet varargs is not null.
    if (readGroupSets == null) failWithMessage("Expecting readGroupSets parameter not to be null.");
    
    // check with standard error message, to set another message call: info.overridingErrorMessage("my error message");
    Iterables.instance().assertContainsOnly(info, actual.getReadGroupSets(), readGroupSets);

    // return the current assertion for method chaining
    return this;
  }

  /**
   * Verifies that the actual GASearchReadGroupSetsResponse's readGroupSets does not contain the given GAReadGroupSet elements.
   *
   * @param readGroupSets the given elements that should not be in actual GASearchReadGroupSetsResponse's readGroupSets.
   * @return this assertion object.
   * @throws AssertionError if the actual GASearchReadGroupSetsResponse's readGroupSets contains any given GAReadGroupSet elements.
   */
  public GASearchReadGroupSetsResponseAssert doesNotHaveReadGroupSets(GAReadGroupSet... readGroupSets) {
    // check that actual GASearchReadGroupSetsResponse we want to make assertions on is not null.
    isNotNull();

    // check that given GAReadGroupSet varargs is not null.
    if (readGroupSets == null) failWithMessage("Expecting readGroupSets parameter not to be null.");
    
    // check with standard error message (use overridingErrorMessage before contains to set your own message).
    Iterables.instance().assertDoesNotContain(info, actual.getReadGroupSets(), readGroupSets);

    // return the current assertion for method chaining
    return this;
  }

  /**
   * Verifies that the actual GASearchReadGroupSetsResponse has no readGroupSets.
   * @return this assertion object.
   * @throws AssertionError if the actual GASearchReadGroupSetsResponse's readGroupSets is not empty.
   */
  public GASearchReadGroupSetsResponseAssert hasNoReadGroupSets() {
    // check that actual GASearchReadGroupSetsResponse we want to make assertions on is not null.
    isNotNull();

    // we override the default error message with a more explicit one
    String assertjErrorMessage = "\nExpecting :\n  <%s>\nnot to have readGroupSets but had :\n  <%s>";
    
    // check
    if (actual.getReadGroupSets().iterator().hasNext()) {
      failWithMessage(assertjErrorMessage, actual, actual.getReadGroupSets());
    }
    
    // return the current assertion for method chaining
    return this;
  }
  

  /**
   * Verifies that the actual GASearchReadGroupSetsResponse's schema is equal to the given one.
   * @param schema the given schema to compare the actual GASearchReadGroupSetsResponse's schema to.
   * @return this assertion object.
   * @throws AssertionError - if the actual GASearchReadGroupSetsResponse's schema is not equal to the given one.
   */
  public GASearchReadGroupSetsResponseAssert hasSchema(org.apache.avro.Schema schema) {
    // check that actual GASearchReadGroupSetsResponse we want to make assertions on is not null.
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
