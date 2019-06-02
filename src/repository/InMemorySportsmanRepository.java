package repository;

import entity.Sportsman;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class InMemorySportsmanRepository implements SportsmanRepository {
    private List<Sportsman> sportsmanList = new ArrayList<>();
    private static int counter = 0;

    public void save(Sportsman sportsman) {
        sportsman.setId(counter);
         sportsmanList.add(sportsman);
         counter++;
    }

    public List<Sportsman> findAll(){
        return Collections.unmodifiableList(sportsmanList);
    }
}
