package org.ga4gh.ctk.transport.avrojson;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.dataformat.avro.AvroFactory;
import com.fasterxml.jackson.dataformat.avro.AvroSchema;
import org.apache.avro.AvroTypeException;
import org.apache.avro.Schema;
import org.apache.avro.io.DatumReader;
import org.apache.avro.io.Decoder;
import org.apache.avro.io.DecoderFactory;
import org.apache.avro.specific.SpecificDatumReader;
import org.apache.avro.specific.SpecificRecordBase;

import java.io.IOException;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * Deserialize GA4GH JSON to JVM object defined by Avro IDL
 * Created by Wayne Stidolph on 6/3/2015.
 */
public class AvroMaker<T extends SpecificRecordBase> {

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

    private Class avroClass; // class for the avroObj examplar
    private T avroObj; // dummy object, so reflection can get properties
    // private Schema schema; // extracted by reflection in getSchema() below

    public AvroMaker(T examplar) {
        avroObj = examplar;
        avroClass = avroObj.getClass();
        //schema = avroObj.getSchema();
    }

    /**
     * Make avro from json.
     *
     * @param json         the json
     * @param sourceForLog the source of the json, for log message
     * @param deserMode    the deserialization mode
     * @return the generic container
     */
    public T makeAvroFromJson(String json, String sourceForLog, DESER_MODE deserMode) {

        T response = null;

        switch (deserMode) { // TODO use polymorphic on jsonToObject instead of switch? Or is this clearer?
            case JACKSON_RELAXED:
                response = jsonToObjectRelaxed(json);
                break;
            case JACKSON_AVRO:
                try {
                    response = jsonToObjectJacksonFactory(json);
                } catch (JsonMappingException jme) {
                    response = null;
                    log.warn("deserializing via " + deserMode + " returns null instead of a " + avroClass.getName()
                            + " from: " + json, jme);
                }
                break;
            case AVRO_DIRECT:
                try {
                    response = jsonToAvroObject(json);
                } catch (AvroTypeException ate) {
                    response = null;
                    log.warn("deserializing via " + deserMode + " returns null instead of a " + avroClass.getName()
                            + " from: " + json, ate);
                }
                break;
        }

        if (response == null) {
            log.info("makeAvroFromResponse returns null instead of requested " + avroClass.getName()
                            + " from " + sourceForLog + " for json < " + json + " >"
            );
        }
        return response;
    }

    private T jsonToObjectRelaxed(String jsonString) {
        T target = null;

        try {
            ObjectMapper mapper = new ObjectMapper()
                    .configure(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES, false);
            target = (T) mapper.readValue(jsonString, avroClass);

        } catch (IOException e) {
            log.warn("Jackson basic failed to make new " + avroClass.getName() + " from: " + jsonString, e);
        }
        return target;
    }

    private T jsonToObjectJacksonFactory(String jsonString) throws JsonMappingException {
        AvroSchema avSchema = new AvroSchema(getSchema());
        ObjectMapper om = new ObjectMapper(new AvroFactory());

        T obj = null;

        try {
            ObjectReader reader = om.reader(avroClass).with(avSchema);
            obj = reader.readValue(jsonString.getBytes());
        } catch (IOException e) {
            log.warn("Jackson with AvroFactory failed to make new "
                    + avroClass.getName() + " from: " + jsonString, e);
        }
        return obj;
    }

    private T jsonToAvroObject(String theJson) {
        // byte[] avroByteArray = fromJsonToBytes(theJson, schema);
        if (theJson == null || theJson.isEmpty()) {
            log.warn("jsonToAvroObject got empty JSON string");
            return null;
        }
        Schema schema = getSchema();
        if (schema == null) {
            log.warn("jsonToAvroObject got null schema object");
            return null;
        }

        DatumReader<T> reader1 = new SpecificDatumReader<>(schema);
        T result = null;
        try {
            Decoder decoder1 = DecoderFactory.get().jsonDecoder(schema, theJson);
            result = reader1.read(null, decoder1);
        } catch (IOException e) {
            log.warn("Avro reader failed to get bytes for Schema " + schema.getName(), e);
        }
        return result;
    }


    private Schema getSchema() {
        return avroObj.getSchema();
    }

}
