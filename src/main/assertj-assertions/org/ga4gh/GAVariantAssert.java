package org.ga4gh;

import org.assertj.core.api.*;
import org.assertj.core.internal.*;
import org.assertj.core.util.*;

/**
 * {@link GAVariant} specific assertions - Generated by CustomAssertionGenerator.
 */
public class GAVariantAssert extends AbstractAssert<GAVariantAssert, GAVariant> {

  /**
   * Creates a new <code>{@link GAVariantAssert}</code> to make assertions on actual GAVariant.
   * @param actual the GAVariant we want to make assertions on.
   */
  public GAVariantAssert(GAVariant actual) {
    super(actual, GAVariantAssert.class);
  }

  /**
   * An entry point for GAVariantAssert to follow AssertJ standard <code>assertThat()</code> statements.<br>
   * With a static import, one can write directly: <code>assertThat(myGAVariant)</code> and get specific assertion with code completion.
   * @param actual the GAVariant we want to make assertions on.
   * @return a new <code>{@link GAVariantAssert}</code>
   */
  public static GAVariantAssert assertThat(GAVariant actual) {
    return new GAVariantAssert(actual);
  }

  /**
   * Verifies that the actual GAVariant's alternateBases contains the given String elements.
   * @param alternateBases the given elements that should be contained in actual GAVariant's alternateBases.
   * @return this assertion object.
   * @throws AssertionError if the actual GAVariant's alternateBases does not contain all given String elements.
   */
  public GAVariantAssert hasAlternateBases(String... alternateBases) {
    // check that actual GAVariant we want to make assertions on is not null.
    isNotNull();

    // check that given String varargs is not null.
    if (alternateBases == null) failWithMessage("Expecting alternateBases parameter not to be null.");
    
    // check with standard error message, to set another message call: info.overridingErrorMessage("my error message");
    Iterables.instance().assertContains(info, actual.getAlternateBases(), alternateBases);

    // return the current assertion for method chaining
    return this;
  }

  /**
   * Verifies that the actual GAVariant's alternateBases contains <b>only<b> the given String elements and nothing else in whatever order.
   * @param alternateBases the given elements that should be contained in actual GAVariant's alternateBases.
   * @return this assertion object.
   * @throws AssertionError if the actual GAVariant's alternateBases does not contain all given String elements.
   */
  public GAVariantAssert hasOnlyAlternateBases(String... alternateBases) {
    // check that actual GAVariant we want to make assertions on is not null.
    isNotNull();

    // check that given String varargs is not null.
    if (alternateBases == null) failWithMessage("Expecting alternateBases parameter not to be null.");
    
    // check with standard error message, to set another message call: info.overridingErrorMessage("my error message");
    Iterables.instance().assertContainsOnly(info, actual.getAlternateBases(), alternateBases);

    // return the current assertion for method chaining
    return this;
  }

  /**
   * Verifies that the actual GAVariant's alternateBases does not contain the given String elements.
   *
   * @param alternateBases the given elements that should not be in actual GAVariant's alternateBases.
   * @return this assertion object.
   * @throws AssertionError if the actual GAVariant's alternateBases contains any given String elements.
   */
  public GAVariantAssert doesNotHaveAlternateBases(String... alternateBases) {
    // check that actual GAVariant we want to make assertions on is not null.
    isNotNull();

    // check that given String varargs is not null.
    if (alternateBases == null) failWithMessage("Expecting alternateBases parameter not to be null.");
    
    // check with standard error message (use overridingErrorMessage before contains to set your own message).
    Iterables.instance().assertDoesNotContain(info, actual.getAlternateBases(), alternateBases);

    // return the current assertion for method chaining
    return this;
  }

