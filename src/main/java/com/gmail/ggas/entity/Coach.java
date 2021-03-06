package com.gmail.ggas.entity;

import java.util.Objects;

public class Coach extends User {
    private int cost;
    private String rank;
    private double workExperience;

    public double getWorkExperience() {
        return workExperience;
    }

    public void setWorkExperience(double workExperience) {
        this.workExperience = workExperience;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String parseToDbString() {
        return super.getId() + ";" + super.getFirstName() + ";" + super.getLastName() + ";" + super.getAge() + ";"
                + super.getSex() + ";" + super.getLogin() + ";" + super.getPassword() + ";" + super.getEmail() + ";"
                + cost + ";" + rank + ";" + workExperience + "\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Coach)) return false;
        if (!super.equals(o)) return false;
        Coach coach = (Coach) o;
        return cost == coach.cost &&
                Objects.equals(rank, coach.rank);
    }

    @Override
    public String toString() {
        return "User" +
                "@" + getId() +
                ", Coach:firstName='" + getFirstName() + '\'' +
                ", lastName='" + getLastName() + '\'' +
                ", role='" + getRole() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", password='" + getPassword() + '\'' +
                ", age='" + getAge() + '\'' +
                ", login='" + getLogin() + '\'' +
                ", sex='" + getSex() + '\'' +
                ", cost='" + cost + '\'' +
                ", rank='" + rank + '\'' +
                ", workExperience='" + workExperience + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), cost, rank);
    }
}



