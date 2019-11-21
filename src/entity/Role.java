package entity;

public enum Role {
    ADMIN,
    COACH,
    SPORTSMEN;

    public void sayHello() {
        System.out.println("Hello from" + this);
    }

    public static void main(String[] args) {
        Role role = null;
        role = Role.COACH;

        role.sayHello();
    }
}
