package org.ga4gh;

import org.assertj.core.api.*;
import org.assertj.core.internal.*;
import org.assertj.core.util.*;

/**
 * {@link GASample} specific assertions - Generated by CustomAssertionGenerator.
 */
public class GASampleAssert extends AbstractAssert<GASampleAssert, GASample> {

  /**
   * Creates a new <code>{@link GASampleAssert}</code> to make assertions on actual GASample.
   * @param actual the GASample we want to make assertions on.
   */
  public GASampleAssert(GASample actual) {
    super(actual, GASampleAssert.class);
  }

  /**
   * An entry point for GASampleAssert to follow AssertJ standard <code>assertThat()</code> statements.<br>
   * With a static import, one can write directly: <code>assertThat(myGASample)</code> and get specific assertion with code completion.
   * @param actual the GASample we want to make assertions on.
   * @return a new <code>{@link GASampleAssert}</code>
   */
  public static GASampleAssert assertThat(GASample actual) {
    return new GASampleAssert(actual);
  }

  /**
   * Verifies that the actual GASample's accessions contains the given String elements.
   * @param accessions the given elements that should be contained in actual GASample's accessions.
   * @return this assertion object.
   * @throws AssertionError if the actual GASample's accessions does not contain all given String elements.
   */
  public GASampleAssert hasAccessions(String... accessions) {
    // check that actual GASample we want to make assertions on is not null.
    isNotNull();

    // check that given String varargs is not null.
    if (accessions == null) failWithMessage("Expecting accessions parameter not to be null.");
    
    // check with standard error message, to set another message call: info.overridingErrorMessage("my error message");
    Iterables.instance().assertContains(info, actual.getAccessions(), accessions);

    // return the current assertion for method chaining
    return this;
  }

  /**
   * Verifies that the actual GASample's accessions contains <b>only<b> the given String elements and nothing else in whatever order.
   * @param accessions the given elements that should be contained in actual GASample's accessions.
   * @return this assertion object.
   * @throws AssertionError if the actual GASample's accessions does not contain all given String elements.
   */
  public GASampleAssert hasOnlyAccessions(String... accessions) {
    // check that actual GASample we want to make assertions on is not null.
    isNotNull();

    // check that given String varargs is not null.
    if (accessions == null) failWithMessage("Expecting accessions parameter not to be null.");
    
    // check with standard error message, to set another message call: info.overridingErrorMessage("my error message");
    Iterables.instance().assertContainsOnly(info, actual.getAccessions(), accessions);

    // return the current assertion for method chaining
    return this;
  }

  /**
   * Verifies that the actual GASample's accessions does not contain the given String elements.
   *
   * @param accessions the given elements that should not be in actual GASample's accessions.
   * @return this assertion object.
   * @throws AssertionError if the actual GASample's accessions contains any given String elements.
   */
  public GASampleAssert doesNotHaveAccessions(String... accessions) {
    // check that actual GASample we want to make assertions on is not null.
    isNotNull();

    // check that given String varargs is not null.
    if (accessions == null) failWithMessage("Expecting accessions parameter not to be null.");
    
    // check with standard error message (use overridingErrorMessage before contains to set your own message).
    Iterables.instance().assertDoesNotContain(info, actual.getAccessions(), accessions);

    // return the current assertion for method chaining
    return this;
  }

  /**
   * Verifies that the actual GASample has no accessions.
   * @return this assertion object.
   * @throws AssertionError if the actual GASample's accessions is not empty.
   */
  public GASampleAssert hasNoAccessions() {
    // check that actual GASample we want to make assertions on is not null.
    isNotNull();

    // we override the default error message with a more explicit one
    String assertjErrorMessage = "\nExpecting :\n  <%s>\nnot to have accessions but had :\n  <%s>";
    
    // check
    if (actual.getAccessions().iterator().hasNext()) {
      failWithMessage(assertjErrorMessage, actual, actual.getAccessions());
    }
    
    // return the current assertion for method chaining
    return this;
  }
  

  /**
   * Verifies that the actual GASample's age is equal to the given one.
   * @param age the given age to compare the actual GASample's age to.
   * @return this assertion object.
   * @throws AssertionError - if the actual GASample's age is not equal to the given one.
   */
  public GASampleAssert hasAge(Long age) {
    // check that actual GASample we want to make assertions on is not null.
    isNotNull();

    // overrides the default error message with a more explicit one
    String assertjErrorMessage = "\nExpecting age of:\n  <%s>\nto be:\n  <%s>\nbut was:\n  <%s>";
    
    // null safe check
    Long actualAge = actual.getAge();
    if (!Objects.areEqual(actualAge, age)) {
      failWithMessage(assertjErrorMessage, actual, age, actualAge);
    }

    // return the current assertion for method chaining
    return this;
  }

