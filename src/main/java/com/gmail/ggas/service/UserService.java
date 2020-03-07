package com.gmail.ggas.service;

import com.gmail.ggas.entity.Role;
import com.gmail.ggas.exception.UserLoginException;
import com.gmail.ggas.file.CoachFileReader;
import com.gmail.ggas.repository.impl.InMemoryCoachRepository;
import com.gmail.ggas.repository.impl.InMemorySportsmanRepository;

import java.util.ArrayList;
import java.util.List;

public class UserService {

    private static UserService instance;

    public static UserService getInstance() {
        if (instance == null) {
            instance = new UserService();
        }
        return instance;
    }

    public Role login(String login, String password) throws UserLoginException {
        if ("admin".equals(login) && "admin".equals(password)) {
            return Role.ADMIN;
        } else if ((InMemoryCoachRepository.getInstance().findByLogin(login) != null) &&
                password.equals(CoachFileReader.findPasswordByLogin(login, password))) {
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

