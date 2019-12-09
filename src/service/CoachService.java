package service;

import entity.Coach;
import entity.Sex;
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

    public void createCoach(List<String> params) {
        try {

            int age = Integer.parseInt(params.get(2));
            int cost = Integer.parseInt(params.get(5));
            Sex sex = Sex.valueOf(params.get(3));
            Coach coach = new Coach();
            coach.setFirstname(params.get(0));
            coach.setLastName(params.get(1));
            coach.setAge(age);
            coach.setSex(sex);
            coach.setCountry(params.get(4));
            coach.setCost(cost);
            coachRepository.save(coach);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