  /**
   * Verifies that the actual GAVariant has no alternateBases.
   * @return this assertion object.
   * @throws AssertionError if the actual GAVariant's alternateBases is not empty.
   */
  public GAVariantAssert hasNoAlternateBases() {
    // check that actual GAVariant we want to make assertions on is not null.
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
   * Verifies that the actual GAVariant's calls contains the given GACall elements.
   * @param calls the given elements that should be contained in actual GAVariant's calls.
   * @return this assertion object.
   * @throws AssertionError if the actual GAVariant's calls does not contain all given GACall elements.
   */
  public GAVariantAssert hasCalls(GACall... calls) {
    // check that actual GAVariant we want to make assertions on is not null.
    isNotNull();

    // check that given GACall varargs is not null.
    if (calls == null) failWithMessage("Expecting calls parameter not to be null.");
    
    // check with standard error message, to set another message call: info.overridingErrorMessage("my error message");
    Iterables.instance().assertContains(info, actual.getCalls(), calls);

    // return the current assertion for method chaining
    return this;
  }

  /**
   * Verifies that the actual GAVariant's calls contains <b>only<b> the given GACall elements and nothing else in whatever order.
   * @param calls the given elements that should be contained in actual GAVariant's calls.
   * @return this assertion object.
   * @throws AssertionError if the actual GAVariant's calls does not contain all given GACall elements.
   */
  public GAVariantAssert hasOnlyCalls(GACall... calls) {
    // check that actual GAVariant we want to make assertions on is not null.
    isNotNull();

    // check that given GACall varargs is not null.
    if (calls == null) failWithMessage("Expecting calls parameter not to be null.");
    
    // check with standard error message, to set another message call: info.overridingErrorMessage("my error message");
    Iterables.instance().assertContainsOnly(info, actual.getCalls(), calls);

    // return the current assertion for method chaining
    return this;
  }

  /**
   * Verifies that the actual GAVariant's calls does not contain the given GACall elements.
   *
   * @param calls the given elements that should not be in actual GAVariant's calls.
   * @return this assertion object.
   * @throws AssertionError if the actual GAVariant's calls contains any given GACall elements.
   */
  public GAVariantAssert doesNotHaveCalls(GACall... calls) {
    // check that actual GAVariant we want to make assertions on is not null.
    isNotNull();

    // check that given GACall varargs is not null.
    if (calls == null) failWithMessage("Expecting calls parameter not to be null.");
    
    // check with standard error message (use overridingErrorMessage before contains to set your own message).
    Iterables.instance().assertDoesNotContain(info, actual.getCalls(), calls);

    // return the current assertion for method chaining
    return this;
  }

  /**
   * Verifies that the actual GAVariant has no calls.
   * @return this assertion object.
   * @throws AssertionError if the actual GAVariant's calls is not empty.
   */
  public GAVariantAssert hasNoCalls() {
    // check that actual GAVariant we want to make assertions on is not null.
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
   * Verifies that the actual GAVariant's classSchema is equal to the given one.
   * @param classSchema the given classSchema to compare the actual GAVariant's classSchema to.
   * @return this assertion object.
   * @throws AssertionError - if the actual GAVariant's classSchema is not equal to the given one.
   */
  public GAVariantAssert hasClassSchema(org.apache.avro.Schema classSchema) {
    // check that actual GAVariant we want to make assertions on is not null.
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
   * Verifies that the actual GAVariant's created is equal to the given one.
   * @param created the given created to compare the actual GAVariant's created to.
   * @return this assertion object.
   * @throws AssertionError - if the actual GAVariant's created is not equal to the given one.
   */
  public GAVariantAssert hasCreated(Long created) {
    // check that actual GAVariant we want to make assertions on is not null.
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
   * Verifies that the actual GAVariant's end is equal to the given one.
   * @param end the given end to compare the actual GAVariant's end to.
   * @return this assertion object.
   * @throws AssertionError - if the actual GAVariant's end is not equal to the given one.
   */
  public GAVariantAssert hasEnd(Long end) {
    // check that actual GAVariant we want to make assertions on is not null.
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
   * Verifies that the actual GAVariant's id is equal to the given one.
   * @param id the given id to compare the actual GAVariant's id to.
   * @return this assertion object.
   * @throws AssertionError - if the actual GAVariant's id is not equal to the given one.
   */
  public GAVariantAssert hasId(String id) {
    // check that actual GAVariant we want to make assertions on is not null.
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
   * Verifies that the actual GAVariant's info is equal to the given one.
   * @param info the given info to compare the actual GAVariant's info to.
   * @return this assertion object.
   * @throws AssertionError - if the actual GAVariant's info is not equal to the given one.
   */
  public GAVariantAssert hasInfo(java.util.Map info) {
    // check that actual GAVariant we want to make assertions on is not null.
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
   * Verifies that the actual GAVariant's names contains the given String elements.
   * @param names the given elements that should be contained in actual GAVariant's names.
   * @return this assertion object.
   * @throws AssertionError if the actual GAVariant's names does not contain all given String elements.
   */
  public GAVariantAssert hasNames(String... names) {
    // check that actual GAVariant we want to make assertions on is not null.
    isNotNull();

    // check that given String varargs is not null.
    if (names == null) failWithMessage("Expecting names parameter not to be null.");
    
    // check with standard error message, to set another message call: info.overridingErrorMessage("my error message");
    Iterables.instance().assertContains(info, actual.getNames(), names);

    // return the current assertion for method chaining
    return this;
  }

  /**
   * Verifies that the actual GAVariant's names contains <b>only<b> the given String elements and nothing else in whatever order.
   * @param names the given elements that should be contained in actual GAVariant's names.
   * @return this assertion object.
   * @throws AssertionError if the actual GAVariant's names does not contain all given String elements.
   */
  public GAVariantAssert hasOnlyNames(String... names) {
    // check that actual GAVariant we want to make assertions on is not null.
    isNotNull();

    // check that given String varargs is not null.
    if (names == null) failWithMessage("Expecting names parameter not to be null.");
    
    // check with standard error message, to set another message call: info.overridingErrorMessage("my error message");
    Iterables.instance().assertContainsOnly(info, actual.getNames(), names);

    // return the current assertion for method chaining
    return this;
  }

  /**
   * Verifies that the actual GAVariant's names does not contain the given String elements.
   *
   * @param names the given elements that should not be in actual GAVariant's names.
   * @return this assertion object.
   * @throws AssertionError if the actual GAVariant's names contains any given String elements.
   */
  public GAVariantAssert doesNotHaveNames(String... names) {
    // check that actual GAVariant we want to make assertions on is not null.
    isNotNull();

    // check that given String varargs is not null.
    if (names == null) failWithMessage("Expecting names parameter not to be null.");
    
    // check with standard error message (use overridingErrorMessage before contains to set your own message).
    Iterables.instance().assertDoesNotContain(info, actual.getNames(), names);

    // return the current assertion for method chaining
    return this;
  }

  /**
   * Verifies that the actual GAVariant has no names.
   * @return this assertion object.
   * @throws AssertionError if the actual GAVariant's names is not empty.
   */
  public GAVariantAssert hasNoNames() {
    // check that actual GAVariant we want to make assertions on is not null.
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
   * Verifies that the actual GAVariant's referenceBases is equal to the given one.
   * @param referenceBases the given referenceBases to compare the actual GAVariant's referenceBases to.
   * @return this assertion object.
   * @throws AssertionError - if the actual GAVariant's referenceBases is not equal to the given one.
   */
  public GAVariantAssert hasReferenceBases(String referenceBases) {
    // check that actual GAVariant we want to make assertions on is not null.
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
   * Verifies that the actual GAVariant's referenceName is equal to the given one.
   * @param referenceName the given referenceName to compare the actual GAVariant's referenceName to.
   * @return this assertion object.
   * @throws AssertionError - if the actual GAVariant's referenceName is not equal to the given one.
   */
  public GAVariantAssert hasReferenceName(String referenceName) {
    // check that actual GAVariant we want to make assertions on is not null.
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
   * Verifies that the actual GAVariant's schema is equal to the given one.
   * @param schema the given schema to compare the actual GAVariant's schema to.
   * @return this assertion object.
   * @throws AssertionError - if the actual GAVariant's schema is not equal to the given one.
   */
  public GAVariantAssert hasSchema(org.apache.avro.Schema schema) {
    // check that actual GAVariant we want to make assertions on is not null.
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
   * Verifies that the actual GAVariant's start is equal to the given one.
   * @param start the given start to compare the actual GAVariant's start to.
   * @return this assertion object.
   * @throws AssertionError - if the actual GAVariant's start is not equal to the given one.
   */
  public GAVariantAssert hasStart(Long start) {
    // check that actual GAVariant we want to make assertions on is not null.
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
   * Verifies that the actual GAVariant's updated is equal to the given one.
   * @param updated the given updated to compare the actual GAVariant's updated to.
   * @return this assertion object.
   * @throws AssertionError - if the actual GAVariant's updated is not equal to the given one.
   */
  public GAVariantAssert hasUpdated(Long updated) {
    // check that actual GAVariant we want to make assertions on is not null.
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
   * Verifies that the actual GAVariant's variantSetId is equal to the given one.
   * @param variantSetId the given variantSetId to compare the actual GAVariant's variantSetId to.
   * @return this assertion object.
   * @throws AssertionError - if the actual GAVariant's variantSetId is not equal to the given one.
   */
  public GAVariantAssert hasVariantSetId(String variantSetId) {
    // check that actual GAVariant we want to make assertions on is not null.
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













}
