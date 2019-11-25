package repository;

import entity.Coach;

import java.util.List;

public interface CoachRepository {
    void save(Coach coach);

    List<Coach> findAll();

    List<Coach> findCoachByAge(int age);

    Coach findById(int id);

    List<Coach> findByCost(int cost);
}
