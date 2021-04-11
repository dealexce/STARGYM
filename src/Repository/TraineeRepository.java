package Repository;

import Data.Trainee;

/**
 * @author Chuxing, Fang
 * @version 1.0
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
}
