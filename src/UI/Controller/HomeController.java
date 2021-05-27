package UI.Controller;

import Data.Course;
import Data.Trainee;
import Data.Trainer;
import UI.ManagedPage;
import UI.Path;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Font;

import java.util.List;

/**
 * @description: Controller of HomePage
 * @author: Haopu Chen
 **/
public class HomeController extends ManagedPage {
    private static final String path = Path.HOME;

    @FXML
    private HBox loginInfo;
    @FXML
    private FlowPane coursePane,trainerPane;


    public void init() {
        genLoginInfo();
        genCourseBoxes();
        genTrainerBoxes();
    }


    private void genLoginInfo(){
        if(this.stageManager.getDataService().isLogin()){
            Button book_btn = new Button("gym booking");
            Button my_info_btn = new Button("my info");
            if(this.stageManager.getDataService().getTrainee()!=null){
                my_info_btn.setOnMouseClicked(e->goMyInfo());
            }
            loginInfo.getChildren().addAll(book_btn,my_info_btn);
        }else{
            Button book_btn = new Button("gym booking");
            Button login_btn = new Button("login");
            login_btn.setOnMouseClicked(e->goLogin());
            Button register_btn = new Button("register");
            register_btn.setOnMouseClicked(e->goRegister());
            loginInfo.getChildren().addAll(book_btn,login_btn,register_btn);
        }
    }

    private void genCourseBoxes(){
        List<Course> courses = this.stageManager.getDataService().getAllCourse();
        int num = 0;
        for (Course course:courses) {
            VBox vb = new VBox();
            vb.setMinSize(150,130);
            vb.setPrefSize(150,130);

            String url = System.getProperty("user.dir")+ "\\res\\Course\\C1.png";
            Image img = new Image("file:"+url);
            ImageView imgv = new ImageView(img);
            imgv.setFitHeight(100);
            imgv.setFitWidth(150);
            imgv.setPreserveRatio(true);
            imgv.setPickOnBounds(true);

            Label lbl = new Label(course.getTitle());
            lbl.setFont(Font.font(14));

            vb.getChildren().addAll(imgv,lbl);
            coursePane.getChildren().add(vb);
            num++;
            if(num>9)break;
        }
    }

    private void genTrainerBoxes(){
        List<Trainer> trainers = this.stageManager.getDataService().getAllTrainer();
        int num = 0;
        for (Trainer trainer:trainers) {
            GridPane gp = new GridPane();
            gp.setMinSize(300,110);
            gp.setPrefSize(300,110);
            gp.setPadding(new Insets(5));
            gp.setStyle("-fx-border-color: black;");

            String url = System.getProperty("user.dir")+ "\\res\\Trainer\\T1.png";
            Image img = new Image("file:"+url);
            ImageView imgv = new ImageView(img);
            imgv.setFitHeight(110);
            imgv.setFitWidth(110);
            imgv.setPreserveRatio(true);
            imgv.setPickOnBounds(true);

            VBox vb = new VBox();
            vb.setPrefSize(100,200);
            vb.setSpacing(5);

            Label lbl = new Label(trainer.getUserName());
            lbl.setFont(Font.font(18));

            vb.getChildren().addAll(lbl);
            gp.add(imgv,0,0);
            gp.add(vb,1,0);
            trainerPane.getChildren().add(gp);
            num++;
            if(num>3)break;
        }
    }

    private void goMyInfo() {
        this.stageManager.stageRedirect(path,Path.MEMBERPERSONAL);
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
