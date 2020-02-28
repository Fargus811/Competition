package com.gmail.ggas.repository;

import com.gmail.ggas.entity.Coach;
import com.gmail.ggas.entity.Role;
import com.gmail.ggas.entity.Sex;
import com.gmail.ggas.entity.User;
import com.gmail.ggas.exception.UserLoginException;
import com.gmail.ggas.file.CoachFileReader;
import com.gmail.ggas.file.CoachFileWriter;

import java.util.ArrayList;
import java.util.List;

import static com.gmail.ggas.file.CoachFileReader.readLineByLogin;

public class InMemoryCoachRepository implements CoachRepository {


    private List<Coach> coachList = new ArrayList<>();
    private static InMemoryCoachRepository instance;
    private FileConfigurator coachFileConfig = new FileConfigurator();


    public static InMemoryCoachRepository getInstance() {
        if (instance == null) {
            instance = new InMemoryCoachRepository();
        }
        return instance;
    }

    @Override
    public List<Coach> findCoachByAge(int age) {
        List<Coach> ageCoach = new ArrayList<>();
        for (Coach coach : coachList) {
            if (coach.getAge() == age) {
                ageCoach.add(coach);
            }
        }

        return ageCoach;

    }

    @Override
    public List<Coach> findByCost(int cost) {
        List<Coach> costCoach = new ArrayList<>();
        for (Coach coach : coachList) {
            if (coach.getCost() == cost) {
                costCoach.add(coach);
            }
        }
        return costCoach;

    }

    @Override
    public void deleteById(long id) {
        List<String> allLines = CoachFileReader.readAllLines();
        allLines.remove(CoachFileReader.readLineById(String.valueOf(id)));
        CoachFileWriter.writeLinesToFile(allLines);
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
        coachFileConfig.initFiles();
        List<String> coachLines = CoachFileReader.readAllLines();
        List<String> coachResult = new ArrayList<>();
        for (String line : coachLines) {
            if (!CoachFileReader.retrieveIdFromLine(line).equals(coachId)) {
                coachResult.add(line);
            }
        }
        coachResult.add(coach.parseToDbString());
        CoachFileWriter.writeLinesToFile(coachResult);
    }

    @Override
    public void save(Coach coach) {
        boolean success;
        coachFileConfig.initFiles();
        coach.setId(CoachFileReader.readMaxId() + 1);
        success = coachFileConfig.writeDataToFile(coachFileConfig.getCoachFile(), coach);
        if (!success) {
            System.err.println("Почини руки");
        }
    }

    @Override
    public List<User> findAll() {
        List<String> coachLines = CoachFileReader.readAllLines();
        List<User> coachResult = new ArrayList<>();
        for (String line : coachLines) {
            coachResult.add(buildCoach(line));
        }
        return coachResult;
    }

    @Override
    public Coach findById(long id) {
        coachFileConfig.initFiles();
        String coachString = CoachFileReader.readLineById(String.valueOf(id));
        return coachString == null ? null : buildCoach(coachString);
    }

    @Override
    public String findByLogin(String login) throws UserLoginException {
        coachFileConfig.initFiles();
        String coachLogin;
        try {

            coachLogin = CoachFileReader.retrieveLoginFromLine(readLineByLogin(login));
        } catch (Exception e) {
            throw new UserLoginException(e);
        }
        return coachLogin;
    }
}

