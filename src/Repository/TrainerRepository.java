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
public class TrainerRepository extends DataRepository {
    public TrainerRepository() {
        super(Path.TRAINER);
    }

    /**
     * Add or update a trainer as a serial file
     *
     * @param trainer Trainer object
     * @return True if success and false if fail
     */
    public boolean add(Trainer trainer) {
        String fileName = trainer.getUserId() + ".ser";
        return super.add(trainer, fileName);
    }

    /**
     * Get a trainer object by its id
     *
     * @param id The trainer's id
     * @return The trainer object if success and null if fail
     */
    public Trainer getById(String id) {
        return (Trainer) super.getById(id);

    }

    /**
     * Login with user id and password
     *
     * @param id       User id
     * @param password Password
     * @return true if success and false if fail
     */
    public boolean login(String id, String password) {
        Trainer result = getById(id);
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
        Trainer trainer = new Trainer();
        trainer.setUserId(getNextId());
        trainer.setUserName(username);
        trainer.setPassWord(password);
        return add(trainer);
    }

    /**
     * Add a trainee to a trainer's list according to the trainee's id
     *
     * @param trainer   the trainer object
     * @param traineeID the trainee's id
     * @return true if success and false if fail
     */
    public boolean addTrainee(Trainer trainer, String traineeID) {
        List<Trainee> temp = trainer.getMyTrainees();
        TraineeRepository traineeRepository = new TraineeRepository();
        Trainee trainee = traineeRepository.getById(traineeID);
        if (trainee == null) {
            return false;
        } else {
            temp.add(trainee);
            trainer.setMyTrainees(temp);
            return add(trainer);
        }
    }

    /**
     * Delete a trainee from a trainer's list
     *
     * @param trainer   the trainer object
     * @param traineeID the trainee's id
     * @return true if success and false if fail
     */
    public boolean deleteTrainee(Trainer trainer, String traineeID) {
        List<Trainee> temp = trainer.getMyTrainees();
        Iterator<Trainee> iter = temp.iterator();
        while (iter.hasNext()) {
            Trainee elem = iter.next();
            if (elem.getUserId().equals(traineeID)) {
                temp.remove(elem);
                trainer.setMyTrainees(temp);
                return add(trainer);
            }
        }
        // if not find the id then return false
        return false;
    }

    /**
     * Add a course to a trainer's own list according to the course id
     *
     * @param trainer  the trainer object
     * @param courseID the id of the course
     * @return true if success and false if fail
     */
    public boolean addCourse(Trainer trainer, String courseID) {
        List<Course> temp = trainer.getMyCourses();
        CourseRepository courseRepository = new CourseRepository();
        Course course = courseRepository.getById(courseID);
        if (course == null) {
            return false;
        } else {
            temp.add(course);
            trainer.setMyCourses(temp);
            return add(trainer);
        }
    }

    /**
     * Delete a course from a trainee's own list
     *
     * @param trainer  the trainee object
     * @param courseID the id of the course
     * @return true if success and false if fail
     */
    public boolean deleteCourse(Trainer trainer, String courseID) {
        List<Course> temp = trainer.getMyCourses();
        Iterator<Course> iter = temp.iterator();
        while (iter.hasNext()) {
            Course elem = iter.next();
            if (elem.getCourseId().equals(courseID)) {
                temp.remove(elem);
                trainer.setMyCourses(temp);
                return add(trainer);
            }
        }
        // if not find the id then return false
        return false;
    }
}
