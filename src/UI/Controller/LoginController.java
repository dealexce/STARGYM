package UI.Controller;

import UI.Page;
import UI.Path;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;


/**
 * @description: Controller of LoginPage
 * @author: Haopu Chen
 **/
public class LoginController extends Page {
    @FXML
    private RadioButton member,trainer;
    @FXML
    private TextField userId,password;

    @Override
    public String getLocalPath() {
        return Path.LOGIN;
    }

    public void login() {
        if(member.isSelected()){
            if(this.stageManager.getDataService().loginAsTrainee(userId.getText(),password.getText())){
                this.stageManager.closeStage(Path.LOGIN);
                this.stageManager.openStage(Path.HOME);
            }else{
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Login Fail");
                alert.setContentText("Login failed, please check your id and password");
                alert.showAndWait();
            }
        }else{
            if(this.stageManager.getDataService().loginAsTrainer(userId.getText(),password.getText())){
                stageManager.stageRedirect(getLocalPath(),Path.TRAINERPERSONAL);
            }else{
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Login Fail");
                alert.setContentText("Login failed, please check your id and password");
                alert.showAndWait();
            }
        }


    }

    public void goRegister() {
        this.stageManager.closeStage(Path.LOGIN);
        this.stageManager.openStage(Path.REGISTER);
    }
}
