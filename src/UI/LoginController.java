package UI;

import javafx.event.ActionEvent;


/**
 * @description: Controller of LoginPage
 * @author: Haopu Chen
 **/
public class LoginController extends ManagedPage{
    public void login(ActionEvent actionEvent) {
        this.stageManager.closeStage(Path.LOGIN);
        this.stageManager.openStage(Path.HOME);
    }

    public void goRegister(ActionEvent actionEvent) {
        this.stageManager.closeStage(Path.LOGIN);
        this.stageManager.openStage(Path.REGISTER);
    }
}
