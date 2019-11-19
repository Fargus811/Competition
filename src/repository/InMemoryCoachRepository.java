package repository;

import entity.Coach;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class InMemoryCoachRepository implements CoachRepository {
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

    private List<Coach> coachList = new ArrayList<>();
    private static int counter = 0;

    @Override
    public void save(Coach coach) {
        coach.setId(counter);
        coachList.add(coach);
        counter++;
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




    public static int getCounter() {
        return counter;
    }
}
