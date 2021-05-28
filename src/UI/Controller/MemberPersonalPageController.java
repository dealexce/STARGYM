package UI.Controller;

import Data.Course;
import Data.Exercise;
import Data.Trainee;
import Data.Trainer;
import UI.Page;
import UI.Path;
import UI.StageManager;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;

import java.util.List;

/**
 * @description: Controller of MemberPersonalPage
 * @author: Haopu Chen
 **/
public class MemberPersonalPageController extends Page {
    public MemberPersonalPageController(){super();}
    public MemberPersonalPageController(StageManager stageManager) {
        super(stageManager);
    }
    private Trainee trainee;

    @FXML
    private Label name,basic,courseNum,exerciseNum;
    @FXML
    private HBox courseHBox;
    @FXML
    private VBox exerciseVBox;
    @FXML
    private FlowPane trainerFlowPane;
    @FXML
    public void viewPremium(MouseEvent mouseEvent) {
        this.stageManager.openStage(Path.VIPREGISTER);
    }

    @Override
    public String getLocalPath() {
        return Path.MEMBERPERSONAL;
    }

    @Override
    public void init() {
        trainee = this.stageManager.getDataService().getTrainee();
        genBasicInfo();
        genFavoriteCourses();
        genExercises();
        genFavoriteTrainers();
        stageManager.openStage(Path.LIVESESSION);
    }

    private void genBasicInfo(){
        name.setText(trainee.getUserName());
        String basicString = trainee.getSex() +
                " | " +
                "Weight: " + trainee.getWeight() +
                " | " +
                "Height: " + trainee.getHeight();
        basic.setText(basicString);
        courseNum.setText(String.valueOf(trainee.getFavoriteCourses().size()));
        exerciseNum.setText(String.valueOf(trainee.getMyExercises().size()));
    }

    private void genFavoriteCourses(){
        List<Course> courses = trainee.getFavoriteCourses();
        int count = 0;
        if(courses.isEmpty()){
            Label lbl = new Label("You have not add any favorite course yet!");
            courseHBox.getChildren().add(lbl);
        }
        for(Course course:courses){
            VBox vb = new VBox();
            vb.setPrefSize(150,150);
            vb.setMinSize(150,150);
            Image img;
            if(course.getCover()==null){
                img = new Image("file:"+System.getProperty("user.dir")+ "\\Resources\\Courses\\C1.png");
            }else{
                img = new Image("file:"+course.getCover());
            }

            ImageView imgv = new ImageView(img);
            imgv.setFitHeight(100);
            imgv.setFitWidth(150);
            Label lbl = new Label(course.getTitle());
            vb.getChildren().addAll(imgv,lbl);

            courseHBox.getChildren().add(vb);

            if(++count>=5){
                break;
            }
        }
    }

    private void genExercises(){
        List<Exercise> exercises = trainee.getMyExercises();
        if(exercises.isEmpty()){
            Label lbl = new Label("You have no exercise yet");
            exerciseVBox.getChildren().add(lbl);
        }
        for(Exercise exercise:exercises){
            GridPane gp = new GridPane();
            gp.setStyle("-fx-border-color: black; -fx-background-color: whitesmoke;");
            gp.setPadding(new Insets(10,20,10,20));
            ColumnConstraints col = new ColumnConstraints();
            col.setHgrow(Priority.SOMETIMES);
            ColumnConstraints col2 = new ColumnConstraints();
            col2.setHgrow(Priority.SOMETIMES);
            gp.getColumnConstraints().addAll(col,col2);
            RowConstraints row = new RowConstraints();
            row.setVgrow(Priority.SOMETIMES);
            gp.getRowConstraints().add(row);

            VBox vb = new VBox();
            vb.setPrefSize(200,70);
            vb.setMinSize(200,70);
            vb.setSpacing(8);
            Label lbl = new Label("Exercise with trainer "+exercise.getTrainerId());
            lbl.setFont(Font.font(16));
            Line line = new Line();
            line.setStartX(-100);
            line.setEndX(100);
            Label lbl2 = new Label(exercise.getDate().toString());
            vb.getChildren().addAll(lbl,line,lbl2);
            vb.setAlignment(Pos.CENTER_LEFT);

            VBox vb2 = new VBox();
            vb2.setPrefSize(200,70);
            vb2.setMinSize(200,70);
            vb2.setSpacing(5);
            Button btn = new Button("Attend");
            btn.setOnMouseClicked(e->stageManager.openStage(Path.LIVESESSION));
            Button btn2 = new Button("Cancel");
            vb2.getChildren().addAll(btn,btn2);
            vb2.setAlignment(Pos.CENTER_RIGHT);

            gp.add(vb,0,0);
            gp.add(vb2,1,0);

            exerciseVBox.getChildren().add(gp);
        }
    }

    private void genFavoriteTrainers(){
        List<Trainer> trainers = trainee.getFavoriteTrainers();
        for (Trainer trainer:trainers) {
            GridPane gp = new GridPane();
            gp.setMinSize(300,110);
            gp.setPrefSize(300,110);
            gp.setPadding(new Insets(10));
            gp.setStyle("-fx-border-color: black;");

            String url = System.getProperty("user.dir")+ "\\Resources\\Trainers\\T1.png";
            Image img = new Image("file:"+url);
            ImageView imgv = new ImageView(img);
            imgv.setFitHeight(90);
            imgv.setFitWidth(90);
            imgv.setPreserveRatio(true);
            imgv.setPickOnBounds(true);

            VBox vb = new VBox();
            vb.setAlignment(Pos.CENTER_LEFT);
            vb.setPrefSize(200,200);
            vb.setSpacing(5);
            vb.setPadding(new Insets(0,20,0,20));
            Label lbl = new Label(trainer.getUserName());
            lbl.setFont(Font.font(18));
            Label lbl2 = new Label("Level: "+trainer.getLevel());
            Button btn = new Button("Remove");
            btn.setMinWidth(70);
            btn.setOnMouseClicked(e->remove(trainer));

            vb.getChildren().addAll(lbl,lbl2,btn);
            gp.add(imgv,0,0);
            gp.add(vb,1,0);
            trainerFlowPane.getChildren().add(gp);
        }
    }

    private void remove(Trainer trainer){
        if(confirm("Remove Confirm","Are you sure you are going to remove this trainer from favorites?")){
            this.stageManager.getDataService().traineeDeleteTrainer(trainer.getUserId());
            this.stageManager.stageRedirect(this.getLocalPath(), this.getLocalPath());
        }
    }

    public void goHome() {
        this.stageManager.stageRedirect(this.getLocalPath(), Path.HOME);
    }

    public void goFavoriteCourse(){
        this.stageManager.stageRedirect(this.getLocalPath(),Path.FAVORITECOURSE);
    }

    @FXML
    void goInfoChange(){
        this.stageManager.openStage(Path.INFOCHANGE);
    }
}
