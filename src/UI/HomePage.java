package UI;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class HomePage extends ControlledPage {
    private String username, password;
    private boolean isLogin;


    /**
     * Construct a HomePage that is logged in, with user's information
     * @param stageController the StageController controlling this Stage
     * @param username the username of this logged in member
     * @param password the password of this logged in member
     */
    public HomePage(StageController stageController, String username, String password){
        super(stageController);
        this.username = username;
        this.password = password;
        this.isLogin = true;
    }

    /**
     * Construct a HomePage that has not logged in yet
     * @param stageController the StageController controlling this Stage
     */
    public HomePage(StageController stageController){
        super(stageController);
        this.isLogin = false;
    }


//    public static void main(String[] args) {
//        launch(args);
//    }

//    @Override
//    public void start(Stage primaryStage) {
//        BorderPane borderPane = new BorderPane();
//        if(this.isLogin)
//            borderPane.setTop(genTopMenuMember());
//        else
//            borderPane.setTop(genTopMenuGuest());
//        borderPane.setCenter(genContent());
//        Scene scene = new Scene(borderPane,1280,750);
//        primaryStage.setTitle("Home");
//        primaryStage.setScene(scene);
//        primaryStage.show();
//    }



    /**
     * Generate the stage of home page
     * @return a Stage of homepage
     */
    public Stage genStage() {
        Stage s = new Stage();
        BorderPane borderPane = new BorderPane();
        if(this.isLogin)
            borderPane.setTop(genTopMenuMember());
        else
            borderPane.setTop(genTopMenuGuest());
        borderPane.setCenter(genContent());
        Scene scene = new Scene(borderPane,1280,750);
        s.setTitle("Home");
        s.setScene(scene);
        return s;
    }


    /**
     * Generate top menu bar when logged in as a member
     * @return HBox of top menu bar of login type
     */
    private HBox genTopMenuMember(){
        Label welcome_lbl = new Label("Welcome! "+this.username);
        welcome_lbl.setStyle("-fx-font-size: 18");
        welcome_lbl.setTextFill(Color.WHITE);
        Button booking_btn = new Button("Gym Booking");
        booking_btn.setPrefSize(100,20);
        Button myinfo_btn = new Button("My Info");
        myinfo_btn.setPrefSize(100,20);
        Button logout_btn = new Button("Log out");
        logout_btn.setOnMouseClicked(event -> this.logout());
        myinfo_btn.setPrefSize(100,20);
        HBox topBox = new HBox();
        topBox.getChildren().addAll(welcome_lbl,booking_btn,myinfo_btn,logout_btn);
        topBox.setSpacing(10);
        topBox.setPadding(new Insets(15));
        topBox.setStyle("-fx-background-color: #336699;");
        return topBox;
    }


    /**
     * Generate the top menu bar when not logged in
     * @return HBox of top menu bar of guest type
     */
    private HBox genTopMenuGuest(){
        Label welcome_lbl = new Label("Welcome to London Fitness!");
        welcome_lbl.setStyle("-fx-font-size: 18");
        welcome_lbl.setTextFill(Color.WHITE);
        Button login_btn = new Button("Login");
        login_btn.setPrefSize(100,20);
        login_btn.setOnMouseClicked(event -> stageController.switchStage(MainApp.homePageID,MainApp.loginPageID));
        Button register_btn = new Button("Register");
        register_btn.setPrefSize(100,20);
        register_btn.setOnMouseClicked(event -> stageController.switchStage(MainApp.homePageID,MainApp.registerPageID));
        HBox topBox = new HBox();
        topBox.getChildren().addAll(welcome_lbl,login_btn,register_btn);
        topBox.setSpacing(10);
        topBox.setPadding(new Insets(15));
        topBox.setStyle("-fx-background-color: #336699;");
        return topBox;
    }



    /**
     * Generate contents in home page
     * @return VBox of contents
     */
    private VBox genContent(){

        VBox vbox = new VBox();
        vbox.setPadding(new Insets(40,20,40,20));
        vbox.setSpacing(50);
        vbox.getChildren().addAll(genCoursesPane(),genTrainersPane());
        return vbox;
    }


    /**
     * Generate elaborate courses area in page's content
     * @return VBox of Courses
     */
    private VBox genCoursesPane(){
        Label courses_lbl = new Label("ELABORATE COURSES");
        courses_lbl.setStyle("-fx-font-size: 28");
        VBox coursesBox = new VBox();
        coursesBox.setSpacing(10);
        GridPane coursesPane = new GridPane();
        coursesPane.setHgap(50);
        coursesPane.setVgap(30);
        coursesPane.setPadding(new Insets(10));
        coursesPane.setAlignment(Pos.CENTER);
        for(int i = 0;i<4;i++){
            for(int j = 0;j<2;j++){
                Rectangle rect = new Rectangle(200,100, Color.SKYBLUE);
                coursesPane.add(rect,i,j);
            }
        }
        coursesBox.getChildren().addAll(courses_lbl,coursesPane);
        return coursesBox;
    }


    /**
     * Generate celebrity trainers area in page's content
     * @return VBox of trainers
     */
    private VBox genTrainersPane(){
        Label courses_lbl = new Label("CELEBRITY TRAINERS");
        courses_lbl.setStyle("-fx-font-size: 28");
        VBox trainerBox = new VBox();
        trainerBox.setSpacing(10);
        GridPane trainerPane = new GridPane();
        trainerPane.setHgap(50);
        trainerPane.setVgap(30);
        trainerPane.setPadding(new Insets(10));
        trainerPane.setAlignment(Pos.CENTER);

        for(int i = 0;i<3;i++){
                Rectangle rect = new Rectangle(300,200, Color.SKYBLUE);
            trainerPane.add(rect,i,0);
        }
        trainerBox.getChildren().addAll(courses_lbl,trainerPane);
        return trainerBox;
    }


    /**
     * Logout and jump to the login page, meanwhile unload this logged homepage
     */
    private void logout(){
        stageController.unloadStage(MainApp.homePageID);
        HomePage homePage = new HomePage(stageController);
        stageController.addStage(MainApp.homePageID,homePage.genStage());
        stageController.switchStage(MainApp.homePageID,MainApp.loginPageID);
    }

}
