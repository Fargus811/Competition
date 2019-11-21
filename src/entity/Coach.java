package entity;

import java.util.Objects;

public class Coach {
    private int id;
    private String firstName;
    private String lastName;
    private int age;
    private String country;
    private Sex sex;
    private int cost;
    private String rank;

    public Coach() {
    }

    public Coach(String firstName, String lastName, int age, String country, Sex sex, int cost, String rank) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.cost=cost;
        this.country = country;
        this.sex = sex;
        this.rank=rank;
    }
    public int getId() {
        return id;
    }
    public int getCost() {
        return cost;
    }
    public void setCost(){
        this.cost = cost;

    }

    public void setId(int id) {
        this.id = id;
    }


    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public String getFirstname() {
        return firstName;
    }

    public void setFirstname(String firstname) {
        this.firstName = firstname;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "entity.Coach{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", country='" + country + '\'' +
                ", sex=" + sex +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coach coach = (Coach) o;
        return id == coach.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}


