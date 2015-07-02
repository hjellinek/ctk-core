package org.ga4gh;

import org.assertj.core.api.AbstractAssert;
import org.assertj.core.internal.Iterables;
import org.assertj.core.util.Objects;

/**
 * {@link GASearchVariantSetsRequest} specific assertions - Generated by CustomAssertionGenerator.
 */
public class GASearchVariantSetsRequestAssert extends AbstractAssert<GASearchVariantSetsRequestAssert, GASearchVariantSetsRequest> {

  /**
   * Creates a new <code>{@link GASearchVariantSetsRequestAssert}</code> to make assertions on actual GASearchVariantSetsRequest.
   * @param actual the GASearchVariantSetsRequest we want to make assertions on.
   */
  public GASearchVariantSetsRequestAssert(GASearchVariantSetsRequest actual) {
    super(actual, GASearchVariantSetsRequestAssert.class);
  }

  /**
   * An entry point for GASearchVariantSetsRequestAssert to follow AssertJ standard <code>assertThat()</code> statements.<br>
   * With a static import, one can write directly: <code>assertThat(myGASearchVariantSetsRequest)</code> and get specific assertion with code completion.
   * @param actual the GASearchVariantSetsRequest we want to make assertions on.
   * @return a new <code>{@link GASearchVariantSetsRequestAssert}</code>
   */
  public static GASearchVariantSetsRequestAssert assertThat(GASearchVariantSetsRequest actual) {
    return new GASearchVariantSetsRequestAssert(actual);
  }

