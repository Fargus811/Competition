package repository;

import entity.Sportsman;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class InMemorySportsmanRepository implements SportsmanRepository {
    private List<Sportsman> sportsmanList = new ArrayList<>();
    private static int counter = 0;

    @Override
    public void save(Sportsman sportsman) {
        sportsman.setId(counter);
         sportsmanList.add(sportsman);
         counter++;
    }

    @Override
    public List<Sportsman> findAll(){
        return Collections.unmodifiableList(sportsmanList);
    }

    @Override
    public List<Sportsman> findSportsManByAge(int age) {
        List<Sportsman> ageSportsman = new ArrayList<>();
        for (Sportsman sportsman: sportsmanList
             ) {
            if (sportsman.getAge() == age){
                ageSportsman.add(sportsman);
            }
        }
        return ageSportsman;

    }

    @Override
    public Sportsman findById(int id) {
        Sportsman fake = new Sportsman();
        fake.setId(id);
        int index = sportsmanList.indexOf(fake);
        return sportsmanList.get(index);
    }

    @Override
    public List<Sportsman> findByWeight(int weight) {
        List<Sportsman> weightSportsman = new ArrayList<>();
        for (Sportsman sportsman: sportsmanList
        ) {
            if (sportsman.getAge() == weight){
                weightSportsman.add(sportsman);
            }
        }
        return weightSportsman;
    }
}
