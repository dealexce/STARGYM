package UI.Controller;

import UI.ManagedPage;
import UI.Path;
import UI.StageManager;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

import java.io.IOException;

/**
 * @description: Controller of MemberPersonalPage
 * @author: Haopu Chen
 **/
public class MemberPersonalPageController extends ManagedPage {
    public MemberPersonalPageController(){super();}
    public MemberPersonalPageController(StageManager stageManager) {
        super(stageManager);
    }

    @FXML
        private Label name;
    @FXML
    public void viewPremium(MouseEvent mouseEvent) {
        this.stageManager.openStage(Path.PREMIUM);
    }

    @Override
    public void init() {
        name.setText(this.stageManager.getDataService().getTrainee().getUserName());
    }
}
