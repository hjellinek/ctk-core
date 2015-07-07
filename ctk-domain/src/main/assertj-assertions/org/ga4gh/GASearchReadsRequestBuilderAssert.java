package org.ga4gh;

import org.assertj.core.api.AbstractAssert;
import org.assertj.core.internal.Iterables;
import org.assertj.core.util.Objects;

/**
 * {@link GASearchReadsRequest.Builder} specific assertions - Generated by CustomAssertionGenerator.
 */
public class GASearchReadsRequestBuilderAssert extends AbstractAssert<GASearchReadsRequestBuilderAssert, GASearchReadsRequest.Builder> {

  /**
   * Creates a new <code>{@link GASearchReadsRequestBuilderAssert}</code> to make assertions on actual GASearchReadsRequest.Builder.
   * @param actual the GASearchReadsRequest.Builder we want to make assertions on.
   */
  public GASearchReadsRequestBuilderAssert(GASearchReadsRequest.Builder actual) {
    super(actual, GASearchReadsRequestBuilderAssert.class);
  }

  /**
   * An entry point for GASearchReadsRequestBuilderAssert to follow AssertJ standard <code>assertThat()</code> statements.<br>
   * With a static import, one can write directly: <code>assertThat(myGASearchReadsRequest.Builder)</code> and get specific assertion with code completion.
   * @param actual the GASearchReadsRequest.Builder we want to make assertions on.
   * @return a new <code>{@link GASearchReadsRequestBuilderAssert}</code>
   */
  public static GASearchReadsRequestBuilderAssert assertThat(GASearchReadsRequest.Builder actual) {
    return new GASearchReadsRequestBuilderAssert(actual);
  }

