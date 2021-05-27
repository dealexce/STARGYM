package UI.Controller;

import Data.Course;
import UI.Page;
import UI.Path;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

import java.util.List;

/**
 * @description: Controller of AllCoursesPage
 * @author: Haopu Chen
 **/
public class AllCoursesController extends Page {
    @FXML
    private FlowPane coursePane;

    @Override
    public String getLocalPath() {
        return Path.ALLCOURSES;
    }

    @Override
    public void init() {
        genCourseBox();
    }

    private void genCourseBox(){
        List<Course> courses = this.stageManager.getDataService().getAllCourse();
        for(Course course:courses){
            GridPane gp = new GridPane();
            gp.setPrefSize(240,170);
            gp.setMinSize(240,170);
            gp.setStyle("-fx-background-color: white");
            String url = System.getProperty("user.dir")+ "\\Resources\\Course\\C1.png";
            Image img = new Image("file:"+url);
            ImageView imgv = new ImageView(img);
            imgv.setFitHeight(120);
            imgv.setFitWidth(240);
            imgv.setPreserveRatio(false);
            imgv.setPickOnBounds(true);
            gp.add(imgv,0,0);

            VBox vb = new VBox();
            vb.setPrefSize(240,200);
            Label lbl = new Label(course.getTitle());
            lbl.setFont(Font.font(18));

            GridPane gp2 = new GridPane();
            gp2.setMinWidth(240);
            Label lbl2 = new Label(course.getCourseId());
            lbl2.setPrefSize(180,15);
            Button btn2 = new Button("Like");
            btn2.setMinWidth(60);
            btn2.setOnMouseClicked(e->like(course));
            Button btn3 = new Button("Start");
            btn3.setMinWidth(60);
            gp2.add(lbl2,0,0);
            gp2.add(btn2,1,0);
            gp2.add(btn3,2,0);

            vb.getChildren().addAll(lbl,gp2);
            gp.add(vb,0,1);

            coursePane.getChildren().add(gp);

        }
    }

    private void like(Course course){
        if(this.stageManager.getDataService().getTrainee()!=null){
            this.stageManager.getDataService().traineeAddCourse(course.getCourseId());
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Success");
            alert.setContentText("You like this courses! You can see this course in your personal page then.");
            alert.showAndWait();
        }else{
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Fail to like this course");
            alert.setContentText("Only members can like a course. Please login as a member first.");
            alert.showAndWait();
        }
    }

    public void goHome(){
        this.stageManager.stageRedirect(getLocalPath(),Path.HOME);
    }
}
