package UI;

import javafx.scene.input.MouseEvent;

import java.io.IOException;

/**
 * @description: Controller of PremiumPlanPage
 * @author: Haopu Chen
 **/
public class PremiumPlanController extends ManagedPage {
    public void goHome(MouseEvent mouseEvent) {
        this.stageManager.openStage(Path.HOME);
    }
}
