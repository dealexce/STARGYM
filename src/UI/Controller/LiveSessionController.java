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

    @Override
    public String getLocalPath() {
        return Path.LIVESESSION;
    }


}
