package service;

import entity.Role;
import entity.Sex;
import entity.Sportsman;
import exception.SportsmanServiceException;
import repository.InMemorySportsmanRepository;
import repository.SportsmanRepository;

import java.util.List;

public class SportsmanService {

    private static SportsmanService instance;

    private SportsmanRepository sportsmanRepository = InMemorySportsmanRepository.getInstance();

    private SportsmanService(){

    }
    public static SportsmanService getInstance(){
        if(instance == null){
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
            sportsman.setRole(Role.SPORTSMEN);
            sportsmanRepository.save(sportsman);
        } catch (Exception e) {
            throw new SportsmanServiceException(e);
        }
    }

    public List<Sportsman> findAll(){
        return sportsmanRepository.findAll();
    }
}
