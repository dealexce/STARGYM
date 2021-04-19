package Repository;

import Data.Trainee;
import Data.Trainer;

/**
 * @author Chuxing, Fang
 * @version 1.1
 */
public class TrainerRepository extends DataRepository {
    public TrainerRepository() {
        super(Path.TRAINER);
    }

    /**
     * Add a trainer as a serial file
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
     * @param id User id
     * @param password Password
     * @return true if success and false if fail
     */
    public boolean login(String id, String password){
        Trainer result = getById(id);
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
        Trainer trainer = new Trainer();
        trainer.setUserId(getNextId());
        trainer.setUserName(username);
        trainer.setPassWord(password);
        return add(trainer);
    }
}
