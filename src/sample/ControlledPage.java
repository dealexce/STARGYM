package sample;

public abstract class ControlledPage {
    protected StageController stageController;
    public ControlledPage(StageController stageController){
        this.setStageController(stageController);
    }

    /**
     * Set the StageController to this ControlledPage
     * @param stageController StageController to this Stage
     */
    public void setStageController(StageController stageController) {
        this.stageController = stageController;
    }
}
