package it.dsibilio.rsocketdemo.repository;

import it.dsibilio.rsocketdemo.domain.Tweet;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import org.springframework.data.domain.Range;
import org.springframework.data.redis.core.ReactiveRedisOperations;
import org.springframework.stereotype.Repository;

@Repository
public class TweetRepository {

    private final ReactiveRedisOperations<String, Tweet> redisTemplate;

    public TweetRepository(ReactiveRedisOperations<String, Tweet> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public Mono<Void> save(Tweet tweet) {
        return Mono.when(
                redisTemplate.<String, Tweet>opsForHash().put("tweets", tweet.getId(), tweet),
                redisTemplate.opsForZSet().add(tweet.getAuthor().toLowerCase().replaceAll("\\s", ""), tweet, tweet.getDate().toEpochDay())
                ).then();
    }

    public Flux<Tweet> getByAuthor(String author) {
        return redisTemplate.opsForZSet().reverseRange(author, Range.unbounded());
    }

}
