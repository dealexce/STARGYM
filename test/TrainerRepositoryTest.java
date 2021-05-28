import Data.Trainer;
import Repository.TrainerRepository;
import org.junit.jupiter.api.*;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author Chuxing, Fang
 * @date
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
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
    @Order(1)
    @Test
    void add() {
        assertTrue(repository.add(testTrainer));
    }

    @Order(2)
    @Test
    void getById() {
        Trainer resultTrainer = repository.getById("Tr10001");
        assertEquals(resultTrainer.getPassWord(), "fc2123");
        assertEquals(resultTrainer.getUserName(), "Fang");
    }

    @Order(3)
    @Test
    void login() {
        assertTrue(repository.login("Tr10001","fc2123"));
    }

    @Order(4)
    @Test
    void register(){
        assertEquals(repository.register("Peter","12345678").getUserName(), "Peter");
    }

}