package UI;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * @description: Controller of HomePage
 * @author: Haopu Chen
 **/
public class HomeController extends ManagedPage implements Initializable{
    private static final String path = Path.HOME;

    @FXML
    private HBox loginInfo;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Button book_btn = new Button("gym booking");
        Button login_btn = new Button("login");
        login_btn.setOnMouseClicked(e->goLogin());
        Button register_btn = new Button("register");
        register_btn.setOnMouseClicked(e->goRegister());
        loginInfo.getChildren().addAll(book_btn,login_btn,register_btn);
    }

    private void goLogin(){
        this.stageManager.stageRedirect(path,Path.LOGIN);
    }

    private void goRegister(){
        this.stageManager.stageRedirect(path,Path.REGISTER);
    }

    public void goAllCourses(ActionEvent actionEvent) {
        this.stageManager.stageRedirect(path,Path.ALLCOURSES);
    }

    public void goAllTrainers(ActionEvent actionEvent) {
        this.stageManager.stageRedirect(path,Path.ALLTRAINERS);
    }
}
