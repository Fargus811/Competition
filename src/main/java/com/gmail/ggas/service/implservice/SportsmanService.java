package com.gmail.ggas.service.implservice;

import com.gmail.ggas.entity.Sportsman;
import com.gmail.ggas.repository.Repository;
import com.gmail.ggas.repository.SportsmanRepository;
import com.gmail.ggas.repository.impl.InMemorySportsmanRepository;
import com.gmail.ggas.service.ISportsmanService;

//TODO create as CoachService
public class SportsmanService extends BaseService<Sportsman> implements ISportsmanService {

    private static ISportsmanService instance;

    private SportsmanRepository sportsmanRepository = InMemorySportsmanRepository.getInstance();

    @Override
    protected Repository<Sportsman> getRepository() {
        return sportsmanRepository;
    }

    public static ISportsmanService getInstance() {
        if (instance == null) {
            instance = new SportsmanService();
        }
        return instance;
    }

}