  /**
   * Verifies that the actual GASearchReadsRequest.Builder's end is equal to the given one.
   * @param end the given end to compare the actual GASearchReadsRequest.Builder's end to.
   * @return this assertion object.
   * @throws AssertionError - if the actual GASearchReadsRequest.Builder's end is not equal to the given one.
   */
  public GASearchReadsRequestBuilderAssert hasEnd(Long end) {
    // check that actual GASearchReadsRequest.Builder we want to make assertions on is not null.
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
   * Verifies that the actual GASearchReadsRequest.Builder's pageSize is equal to the given one.
   * @param pageSize the given pageSize to compare the actual GASearchReadsRequest.Builder's pageSize to.
   * @return this assertion object.
   * @throws AssertionError - if the actual GASearchReadsRequest.Builder's pageSize is not equal to the given one.
   */
  public GASearchReadsRequestBuilderAssert hasPageSize(Integer pageSize) {
    // check that actual GASearchReadsRequest.Builder we want to make assertions on is not null.
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
   * Verifies that the actual GASearchReadsRequest.Builder's pageToken is equal to the given one.
   * @param pageToken the given pageToken to compare the actual GASearchReadsRequest.Builder's pageToken to.
   * @return this assertion object.
   * @throws AssertionError - if the actual GASearchReadsRequest.Builder's pageToken is not equal to the given one.
   */
  public GASearchReadsRequestBuilderAssert hasPageToken(String pageToken) {
    // check that actual GASearchReadsRequest.Builder we want to make assertions on is not null.
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
   * Verifies that the actual GASearchReadsRequest.Builder's readGroupIds contains the given String elements.
   * @param readGroupIds the given elements that should be contained in actual GASearchReadsRequest.Builder's readGroupIds.
   * @return this assertion object.
   * @throws AssertionError if the actual GASearchReadsRequest.Builder's readGroupIds does not contain all given String elements.
   */
  public GASearchReadsRequestBuilderAssert hasReadGroupIds(String... readGroupIds) {
    // check that actual GASearchReadsRequest.Builder we want to make assertions on is not null.
    isNotNull();

    // check that given String varargs is not null.
    if (readGroupIds == null) failWithMessage("Expecting readGroupIds parameter not to be null.");
    
    // check with standard error message, to set another message call: info.overridingErrorMessage("my error message");
    Iterables.instance().assertContains(info, actual.getReadGroupIds(), readGroupIds);

    // return the current assertion for method chaining
    return this;
  }

  /**
   * Verifies that the actual GASearchReadsRequest.Builder's readGroupIds contains <b>only<b> the given String elements and nothing else in whatever order.
   * @param readGroupIds the given elements that should be contained in actual GASearchReadsRequest.Builder's readGroupIds.
   * @return this assertion object.
   * @throws AssertionError if the actual GASearchReadsRequest.Builder's readGroupIds does not contain all given String elements.
   */
  public GASearchReadsRequestBuilderAssert hasOnlyReadGroupIds(String... readGroupIds) {
    // check that actual GASearchReadsRequest.Builder we want to make assertions on is not null.
    isNotNull();

    // check that given String varargs is not null.
    if (readGroupIds == null) failWithMessage("Expecting readGroupIds parameter not to be null.");
    
    // check with standard error message, to set another message call: info.overridingErrorMessage("my error message");
    Iterables.instance().assertContainsOnly(info, actual.getReadGroupIds(), readGroupIds);

    // return the current assertion for method chaining
    return this;
  }

  /**
   * Verifies that the actual GASearchReadsRequest.Builder's readGroupIds does not contain the given String elements.
   *
   * @param readGroupIds the given elements that should not be in actual GASearchReadsRequest.Builder's readGroupIds.
   * @return this assertion object.
   * @throws AssertionError if the actual GASearchReadsRequest.Builder's readGroupIds contains any given String elements.
   */
  public GASearchReadsRequestBuilderAssert doesNotHaveReadGroupIds(String... readGroupIds) {
    // check that actual GASearchReadsRequest.Builder we want to make assertions on is not null.
    isNotNull();

    // check that given String varargs is not null.
    if (readGroupIds == null) failWithMessage("Expecting readGroupIds parameter not to be null.");
    
    // check with standard error message (use overridingErrorMessage before contains to set your own message).
    Iterables.instance().assertDoesNotContain(info, actual.getReadGroupIds(), readGroupIds);

    // return the current assertion for method chaining
    return this;
  }

  /**
   * Verifies that the actual GASearchReadsRequest.Builder has no readGroupIds.
   * @return this assertion object.
   * @throws AssertionError if the actual GASearchReadsRequest.Builder's readGroupIds is not empty.
   */
  public GASearchReadsRequestBuilderAssert hasNoReadGroupIds() {
    // check that actual GASearchReadsRequest.Builder we want to make assertions on is not null.
    isNotNull();

    // we override the default error message with a more explicit one
    String assertjErrorMessage = "\nExpecting :\n  <%s>\nnot to have readGroupIds but had :\n  <%s>";
    
    // check
    if (actual.getReadGroupIds().iterator().hasNext()) {
      failWithMessage(assertjErrorMessage, actual, actual.getReadGroupIds());
    }
    
    // return the current assertion for method chaining
    return this;
  }
  

  /**
   * Verifies that the actual GASearchReadsRequest.Builder's referenceId is equal to the given one.
   * @param referenceId the given referenceId to compare the actual GASearchReadsRequest.Builder's referenceId to.
   * @return this assertion object.
   * @throws AssertionError - if the actual GASearchReadsRequest.Builder's referenceId is not equal to the given one.
   */
  public GASearchReadsRequestBuilderAssert hasReferenceId(String referenceId) {
    // check that actual GASearchReadsRequest.Builder we want to make assertions on is not null.
    isNotNull();

    // overrides the default error message with a more explicit one
    String assertjErrorMessage = "\nExpecting referenceId of:\n  <%s>\nto be:\n  <%s>\nbut was:\n  <%s>";
    
    // null safe check
    String actualReferenceId = actual.getReferenceId();
    if (!Objects.areEqual(actualReferenceId, referenceId)) {
      failWithMessage(assertjErrorMessage, actual, referenceId, actualReferenceId);
    }

    // return the current assertion for method chaining
    return this;
  }

  /**
   * Verifies that the actual GASearchReadsRequest.Builder's referenceName is equal to the given one.
   * @param referenceName the given referenceName to compare the actual GASearchReadsRequest.Builder's referenceName to.
   * @return this assertion object.
   * @throws AssertionError - if the actual GASearchReadsRequest.Builder's referenceName is not equal to the given one.
   */
  public GASearchReadsRequestBuilderAssert hasReferenceName(String referenceName) {
    // check that actual GASearchReadsRequest.Builder we want to make assertions on is not null.
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
   * Verifies that the actual GASearchReadsRequest.Builder's start is equal to the given one.
   * @param start the given start to compare the actual GASearchReadsRequest.Builder's start to.
   * @return this assertion object.
   * @throws AssertionError - if the actual GASearchReadsRequest.Builder's start is not equal to the given one.
   */
  public GASearchReadsRequestBuilderAssert hasStart(Long start) {
    // check that actual GASearchReadsRequest.Builder we want to make assertions on is not null.
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
   * Verifies that the actual GASearchReadsRequest.Builder has end.
   * @return this assertion object.
   * @throws AssertionError - if the actual GASearchReadsRequest.Builder does not have end.
   */
  public GASearchReadsRequestBuilderAssert hasEnd() {
    // check that actual GASearchReadsRequest.Builder we want to make assertions on is not null.
    isNotNull();

    // check
    if (!actual.hasEnd()) {
      failWithMessage("\nExpecting that actual GASearchReadsRequest.Builder has end but does not have.");
    }
    
    // return the current assertion for method chaining
    return this;
  }

  /**
   * Verifies that the actual GASearchReadsRequest.Builder does not have end.
   * @return this assertion object.
   * @throws AssertionError - if the actual GASearchReadsRequest.Builder has end.
   */
  public GASearchReadsRequestBuilderAssert doesNotHaveEnd() {
    // check that actual GASearchReadsRequest.Builder we want to make assertions on is not null.
    isNotNull();

    // check
    if (actual.hasEnd()) {
      failWithMessage("\nExpecting that actual GASearchReadsRequest.Builder does not have end but has.");
    }
    
    // return the current assertion for method chaining
    return this;
  }

  /**
   * Verifies that the actual GASearchReadsRequest.Builder has page size.
   * @return this assertion object.
   * @throws AssertionError - if the actual GASearchReadsRequest.Builder does not have page size.
   */
  public GASearchReadsRequestBuilderAssert hasPageSize() {
    // check that actual GASearchReadsRequest.Builder we want to make assertions on is not null.
    isNotNull();

    // check
    if (!actual.hasPageSize()) {
      failWithMessage("\nExpecting that actual GASearchReadsRequest.Builder has page size but does not have.");
    }
    
    // return the current assertion for method chaining
    return this;
  }

  /**
   * Verifies that the actual GASearchReadsRequest.Builder does not have page size.
   * @return this assertion object.
   * @throws AssertionError - if the actual GASearchReadsRequest.Builder has page size.
   */
  public GASearchReadsRequestBuilderAssert doesNotHavePageSize() {
    // check that actual GASearchReadsRequest.Builder we want to make assertions on is not null.
    isNotNull();

    // check
    if (actual.hasPageSize()) {
      failWithMessage("\nExpecting that actual GASearchReadsRequest.Builder does not have page size but has.");
    }
    
    // return the current assertion for method chaining
    return this;
  }

  /**
   * Verifies that the actual GASearchReadsRequest.Builder has page token.
   * @return this assertion object.
   * @throws AssertionError - if the actual GASearchReadsRequest.Builder does not have page token.
   */
  public GASearchReadsRequestBuilderAssert hasPageToken() {
    // check that actual GASearchReadsRequest.Builder we want to make assertions on is not null.
    isNotNull();

    // check
    if (!actual.hasPageToken()) {
      failWithMessage("\nExpecting that actual GASearchReadsRequest.Builder has page token but does not have.");
    }
    
    // return the current assertion for method chaining
    return this;
  }

  /**
   * Verifies that the actual GASearchReadsRequest.Builder does not have page token.
   * @return this assertion object.
   * @throws AssertionError - if the actual GASearchReadsRequest.Builder has page token.
   */
  public GASearchReadsRequestBuilderAssert doesNotHavePageToken() {
    // check that actual GASearchReadsRequest.Builder we want to make assertions on is not null.
    isNotNull();

    // check
    if (actual.hasPageToken()) {
      failWithMessage("\nExpecting that actual GASearchReadsRequest.Builder does not have page token but has.");
    }
    
    // return the current assertion for method chaining
    return this;
  }

  /**
   * Verifies that the actual GASearchReadsRequest.Builder has read group ids.
   * @return this assertion object.
   * @throws AssertionError - if the actual GASearchReadsRequest.Builder does not have read group ids.
   */
  public GASearchReadsRequestBuilderAssert hasReadGroupIds() {
    // check that actual GASearchReadsRequest.Builder we want to make assertions on is not null.
    isNotNull();

    // check
    if (!actual.hasReadGroupIds()) {
      failWithMessage("\nExpecting that actual GASearchReadsRequest.Builder has read group ids but does not have.");
    }
    
    // return the current assertion for method chaining
    return this;
  }

  /**
   * Verifies that the actual GASearchReadsRequest.Builder does not have read group ids.
   * @return this assertion object.
   * @throws AssertionError - if the actual GASearchReadsRequest.Builder has read group ids.
   */
  public GASearchReadsRequestBuilderAssert doesNotHaveReadGroupIds() {
    // check that actual GASearchReadsRequest.Builder we want to make assertions on is not null.
    isNotNull();

    // check
    if (actual.hasReadGroupIds()) {
      failWithMessage("\nExpecting that actual GASearchReadsRequest.Builder does not have read group ids but has.");
    }
    
    // return the current assertion for method chaining
    return this;
  }

  /**
   * Verifies that the actual GASearchReadsRequest.Builder has reference id.
   * @return this assertion object.
   * @throws AssertionError - if the actual GASearchReadsRequest.Builder does not have reference id.
   */
  public GASearchReadsRequestBuilderAssert hasReferenceId() {
    // check that actual GASearchReadsRequest.Builder we want to make assertions on is not null.
    isNotNull();

    // check
    if (!actual.hasReferenceId()) {
      failWithMessage("\nExpecting that actual GASearchReadsRequest.Builder has reference id but does not have.");
    }
    
    // return the current assertion for method chaining
    return this;
  }

  /**
   * Verifies that the actual GASearchReadsRequest.Builder does not have reference id.
   * @return this assertion object.
   * @throws AssertionError - if the actual GASearchReadsRequest.Builder has reference id.
   */
  public GASearchReadsRequestBuilderAssert doesNotHaveReferenceId() {
    // check that actual GASearchReadsRequest.Builder we want to make assertions on is not null.
    isNotNull();

    // check
    if (actual.hasReferenceId()) {
      failWithMessage("\nExpecting that actual GASearchReadsRequest.Builder does not have reference id but has.");
    }
    
    // return the current assertion for method chaining
    return this;
  }

  /**
   * Verifies that the actual GASearchReadsRequest.Builder has reference name.
   * @return this assertion object.
   * @throws AssertionError - if the actual GASearchReadsRequest.Builder does not have reference name.
   */
  public GASearchReadsRequestBuilderAssert hasReferenceName() {
    // check that actual GASearchReadsRequest.Builder we want to make assertions on is not null.
    isNotNull();

    // check
    if (!actual.hasReferenceName()) {
      failWithMessage("\nExpecting that actual GASearchReadsRequest.Builder has reference name but does not have.");
    }
    
    // return the current assertion for method chaining
    return this;
  }

  /**
   * Verifies that the actual GASearchReadsRequest.Builder does not have reference name.
   * @return this assertion object.
   * @throws AssertionError - if the actual GASearchReadsRequest.Builder has reference name.
   */
  public GASearchReadsRequestBuilderAssert doesNotHaveReferenceName() {
    // check that actual GASearchReadsRequest.Builder we want to make assertions on is not null.
    isNotNull();

    // check
    if (actual.hasReferenceName()) {
      failWithMessage("\nExpecting that actual GASearchReadsRequest.Builder does not have reference name but has.");
    }
    
    // return the current assertion for method chaining
    return this;
  }

  /**
   * Verifies that the actual GASearchReadsRequest.Builder has start.
   * @return this assertion object.
   * @throws AssertionError - if the actual GASearchReadsRequest.Builder does not have start.
   */
  public GASearchReadsRequestBuilderAssert hasStart() {
    // check that actual GASearchReadsRequest.Builder we want to make assertions on is not null.
    isNotNull();

    // check
    if (!actual.hasStart()) {
      failWithMessage("\nExpecting that actual GASearchReadsRequest.Builder has start but does not have.");
    }
    
    // return the current assertion for method chaining
    return this;
  }

  /**
   * Verifies that the actual GASearchReadsRequest.Builder does not have start.
   * @return this assertion object.
   * @throws AssertionError - if the actual GASearchReadsRequest.Builder has start.
   */
  public GASearchReadsRequestBuilderAssert doesNotHaveStart() {
    // check that actual GASearchReadsRequest.Builder we want to make assertions on is not null.
    isNotNull();

    // check
    if (actual.hasStart()) {
      failWithMessage("\nExpecting that actual GASearchReadsRequest.Builder does not have start but has.");
    }
    
    // return the current assertion for method chaining
    return this;
  }

}