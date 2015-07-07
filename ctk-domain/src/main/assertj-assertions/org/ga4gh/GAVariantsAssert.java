package org.ga4gh;

import org.assertj.core.api.AbstractAssert;

/**
 * {@link GAVariants} specific assertions - Generated by CustomAssertionGenerator.
 */
public class GAVariantsAssert extends AbstractAssert<GAVariantsAssert, GAVariants> {

  /**
   * Creates a new <code>{@link GAVariantsAssert}</code> to make assertions on actual GAVariants.
   * @param actual the GAVariants we want to make assertions on.
   */
  public GAVariantsAssert(GAVariants actual) {
    super(actual, GAVariantsAssert.class);
  }

  /**
   * An entry point for GAVariantsAssert to follow AssertJ standard <code>assertThat()</code> statements.<br>
   * With a static import, one can write directly: <code>assertThat(myGAVariants)</code> and get specific assertion with code completion.
   * @param actual the GAVariants we want to make assertions on.
   * @return a new <code>{@link GAVariantsAssert}</code>
   */
  public static GAVariantsAssert assertThat(GAVariants actual) {
    return new GAVariantsAssert(actual);
  }

}