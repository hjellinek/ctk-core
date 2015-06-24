package org.ga4gh;

import org.assertj.core.api.*;
import org.assertj.core.util.*;

/**
 * {@link GAIndividualGroup} specific assertions - Generated by CustomAssertionGenerator.
 */
public class GAIndividualGroupAssert extends AbstractAssert<GAIndividualGroupAssert, GAIndividualGroup> {

  /**
   * Creates a new <code>{@link GAIndividualGroupAssert}</code> to make assertions on actual GAIndividualGroup.
   * @param actual the GAIndividualGroup we want to make assertions on.
   */
  public GAIndividualGroupAssert(GAIndividualGroup actual) {
    super(actual, GAIndividualGroupAssert.class);
  }

  /**
   * An entry point for GAIndividualGroupAssert to follow AssertJ standard <code>assertThat()</code> statements.<br>
   * With a static import, one can write directly: <code>assertThat(myGAIndividualGroup)</code> and get specific assertion with code completion.
   * @param actual the GAIndividualGroup we want to make assertions on.
   * @return a new <code>{@link GAIndividualGroupAssert}</code>
   */
  public static GAIndividualGroupAssert assertThat(GAIndividualGroup actual) {
    return new GAIndividualGroupAssert(actual);
  }

  /**
   * Verifies that the actual GAIndividualGroup's classSchema is equal to the given one.
   * @param classSchema the given classSchema to compare the actual GAIndividualGroup's classSchema to.
   * @return this assertion object.
   * @throws AssertionError - if the actual GAIndividualGroup's classSchema is not equal to the given one.
   */
  public GAIndividualGroupAssert hasClassSchema(org.apache.avro.Schema classSchema) {
    // check that actual GAIndividualGroup we want to make assertions on is not null.
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
   * Verifies that the actual GAIndividualGroup's created is equal to the given one.
   * @param created the given created to compare the actual GAIndividualGroup's created to.
   * @return this assertion object.
   * @throws AssertionError - if the actual GAIndividualGroup's created is not equal to the given one.
   */
  public GAIndividualGroupAssert hasCreated(Long created) {
    // check that actual GAIndividualGroup we want to make assertions on is not null.
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
   * Verifies that the actual GAIndividualGroup's description is equal to the given one.
   * @param description the given description to compare the actual GAIndividualGroup's description to.
   * @return this assertion object.
   * @throws AssertionError - if the actual GAIndividualGroup's description is not equal to the given one.
   */
  public GAIndividualGroupAssert hasDescription(String description) {
    // check that actual GAIndividualGroup we want to make assertions on is not null.
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
   * Verifies that the actual GAIndividualGroup's id is equal to the given one.
   * @param id the given id to compare the actual GAIndividualGroup's id to.
   * @return this assertion object.
   * @throws AssertionError - if the actual GAIndividualGroup's id is not equal to the given one.
   */
  public GAIndividualGroupAssert hasId(String id) {
    // check that actual GAIndividualGroup we want to make assertions on is not null.
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
   * Verifies that the actual GAIndividualGroup's info is equal to the given one.
   * @param info the given info to compare the actual GAIndividualGroup's info to.
   * @return this assertion object.
   * @throws AssertionError - if the actual GAIndividualGroup's info is not equal to the given one.
   */
  public GAIndividualGroupAssert hasInfo(java.util.Map info) {
    // check that actual GAIndividualGroup we want to make assertions on is not null.
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
   * Verifies that the actual GAIndividualGroup's name is equal to the given one.
   * @param name the given name to compare the actual GAIndividualGroup's name to.
   * @return this assertion object.
   * @throws AssertionError - if the actual GAIndividualGroup's name is not equal to the given one.
   */
  public GAIndividualGroupAssert hasName(String name) {
    // check that actual GAIndividualGroup we want to make assertions on is not null.
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
   * Verifies that the actual GAIndividualGroup's schema is equal to the given one.
   * @param schema the given schema to compare the actual GAIndividualGroup's schema to.
   * @return this assertion object.
   * @throws AssertionError - if the actual GAIndividualGroup's schema is not equal to the given one.
   */
  public GAIndividualGroupAssert hasSchema(org.apache.avro.Schema schema) {
    // check that actual GAIndividualGroup we want to make assertions on is not null.
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
   * Verifies that the actual GAIndividualGroup's type is equal to the given one.
   * @param type the given type to compare the actual GAIndividualGroup's type to.
   * @return this assertion object.
   * @throws AssertionError - if the actual GAIndividualGroup's type is not equal to the given one.
   */
  public GAIndividualGroupAssert hasType(String type) {
    // check that actual GAIndividualGroup we want to make assertions on is not null.
    isNotNull();

    // overrides the default error message with a more explicit one
    String assertjErrorMessage = "\nExpecting type of:\n  <%s>\nto be:\n  <%s>\nbut was:\n  <%s>";
    
    // null safe check
    String actualType = actual.getType();
    if (!Objects.areEqual(actualType, type)) {
      failWithMessage(assertjErrorMessage, actual, type, actualType);
    }

    // return the current assertion for method chaining
    return this;
  }

  /**
   * Verifies that the actual GAIndividualGroup's updated is equal to the given one.
   * @param updated the given updated to compare the actual GAIndividualGroup's updated to.
   * @return this assertion object.
   * @throws AssertionError - if the actual GAIndividualGroup's updated is not equal to the given one.
   */
  public GAIndividualGroupAssert hasUpdated(Long updated) {
    // check that actual GAIndividualGroup we want to make assertions on is not null.
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
