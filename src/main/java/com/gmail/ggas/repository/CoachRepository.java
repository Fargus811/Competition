package com.gmail.ggas.repository;

import com.gmail.ggas.entity.Coach;
import com.gmail.ggas.entity.User;
import com.gmail.ggas.exception.UserLoginException;

import java.util.List;

public interface CoachRepository {


    void save(Coach coach);

    List<User> findAll();

    List<Coach> findCoachByAge(int age);

    Coach findById(long id);

    List<Coach> findByCost(int cost);

    void deleteById(long id);

    void update(Coach coach);

    String findByLogin(String login) throws UserLoginException;
}
