package UI;

import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;

public abstract class ManagedPage {
    protected StageManager stageManager;
    public ManagedPage() { this.setStageManager(null); }
    public ManagedPage(StageManager stageManager){
        this.setStageManager(stageManager);
    }

    /**
     * Set the StageController to this ControlledPage
     * @param stageManager StageController to this Stage
     */
    public void setStageManager(StageManager stageManager) {
        this.stageManager = stageManager;
    }
    public void init() {
    }
}
