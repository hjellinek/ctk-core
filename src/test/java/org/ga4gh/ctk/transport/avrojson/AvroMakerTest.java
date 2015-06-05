package org.ga4gh.ctk.transport.avrojson;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.apache.avro.specific.SpecificDatumWriter;
import org.ga4gh.GASearchReadsResponse;
import org.ga4gh.ctk.transport.avrojson.AvroMaker.DESER_MODE;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.ByteArrayOutputStream;

import static org.ga4gh.GASearchReadsResponseAssert.assertThat;

/**
 * AvroMaker Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>Jun 3, 2015</pre>
 */
@RunWith(JUnitParamsRunner.class)
public class AvroMakerTest {

    GASearchReadsResponse gsrr;
    ByteArrayOutputStream theJson;

    long startVal = 4321L;
    int pageSizeVal = 33;
    String TOKEN = "I_am_a_test";

    @Before
    public void before() throws Exception {
        gsrr = GASearchReadsResponse.newBuilder()
                .setNextPageToken(TOKEN)
                .build();

        theJson = JsonMaker.avroToJsonBytes(
                new SpecificDatumWriter<GASearchReadsResponse>(),
                GASearchReadsResponse.SCHEMA$,
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
        GASearchReadsResponse examplar = new GASearchReadsResponse();

        AvroMaker<GASearchReadsResponse> av = new AvroMaker<>(examplar);

        GASearchReadsResponse deserializationResult =
                av.makeAvroFromJson(theJson.toString(), "test deserializing using " + dmode, dmode);
        // do field-by-field compare here
        assertThat(deserializationResult)
                .isNotNull()
                .hasNextPageToken(TOKEN);
    }


} 
