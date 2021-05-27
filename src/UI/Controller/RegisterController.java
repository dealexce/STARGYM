package UI.Controller;

import Data.Trainee;
import UI.ManagedPage;
import UI.Path;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import java.io.IOException;

import Repository.TraineeRepository;

public class RegisterController extends ManagedPage {
    /**
     * @description: Controller of RegisterPage
     * @author: Haopu Chen
     **/
    @FXML
    private TextField username,password,passwordConfirm;
    @FXML
    private RadioButton member, trainer;

    public void register(ActionEvent actionEvent) {
        if(password.getText().equals(passwordConfirm.getText())){
            String id;
            if(member.isSelected()){
                id = this.stageManager.getDataService().registerAsTrainee(username.getText(),password.getText());
            }else{
                id = this.stageManager.getDataService().registerAsTrainer(username.getText(),password.getText());
            }

            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Success");
            alert.setContentText("Registered successfully! Please remember your id to login:" + id);
            alert.showAndWait();
            this.stageManager.closeStage(Path.REGISTER);
            this.stageManager.openStage(Path.LOGIN);
        }else{
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Password Confirm");
            alert.setContentText("Two passwords did not match, please retry.");
            alert.showAndWait();
        }

    }


    public void goLogin(ActionEvent actionEvent) {
        this.stageManager.closeStage(Path.REGISTER);
        this.stageManager.openStage(Path.LOGIN);
    }
}
