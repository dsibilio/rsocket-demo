package it.dsibilio.rsocketdemo.features;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.geojson.Feature;
import org.geojson.FeatureCollection;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.util.ResourceUtils;
import reactor.core.publisher.Flux;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class FeatureService {

    static String json1;
    static String json2;
    static String json3;

    public FeatureService() {
    }

    public Flux<Feature> getFeatureSubscription() {

        json1 = getString("fc1.geojson");
        json2 = getString("fc2.geojson");
        json3 = getString("fc3.geojson");

        return Flux.just(json1)
                .map(jsonString -> {
                    FeatureCollection fc1 = null;
                    try {
                        fc1 = new ObjectMapper().readValue(jsonString, FeatureCollection.class);
                    } catch (JsonProcessingException e) {
                        e.printStackTrace();
                    }
                    return fc1;
                })
                .cast(FeatureCollection.class)
                .flatMapIterable(FeatureCollection::getFeatures);
    }

    private String getString(String fileName) {
        String featureCollection = "";
        try {
            Path path = ResourceUtils.getFile(this.getClass().getResource("/" + fileName)).toPath();
            try {
                Charset charset = StandardCharsets.UTF_8;
                try (BufferedReader reader = Files.newBufferedReader(path, charset)) {
                    String tempLine;
                    while ((tempLine = reader.readLine()) != null) {
                        featureCollection = "" + tempLine;
                    }
                } catch (IOException x) {
                    throw x;
                }
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception error) {
            error.printStackTrace();
            Assert.state(false, "Error reading test geojson file '" + fileName + "'  in test/resources: " + error.toString());
        }
        return featureCollection;
    }
}

