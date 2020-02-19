import com.gmail.ggas.entity.Coach;
import com.gmail.ggas.entity.Role;
import com.gmail.ggas.entity.Sex;
import com.gmail.ggas.repository.CoachRepository;
import com.gmail.ggas.repository.InMemoryCoachRepository;
import org.junit.Assert;
import org.junit.Test;

public class CoachRepositoryTest {
    @Test
            public void buildCoach() throws Exception {
        InMemoryCoachRepository repository =InMemoryCoachRepository.getInstance();
        Coach coachAssert = new Coach();
        coachAssert.setFirstName("Daniil");
        coachAssert.setLastName("Sergeev");
        coachAssert.setId(0);
        coachAssert.setAge(23);
        coachAssert.setSex(Sex.MALE);
        coachAssert.setLogin("FARGUS*8");
        coachAssert.setPassword("XYZ");
        coachAssert.setEmail("GMAIL");
        coachAssert.setCost(500);
        coachAssert.setRank("MCMK");
        coachAssert.setWorkExperience(5.5);
        coachAssert.setRole(Role.COACH);
        Coach coach = repository.buildCoach("0;Sergeev;Daniil;23;MALE;FARGUS*8;XYZ;GMAIL;500;MCMK;5.5");
                Assert.assertEquals("So bad",coachAssert,coach);
    }
}



