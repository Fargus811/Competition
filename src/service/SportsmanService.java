package service;

import entity.Sportsman;
import repository.InMemorySportsmanRepository;
import repository.SportsmanRepository;

import java.util.List;

public class SportsmanService {

    private static SportsmanService instance;

    private SportsmanService(){

    }
    public static SportsmanService getInstance(){
        if(instance == null){
            instance = new SportsmanService();
        }
        return instance;
    }

    SportsmanRepository sportsmanRepository = InMemorySportsmanRepository.getInstance();

    public List<Sportsman> findAll(){
        return sportsmanRepository.findAll();
    }
}
