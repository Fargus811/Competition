package entity;

public class Coach {
    private int id;
    private String firstName;
    private String lastName;
    private int age;
    private String country;
    private Sex sex;
    private int cost;
    private String rank;


    public Coach(String firstName, String lastName, int age, String country, Sex sex, int cost,String rank) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.cost=cost;
        this.country = country;
        this.sex = sex;
        this.rank=rank;
    }
}
