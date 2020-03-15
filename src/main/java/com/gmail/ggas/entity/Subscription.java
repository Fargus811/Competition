package com.gmail.ggas.entity;


public class Subscription implements Entity {
    long id;
    long sportsmanId;
    int numberOfClasses;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getSportsmanId() {
        return sportsmanId;
    }

    public void setSportsmanId(long sportsmanId) {
        this.sportsmanId = sportsmanId;
    }

    public int getNumberOfClasses() {
        return numberOfClasses;
    }

    public void setNumberOfClasses(int numberOfClasses) {
        this.numberOfClasses = numberOfClasses;
    }
}
