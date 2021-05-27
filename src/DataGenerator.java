import Data.Course;
import Data.Trainer;
import Repository.CourseRepository;
import Repository.TrainerRepository;
import Service.DataService;

/**
 * @author Chuxing, Fang
 * @version 1.0
 */
public class DataGenerator {
    public static void main(String[] args) {
        CourseRepository courseRepository = new CourseRepository();
        TrainerRepository trainerRepository = new TrainerRepository();
        Trainer trainer = trainerRepository.getById("Tr10002");
        System.out.println(trainer.getUserName());
        Course newCourse = new Course();
        newCourse.setCourseId("CS10001");
        courseRepository.add(newCourse);
        for(int i=0; i<20; i++){
            Course course = new Course();
            course.setTitle("Practice "+(i+1));
            course.setType("Normal practice");
            trainerRepository.createCourse(trainer,course);
        }
    }
}
