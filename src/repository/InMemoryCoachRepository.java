package repository;import entity.Sex;
import entity.Coach;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class IInMemoryCoachRepository implements CoachRepository {
    private List<Coach> sportsmanList = new ArrayList<>();
    private static int counter = 0;
    private Object Coach;

    @Override
    public void save(Coach coach) {
        coach.setId(counter);
        coachList.add(coach);
        counter++;
    }

    @Override
    public List<Coach> findAll() {
        return Collections.unmodifiableList(sportsmanList);
    }

    @Override
    public List<Coach> findSportsManByAge(int age) throws Exception {
        List<Coach> ageCoach = new ArrayList<>();
        for (Coach sportsman : sportsmanList
        ) {
            if (sportsman.getAge() == age) {
                ageCoach.add(Coach);
            }
        }
        return ageSportsman;

    }

    @Override
    public Coach findById(int id) {
        Coach fake = new Coach();
        fake.setId(id);
        int index = coachList.indexOf(fake);
        return sportsmanList.get(index);
    }

    @Override
    public List<Sportsman> findByWeight(int weight) {
        List<Sportsman> weightSportsman = new ArrayList<>();
        for (Sportsman sportsman : sportsmanList
        ) {
            if (sportsman.getWeight() == weight) {
                weightSportsman.add(sportsman);
            }
        }
        return weightSportsman;
    }


    public static int getCounter() {
        return counter;
    }
}
