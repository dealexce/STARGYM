package UI;

import javafx.fxml.FXML;
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
    public void viewPremium(MouseEvent mouseEvent) {
        this.stageManager.openStage(Path.PREMIUM);
    }
}
