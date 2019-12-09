package service;

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


    public List<Sportsman> findAll(){
        return sportsmanRepository.findAll();
    }
}
