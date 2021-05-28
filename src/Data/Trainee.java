package Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Chuxing, Fang
 * @version 1.0
 * Data class of trainee users
 */
public class Trainee extends User implements Serializable {
    private static final long serialVersionUID = 4847083491969217078L;
    // Type of members of the user (Normal, Member and VIPMember)
    private int userType = 1;
    private List<Course> favoriteCourses = new ArrayList<>();
    private List<Trainer> favoriteTrainers = new ArrayList<>();
    private List<Exercise> myExercises = new ArrayList<>();

    public List<Exercise> getMyExercises() {
        return myExercises;
    }

    public void setMyExercises(List<Exercise> myExercises) {
        this.myExercises = myExercises;
    }

    public Trainee(String userId, String userName, String passWord, String telephone, String sex, int height, int weight) {
        super(userId, userName, passWord, telephone, sex, height, weight);
    }

    public Trainee(){}

    public int getUserType() {
        return userType;
    }

    public void setUserType(int userType) {
        this.userType = userType;
    }

    public List<Course> getFavoriteCourses() {
        return favoriteCourses;
    }

    public void setFavoriteCourses(List<Course> favoriteCourses) {
        this.favoriteCourses = favoriteCourses;
    }

    public List<Trainer> getFavoriteTrainers() {
        return favoriteTrainers;
    }

    public void setFavoriteTrainers(List<Trainer> favoriteTrainers) {
        this.favoriteTrainers = favoriteTrainers;
    }

}
