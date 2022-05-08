package com.example.urbanres.Reservation;

public class bookingModel {
    private int id;
    private String n_tickets;
    private String box_tickets;
    private String date;
    private String time;
    private String amount;
    private String movieName;

    public bookingModel(int id, String n_tickets, String box_tickets, String date, String time, String amount, String movieName) {
        this.id = id;
        this.n_tickets = n_tickets;
        this.box_tickets = box_tickets;
        this.date = date;
        this.time = time;
        this.amount = amount;
        this.movieName = movieName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getN_tickets() {
        return n_tickets;
    }

    public void setN_tickets(String n_tickets) {
        this.n_tickets = n_tickets;
    }

    public String getBox_tickets() {
        return box_tickets;
    }

    public void setBox_tickets(String box_tickets) {
        this.box_tickets = box_tickets;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getAmount() {
        return amount;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
}
