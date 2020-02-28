package com.gmail.ggas.repository;

import com.gmail.ggas.entity.Sportsman;
import com.gmail.ggas.entity.User;

import java.util.List;

public interface SportsmanRepository {

    void save(Sportsman sportsman);

    List<User> findAll();

    List<Sportsman> findSportsManByAge(int age);

    Sportsman findById(long id);

    Sportsman findByWeight(double weight);

    void deleteById(long id);

    void update(Sportsman sportsman);

    Sportsman findByLogin(String login);

}
