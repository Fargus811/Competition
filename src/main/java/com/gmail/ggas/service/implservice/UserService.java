package com.gmail.ggas.service.implservice;

import com.gmail.ggas.entity.Role;
import com.gmail.ggas.entity.User;
import com.gmail.ggas.exception.UserLoginException;
import com.gmail.ggas.repository.CoachRepository;
import com.gmail.ggas.repository.SportsmanRepository;
import com.gmail.ggas.repository.impl.InMemoryCoachRepository;
import com.gmail.ggas.repository.impl.InMemorySportsmanRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UserService {

    private static UserService instance;

    private CoachRepository coachRepository = InMemoryCoachRepository.getInstance();

    private SportsmanRepository sportsmanRepository = InMemorySportsmanRepository.getInstance();

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
                password.equals(InMemoryCoachRepository.getInstance().findPasswordByLogin(login))) {
            return Role.COACH;
        } else {
            throw new UserLoginException("Введён неправильно логин или пароль");
        }
    }

    public List<User> showAll() {
        List<User> users = new ArrayList<>();
        users.addAll(coachRepository.findAll());
        users.addAll(sportsmanRepository.findAll());
        return users;
    }

    public List<User> findAll(int page, int pageSize) {
        List<User> users = showAll();
        int offset = (page - 1) * pageSize;
        if (offset >= users.size()) {
            return Collections.emptyList();
        }
        int lastIndex = offset + pageSize;
        lastIndex = (lastIndex >= users.size()) ? users.size() - 1 : lastIndex;
        return users.subList(offset, lastIndex);
    }

}

