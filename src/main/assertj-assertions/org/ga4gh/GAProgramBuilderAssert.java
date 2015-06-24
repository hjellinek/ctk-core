package org.ga4gh;

/**
 * {@link GAProgram.Builder} specific assertions - Generated by CustomAssertionGenerator.
 */
public class GAProgramBuilderAssert extends AbstractAssert<GAProgramBuilderAssert, GAProgram.Builder> {

  /**
   * Creates a new <code>{@link GAProgramBuilderAssert}</code> to make assertions on actual GAProgram.Builder.
   * @param actual the GAProgram.Builder we want to make assertions on.
   */
  public GAProgramBuilderAssert(GAProgram.Builder actual) {
    super(actual, GAProgramBuilderAssert.class);
  }

  /**
   * An entry point for GAProgramBuilderAssert to follow AssertJ standard <code>assertThat()</code> statements.<br>
   * With a static import, one can write directly: <code>assertThat(myGAProgram.Builder)</code> and get specific assertion with code completion.
   * @param actual the GAProgram.Builder we want to make assertions on.
   * @return a new <code>{@link GAProgramBuilderAssert}</code>
   */
  public static GAProgramBuilderAssert assertThat(GAProgram.Builder actual) {
    return new GAProgramBuilderAssert(actual);
  }

