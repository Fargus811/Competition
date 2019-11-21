package service;

public class UserService {

    public boolean login(String login, String password) {
        return  "admin".equals(login) && "admin".equals(password);
    }
}
