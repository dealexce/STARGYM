package Repository;

import Data.Course;

/**
 * @author Chuxing, Fang
 * @version 1.0
 */
public class CourseRepository extends DataRepository {

    public CourseRepository() {
        super(Path.COURSE);
    }

    /**
     * Add a course as a serial file
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
}
