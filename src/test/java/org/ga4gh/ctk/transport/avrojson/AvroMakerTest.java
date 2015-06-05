package org.ga4gh.ctk.transport.avrojson;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.apache.avro.specific.SpecificDatumWriter;
import org.ga4gh.GASearchReadsRequest;
import org.ga4gh.ctk.transport.avrojson.AvroMaker.DESER_MODE;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.ByteArrayOutputStream;

import static org.ga4gh.GASearchReadsRequestAssert.assertThat;

/**
 * AvroMaker Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>Jun 3, 2015</pre>
 */
@RunWith(JUnitParamsRunner.class)
public class AvroMakerTest {

    GASearchReadsRequest gsrr;
    ByteArrayOutputStream theJson;

    long startVal = 4321L;
    int pageSizeVal = 33;

    @Before
    public void before() throws Exception {
        gsrr = GASearchReadsRequest.newBuilder()
                .setPageSize(pageSizeVal)
                .setStart(startVal)
                .build();

        theJson = JsonMaker.avroToJsonBytes(
                new SpecificDatumWriter<GASearchReadsRequest>(),
                GASearchReadsRequest.SCHEMA$,
                gsrr);
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: makeAvroFromJson use tge @Before avro object, serializes it to
     * JSON then auses AvroMaker to deserialize.
     */
    @Test
    @Parameters({"JACKSON_RELAXED", "JACKSON_AVRO", "AVRO_DIRECT"})
    public void testMakeAvroFromJson(DESER_MODE dmode) throws Exception {
        GASearchReadsRequest examplar = new GASearchReadsRequest();

        AvroMaker<GASearchReadsRequest> av = new AvroMaker<>(examplar);

        GASearchReadsRequest actual =
                av.makeAvroFromJson(theJson.toString(), "testing deserializing " + dmode, dmode);
        // do field-by-field compare here
        assertThat(actual).hasStart(startVal).hasPageSize(pageSizeVal);
    }


} 
