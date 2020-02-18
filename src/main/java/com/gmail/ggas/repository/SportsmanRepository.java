package com.gmail.ggas.repository;

import com.gmail.ggas.entity.Sex;
import com.gmail.ggas.entity.Sportsman;

import java.util.List;

public interface SportsmanRepository {

    void save(Sportsman sportsman);

    List<Sportsman> findAll();

    List<Sportsman> findSportsManByAge(int age);

    Sportsman findById(long id);

    Sportsman findByWeight(double weight);

    Sportsman findByManAndWeight(double weight, Sex sex);

    void deleteById(long id);

    Sportsman buildSportsman(String sportsman);

    void update(Sportsman sportsman);

    Sportsman findByLogin(String login);

}
