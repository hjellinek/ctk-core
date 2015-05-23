package org.ga4gh.transport;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.apache.avro.Schema;
import org.apache.avro.io.DatumWriter;
import org.apache.avro.io.EncoderFactory;
import org.apache.avro.io.JsonEncoder;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * Created by Wayne Stidolph on 5/22/2015.
 */
public class AvroJson {
    private org.slf4j.Logger log = getLogger(AvroJson.class);
    String urlRoot = "localhost";

    public String getUrlRoot() {
        return urlRoot;
    }

    public void setUrlRoot(String urlRoot) {
        this.urlRoot = urlRoot;
    }

    public AvroJson(){}
    public AvroJson(String urlRoot){
        this.urlRoot = urlRoot;
    }

    public <T> ByteArrayOutputStream avroToJson(DatumWriter<T> dw, Schema schema, T request) {

        Boolean pretty = true;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        try {
            JsonEncoder encoder = EncoderFactory.get().jsonEncoder(schema, out, pretty);
            dw.setSchema(schema);
            dw.write(request, encoder);
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

    public <T> Object jsonToObject(String jsonResp) {
        return new Object();
    }

}
