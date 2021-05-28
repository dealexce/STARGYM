package Data;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * @author Chuxing, Fang
 * @version 1.0
 * Data class of the live session (exercise)
 */
public class Exercise implements Serializable {


    private static final long serialVersionUID = -4333716633146060344L;
    private String exerciseId;
    private String trainerId;
    private String traineeId;
    private LocalDate date;
    // range from 0 to 12 related to 24h per day
    private int timeStamp;
    private String description;

    public String getTrainerId() {
        return trainerId;
    }

    public void setTrainerId(String trainerId) {
        this.trainerId = trainerId;
    }

    public String getTraineeId() {
        return traineeId;
    }

    public void setTraineeId(String traineeId) {
        this.traineeId = traineeId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(int timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getExerciseId() {
        return exerciseId;
    }

    public void setExerciseId(String exerciseId) {
        this.exerciseId = exerciseId;
    }
}
