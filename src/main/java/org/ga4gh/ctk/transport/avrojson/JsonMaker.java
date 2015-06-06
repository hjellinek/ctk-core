package org.ga4gh.ctk.transport.avrojson;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.avro.Schema;
import org.apache.avro.io.DatumWriter;
import org.apache.avro.io.EncoderFactory;
import org.apache.avro.io.JsonEncoder;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * Created by Wayne Stidolph on 6/1/2015.
 * @param <T>  the type parameter
 */
public class JsonMaker<T> {

    private static org.slf4j.Logger log = getLogger(JsonMaker.class);

    /**
     * Avro to json bytes.
     *
     * Use Avro to generate JSON; produces field values that are
     * {"<type>":"<value>"} which the Jackson deserializer doesn't
     * handle by default.
     *
     * @param dw the dw
     * @param schema the schema
     * @param srcBytes the src bytes
     * @return the byte array output stream
     */
    public static ByteArrayOutputStream avroToJsonBytes(DatumWriter dw, Schema schema, Object srcBytes) {

        Boolean pretty = true;
        ByteArrayOutputStream jsonBytes = new ByteArrayOutputStream();
        if (srcBytes == null){
            log.warn("null srcBytes param" );
            return jsonBytes;
        }

        try {
            // use jsonEncoder to writer to 'out' byte stream
            JsonEncoder encoder = EncoderFactory.get().jsonEncoder(schema, jsonBytes, pretty);

            dw.setSchema(schema);
            dw.write(srcBytes, encoder); // actual write
            encoder.flush();
            jsonBytes.close();
        } catch (IOException e) {
            log.warn("problem creating JSON from avro for schema " + schema, e);
        }
        if (log.isDebugEnabled()) {
            log.debug("avroToJson generates: " + jsonBytes.toString());
        }
        return jsonBytes;
    }

    /**
     * Jackson to json bytes.
     *
     * Use Jacskon to create simplified JSON, won't work with
     * Avro deserializing, but is like the Ref Server currenty generates.
     *
     * @param src the src
     * @return the byte array output stream
     */
    public static ByteArrayOutputStream JacksonToJsonBytes(Object src) {
        ObjectMapper mapper = new ObjectMapper();
        ByteArrayOutputStream jsonBytes =new ByteArrayOutputStream();
        try {
            mapper.writeValue(jsonBytes, src);
        } catch (IOException e) {
            log.warn("Jackson can't make output " + src.getClass().getName(), e);
        }
        return jsonBytes;
    }
}
