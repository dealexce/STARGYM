import Data.Exercise;
import Repository.ExerciseRepository;
import org.junit.jupiter.api.*;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author by Yechen He
 * @date 2021/5/26.
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ExerciseRepositoryTest {
    private static Exercise exercise;
    private static ExerciseRepository repository;

    @BeforeAll
    static void initial(){
        exercise = new Exercise();
        exercise.setExerciseId("Ex10001");
        exercise.setTrainerId("Tr10001");
        exercise.setTraineeId("Te10001");
        exercise.setDescription("Description");
        repository = new ExerciseRepository();
    }
    @Order(1)
    @Test
    void add() {
        assertTrue(repository.add(exercise));
    }

    @Order(2)
    @Test
    void getById() {
        Exercise resultExercise = repository.getById("Ex10001");
        assertEquals(resultExercise.getExerciseId(),"Ex10001");
        assertEquals(resultExercise.getTraineeId(),"Te10001");
        assertEquals(resultExercise.getTrainerId(),"Tr10001");
        assertEquals(resultExercise.getDescription(),"Description");
    }

    @Order(3)
    @Test
    void getALL() {
        List<Exercise> actual = Arrays.asList(exercise);
        int i = actual.size();
        assertNotNull(actual);

    }
}