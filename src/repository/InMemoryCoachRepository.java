package repository;

import entity.Coach;
import file.CoachFileReader;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class InMemoryCoachRepository implements CoachRepository {

    private List<Coach> coachList = new ArrayList<>();

    private static InMemoryCoachRepository instance;
    FileConfigurator coachFileConfig = new FileConfigurator();

    private InMemoryCoachRepository() {

    }

    public static InMemoryCoachRepository getInstance() {
        if (instance == null) {
            instance = new InMemoryCoachRepository();
        }
        return instance;
    }

    @Override
    public List<Coach> findCoachByAge(int age) {
        List<Coach> ageCoach = new ArrayList<>();
        for (Coach coach : coachList
        ) {
            if (coach.getAge() == age) {
                ageCoach.add(coach);
            }
        }
        return ageCoach;

    }

    @Override
    public List<Coach> findByCost(int cost) {
        List<Coach> costCoach = new ArrayList<>();
        for (Coach coach : coachList
        ) {
            if (coach.getCost() == cost) {
                costCoach.add(coach);
            }
        }
        return costCoach;

    }

    @Override
    public void save(Coach coach) {
        boolean success;
        coachFileConfig.initFiles();
        coach.setId(CoachFileReader.readMaxId()+1);
        success = coachFileConfig.writeDataToFile(coachFileConfig.getCoachFile(), coach);
        if (!success) {
            System.err.println("Почини руки");
        }
    }

    @Override
    public List<Coach> findAll() {
        return Collections.unmodifiableList(coachList);
    }

    @Override
    public Coach findById(int id) {
        Coach fake = new Coach();
        fake.setId(id);
        int index = coachList.indexOf(fake);
        return coachList.get(index);
    }
}

