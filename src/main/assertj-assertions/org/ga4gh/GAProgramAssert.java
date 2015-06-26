package org.ga4gh;

import org.assertj.core.api.AbstractAssert;
import org.assertj.core.util.Objects;

/**
 * {@link GAProgram} specific assertions - Generated by CustomAssertionGenerator.
 */
public class GAProgramAssert extends AbstractAssert<GAProgramAssert, GAProgram> {

  /**
   * Creates a new <code>{@link GAProgramAssert}</code> to make assertions on actual GAProgram.
   * @param actual the GAProgram we want to make assertions on.
   */
  public GAProgramAssert(GAProgram actual) {
    super(actual, GAProgramAssert.class);
  }

  /**
   * An entry point for GAProgramAssert to follow AssertJ standard <code>assertThat()</code> statements.<br>
   * With a static import, one can write directly: <code>assertThat(myGAProgram)</code> and get specific assertion with code completion.
   * @param actual the GAProgram we want to make assertions on.
   * @return a new <code>{@link GAProgramAssert}</code>
   */
  public static GAProgramAssert assertThat(GAProgram actual) {
    return new GAProgramAssert(actual);
  }

  /**
   * Verifies that the actual GAProgram's classSchema is equal to the given one.
   * @param classSchema the given classSchema to compare the actual GAProgram's classSchema to.
   * @return this assertion object.
   * @throws AssertionError - if the actual GAProgram's classSchema is not equal to the given one.
   */
  public GAProgramAssert hasClassSchema(org.apache.avro.Schema classSchema) {
    // check that actual GAProgram we want to make assertions on is not null.
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
   * Verifies that the actual GAProgram's commandLine is equal to the given one.
   * @param commandLine the given commandLine to compare the actual GAProgram's commandLine to.
   * @return this assertion object.
   * @throws AssertionError - if the actual GAProgram's commandLine is not equal to the given one.
   */
  public GAProgramAssert hasCommandLine(String commandLine) {
    // check that actual GAProgram we want to make assertions on is not null.
    isNotNull();

    // overrides the default error message with a more explicit one
    String assertjErrorMessage = "\nExpecting commandLine of:\n  <%s>\nto be:\n  <%s>\nbut was:\n  <%s>";
    
    // null safe check
    String actualCommandLine = actual.getCommandLine();
    if (!Objects.areEqual(actualCommandLine, commandLine)) {
      failWithMessage(assertjErrorMessage, actual, commandLine, actualCommandLine);
    }

    // return the current assertion for method chaining
    return this;
  }

  /**
   * Verifies that the actual GAProgram's id is equal to the given one.
   * @param id the given id to compare the actual GAProgram's id to.
   * @return this assertion object.
   * @throws AssertionError - if the actual GAProgram's id is not equal to the given one.
   */
  public GAProgramAssert hasId(String id) {
    // check that actual GAProgram we want to make assertions on is not null.
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
   * Verifies that the actual GAProgram's name is equal to the given one.
   * @param name the given name to compare the actual GAProgram's name to.
   * @return this assertion object.
   * @throws AssertionError - if the actual GAProgram's name is not equal to the given one.
   */
  public GAProgramAssert hasName(String name) {
    // check that actual GAProgram we want to make assertions on is not null.
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
   * Verifies that the actual GAProgram's prevProgramId is equal to the given one.
   * @param prevProgramId the given prevProgramId to compare the actual GAProgram's prevProgramId to.
   * @return this assertion object.
   * @throws AssertionError - if the actual GAProgram's prevProgramId is not equal to the given one.
   */
  public GAProgramAssert hasPrevProgramId(String prevProgramId) {
    // check that actual GAProgram we want to make assertions on is not null.
    isNotNull();

    // overrides the default error message with a more explicit one
    String assertjErrorMessage = "\nExpecting prevProgramId of:\n  <%s>\nto be:\n  <%s>\nbut was:\n  <%s>";
    
    // null safe check
    String actualPrevProgramId = actual.getPrevProgramId();
    if (!Objects.areEqual(actualPrevProgramId, prevProgramId)) {
      failWithMessage(assertjErrorMessage, actual, prevProgramId, actualPrevProgramId);
    }

    // return the current assertion for method chaining
    return this;
  }

  /**
   * Verifies that the actual GAProgram's schema is equal to the given one.
   * @param schema the given schema to compare the actual GAProgram's schema to.
   * @return this assertion object.
   * @throws AssertionError - if the actual GAProgram's schema is not equal to the given one.
   */
  public GAProgramAssert hasSchema(org.apache.avro.Schema schema) {
    // check that actual GAProgram we want to make assertions on is not null.
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
   * Verifies that the actual GAProgram's version is equal to the given one.
   * @param version the given version to compare the actual GAProgram's version to.
   * @return this assertion object.
   * @throws AssertionError - if the actual GAProgram's version is not equal to the given one.
   */
  public GAProgramAssert hasVersion(String version) {
    // check that actual GAProgram we want to make assertions on is not null.
    isNotNull();

    // overrides the default error message with a more explicit one
    String assertjErrorMessage = "\nExpecting version of:\n  <%s>\nto be:\n  <%s>\nbut was:\n  <%s>";
    
    // null safe check
    String actualVersion = actual.getVersion();
    if (!Objects.areEqual(actualVersion, version)) {
      failWithMessage(assertjErrorMessage, actual, version, actualVersion);
    }

    // return the current assertion for method chaining
    return this;
  }






}
