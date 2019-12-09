package it.dsibilio.rsocketdemo.features;


import org.geojson.Feature;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Flux;
import java.time.Duration;

@Controller
public class FeatureController {

    private final FeatureService service;

    public FeatureController(FeatureService service) {
        this.service = service;
    }

    @MessageMapping("traveltime-message")
    public Flux<Feature> getRoadSubscription() {
        return service.getFeatureSubscription().delayElements(Duration.ofMillis(500));
    }

}
