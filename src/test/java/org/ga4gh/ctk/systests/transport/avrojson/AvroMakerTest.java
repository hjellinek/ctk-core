package org.ga4gh.ctk.systests.transport.avrojson;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.apache.avro.generic.GenericDatumWriter;
import org.ga4gh.GASearchReadsResponse;
import org.ga4gh.ctk.control.testcategories.CTK.AvroTests;
import org.ga4gh.ctk.control.testcategories.CTK.TransportTests;
import org.ga4gh.ctk.transport.avrojson.AvroMaker;
import org.ga4gh.ctk.transport.avrojson.AvroMaker.DESER_MODE;
import org.ga4gh.ctk.transport.avrojson.JsonMaker;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
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
@Category({TransportTests.class, AvroTests.class})
public class AvroMakerTest {

    long startVal = 4321L;
    int pageSizeVal = 33;
    String TOKEN = "I_am_a_test";

    GASearchReadsResponse gsrr;
    ByteArrayOutputStream avroJson;
    String localJson = "{ \"alignments\" : [ ],\"nextPageToken\" : \"" + TOKEN + "\"}";


    // JSON without the type->value bodies for fields
    @Before
    public void before() throws Exception {
        gsrr = GASearchReadsResponse.newBuilder()
                .setNextPageToken(TOKEN)
                .build();

        avroJson = JsonMaker.avroToJsonBytes(
                new GenericDatumWriter<GASearchReadsResponse>(),
                GASearchReadsResponse.SCHEMA$,
                gsrr);
    }

    @After
    public void after() throws Exception { }

    /**
     * Demonstrate deserialize JSON built the "GA4GH way" - no type info,
     * undefined ordering of fields in each JSON block
     * @param dmode set deserializer
     * @throws Exception
     */
    @Test
    @Parameters({"JACKSON_RELAXED"})
    public void testMakeAvroFromJson(DESER_MODE dmode) throws Exception {
        GASearchReadsResponse examplar = new GASearchReadsResponse();

        AvroMaker<GASearchReadsResponse> av = new AvroMaker<>(examplar);

        GASearchReadsResponse deserializationResult =
                av.makeAvroFromJson(localJson.toString(),
                        "test deserializing using " + dmode, dmode);
        // do field-by-field compare here
        assertThat(deserializationResult)
                .isNotNull()
                .hasNextPageToken(TOKEN);
    }

    /**
     * Demonstrate deserialize of Avro-generated serialed JSON; this has type
     * info in the fields, ad demands field ordering be as in the Schema
     * @param dmode set deserializer
     * @throws Exception
     */
    @Test
    @Parameters({"AVRO_DIRECT"})
    public void testMakeAvroFromJsonGenByAvro(DESER_MODE dmode) throws Exception {
        GASearchReadsResponse examplar = new GASearchReadsResponse();

        AvroMaker<GASearchReadsResponse> av = new AvroMaker<>(examplar);

        GASearchReadsResponse deserializationResult =
                av.makeAvroFromJson(avroJson.toString(),
                        "test deserializing using " + dmode, dmode);
        // do field-by-field compare here
        assertThat(deserializationResult)
                .isNotNull()
                .hasNextPageToken(TOKEN);
    }


} 
