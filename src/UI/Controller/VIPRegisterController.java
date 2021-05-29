package UI.Controller;

import Data.Trainee;
import UI.Page;
import UI.Path;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.lang.reflect.Member;

public class VIPRegisterController extends Page {
    @FXML
    public static final String path = Path.ALLTRAINERS;
    public void goHome(ActionEvent actionEvent) {
        this.stageManager.stageRedirect(path,Path.HOME);
    }
    @FXML
    private Button ViewNormal, ViewMember, ViewVip, normalButton, memberButton, vipButton;
    @FXML
    private ImageView normal, member, vip;

    @Override
    public void init() {
        if(this.stageManager.getDataService().getTrainee()==null||!this.stageManager.getDataService().isLogin()){
            normalButton.setDisable(true);
            memberButton.setDisable(true);
            vipButton.setDisable(true);
            return;
        }
        int currentType = this.stageManager.getDataService().getTrainee().getUserType();
        if(currentType==1){
            normalButton.setText("Current");
            normalButton.setDisable(true);
        }
        if(currentType==2){
            normalButton.setDisable(true);
            memberButton.setText("Current");
            memberButton.setDisable(true);
        }
        if(currentType==3){
            normalButton.setDisable(true);
            normalButton.setDisable(true);
            vipButton.setText("Current");
            vipButton.setDisable(true);
        }
        String normalURL = System.getProperty("user.dir")+ "\\Resources\\VIP\\Normal.jpg";
        String memberURL = System.getProperty("user.dir")+ "\\Resources\\VIP\\Member.jpg";
        String vipURL = System.getProperty("user.dir")+ "\\Resources\\VIP\\VIP.jpg";
        Image normalImg = new Image("file:"+normalURL);
        Image memberImg = new Image("file:"+memberURL);
        Image vipImg = new Image("file:"+vipURL);
        normal.setImage(normalImg);
        member.setImage(memberImg);
        vip.setImage(vipImg);
    }

    @FXML
    void ViewVIP_Event(ActionEvent event){
        notice("Introduction","Level 1 & Level 2 Trainers are both available.",Alert.AlertType.INFORMATION);
    }
    @FXML
    void ViewNormal_Event(ActionEvent event){
        notice("Introduction","Only Courses are available. Cannot book any exercise",Alert.AlertType.INFORMATION);
    }
    @FXML
    void ViewMember_Event(ActionEvent event) {
        notice("Introduction", "Only Level 1 Trainers are available", Alert.AlertType.INFORMATION);
    }

    @FXML
    void VIPRegister(ActionEvent event){
        if(confirm("Comfirm","Are you sure you want to change your membership to this?")){
            registerMembership(3);
        }
    }
    @FXML
    void memberRegister(ActionEvent event){
        if(confirm("Comfirm","Are you sure you want to change your membership to this?")){
            registerMembership(2);
        }
    }
    @FXML
    void normalRegister(ActionEvent event){
        if(confirm("Comfirm","Are you sure you want to change your membership to this?")){
            registerMembership(1);
        }
    }

    private void registerMembership(int type){
        if(this.stageManager.getDataService().traineeChangeMembership(type)){
            this.stageManager.stageRedirect(getLocalPath(),getLocalPath());
        }
    }

    @Override
    public String getLocalPath() {
        return Path.VIPREGISTER;
    }
}
