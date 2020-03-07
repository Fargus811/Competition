package com.gmail.ggas.repository;

import com.gmail.ggas.entity.Sportsman;

import java.util.List;

public interface SportsmanRepository extends Repository<Sportsman> {


    List<Sportsman> findSportsManByAge(int age);

    Sportsman findByWeight(double weight);


}
