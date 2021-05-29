import Data.Course;
import Data.Exercise;
import Data.Trainee;
import Data.Trainer;
import Repository.CourseRepository;
import Repository.TraineeRepository;
import Repository.TrainerRepository;
import Service.DataService;

import java.time.LocalDate;

/**
 * @author Chuxing, Fang
 * @version 1.0
 */
public class DataGenerator {
    public static void main(String[] args) {
       TrainerRepository trainerRepository = new TrainerRepository();
       Trainer trainer = trainerRepository.getById("TR10000");
       trainer.setLevel(2);
       trainerRepository.add(trainer);
    }
}
