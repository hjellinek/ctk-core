package org.ga4gh;

import org.assertj.core.api.AbstractAssert;
import org.assertj.core.internal.Iterables;
import org.assertj.core.util.Objects;

/**
 * {@link GASearchReadsResponse.Builder} specific assertions - Generated by CustomAssertionGenerator.
 */
public class GASearchReadsResponseBuilderAssert extends AbstractAssert<GASearchReadsResponseBuilderAssert, GASearchReadsResponse.Builder> {

  /**
   * Creates a new <code>{@link GASearchReadsResponseBuilderAssert}</code> to make assertions on actual GASearchReadsResponse.Builder.
   * @param actual the GASearchReadsResponse.Builder we want to make assertions on.
   */
  public GASearchReadsResponseBuilderAssert(GASearchReadsResponse.Builder actual) {
    super(actual, GASearchReadsResponseBuilderAssert.class);
  }

  /**
   * An entry point for GASearchReadsResponseBuilderAssert to follow AssertJ standard <code>assertThat()</code> statements.<br>
   * With a static import, one can write directly: <code>assertThat(myGASearchReadsResponse.Builder)</code> and get specific assertion with code completion.
   * @param actual the GASearchReadsResponse.Builder we want to make assertions on.
   * @return a new <code>{@link GASearchReadsResponseBuilderAssert}</code>
   */
  public static GASearchReadsResponseBuilderAssert assertThat(GASearchReadsResponse.Builder actual) {
    return new GASearchReadsResponseBuilderAssert(actual);
  }

  /**
   * Verifies that the actual GASearchReadsResponse.Builder's alignments contains the given GAReadAlignment elements.
   * @param alignments the given elements that should be contained in actual GASearchReadsResponse.Builder's alignments.
   * @return this assertion object.
   * @throws AssertionError if the actual GASearchReadsResponse.Builder's alignments does not contain all given GAReadAlignment elements.
   */
  public GASearchReadsResponseBuilderAssert hasAlignments(GAReadAlignment... alignments) {
    // check that actual GASearchReadsResponse.Builder we want to make assertions on is not null.
    isNotNull();

    // check that given GAReadAlignment varargs is not null.
    if (alignments == null) failWithMessage("Expecting alignments parameter not to be null.");
    
    // check with standard error message, to set another message call: info.overridingErrorMessage("my error message");
    Iterables.instance().assertContains(info, actual.getAlignments(), alignments);

    // return the current assertion for method chaining
    return this;
  }

  /**
   * Verifies that the actual GASearchReadsResponse.Builder's alignments contains <b>only<b> the given GAReadAlignment elements and nothing else in whatever order.
   * @param alignments the given elements that should be contained in actual GASearchReadsResponse.Builder's alignments.
   * @return this assertion object.
   * @throws AssertionError if the actual GASearchReadsResponse.Builder's alignments does not contain all given GAReadAlignment elements.
   */
  public GASearchReadsResponseBuilderAssert hasOnlyAlignments(GAReadAlignment... alignments) {
    // check that actual GASearchReadsResponse.Builder we want to make assertions on is not null.
    isNotNull();

    // check that given GAReadAlignment varargs is not null.
    if (alignments == null) failWithMessage("Expecting alignments parameter not to be null.");
    
    // check with standard error message, to set another message call: info.overridingErrorMessage("my error message");
    Iterables.instance().assertContainsOnly(info, actual.getAlignments(), alignments);

    // return the current assertion for method chaining
    return this;
  }

  /**
   * Verifies that the actual GASearchReadsResponse.Builder's alignments does not contain the given GAReadAlignment elements.
   *
   * @param alignments the given elements that should not be in actual GASearchReadsResponse.Builder's alignments.
   * @return this assertion object.
   * @throws AssertionError if the actual GASearchReadsResponse.Builder's alignments contains any given GAReadAlignment elements.
   */
  public GASearchReadsResponseBuilderAssert doesNotHaveAlignments(GAReadAlignment... alignments) {
    // check that actual GASearchReadsResponse.Builder we want to make assertions on is not null.
    isNotNull();

    // check that given GAReadAlignment varargs is not null.
    if (alignments == null) failWithMessage("Expecting alignments parameter not to be null.");
    
    // check with standard error message (use overridingErrorMessage before contains to set your own message).
    Iterables.instance().assertDoesNotContain(info, actual.getAlignments(), alignments);

    // return the current assertion for method chaining
    return this;
  }

