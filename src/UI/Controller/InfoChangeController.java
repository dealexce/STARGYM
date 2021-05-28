package UI.Controller;

import Data.Trainee;
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

    @Override
    public String getLocalPath() {
        return Path.INFOCHANGE;
    }

    @Override
    public void init() {
        trainee = stageManager.getDataService().getTrainee();
        sex.getItems().addAll("Male","Female","Other");
        sex.getSelectionModel().select(trainee.getSex());

        name.setText(trainee.getUserName());
        height.setText(String.valueOf(trainee.getHeight()));
        weight.setText(String.valueOf(trainee.getWeight()));
        telephone.setText(trainee.getTelephone());
        password.setText(trainee.getPassWord());
    }


    @FXML
    private void saveChange(){
        String checkString = infoCheck();
        if(!checkString.isEmpty()){
            notice("Please check",checkString, Alert.AlertType.INFORMATION);
            return;
        }
        trainee.setUserName(name.getText());
        trainee.setSex(sex.getValue());
        trainee.setHeight(Integer.parseInt(height.getText()));
        trainee.setWeight(Integer.parseInt(weight.getText()));
        trainee.setTelephone(telephone.getText());
        trainee.setPassWord(password.getText());
        stageManager.getDataService().traineeChangeInfo(trainee);
        this.stageManager.stageRedirect(getLocalPath(),Path.MEMBERPERSONAL);
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
