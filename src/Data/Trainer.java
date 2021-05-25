package Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author Chuxing, Fang
 * @version 1.0
 * Data class of trainer users
 */
public class Trainer extends User implements Serializable {
    private int level;
    private List<Trainee> myTrainees;
    private List<Course> myCourses;

    public Trainer(String userId, String userName, String passWord, String telephone, String sex) {
        super(userId, userName, passWord, telephone, sex);
    }

    public Trainer(){

    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public List<Trainee> getMyTrainees() {
        return myTrainees;
    }

    public void setMyTrainees(List<Trainee> myTrainees) {
        this.myTrainees = myTrainees;
    }

    public List<Course> getMyCourses() {
        return myCourses;
    }

    public void setMyCourses(List<Course> myCourses) {
        this.myCourses = myCourses;
    }

}
