package sample;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import sun.applet.Main;

public class LoginPage extends ControlledPage{
    public LoginPage(StageController stageController) {
        super(stageController);
    }


    /**
    * @Description: Generate the stage of login page
    * @Param: []
    * @return: javafx.stage.Stage
    * @Author: Haopu Chen
    * @Date: 2021/4/11
    */
    public Stage genLoginStage(){
        Label welcome_lbl = new Label("Welcome to\nSTAYGYM");
        welcome_lbl.setAlignment(Pos.CENTER);
        welcome_lbl.setStyle("-fx-text-alignment: center;-fx-font-size: 28");


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

        Button login_button = new Button("Login");
        login_button.setOnMouseClicked(event -> this.login(username_text.getText(),password_text.getText()));
        login_button.setPrefWidth(200);
        login_button.setMinHeight(50);
        Button goRegister_btn = new Button("Register for an account");
        goRegister_btn.setOnMouseClicked(event -> stageController.switchStage(MainApp.loginPageID,MainApp.registerPageID));
        Button guestin_btn = new Button("Visit as a guest");
        guestin_btn.setOnMouseClicked(event -> guestin());
        VBox vbox = new VBox();
        vbox.getChildren().addAll(welcome_lbl,usernameBox,passwordBox,login_button,goRegister_btn,guestin_btn);
        vbox.setAlignment(Pos.CENTER);
        vbox.setSpacing(20);
        Scene scene = new Scene(vbox, 400, 720);
        Stage stage = new Stage();
        stage.setTitle("Register");
        stage.setScene(scene);
        return stage;
    }

    /**
    * @Description: Login with input username and password, unload guest homepage, load member homepage and jump to it
    * @Param: [username, password]
    * @return: void
    * @Author: Haopu Chen
    * @Date: 2021/4/11
    */
    private void login(String username, String password){
        stageController.unloadStage(MainApp.homePageID);
        HomePage homePage = new HomePage(stageController,username,password);
        stageController.addStage(MainApp.homePageID,homePage.genStage());
        stageController.switchStage(MainApp.loginPageID,MainApp.homePageID);
    }

    private void guestin(){
        stageController.unloadStage(MainApp.homePageID);
        HomePage homePage = new HomePage(stageController);
        stageController.addStage(MainApp.homePageID,homePage.genStage());
        stageController.switchStage(MainApp.loginPageID,MainApp.homePageID);
    }

}
