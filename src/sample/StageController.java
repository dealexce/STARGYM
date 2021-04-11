package sample;

import javafx.application.Application;
import javafx.stage.Stage;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class StageController {
    private HashMap<String, Stage> stages = new HashMap<String, Stage>();
    public StageController(){
    }

    public void addStage(String name, Stage stage){
        stages.put(name, stage);
    }

    public Stage getStage(String name){
        return stages.get(name);
    }

    public void showStage(String name){
        stages.get(name).show();
    }

    public void switchStage(String oldPage,String newPage){
        closeStage(oldPage);
        showStage(newPage);
    }

    public void closeStage(String name){
        stages.get(name).close();
    }

    public void closeAllStage(){
        for(Map.Entry<String,Stage> entry:stages.entrySet()){
            entry.getValue().close();
        }
    }

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
