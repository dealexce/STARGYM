package UI;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

import java.io.IOException;

public class RegisterController extends ManagedPage{
    /**
     * @description: Controller of RegisterPage
     * @author: Haopu Chen
     **/
    @FXML
    private TextField username,password,passwordConfirm;

    public void register(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Success");
        alert.setContentText("Your account has been registered successfully!");
        alert.showAndWait();
        this.stageManager.closeStage(Path.REGISTER);
        this.stageManager.openStage(Path.LOGIN);
    }


    public void goLogin(ActionEvent actionEvent) {
        this.stageManager.closeStage(Path.REGISTER);
        this.stageManager.openStage(Path.LOGIN);
    }
}
