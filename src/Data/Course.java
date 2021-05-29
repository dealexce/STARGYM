package Data;

import java.io.Serializable;

/**
 * @author Chuxing, Fang
 * @version 1.0
 * Data class of the course
 */
public class Course implements Serializable {
    private static final long serialVersionUID = 2813118854261470444L;
    private String courseId;
    private String trainerId;
    private String title;
    private String type;
    private String description;
    // The file path of the cover image
    private String cover;

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String video) {
        this.description = video;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTrainerId() {
        return trainerId;
    }

    public void setTrainerId(String trainerId) {
        this.trainerId = trainerId;
    }

}