  /**
   * Verifies that the actual GASample's cellLine is equal to the given one.
   * @param cellLine the given cellLine to compare the actual GASample's cellLine to.
   * @return this assertion object.
   * @throws AssertionError - if the actual GASample's cellLine is not equal to the given one.
   */
  public GASampleAssert hasCellLine(String cellLine) {
    // check that actual GASample we want to make assertions on is not null.
    isNotNull();

    // overrides the default error message with a more explicit one
    String assertjErrorMessage = "\nExpecting cellLine of:\n  <%s>\nto be:\n  <%s>\nbut was:\n  <%s>";
    
    // null safe check
    String actualCellLine = actual.getCellLine();
    if (!Objects.areEqual(actualCellLine, cellLine)) {
      failWithMessage(assertjErrorMessage, actual, cellLine, actualCellLine);
    }

    // return the current assertion for method chaining
    return this;
  }

  /**
   * Verifies that the actual GASample's cellType is equal to the given one.
   * @param cellType the given cellType to compare the actual GASample's cellType to.
   * @return this assertion object.
   * @throws AssertionError - if the actual GASample's cellType is not equal to the given one.
   */
  public GASampleAssert hasCellType(String cellType) {
    // check that actual GASample we want to make assertions on is not null.
    isNotNull();

    // overrides the default error message with a more explicit one
    String assertjErrorMessage = "\nExpecting cellType of:\n  <%s>\nto be:\n  <%s>\nbut was:\n  <%s>";
    
    // null safe check
    String actualCellType = actual.getCellType();
    if (!Objects.areEqual(actualCellType, cellType)) {
      failWithMessage(assertjErrorMessage, actual, cellType, actualCellType);
    }

    // return the current assertion for method chaining
    return this;
  }

