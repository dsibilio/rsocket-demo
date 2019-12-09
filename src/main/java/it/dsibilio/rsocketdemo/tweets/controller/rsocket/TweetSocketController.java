package it.dsibilio.rsocketdemo.tweets.controller.rsocket;

import it.dsibilio.rsocketdemo.tweets.domain.Tweet;
import it.dsibilio.rsocketdemo.tweets.domain.TweetRequest;
import it.dsibilio.rsocketdemo.tweets.service.TweetService;
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
