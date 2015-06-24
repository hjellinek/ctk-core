package org.ga4gh;

/**
 * {@link GASearchVariantsRequest.Builder} specific assertions - Generated by CustomAssertionGenerator.
 */
public class GASearchVariantsRequestBuilderAssert extends AbstractAssert<GASearchVariantsRequestBuilderAssert, GASearchVariantsRequest.Builder> {

  /**
   * Creates a new <code>{@link GASearchVariantsRequestBuilderAssert}</code> to make assertions on actual GASearchVariantsRequest.Builder.
   * @param actual the GASearchVariantsRequest.Builder we want to make assertions on.
   */
  public GASearchVariantsRequestBuilderAssert(GASearchVariantsRequest.Builder actual) {
    super(actual, GASearchVariantsRequestBuilderAssert.class);
  }

  /**
   * An entry point for GASearchVariantsRequestBuilderAssert to follow AssertJ standard <code>assertThat()</code> statements.<br>
   * With a static import, one can write directly: <code>assertThat(myGASearchVariantsRequest.Builder)</code> and get specific assertion with code completion.
   * @param actual the GASearchVariantsRequest.Builder we want to make assertions on.
   * @return a new <code>{@link GASearchVariantsRequestBuilderAssert}</code>
   */
  public static GASearchVariantsRequestBuilderAssert assertThat(GASearchVariantsRequest.Builder actual) {
    return new GASearchVariantsRequestBuilderAssert(actual);
  }

  /**
   * Verifies that the actual GASearchVariantsRequest.Builder's callSetIds contains the given String elements.
   * @param callSetIds the given elements that should be contained in actual GASearchVariantsRequest.Builder's callSetIds.
   * @return this assertion object.
   * @throws AssertionError if the actual GASearchVariantsRequest.Builder's callSetIds does not contain all given String elements.
   */
  public GASearchVariantsRequestBuilderAssert hasCallSetIds(String... callSetIds) {
    // check that actual GASearchVariantsRequest.Builder we want to make assertions on is not null.
    isNotNull();

    // check that given String varargs is not null.
    if (callSetIds == null) failWithMessage("Expecting callSetIds parameter not to be null.");
    
    // check with standard error message, to set another message call: info.overridingErrorMessage("my error message");
    Iterables.instance().assertContains(info, actual.getCallSetIds(), callSetIds);

    // return the current assertion for method chaining
    return this;
  }

  /**
   * Verifies that the actual GASearchVariantsRequest.Builder's callSetIds contains <b>only<b> the given String elements and nothing else in whatever order.
   * @param callSetIds the given elements that should be contained in actual GASearchVariantsRequest.Builder's callSetIds.
   * @return this assertion object.
   * @throws AssertionError if the actual GASearchVariantsRequest.Builder's callSetIds does not contain all given String elements.
   */
  public GASearchVariantsRequestBuilderAssert hasOnlyCallSetIds(String... callSetIds) {
    // check that actual GASearchVariantsRequest.Builder we want to make assertions on is not null.
    isNotNull();

    // check that given String varargs is not null.
    if (callSetIds == null) failWithMessage("Expecting callSetIds parameter not to be null.");
    
    // check with standard error message, to set another message call: info.overridingErrorMessage("my error message");
    Iterables.instance().assertContainsOnly(info, actual.getCallSetIds(), callSetIds);

    // return the current assertion for method chaining
    return this;
  }

  /**
   * Verifies that the actual GASearchVariantsRequest.Builder's callSetIds does not contain the given String elements.
   *
   * @param callSetIds the given elements that should not be in actual GASearchVariantsRequest.Builder's callSetIds.
   * @return this assertion object.
   * @throws AssertionError if the actual GASearchVariantsRequest.Builder's callSetIds contains any given String elements.
   */
  public GASearchVariantsRequestBuilderAssert doesNotHaveCallSetIds(String... callSetIds) {
    // check that actual GASearchVariantsRequest.Builder we want to make assertions on is not null.
    isNotNull();

    // check that given String varargs is not null.
    if (callSetIds == null) failWithMessage("Expecting callSetIds parameter not to be null.");
    
    // check with standard error message (use overridingErrorMessage before contains to set your own message).
    Iterables.instance().assertDoesNotContain(info, actual.getCallSetIds(), callSetIds);

    // return the current assertion for method chaining
    return this;
  }

