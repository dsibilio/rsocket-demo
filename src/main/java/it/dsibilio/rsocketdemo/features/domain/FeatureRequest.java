package it.dsibilio.rsocketdemo.features.domain;

public class FeatureRequest {
    private String author;
    
    public FeatureRequest() {}

    public FeatureRequest(String author) {
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

}
