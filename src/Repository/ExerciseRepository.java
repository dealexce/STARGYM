package Repository;

import Data.Course;
import Data.Exercise;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Chuxing, Fang
 * @version 1.0
 */
public class ExerciseRepository extends DataRepository{
    public ExerciseRepository() {
        super(Path.EXERCISE);
    }

    /**
     * Add or update a exercise as a serial file
     *
     * @param exercise exercise object
     * @return True if success and false if fail
     */
    public boolean add(Exercise exercise) {
        String fileName = exercise.getExerciseId() + ".ser";
        return super.add(exercise, fileName);
    }

    /**
     * Get a exercise object by its id
     *
     * @param id The exercise's id
     * @return The exercise object if success and null if fail
     */
    public Exercise getById(String id) {
        return (Exercise) super.getById(id);
    }

    /**
     * Get all the exercise information
     * @return All the existed exercises
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public List<Exercise> getALL(){
        String path = this.getFilePath();
        List<String> files = new ArrayList<String>();
        List<Exercise> exercises = new ArrayList<>();
        File file = new File(path);
        File[] tempList = file.listFiles();
        try{
            for (int i = 0; i < (tempList != null ? tempList.length : 0); i++) {
                if (tempList[i].isFile()) {
                    FileInputStream inputStream = new FileInputStream(tempList[i]);
                    ObjectInputStream out = new ObjectInputStream(inputStream);
                    exercises.add((Exercise) out.readObject());
                }
            }
        }catch (IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
        return exercises;
    }
}
