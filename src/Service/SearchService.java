package Service;

import Data.Course;
import Data.Trainee;
import Data.Trainer;

import java.util.*;

/**
 * The search function for the UI layer
 * @author Chuxing, Fang
 * @version 1.0
 */
public class SearchService {
    /**
     * Search in a course list by a keyword
     * @param keyword the searching keyword (dark search)
     * @param rawList the list to be searched
     * @return the result list
     */
    public static List<Course> searchCourse(String keyword, List<Course> rawList){
        List<Course> result = new ArrayList<>();
        for (Course c : rawList) {
            String title = c.getTitle();
            if(title.contains(keyword)){
                result.add(c);
            }
        }
        return result;
    }

    /**
     * Search for a trainer by his/her name
     * @param name the trainer's name (dark search)
     * @param rawList the list to be searched
     * @return the result list
     */
    public static List<Trainer> searchTrainer(String name, List<Trainer> rawList){
        List<Trainer> result = new ArrayList<>();
        for (Trainer c : rawList) {
            String userName = c.getUserName();
            if(userName.contains(name)){
                result.add(c);
            }
        }
        return result;
    }
}
