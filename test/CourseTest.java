import Data.Course;
import Repository.CourseRepository;

public class CourseTest {
/**
 * @description: Test Class for Courses
 * @author: Haopu Chen
 **/
    public static void main(String[] args) {
        CourseRepository courseRepository = new CourseRepository();
        for(int i = 1;i<20;i++){
            Course course = new Course();
            course.setCourseId("C"+ (i+100000));
            course.setTitle("Kongfu Pro"+i);
            courseRepository.add(course);
        }

    }
}
