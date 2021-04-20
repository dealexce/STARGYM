package UI;

import javafx.application.Application;
import javafx.stage.Stage;

public class MainApp extends Application {
    public static final String homePageID = "homePage";
    public static final String loginPageID = "loginPage";
    public static final String registerPageID = "registerPage";
    @Override
    public void start(Stage primaryStage) throws Exception {
        //Create a StageController and load all stages into it
        StageController stageController = new StageController();
        stageController.addStage("primaryStage",primaryStage);
        HomePage homePage = new HomePage(stageController);
        stageController.addStage(homePageID,homePage.genStage());
        LoginPage loginPage = new LoginPage(stageController);
        stageController.addStage(loginPageID, loginPage.genLoginStage());
        RegisterPage registerPage = new RegisterPage(stageController);
        stageController.addStage(registerPageID, registerPage.genRegisterStage());

        //Show homepage first
        stageController.showStage(homePageID);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
