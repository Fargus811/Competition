package com.gmail.ggas.service.implservice;

import com.gmail.ggas.entity.Coach;
import com.gmail.ggas.repository.CoachRepository;
import com.gmail.ggas.repository.Repository;
import com.gmail.ggas.repository.impl.InMemoryCoachRepository;
import com.gmail.ggas.service.ICoachService;

import java.util.List;

public class CoachService extends BaseService<Coach> implements ICoachService {

    private CoachRepository coachRepository = InMemoryCoachRepository.getInstance();

    private static CoachService instance;

    private CoachService() {
    }

    public static CoachService getInstance() {
        if (instance == null) {
            instance = new CoachService();
        }
        return instance;
    }

    @Override
    protected Repository<Coach> getRepository() {
        return coachRepository;
    }


    public List<Coach> findCoachByAge(int age) {
        return coachRepository.findCoachByAge(age);
    }

}
