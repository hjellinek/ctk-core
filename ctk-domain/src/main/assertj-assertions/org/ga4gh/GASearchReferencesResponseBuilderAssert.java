package org.ga4gh;

import org.assertj.core.api.AbstractAssert;
import org.assertj.core.internal.Iterables;
import org.assertj.core.util.Objects;

/**
 * {@link GASearchReferencesResponse.Builder} specific assertions - Generated by CustomAssertionGenerator.
 */
public class GASearchReferencesResponseBuilderAssert extends AbstractAssert<GASearchReferencesResponseBuilderAssert, GASearchReferencesResponse.Builder> {

  /**
   * Creates a new <code>{@link GASearchReferencesResponseBuilderAssert}</code> to make assertions on actual GASearchReferencesResponse.Builder.
   * @param actual the GASearchReferencesResponse.Builder we want to make assertions on.
   */
  public GASearchReferencesResponseBuilderAssert(GASearchReferencesResponse.Builder actual) {
    super(actual, GASearchReferencesResponseBuilderAssert.class);
  }

  /**
   * An entry point for GASearchReferencesResponseBuilderAssert to follow AssertJ standard <code>assertThat()</code> statements.<br>
   * With a static import, one can write directly: <code>assertThat(myGASearchReferencesResponse.Builder)</code> and get specific assertion with code completion.
   * @param actual the GASearchReferencesResponse.Builder we want to make assertions on.
   * @return a new <code>{@link GASearchReferencesResponseBuilderAssert}</code>
   */
  public static GASearchReferencesResponseBuilderAssert assertThat(GASearchReferencesResponse.Builder actual) {
    return new GASearchReferencesResponseBuilderAssert(actual);
  }

