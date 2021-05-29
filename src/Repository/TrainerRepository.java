package Repository;

import Data.Course;
import Data.Exercise;
import Data.Trainee;
import Data.Trainer;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

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
    public Trainer register(String username, String password) {
        Trainer trainer = new Trainer();
        trainer.setUserId(getNextId("TR"));
        trainer.setUserName(username);
        trainer.setPassWord(password);
        Random random = new Random();
        trainer.setLevel(random.nextInt(2)+1);
        add(trainer);
        return trainer;
    }

    /**
     * Add a trainee to a trainer's list according to the trainee's id
     *
     * @param trainer   the trainer object
     * @param traineeID the trainee's id
     * @return true if success and false if fail
     */
    public boolean addTrainee(Trainer trainer, String traineeID) {
        List<Trainee> temp = new ArrayList<>();
        if(trainer.getMyTrainees() != null){
            temp = trainer.getMyTrainees();
        }
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
     * Trainer user create a course
     *
     * @param trainer  the trainer object
     * @param course the course object
     * @return true if success and false if fail
     */
    public boolean createCourse(Trainer trainer, Course course) {
        List<Course> temp = new ArrayList<>();
        if(trainer.getMyCourses()!=null){
            temp = trainer.getMyCourses();
        }
        CourseRepository courseRepository = new CourseRepository();
        if (course == null) {
            return false;
        } else {
            course.setCourseId(courseRepository.getNextId("CR"));
            course.setTrainerId(trainer.getUserId());
            courseRepository.add(course);
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

    /**
     * Get all the trainer information
     * @return All the existed trainers
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public List<Trainer> getALL(){
        String path = this.getFilePath();
        List<String> files = new ArrayList<String>();
        List<Trainer> trainers = new ArrayList<>();
        File file = new File(path);
        File[] tempList = file.listFiles();
        try{
            for (int i = 0; i < (tempList != null ? tempList.length : 0); i++) {
                if (tempList[i].isFile()) {
                    FileInputStream inputStream = new FileInputStream(tempList[i]);
                    ObjectInputStream out = new ObjectInputStream(inputStream);
                    trainers.add((Trainer) out.readObject());
                }
            }
        }catch (IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
        return trainers;
    }

    /**
     * Add an exercise to a trainer's exercises
     * @param trainer the trainer object
     * @param exercise the exercise object
     * @return
     */
    public boolean addMyExercises(Trainer trainer, Exercise exercise){
        List<Exercise> temp = new ArrayList<>();
        if(trainer.getMyExercises() != null){
            temp = trainer.getMyExercises();
        }
        if (exercise == null) {
            return false;
        } else {
            temp.add(exercise);
            trainer.setMyExercises(temp);
            return add(trainer);
        }
    }

    /**
     * delete an exercise from a trainer's exercises
     * @param trainer the trainer object
     * @param exerciseId the exercise id
     * @return
     */
    public boolean deleteExercise(Trainer trainer, String exerciseId){
        List<Exercise> temp = trainer.getMyExercises();
        Iterator<Exercise> iter = temp.iterator();
        while (iter.hasNext()) {
            Exercise elem = iter.next();
            if (elem.getExerciseId().equals(exerciseId)) {
                temp.remove(elem);
                trainer.setMyExercises(temp);
                return add(trainer);
            }
        }
        // if not find the id then return false
        return false;
    }
}
