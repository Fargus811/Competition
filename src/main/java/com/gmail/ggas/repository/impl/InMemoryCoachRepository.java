package com.gmail.ggas.repository.impl;

import com.gmail.ggas.entity.Coach;
import com.gmail.ggas.entity.Role;
import com.gmail.ggas.entity.Sex;
import com.gmail.ggas.exception.UserLoginException;
import com.gmail.ggas.file.EntityKeyValueFileStore;
import com.gmail.ggas.repository.CoachRepository;
import com.gmail.ggas.repository.condition.Condition;

import java.util.List;
import java.util.ListIterator;

public class InMemoryCoachRepository extends BaseRepository<Coach> implements CoachRepository {

    private InMemoryCoachRepository(String relativePath) {
        super(relativePath);
    }

    private static InMemoryCoachRepository instance;

    public static InMemoryCoachRepository getInstance() {
        if (instance == null) {
            instance = new InMemoryCoachRepository("database/coachList.txt");
        }
        return instance;
    }

    @Override
    public List<Coach> findCoachByAge(int age) {
        Condition condition = new Condition<Coach>() {
            @Override
            public boolean check(Coach coach) {
                return coach.getAge() == age;
            }
        };
        return findListByCondition(condition);
    }

    @Override
    public List<Coach> findByCost(int cost) {
        Condition<Coach> condition = new Condition<Coach>() {
            @Override
            public boolean check(Coach coach) {
                return coach.getCost() == cost;
            }
        };
        return findListByCondition(condition);
    }

    @Override
    public Coach findByLogin(String login) {
        Condition<Coach> condition = new Condition<Coach>() {
            @Override
            public boolean check(Coach coach) {
                return coach.getLogin().equals(login);
            }
        };
        return findListByCondition(condition).get(0);
    }

    public String findPasswordByLogin(String login) throws UserLoginException {
        List<String> lines = new EntityKeyValueFileStore("database/coachList.txt").readAllLines();
        ListIterator<String> iterator = lines.listIterator();
        String truePassword;
        while (iterator.hasNext()) {
            String currentLine = iterator.next();
            if (currentLine.split(";")[5].equals(login)) {
                truePassword = currentLine.split(";")[9];
                return truePassword;
            }
        }
        throw new UserLoginException();
    }


    protected Coach buildEntity(String coach) {
        String[] coachParts = coach.split(";");
        Coach coachResult = new Coach();
        coachResult.setId(Long.parseLong(coachParts[0]));
        int age = Integer.parseInt(coachParts[3]);
        int cost = Integer.parseInt(coachParts[8]);
        double workExp = Double.valueOf(coachParts[10]);
        Sex sex = Sex.valueOf(coachParts[4]);
        coachResult.setFirstName(coachParts[2]);
        coachResult.setLastName(coachParts[1]);
        coachResult.setAge(age);
        coachResult.setSex(sex);
        coachResult.setLogin(coachParts[5]);
        coachResult.setCost(cost);
        coachResult.setRank(coachParts[9]);
        coachResult.setEmail(coachParts[7]);
        coachResult.setPassword(coachParts[6]);
        coachResult.setWorkExperience(workExp);
        coachResult.setRole(Role.COACH);
        return coachResult;
    }

    //TODO оптимизировать
    protected String buildLine(Coach coach) {
        return coach.getId() + ";" + coach.getFirstName() + ";" + coach.getLastName() + ";" + coach.getAge() + ";"
                + coach.getSex() + ";" + coach.getLogin() + ";" + coach.getPassword() + ";" + coach.getEmail() + ";"
                + coach.getCost() + ";" + coach.getRank() + ";" + coach.getWorkExperience() + "\n";

    }

}


