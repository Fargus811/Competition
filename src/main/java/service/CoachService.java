package service;

import entity.Coach;
import entity.Role;
import entity.Sex;
import exception.CoachServiceException;
import repository.CoachRepository;
import repository.InMemoryCoachRepository;

import java.util.List;

public class CoachService {

    private static CoachService instance;

    private CoachRepository coachRepository = InMemoryCoachRepository.getInstance();

    private CoachService() {

    }

    public static CoachService getInstance() {
        if (instance == null) {
            instance = new CoachService();
        }
        return instance;
    }

    public List<Coach> findAll() {
        return coachRepository.findAll();
    }

    public void createCoach(List<String> params) throws CoachServiceException {
        try {
            int age = Integer.parseInt(params.get(2));
            int cost = Integer.parseInt(params.get(5));
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
            coach.setRole(Role.COACH);
            coachRepository.save(coach);
        } catch (Exception e) {
            throw new CoachServiceException(e);
        }

    }

    public void deleteById(long id){
        Coach coach = coachRepository.findById(id);
        if (coach == null){
            System.out.println("Пользователь с таким id:"+ id + " не найден");
        }else {
            coachRepository.deleteById(id);
        }

    }
    public void update(List<String> params) throws CoachServiceException{
        try {
            int age = Integer.parseInt(params.get(3));
            int cost = Integer.parseInt(params.get(6));
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
            coachRepository.update(coach);
        } catch (Exception e) {
            throw new CoachServiceException(e);
        }

    }
}