package org.ga4gh.ctk.transport.avrojson;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.dataformat.avro.AvroFactory;
import com.fasterxml.jackson.dataformat.avro.AvroSchema;
import org.apache.avro.AvroTypeException;
import org.apache.avro.Schema;
import org.apache.avro.generic.GenericContainer;
import org.apache.avro.generic.GenericDatumReader;
import org.apache.avro.generic.GenericRecord;
import org.apache.avro.io.DatumReader;
import org.apache.avro.io.Decoder;
import org.apache.avro.io.DecoderFactory;

import java.io.IOException;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * Deserialize GA4GH JSON to JVM object defined by Avro IDL
 * Created by Wayne Stidolph on 6/3/2015.
 */
public class AvroMaker {

    private static org.slf4j.Logger log = getLogger(AvroMaker.class);

    /**
     * The enum DESER _ MODE.
     */
    public enum DESER_MODE {
        /**
         * Use Jackson to pull JSON into field,
         * without worry about order matching. But, if the
         * JSON is missing a field, it won't be initialized
         * in the Avro object!
         */
        JACKSON_RELAXED,
        /**
         * Use Jackson as teh deserializing library, with the
         * AvroFactory addon to the ObjectMapper for type/order
         * checking.
         */
        JACKSON_AVRO,
        /**
         * Use Avro Java libs to deserialize; is order-sensitive,
         * probably the most definitely safe (but hardest to read
         * and code).
         */
        AVRO_DIRECT
    }

    /**
     * Make avro from json.
     *
     * @param json the json
     * @param tgt the target Avro type class, extends GenericContainer
     * @param sourceForLog the source of the json, for log message
     * @param deserMode the deserialization mode
     * @return the generic container
     */
    public static GenericContainer makeAvroFromJson(String json, Class<? extends GenericContainer> tgt, String sourceForLog, DESER_MODE deserMode) {

        if(tgt == null){
            log.warn("makeAvroFromJson got null target class type");
            return null;
        }
        GenericContainer response = null;
        try {
            response = tgt.newInstance();
        } catch (InstantiationException e) {
            log.warn("Couldn't make Avro object " + tgt.getName(), tgt);
            return null;
        } catch (IllegalAccessException e) {
           log.warn("Couldn't make Avro object " + tgt.getName(), tgt);
            return null;
        }
        String theRespSchema = response.getSchema().toString(true);
        log.trace("AVRO EXPECTED-RESPONSE SCHEMA: " + theRespSchema);

        switch (deserMode) { // TODO use polymorphic on jsonToObject instead of switch? Or is this clearer?
            case JACKSON_AVRO:
                try {
                    response = (GenericContainer) jsonToObjectJacksonFactory(json, tgt, response.getSchema());
                } catch (JsonMappingException jme) {
                    response = null;
                    log.warn("deserializing via " + deserMode + " returns null instead of a " + tgt.getName()
                            + " from: " + json, jme);
                }
                break;
            case AVRO_DIRECT:
                try {
                    response = jsonToAvroObject(json, response.getSchema());
                } catch (AvroTypeException ate) {
                    response = null;
                    log.warn("deserializing via " + deserMode + " returns null instead of a " + tgt.getName()
                            + " from: " + json, ate);
                }
                break;
            case JACKSON_RELAXED:
                response = (GenericContainer) jsonToObjectRelaxed(json, tgt);
                break;
        }

        if(response == null){
            log.info("makeAvroFromResponse returns null instead of requested " + tgt.getClass().getName()
                            + " from " + sourceForLog + " for json < " +json + " >"
            );
        }
        return response;
    }

    static Object jsonToObjectRelaxed(String jsonString, Class objClass) {
        Object target = null;

        try {
            ObjectMapper mapper = new ObjectMapper()
                    .configure(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES, false);
            target = mapper.readValue(jsonString, objClass);

        } catch (IOException e) {
            log.warn("Failed to make new " + objClass.getName() + " from: " + jsonString, e);
        }
        return target;
    }

    public static Object jsonToObjectJacksonFactory(String jsonString, Class objClass, Schema schema) throws JsonMappingException {

        AvroSchema avSchema = new AvroSchema(schema);
        ObjectMapper om = new ObjectMapper(new AvroFactory());

        Object obj = null;

        try {
            ObjectReader reader = om.reader(objClass).with(avSchema);
            obj = reader.readValue(jsonString.getBytes());
        } catch (IOException e) {
            log.warn("Jackson with AvroFactory failed to make new " + objClass.getName() + " from: " + jsonString, e);
        }
        return obj;
    }

    public static GenericRecord jsonToAvroObject(String theJson, Schema schema) {
       // byte[] avroByteArray = fromJsonToBytes(theJson, schema);
        if (theJson == null || theJson.isEmpty()) {
            log.warn("jsonToAvroObject got empty JSON string");
            return null;
        }

        if (schema == null) {
            log.warn("jsonToAvroObject got null schema object");
            return null;
        }

        DatumReader<GenericRecord> reader1 = new GenericDatumReader<GenericRecord>(schema);
        GenericRecord result = null;
        try {
            Decoder decoder1 = DecoderFactory.get().jsonDecoder(schema, theJson);
            result = reader1.read(null, decoder1);
        } catch (IOException e) {
            log.warn("Avro reader failed to get bytes for Schema " + schema.getName(), e);
        }
        return result;
    }



}