  /**
   * Verifies that the actual GASearchReferencesResponse.Builder's nextPageToken is equal to the given one.
   * @param nextPageToken the given nextPageToken to compare the actual GASearchReferencesResponse.Builder's nextPageToken to.
   * @return this assertion object.
   * @throws AssertionError - if the actual GASearchReferencesResponse.Builder's nextPageToken is not equal to the given one.
   */
  public GASearchReferencesResponseBuilderAssert hasNextPageToken(String nextPageToken) {
    // check that actual GASearchReferencesResponse.Builder we want to make assertions on is not null.
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
   * Verifies that the actual GASearchReferencesResponse.Builder's references contains the given GAReference elements.
   * @param references the given elements that should be contained in actual GASearchReferencesResponse.Builder's references.
   * @return this assertion object.
   * @throws AssertionError if the actual GASearchReferencesResponse.Builder's references does not contain all given GAReference elements.
   */
  public GASearchReferencesResponseBuilderAssert hasReferences(GAReference... references) {
    // check that actual GASearchReferencesResponse.Builder we want to make assertions on is not null.
    isNotNull();

    // check that given GAReference varargs is not null.
    if (references == null) failWithMessage("Expecting references parameter not to be null.");
    
    // check with standard error message, to set another message call: info.overridingErrorMessage("my error message");
    Iterables.instance().assertContains(info, actual.getReferences(), references);

    // return the current assertion for method chaining
    return this;
  }

  /**
   * Verifies that the actual GASearchReferencesResponse.Builder's references contains <b>only<b> the given GAReference elements and nothing else in whatever order.
   * @param references the given elements that should be contained in actual GASearchReferencesResponse.Builder's references.
   * @return this assertion object.
   * @throws AssertionError if the actual GASearchReferencesResponse.Builder's references does not contain all given GAReference elements.
   */
  public GASearchReferencesResponseBuilderAssert hasOnlyReferences(GAReference... references) {
    // check that actual GASearchReferencesResponse.Builder we want to make assertions on is not null.
    isNotNull();

    // check that given GAReference varargs is not null.
    if (references == null) failWithMessage("Expecting references parameter not to be null.");
    
    // check with standard error message, to set another message call: info.overridingErrorMessage("my error message");
    Iterables.instance().assertContainsOnly(info, actual.getReferences(), references);

    // return the current assertion for method chaining
    return this;
  }

  /**
   * Verifies that the actual GASearchReferencesResponse.Builder's references does not contain the given GAReference elements.
   *
   * @param references the given elements that should not be in actual GASearchReferencesResponse.Builder's references.
   * @return this assertion object.
   * @throws AssertionError if the actual GASearchReferencesResponse.Builder's references contains any given GAReference elements.
   */
  public GASearchReferencesResponseBuilderAssert doesNotHaveReferences(GAReference... references) {
    // check that actual GASearchReferencesResponse.Builder we want to make assertions on is not null.
    isNotNull();

    // check that given GAReference varargs is not null.
    if (references == null) failWithMessage("Expecting references parameter not to be null.");
    
    // check with standard error message (use overridingErrorMessage before contains to set your own message).
    Iterables.instance().assertDoesNotContain(info, actual.getReferences(), references);

    // return the current assertion for method chaining
    return this;
  }

  /**
   * Verifies that the actual GASearchReferencesResponse.Builder has no references.
   * @return this assertion object.
   * @throws AssertionError if the actual GASearchReferencesResponse.Builder's references is not empty.
   */
  public GASearchReferencesResponseBuilderAssert hasNoReferences() {
    // check that actual GASearchReferencesResponse.Builder we want to make assertions on is not null.
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
   * Verifies that the actual GASearchReferencesResponse.Builder has next page token.
   * @return this assertion object.
   * @throws AssertionError - if the actual GASearchReferencesResponse.Builder does not have next page token.
   */
  public GASearchReferencesResponseBuilderAssert hasNextPageToken() {
    // check that actual GASearchReferencesResponse.Builder we want to make assertions on is not null.
    isNotNull();

    // check
    if (!actual.hasNextPageToken()) {
      failWithMessage("\nExpecting that actual GASearchReferencesResponse.Builder has next page token but does not have.");
    }
    
    // return the current assertion for method chaining
    return this;
  }

  /**
   * Verifies that the actual GASearchReferencesResponse.Builder does not have next page token.
   * @return this assertion object.
   * @throws AssertionError - if the actual GASearchReferencesResponse.Builder has next page token.
   */
  public GASearchReferencesResponseBuilderAssert doesNotHaveNextPageToken() {
    // check that actual GASearchReferencesResponse.Builder we want to make assertions on is not null.
    isNotNull();

    // check
    if (actual.hasNextPageToken()) {
      failWithMessage("\nExpecting that actual GASearchReferencesResponse.Builder does not have next page token but has.");
    }
    
    // return the current assertion for method chaining
    return this;
  }

  /**
   * Verifies that the actual GASearchReferencesResponse.Builder has references.
   * @return this assertion object.
   * @throws AssertionError - if the actual GASearchReferencesResponse.Builder does not have references.
   */
  public GASearchReferencesResponseBuilderAssert hasReferences() {
    // check that actual GASearchReferencesResponse.Builder we want to make assertions on is not null.
    isNotNull();

    // check
    if (!actual.hasReferences()) {
      failWithMessage("\nExpecting that actual GASearchReferencesResponse.Builder has references but does not have.");
    }
    
    // return the current assertion for method chaining
    return this;
  }

  /**
   * Verifies that the actual GASearchReferencesResponse.Builder does not have references.
   * @return this assertion object.
   * @throws AssertionError - if the actual GASearchReferencesResponse.Builder has references.
   */
  public GASearchReferencesResponseBuilderAssert doesNotHaveReferences() {
    // check that actual GASearchReferencesResponse.Builder we want to make assertions on is not null.
    isNotNull();

    // check
    if (actual.hasReferences()) {
      failWithMessage("\nExpecting that actual GASearchReferencesResponse.Builder does not have references but has.");
    }
    
    // return the current assertion for method chaining
    return this;
  }

}
