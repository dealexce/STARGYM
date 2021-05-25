package Repository;

import Data.Course;

import java.io.*;
import java.util.*;

/**
 * @author Chuxing, Fang
 * @version 1.0
 */
public class CourseRepository extends DataRepository {

    public CourseRepository() {
        super(Path.COURSE);
    }

    /**
     * Add or update a course as a serial file
     *
     * @param course Trainee object
     * @return True if success and false if fail
     */
    public boolean add(Course course) {
        String fileName = course.getCourseId() + ".ser";
        return super.add(course, fileName);
    }

    /**
     * Get a course object by its id
     *
     * @param id The course's id
     * @return The course object if success and null if fail
     */
    public Course getById(String id) {
        return (Course) super.getById(id);
    }

    /**
     * Get all the course information
     * @return All the existed courses
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public List<Course> getALL(){
        String path = this.getFilePath();
        List<String> files = new ArrayList<String>();
        List<Course> courses = new ArrayList<>();
        File file = new File(path);
        File[] tempList = file.listFiles();
        try{
            for (int i = 0; i < (tempList != null ? tempList.length : 0); i++) {
                if (tempList[i].isFile()) {
                    FileInputStream inputStream = new FileInputStream(tempList[i]);
                    ObjectInputStream out = new ObjectInputStream(inputStream);
                    courses.add((Course)out.readObject());
                }
            }
        }catch (IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
        return courses;
    }
}
