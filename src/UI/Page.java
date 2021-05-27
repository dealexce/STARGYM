package UI;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public abstract class Page implements Managed{
    protected StageManager stageManager;
    protected String localPath;
    public Page() { this.setStageManager(null); }
    public Page(StageManager stageManager){
        this.setStageManager(stageManager);
    }

    /**
     * Set the StageController to this ControlledPage
     * @param stageManager StageController to this Stage
     */
    public void setStageManager(StageManager stageManager) {
        this.stageManager = stageManager;
    }

    @Override
    public void init(){

    }

    public void init(Object o) {
        init();
    }

    protected void notice(String title, String message, Alert.AlertType type){
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }

    protected boolean confirm(String title, String message){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle(title);
        alert.setContentText(message);
        Optional<ButtonType> result = alert.showAndWait();
        return result.filter(buttonType -> buttonType == ButtonType.OK).isPresent();
    }

}
