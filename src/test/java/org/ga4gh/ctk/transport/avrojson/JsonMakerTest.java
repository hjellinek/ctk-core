package org.ga4gh.ctk.transport.avrojson;

import org.apache.avro.Schema;
import org.apache.avro.generic.GenericDatumWriter;
import org.apache.avro.io.DatumWriter;
import org.ga4gh.GAReadGroup;
import org.ga4gh.GASearchAnalysesRequest;
import org.ga4gh.GASearchReadsRequest;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.skyscreamer.jsonassert.JSONAssert;

import java.io.ByteArrayOutputStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * JsonMaker Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>Jun 3, 2015</pre>
 */
public class JsonMakerTest {

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: avroToJson(DatumWriter dw, Schema schema, T srcBytes)
     */
    @Test
    public void NullAvroMeansEmptyJsonBytes() throws Exception {
        //JsonMaker av = new JsonMaker();
        Schema sampleSchema = GAReadGroup.SCHEMA$;
        DatumWriter dw = new GenericDatumWriter<>(sampleSchema);

        // this generates a log warning in JsonMaker, but not
        // an exception
        ByteArrayOutputStream rtn =
                JsonMaker.avroToJsonBytes(dw, sampleSchema, null);

        byte[] bytes = rtn.toByteArray();
        assertEquals(0, bytes.length);
    }

    /**
     * Avro requires start be set.
     * This test illustrates an apparent problem with avro 'builder'
     * it seems sometimes a default-ed field has to be set!
     * In this case, if we don't set the "start" field then we
     * catch an AvroRuntimeException.
     *
     * @throws Exception the exception
     */
    @Test//(expected = org.apache.avro.AvroRuntimeException.class)
    public void AvroRequiresStartBeSet() throws Exception {
        GASearchReadsRequest gsrr = GASearchReadsRequest.newBuilder()
                .build();
    }

    @Test
    public void AvroBuildsDefaultObject() throws Exception {
        GASearchReadsRequest gsrr = GASearchReadsRequest.newBuilder()
                .setStart(0L)
                .build();
        assertNotNull(gsrr);
    }

    /**
     * Method: avroToJson(DatumWriter dw, Schema schema, T srcBytes)
     * Note this test is specific to the Avro-using JSON serializer
     * so the "expected" JSON is in the Avro style, with JSON blocks
     * for non-null fields, like ... "start": { "long" : "0"}
     *
     * This is fine for an Avro deserializer, but doesn't work with
     * defaul Jackson deserializing, so we'll have a distinct test
     * for Jackson.
     */
    @Test
    public void AvroGeneratesJsonBytesForDefaultGA() throws Exception {
        //JsonMaker av = new JsonMaker();
        GASearchReadsRequest gsrr = GASearchReadsRequest.newBuilder()
                .setStart(0L)
                .build();
        assertNotNull("test data is default GaSearchReadsRequest", gsrr);
        Schema sampleSchema = GASearchReadsRequest.SCHEMA$;
        DatumWriter dw = new GenericDatumWriter<>(sampleSchema);

        String actual =
                JsonMaker.avroToJsonBytes(dw, sampleSchema, gsrr).toString();

        String expected = "{\n" +
                "  \"readGroupIds\" : [ ],\n" +
                "  \"referenceName\" : null,\n" +
                "  \"referenceId\" : null,\n" +
                "  \"start\" : {\n" +
                "    \"long\" : 0\n" +
                "  },\n" +
                "  \"end\" : null,\n" +
                "  \"pageSize\" : null,\n" +
                "  \"pageToken\" : null\n" +
                "}";
        boolean strictCompare = true;
        JSONAssert.assertEquals(expected, actual, strictCompare);
    }

    public void JacksonGeneratesJsonBytesForDefaultGA() throws Exception {
        //JsonMaker av = new JsonMaker();
        GASearchReadsRequest gsrr = GASearchReadsRequest.newBuilder()
                .setStart(0L)
                .build();
        assertNotNull("test data is default GaSearchReadsRequest", gsrr);
        Schema sampleSchema = GASearchReadsRequest.SCHEMA$;
        DatumWriter dw = new GenericDatumWriter<>(sampleSchema);

        String actual =
                JsonMaker.JacksonToJsonBytes(gsrr).toString();

        String expected = "{\n" +
                "  \"readGroupIds\" : [ ],\n" +
                "  \"referenceName\" : null,\n" +
                "  \"referenceId\" : null,\n" +
                "  \"start\" : 0,\n" +
                "  \"end\" : null,\n" +
                "  \"pageSize\" : null,\n" +
                "  \"pageToken\" : null\n" +
                "}";
        boolean strictCompare = true;
        JSONAssert.assertEquals(expected, actual, strictCompare);
    }
    /**
     * Avro notice mismatch obj schema.
     *
     * Feed mismatched Schema to avro, something should complain!
     * Probably different in different cases, but this shows one.
     *
     * @throws Exception the exception
     */
    @Test(expected = org.apache.avro.UnresolvedUnionException.class)
    public void AvroNoticeMismatchObjSchema() throws Exception {
        //JsonMaker av = new JsonMaker();
        GASearchReadsRequest gsrr = GASearchReadsRequest.newBuilder()
                .setStart(0L) // must set, even to default
                .build();
        Schema wrongSchema = GASearchAnalysesRequest.SCHEMA$;
        DatumWriter dw = new GenericDatumWriter<>(wrongSchema);

        // using the DatumWriter should trigger an exception
        String actual = JsonMaker.avroToJsonBytes(dw, wrongSchema, gsrr).toString();
    }

}
