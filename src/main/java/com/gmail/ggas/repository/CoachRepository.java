package com.gmail.ggas.repository;

import com.gmail.ggas.entity.Coach;

import java.util.List;

public interface CoachRepository extends Repository<Coach> {

    List<Coach> findCoachByAge(int age);

    List<Coach> findByCost(int cost);

}
