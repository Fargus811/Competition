package com.gmail.ggas.repository.impl;

import com.gmail.ggas.entity.Coach;
import com.gmail.ggas.entity.Role;
import com.gmail.ggas.entity.Sex;
import com.gmail.ggas.exception.RepositoryException;
import com.gmail.ggas.file.CoachFileWriter;
import com.gmail.ggas.file.EntityKeyValueFileStore;
import com.gmail.ggas.file.FileConfigurator;
import com.gmail.ggas.repository.CoachRepository;
import com.gmail.ggas.repository.condition.AgeCoachCondition;
import com.gmail.ggas.repository.condition.CoachCondition;
import com.gmail.ggas.repository.condition.CostCoachCondition;
import com.gmail.ggas.repository.condition.LoginCoachCondition;
import org.apache.commons.collections4.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

public class InMemoryCoachRepository implements CoachRepository {

    private List<Coach> coachList = new ArrayList<>();

    private static InMemoryCoachRepository instance;

    private FileConfigurator coachFileConfig = new FileConfigurator();

    private EntityKeyValueFileStore coachKeyValueFileStore = new EntityKeyValueFileStore("database/coachList.txt");


    public static InMemoryCoachRepository getInstance() {
        if (instance == null) {
            instance = new InMemoryCoachRepository();
            instance.coachFileConfig.initFiles();
        }

        return instance;
    }

    @Override
    public List<Coach> findCoachByAge(int age) {
        CoachCondition coachCondition = new AgeCoachCondition(age);
        return findListByCondition(coachCondition);
        //


    }

    @Override
    public List<Coach> findByCost(int cost) {
        CoachCondition coachCondition = new CostCoachCondition(cost);
        return findListByCondition(coachCondition);

//        List<String> lines = coachKeyValueFileStore.readAllLines();
//        List<Coach> coaches = new ArrayList<>();
//        List<Coach> resultCoaches = new ArrayList<>();
//        for (String line : lines) {
//            coaches.add(buildCoach(line));
//        }
//        for (Coach coach : coaches) {
//            // the same
//            if (coach.getCost() == cost) {
//                resultCoaches.add(coach);
//            }
//        }
//        //the same
//
//        return resultCoaches;
    }

    private List<Coach> findListByCondition(CoachCondition condition) {
        List<String> lines = coachKeyValueFileStore.readAllLines();
        List<Coach> coaches = new ArrayList<>();
        List<Coach> resultCoaches = new ArrayList<>();
        for (String line : lines) {
            coaches.add(buildCoach(line));
        }
        for (Coach coach : coaches) {
            if (condition.check(coach)) { //
                resultCoaches.add(coach);
            }
        }
        return resultCoaches;
    }


    @Override
    public void deleteById(long id) {
        coachKeyValueFileStore.deleteById(id);
    }


    private Coach buildCoach(String coach) {
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

    @Override
    public void update(Coach coach) {
        String coachId = String.valueOf(coach.getId());
        List<String> coachLines = coachKeyValueFileStore.readAllLines();
        List<String> coachResult = new ArrayList<>();
        for (String line : coachLines) {
            if (!coachKeyValueFileStore.retrieveIdFromLine(line).equals(coachId)) {
                coachResult.add(line);
            }
        }
        coachResult.add(coach.parseToDbString());
        CoachFileWriter.writeLinesToFile(coachResult);
    }

    @Override
    public void save(Coach coach) {
        boolean success;
        coach.setId(coachKeyValueFileStore.readMaxId() + 1);
        success = coachFileConfig.writeDataToFile(coachFileConfig.getCoachFile(), coach);
        if (!success) {
            System.err.println("Почини руки");
        }
    }

    @Override
    public List<Coach> findAll() {
        List<String> coachLines = coachKeyValueFileStore.readAllLines();
        List<Coach> coachResult = new ArrayList<>();
        for (String line : coachLines) {
            coachResult.add(buildCoach(line));
        }
        return coachResult;
    }

    @Override
    public Coach findById(long id) {
        String coachString = coachKeyValueFileStore.readLineById(String.valueOf(id));
        return coachString == null ? null : buildCoach(coachString);
    }

    @Override
    public Coach findByLogin(String login) {
        CoachCondition coachCondition = new LoginCoachCondition(login);
        return findListByCondition(coachCondition).get(0);
    }

    public Coach findOneByCondition(CoachCondition condition) throws RepositoryException {
        List<Coach> coaches = findListByCondition(condition);
        if (CollectionUtils.isEmpty(coaches)) {
            return null;
        } else if (coaches.size() > 1) {
            throw new RepositoryException("Illegal number of entities ");
        }
        return coaches.get(0);
    }
}

//        List<String> lines = coachKeyValueFileStore.readAllLines();
//        List<Coach> coaches = new ArrayList<>();
//        for (String line : lines) {
//            coaches.add(buildCoach(line));
//        }
//        for (Coach coach : coaches) {
//            String currentLogin;
//            currentLogin = coach.getLogin();
//            if (currentLogin.equals(login)) {
//                return coach;
//            }
//        }
//        return null;
//
//    }


