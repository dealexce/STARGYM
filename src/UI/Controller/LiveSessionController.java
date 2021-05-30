package UI.Controller;

import Data.Course;
import UI.Page;
import UI.Path;
import UI.StageManager;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;

/**
 * @description: Controller of MemberPersonalPage
 * @author: Haopu Chen
 **/
public class LiveSessionController extends Page {
    public LiveSessionController(){super();}
    public LiveSessionController(StageManager stageManager) {
        super(stageManager);
    }

    @FXML
    private ImageView trainer, trainee, connect;

    @Override
    public String getLocalPath() {
        return Path.LIVESESSION;
    }

    @Override
    public void init() {
        String trainerURL = Path.RESOURCE+ File.separator+"Trainers"+File.separator+"T1.png";
        String connectURL = Path.RESOURCE+ File.separator+"Contact"+File.separator+"connect.gif";
        String traineeURL = Path.RESOURCE+ File.separator+"Trainee"+File.separator+"OIP.jpg";
        Image trainerImg = new Image("file:"+trainerURL);
        Image connectImg = new Image("file:"+connectURL);
        Image traineeImg = new Image("file:"+traineeURL);
        trainer.setImage(trainerImg);
        connect.setImage(connectImg);
        trainee.setImage(traineeImg);
    }
}