  /**
   * Verifies that the actual GAProgram.Builder's commandLine is equal to the given one.
   * @param commandLine the given commandLine to compare the actual GAProgram.Builder's commandLine to.
   * @return this assertion object.
   * @throws AssertionError - if the actual GAProgram.Builder's commandLine is not equal to the given one.
   */
  public GAProgramBuilderAssert hasCommandLine(String commandLine) {
    // check that actual GAProgram.Builder we want to make assertions on is not null.
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
   * Verifies that the actual GAProgram.Builder's id is equal to the given one.
   * @param id the given id to compare the actual GAProgram.Builder's id to.
   * @return this assertion object.
   * @throws AssertionError - if the actual GAProgram.Builder's id is not equal to the given one.
   */
  public GAProgramBuilderAssert hasId(String id) {
    // check that actual GAProgram.Builder we want to make assertions on is not null.
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
   * Verifies that the actual GAProgram.Builder's name is equal to the given one.
   * @param name the given name to compare the actual GAProgram.Builder's name to.
   * @return this assertion object.
   * @throws AssertionError - if the actual GAProgram.Builder's name is not equal to the given one.
   */
  public GAProgramBuilderAssert hasName(String name) {
    // check that actual GAProgram.Builder we want to make assertions on is not null.
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
   * Verifies that the actual GAProgram.Builder's prevProgramId is equal to the given one.
   * @param prevProgramId the given prevProgramId to compare the actual GAProgram.Builder's prevProgramId to.
   * @return this assertion object.
   * @throws AssertionError - if the actual GAProgram.Builder's prevProgramId is not equal to the given one.
   */
  public GAProgramBuilderAssert hasPrevProgramId(String prevProgramId) {
    // check that actual GAProgram.Builder we want to make assertions on is not null.
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
   * Verifies that the actual GAProgram.Builder's version is equal to the given one.
   * @param version the given version to compare the actual GAProgram.Builder's version to.
   * @return this assertion object.
   * @throws AssertionError - if the actual GAProgram.Builder's version is not equal to the given one.
   */
  public GAProgramBuilderAssert hasVersion(String version) {
    // check that actual GAProgram.Builder we want to make assertions on is not null.
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

  /**
   * Verifies that the actual GAProgram.Builder has command line.
   * @return this assertion object.
   * @throws AssertionError - if the actual GAProgram.Builder does not have command line.
   */
  public GAProgramBuilderAssert hasCommandLine() {
    // check that actual GAProgram.Builder we want to make assertions on is not null.
    isNotNull();

    // check
    if (!actual.hasCommandLine()) {
      failWithMessage("\nExpecting that actual GAProgram.Builder has command line but does not have.");
    }
    
    // return the current assertion for method chaining
    return this;
  }

  /**
   * Verifies that the actual GAProgram.Builder does not have command line.
   * @return this assertion object.
   * @throws AssertionError - if the actual GAProgram.Builder has command line.
   */
  public GAProgramBuilderAssert doesNotHaveCommandLine() {
    // check that actual GAProgram.Builder we want to make assertions on is not null.
    isNotNull();

    // check
    if (actual.hasCommandLine()) {
      failWithMessage("\nExpecting that actual GAProgram.Builder does not have command line but has.");
    }
    
    // return the current assertion for method chaining
    return this;
  }

  /**
   * Verifies that the actual GAProgram.Builder has id.
   * @return this assertion object.
   * @throws AssertionError - if the actual GAProgram.Builder does not have id.
   */
  public GAProgramBuilderAssert hasId() {
    // check that actual GAProgram.Builder we want to make assertions on is not null.
    isNotNull();

    // check
    if (!actual.hasId()) {
      failWithMessage("\nExpecting that actual GAProgram.Builder has id but does not have.");
    }
    
    // return the current assertion for method chaining
    return this;
  }

  /**
   * Verifies that the actual GAProgram.Builder does not have id.
   * @return this assertion object.
   * @throws AssertionError - if the actual GAProgram.Builder has id.
   */
  public GAProgramBuilderAssert doesNotHaveId() {
    // check that actual GAProgram.Builder we want to make assertions on is not null.
    isNotNull();

    // check
    if (actual.hasId()) {
      failWithMessage("\nExpecting that actual GAProgram.Builder does not have id but has.");
    }
    
    // return the current assertion for method chaining
    return this;
  }

  /**
   * Verifies that the actual GAProgram.Builder has name.
   * @return this assertion object.
   * @throws AssertionError - if the actual GAProgram.Builder does not have name.
   */
  public GAProgramBuilderAssert hasName() {
    // check that actual GAProgram.Builder we want to make assertions on is not null.
    isNotNull();

    // check
    if (!actual.hasName()) {
      failWithMessage("\nExpecting that actual GAProgram.Builder has name but does not have.");
    }
    
    // return the current assertion for method chaining
    return this;
  }

  /**
   * Verifies that the actual GAProgram.Builder does not have name.
   * @return this assertion object.
   * @throws AssertionError - if the actual GAProgram.Builder has name.
   */
  public GAProgramBuilderAssert doesNotHaveName() {
    // check that actual GAProgram.Builder we want to make assertions on is not null.
    isNotNull();

    // check
    if (actual.hasName()) {
      failWithMessage("\nExpecting that actual GAProgram.Builder does not have name but has.");
    }
    
    // return the current assertion for method chaining
    return this;
  }

  /**
   * Verifies that the actual GAProgram.Builder has prev program id.
   * @return this assertion object.
   * @throws AssertionError - if the actual GAProgram.Builder does not have prev program id.
   */
  public GAProgramBuilderAssert hasPrevProgramId() {
    // check that actual GAProgram.Builder we want to make assertions on is not null.
    isNotNull();

    // check
    if (!actual.hasPrevProgramId()) {
      failWithMessage("\nExpecting that actual GAProgram.Builder has prev program id but does not have.");
    }
    
    // return the current assertion for method chaining
    return this;
  }

  /**
   * Verifies that the actual GAProgram.Builder does not have prev program id.
   * @return this assertion object.
   * @throws AssertionError - if the actual GAProgram.Builder has prev program id.
   */
  public GAProgramBuilderAssert doesNotHavePrevProgramId() {
    // check that actual GAProgram.Builder we want to make assertions on is not null.
    isNotNull();

    // check
    if (actual.hasPrevProgramId()) {
      failWithMessage("\nExpecting that actual GAProgram.Builder does not have prev program id but has.");
    }
    
    // return the current assertion for method chaining
    return this;
  }

  /**
   * Verifies that the actual GAProgram.Builder has version.
   * @return this assertion object.
   * @throws AssertionError - if the actual GAProgram.Builder does not have version.
   */
  public GAProgramBuilderAssert hasVersion() {
    // check that actual GAProgram.Builder we want to make assertions on is not null.
    isNotNull();

    // check
    if (!actual.hasVersion()) {
      failWithMessage("\nExpecting that actual GAProgram.Builder has version but does not have.");
    }
    
    // return the current assertion for method chaining
    return this;
  }

  /**
   * Verifies that the actual GAProgram.Builder does not have version.
   * @return this assertion object.
   * @throws AssertionError - if the actual GAProgram.Builder has version.
   */
  public GAProgramBuilderAssert doesNotHaveVersion() {
    // check that actual GAProgram.Builder we want to make assertions on is not null.
    isNotNull();

    // check
    if (actual.hasVersion()) {
      failWithMessage("\nExpecting that actual GAProgram.Builder does not have version but has.");
    }
    
    // return the current assertion for method chaining
    return this;
  }

}
