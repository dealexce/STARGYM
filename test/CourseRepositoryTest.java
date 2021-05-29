import Data.Course;
import Repository.CourseRepository;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author by Yechen He
 * @date 2021/5/25.
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class CourseRepositoryTest {

    private static Course course;
    private static CourseRepository repository;

    @BeforeAll
    static void initial(){
        course = new Course();
        course.setCourseId("C10001");
        course.setTitle("CourseA");
        course.setDescription("VideoA");
        course.setCover("CoverA");
        course.setType("TypeA");
        repository = new CourseRepository();
    }
    @Order(1)
    @Test
    void add() {
        assertTrue(repository.add(course));
    }
    @Order(2)
    @Test
    void getById() {
        Course resultCourse = repository.getById("C10001");
        assertEquals(resultCourse.getTitle(),"CourseA");
        assertEquals(resultCourse.getDescription(),"VideoA");
        assertEquals(resultCourse.getCover(),"CoverA");
        assertEquals(resultCourse.getType(),"TypeA");
    }
}