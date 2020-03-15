package com.gmail.ggas.entity;

import java.util.Objects;

public abstract class User implements Entity {
    private long id;
    private String firstName;
    private String lastName;
    private Role role;
    private String email;
    private String password;
    private int age;
    private String login;
    private Sex sex;

    public User() {
    }

    public User(long id, String firstName, String lastName, Role role, String email, String password, int age, String login, Sex sex) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.role = role;
        this.email = email;
        this.password = password;
        this.age = age;
        this.login = login;
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "User" +
                "@" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", role='" + role + '\''+
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", age='" + age + '\'' +
                ", login='" + login + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id &&
                age == user.age &&
                firstName.equals(user.firstName) &&
                lastName.equals(user.lastName) &&
                role == user.role &&
                email.equals(user.email) &&
                login.equals(user.login) &&
                sex == user.sex;
    }


    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, role, email, age, login, sex);
    }

    public abstract double getWorkExperience();
}
