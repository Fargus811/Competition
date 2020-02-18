package com.gmail.ggas.service;

import com.gmail.ggas.entity.Role;
import com.gmail.ggas.entity.Sex;
import com.gmail.ggas.entity.Sportsman;
import com.gmail.ggas.exception.SportsmanServiceException;
import com.gmail.ggas.repository.InMemorySportsmanRepository;
import com.gmail.ggas.repository.SportsmanRepository;

import java.util.List;

public class SportsmanService {

    private static SportsmanService instance;

    private SportsmanRepository sportsmanRepository = InMemorySportsmanRepository.getInstance();

    public static SportsmanService getInstance() {
        if (instance == null) {
            instance = new SportsmanService();
        }
        return instance;
    }

    public void createSportsman(List<String> params) throws SportsmanServiceException {
        try {
            int age = Integer.parseInt(params.get(2));
            double weight = Double.valueOf(params.get(3));
            Sex sex = Sex.valueOf(params.get(6));
            Sportsman sportsman = new Sportsman();
            sportsman.setFirstName(params.get(0));
            sportsman.setLastName(params.get(1));
            sportsman.setLogin(params.get(4));
            sportsman.setPassword(params.get(5));
            sportsman.setEmail(params.get(7));
            sportsman.setAge(age);
            sportsman.setSex(sex);
            sportsman.setWeight(weight);
            sportsman.setRole(Role.SPORTSMEN);
            sportsmanRepository.save(sportsman);
        } catch (Exception e) {
            throw new SportsmanServiceException(e);
        }
    }

    public void deleteById(long id) {
        Sportsman sportsman = sportsmanRepository.findById(id);
        if (sportsman == null) {
            System.out.println("Пользователь с таким id:" + id + " не найден");
        } else {
            sportsmanRepository.deleteById(id);
        }

    }

    public void update(List<String> params) throws SportsmanServiceException {
        try {
            int age = Integer.parseInt(params.get(3));
            double weight = Double.valueOf(params.get(4));
            Sex sex = Sex.valueOf(params.get(7));
            Sportsman sportsman = new Sportsman();
            sportsman.setId(Long.parseLong(params.get(0)));
            sportsman.setFirstName(params.get(1));
            sportsman.setLastName(params.get(2));
            sportsman.setLogin(params.get(5));
            sportsman.setPassword(params.get(6));
            sportsman.setEmail(params.get(8));
            sportsman.setAge(age);
            sportsman.setSex(sex);
            sportsman.setWeight(weight);
            sportsman.setRole(Role.SPORTSMEN);
            sportsmanRepository.update(sportsman);
        } catch (Exception e) {
            throw new SportsmanServiceException(e);
        }
    }

    public List<Sportsman> findAll() {
        return sportsmanRepository.findAll();
    }
}
