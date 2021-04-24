package UI;

import javafx.event.ActionEvent;

/**
 * @description: Controller of AllTrainersPage
 * @author: Haopu Chen
 **/
public class AllTrainersController extends ManagedPage{
    public static final String path = Path.ALLTRAINERS;
    public void goHome(ActionEvent actionEvent) {
        this.stageManager.stageRedirect(path,Path.HOME);
    }
}
