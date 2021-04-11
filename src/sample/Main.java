package sample;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Main extends Application {
    Stage stage = new Stage();
    private String username, password;

    public Main(String username, String password){
        super();
        this.username = username;
        this.password = password;
    }


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        BorderPane borderPane = new BorderPane();
        borderPane.setTop(genTopMenu());
        borderPane.setCenter(genContent());
        Scene scene = new Scene(borderPane,1280,750);
        stage.setTitle("Home");
        stage.setScene(scene);
        stage.show();
    }


    public Stage genStage() {
        Stage s = new Stage();
        BorderPane borderPane = new BorderPane();
        borderPane.setTop(genTopMenu());
        borderPane.setCenter(genContent());
        Scene scene = new Scene(borderPane,1280,750);
        s.setTitle("Home");
        s.setScene(scene);
        return s;
    }


    private HBox genTopMenu(){
        Label welcome_lbl = new Label("Welcome! "+this.username);
        welcome_lbl.setStyle("-fx-font-size: 18");
        welcome_lbl.setTextFill(Color.WHITE);
        Button booking_btn = new Button("Gym Booking");
        booking_btn.setPrefSize(100,20);
        Button myinfo_btn = new Button("My Info");
        myinfo_btn.setPrefSize(100,20);
        HBox topBox = new HBox();
        topBox.getChildren().addAll(welcome_lbl,booking_btn,myinfo_btn);
        topBox.setSpacing(10);
        topBox.setPadding(new Insets(15));
        topBox.setStyle("-fx-background-color: #336699;");
        return topBox;
    }

    private VBox genContent(){

        VBox vbox = new VBox();
        vbox.setPadding(new Insets(40,20,40,20));
        vbox.setSpacing(50);
        vbox.getChildren().addAll(genCoursesPane(),genTrainersPane());
        return vbox;
    }

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
}
