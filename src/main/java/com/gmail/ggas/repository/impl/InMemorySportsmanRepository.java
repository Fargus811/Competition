package com.gmail.ggas.repository.impl;

import com.gmail.ggas.entity.Role;
import com.gmail.ggas.entity.Sex;
import com.gmail.ggas.entity.Sportsman;
import com.gmail.ggas.file.*;
import com.gmail.ggas.repository.SportsmanRepository;

import java.util.ArrayList;
import java.util.List;

public class InMemorySportsmanRepository implements SportsmanRepository {

    private static int counter = 0;

    private FileConfigurator sportsmanFileConfig = new FileConfigurator();

    private static InMemorySportsmanRepository instance;

    private EntityKeyValueFileStore sportsmanKeyValueFileStore =
            new EntityKeyValueFileStore("database/sportsmenList.txt");


    public static InMemorySportsmanRepository getInstance() {
        if (instance == null) {
            instance = new InMemorySportsmanRepository();
        }
        return instance;
    }


    @Override
    public void save(Sportsman sportsman) {
        boolean success;
        sportsmanFileConfig.initFiles();
        sportsman.setId(SportsmanFileReader.readMaxId() + 1);
        success = sportsmanFileConfig.writeDataToFile(sportsmanFileConfig.getSportsmenFile(), sportsman);
        if (!success) {
            System.err.println("Почини руки");
        }
    }

    @Override
    public List<Sportsman> findAll() {
        List<String> sportsmanLines = sportsmanKeyValueFileStore.readAllLines();
        List<Sportsman> sportsmanList = new ArrayList<>();
        for (String line : sportsmanLines) {
            sportsmanList.add(buildSportsman(line));
        }
        return sportsmanList;
    }

    @Override
    public List<Sportsman> findSportsManByAge(int age) {
//        List<Sportsman> ageSportsman = new ArrayList<>();
//        for (Sportsman sportsman : sportsmanList) {
//            if (sportsman.getAge() == age) {
//                ageSportsman.add(sportsman);
//            }
//        }
//        return ageSportsman;
        return null;
    }

    @Override
    public Sportsman findById(long id) {
        sportsmanFileConfig.initFiles();
        String coachString = SportsmanFileReader.readLineById(String.valueOf(id));
        return coachString == null ? null : buildSportsman(coachString);
    }

    @Override
    public Sportsman findByWeight(double weight) {
//        List<Sportsman> weightSportsman = new ArrayList<>();
//        for (Sportsman sportsman : sportsmanList) {
//            if (sportsman.getWeight() == weight) {
//                weightSportsman.add(sportsman);
//            }
//        }
//        for (Sportsman sportsman : weightSportsman
//        ) {
//            return sportsman;
//        }
        return null;
    }
//
//    public List<Sportsman> findByManAndWeight(double weight) {
//        List<Sportsman> weightSportsman = new ArrayList<>();
//        for (Sportsman sportsman : sportsmanList) {
//            if (sportsman.getWeight() == weight && sportsman.getSex() == Sex.MALE) {
//                weightSportsman.add(sportsman);
//            }
//        }
//        return weightSportsman;
//    }

    @Override
    public void deleteById(long id) {
        List<String> allLines = CoachFileReader.readAllLines();
        allLines.remove(SportsmanFileReader.readLineById(String.valueOf(id)));
        SportsmanFileWriter.writeLinesToFile(allLines);
    }

    private Sportsman buildSportsman(String sportsman) {
        String[] coachParts = sportsman.split(";");
        Sportsman sportsmanResult = new Sportsman();
        sportsmanResult.setId(Long.parseLong(coachParts[0]));
        int age = Integer.parseInt(coachParts[3]);
        double weight = Double.parseDouble(coachParts[8]);
        Sex sex = Sex.valueOf(coachParts[4]);
        sportsmanResult.setFirstName(coachParts[1]);
        sportsmanResult.setLastName(coachParts[2]);
        sportsmanResult.setAge(age);
        sportsmanResult.setWeight(weight);
        sportsmanResult.setLogin(coachParts[5]);
        sportsmanResult.setPassword(coachParts[6]);
        sportsmanResult.setSex(sex);
        sportsmanResult.setEmail(coachParts[7]);
        sportsmanResult.setRole(Role.COACH);
        return sportsmanResult;
    }

    @Override
    public void update(Sportsman sportsman) {
        String coachId = String.valueOf(sportsman.getId());
        sportsmanFileConfig.initFiles();
        List<String> sportsmanLines = CoachFileReader.readAllLines();
        List<String> sportsmanResult = new ArrayList<>();
        for (String line : sportsmanLines) {
            if (!CoachFileReader.retrieveIdFromLine(line).equals(coachId)) {
                sportsmanResult.add(line);
            }
        }
        sportsmanResult.add(sportsman.parseToDbString());
        SportsmanFileWriter.writeLinesToFile(sportsmanResult);
    }

    @Override
    public Sportsman findByLogin(String login) {
        return null;
    }

    public static int getCounter() {
        return counter;
    }

}