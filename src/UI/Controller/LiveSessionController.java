package UI.Controller;

import Data.Course;
import UI.Page;
import UI.Path;
import UI.StageManager;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

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
        String trainerURL = System.getProperty("user.dir")+ "\\Resources\\Trainers\\T1.png";
        String connectURL = System.getProperty("user.dir")+ "\\Resources\\Contact\\connect.gif";
        String traineeURL = System.getProperty("user.dir")+ "\\Resources\\Trainee\\OIP.jpg";
        Image trainerImg = new Image("file:"+trainerURL);
        Image connectImg = new Image("file:"+connectURL);
        Image traineeImg = new Image("file:"+traineeURL);
        trainer.setImage(trainerImg);
        connect.setImage(connectImg);
        trainee.setImage(traineeImg);
    }
}