  /**
   * Verifies that the actual GASearchReadsResponse.Builder has no alignments.
   * @return this assertion object.
   * @throws AssertionError if the actual GASearchReadsResponse.Builder's alignments is not empty.
   */
  public GASearchReadsResponseBuilderAssert hasNoAlignments() {
    // check that actual GASearchReadsResponse.Builder we want to make assertions on is not null.
    isNotNull();

    // we override the default error message with a more explicit one
    String assertjErrorMessage = "\nExpecting :\n  <%s>\nnot to have alignments but had :\n  <%s>";
    
    // check
    if (actual.getAlignments().iterator().hasNext()) {
      failWithMessage(assertjErrorMessage, actual, actual.getAlignments());
    }
    
    // return the current assertion for method chaining
    return this;
  }
  

  /**
   * Verifies that the actual GASearchReadsResponse.Builder's nextPageToken is equal to the given one.
   * @param nextPageToken the given nextPageToken to compare the actual GASearchReadsResponse.Builder's nextPageToken to.
   * @return this assertion object.
   * @throws AssertionError - if the actual GASearchReadsResponse.Builder's nextPageToken is not equal to the given one.
   */
  public GASearchReadsResponseBuilderAssert hasNextPageToken(String nextPageToken) {
    // check that actual GASearchReadsResponse.Builder we want to make assertions on is not null.
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
   * Verifies that the actual GASearchReadsResponse.Builder has alignments.
   * @return this assertion object.
   * @throws AssertionError - if the actual GASearchReadsResponse.Builder does not have alignments.
   */
  public GASearchReadsResponseBuilderAssert hasAlignments() {
    // check that actual GASearchReadsResponse.Builder we want to make assertions on is not null.
    isNotNull();

    // check
    if (!actual.hasAlignments()) {
      failWithMessage("\nExpecting that actual GASearchReadsResponse.Builder has alignments but does not have.");
    }
    
    // return the current assertion for method chaining
    return this;
  }

  /**
   * Verifies that the actual GASearchReadsResponse.Builder does not have alignments.
   * @return this assertion object.
   * @throws AssertionError - if the actual GASearchReadsResponse.Builder has alignments.
   */
  public GASearchReadsResponseBuilderAssert doesNotHaveAlignments() {
    // check that actual GASearchReadsResponse.Builder we want to make assertions on is not null.
    isNotNull();

    // check
    if (actual.hasAlignments()) {
      failWithMessage("\nExpecting that actual GASearchReadsResponse.Builder does not have alignments but has.");
    }
    
    // return the current assertion for method chaining
    return this;
  }

  /**
   * Verifies that the actual GASearchReadsResponse.Builder has next page token.
   * @return this assertion object.
   * @throws AssertionError - if the actual GASearchReadsResponse.Builder does not have next page token.
   */
  public GASearchReadsResponseBuilderAssert hasNextPageToken() {
    // check that actual GASearchReadsResponse.Builder we want to make assertions on is not null.
    isNotNull();

    // check
    if (!actual.hasNextPageToken()) {
      failWithMessage("\nExpecting that actual GASearchReadsResponse.Builder has next page token but does not have.");
    }
    
    // return the current assertion for method chaining
    return this;
  }

  /**
   * Verifies that the actual GASearchReadsResponse.Builder does not have next page token.
   * @return this assertion object.
   * @throws AssertionError - if the actual GASearchReadsResponse.Builder has next page token.
   */
  public GASearchReadsResponseBuilderAssert doesNotHaveNextPageToken() {
    // check that actual GASearchReadsResponse.Builder we want to make assertions on is not null.
    isNotNull();

    // check
    if (actual.hasNextPageToken()) {
      failWithMessage("\nExpecting that actual GASearchReadsResponse.Builder does not have next page token but has.");
    }
    
    // return the current assertion for method chaining
    return this;
  }

}
