package entity;

public class User {
    private long id;
    private String name;
    private Role role;

    public User(long id, String name, Role role) {
        this.id = id;
        this.name = name;
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", role=" + role +
                '}';
    }
}
