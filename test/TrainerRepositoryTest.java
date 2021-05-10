import Data.Trainer;
import Repository.TrainerRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import javax.xml.ws.ServiceMode;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author Chuxing, Fang
 * @date
 */
class TrainerRepositoryTest {
    private static Trainer testTrainer;
    private static TrainerRepository repository;

    @BeforeAll
    static void initial() {
        testTrainer = new Trainer();
        testTrainer.setUserId("Tr10001");
        testTrainer.setUserName("Fang");
        testTrainer.setPassWord("fc2123");
        repository = new TrainerRepository();
    }

    @Test
    void add() {
        assertTrue(repository.add(testTrainer));
    }

    @Test
    void getById() {
        Trainer resultTrainer = repository.getById("Tr10001");
        assertEquals(resultTrainer.getPassWord(), "fc2123");
        assertEquals(resultTrainer.getUserName(), "Fang");
    }

    @Test
    void login() {
        assertTrue(repository.login("Tr10001","fc2123"));
    }

    @Test
    void register(){
        assertEquals(repository.register("Peter","12345678").getUserName(), "Peter");
    }

}