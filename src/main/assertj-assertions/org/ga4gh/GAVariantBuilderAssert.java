package org.ga4gh;

/**
 * {@link GAVariant.Builder} specific assertions - Generated by CustomAssertionGenerator.
 */
public class GAVariantBuilderAssert extends AbstractAssert<GAVariantBuilderAssert, GAVariant.Builder> {

  /**
   * Creates a new <code>{@link GAVariantBuilderAssert}</code> to make assertions on actual GAVariant.Builder.
   * @param actual the GAVariant.Builder we want to make assertions on.
   */
  public GAVariantBuilderAssert(GAVariant.Builder actual) {
    super(actual, GAVariantBuilderAssert.class);
  }

  /**
   * An entry point for GAVariantBuilderAssert to follow AssertJ standard <code>assertThat()</code> statements.<br>
   * With a static import, one can write directly: <code>assertThat(myGAVariant.Builder)</code> and get specific assertion with code completion.
   * @param actual the GAVariant.Builder we want to make assertions on.
   * @return a new <code>{@link GAVariantBuilderAssert}</code>
   */
  public static GAVariantBuilderAssert assertThat(GAVariant.Builder actual) {
    return new GAVariantBuilderAssert(actual);
  }

  /**
   * Verifies that the actual GAVariant.Builder's alternateBases contains the given String elements.
   * @param alternateBases the given elements that should be contained in actual GAVariant.Builder's alternateBases.
   * @return this assertion object.
   * @throws AssertionError if the actual GAVariant.Builder's alternateBases does not contain all given String elements.
   */
  public GAVariantBuilderAssert hasAlternateBases(String... alternateBases) {
    // check that actual GAVariant.Builder we want to make assertions on is not null.
    isNotNull();

    // check that given String varargs is not null.
    if (alternateBases == null) failWithMessage("Expecting alternateBases parameter not to be null.");
    
    // check with standard error message, to set another message call: info.overridingErrorMessage("my error message");
    Iterables.instance().assertContains(info, actual.getAlternateBases(), alternateBases);

    // return the current assertion for method chaining
    return this;
  }

  /**
   * Verifies that the actual GAVariant.Builder's alternateBases contains <b>only<b> the given String elements and nothing else in whatever order.
   * @param alternateBases the given elements that should be contained in actual GAVariant.Builder's alternateBases.
   * @return this assertion object.
   * @throws AssertionError if the actual GAVariant.Builder's alternateBases does not contain all given String elements.
   */
  public GAVariantBuilderAssert hasOnlyAlternateBases(String... alternateBases) {
    // check that actual GAVariant.Builder we want to make assertions on is not null.
    isNotNull();

    // check that given String varargs is not null.
    if (alternateBases == null) failWithMessage("Expecting alternateBases parameter not to be null.");
    
    // check with standard error message, to set another message call: info.overridingErrorMessage("my error message");
    Iterables.instance().assertContainsOnly(info, actual.getAlternateBases(), alternateBases);

    // return the current assertion for method chaining
    return this;
  }

  /**
   * Verifies that the actual GAVariant.Builder's alternateBases does not contain the given String elements.
   *
   * @param alternateBases the given elements that should not be in actual GAVariant.Builder's alternateBases.
   * @return this assertion object.
   * @throws AssertionError if the actual GAVariant.Builder's alternateBases contains any given String elements.
   */
  public GAVariantBuilderAssert doesNotHaveAlternateBases(String... alternateBases) {
    // check that actual GAVariant.Builder we want to make assertions on is not null.
    isNotNull();

    // check that given String varargs is not null.
    if (alternateBases == null) failWithMessage("Expecting alternateBases parameter not to be null.");
    
    // check with standard error message (use overridingErrorMessage before contains to set your own message).
    Iterables.instance().assertDoesNotContain(info, actual.getAlternateBases(), alternateBases);

    // return the current assertion for method chaining
    return this;
  }

