package org.ga4gh.ctk.transport.avrojson;

import org.apache.avro.Schema;
import org.apache.avro.io.DatumWriter;
import org.apache.avro.io.EncoderFactory;
import org.apache.avro.io.JsonEncoder;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * Created by Wayne Stidolph on 6/1/2015.
 */
public class JsonMaker<T> {

    private static org.slf4j.Logger log = getLogger(JsonMaker.class);

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
}
