package com.gmail.ggas.service;

import com.gmail.ggas.entity.Coach;
import com.gmail.ggas.entity.Role;
import com.gmail.ggas.entity.Sex;
import com.gmail.ggas.exception.CoachServiceException;
import com.gmail.ggas.repository.CoachRepository;
import com.gmail.ggas.repository.impl.InMemoryCoachRepository;

import java.util.List;

public class CoachService implements ICoachService {

    private static ICoachService instance;

    private CoachRepository coachRepository = InMemoryCoachRepository.getInstance();

    public static ICoachService getInstance() {
        if (instance == null) {
            instance = new CoachService();
        }
        return instance;
    }

    public void createPerson(List<String> params) throws CoachServiceException {
        try {
            int age = Integer.parseInt(params.get(2));
            int cost = Integer.parseInt(params.get(5));
            double workExp = Double.valueOf(params.get(9));
            Sex sex = Sex.valueOf(params.get(3));
            Coach coach = new Coach();
            coach.setFirstName(params.get(0));
            coach.setLastName(params.get(1));
            coach.setAge(age);
            coach.setSex(sex);
            coach.setLogin(params.get(4));
            coach.setCost(cost);
            coach.setRank(params.get(6));
            coach.setEmail(params.get(7));
            coach.setPassword(params.get(8));
            coach.setWorkExperience(workExp);
            coach.setRole(Role.COACH);
            coachRepository.save(coach);
        } catch (Exception e) {
            throw new CoachServiceException(e);
        }

    }

    public void deleteById(long id) {
        Coach coach = coachRepository.findById(id);
        if (coach == null) {
            System.out.println("Пользователь с таким id:" + id + " не найден");
        } else {
            coachRepository.deleteById(id);
        }

    }

    public void update(List<String> params) throws CoachServiceException {
        try {
            int age = Integer.parseInt(params.get(3));
            int cost = Integer.parseInt(params.get(6));
            double workExp = Double.valueOf(params.get(10));
            Sex sex = Sex.valueOf(params.get(4));
            Coach coach = new Coach();
            coach.setId(Long.parseLong(params.get(0)));
            coach.setFirstName(params.get(1));
            coach.setLastName(params.get(2));
            coach.setAge(age);
            coach.setSex(sex);
            coach.setLogin(params.get(5));
            coach.setCost(cost);
            coach.setRank(params.get(7));
            coach.setEmail(params.get(8));
            coach.setPassword(params.get(9));
            coach.setWorkExperience(workExp);
            coach.setRole(Role.COACH);
            coachRepository.update(coach);
        } catch (Exception e) {
            throw new CoachServiceException(e);
        }
    }

    public List<Coach> findAll() {
        return coachRepository.findAll();
    }

    public List<Coach> findCoachByAge(List<String> params) {
        return coachRepository.findCoachByAge(Integer.parseInt(params.get(0)));
    }
}
