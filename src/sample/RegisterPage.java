package sample;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import sun.applet.Main;

public class RegisterPage extends ControlledPage{
    public RegisterPage(StageController stageController) {
        super(stageController);
    }
    public Stage genRegisterScene() {
        Label welcome_lbl = new Label("Register");
        welcome_lbl.setStyle("-fx-font-size: 40");

        Label username_lbl = new Label("username:");
        TextField username_text = new TextField();
        username_text.setMaxWidth(200);
        username_text.setMaxHeight(20);
        HBox usernameBox = new HBox();
        usernameBox.getChildren().addAll(username_lbl,username_text);
        usernameBox.setSpacing(20);
        usernameBox.setAlignment(Pos.CENTER);

        Label password_lbl = new Label("password:");
        TextField password_text = new TextField();
        password_text.setMaxWidth(200);
        password_text.setMaxHeight(20);
        HBox passwordBox = new HBox();
        passwordBox.getChildren().addAll(password_lbl,password_text);
        passwordBox.setSpacing(20);
        passwordBox.setAlignment(Pos.CENTER);

        Button register_button = new Button("Register");

        Button goRegister_btn = new Button("Already have an account?");
        goRegister_btn.setOnMouseClicked(event -> stageController.showStage(MainApp.loginPageID));
        register_button.setPrefWidth(200);
        register_button.setMinHeight(50);
        VBox vbox = new VBox();
        vbox.getChildren().addAll(welcome_lbl,usernameBox,passwordBox,register_button,goRegister_btn);
        vbox.setAlignment(Pos.CENTER);
        vbox.setSpacing(20);
        Scene scene = new Scene(vbox, 400, 720);
        Stage stage = new Stage();
        stage.setTitle("Register");
        stage.setScene(scene);
        return stage;
    }
}
