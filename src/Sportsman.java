import java.util.Objects;

public class Sportsman {
    private String firstName;
    private String lastName;
    private int age;
    private double weight;
    private String club;
    private String rank;
    private String country;
    private Sex sex;

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

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getClub() {
        return club;
    }

    public void setClub(String club) {
        this.club = club;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }


    @Override
    public String toString() {
        return "Sportsman{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", weight=" + weight +
                ", club='" + club + '\'' +
                ", rank='" + rank + '\'' +
                ", country='" + country + '\'' +
                ", sex=" + sex +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sportsman sportsman = (Sportsman) o;
        return age == sportsman.age &&
                Double.compare(sportsman.weight, weight) == 0 &&
                Objects.equals(firstName, sportsman.firstName) &&
                Objects.equals(lastName, sportsman.lastName) &&
                Objects.equals(club, sportsman.club) &&
                Objects.equals(rank, sportsman.rank) &&
                Objects.equals(country, sportsman.country) &&
                sex == sportsman.sex;
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, age, weight, club, rank, country, sex);
    }

}
