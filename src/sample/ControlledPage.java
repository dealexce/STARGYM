package sample;

public abstract class ControlledPage {
    protected StageController stageController;
    public ControlledPage(StageController stageController){
        this.setStageController(stageController);
    }
    public void setStageController(StageController stageController) {
        this.stageController = stageController;
    }
}
