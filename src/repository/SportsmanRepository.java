package repository;

import entity.Sportsman;

import java.util.List;

public interface SportsmanRepository {
    void save(Sportsman sportsman);

    List<Sportsman> findAll();

    List<Sportsman> findSportsManByAge(int age);

    Sportsman findById(int id);

    List<Sportsman> findByWeight(int weight);

    List<Sportsman> findByManandWeight( int weight);

}
