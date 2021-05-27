package UI.Controller;

import UI.Page;
import UI.Path;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

import Util.FormatUtil;

public class RegisterController extends Page {
    /**
     * @description: Controller of RegisterPage
     * @author: Haopu Chen
     **/
    @FXML
    private TextField username,password,passwordConfirm,phone;
    @FXML
    private RadioButton member, trainer;

    @Override
    public String getLocalPath() {
        return Path.HOME;
    }

    public void register(ActionEvent actionEvent) {
        StringBuilder noticeStringBuilder = new StringBuilder();
        if(!FormatUtil.checkPassword(password.getText())){
            noticeStringBuilder.append("A password must be 6-20 digits of letters, numbers, and underlines;\n");
        }
        if(!FormatUtil.checkTelephone(phone.getText())){
            noticeStringBuilder.append("A telephone number must has 11 numbers and starts with 1;\n");
        }
        if(!password.getText().equals(passwordConfirm.getText())){
            noticeStringBuilder.append("Two passwords are not identical\n");
        }
        if(noticeStringBuilder.length()!=0){
            notice("Information Check",noticeStringBuilder.toString(), Alert.AlertType.WARNING);
            return;
        }
        String id;
        if(member.isSelected()){
            id = this.stageManager.getDataService().registerAsTrainee(username.getText(),password.getText());
        }else{
            id = this.stageManager.getDataService().registerAsTrainer(username.getText(),password.getText());
        }
        notice("SUCCESS",
                "Registered successfully! Please remember your id to login:" + id,
                Alert.AlertType.CONFIRMATION);

        this.stageManager.stageRedirect(Path.REGISTER,Path.LOGIN);

    }

    public void goLogin(ActionEvent actionEvent) {
        this.stageManager.closeStage(Path.REGISTER);
        this.stageManager.openStage(Path.LOGIN);
    }
}
