package org.ga4gh;

import org.assertj.core.api.AbstractAssert;
import org.assertj.core.util.Objects;

/**
 * {@link GAPosition} specific assertions - Generated by CustomAssertionGenerator.
 */
public class GAPositionAssert extends AbstractAssert<GAPositionAssert, GAPosition> {

  /**
   * Creates a new <code>{@link GAPositionAssert}</code> to make assertions on actual GAPosition.
   * @param actual the GAPosition we want to make assertions on.
   */
  public GAPositionAssert(GAPosition actual) {
    super(actual, GAPositionAssert.class);
  }

  /**
   * An entry point for GAPositionAssert to follow AssertJ standard <code>assertThat()</code> statements.<br>
   * With a static import, one can write directly: <code>assertThat(myGAPosition)</code> and get specific assertion with code completion.
   * @param actual the GAPosition we want to make assertions on.
   * @return a new <code>{@link GAPositionAssert}</code>
   */
  public static GAPositionAssert assertThat(GAPosition actual) {
    return new GAPositionAssert(actual);
  }

  /**
   * Verifies that the actual GAPosition's classSchema is equal to the given one.
   * @param classSchema the given classSchema to compare the actual GAPosition's classSchema to.
   * @return this assertion object.
   * @throws AssertionError - if the actual GAPosition's classSchema is not equal to the given one.
   */
  public GAPositionAssert hasClassSchema(org.apache.avro.Schema classSchema) {
    // check that actual GAPosition we want to make assertions on is not null.
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
   * Verifies that the actual GAPosition's position is equal to the given one.
   * @param position the given position to compare the actual GAPosition's position to.
   * @return this assertion object.
   * @throws AssertionError - if the actual GAPosition's position is not equal to the given one.
   */
  public GAPositionAssert hasPosition(Long position) {
    // check that actual GAPosition we want to make assertions on is not null.
    isNotNull();

    // overrides the default error message with a more explicit one
    String assertjErrorMessage = "\nExpecting position of:\n  <%s>\nto be:\n  <%s>\nbut was:\n  <%s>";
    
    // null safe check
    Long actualPosition = actual.getPosition();
    if (!Objects.areEqual(actualPosition, position)) {
      failWithMessage(assertjErrorMessage, actual, position, actualPosition);
    }

    // return the current assertion for method chaining
    return this;
  }

  /**
   * Verifies that the actual GAPosition's referenceName is equal to the given one.
   * @param referenceName the given referenceName to compare the actual GAPosition's referenceName to.
   * @return this assertion object.
   * @throws AssertionError - if the actual GAPosition's referenceName is not equal to the given one.
   */
  public GAPositionAssert hasReferenceName(String referenceName) {
    // check that actual GAPosition we want to make assertions on is not null.
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
   * Verifies that the actual GAPosition's reverseStrand is equal to the given one.
   * @param reverseStrand the given reverseStrand to compare the actual GAPosition's reverseStrand to.
   * @return this assertion object.
   * @throws AssertionError - if the actual GAPosition's reverseStrand is not equal to the given one.
   */
  public GAPositionAssert hasReverseStrand(Boolean reverseStrand) {
    // check that actual GAPosition we want to make assertions on is not null.
    isNotNull();

    // overrides the default error message with a more explicit one
    String assertjErrorMessage = "\nExpecting reverseStrand of:\n  <%s>\nto be:\n  <%s>\nbut was:\n  <%s>";
    
    // null safe check
    Boolean actualReverseStrand = actual.getReverseStrand();
    if (!Objects.areEqual(actualReverseStrand, reverseStrand)) {
      failWithMessage(assertjErrorMessage, actual, reverseStrand, actualReverseStrand);
    }

    // return the current assertion for method chaining
    return this;
  }

  /**
   * Verifies that the actual GAPosition's schema is equal to the given one.
   * @param schema the given schema to compare the actual GAPosition's schema to.
   * @return this assertion object.
   * @throws AssertionError - if the actual GAPosition's schema is not equal to the given one.
   */
  public GAPositionAssert hasSchema(org.apache.avro.Schema schema) {
    // check that actual GAPosition we want to make assertions on is not null.
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
