package service;

import entity.Sex;
import entity.Sportsman;
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
    public void createSportsman(List<String> params) {
        try {

            int age = Integer.parseInt(params.get(2));
            double cost = Double.valueOf(params.get(3));
            Sex sex = Sex.valueOf(params.get(5));
            Sportsman sportsman = new Sportsman();
            sportsman.setFirstname(params.get(0));
            sportsman.setLastName(params.get(1));
            sportsman.setAge(age);
            sportsman.setSex(sex);
            sportsman.setCountry(params.get(4));
            sportsmanRepository.save(sportsman);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    public List<Sportsman> findAll(){
        return sportsmanRepository.findAll();
    }
}
