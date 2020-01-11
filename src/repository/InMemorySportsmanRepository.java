package repository;

import entity.Sex;
import entity.Sportsman;
import file.CoachFileReader;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class InMemorySportsmanRepository implements SportsmanRepository {

    private List<Sportsman> sportsmanList = new ArrayList<>();

    private static int counter = 0;

    private static InMemorySportsmanRepository instance ;

    private InMemorySportsmanRepository(){

    }

    public static InMemorySportsmanRepository getInstance(){
        if(instance == null){
            instance = new InMemorySportsmanRepository();
        }
        return instance;
    }



    @Override
    public void save(Sportsman sportsman) {
        boolean success;
        coachFileConfig.initFiles();
        sportsman.setId(CoachFileReader.readMaxId() + 1);
        success = coachFileConfig.writeDataToFile(coachFileConfig.getCoachFile(), coach);
        if (!success) {
            System.err.println("Почини руки");
        }
    }

    @Override
    public List<Sportsman> findAll() {
        return Collections.unmodifiableList(sportsmanList);
    }

    @Override
    public List<Sportsman> findSportsManByAge(int age) {
        List<Sportsman> ageSportsman = new ArrayList<>();
        for (Sportsman sportsman : sportsmanList
        ) {
            if (sportsman.getAge() == age) {
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
        for (Sportsman sportsman : sportsmanList
        ) {
            if (sportsman.getWeight() == weight) {
                weightSportsman.add(sportsman);
            }
        }
        return weightSportsman;
    }

    @Override
    public List<Sportsman> findByManandWeight(int weight) {
        List<Sportsman> weightSportsman = new ArrayList<>();
        for (Sportsman sportsman : sportsmanList
        ) {
            if (sportsman.getWeight() == weight && sportsman.getSex() == Sex.MALE) {
                weightSportsman.add(sportsman);
            }
        }
        return weightSportsman;
    }

    public static int getCounter() {
        return counter;
    }
}
