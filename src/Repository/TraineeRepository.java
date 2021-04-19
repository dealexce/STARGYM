package Repository;

import Data.Trainee;
import Data.Trainer;

/**
 * @author Chuxing, Fang
 * @version 1.1
 */
public class TraineeRepository extends DataRepository {

    public TraineeRepository() {
        super(Path.TRAINEE);
    }

    /**
     * Add a trainee as a serial file
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
     * @param id User id
     * @param password Password
     * @return true if success and false if fail
     */
    public boolean login(String id, String password){
        Trainee result = getById(id);
        if(result == null){
            return false;
        }else return result.getPassWord().equals(password);
    }

    /**
     * Register a new trainee
     * @param username The user's name
     * @param password The user's password
     * @return true if success and false if fail
     */
    public boolean register(String username, String password){
        Trainee trainee = new Trainee();
        trainee.setUserId(getNextId());
        trainee.setUserName(username);
        trainee.setPassWord(password);
        return add(trainee);
    }
}