  /**
   * Verifies that the actual GASearchVariantSetsRequest's classSchema is equal to the given one.
   * @param classSchema the given classSchema to compare the actual GASearchVariantSetsRequest's classSchema to.
   * @return this assertion object.
   * @throws AssertionError - if the actual GASearchVariantSetsRequest's classSchema is not equal to the given one.
   */
  public GASearchVariantSetsRequestAssert hasClassSchema(org.apache.avro.Schema classSchema) {
    // check that actual GASearchVariantSetsRequest we want to make assertions on is not null.
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
   * Verifies that the actual GASearchVariantSetsRequest's datasetIds contains the given String elements.
   * @param datasetIds the given elements that should be contained in actual GASearchVariantSetsRequest's datasetIds.
   * @return this assertion object.
   * @throws AssertionError if the actual GASearchVariantSetsRequest's datasetIds does not contain all given String elements.
   */
  public GASearchVariantSetsRequestAssert hasDatasetIds(String... datasetIds) {
    // check that actual GASearchVariantSetsRequest we want to make assertions on is not null.
    isNotNull();

    // check that given String varargs is not null.
    if (datasetIds == null) failWithMessage("Expecting datasetIds parameter not to be null.");
    
    // check with standard error message, to set another message call: info.overridingErrorMessage("my error message");
    Iterables.instance().assertContains(info, actual.getDatasetIds(), datasetIds);

    // return the current assertion for method chaining
    return this;
  }

  /**
   * Verifies that the actual GASearchVariantSetsRequest's datasetIds contains <b>only<b> the given String elements and nothing else in whatever order.
   * @param datasetIds the given elements that should be contained in actual GASearchVariantSetsRequest's datasetIds.
   * @return this assertion object.
   * @throws AssertionError if the actual GASearchVariantSetsRequest's datasetIds does not contain all given String elements.
   */
  public GASearchVariantSetsRequestAssert hasOnlyDatasetIds(String... datasetIds) {
    // check that actual GASearchVariantSetsRequest we want to make assertions on is not null.
    isNotNull();

    // check that given String varargs is not null.
    if (datasetIds == null) failWithMessage("Expecting datasetIds parameter not to be null.");
    
    // check with standard error message, to set another message call: info.overridingErrorMessage("my error message");
    Iterables.instance().assertContainsOnly(info, actual.getDatasetIds(), datasetIds);

    // return the current assertion for method chaining
    return this;
  }

  /**
   * Verifies that the actual GASearchVariantSetsRequest's datasetIds does not contain the given String elements.
   *
   * @param datasetIds the given elements that should not be in actual GASearchVariantSetsRequest's datasetIds.
   * @return this assertion object.
   * @throws AssertionError if the actual GASearchVariantSetsRequest's datasetIds contains any given String elements.
   */
  public GASearchVariantSetsRequestAssert doesNotHaveDatasetIds(String... datasetIds) {
    // check that actual GASearchVariantSetsRequest we want to make assertions on is not null.
    isNotNull();

    // check that given String varargs is not null.
    if (datasetIds == null) failWithMessage("Expecting datasetIds parameter not to be null.");
    
    // check with standard error message (use overridingErrorMessage before contains to set your own message).
    Iterables.instance().assertDoesNotContain(info, actual.getDatasetIds(), datasetIds);

    // return the current assertion for method chaining
    return this;
  }

  /**
   * Verifies that the actual GASearchVariantSetsRequest has no datasetIds.
   * @return this assertion object.
   * @throws AssertionError if the actual GASearchVariantSetsRequest's datasetIds is not empty.
   */
  public GASearchVariantSetsRequestAssert hasNoDatasetIds() {
    // check that actual GASearchVariantSetsRequest we want to make assertions on is not null.
    isNotNull();

    // we override the default error message with a more explicit one
    String assertjErrorMessage = "\nExpecting :\n  <%s>\nnot to have datasetIds but had :\n  <%s>";
    
    // check
    if (actual.getDatasetIds().iterator().hasNext()) {
      failWithMessage(assertjErrorMessage, actual, actual.getDatasetIds());
    }
    
    // return the current assertion for method chaining
    return this;
  }
  

  /**
   * Verifies that the actual GASearchVariantSetsRequest's pageSize is equal to the given one.
   * @param pageSize the given pageSize to compare the actual GASearchVariantSetsRequest's pageSize to.
   * @return this assertion object.
   * @throws AssertionError - if the actual GASearchVariantSetsRequest's pageSize is not equal to the given one.
   */
  public GASearchVariantSetsRequestAssert hasPageSize(Integer pageSize) {
    // check that actual GASearchVariantSetsRequest we want to make assertions on is not null.
    isNotNull();

    // overrides the default error message with a more explicit one
    String assertjErrorMessage = "\nExpecting pageSize of:\n  <%s>\nto be:\n  <%s>\nbut was:\n  <%s>";
    
    // null safe check
    Integer actualPageSize = actual.getPageSize();
    if (!Objects.areEqual(actualPageSize, pageSize)) {
      failWithMessage(assertjErrorMessage, actual, pageSize, actualPageSize);
    }

    // return the current assertion for method chaining
    return this;
  }

  /**
   * Verifies that the actual GASearchVariantSetsRequest's pageToken is equal to the given one.
   * @param pageToken the given pageToken to compare the actual GASearchVariantSetsRequest's pageToken to.
   * @return this assertion object.
   * @throws AssertionError - if the actual GASearchVariantSetsRequest's pageToken is not equal to the given one.
   */
  public GASearchVariantSetsRequestAssert hasPageToken(String pageToken) {
    // check that actual GASearchVariantSetsRequest we want to make assertions on is not null.
    isNotNull();

    // overrides the default error message with a more explicit one
    String assertjErrorMessage = "\nExpecting pageToken of:\n  <%s>\nto be:\n  <%s>\nbut was:\n  <%s>";
    
    // null safe check
    String actualPageToken = actual.getPageToken();
    if (!Objects.areEqual(actualPageToken, pageToken)) {
      failWithMessage(assertjErrorMessage, actual, pageToken, actualPageToken);
    }

    // return the current assertion for method chaining
    return this;
  }

  /**
   * Verifies that the actual GASearchVariantSetsRequest's schema is equal to the given one.
   * @param schema the given schema to compare the actual GASearchVariantSetsRequest's schema to.
   * @return this assertion object.
   * @throws AssertionError - if the actual GASearchVariantSetsRequest's schema is not equal to the given one.
   */
  public GASearchVariantSetsRequestAssert hasSchema(org.apache.avro.Schema schema) {
    // check that actual GASearchVariantSetsRequest we want to make assertions on is not null.
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
