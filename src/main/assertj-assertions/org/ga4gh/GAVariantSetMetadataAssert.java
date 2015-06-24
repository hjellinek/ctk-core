package org.ga4gh;

import org.assertj.core.api.*;
import org.assertj.core.util.*;

/**
 * {@link GAVariantSetMetadata} specific assertions - Generated by CustomAssertionGenerator.
 */
public class GAVariantSetMetadataAssert extends AbstractAssert<GAVariantSetMetadataAssert, GAVariantSetMetadata> {

  /**
   * Creates a new <code>{@link GAVariantSetMetadataAssert}</code> to make assertions on actual GAVariantSetMetadata.
   * @param actual the GAVariantSetMetadata we want to make assertions on.
   */
  public GAVariantSetMetadataAssert(GAVariantSetMetadata actual) {
    super(actual, GAVariantSetMetadataAssert.class);
  }

  /**
   * An entry point for GAVariantSetMetadataAssert to follow AssertJ standard <code>assertThat()</code> statements.<br>
   * With a static import, one can write directly: <code>assertThat(myGAVariantSetMetadata)</code> and get specific assertion with code completion.
   * @param actual the GAVariantSetMetadata we want to make assertions on.
   * @return a new <code>{@link GAVariantSetMetadataAssert}</code>
   */
  public static GAVariantSetMetadataAssert assertThat(GAVariantSetMetadata actual) {
    return new GAVariantSetMetadataAssert(actual);
  }

  /**
   * Verifies that the actual GAVariantSetMetadata's classSchema is equal to the given one.
   * @param classSchema the given classSchema to compare the actual GAVariantSetMetadata's classSchema to.
   * @return this assertion object.
   * @throws AssertionError - if the actual GAVariantSetMetadata's classSchema is not equal to the given one.
   */
  public GAVariantSetMetadataAssert hasClassSchema(org.apache.avro.Schema classSchema) {
    // check that actual GAVariantSetMetadata we want to make assertions on is not null.
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
   * Verifies that the actual GAVariantSetMetadata's description is equal to the given one.
   * @param description the given description to compare the actual GAVariantSetMetadata's description to.
   * @return this assertion object.
   * @throws AssertionError - if the actual GAVariantSetMetadata's description is not equal to the given one.
   */
  public GAVariantSetMetadataAssert hasDescription(String description) {
    // check that actual GAVariantSetMetadata we want to make assertions on is not null.
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
   * Verifies that the actual GAVariantSetMetadata's id is equal to the given one.
   * @param id the given id to compare the actual GAVariantSetMetadata's id to.
   * @return this assertion object.
   * @throws AssertionError - if the actual GAVariantSetMetadata's id is not equal to the given one.
   */
  public GAVariantSetMetadataAssert hasId(String id) {
    // check that actual GAVariantSetMetadata we want to make assertions on is not null.
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
   * Verifies that the actual GAVariantSetMetadata's info is equal to the given one.
   * @param info the given info to compare the actual GAVariantSetMetadata's info to.
   * @return this assertion object.
   * @throws AssertionError - if the actual GAVariantSetMetadata's info is not equal to the given one.
   */
  public GAVariantSetMetadataAssert hasInfo(java.util.Map info) {
    // check that actual GAVariantSetMetadata we want to make assertions on is not null.
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
   * Verifies that the actual GAVariantSetMetadata's key is equal to the given one.
   * @param key the given key to compare the actual GAVariantSetMetadata's key to.
   * @return this assertion object.
   * @throws AssertionError - if the actual GAVariantSetMetadata's key is not equal to the given one.
   */
  public GAVariantSetMetadataAssert hasKey(String key) {
    // check that actual GAVariantSetMetadata we want to make assertions on is not null.
    isNotNull();

    // overrides the default error message with a more explicit one
    String assertjErrorMessage = "\nExpecting key of:\n  <%s>\nto be:\n  <%s>\nbut was:\n  <%s>";
    
    // null safe check
    String actualKey = actual.getKey();
    if (!Objects.areEqual(actualKey, key)) {
      failWithMessage(assertjErrorMessage, actual, key, actualKey);
    }

    // return the current assertion for method chaining
    return this;
  }

  /**
   * Verifies that the actual GAVariantSetMetadata's number is equal to the given one.
   * @param number the given number to compare the actual GAVariantSetMetadata's number to.
   * @return this assertion object.
   * @throws AssertionError - if the actual GAVariantSetMetadata's number is not equal to the given one.
   */
  public GAVariantSetMetadataAssert hasNumber(String number) {
    // check that actual GAVariantSetMetadata we want to make assertions on is not null.
    isNotNull();

    // overrides the default error message with a more explicit one
    String assertjErrorMessage = "\nExpecting number of:\n  <%s>\nto be:\n  <%s>\nbut was:\n  <%s>";
    
    // null safe check
    String actualNumber = actual.getNumber();
    if (!Objects.areEqual(actualNumber, number)) {
      failWithMessage(assertjErrorMessage, actual, number, actualNumber);
    }

    // return the current assertion for method chaining
    return this;
  }

  /**
   * Verifies that the actual GAVariantSetMetadata's schema is equal to the given one.
   * @param schema the given schema to compare the actual GAVariantSetMetadata's schema to.
   * @return this assertion object.
   * @throws AssertionError - if the actual GAVariantSetMetadata's schema is not equal to the given one.
   */
  public GAVariantSetMetadataAssert hasSchema(org.apache.avro.Schema schema) {
    // check that actual GAVariantSetMetadata we want to make assertions on is not null.
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
   * Verifies that the actual GAVariantSetMetadata's type is equal to the given one.
   * @param type the given type to compare the actual GAVariantSetMetadata's type to.
   * @return this assertion object.
   * @throws AssertionError - if the actual GAVariantSetMetadata's type is not equal to the given one.
   */
  public GAVariantSetMetadataAssert hasType(String type) {
    // check that actual GAVariantSetMetadata we want to make assertions on is not null.
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
   * Verifies that the actual GAVariantSetMetadata's value is equal to the given one.
   * @param value the given value to compare the actual GAVariantSetMetadata's value to.
   * @return this assertion object.
   * @throws AssertionError - if the actual GAVariantSetMetadata's value is not equal to the given one.
   */
  public GAVariantSetMetadataAssert hasValue(String value) {
    // check that actual GAVariantSetMetadata we want to make assertions on is not null.
    isNotNull();

    // overrides the default error message with a more explicit one
    String assertjErrorMessage = "\nExpecting value of:\n  <%s>\nto be:\n  <%s>\nbut was:\n  <%s>";
    
    // null safe check
    String actualValue = actual.getValue();
    if (!Objects.areEqual(actualValue, value)) {
      failWithMessage(assertjErrorMessage, actual, value, actualValue);
    }

    // return the current assertion for method chaining
    return this;
  }








}
