package com.gmail.ggas.repository;

import com.gmail.ggas.entity.Coach;
import com.gmail.ggas.exception.UserLoginException;

import java.util.List;

public interface CoachRepository extends Repository<Coach> {

    List<Coach> findCoachByAge(int age);

    List<Coach> findByCost(int cost);

    Coach findByLogin(String login) throws UserLoginException;

}
