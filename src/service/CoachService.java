package service;

import entity.Coach;
import repository.CoachRepository;
import repository.InMemoryCoachRepository;

import java.util.List;

public class CoachService {

    private static CoachService instance;

    private CoachService(){

    }
    public static CoachService getInstance(){
        if(instance == null){
            instance = new CoachService();
        }
        return instance;
    }

    CoachRepository coachRepository = InMemoryCoachRepository.getInstance();

    public List<Coach> findAll(){
        return coachRepository.findAll();
    }
}
