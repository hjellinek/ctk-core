package org.ga4gh;

import org.assertj.core.api.AbstractAssert;
import org.assertj.core.util.Objects;

/**
 * {@link GACigarUnit} specific assertions - Generated by CustomAssertionGenerator.
 */
public class GACigarUnitAssert extends AbstractAssert<GACigarUnitAssert, GACigarUnit> {

  /**
   * Creates a new <code>{@link GACigarUnitAssert}</code> to make assertions on actual GACigarUnit.
   * @param actual the GACigarUnit we want to make assertions on.
   */
  public GACigarUnitAssert(GACigarUnit actual) {
    super(actual, GACigarUnitAssert.class);
  }

  /**
   * An entry point for GACigarUnitAssert to follow AssertJ standard <code>assertThat()</code> statements.<br>
   * With a static import, one can write directly: <code>assertThat(myGACigarUnit)</code> and get specific assertion with code completion.
   * @param actual the GACigarUnit we want to make assertions on.
   * @return a new <code>{@link GACigarUnitAssert}</code>
   */
  public static GACigarUnitAssert assertThat(GACigarUnit actual) {
    return new GACigarUnitAssert(actual);
  }

  /**
   * Verifies that the actual GACigarUnit's classSchema is equal to the given one.
   * @param classSchema the given classSchema to compare the actual GACigarUnit's classSchema to.
   * @return this assertion object.
   * @throws AssertionError - if the actual GACigarUnit's classSchema is not equal to the given one.
   */
  public GACigarUnitAssert hasClassSchema(org.apache.avro.Schema classSchema) {
    // check that actual GACigarUnit we want to make assertions on is not null.
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
   * Verifies that the actual GACigarUnit's operation is equal to the given one.
   * @param operation the given operation to compare the actual GACigarUnit's operation to.
   * @return this assertion object.
   * @throws AssertionError - if the actual GACigarUnit's operation is not equal to the given one.
   */
  public GACigarUnitAssert hasOperation(GACigarOperation operation) {
    // check that actual GACigarUnit we want to make assertions on is not null.
    isNotNull();

    // overrides the default error message with a more explicit one
    String assertjErrorMessage = "\nExpecting operation of:\n  <%s>\nto be:\n  <%s>\nbut was:\n  <%s>";
    
    // null safe check
    GACigarOperation actualOperation = actual.getOperation();
    if (!Objects.areEqual(actualOperation, operation)) {
      failWithMessage(assertjErrorMessage, actual, operation, actualOperation);
    }

    // return the current assertion for method chaining
    return this;
  }

  /**
   * Verifies that the actual GACigarUnit's operationLength is equal to the given one.
   * @param operationLength the given operationLength to compare the actual GACigarUnit's operationLength to.
   * @return this assertion object.
   * @throws AssertionError - if the actual GACigarUnit's operationLength is not equal to the given one.
   */
  public GACigarUnitAssert hasOperationLength(Long operationLength) {
    // check that actual GACigarUnit we want to make assertions on is not null.
    isNotNull();

    // overrides the default error message with a more explicit one
    String assertjErrorMessage = "\nExpecting operationLength of:\n  <%s>\nto be:\n  <%s>\nbut was:\n  <%s>";
    
    // null safe check
    Long actualOperationLength = actual.getOperationLength();
    if (!Objects.areEqual(actualOperationLength, operationLength)) {
      failWithMessage(assertjErrorMessage, actual, operationLength, actualOperationLength);
    }

    // return the current assertion for method chaining
    return this;
  }

  /**
   * Verifies that the actual GACigarUnit's referenceSequence is equal to the given one.
   * @param referenceSequence the given referenceSequence to compare the actual GACigarUnit's referenceSequence to.
   * @return this assertion object.
   * @throws AssertionError - if the actual GACigarUnit's referenceSequence is not equal to the given one.
   */
  public GACigarUnitAssert hasReferenceSequence(String referenceSequence) {
    // check that actual GACigarUnit we want to make assertions on is not null.
    isNotNull();

    // overrides the default error message with a more explicit one
    String assertjErrorMessage = "\nExpecting referenceSequence of:\n  <%s>\nto be:\n  <%s>\nbut was:\n  <%s>";
    
    // null safe check
    String actualReferenceSequence = actual.getReferenceSequence();
    if (!Objects.areEqual(actualReferenceSequence, referenceSequence)) {
      failWithMessage(assertjErrorMessage, actual, referenceSequence, actualReferenceSequence);
    }

    // return the current assertion for method chaining
    return this;
  }

  /**
   * Verifies that the actual GACigarUnit's schema is equal to the given one.
   * @param schema the given schema to compare the actual GACigarUnit's schema to.
   * @return this assertion object.
   * @throws AssertionError - if the actual GACigarUnit's schema is not equal to the given one.
   */
  public GACigarUnitAssert hasSchema(org.apache.avro.Schema schema) {
    // check that actual GACigarUnit we want to make assertions on is not null.
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
