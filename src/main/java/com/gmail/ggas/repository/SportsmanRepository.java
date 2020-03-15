package com.gmail.ggas.repository;

import com.gmail.ggas.entity.Sportsman;
import com.gmail.ggas.exception.UserLoginException;

import java.util.List;

public interface SportsmanRepository extends Repository<Sportsman> {


    List<Sportsman> findSportsManByAge(int age);

    List<Sportsman> findByWeight(double weight);

    Sportsman findByLogin(String login) throws UserLoginException;

}
