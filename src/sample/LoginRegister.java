package sample;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class LoginRegister extends Application {
    public enum Page{
        LOGIN,REGISTER;
    }
    Stage stage = new Stage();
    Scene loginScene, registerScene;
    @Override
    public void start(Stage primaryStage) throws Exception{

        loginScene = genLoginScene();
        registerScene = genRegisterScene();
        stage.setTitle("Login");
        stage.setScene(loginScene);
        stage.show();
    }

    private Scene genRegisterScene() {
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
        goRegister_btn.setOnMouseClicked(event -> stage.setScene(loginScene));
        register_button.setPrefWidth(200);
        register_button.setMinHeight(50);
        VBox vbox = new VBox();
        vbox.getChildren().addAll(welcome_lbl,usernameBox,passwordBox,register_button,goRegister_btn);
        vbox.setAlignment(Pos.CENTER);
        vbox.setSpacing(20);
        return new Scene(vbox, 400, 720);
    }

    private Scene genLoginScene(){
        Label welcome_lbl = new Label("Welcome");
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

        Button login_button = new Button("Login");
        login_button.setOnMouseClicked(event -> {
            Main n = new Main(username_text.getText(),"123123");
            n.start(new Stage());
            stage.close();
        });
        Button goRegister_btn = new Button("Register for an account");
        goRegister_btn.setOnMouseClicked(event -> stage.setScene(registerScene));
        login_button.setPrefWidth(200);
        login_button.setMinHeight(50);
        VBox vbox = new VBox();
        vbox.getChildren().addAll(welcome_lbl,usernameBox,passwordBox,login_button,goRegister_btn);
        vbox.setAlignment(Pos.CENTER);
        vbox.setSpacing(20);
        return new Scene(vbox, 400, 720);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
