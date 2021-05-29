package UI.Controller;

import Data.Trainee;
import Data.Trainer;
import UI.Page;
import UI.Path;
import Util.FormatUtil;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.text.Normalizer;

/**
 * @description: Controller of AllTrainersPage
 * @author: Haopu Chen
 **/
public class InfoChangeController extends Page {
    @FXML
    private TextField name,height, weight, telephone, password;
    @FXML
    private ComboBox<String> sex;

    private Trainee trainee;
    private Trainer trainer;

    @Override
    public String getLocalPath() {
        return Path.INFOCHANGE;
    }

    @Override
    public void init() {
        if(stageManager.getDataService().getTrainee() != null){
            trainee = stageManager.getDataService().getTrainee();
            generateInit(trainee.getSex(), trainee.getUserName(), trainee.getHeight(), trainee.getWeight(), trainee.getTelephone(), trainee.getPassWord());
        }else if(stageManager.getDataService().getTrainer() != null){
            trainer = stageManager.getDataService().getTrainer();
            generateInit(trainer.getSex(), trainer.getUserName(), trainer.getHeight(), trainer.getWeight(), trainer.getTelephone(), trainer.getPassWord());
        }

    }

    private void generateInit(String sex, String userName, int height, int weight, String telephone, String passWord) {
        this.sex.getItems().addAll("Male","Female","Other");
        this.sex.getSelectionModel().select(sex);

        name.setText(userName);
        this.height.setText(String.valueOf(height));
        this.weight.setText(String.valueOf(weight));
        this.telephone.setText(telephone);
        password.setText(passWord);
    }


    @FXML
    private void saveChange(){
        String checkString = infoCheck();
        if(!checkString.isEmpty()){
            notice("Please check",checkString, Alert.AlertType.INFORMATION);
            return;
        }
        if(stageManager.getDataService().getTrainee() != null){
            trainee.setUserName(name.getText());
            trainee.setSex(sex.getValue());
            trainee.setHeight(Integer.parseInt(height.getText()));
            trainee.setWeight(Integer.parseInt(weight.getText()));
            trainee.setTelephone(telephone.getText());
            trainee.setPassWord(password.getText());
            stageManager.getDataService().traineeChangeInfo(trainee);
            this.stageManager.stageRedirect(getLocalPath(),Path.MEMBERPERSONAL);
        }else if(stageManager.getDataService().getTrainer() != null){
            trainer.setUserName(name.getText());
            trainer.setSex(sex.getValue());
            trainer.setHeight(Integer.parseInt(height.getText()));
            trainer.setWeight(Integer.parseInt(weight.getText()));
            trainer.setTelephone(telephone.getText());
            trainer.setPassWord(password.getText());
            stageManager.getDataService().trainerChangeInfo(trainer);
            this.stageManager.stageRedirect(getLocalPath(),Path.TRAINERPERSONAL);
        }

    }

    private String infoCheck(){
        StringBuilder stringBuilder = new StringBuilder();
        if(name.getText().isEmpty()){
            stringBuilder.append("Please provide your name;\n");
        }
        if(sex.getValue().isEmpty()){
            stringBuilder.append("Please select your gender;\n");
        }
        if(height.getText().isEmpty()|| !FormatUtil.isInteger(height.getText())){
            stringBuilder.append("Please provide your height in integer;\n");
        }
        if(weight.getText().isEmpty()|| !FormatUtil.isInteger(height.getText())){
            stringBuilder.append("Please provide your weight in integer;\n");
        }
        if(!FormatUtil.checkTelephone(telephone.getText())){
            stringBuilder.append("telephone number must has 11 numbers and starts with 1;\n");
        }
        if(!FormatUtil.checkPassword(password.getText())){
            stringBuilder.append("A password must be 6-20 digits of letters, numbers, or underscores;\n");
        }
        return stringBuilder.toString();
    }

    @FXML
    void goBack(){
        this.stageManager.stageRedirect(getLocalPath(),Path.MEMBERPERSONAL);
        this.stageManager.stageRefresh(Path.MEMBERPERSONAL);
    }

}
