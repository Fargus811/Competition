package entity;

import java.util.Objects;

public class Sportsman extends User {
    private double weight;

    public Sportsman() {
    }

    public Sportsman(long id, String firstName, String lastName, Role role, String email, String password, int age,
                     String login, Sex sex, double weight) {
        super(id, firstName, lastName, role, email, password, age, login, sex);
        this.weight = weight;
    }

    @Override
    public long getId() {
        return super.getId();
    }

    @Override
    public void setId(long id) {
        super.setId(id);
    }

    @Override
    public String getFirstName() {
        return super.getFirstName();
    }

    @Override
    public void setFirstName(String firstName) {
        super.setFirstName(firstName);
    }

    @Override
    public String getLastName() {
        return super.getLastName();
    }

    @Override
    public void setLastName(String lastName) {
        super.setLastName(lastName);
    }

    @Override
    public Role getRole() {
        return super.getRole();
    }

    @Override
    public void setRole(Role role) {
        super.setRole(role);
    }

    @Override
    public String getEmail() {
        return super.getEmail();
    }

    @Override
    public void setEmail(String email) {
        super.setEmail(email);
    }

    @Override
    public String getPassword() {
        return super.getPassword();
    }

    @Override
    public void setPassword(String password) {
        super.setPassword(password);
    }

    @Override
    public int getAge() {
        return super.getAge();
    }

    @Override
    public void setAge(int age) {
        super.setAge(age);
    }

    @Override
    public String getLogin() {
        return super.getLogin();
    }

    @Override
    public void setLogin(String login) {
        super.setLogin(login);
    }

    @Override
    public Sex getSex() {
        return super.getSex();
    }

    @Override
    public void setSex(Sex sex) {
        super.setSex(sex);
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Sportsman)) return false;
        if (!super.equals(o)) return false;
        Sportsman sportsman = (Sportsman) o;
        return Double.compare(sportsman.weight, weight) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), weight);
    }


}
