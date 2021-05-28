package UI.Controller;

import Data.Course;
import Data.Exercise;
import Data.Trainee;
import Data.Trainer;
import UI.Page;
import UI.Path;
import Util.UserUtil;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.util.Callback;

import java.time.LocalDate;
import java.util.List;

/**
 * @description: Controller of AllTrainersPage
 * @author: Haopu Chen
 **/
public class CreateCourseController extends Page {
    @FXML
    private TextField title,type;
    @FXML
    private TextArea description;

    private Trainer trainer;
    @Override
    public String getLocalPath() {
        return Path.CREATECOURSE;
    }

    @Override
    public void init() {
        this.trainer = this.stageManager.getDataService().getTrainer();
    }

    private String infoNotValidString(){
        StringBuilder stringBuilder = new StringBuilder();
        if(title.getText().isEmpty())
            stringBuilder.append("Please determine the topic of this course;\n");
        if(type.getText().isEmpty())
            stringBuilder.append("Please determine the type of this course;\n");
        if(description.getText().isEmpty())
            stringBuilder.append("Pleas make some description for this course;\n");
        return stringBuilder.toString();
    }

    @FXML
    private void publish(){
        String validString = infoNotValidString();
        if(!validString.isEmpty()){
            notice("Fail",validString, Alert.AlertType.WARNING);
            return;
        }
        if(trainer==null){
            notice("Fail","Unavailable trainer", Alert.AlertType.ERROR);
            return;
        }
        this.stageManager.getDataService().trainerCreateCourse(title.getText(),type.getText(),description.getText());
        this.stageManager.closeStage(getLocalPath());
        this.stageManager.stageRefresh(Path.TRAINERPERSONAL);
        this.stageManager.stageRefresh(Path.TRAINERMYCOURSE);
    }

    @FXML
    void goBack(){this.stageManager.stageRedirect(getLocalPath(),Path.TRAINERPERSONAL);}

}