  /**
   * Verifies that the actual GASearchVariantsRequest.Builder has no callSetIds.
   * @return this assertion object.
   * @throws AssertionError if the actual GASearchVariantsRequest.Builder's callSetIds is not empty.
   */
  public GASearchVariantsRequestBuilderAssert hasNoCallSetIds() {
    // check that actual GASearchVariantsRequest.Builder we want to make assertions on is not null.
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
   * Verifies that the actual GASearchVariantsRequest.Builder's end is equal to the given one.
   * @param end the given end to compare the actual GASearchVariantsRequest.Builder's end to.
   * @return this assertion object.
   * @throws AssertionError - if the actual GASearchVariantsRequest.Builder's end is not equal to the given one.
   */
  public GASearchVariantsRequestBuilderAssert hasEnd(Long end) {
    // check that actual GASearchVariantsRequest.Builder we want to make assertions on is not null.
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
   * Verifies that the actual GASearchVariantsRequest.Builder's pageSize is equal to the given one.
   * @param pageSize the given pageSize to compare the actual GASearchVariantsRequest.Builder's pageSize to.
   * @return this assertion object.
   * @throws AssertionError - if the actual GASearchVariantsRequest.Builder's pageSize is not equal to the given one.
   */
  public GASearchVariantsRequestBuilderAssert hasPageSize(Integer pageSize) {
    // check that actual GASearchVariantsRequest.Builder we want to make assertions on is not null.
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
   * Verifies that the actual GASearchVariantsRequest.Builder's pageToken is equal to the given one.
   * @param pageToken the given pageToken to compare the actual GASearchVariantsRequest.Builder's pageToken to.
   * @return this assertion object.
   * @throws AssertionError - if the actual GASearchVariantsRequest.Builder's pageToken is not equal to the given one.
   */
  public GASearchVariantsRequestBuilderAssert hasPageToken(String pageToken) {
    // check that actual GASearchVariantsRequest.Builder we want to make assertions on is not null.
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
   * Verifies that the actual GASearchVariantsRequest.Builder's referenceName is equal to the given one.
   * @param referenceName the given referenceName to compare the actual GASearchVariantsRequest.Builder's referenceName to.
   * @return this assertion object.
   * @throws AssertionError - if the actual GASearchVariantsRequest.Builder's referenceName is not equal to the given one.
   */
  public GASearchVariantsRequestBuilderAssert hasReferenceName(String referenceName) {
    // check that actual GASearchVariantsRequest.Builder we want to make assertions on is not null.
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
   * Verifies that the actual GASearchVariantsRequest.Builder's start is equal to the given one.
   * @param start the given start to compare the actual GASearchVariantsRequest.Builder's start to.
   * @return this assertion object.
   * @throws AssertionError - if the actual GASearchVariantsRequest.Builder's start is not equal to the given one.
   */
  public GASearchVariantsRequestBuilderAssert hasStart(Long start) {
    // check that actual GASearchVariantsRequest.Builder we want to make assertions on is not null.
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
   * Verifies that the actual GASearchVariantsRequest.Builder's variantName is equal to the given one.
   * @param variantName the given variantName to compare the actual GASearchVariantsRequest.Builder's variantName to.
   * @return this assertion object.
   * @throws AssertionError - if the actual GASearchVariantsRequest.Builder's variantName is not equal to the given one.
   */
  public GASearchVariantsRequestBuilderAssert hasVariantName(String variantName) {
    // check that actual GASearchVariantsRequest.Builder we want to make assertions on is not null.
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
   * Verifies that the actual GASearchVariantsRequest.Builder's variantSetIds contains the given String elements.
   * @param variantSetIds the given elements that should be contained in actual GASearchVariantsRequest.Builder's variantSetIds.
   * @return this assertion object.
   * @throws AssertionError if the actual GASearchVariantsRequest.Builder's variantSetIds does not contain all given String elements.
   */
  public GASearchVariantsRequestBuilderAssert hasVariantSetIds(String... variantSetIds) {
    // check that actual GASearchVariantsRequest.Builder we want to make assertions on is not null.
    isNotNull();

    // check that given String varargs is not null.
    if (variantSetIds == null) failWithMessage("Expecting variantSetIds parameter not to be null.");
    
    // check with standard error message, to set another message call: info.overridingErrorMessage("my error message");
    Iterables.instance().assertContains(info, actual.getVariantSetIds(), variantSetIds);

    // return the current assertion for method chaining
    return this;
  }

  /**
   * Verifies that the actual GASearchVariantsRequest.Builder's variantSetIds contains <b>only<b> the given String elements and nothing else in whatever order.
   * @param variantSetIds the given elements that should be contained in actual GASearchVariantsRequest.Builder's variantSetIds.
   * @return this assertion object.
   * @throws AssertionError if the actual GASearchVariantsRequest.Builder's variantSetIds does not contain all given String elements.
   */
  public GASearchVariantsRequestBuilderAssert hasOnlyVariantSetIds(String... variantSetIds) {
    // check that actual GASearchVariantsRequest.Builder we want to make assertions on is not null.
    isNotNull();

    // check that given String varargs is not null.
    if (variantSetIds == null) failWithMessage("Expecting variantSetIds parameter not to be null.");
    
    // check with standard error message, to set another message call: info.overridingErrorMessage("my error message");
    Iterables.instance().assertContainsOnly(info, actual.getVariantSetIds(), variantSetIds);

    // return the current assertion for method chaining
    return this;
  }

  /**
   * Verifies that the actual GASearchVariantsRequest.Builder's variantSetIds does not contain the given String elements.
   *
   * @param variantSetIds the given elements that should not be in actual GASearchVariantsRequest.Builder's variantSetIds.
   * @return this assertion object.
   * @throws AssertionError if the actual GASearchVariantsRequest.Builder's variantSetIds contains any given String elements.
   */
  public GASearchVariantsRequestBuilderAssert doesNotHaveVariantSetIds(String... variantSetIds) {
    // check that actual GASearchVariantsRequest.Builder we want to make assertions on is not null.
    isNotNull();

    // check that given String varargs is not null.
    if (variantSetIds == null) failWithMessage("Expecting variantSetIds parameter not to be null.");
    
    // check with standard error message (use overridingErrorMessage before contains to set your own message).
    Iterables.instance().assertDoesNotContain(info, actual.getVariantSetIds(), variantSetIds);

    // return the current assertion for method chaining
    return this;
  }

  /**
   * Verifies that the actual GASearchVariantsRequest.Builder has no variantSetIds.
   * @return this assertion object.
   * @throws AssertionError if the actual GASearchVariantsRequest.Builder's variantSetIds is not empty.
   */
  public GASearchVariantsRequestBuilderAssert hasNoVariantSetIds() {
    // check that actual GASearchVariantsRequest.Builder we want to make assertions on is not null.
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
  

  /**
   * Verifies that the actual GASearchVariantsRequest.Builder has call set ids.
   * @return this assertion object.
   * @throws AssertionError - if the actual GASearchVariantsRequest.Builder does not have call set ids.
   */
  public GASearchVariantsRequestBuilderAssert hasCallSetIds() {
    // check that actual GASearchVariantsRequest.Builder we want to make assertions on is not null.
    isNotNull();

    // check
    if (!actual.hasCallSetIds()) {
      failWithMessage("\nExpecting that actual GASearchVariantsRequest.Builder has call set ids but does not have.");
    }
    
    // return the current assertion for method chaining
    return this;
  }

  /**
   * Verifies that the actual GASearchVariantsRequest.Builder does not have call set ids.
   * @return this assertion object.
   * @throws AssertionError - if the actual GASearchVariantsRequest.Builder has call set ids.
   */
  public GASearchVariantsRequestBuilderAssert doesNotHaveCallSetIds() {
    // check that actual GASearchVariantsRequest.Builder we want to make assertions on is not null.
    isNotNull();

    // check
    if (actual.hasCallSetIds()) {
      failWithMessage("\nExpecting that actual GASearchVariantsRequest.Builder does not have call set ids but has.");
    }
    
    // return the current assertion for method chaining
    return this;
  }

  /**
   * Verifies that the actual GASearchVariantsRequest.Builder has end.
   * @return this assertion object.
   * @throws AssertionError - if the actual GASearchVariantsRequest.Builder does not have end.
   */
  public GASearchVariantsRequestBuilderAssert hasEnd() {
    // check that actual GASearchVariantsRequest.Builder we want to make assertions on is not null.
    isNotNull();

    // check
    if (!actual.hasEnd()) {
      failWithMessage("\nExpecting that actual GASearchVariantsRequest.Builder has end but does not have.");
    }
    
    // return the current assertion for method chaining
    return this;
  }

  /**
   * Verifies that the actual GASearchVariantsRequest.Builder does not have end.
   * @return this assertion object.
   * @throws AssertionError - if the actual GASearchVariantsRequest.Builder has end.
   */
  public GASearchVariantsRequestBuilderAssert doesNotHaveEnd() {
    // check that actual GASearchVariantsRequest.Builder we want to make assertions on is not null.
    isNotNull();

    // check
    if (actual.hasEnd()) {
      failWithMessage("\nExpecting that actual GASearchVariantsRequest.Builder does not have end but has.");
    }
    
    // return the current assertion for method chaining
    return this;
  }

  /**
   * Verifies that the actual GASearchVariantsRequest.Builder has page size.
   * @return this assertion object.
   * @throws AssertionError - if the actual GASearchVariantsRequest.Builder does not have page size.
   */
  public GASearchVariantsRequestBuilderAssert hasPageSize() {
    // check that actual GASearchVariantsRequest.Builder we want to make assertions on is not null.
    isNotNull();

    // check
    if (!actual.hasPageSize()) {
      failWithMessage("\nExpecting that actual GASearchVariantsRequest.Builder has page size but does not have.");
    }
    
    // return the current assertion for method chaining
    return this;
  }

  /**
   * Verifies that the actual GASearchVariantsRequest.Builder does not have page size.
   * @return this assertion object.
   * @throws AssertionError - if the actual GASearchVariantsRequest.Builder has page size.
   */
  public GASearchVariantsRequestBuilderAssert doesNotHavePageSize() {
    // check that actual GASearchVariantsRequest.Builder we want to make assertions on is not null.
    isNotNull();

    // check
    if (actual.hasPageSize()) {
      failWithMessage("\nExpecting that actual GASearchVariantsRequest.Builder does not have page size but has.");
    }
    
    // return the current assertion for method chaining
    return this;
  }

  /**
   * Verifies that the actual GASearchVariantsRequest.Builder has page token.
   * @return this assertion object.
   * @throws AssertionError - if the actual GASearchVariantsRequest.Builder does not have page token.
   */
  public GASearchVariantsRequestBuilderAssert hasPageToken() {
    // check that actual GASearchVariantsRequest.Builder we want to make assertions on is not null.
    isNotNull();

    // check
    if (!actual.hasPageToken()) {
      failWithMessage("\nExpecting that actual GASearchVariantsRequest.Builder has page token but does not have.");
    }
    
    // return the current assertion for method chaining
    return this;
  }

  /**
   * Verifies that the actual GASearchVariantsRequest.Builder does not have page token.
   * @return this assertion object.
   * @throws AssertionError - if the actual GASearchVariantsRequest.Builder has page token.
   */
  public GASearchVariantsRequestBuilderAssert doesNotHavePageToken() {
    // check that actual GASearchVariantsRequest.Builder we want to make assertions on is not null.
    isNotNull();

    // check
    if (actual.hasPageToken()) {
      failWithMessage("\nExpecting that actual GASearchVariantsRequest.Builder does not have page token but has.");
    }
    
    // return the current assertion for method chaining
    return this;
  }

  /**
   * Verifies that the actual GASearchVariantsRequest.Builder has reference name.
   * @return this assertion object.
   * @throws AssertionError - if the actual GASearchVariantsRequest.Builder does not have reference name.
   */
  public GASearchVariantsRequestBuilderAssert hasReferenceName() {
    // check that actual GASearchVariantsRequest.Builder we want to make assertions on is not null.
    isNotNull();

    // check
    if (!actual.hasReferenceName()) {
      failWithMessage("\nExpecting that actual GASearchVariantsRequest.Builder has reference name but does not have.");
    }
    
    // return the current assertion for method chaining
    return this;
  }

  /**
   * Verifies that the actual GASearchVariantsRequest.Builder does not have reference name.
   * @return this assertion object.
   * @throws AssertionError - if the actual GASearchVariantsRequest.Builder has reference name.
   */
  public GASearchVariantsRequestBuilderAssert doesNotHaveReferenceName() {
    // check that actual GASearchVariantsRequest.Builder we want to make assertions on is not null.
    isNotNull();

    // check
    if (actual.hasReferenceName()) {
      failWithMessage("\nExpecting that actual GASearchVariantsRequest.Builder does not have reference name but has.");
    }
    
    // return the current assertion for method chaining
    return this;
  }

  /**
   * Verifies that the actual GASearchVariantsRequest.Builder has start.
   * @return this assertion object.
   * @throws AssertionError - if the actual GASearchVariantsRequest.Builder does not have start.
   */
  public GASearchVariantsRequestBuilderAssert hasStart() {
    // check that actual GASearchVariantsRequest.Builder we want to make assertions on is not null.
    isNotNull();

    // check
    if (!actual.hasStart()) {
      failWithMessage("\nExpecting that actual GASearchVariantsRequest.Builder has start but does not have.");
    }
    
    // return the current assertion for method chaining
    return this;
  }

  /**
   * Verifies that the actual GASearchVariantsRequest.Builder does not have start.
   * @return this assertion object.
   * @throws AssertionError - if the actual GASearchVariantsRequest.Builder has start.
   */
  public GASearchVariantsRequestBuilderAssert doesNotHaveStart() {
    // check that actual GASearchVariantsRequest.Builder we want to make assertions on is not null.
    isNotNull();

    // check
    if (actual.hasStart()) {
      failWithMessage("\nExpecting that actual GASearchVariantsRequest.Builder does not have start but has.");
    }
    
    // return the current assertion for method chaining
    return this;
  }

  /**
   * Verifies that the actual GASearchVariantsRequest.Builder has variant name.
   * @return this assertion object.
   * @throws AssertionError - if the actual GASearchVariantsRequest.Builder does not have variant name.
   */
  public GASearchVariantsRequestBuilderAssert hasVariantName() {
    // check that actual GASearchVariantsRequest.Builder we want to make assertions on is not null.
    isNotNull();

    // check
    if (!actual.hasVariantName()) {
      failWithMessage("\nExpecting that actual GASearchVariantsRequest.Builder has variant name but does not have.");
    }
    
    // return the current assertion for method chaining
    return this;
  }

  /**
   * Verifies that the actual GASearchVariantsRequest.Builder does not have variant name.
   * @return this assertion object.
   * @throws AssertionError - if the actual GASearchVariantsRequest.Builder has variant name.
   */
  public GASearchVariantsRequestBuilderAssert doesNotHaveVariantName() {
    // check that actual GASearchVariantsRequest.Builder we want to make assertions on is not null.
    isNotNull();

    // check
    if (actual.hasVariantName()) {
      failWithMessage("\nExpecting that actual GASearchVariantsRequest.Builder does not have variant name but has.");
    }
    
    // return the current assertion for method chaining
    return this;
  }

  /**
   * Verifies that the actual GASearchVariantsRequest.Builder has variant set ids.
   * @return this assertion object.
   * @throws AssertionError - if the actual GASearchVariantsRequest.Builder does not have variant set ids.
   */
  public GASearchVariantsRequestBuilderAssert hasVariantSetIds() {
    // check that actual GASearchVariantsRequest.Builder we want to make assertions on is not null.
    isNotNull();

    // check
    if (!actual.hasVariantSetIds()) {
      failWithMessage("\nExpecting that actual GASearchVariantsRequest.Builder has variant set ids but does not have.");
    }
    
    // return the current assertion for method chaining
    return this;
  }

  /**
   * Verifies that the actual GASearchVariantsRequest.Builder does not have variant set ids.
   * @return this assertion object.
   * @throws AssertionError - if the actual GASearchVariantsRequest.Builder has variant set ids.
   */
  public GASearchVariantsRequestBuilderAssert doesNotHaveVariantSetIds() {
    // check that actual GASearchVariantsRequest.Builder we want to make assertions on is not null.
    isNotNull();

    // check
    if (actual.hasVariantSetIds()) {
      failWithMessage("\nExpecting that actual GASearchVariantsRequest.Builder does not have variant set ids but has.");
    }
    
    // return the current assertion for method chaining
    return this;
  }

}
