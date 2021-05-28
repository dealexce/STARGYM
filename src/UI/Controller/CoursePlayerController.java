package UI.Controller;

import Data.Course;
import Data.Exercise;
import Data.Trainee;
import Data.Trainer;
import UI.Page;
import UI.Path;
import UI.StageManager;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;

import java.util.List;

/**
 * @description: Controller of MemberPersonalPage
 * @author: Haopu Chen
 **/
public class CoursePlayerController extends Page {
    public CoursePlayerController(){super();}
    public CoursePlayerController(StageManager stageManager) {
        super(stageManager);
    }

    @FXML
    private Label courseTitle,trainerName,introduction;
    @FXML
    private ImageView playerContent;

    @Override
    public String getLocalPath() {
        return Path.COURSEPLAYER;
    }

    public void init(Object o) {
        Course course;
        try{
            course = (Course)o;
        }catch (Exception e){
            e.printStackTrace();
            return;
        }
        if(course!=null){
            courseTitle.setText(course.getTitle());
            trainerName.setText(course.getTrainerId());
            introduction.setText(course.getCover());
            String url = System.getProperty("user.dir")+ "\\Resources\\Player\\V1.gif";
            Image img = new Image("file:"+url);
            playerContent.setImage(img);
        }
    }

    public void goHome(){
        this.stageManager.stageRedirect(getLocalPath(),Path.HOME);
    }

}
