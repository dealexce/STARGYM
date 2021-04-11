package Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author Chuxing, Fang
 * @version 1.0
 * Data class of trainee users
 */
public class Trainee extends User implements Serializable {
    // Type of members of the user
    private String userType;
    private List<Course> favoriteCourses;
    private List<Trainer> favoriteTrainers;

    public Trainee(String userId, String userName, String passWord, String telephone, String sex) {
        super(userId, userName, passWord, telephone, sex);
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
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
