package service;

import entity.Coach;
import entity.Sex;
import repository.CoachRepository;
import repository.InMemoryCoachRepository;

import java.util.List;
import java.util.Scanner;

public class CoachService {

    private static CoachService instance;

    CoachRepository coachRepository = InMemoryCoachRepository.getInstance();

    private CoachService(){

    }
    public static CoachService getInstance(){
        if(instance == null){
            instance = new CoachService();
        }
        return instance;
    }


    public List<Coach> findAll(){
        return coachRepository.findAll();
    }

    public void createCoach(){

        Coach coach = new Coach();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Ввeдите фамилию тренера");

        coach.setFirstname(scanner.next());

        System.out.println("Введите имя тренера");

        coach.setLastName(scanner.next());

        System.out.println("Введите востраст тренера");

        coach.setAge(scanner.nextInt());

        System.out.println("Введите пол тренара: MALE или FEMALE");

        coach.setSex(Sex.valueOf(scanner.next()));

        System.out.println("Введите старну тренера");

        coach.setCountry(scanner.next());

        System.out.println("Введите стоимость одной тренировки");

        coach.setCost();

        coachRepository.save(coach);


    }
}
