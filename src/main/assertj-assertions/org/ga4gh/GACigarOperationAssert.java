package org.ga4gh;

import org.assertj.core.api.*;
import org.assertj.core.util.*;

/**
 * {@link GACigarOperation} specific assertions - Generated by CustomAssertionGenerator.
 */
public class GACigarOperationAssert extends AbstractAssert<GACigarOperationAssert, GACigarOperation> {

  /**
   * Creates a new <code>{@link GACigarOperationAssert}</code> to make assertions on actual GACigarOperation.
   * @param actual the GACigarOperation we want to make assertions on.
   */
  public GACigarOperationAssert(GACigarOperation actual) {
    super(actual, GACigarOperationAssert.class);
  }

  /**
   * An entry point for GACigarOperationAssert to follow AssertJ standard <code>assertThat()</code> statements.<br>
   * With a static import, one can write directly: <code>assertThat(myGACigarOperation)</code> and get specific assertion with code completion.
   * @param actual the GACigarOperation we want to make assertions on.
   * @return a new <code>{@link GACigarOperationAssert}</code>
   */
  public static GACigarOperationAssert assertThat(GACigarOperation actual) {
    return new GACigarOperationAssert(actual);
  }

  /**
   * Verifies that the actual GACigarOperation's classSchema is equal to the given one.
   * @param classSchema the given classSchema to compare the actual GACigarOperation's classSchema to.
   * @return this assertion object.
   * @throws AssertionError - if the actual GACigarOperation's classSchema is not equal to the given one.
   */
  public GACigarOperationAssert hasClassSchema(org.apache.avro.Schema classSchema) {
    // check that actual GACigarOperation we want to make assertions on is not null.
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

}
