import Data.Course;
import Data.Trainer;
import Service.SearchService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class SearchServiceTest {

    private List<Course> courseList;
    private List<Trainer> trainerList;
    @BeforeEach
    void setUp() {
        courseList = new ArrayList<>();
        trainerList = new ArrayList<>();
        for(int i=0; i<5; i++){
            Course tempCourse = new Course();
            Trainer tempTrainer = new Trainer();
            tempCourse.setTitle("RealCourse"+i);
            tempTrainer.setUserName("RealTrainer"+i);
            courseList.add(tempCourse);
            trainerList.add(tempTrainer);
        }
        for(int i=0; i<3; i++){
            Course tempCourse = new Course();
            Trainer tempTrainer = new Trainer();
            tempCourse.setTitle("FakeCourse"+i);
            tempTrainer.setUserName("FakeTrainer"+i);
            courseList.add(tempCourse);
            trainerList.add(tempTrainer);
        }
    }

    @Test
    void searchCourse() {
        int resultNum = SearchService.searchCourse("Real",courseList).size();
        assertEquals(resultNum,5);
    }

    @Test
    void searchTrainer() {
        int resultNum = SearchService.searchTrainer("Real",trainerList).size();
        assertEquals(resultNum,5);
    }
}