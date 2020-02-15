package repository;

import entity.Coach;
import exception.UserLoginException;

import java.util.List;

public interface CoachRepository {


    void save(Coach coach);

    List<Coach> findAll();

    List<Coach> findCoachByAge(int age);

    Coach findById(long id);

    List<Coach> findByCost(int cost);

    void deleteById(long id);

    Coach buildCoach(String coach);

    void update(Coach coach);

    String findByLogin(String login) throws UserLoginException;
}