  /**
   * Verifies that the actual GAVariant.Builder has no alternateBases.
   * @return this assertion object.
   * @throws AssertionError if the actual GAVariant.Builder's alternateBases is not empty.
   */
  public GAVariantBuilderAssert hasNoAlternateBases() {
    // check that actual GAVariant.Builder we want to make assertions on is not null.
    isNotNull();

    // we override the default error message with a more explicit one
    String assertjErrorMessage = "\nExpecting :\n  <%s>\nnot to have alternateBases but had :\n  <%s>";
    
    // check
    if (actual.getAlternateBases().iterator().hasNext()) {
      failWithMessage(assertjErrorMessage, actual, actual.getAlternateBases());
    }
    
    // return the current assertion for method chaining
    return this;
  }
  

  /**
   * Verifies that the actual GAVariant.Builder's calls contains the given GACall elements.
   * @param calls the given elements that should be contained in actual GAVariant.Builder's calls.
   * @return this assertion object.
   * @throws AssertionError if the actual GAVariant.Builder's calls does not contain all given GACall elements.
   */
  public GAVariantBuilderAssert hasCalls(GACall... calls) {
    // check that actual GAVariant.Builder we want to make assertions on is not null.
    isNotNull();

    // check that given GACall varargs is not null.
    if (calls == null) failWithMessage("Expecting calls parameter not to be null.");
    
    // check with standard error message, to set another message call: info.overridingErrorMessage("my error message");
    Iterables.instance().assertContains(info, actual.getCalls(), calls);

    // return the current assertion for method chaining
    return this;
  }

  /**
   * Verifies that the actual GAVariant.Builder's calls contains <b>only<b> the given GACall elements and nothing else in whatever order.
   * @param calls the given elements that should be contained in actual GAVariant.Builder's calls.
   * @return this assertion object.
   * @throws AssertionError if the actual GAVariant.Builder's calls does not contain all given GACall elements.
   */
  public GAVariantBuilderAssert hasOnlyCalls(GACall... calls) {
    // check that actual GAVariant.Builder we want to make assertions on is not null.
    isNotNull();

    // check that given GACall varargs is not null.
    if (calls == null) failWithMessage("Expecting calls parameter not to be null.");
    
    // check with standard error message, to set another message call: info.overridingErrorMessage("my error message");
    Iterables.instance().assertContainsOnly(info, actual.getCalls(), calls);

    // return the current assertion for method chaining
    return this;
  }

  /**
   * Verifies that the actual GAVariant.Builder's calls does not contain the given GACall elements.
   *
   * @param calls the given elements that should not be in actual GAVariant.Builder's calls.
   * @return this assertion object.
   * @throws AssertionError if the actual GAVariant.Builder's calls contains any given GACall elements.
   */
  public GAVariantBuilderAssert doesNotHaveCalls(GACall... calls) {
    // check that actual GAVariant.Builder we want to make assertions on is not null.
    isNotNull();

    // check that given GACall varargs is not null.
    if (calls == null) failWithMessage("Expecting calls parameter not to be null.");
    
    // check with standard error message (use overridingErrorMessage before contains to set your own message).
    Iterables.instance().assertDoesNotContain(info, actual.getCalls(), calls);

    // return the current assertion for method chaining
    return this;
  }

  /**
   * Verifies that the actual GAVariant.Builder has no calls.
   * @return this assertion object.
   * @throws AssertionError if the actual GAVariant.Builder's calls is not empty.
   */
  public GAVariantBuilderAssert hasNoCalls() {
    // check that actual GAVariant.Builder we want to make assertions on is not null.
    isNotNull();

    // we override the default error message with a more explicit one
    String assertjErrorMessage = "\nExpecting :\n  <%s>\nnot to have calls but had :\n  <%s>";
    
    // check
    if (actual.getCalls().iterator().hasNext()) {
      failWithMessage(assertjErrorMessage, actual, actual.getCalls());
    }
    
    // return the current assertion for method chaining
    return this;
  }
  

