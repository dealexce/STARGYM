package UI;

import javafx.stage.Stage;

import java.util.HashMap;
import java.util.Map;

public class StageController {
    private HashMap<String, Stage> stages = new HashMap<String, Stage>();
    public StageController(){
    }

    /**
     * Add a new stage into this StageController
     * @param name name of this new Stage
     * @param stage the new Stage
     */
    public void addStage(String name, Stage stage){
        stages.put(name, stage);
    }

    /**
     * get the stage with respond to given name
     * @param name the name of the Stage to get
     * @return the wanting Stage
     */
    public Stage getStage(String name){
        return stages.get(name);
    }

    /**
     * show the stage with respond to given name
     * @param name name of the stage to show
     */
    public void showStage(String name){
        stages.get(name).show();
    }

    /**
     * Close the old stage, and show the new stage
     * @param oldPage name of the old Stage
     * @param newPage name of the new Stage
     */
    public void switchStage(String oldPage,String newPage){
        closeStage(oldPage);
        showStage(newPage);
    }

    /**
     * Close the stage with respond to given name
     * @param name name of the stage to close
     */
    public void closeStage(String name){
        stages.get(name).close();
    }

    /**
     * Close all stages in the hashmap
     */
    public void closeAllStage(){
        for(Map.Entry<String,Stage> entry:stages.entrySet()){
            entry.getValue().close();
        }
    }

    /**
     * Unload the stage response to given stage name, remove it from the hashmap
     * @param name name of the stage to unload
     * @return true if successfully removed, false if no such a stage to remove
     */
    public boolean unloadStage(String name){
        if(stages.get(name)!=null){
            stages.get(name).close();
            stages.remove(name);
            System.out.println("Removed stage: "+name);
            return true;
        }else{
            System.out.println("Removing non-existing stage: "+name);
            return false;
        }
    }




}
