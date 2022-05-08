package com.example.urbanres.Reviews;

public class Reviews {

    private String id;
    private String review, date;
    private float scount;

    public Reviews(String id, String review, String date, String scount) {
        this.id = id;
        this.review = review;
        this.date = date;
        this.scount = Float.parseFloat(scount);
    }

    public Reviews() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public float getScount() {
        return scount;
    }

    public void setScount(float scount) {
        this.scount = scount;
    }
}
