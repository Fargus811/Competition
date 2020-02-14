package repository;

import entity.Coach;
import entity.Role;
import entity.Sex;
import file.CoachFileReader;
import file.CoachFileWriter;

import java.util.*;

public class InMemoryCoachRepository implements CoachRepository {
    Object a = new String("f");
    String s = (String)a;

    private List<Coach> coachList = new ArrayList<>();
    private static InMemoryCoachRepository instance;
    private FileConfigurator coachFileConfig = new FileConfigurator();

    private  InMemoryCoachRepository() {

    }

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

    @Override
    public Coach buildCoach(String coach) {
        String[] coachParts = coach.split(";");
        Coach coachResult = new Coach();
        coachResult.setId(Long.parseLong(coachParts[0]));
        int age = Integer.parseInt(coachParts[3]);
        int cost = Integer.parseInt(coachParts[6]);
        Sex sex = Sex.valueOf(coachParts[4]);
        coachResult.setFirstName(coachParts[1]);
        coachResult.setLastName(coachParts[2]);
        coachResult.setAge(age);
        coachResult.setSex(sex);
        coachResult.setLogin(coachParts[5]);
        coachResult.setCost(cost);
        coachResult.setRank(coachParts[7]);
        coachResult.setEmail(coachParts[8]);
        coachResult.setPassword(coachParts[9]);
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
    public List<Coach> findAll() {
        List<String> coachLines = CoachFileReader.readAllLines();
        List<Coach> coachResult = new ArrayList<>();
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
    public Coach findByLogin(String login) {
        coachFileConfig.initFiles();
        String coachLogin = CoachFileReader.readLineByLogin(login);
        return null;
    }
}

