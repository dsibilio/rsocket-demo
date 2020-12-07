package it.dsibilio.rsocketdemo.config;

import redis.embedded.RedisServer;

import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Configuration
@Profile("!prod")
public class RedisServerConfiguration {

    private final RedisServer redisServer;

    public RedisServerConfiguration(RedisProperties redisProperties) {
        this.redisServer = new RedisServer(redisProperties.getPort());
    }

    @PostConstruct
    public void init() {
        redisServer.start();
    }

    @PreDestroy
    public void destroy() {
        redisServer.stop();
    }

}
