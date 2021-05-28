package UI.Controller;

import UI.ManagedPage;
import UI.Path;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class VIPRegister extends ManagedPage{
    @FXML
    public static final String path = Path.ALLTRAINERS;
    public void goHome(ActionEvent actionEvent) {
        this.stageManager.stageRedirect(path,Path.HOME);
    }
    @FXML
    private Button ViewNormal, ViewMember, ViewVip;

    @FXML
    void ViewVIP_Event(ActionEvent event){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Introduction");
        alert.setContentText("Level 1 & Level 2 Trainers are both available.");
    }
    @FXML
    void ViewNormal_Event(ActionEvent event){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Introduction");
        alert.setContentText("Only Courses are available. Cannot book any exercise");
    }
    @FXML
    void ViewMember_Event(ActionEvent event){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Introduction");
        alert.setContentText("Only Level 1 Trainers are available");}
}
