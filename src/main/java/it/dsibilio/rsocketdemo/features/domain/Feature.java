package it.dsibilio.rsocketdemo.features.domain;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import io.netty.util.internal.ThreadLocalRandom;

import java.time.LocalDate;
import java.util.UUID;

public class Feature {
    private String id;
    private String author;
    private String body;

    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    private LocalDate date;

    public Feature() {}

    public Feature(String author, String body) {
        this.id = UUID.randomUUID().toString();
        this.author = author;
        this.body = body;
        this.date = getRandomDate();
    }
    
    public static Feature of(Feature tweet) {
        return new Feature(tweet.getAuthor(), tweet.getBody());
    }

    private LocalDate getRandomDate() {
        ThreadLocalRandom r = ThreadLocalRandom.current();
        return LocalDate.of(r.nextInt(1990, 2020), r.nextInt(1, 13), r.nextInt(1, 29));
    }

    public String getId() {
        return id;
    }

    public String getAuthor() {
        return author;
    }

    public String getBody() {
        return body;
    }

    public LocalDate getDate() {
        return date;
    }

}
