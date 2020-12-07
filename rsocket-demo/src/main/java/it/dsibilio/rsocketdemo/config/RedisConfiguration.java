package it.dsibilio.rsocketdemo.config;

import it.dsibilio.rsocketdemo.domain.Tweet;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.ReactiveRedisConnectionFactory;
import org.springframework.data.redis.core.ReactiveRedisOperations;
import org.springframework.data.redis.core.ReactiveRedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class RedisConfiguration {

    @Bean
    public ReactiveRedisOperations<String, Tweet> redisOperations(ReactiveRedisConnectionFactory factory) {
        Jackson2JsonRedisSerializer<Tweet> serializer = new Jackson2JsonRedisSerializer<>(Tweet.class);

        RedisSerializationContext.RedisSerializationContextBuilder<String, Tweet> builder =
                RedisSerializationContext.newSerializationContext(new StringRedisSerializer());

        RedisSerializationContext<String, Tweet> context = 
                builder.value(serializer).hashKey(new StringRedisSerializer()).hashValue(serializer).build();

        return new ReactiveRedisTemplate<>(factory, context);
    }

}
