package it.dsibilio.rsocketdemo.domain;

public class TweetRequest {
    private String author;
    
    public TweetRequest() {}

    public TweetRequest(String author) {
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

}
