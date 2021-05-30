package UI.Controller;

import Data.Course;
import Data.Exercise;
import Data.Trainer;
import UI.Page;
import UI.Path;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;

import java.io.File;
import java.util.List;

/**
 * @description: Controller of MemberPersonalPage
 * @author: Haopu Chen
 **/
public class TrainerPersonalPageController extends Page {
    private Trainer trainer;
    @FXML
    private Label name,basic,courseNum,exerciseNum;
    @FXML
    private HBox courseHBox;
    @FXML
    private VBox exerciseVBox;
    @FXML
    public void viewPremium(MouseEvent mouseEvent) {
        this.stageManager.openStage(Path.VIPREGISTER);
    }

    @Override
    public String getLocalPath() {
        return Path.TRAINERPERSONAL;
    }

    @Override
    public void init() {
        trainer = this.stageManager.getDataService().getTrainer();
        genBasicInfo();
        genMyCourses();
        genExercises();
    }

    private void genBasicInfo(){
        name.setText(trainer.getUserName());
        String basicString = trainer.getSex() +
                " | " +
                "Weight: " + trainer.getWeight() +
                " | " +
                "Height: " + trainer.getHeight();
        basic.setText(basicString);
        courseNum.setText(String.valueOf(trainer.getMyCourses().size()));
        exerciseNum.setText(String.valueOf(trainer.getMyExercises().size()));
    }

    private void genMyCourses(){
        List<Course> courses = trainer.getMyCourses();
        int count = 0;
        if(courses.isEmpty()){
            Label lbl = new Label("You have not publish any courses yet!");
            courseHBox.getChildren().add(lbl);
        }
        for(Course course:courses){
            VBox vb = new VBox();
            vb.setPrefSize(150,150);
            vb.setMinSize(150,150);
            Image img;
            img = new Image("file:"+Path.RESOURCE+ File.separator+"Courses"+File.separator+course.getCover()+".jpg");
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
        List<Exercise> exercises = trainer.getMyExercises();
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
            Label lbl = new Label("Exercise with trainee "+ this.stageManager.getDataService().findTrainee(exercise.getTraineeId()).getUserName());
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
            vb2.getChildren().addAll(btn);
            vb2.setAlignment(Pos.CENTER_RIGHT);

            gp.add(vb,0,0);
            gp.add(vb2,1,0);

            exerciseVBox.getChildren().add(gp);
        }
    }


    public void goHome() {
        this.stageManager.stageRedirect(this.getLocalPath(), Path.HOME);
    }

    public void goMyCourse(){
        this.stageManager.stageRedirect(this.getLocalPath(),Path.TRAINERMYCOURSE);
    }

    public void goChangeInfo(){
        this.stageManager.stageRedirect(this.getLocalPath(),Path.INFOCHANGE);
    }

    public void publish(){
        this.stageManager.openStage(Path.CREATECOURSE);
    }
}
