package com.nhuy.useretrofitcallapi.model;

public class Currency {
    private boolean success;
    private String terms;
    private String privacy;
    private float timestamp;
    private String source;
    private Quote quotes;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getTerms() {
        return terms;
    }

    public void setTerms(String terms) {
        this.terms = terms;
    }

    public String getPrivacy() {
        return privacy;
    }

    public void setPrivacy(String privacy) {
        this.privacy = privacy;
    }

    public float getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(float timestamp) {
        this.timestamp = timestamp;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public Quote getQuotes() {
        return quotes;
    }

    public void setQuotes(Quote quotes) {
        this.quotes = quotes;
    }
}
