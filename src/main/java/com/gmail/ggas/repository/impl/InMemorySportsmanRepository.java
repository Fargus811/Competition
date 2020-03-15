package com.gmail.ggas.repository.impl;

import com.gmail.ggas.entity.Role;
import com.gmail.ggas.entity.Sex;
import com.gmail.ggas.entity.Sportsman;
import com.gmail.ggas.repository.SportsmanRepository;
import com.gmail.ggas.repository.condition.Condition;

import java.util.List;

public class InMemorySportsmanRepository extends BaseRepository<Sportsman> implements SportsmanRepository {

    public InMemorySportsmanRepository(String relativePath) {
        super(relativePath);
    }

    private static InMemorySportsmanRepository instance;

    public static InMemorySportsmanRepository getInstance() {
        if (instance == null) {
            instance = new InMemorySportsmanRepository("database/sportsmenList.txt");
        }
        return instance;
    }


    @Override
    public List<Sportsman> findSportsManByAge(int age) {
        Condition<Sportsman> condition = new Condition<Sportsman>() {
            @Override
            public boolean check(Sportsman entity) {
                return entity.getAge() == age;
            }
        };
        return findListByCondition(condition);
    }

    @Override
    public List<Sportsman> findByWeight(double weight) {
        Condition<Sportsman> condition = new Condition<Sportsman>() {
            @Override
            public boolean check(Sportsman entity) {
                return entity.getWeight() == weight;
            }
        };
        return findListByCondition(condition);
    }

    protected Sportsman buildEntity(String sportsman) {
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
        sportsmanResult.setRole(Role.SPORTSMEN);
        return sportsmanResult;
    }

    @Override
    public Sportsman findByLogin(String login) {
        Condition<Sportsman> condition = new Condition<Sportsman>() {
            @Override
            public boolean check(Sportsman sportsman) {
                return sportsman.getLogin().equals(login);
            }
        };
        return findListByCondition(condition).get(0);
    }

    protected String buildLine(Sportsman sportsman) {
        StringBuilder builder = new StringBuilder();
        builder.append(sportsman.getId()).append(";").append(sportsman.getFirstName()).append(";")
                .append(sportsman.getLastName()).append(";").append(sportsman.getAge()).append(";")
                .append(sportsman.getSex()).append(";").append(sportsman.getLogin()).append(";")
                .append(sportsman.getPassword()).append(";").append(sportsman.getEmail()).append(";")
                .append(sportsman.getWeight());
        return builder.toString();
    }

}