  /**
   * Verifies that the actual GAVariant.Builder's created is equal to the given one.
   * @param created the given created to compare the actual GAVariant.Builder's created to.
   * @return this assertion object.
   * @throws AssertionError - if the actual GAVariant.Builder's created is not equal to the given one.
   */
  public GAVariantBuilderAssert hasCreated(Long created) {
    // check that actual GAVariant.Builder we want to make assertions on is not null.
    isNotNull();

    // overrides the default error message with a more explicit one
    String assertjErrorMessage = "\nExpecting created of:\n  <%s>\nto be:\n  <%s>\nbut was:\n  <%s>";
    
    // null safe check
    Long actualCreated = actual.getCreated();
    if (!Objects.areEqual(actualCreated, created)) {
      failWithMessage(assertjErrorMessage, actual, created, actualCreated);
    }

    // return the current assertion for method chaining
    return this;
  }

  /**
   * Verifies that the actual GAVariant.Builder's end is equal to the given one.
   * @param end the given end to compare the actual GAVariant.Builder's end to.
   * @return this assertion object.
   * @throws AssertionError - if the actual GAVariant.Builder's end is not equal to the given one.
   */
  public GAVariantBuilderAssert hasEnd(Long end) {
    // check that actual GAVariant.Builder we want to make assertions on is not null.
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
   * Verifies that the actual GAVariant.Builder's id is equal to the given one.
   * @param id the given id to compare the actual GAVariant.Builder's id to.
   * @return this assertion object.
   * @throws AssertionError - if the actual GAVariant.Builder's id is not equal to the given one.
   */
  public GAVariantBuilderAssert hasId(String id) {
    // check that actual GAVariant.Builder we want to make assertions on is not null.
    isNotNull();

    // overrides the default error message with a more explicit one
    String assertjErrorMessage = "\nExpecting id of:\n  <%s>\nto be:\n  <%s>\nbut was:\n  <%s>";
    
    // null safe check
    String actualId = actual.getId();
    if (!Objects.areEqual(actualId, id)) {
      failWithMessage(assertjErrorMessage, actual, id, actualId);
    }

    // return the current assertion for method chaining
    return this;
  }

  /**
   * Verifies that the actual GAVariant.Builder's info is equal to the given one.
   * @param info the given info to compare the actual GAVariant.Builder's info to.
   * @return this assertion object.
   * @throws AssertionError - if the actual GAVariant.Builder's info is not equal to the given one.
   */
  public GAVariantBuilderAssert hasInfo(java.util.Map info) {
    // check that actual GAVariant.Builder we want to make assertions on is not null.
    isNotNull();

    // overrides the default error message with a more explicit one
    String assertjErrorMessage = "\nExpecting info of:\n  <%s>\nto be:\n  <%s>\nbut was:\n  <%s>";
    
    // null safe check
    java.util.Map actualInfo = actual.getInfo();
    if (!Objects.areEqual(actualInfo, info)) {
      failWithMessage(assertjErrorMessage, actual, info, actualInfo);
    }

    // return the current assertion for method chaining
    return this;
  }

  /**
   * Verifies that the actual GAVariant.Builder's names contains the given String elements.
   * @param names the given elements that should be contained in actual GAVariant.Builder's names.
   * @return this assertion object.
   * @throws AssertionError if the actual GAVariant.Builder's names does not contain all given String elements.
   */
  public GAVariantBuilderAssert hasNames(String... names) {
    // check that actual GAVariant.Builder we want to make assertions on is not null.
    isNotNull();

    // check that given String varargs is not null.
    if (names == null) failWithMessage("Expecting names parameter not to be null.");
    
    // check with standard error message, to set another message call: info.overridingErrorMessage("my error message");
    Iterables.instance().assertContains(info, actual.getNames(), names);

    // return the current assertion for method chaining
    return this;
  }

  /**
   * Verifies that the actual GAVariant.Builder's names contains <b>only<b> the given String elements and nothing else in whatever order.
   * @param names the given elements that should be contained in actual GAVariant.Builder's names.
   * @return this assertion object.
   * @throws AssertionError if the actual GAVariant.Builder's names does not contain all given String elements.
   */
  public GAVariantBuilderAssert hasOnlyNames(String... names) {
    // check that actual GAVariant.Builder we want to make assertions on is not null.
    isNotNull();

    // check that given String varargs is not null.
    if (names == null) failWithMessage("Expecting names parameter not to be null.");
    
    // check with standard error message, to set another message call: info.overridingErrorMessage("my error message");
    Iterables.instance().assertContainsOnly(info, actual.getNames(), names);

    // return the current assertion for method chaining
    return this;
  }

  /**
   * Verifies that the actual GAVariant.Builder's names does not contain the given String elements.
   *
   * @param names the given elements that should not be in actual GAVariant.Builder's names.
   * @return this assertion object.
   * @throws AssertionError if the actual GAVariant.Builder's names contains any given String elements.
   */
  public GAVariantBuilderAssert doesNotHaveNames(String... names) {
    // check that actual GAVariant.Builder we want to make assertions on is not null.
    isNotNull();

    // check that given String varargs is not null.
    if (names == null) failWithMessage("Expecting names parameter not to be null.");
    
    // check with standard error message (use overridingErrorMessage before contains to set your own message).
    Iterables.instance().assertDoesNotContain(info, actual.getNames(), names);

    // return the current assertion for method chaining
    return this;
  }

  /**
   * Verifies that the actual GAVariant.Builder has no names.
   * @return this assertion object.
   * @throws AssertionError if the actual GAVariant.Builder's names is not empty.
   */
  public GAVariantBuilderAssert hasNoNames() {
    // check that actual GAVariant.Builder we want to make assertions on is not null.
    isNotNull();

    // we override the default error message with a more explicit one
    String assertjErrorMessage = "\nExpecting :\n  <%s>\nnot to have names but had :\n  <%s>";
    
    // check
    if (actual.getNames().iterator().hasNext()) {
      failWithMessage(assertjErrorMessage, actual, actual.getNames());
    }
    
    // return the current assertion for method chaining
    return this;
  }
  

  /**
   * Verifies that the actual GAVariant.Builder's referenceBases is equal to the given one.
   * @param referenceBases the given referenceBases to compare the actual GAVariant.Builder's referenceBases to.
   * @return this assertion object.
   * @throws AssertionError - if the actual GAVariant.Builder's referenceBases is not equal to the given one.
   */
  public GAVariantBuilderAssert hasReferenceBases(String referenceBases) {
    // check that actual GAVariant.Builder we want to make assertions on is not null.
    isNotNull();

    // overrides the default error message with a more explicit one
    String assertjErrorMessage = "\nExpecting referenceBases of:\n  <%s>\nto be:\n  <%s>\nbut was:\n  <%s>";
    
    // null safe check
    String actualReferenceBases = actual.getReferenceBases();
    if (!Objects.areEqual(actualReferenceBases, referenceBases)) {
      failWithMessage(assertjErrorMessage, actual, referenceBases, actualReferenceBases);
    }

    // return the current assertion for method chaining
    return this;
  }

  /**
   * Verifies that the actual GAVariant.Builder's referenceName is equal to the given one.
   * @param referenceName the given referenceName to compare the actual GAVariant.Builder's referenceName to.
   * @return this assertion object.
   * @throws AssertionError - if the actual GAVariant.Builder's referenceName is not equal to the given one.
   */
  public GAVariantBuilderAssert hasReferenceName(String referenceName) {
    // check that actual GAVariant.Builder we want to make assertions on is not null.
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
   * Verifies that the actual GAVariant.Builder's start is equal to the given one.
   * @param start the given start to compare the actual GAVariant.Builder's start to.
   * @return this assertion object.
   * @throws AssertionError - if the actual GAVariant.Builder's start is not equal to the given one.
   */
  public GAVariantBuilderAssert hasStart(Long start) {
    // check that actual GAVariant.Builder we want to make assertions on is not null.
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
   * Verifies that the actual GAVariant.Builder's updated is equal to the given one.
   * @param updated the given updated to compare the actual GAVariant.Builder's updated to.
   * @return this assertion object.
   * @throws AssertionError - if the actual GAVariant.Builder's updated is not equal to the given one.
   */
  public GAVariantBuilderAssert hasUpdated(Long updated) {
    // check that actual GAVariant.Builder we want to make assertions on is not null.
    isNotNull();

    // overrides the default error message with a more explicit one
    String assertjErrorMessage = "\nExpecting updated of:\n  <%s>\nto be:\n  <%s>\nbut was:\n  <%s>";
    
    // null safe check
    Long actualUpdated = actual.getUpdated();
    if (!Objects.areEqual(actualUpdated, updated)) {
      failWithMessage(assertjErrorMessage, actual, updated, actualUpdated);
    }

    // return the current assertion for method chaining
    return this;
  }

  /**
   * Verifies that the actual GAVariant.Builder's variantSetId is equal to the given one.
   * @param variantSetId the given variantSetId to compare the actual GAVariant.Builder's variantSetId to.
   * @return this assertion object.
   * @throws AssertionError - if the actual GAVariant.Builder's variantSetId is not equal to the given one.
   */
  public GAVariantBuilderAssert hasVariantSetId(String variantSetId) {
    // check that actual GAVariant.Builder we want to make assertions on is not null.
    isNotNull();

    // overrides the default error message with a more explicit one
    String assertjErrorMessage = "\nExpecting variantSetId of:\n  <%s>\nto be:\n  <%s>\nbut was:\n  <%s>";
    
    // null safe check
    String actualVariantSetId = actual.getVariantSetId();
    if (!Objects.areEqual(actualVariantSetId, variantSetId)) {
      failWithMessage(assertjErrorMessage, actual, variantSetId, actualVariantSetId);
    }

    // return the current assertion for method chaining
    return this;
  }

  /**
   * Verifies that the actual GAVariant.Builder has alternate bases.
   * @return this assertion object.
   * @throws AssertionError - if the actual GAVariant.Builder does not have alternate bases.
   */
  public GAVariantBuilderAssert hasAlternateBases() {
    // check that actual GAVariant.Builder we want to make assertions on is not null.
    isNotNull();

    // check
    if (!actual.hasAlternateBases()) {
      failWithMessage("\nExpecting that actual GAVariant.Builder has alternate bases but does not have.");
    }
    
    // return the current assertion for method chaining
    return this;
  }

  /**
   * Verifies that the actual GAVariant.Builder does not have alternate bases.
   * @return this assertion object.
   * @throws AssertionError - if the actual GAVariant.Builder has alternate bases.
   */
  public GAVariantBuilderAssert doesNotHaveAlternateBases() {
    // check that actual GAVariant.Builder we want to make assertions on is not null.
    isNotNull();

    // check
    if (actual.hasAlternateBases()) {
      failWithMessage("\nExpecting that actual GAVariant.Builder does not have alternate bases but has.");
    }
    
    // return the current assertion for method chaining
    return this;
  }

  /**
   * Verifies that the actual GAVariant.Builder has calls.
   * @return this assertion object.
   * @throws AssertionError - if the actual GAVariant.Builder does not have calls.
   */
  public GAVariantBuilderAssert hasCalls() {
    // check that actual GAVariant.Builder we want to make assertions on is not null.
    isNotNull();

    // check
    if (!actual.hasCalls()) {
      failWithMessage("\nExpecting that actual GAVariant.Builder has calls but does not have.");
    }
    
    // return the current assertion for method chaining
    return this;
  }

  /**
   * Verifies that the actual GAVariant.Builder does not have calls.
   * @return this assertion object.
   * @throws AssertionError - if the actual GAVariant.Builder has calls.
   */
  public GAVariantBuilderAssert doesNotHaveCalls() {
    // check that actual GAVariant.Builder we want to make assertions on is not null.
    isNotNull();

    // check
    if (actual.hasCalls()) {
      failWithMessage("\nExpecting that actual GAVariant.Builder does not have calls but has.");
    }
    
    // return the current assertion for method chaining
    return this;
  }

  /**
   * Verifies that the actual GAVariant.Builder has created.
   * @return this assertion object.
   * @throws AssertionError - if the actual GAVariant.Builder does not have created.
   */
  public GAVariantBuilderAssert hasCreated() {
    // check that actual GAVariant.Builder we want to make assertions on is not null.
    isNotNull();

    // check
    if (!actual.hasCreated()) {
      failWithMessage("\nExpecting that actual GAVariant.Builder has created but does not have.");
    }
    
    // return the current assertion for method chaining
    return this;
  }

  /**
   * Verifies that the actual GAVariant.Builder does not have created.
   * @return this assertion object.
   * @throws AssertionError - if the actual GAVariant.Builder has created.
   */
  public GAVariantBuilderAssert doesNotHaveCreated() {
    // check that actual GAVariant.Builder we want to make assertions on is not null.
    isNotNull();

    // check
    if (actual.hasCreated()) {
      failWithMessage("\nExpecting that actual GAVariant.Builder does not have created but has.");
    }
    
    // return the current assertion for method chaining
    return this;
  }

  /**
   * Verifies that the actual GAVariant.Builder has end.
   * @return this assertion object.
   * @throws AssertionError - if the actual GAVariant.Builder does not have end.
   */
  public GAVariantBuilderAssert hasEnd() {
    // check that actual GAVariant.Builder we want to make assertions on is not null.
    isNotNull();

    // check
    if (!actual.hasEnd()) {
      failWithMessage("\nExpecting that actual GAVariant.Builder has end but does not have.");
    }
    
    // return the current assertion for method chaining
    return this;
  }

  /**
   * Verifies that the actual GAVariant.Builder does not have end.
   * @return this assertion object.
   * @throws AssertionError - if the actual GAVariant.Builder has end.
   */
  public GAVariantBuilderAssert doesNotHaveEnd() {
    // check that actual GAVariant.Builder we want to make assertions on is not null.
    isNotNull();

    // check
    if (actual.hasEnd()) {
      failWithMessage("\nExpecting that actual GAVariant.Builder does not have end but has.");
    }
    
    // return the current assertion for method chaining
    return this;
  }

  /**
   * Verifies that the actual GAVariant.Builder has id.
   * @return this assertion object.
   * @throws AssertionError - if the actual GAVariant.Builder does not have id.
   */
  public GAVariantBuilderAssert hasId() {
    // check that actual GAVariant.Builder we want to make assertions on is not null.
    isNotNull();

    // check
    if (!actual.hasId()) {
      failWithMessage("\nExpecting that actual GAVariant.Builder has id but does not have.");
    }
    
    // return the current assertion for method chaining
    return this;
  }

  /**
   * Verifies that the actual GAVariant.Builder does not have id.
   * @return this assertion object.
   * @throws AssertionError - if the actual GAVariant.Builder has id.
   */
  public GAVariantBuilderAssert doesNotHaveId() {
    // check that actual GAVariant.Builder we want to make assertions on is not null.
    isNotNull();

    // check
    if (actual.hasId()) {
      failWithMessage("\nExpecting that actual GAVariant.Builder does not have id but has.");
    }
    
    // return the current assertion for method chaining
    return this;
  }

  /**
   * Verifies that the actual GAVariant.Builder has info.
   * @return this assertion object.
   * @throws AssertionError - if the actual GAVariant.Builder does not have info.
   */
  public GAVariantBuilderAssert hasInfo() {
    // check that actual GAVariant.Builder we want to make assertions on is not null.
    isNotNull();

    // check
    if (!actual.hasInfo()) {
      failWithMessage("\nExpecting that actual GAVariant.Builder has info but does not have.");
    }
    
    // return the current assertion for method chaining
    return this;
  }

  /**
   * Verifies that the actual GAVariant.Builder does not have info.
   * @return this assertion object.
   * @throws AssertionError - if the actual GAVariant.Builder has info.
   */
  public GAVariantBuilderAssert doesNotHaveInfo() {
    // check that actual GAVariant.Builder we want to make assertions on is not null.
    isNotNull();

    // check
    if (actual.hasInfo()) {
      failWithMessage("\nExpecting that actual GAVariant.Builder does not have info but has.");
    }
    
    // return the current assertion for method chaining
    return this;
  }

  /**
   * Verifies that the actual GAVariant.Builder has names.
   * @return this assertion object.
   * @throws AssertionError - if the actual GAVariant.Builder does not have names.
   */
  public GAVariantBuilderAssert hasNames() {
    // check that actual GAVariant.Builder we want to make assertions on is not null.
    isNotNull();

    // check
    if (!actual.hasNames()) {
      failWithMessage("\nExpecting that actual GAVariant.Builder has names but does not have.");
    }
    
    // return the current assertion for method chaining
    return this;
  }

  /**
   * Verifies that the actual GAVariant.Builder does not have names.
   * @return this assertion object.
   * @throws AssertionError - if the actual GAVariant.Builder has names.
   */
  public GAVariantBuilderAssert doesNotHaveNames() {
    // check that actual GAVariant.Builder we want to make assertions on is not null.
    isNotNull();

    // check
    if (actual.hasNames()) {
      failWithMessage("\nExpecting that actual GAVariant.Builder does not have names but has.");
    }
    
    // return the current assertion for method chaining
    return this;
  }

  /**
   * Verifies that the actual GAVariant.Builder has reference bases.
   * @return this assertion object.
   * @throws AssertionError - if the actual GAVariant.Builder does not have reference bases.
   */
  public GAVariantBuilderAssert hasReferenceBases() {
    // check that actual GAVariant.Builder we want to make assertions on is not null.
    isNotNull();

    // check
    if (!actual.hasReferenceBases()) {
      failWithMessage("\nExpecting that actual GAVariant.Builder has reference bases but does not have.");
    }
    
    // return the current assertion for method chaining
    return this;
  }

  /**
   * Verifies that the actual GAVariant.Builder does not have reference bases.
   * @return this assertion object.
   * @throws AssertionError - if the actual GAVariant.Builder has reference bases.
   */
  public GAVariantBuilderAssert doesNotHaveReferenceBases() {
    // check that actual GAVariant.Builder we want to make assertions on is not null.
    isNotNull();

    // check
    if (actual.hasReferenceBases()) {
      failWithMessage("\nExpecting that actual GAVariant.Builder does not have reference bases but has.");
    }
    
    // return the current assertion for method chaining
    return this;
  }

  /**
   * Verifies that the actual GAVariant.Builder has reference name.
   * @return this assertion object.
   * @throws AssertionError - if the actual GAVariant.Builder does not have reference name.
   */
  public GAVariantBuilderAssert hasReferenceName() {
    // check that actual GAVariant.Builder we want to make assertions on is not null.
    isNotNull();

    // check
    if (!actual.hasReferenceName()) {
      failWithMessage("\nExpecting that actual GAVariant.Builder has reference name but does not have.");
    }
    
    // return the current assertion for method chaining
    return this;
  }

  /**
   * Verifies that the actual GAVariant.Builder does not have reference name.
   * @return this assertion object.
   * @throws AssertionError - if the actual GAVariant.Builder has reference name.
   */
  public GAVariantBuilderAssert doesNotHaveReferenceName() {
    // check that actual GAVariant.Builder we want to make assertions on is not null.
    isNotNull();

    // check
    if (actual.hasReferenceName()) {
      failWithMessage("\nExpecting that actual GAVariant.Builder does not have reference name but has.");
    }
    
    // return the current assertion for method chaining
    return this;
  }

  /**
   * Verifies that the actual GAVariant.Builder has start.
   * @return this assertion object.
   * @throws AssertionError - if the actual GAVariant.Builder does not have start.
   */
  public GAVariantBuilderAssert hasStart() {
    // check that actual GAVariant.Builder we want to make assertions on is not null.
    isNotNull();

    // check
    if (!actual.hasStart()) {
      failWithMessage("\nExpecting that actual GAVariant.Builder has start but does not have.");
    }
    
    // return the current assertion for method chaining
    return this;
  }

  /**
   * Verifies that the actual GAVariant.Builder does not have start.
   * @return this assertion object.
   * @throws AssertionError - if the actual GAVariant.Builder has start.
   */
  public GAVariantBuilderAssert doesNotHaveStart() {
    // check that actual GAVariant.Builder we want to make assertions on is not null.
    isNotNull();

    // check
    if (actual.hasStart()) {
      failWithMessage("\nExpecting that actual GAVariant.Builder does not have start but has.");
    }
    
    // return the current assertion for method chaining
    return this;
  }

  /**
   * Verifies that the actual GAVariant.Builder has updated.
   * @return this assertion object.
   * @throws AssertionError - if the actual GAVariant.Builder does not have updated.
   */
  public GAVariantBuilderAssert hasUpdated() {
    // check that actual GAVariant.Builder we want to make assertions on is not null.
    isNotNull();

    // check
    if (!actual.hasUpdated()) {
      failWithMessage("\nExpecting that actual GAVariant.Builder has updated but does not have.");
    }
    
    // return the current assertion for method chaining
    return this;
  }

  /**
   * Verifies that the actual GAVariant.Builder does not have updated.
   * @return this assertion object.
   * @throws AssertionError - if the actual GAVariant.Builder has updated.
   */
  public GAVariantBuilderAssert doesNotHaveUpdated() {
    // check that actual GAVariant.Builder we want to make assertions on is not null.
    isNotNull();

    // check
    if (actual.hasUpdated()) {
      failWithMessage("\nExpecting that actual GAVariant.Builder does not have updated but has.");
    }
    
    // return the current assertion for method chaining
    return this;
  }

  /**
   * Verifies that the actual GAVariant.Builder has variant set id.
   * @return this assertion object.
   * @throws AssertionError - if the actual GAVariant.Builder does not have variant set id.
   */
  public GAVariantBuilderAssert hasVariantSetId() {
    // check that actual GAVariant.Builder we want to make assertions on is not null.
    isNotNull();

    // check
    if (!actual.hasVariantSetId()) {
      failWithMessage("\nExpecting that actual GAVariant.Builder has variant set id but does not have.");
    }
    
    // return the current assertion for method chaining
    return this;
  }

  /**
   * Verifies that the actual GAVariant.Builder does not have variant set id.
   * @return this assertion object.
   * @throws AssertionError - if the actual GAVariant.Builder has variant set id.
   */
  public GAVariantBuilderAssert doesNotHaveVariantSetId() {
    // check that actual GAVariant.Builder we want to make assertions on is not null.
    isNotNull();

    // check
    if (actual.hasVariantSetId()) {
      failWithMessage("\nExpecting that actual GAVariant.Builder does not have variant set id but has.");
    }
    
    // return the current assertion for method chaining
    return this;
  }

}
