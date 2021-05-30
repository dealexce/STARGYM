import UI.Path;
import UI.StageManager;
import javafx.application.Application;
import javafx.stage.Stage;

public class MainApp extends Application {
    public static final String homePageID = "homePage";
    public static final String loginPageID = "loginPage";
    public static final String registerPageID = "registerPage";
    @Override
    public void start(Stage primaryStage) throws Exception {
        //Create a StageController and load all stages into it
        StageManager stageManager = new StageManager();
        stageManager.addStage("primaryStage",primaryStage);
        stageManager.openStage(Path.HOME);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
