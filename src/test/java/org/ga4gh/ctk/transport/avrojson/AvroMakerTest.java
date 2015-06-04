package org.ga4gh.ctk.transport.avrojson;

import org.apache.avro.specific.SpecificDatumWriter;
import org.ga4gh.GASearchReadsRequest;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;

/** 
* AvroMaker Tester. 
* 
* @author <Authors name> 
* @since <pre>Jun 3, 2015</pre> 
* @version 1.0 
*/ 
public class AvroMakerTest {

    GASearchReadsRequest gsrr;
    ByteArrayOutputStream theJson;
@Before
public void before() throws Exception {
    gsrr = GASearchReadsRequest.newBuilder()
            .setStart(0L)
            .setPageSize(33)
            .setStart(4321L)
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
* 
* Method: makeAvroFromJson(String json, Class<? extends GenericContainer> tgt, String sourceForLog, DESER_MODE deserMode) 
* 
*/ 
@Test
public void testMakeAvroFromJson() throws Exception {
    GASearchReadsRequest actual =
            (GASearchReadsRequest) AvroMaker.jsonToAvroObject(theJson.toString(), GASearchReadsRequest.SCHEMA$);
    // do field-by-field compare here
    assert gsrr.equals(actual);
} 

/** 
* 
* Method: jsonToObjectRelaxed(String jsonString, Class objClass) 
* 
*/ 
@Test
public void testJsonToObjectRelaxed() throws Exception { 
    // make an example Avro object
    // start by generating the expected JSON

    // now we have JSON in "avro order" so we need to swap
    // a couple fields

} 

/** 
* 
* Method: jsonToObjectJacksonFactory(String jsonString, Class objClass, Schema schema) 
* 
*/ 
@Test
public void testJsonToObjectJacksonFactory() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: jsonToAvroObject(String theJson, Schema schema) 
* 
*/ 
@Test
public void testJsonToAvroObject() throws Exception { 
//TODO: Test goes here... 
} 


} 
