package Service;

import Data.*;
import Repository.CourseRepository;
import Repository.TraineeRepository;
import Repository.TrainerRepository;

import java.util.*;

/**
 * @author Chuxing, Fang
 * @version 1.0
 * Data processor in the service layer
 */
public class DataService {
    private Trainer trainer;
    private Trainee trainee;
    private CourseRepository courseRepository;
    private TrainerRepository trainerRepository;
    private TraineeRepository traineeRepository;
    private boolean isLogin = false;

    public DataService(Trainee trainee) {
        this.trainee = trainee;
        this.courseRepository = new CourseRepository();
        this.trainerRepository = new TrainerRepository();
        this.traineeRepository = new TraineeRepository();
    }

    public DataService(Trainer trainer) {
        this.trainer = trainer;
        this.courseRepository = new CourseRepository();
        this.trainerRepository = new TrainerRepository();
        this.traineeRepository = new TraineeRepository();
    }

    public DataService() {
        this.courseRepository = new CourseRepository();
        this.trainerRepository = new TrainerRepository();
        this.traineeRepository = new TraineeRepository();
    }

    public Trainee getTrainee() {
        return trainee;
    }

    public Trainer getTrainer() {
        return trainer;
    }

    /**
     * Get all the course information
     *
     * @return all the existed courses
     */
    public List<Course> getAllCourse() {
        return courseRepository.getALL();
    }

    /**
     * Get all the trainer information
     *
     * @return all the existed courses
     */
    public List<Trainer> getAllTrainer() {
        return trainerRepository.getALL();
    }

    /**
     * Login as a trainer
     *
     * @param userId   the trainer's id
     * @param password the trainer's password
     * @return true if success and false if fail
     */
    public boolean loginAsTrainer(String userId, String password) {
        boolean isLogin = false;
        isLogin = trainerRepository.login(userId, password);
        this.isLogin = isLogin;
        this.trainer = trainerRepository.getById(userId);
        return isLogin;
    }

    /**
     * Login as a trainee
     *
     * @param userId   the trainee's id
     * @param password the trainee's password
     * @return true if success and false if fail
     */
    public boolean loginAsTrainee(String userId, String password) {
        boolean isLogin = false;
        isLogin = traineeRepository.login(userId, password);
        this.isLogin = isLogin;
        this.trainee = traineeRepository.getById(userId);
        return isLogin;
    }

    /**
     * Register as a trainer
     *
     * @param username the trainer's user name
     * @param password the trainer's password
     * @return the id of the new trainer
     */
    public String registerAsTrainer(String username, String password) {
        Trainer trainer = trainerRepository.register(username, password);
        return trainer.getUserId();
    }

    /**
     * Register as a trainee
     *
     * @param username the trainee's user name
     * @param password the trainee's password
     * @return the id of the new trainee
     */
    public String registerAsTrainee(String username, String password) {
        Trainee trainee = traineeRepository.register(username, password);
        return trainee.getUserId();
    }

    /**
     * Trainee add a course to favorite
     * @param courseId the course id
     * @return true if success and false if fail
     */
    public boolean traineeAddCourse(String courseId) {
        boolean result = traineeRepository.addCourse(trainee, courseId);
        refresh();
        return result;
    }

    /**
     * Trainee add a trainer to favorite
     * @param trainerId the trainer id
     * @return true if success and false if fail
     */
    public boolean traineeAddTrainer(String trainerId) {
        boolean result = traineeRepository.addTrainer(trainee, trainerId);
        refresh();
        return result;
    }

    /**
     * Trainer create a course
     * @param course the course object
     * @return true if success and false if fail
     */
    public boolean trainerCreateCourse(Course course){
        boolean result = trainerRepository.createCourse(trainer, course);
        refresh();
        return result;
    }

    /**
     * refresh the user information from the data file
     */
    private void refresh(){
        if(trainer != null){
            trainer = trainerRepository.getById(trainer.getUserId());
        }
        if(trainee != null){
            trainee = traineeRepository.getById(trainee.getUserId());
        }
    }
}
