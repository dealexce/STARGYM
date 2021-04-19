import Data.Trainee;
import Repository.TraineeRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TraineeRepositoryTest {

    private static Trainee testTrainee;
    private static TraineeRepository repository;

    @BeforeAll
    static void initial() {
        testTrainee = new Trainee();
        testTrainee.setUserId("Te10001");
        testTrainee.setUserName("Star");
        testTrainee.setPassWord("star123");
        testTrainee.setSex("Male");
        testTrainee.setTelephone("17363348888");
        repository = new TraineeRepository();
    }
    @Test
    void add() {
        assertTrue(repository.add(testTrainee));
    }

    @Test
    void getById() {
        Trainee resultTrainee = repository.getById("Te10001");
        assertEquals(resultTrainee.getPassWord(), "star123");
        assertEquals(resultTrainee.getUserName(),"Star");
        assertEquals(resultTrainee.getSex(), "Male");
        assertEquals(resultTrainee.getTelephone(),"17363348888");
    }

    @Test
    void login() {
        assertTrue(repository.login("Te10001","star123"));
    }

    @Test
    void register(){
        assertTrue(repository.register("David","12345678"));
    }
}