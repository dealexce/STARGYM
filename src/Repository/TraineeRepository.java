package Repository;

import Data.Course;
import Data.Trainee;
import Data.Trainer;

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
    public boolean register(String username, String password) {
        Trainee trainee = new Trainee();
        trainee.setUserId(getNextId());
        trainee.setUserName(username);
        trainee.setPassWord(password);
        return add(trainee);
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
}
