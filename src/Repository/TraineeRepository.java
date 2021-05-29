package Repository;

import Data.Course;
import Data.Exercise;
import Data.Trainee;
import Data.Trainer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author Chuxing, Fang
 * @version 1.2
 */
public class TraineeRepository extends DataRepository {

    public TraineeRepository() {
        super(Path.TRAINEE);
    }

    /**
     * Add or update a trainee as a serial file
     *
     * @param trainee Trainee object
     * @return True if success and false if fail
     */
    public boolean add(Trainee trainee) {
        String fileName = trainee.getUserId() + ".ser";
        return super.add(trainee, fileName);
    }

    /**
     * Get a trainee object by its id
     *
     * @param id The trainee's id
     * @return The trainee object if success and null if fail
     */
    public Trainee getById(String id) {
        return (Trainee) super.getById(id);
    }

    /**
     * Login with user id and password
     *
     * @param id       User id
     * @param password Password
     * @return true if success and false if fail
     */
    public boolean login(String id, String password) {
        Trainee result = getById(id);
        if (result == null) {
            return false;
        } else return result.getPassWord().equals(password);
    }

    /**
     * Register a new trainee
     *
     * @param username The user's name
     * @param password The user's password
     * @return true if success and false if fail
     */
    public Trainee register(String username, String password) {
        Trainee trainee = new Trainee();
        trainee.setUserId(getNextId("TE"));
        trainee.setUserName(username);
        trainee.setPassWord(password);
        add(trainee);
        return trainee;
    }

    /**
     * Add a trainer to a trainee's favorite according to the trainer's id
     *
     * @param trainee   the trainee object
     * @param trainerID the trainer's id
     * @return true if success and false if fail
     */
    public boolean addTrainer(Trainee trainee, String trainerID) {
        List<Trainer> temp = trainee.getFavoriteTrainers();
        TrainerRepository trainerRepository = new TrainerRepository();
        Trainer trainer = trainerRepository.getById(trainerID);
        if (trainer == null) {
            return false;
        } else {
            if(temp.contains(trainer)){
                return true;
            }
            temp.add(trainer);
            trainee.setFavoriteTrainers(temp);
            return add(trainee);
        }
    }

    /**
     * Delete a trainer from a trainee's favorite
     *
     * @param trainee   the trainee object
     * @param trainerID the trainer's id
     * @return true if success and false if fail
     */
    public boolean deleteTrainer(Trainee trainee, String trainerID) {
        List<Trainer> temp = trainee.getFavoriteTrainers();
        Iterator<Trainer> iter = temp.iterator();
        while (iter.hasNext()) {
            Trainer elem = iter.next();
            if (elem.getUserId().equals(trainerID)) {
                temp.remove(elem);
                trainee.setFavoriteTrainers(temp);
                return add(trainee);
            }
        }
        // if not find the id then return false
        return false;
    }

    /**
     * Add a course to a trainee's favorite according to the course id
     *
     * @param trainee  the trainee object
     * @param courseID the id of the course
     * @return true if success and false if fail
     */
    public boolean addCourse(Trainee trainee, String courseID) {
        List<Course> temp = trainee.getFavoriteCourses();
        CourseRepository courseRepository = new CourseRepository();
        Course course = courseRepository.getById(courseID);
        if (course == null) {
            return false;
        } else {
            if(temp.contains(course)){
                return true;
            }
            temp.add(course);
            trainee.setFavoriteCourses(temp);
            return add(trainee);
        }
    }

    /**
     * Delete a course from a trainee's favorite
     *
     * @param trainee  the trainee object
     * @param courseID the id of the course
     * @return true if success and false if fail
     */
    public boolean deleteCourse(Trainee trainee, String courseID) {
        List<Course> temp = trainee.getFavoriteCourses();
        Iterator<Course> iter = temp.iterator();
        while (iter.hasNext()) {
            Course elem = iter.next();
            if (elem.getCourseId().equals(courseID)) {
                temp.remove(elem);
                trainee.setFavoriteCourses(temp);
                return add(trainee);
            }
        }
        // if not find the id then return false
        return false;
    }

    /**
     * create a new exercise, need to choose date, time, description and trainer
     * @param trainee the trainee object
     * @param exercise the exercise object
     * @return true if success and false if fail
     */
    public boolean createExercise(Trainee trainee, Exercise exercise){
        // initialize the exercise object
        exercise.setTraineeId(trainee.getUserId());
        ExerciseRepository exerciseRepository = new ExerciseRepository();
        exercise.setExerciseId(exerciseRepository.getNextId("EX"));
        exerciseRepository.add(exercise);
        // add the exercise to the corresponding trainer
        TrainerRepository trainerRepository = new TrainerRepository();
        Trainer trainer = trainerRepository.getById(exercise.getTrainerId());
        trainerRepository.addMyExercises(trainer, exercise);
        if(!trainerRepository.add(trainer)){
            return false;
        }
        // add the exercise to the corresponding trainee
        List<Exercise> temp = new ArrayList<>();
        if(trainee.getMyExercises() != null){
            temp = trainee.getMyExercises();
        }
        temp.add(exercise);
        trainee.setMyExercises(temp);
        return add(trainee);
    }

    /**
     * cancel a certain exercise
     * @param trainee the trainee object
     * @param exerciseId the id of the exercise
     * @return true if success and false if fail
     */
    public boolean cancelExercise(Trainee trainee, String exerciseId){
        ExerciseRepository exerciseRepository = new ExerciseRepository();
        TrainerRepository trainerRepository = new TrainerRepository();
        List<Exercise> exercises = trainee.getMyExercises();
        for (Exercise elem : exercises) {
            if (elem.getExerciseId().equals(exerciseId)) {
                Trainer trainer = trainerRepository.getById(elem.getTrainerId());
                trainerRepository.deleteExercise(trainer, elem.getExerciseId());
                exercises.remove(elem);
                trainee.setMyExercises(exercises);
                return add(trainee);
            }
        }
        // if not find the id then return false
        return false;
    }

    /**
     * register a trainee as a member
     * @param trainee the trainee member
     * @param category 1 for normal, 2 for member, 3 for VIP
     * @return true if success and false if fail
     */
    public boolean registerMembership(Trainee trainee, int category){
        trainee.setUserType(category);
        return add(trainee);
    }
}
