package entity;

public enum Role {
    ADMIN,
    COACH,
    SPORTSMEN;

    public void sayHello() {
        System.out.println("Hello from" + this);
    }

}
