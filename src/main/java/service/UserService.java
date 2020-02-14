package service;

import entity.Role;
import exception.UserLoginException;
import file.CoachFileReader;
import repository.InMemoryCoachRepository;
import repository.InMemorySportsmanRepository;

import java.util.ArrayList;
import java.util.List;

public class UserService {

    private static UserService instance;

    private UserService() {

    }

    public static UserService getInstance() {
        if (instance == null) {
            instance = new UserService();
        }
        return instance;
    }

    public Role login(String login, String password) throws UserLoginException {
        if ("admin".equals(login) && "admin".equals(password)) {
            return Role.ADMIN;
        } else  if (login.equals(InMemoryCoachRepository.getInstance().findByLogin(login))&&
                password.equals(CoachFileReader.findPasswordByLogin(login,password))) {
            return Role.COACH;
        } else {
            throw new UserLoginException("Введён неправильно логин или пароль");
        }
    }

    public List<Object> showAll() {
        List<Object> users = new ArrayList<>();
        users.addAll(InMemoryCoachRepository.getInstance().findAll());
        users.addAll(InMemorySportsmanRepository.getInstance().findAll());
        return users;
    }
}

