package Repository;

import Data.Trainer;

/**
 * @author Chuxing, Fang
 * @version 1.0
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
}
