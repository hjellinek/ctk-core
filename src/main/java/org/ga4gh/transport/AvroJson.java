package org.ga4gh.transport;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.apache.avro.Schema;
import org.apache.avro.generic.GenericDatumReader;
import org.apache.avro.generic.GenericDatumWriter;
import org.apache.avro.generic.GenericRecord;
import org.apache.avro.io.*;

import java.io.*;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * Created by Wayne Stidolph on 5/22/2015.
 */
public class AvroJson {
    private org.slf4j.Logger log = getLogger(AvroJson.class);
    String urlRoot = "localhost";

    public AvroJson() {
    }

    public AvroJson(String urlRoot) {
        this.urlRoot = urlRoot;
    }

    public String getUrlRoot() {
        return urlRoot;
    }

    public void setUrlRoot(String urlRoot) {
        this.urlRoot = urlRoot;
    }


    public <T> ByteArrayOutputStream avroToJson(DatumWriter<T> dw, Schema schema, T srcBytes) {

        Boolean pretty = true;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        try {
            // use jsonEncoder to writer to 'out' byte stream
            JsonEncoder encoder = EncoderFactory.get().jsonEncoder(schema, out, pretty);

            dw.setSchema(schema);
            dw.write(srcBytes, encoder); // actual write
            encoder.flush();
            out.close();
        } catch (IOException e) {
            log.warn("problem creating JSON from avro for schema " + schema, e);
        }
        if (log.isDebugEnabled()) {
            log.debug(out.toString());
        }
        return out;
    }

    public HttpResponse<JsonNode> jsonPost(ByteArrayOutputStream theJson, String theSpecURL) {
        HttpResponse<JsonNode> jsonResponse = null;
        try {
            jsonResponse = Unirest.post(urlRoot + theSpecURL)
                    .header("Content-Type", "application/json")
                    .header("accept", "application/json")
                    .body(theJson.toString())
                    .asJson();
        } catch (UnirestException e) {
            log.warn("problem communicating JSON with " + urlRoot + theSpecURL, e);
        }
        return jsonResponse;
    }

    public <T> T jsonToAvroObject(String theJson, Schema schema){
        byte[] avroByteArray = fromJsonToBytes(theJson, schema);
        DatumReader<GenericRecord> reader1 = new GenericDatumReader<GenericRecord>(schema);
        Decoder decoder1 = DecoderFactory.get().binaryDecoder(avroByteArray, null);
        try {
            GenericRecord result = reader1.read(null, decoder1);
            return (T) result;
        } catch (IOException e) {
            log.warn("Failed making GenericRecord result",e);
        }
        return null;
    }

    public byte[] fromJsonToBytes(String theJson, Schema schema){
        ByteArrayOutputStream outputStream = null;

        InputStream input = new ByteArrayInputStream(theJson.getBytes());
        DataInputStream din = new DataInputStream(input);
        Decoder decoder = null;
        try {
            decoder = DecoderFactory.get().jsonDecoder(schema, din);
            DatumReader<Object> reader = new GenericDatumReader<Object>(schema);
            Object datum = reader.read(null, decoder);
            GenericDatumWriter<Object> w = new GenericDatumWriter<Object>(schema);
            outputStream = new ByteArrayOutputStream();

            Encoder e = EncoderFactory.get().binaryEncoder(outputStream, null);

            w.write(datum, e);
            e.flush();

        } catch (IOException e) {
            log.warn("IOException getting bytes", e);
        }
        catch (org.apache.avro.AvroTypeException te){
            log.warn("Failed fromJsonToBytes for " + schema.getName() + " on "+theJson, te);
        }
        byte[] outbytes = new byte[] {};
        if(outputStream != null){
            outbytes = outputStream.toByteArray();
        }
        return outbytes;
    }

}
