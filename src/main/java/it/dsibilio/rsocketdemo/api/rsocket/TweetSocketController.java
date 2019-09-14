package it.dsibilio.rsocketdemo.api.rsocket;

import it.dsibilio.rsocketdemo.domain.Tweet;
import it.dsibilio.rsocketdemo.domain.TweetRequest;
import it.dsibilio.rsocketdemo.service.TweetService;
import reactor.core.publisher.Flux;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;

@Controller
public class TweetSocketController {

    private final TweetService service;

    public TweetSocketController(TweetService service) {
        this.service = service;
    }

    @MessageMapping("tweets.by.author")
    public Flux<Tweet> getByAuthor(TweetRequest request) {
        return service.getByAuthor(request.getAuthor());
    }

}
