package com.jtonna.rsocketproject.models;

import java.time.Instant;

public class RSocketMessage
{
    private String origin;
    private long index;
    private String interaction;
    private long created = Instant.now().getEpochSecond();

    public RSocketMessage() {
    }

    public RSocketMessage(String origin, String interaction, long index) {
        this.origin = origin;
        this.interaction = interaction;
        this.index = index;
    }

    public RSocketMessage(String origin, String interaction) {
        this.origin = origin;
        this.interaction = interaction;
        this.index = 0;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getInteraction() {
        return interaction;
    }

    public void setInteraction(String interaction) {
        this.interaction = interaction;
    }

    public long getCreated() {
        return created;
    }

    public void setCreated(long created) {
        this.created = created;
    }

    @Override
    public String toString() {
        return "RSocketMessage{" +
                "origin='" + origin + '\'' +
                ", interaction='" + interaction + '\'' +
                ", created=" + created +
                '}';
    }
}
