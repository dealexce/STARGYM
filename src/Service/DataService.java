package Service;

import Data.*;
import Repository.CourseRepository;
import Repository.ExerciseRepository;
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
    private ExerciseRepository exerciseRepository;

    public boolean isLogin() {
        return isLogin;
    }

    private boolean isLogin = false;

    public DataService(Trainee trainee) {
        this.trainee = trainee;
        this.courseRepository = new CourseRepository();
        this.trainerRepository = new TrainerRepository();
        this.traineeRepository = new TraineeRepository();
        this.exerciseRepository = new ExerciseRepository();
    }

    public DataService(Trainer trainer) {
        this.trainer = trainer;
        this.courseRepository = new CourseRepository();
        this.trainerRepository = new TrainerRepository();
        this.traineeRepository = new TraineeRepository();
        this.exerciseRepository = new ExerciseRepository();
    }

    public DataService() {
        this.courseRepository = new CourseRepository();
        this.trainerRepository = new TrainerRepository();
        this.traineeRepository = new TraineeRepository();
        this.exerciseRepository = new ExerciseRepository();
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
     * Trainee remove a course from the favorites
     * @param courseId the id of the course to be removed
     * @return true if success and false if fail
     */
    public boolean traineeDeleteCourse(String courseId){
        boolean result = traineeRepository.deleteCourse(trainee,courseId);
        refresh();
        return result;
    }

    /**
     * Trainee remove a trainer from the favorites
     * @param trainerId the id of the course to be removed
     * @return true if success and false if fail
     */
    public boolean traineeDeleteTrainer(String trainerId){
        boolean result = traineeRepository.deleteTrainer(trainee,trainerId);
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
     * A trainee create a new exercise
     * @param TrainerId the trainer's id
     * @param date the date of the exercise
     * @param timestamp a int range from 0 to 12 related to 24h per day
     * @param description the detail information
     * @return true if success and false if fail
     */
    public boolean traineeCreateExercise(String TrainerId, Date date, int timestamp, String description){
        Exercise exercise = new Exercise();
        exercise.setTraineeId(trainee.getUserId());
        exercise.setDate(date);
        exercise.setTrainerId(TrainerId);
        exercise.setDescription(description);
        exercise.setTimeStamp(timestamp);
        boolean result = traineeRepository.createExercise(trainee,exercise);
        refresh();
        return result;
    }

    /**
     * Trainee cancel an existed exercise
     * @param exerciseId the id of the exercise to be canceled
     * @return true if success and false if fail
     */
    public boolean traineeCancelExercise(String exerciseId){
        boolean result = traineeRepository.cancelExercise(trainee,exerciseId);
        refresh();
        return result;
    }

    /**
     * Change the membership type for a trainee
     * @param category 1 for Normal, 2 for Member and 3 for VIP Member
     * @return true if success and false if fail
     */
    public boolean traineeChangeMembership(int category){
        boolean result = traineeRepository.registerMembership(trainee, category);
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
