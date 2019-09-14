package it.dsibilio.rsocketdemo.api.rest;

import it.dsibilio.rsocketdemo.domain.Tweet;
import it.dsibilio.rsocketdemo.service.TweetService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import org.springframework.http.MediaType;
import org.springframework.messaging.rsocket.RSocketRequester;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TweetController {

    private final TweetService service;
    private final Mono<RSocketRequester> requester;

    public TweetController(TweetService service, Mono<RSocketRequester> requester) {
        this.service = service;
        this.requester = requester;
    }

    @GetMapping(value = "/tweets/{author}", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Tweet> getByAuthor(@PathVariable String author) {
        return service.getByAuthor(author);
    }

    @GetMapping(value = "/socket/{author}", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Tweet> getByAuthorViaSocket(@PathVariable String author) {
        return requester.flatMapMany(r -> r.route("tweets.by.author").data(author).retrieveFlux(Tweet.class));
    }

}
