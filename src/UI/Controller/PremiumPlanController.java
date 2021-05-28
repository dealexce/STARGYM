package UI.Controller;

import UI.Page;
import UI.Path;
import javafx.scene.input.MouseEvent;

/**
 * @description: Controller of PremiumPlanPage
 * @author: Haopu Chen
 **/
public class PremiumPlanController extends Page {
    public void goHome(MouseEvent mouseEvent) {
        this.stageManager.openStage(Path.HOME);
    }

    @Override
    public String getLocalPath() {
        return Path.VIPREGISTER;
    }




}
