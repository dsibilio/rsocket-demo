package com.jtonna.rsocketproject.models;

import java.time.Instant;

public class RSocketMessage
{
    private String message;
    private long created = Instant.now().getEpochSecond();

    public RSocketMessage(String message)
    {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
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
                "message='" + message + '\'' +
                ", created=" + created +
                '}';
    }
}
