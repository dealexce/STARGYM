package UI;

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
}
