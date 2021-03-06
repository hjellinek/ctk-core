package org.ga4gh;

import org.assertj.core.api.AbstractAssert;
import org.assertj.core.util.Objects;

/**
 * {@link GADataset.Builder} specific assertions - Generated by CustomAssertionGenerator.
 */
public class GADatasetBuilderAssert extends AbstractAssert<GADatasetBuilderAssert, GADataset.Builder> {

  /**
   * Creates a new <code>{@link GADatasetBuilderAssert}</code> to make assertions on actual GADataset.Builder.
   * @param actual the GADataset.Builder we want to make assertions on.
   */
  public GADatasetBuilderAssert(GADataset.Builder actual) {
    super(actual, GADatasetBuilderAssert.class);
  }

  /**
   * An entry point for GADatasetBuilderAssert to follow AssertJ standard <code>assertThat()</code> statements.<br>
   * With a static import, one can write directly: <code>assertThat(myGADataset.Builder)</code> and get specific assertion with code completion.
   * @param actual the GADataset.Builder we want to make assertions on.
   * @return a new <code>{@link GADatasetBuilderAssert}</code>
   */
  public static GADatasetBuilderAssert assertThat(GADataset.Builder actual) {
    return new GADatasetBuilderAssert(actual);
  }

  /**
   * Verifies that the actual GADataset.Builder's description is equal to the given one.
   * @param description the given description to compare the actual GADataset.Builder's description to.
   * @return this assertion object.
   * @throws AssertionError - if the actual GADataset.Builder's description is not equal to the given one.
   */
  public GADatasetBuilderAssert hasDescription(String description) {
    // check that actual GADataset.Builder we want to make assertions on is not null.
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
   * Verifies that the actual GADataset.Builder's id is equal to the given one.
   * @param id the given id to compare the actual GADataset.Builder's id to.
   * @return this assertion object.
   * @throws AssertionError - if the actual GADataset.Builder's id is not equal to the given one.
   */
  public GADatasetBuilderAssert hasId(String id) {
    // check that actual GADataset.Builder we want to make assertions on is not null.
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
   * Verifies that the actual GADataset.Builder has description.
   * @return this assertion object.
   * @throws AssertionError - if the actual GADataset.Builder does not have description.
   */
  public GADatasetBuilderAssert hasDescription() {
    // check that actual GADataset.Builder we want to make assertions on is not null.
    isNotNull();

    // check
    if (!actual.hasDescription()) {
      failWithMessage("\nExpecting that actual GADataset.Builder has description but does not have.");
    }
    
    // return the current assertion for method chaining
    return this;
  }

  /**
   * Verifies that the actual GADataset.Builder does not have description.
   * @return this assertion object.
   * @throws AssertionError - if the actual GADataset.Builder has description.
   */
  public GADatasetBuilderAssert doesNotHaveDescription() {
    // check that actual GADataset.Builder we want to make assertions on is not null.
    isNotNull();

    // check
    if (actual.hasDescription()) {
      failWithMessage("\nExpecting that actual GADataset.Builder does not have description but has.");
    }
    
    // return the current assertion for method chaining
    return this;
  }

  /**
   * Verifies that the actual GADataset.Builder has id.
   * @return this assertion object.
   * @throws AssertionError - if the actual GADataset.Builder does not have id.
   */
  public GADatasetBuilderAssert hasId() {
    // check that actual GADataset.Builder we want to make assertions on is not null.
    isNotNull();

    // check
    if (!actual.hasId()) {
      failWithMessage("\nExpecting that actual GADataset.Builder has id but does not have.");
    }
    
    // return the current assertion for method chaining
    return this;
  }

  /**
   * Verifies that the actual GADataset.Builder does not have id.
   * @return this assertion object.
   * @throws AssertionError - if the actual GADataset.Builder has id.
   */
  public GADatasetBuilderAssert doesNotHaveId() {
    // check that actual GADataset.Builder we want to make assertions on is not null.
    isNotNull();

    // check
    if (actual.hasId()) {
      failWithMessage("\nExpecting that actual GADataset.Builder does not have id but has.");
    }
    
    // return the current assertion for method chaining
    return this;
  }

}
