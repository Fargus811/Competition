import entity.Sex;
import entity.Sportsman;
import repository.InMemorySportsmanRepository;
import repository.SportsmanRepository;

public class Main {
    public static void main(String[] args) {
        SportsmanRepository sportsmanRepository = new InMemorySportsmanRepository();

        Sportsman first = new Sportsman();
        first.setAge(21);
        first.setClub("Molodost");
        first.setCountry("Belarus");
        first.setFirstname("Daniil");
        first.setLastName("Sergeev");
        first.setWeight(75);
        first.setSex(Sex.MALE);

        Sportsman second = new Sportsman();
        second.setAge(20);
        second.setClub("Molodost");
        second.setCountry("Belarus");
        second.setFirstname("Anna");
        second.setLastName("Sergeeva");
        second.setWeight(55);
        second.setSex(Sex.FEMALE);

        Sportsman third = new Sportsman();
        third.setAge(21);
        third.setClub("Molodost");
        third.setCountry("Belarus");
        third.setFirstname("Andrew");
        third.setLastName("Dorohovich");
        third.setWeight(75);
        third.setSex(Sex.MALE);

        sportsmanRepository.save(first);
        sportsmanRepository.save(second);
        sportsmanRepository.save(third);
        System.out.println(sportsmanRepository.findSportsManByAge(21));
        System.out.println(sportsmanRepository.findAll());
    }
}
