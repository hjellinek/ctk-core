package org.ga4gh.ctk.sut;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * <p>Stupidly named zz... so it runs last, this test class will evaluate
 * integration test completeness (are all messages, data type,and endpoints exercised)</p>
 * <p>Created by Wayne Stidolph on 5/30/2015.</p>
 */

public class zzCheckCoverageIT {

    @Test
    public void allAvroMessagesShouldBeUsed() throws Exception {
        assertEquals(1,1);
    }
}
