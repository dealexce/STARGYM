package UI;

import Service.DataService;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class StageManager {
    private HashMap<String, Stage> stages = new HashMap<String, Stage>();
    private DataService dataService;

    public StageManager(){
        dataService = new DataService();
    }

    public DataService getDataService() {
        return dataService;
    }
    /**
     * Add a new stage into this StageManager
     * @param name name of this new Stage
     * @param stage the new Stage
     */
    public void addStage(String name, Stage stage){
        stages.put(name, stage);
    }

    public void openStage(String resource){
        Stage tempStage = stages.get(resource);
        if(tempStage!=null){
            tempStage.show();
            tempStage.toFront();
        }else{
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource(resource));
            Parent p = null;
            try {
                p = loader.load();
                Page page = (Page) loader.getController();
                page.setStageManager(this);
                page.init();


                Scene scene = new Scene(p);
                Stage stage = new Stage();
                stage.setScene(scene);
                this.addStage(resource,stage);
                this.showStage(resource);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void openStage(String resource,Object o){
        Stage tempStage = stages.get(resource);
        if(tempStage!=null){
            tempStage.show();
            tempStage.toFront();
        }else{
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource(resource));
            Parent p = null;
            try {
                p = loader.load();
                Page page = (Page) loader.getController();
                page.setStageManager(this);
                page.init(o);


                Scene scene = new Scene(p);
                Stage stage = new Stage();
                stage.setScene(scene);
                this.addStage(resource,stage);
                this.showStage(resource);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
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
     * Hide the old stage, and show the new stage
     * @param oldPage name of the old Stage
     * @param newPage name of the new Stage
     */
    public void switchStage(String oldPage,String newPage){
        hideStage(oldPage);
        showStage(newPage);
    }

    /**
     * Hide the stage with respond to given name
     * @param name name of the stage to close
     */
    public void hideStage(String name){
        stages.get(name).close();
    }

    /**
     * Hide all stages in the hashmap
     */
    public void hideAllStage(){
        for(Map.Entry<String,Stage> entry:stages.entrySet()){
            entry.getValue().close();
        }
    }

    /**
     * Unload the stage response to given stage name, remove it from the hashmap
     * @param name name of the stage to unload
     * @return true if successfully removed, false if no such a stage to remove
     */
    public boolean closeStage(String name){
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


    public void stageRedirect(String oldStageName, String newStageName){
        closeStage(oldStageName);
        openStage(newStageName);
    }

    public void stageRedirect(String oldStageName, String newStageName, Object o){
        closeStage(oldStageName);
        openStage(newStageName,o);
    }




}
