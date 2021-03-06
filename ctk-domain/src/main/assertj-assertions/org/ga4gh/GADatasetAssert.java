package org.ga4gh;

import org.assertj.core.api.AbstractAssert;
import org.assertj.core.util.Objects;

/**
 * {@link GADataset} specific assertions - Generated by CustomAssertionGenerator.
 */
public class GADatasetAssert extends AbstractAssert<GADatasetAssert, GADataset> {

  /**
   * Creates a new <code>{@link GADatasetAssert}</code> to make assertions on actual GADataset.
   * @param actual the GADataset we want to make assertions on.
   */
  public GADatasetAssert(GADataset actual) {
    super(actual, GADatasetAssert.class);
  }

  /**
   * An entry point for GADatasetAssert to follow AssertJ standard <code>assertThat()</code> statements.<br>
   * With a static import, one can write directly: <code>assertThat(myGADataset)</code> and get specific assertion with code completion.
   * @param actual the GADataset we want to make assertions on.
   * @return a new <code>{@link GADatasetAssert}</code>
   */
  public static GADatasetAssert assertThat(GADataset actual) {
    return new GADatasetAssert(actual);
  }

  /**
   * Verifies that the actual GADataset's classSchema is equal to the given one.
   * @param classSchema the given classSchema to compare the actual GADataset's classSchema to.
   * @return this assertion object.
   * @throws AssertionError - if the actual GADataset's classSchema is not equal to the given one.
   */
  public GADatasetAssert hasClassSchema(org.apache.avro.Schema classSchema) {
    // check that actual GADataset we want to make assertions on is not null.
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
   * Verifies that the actual GADataset's description is equal to the given one.
   * @param description the given description to compare the actual GADataset's description to.
   * @return this assertion object.
   * @throws AssertionError - if the actual GADataset's description is not equal to the given one.
   */
  public GADatasetAssert hasDescription(String description) {
    // check that actual GADataset we want to make assertions on is not null.
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
   * Verifies that the actual GADataset's id is equal to the given one.
   * @param id the given id to compare the actual GADataset's id to.
   * @return this assertion object.
   * @throws AssertionError - if the actual GADataset's id is not equal to the given one.
   */
  public GADatasetAssert hasId(String id) {
    // check that actual GADataset we want to make assertions on is not null.
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
   * Verifies that the actual GADataset's schema is equal to the given one.
   * @param schema the given schema to compare the actual GADataset's schema to.
   * @return this assertion object.
   * @throws AssertionError - if the actual GADataset's schema is not equal to the given one.
   */
  public GADatasetAssert hasSchema(org.apache.avro.Schema schema) {
    // check that actual GADataset we want to make assertions on is not null.
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
