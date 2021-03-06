package org.ga4gh.ctk.transport;

import org.assertj.core.api.AbstractAssert;

/**
 * {@link RespCode} specific assertions - Generated by CustomAssertionGenerator.
 */
public class RespCodeAssert extends AbstractAssert<RespCodeAssert, RespCode> {

  /**
   * Creates a new <code>{@link RespCodeAssert}</code> to make assertions on actual RespCode.
   * @param actual the RespCode we want to make assertions on.
   */
  public RespCodeAssert(RespCode actual) {
    super(actual, RespCodeAssert.class);
  }

  /**
   * An entry point for RespCodeAssert to follow AssertJ standard <code>assertThat()</code> statements.<br>
   * With a static import, one can write directly: <code>assertThat(myRespCode)</code> and get specific assertion with code completion.
   * @param actual the RespCode we want to make assertions on.
   * @return a new <code>{@link RespCodeAssert}</code>
   */
  public static RespCodeAssert assertThat(RespCode actual) {
    return new RespCodeAssert(actual);
  }

}
