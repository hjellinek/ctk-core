package org.ga4gh;

import org.assertj.core.api.AbstractAssert;
import org.assertj.core.internal.Iterables;
import org.assertj.core.util.Objects;

/**
 * {@link GAVariantSet} specific assertions - Generated by CustomAssertionGenerator.
 */
public class GAVariantSetAssert extends AbstractAssert<GAVariantSetAssert, GAVariantSet> {

  /**
   * Creates a new <code>{@link GAVariantSetAssert}</code> to make assertions on actual GAVariantSet.
   * @param actual the GAVariantSet we want to make assertions on.
   */
  public GAVariantSetAssert(GAVariantSet actual) {
    super(actual, GAVariantSetAssert.class);
  }

  /**
   * An entry point for GAVariantSetAssert to follow AssertJ standard <code>assertThat()</code> statements.<br>
   * With a static import, one can write directly: <code>assertThat(myGAVariantSet)</code> and get specific assertion with code completion.
   * @param actual the GAVariantSet we want to make assertions on.
   * @return a new <code>{@link GAVariantSetAssert}</code>
   */
  public static GAVariantSetAssert assertThat(GAVariantSet actual) {
    return new GAVariantSetAssert(actual);
  }

  /**
   * Verifies that the actual GAVariantSet's classSchema is equal to the given one.
   * @param classSchema the given classSchema to compare the actual GAVariantSet's classSchema to.
   * @return this assertion object.
   * @throws AssertionError - if the actual GAVariantSet's classSchema is not equal to the given one.
   */
  public GAVariantSetAssert hasClassSchema(org.apache.avro.Schema classSchema) {
    // check that actual GAVariantSet we want to make assertions on is not null.
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
   * Verifies that the actual GAVariantSet's datasetId is equal to the given one.
   * @param datasetId the given datasetId to compare the actual GAVariantSet's datasetId to.
   * @return this assertion object.
   * @throws AssertionError - if the actual GAVariantSet's datasetId is not equal to the given one.
   */
  public GAVariantSetAssert hasDatasetId(String datasetId) {
    // check that actual GAVariantSet we want to make assertions on is not null.
    isNotNull();

    // overrides the default error message with a more explicit one
    String assertjErrorMessage = "\nExpecting datasetId of:\n  <%s>\nto be:\n  <%s>\nbut was:\n  <%s>";
    
    // null safe check
    String actualDatasetId = actual.getDatasetId();
    if (!Objects.areEqual(actualDatasetId, datasetId)) {
      failWithMessage(assertjErrorMessage, actual, datasetId, actualDatasetId);
    }

    // return the current assertion for method chaining
    return this;
  }

  /**
   * Verifies that the actual GAVariantSet's id is equal to the given one.
   * @param id the given id to compare the actual GAVariantSet's id to.
   * @return this assertion object.
   * @throws AssertionError - if the actual GAVariantSet's id is not equal to the given one.
   */
  public GAVariantSetAssert hasId(String id) {
    // check that actual GAVariantSet we want to make assertions on is not null.
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
   * Verifies that the actual GAVariantSet's metadata contains the given GAVariantSetMetadata elements.
   * @param metadata the given elements that should be contained in actual GAVariantSet's metadata.
   * @return this assertion object.
   * @throws AssertionError if the actual GAVariantSet's metadata does not contain all given GAVariantSetMetadata elements.
   */
  public GAVariantSetAssert hasMetadata(GAVariantSetMetadata... metadata) {
    // check that actual GAVariantSet we want to make assertions on is not null.
    isNotNull();

    // check that given GAVariantSetMetadata varargs is not null.
    if (metadata == null) failWithMessage("Expecting metadata parameter not to be null.");
    
    // check with standard error message, to set another message call: info.overridingErrorMessage("my error message");
    Iterables.instance().assertContains(info, actual.getMetadata(), metadata);

    // return the current assertion for method chaining
    return this;
  }

  /**
   * Verifies that the actual GAVariantSet's metadata contains <b>only<b> the given GAVariantSetMetadata elements and nothing else in whatever order.
   * @param metadata the given elements that should be contained in actual GAVariantSet's metadata.
   * @return this assertion object.
   * @throws AssertionError if the actual GAVariantSet's metadata does not contain all given GAVariantSetMetadata elements.
   */
  public GAVariantSetAssert hasOnlyMetadata(GAVariantSetMetadata... metadata) {
    // check that actual GAVariantSet we want to make assertions on is not null.
    isNotNull();

    // check that given GAVariantSetMetadata varargs is not null.
    if (metadata == null) failWithMessage("Expecting metadata parameter not to be null.");
    
    // check with standard error message, to set another message call: info.overridingErrorMessage("my error message");
    Iterables.instance().assertContainsOnly(info, actual.getMetadata(), metadata);

    // return the current assertion for method chaining
    return this;
  }

  /**
   * Verifies that the actual GAVariantSet's metadata does not contain the given GAVariantSetMetadata elements.
   *
   * @param metadata the given elements that should not be in actual GAVariantSet's metadata.
   * @return this assertion object.
   * @throws AssertionError if the actual GAVariantSet's metadata contains any given GAVariantSetMetadata elements.
   */
  public GAVariantSetAssert doesNotHaveMetadata(GAVariantSetMetadata... metadata) {
    // check that actual GAVariantSet we want to make assertions on is not null.
    isNotNull();

    // check that given GAVariantSetMetadata varargs is not null.
    if (metadata == null) failWithMessage("Expecting metadata parameter not to be null.");
    
    // check with standard error message (use overridingErrorMessage before contains to set your own message).
    Iterables.instance().assertDoesNotContain(info, actual.getMetadata(), metadata);

    // return the current assertion for method chaining
    return this;
  }

  /**
   * Verifies that the actual GAVariantSet has no metadata.
   * @return this assertion object.
   * @throws AssertionError if the actual GAVariantSet's metadata is not empty.
   */
  public GAVariantSetAssert hasNoMetadata() {
    // check that actual GAVariantSet we want to make assertions on is not null.
    isNotNull();

    // we override the default error message with a more explicit one
    String assertjErrorMessage = "\nExpecting :\n  <%s>\nnot to have metadata but had :\n  <%s>";
    
    // check
    if (actual.getMetadata().iterator().hasNext()) {
      failWithMessage(assertjErrorMessage, actual, actual.getMetadata());
    }
    
    // return the current assertion for method chaining
    return this;
  }
  

  /**
   * Verifies that the actual GAVariantSet's schema is equal to the given one.
   * @param schema the given schema to compare the actual GAVariantSet's schema to.
   * @return this assertion object.
   * @throws AssertionError - if the actual GAVariantSet's schema is not equal to the given one.
   */
  public GAVariantSetAssert hasSchema(org.apache.avro.Schema schema) {
    // check that actual GAVariantSet we want to make assertions on is not null.
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