  /**
   * Verifies that the actual GASample's classSchema is equal to the given one.
   * @param classSchema the given classSchema to compare the actual GASample's classSchema to.
   * @return this assertion object.
   * @throws AssertionError - if the actual GASample's classSchema is not equal to the given one.
   */
  public GASampleAssert hasClassSchema(org.apache.avro.Schema classSchema) {
    // check that actual GASample we want to make assertions on is not null.
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
   * Verifies that the actual GASample's created is equal to the given one.
   * @param created the given created to compare the actual GASample's created to.
   * @return this assertion object.
   * @throws AssertionError - if the actual GASample's created is not equal to the given one.
   */
  public GASampleAssert hasCreated(Long created) {
    // check that actual GASample we want to make assertions on is not null.
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
   * Verifies that the actual GASample's description is equal to the given one.
   * @param description the given description to compare the actual GASample's description to.
   * @return this assertion object.
   * @throws AssertionError - if the actual GASample's description is not equal to the given one.
   */
  public GASampleAssert hasDescription(String description) {
    // check that actual GASample we want to make assertions on is not null.
    isNotNull();

    // overrides the default error message with a more explicit one
    String assertjErrorMessage = "\nExpecting description of:\n  <%s>\nto be:\n  <%s>\nbut was:\n  <%s>";
    
    // null safe check
    String actualDescription = actual.getDescription();
    if (!Objects.areEqual(actualDescription, description)) {
      failWithMessage(assertjErrorMessage, actual, description, actualDescription);
    }

    // return the current assertion for method chaining
    return this;
  }

  /**
   * Verifies that the actual GASample's geocode is equal to the given one.
   * @param geocode the given geocode to compare the actual GASample's geocode to.
   * @return this assertion object.
   * @throws AssertionError - if the actual GASample's geocode is not equal to the given one.
   */
  public GASampleAssert hasGeocode(String geocode) {
    // check that actual GASample we want to make assertions on is not null.
    isNotNull();

    // overrides the default error message with a more explicit one
    String assertjErrorMessage = "\nExpecting geocode of:\n  <%s>\nto be:\n  <%s>\nbut was:\n  <%s>";
    
    // null safe check
    String actualGeocode = actual.getGeocode();
    if (!Objects.areEqual(actualGeocode, geocode)) {
      failWithMessage(assertjErrorMessage, actual, geocode, actualGeocode);
    }

    // return the current assertion for method chaining
    return this;
  }

  /**
   * Verifies that the actual GASample's id is equal to the given one.
   * @param id the given id to compare the actual GASample's id to.
   * @return this assertion object.
   * @throws AssertionError - if the actual GASample's id is not equal to the given one.
   */
  public GASampleAssert hasId(String id) {
    // check that actual GASample we want to make assertions on is not null.
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
   * Verifies that the actual GASample's individualId is equal to the given one.
   * @param individualId the given individualId to compare the actual GASample's individualId to.
   * @return this assertion object.
   * @throws AssertionError - if the actual GASample's individualId is not equal to the given one.
   */
  public GASampleAssert hasIndividualId(String individualId) {
    // check that actual GASample we want to make assertions on is not null.
    isNotNull();

    // overrides the default error message with a more explicit one
    String assertjErrorMessage = "\nExpecting individualId of:\n  <%s>\nto be:\n  <%s>\nbut was:\n  <%s>";
    
    // null safe check
    String actualIndividualId = actual.getIndividualId();
    if (!Objects.areEqual(actualIndividualId, individualId)) {
      failWithMessage(assertjErrorMessage, actual, individualId, actualIndividualId);
    }

    // return the current assertion for method chaining
    return this;
  }

  /**
   * Verifies that the actual GASample's info is equal to the given one.
   * @param info the given info to compare the actual GASample's info to.
   * @return this assertion object.
   * @throws AssertionError - if the actual GASample's info is not equal to the given one.
   */
  public GASampleAssert hasInfo(java.util.Map info) {
    // check that actual GASample we want to make assertions on is not null.
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
   * Verifies that the actual GASample's name is equal to the given one.
   * @param name the given name to compare the actual GASample's name to.
   * @return this assertion object.
   * @throws AssertionError - if the actual GASample's name is not equal to the given one.
   */
  public GASampleAssert hasName(String name) {
    // check that actual GASample we want to make assertions on is not null.
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
   * Verifies that the actual GASample's organismPart is equal to the given one.
   * @param organismPart the given organismPart to compare the actual GASample's organismPart to.
   * @return this assertion object.
   * @throws AssertionError - if the actual GASample's organismPart is not equal to the given one.
   */
  public GASampleAssert hasOrganismPart(GAOntologyTerm organismPart) {
    // check that actual GASample we want to make assertions on is not null.
    isNotNull();

    // overrides the default error message with a more explicit one
    String assertjErrorMessage = "\nExpecting organismPart of:\n  <%s>\nto be:\n  <%s>\nbut was:\n  <%s>";
    
    // null safe check
    GAOntologyTerm actualOrganismPart = actual.getOrganismPart();
    if (!Objects.areEqual(actualOrganismPart, organismPart)) {
      failWithMessage(assertjErrorMessage, actual, organismPart, actualOrganismPart);
    }

    // return the current assertion for method chaining
    return this;
  }

  /**
   * Verifies that the actual GASample's sampleType is equal to the given one.
   * @param sampleType the given sampleType to compare the actual GASample's sampleType to.
   * @return this assertion object.
   * @throws AssertionError - if the actual GASample's sampleType is not equal to the given one.
   */
  public GASampleAssert hasSampleType(String sampleType) {
    // check that actual GASample we want to make assertions on is not null.
    isNotNull();

    // overrides the default error message with a more explicit one
    String assertjErrorMessage = "\nExpecting sampleType of:\n  <%s>\nto be:\n  <%s>\nbut was:\n  <%s>";
    
    // null safe check
    String actualSampleType = actual.getSampleType();
    if (!Objects.areEqual(actualSampleType, sampleType)) {
      failWithMessage(assertjErrorMessage, actual, sampleType, actualSampleType);
    }

    // return the current assertion for method chaining
    return this;
  }

  /**
   * Verifies that the actual GASample's samplingDate is equal to the given one.
   * @param samplingDate the given samplingDate to compare the actual GASample's samplingDate to.
   * @return this assertion object.
   * @throws AssertionError - if the actual GASample's samplingDate is not equal to the given one.
   */
  public GASampleAssert hasSamplingDate(Long samplingDate) {
    // check that actual GASample we want to make assertions on is not null.
    isNotNull();

    // overrides the default error message with a more explicit one
    String assertjErrorMessage = "\nExpecting samplingDate of:\n  <%s>\nto be:\n  <%s>\nbut was:\n  <%s>";
    
    // null safe check
    Long actualSamplingDate = actual.getSamplingDate();
    if (!Objects.areEqual(actualSamplingDate, samplingDate)) {
      failWithMessage(assertjErrorMessage, actual, samplingDate, actualSamplingDate);
    }

    // return the current assertion for method chaining
    return this;
  }

  /**
   * Verifies that the actual GASample's schema is equal to the given one.
   * @param schema the given schema to compare the actual GASample's schema to.
   * @return this assertion object.
   * @throws AssertionError - if the actual GASample's schema is not equal to the given one.
   */
  public GASampleAssert hasSchema(org.apache.avro.Schema schema) {
    // check that actual GASample we want to make assertions on is not null.
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
   * Verifies that the actual GASample's updated is equal to the given one.
   * @param updated the given updated to compare the actual GASample's updated to.
   * @return this assertion object.
   * @throws AssertionError - if the actual GASample's updated is not equal to the given one.
   */
  public GASampleAssert hasUpdated(Long updated) {
    // check that actual GASample we want to make assertions on is not null.
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
















}
