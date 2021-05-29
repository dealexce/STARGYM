package UI.Controller;

import Data.Course;
import Service.SearchService;
import UI.Page;
import UI.Path;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
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
    @FXML
    private TextField searchWord;

    @Override
    public String getLocalPath() {
        return Path.ALLCOURSES;
    }

    @Override
    public void init() {
        genCourseBox(this.stageManager.getDataService().getAllCourse());
    }

    @FXML
    void search(){
        List<Course> courses = SearchService.searchCourse(searchWord.getText(),stageManager.getDataService().getAllCourse());
        genCourseBox(courses);
    }

    private void genCourseBox(List<Course> courses){
        coursePane.getChildren().clear();
        for(Course course:courses){
            GridPane gp = new GridPane();
            gp.setPrefSize(240,170);
            gp.setMinSize(240,170);
            gp.setStyle("-fx-background-color: white");
            String url = System.getProperty("user.dir")+ "\\Resources\\Course\\"+course.getCover()+".jpg";
            Image img = new Image("file:"+url);
            ImageView imgv = new ImageView(img);
            imgv.setFitHeight(120);
            imgv.setFitWidth(240);
            imgv.setPreserveRatio(false);
            imgv.setPickOnBounds(true);
            VBox imgVB = new VBox();
            imgVB.setMinSize(240,120);
            imgVB.setPrefSize(240,120);
            imgVB.getChildren().add(imgv);
            gp.add(imgVB,0,0);

            VBox vb = new VBox();
            vb.setPrefSize(240,15);
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
            btn3.setOnMouseClicked(e->start(course));
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

    private void start(Course course){
        this.stageManager.openStage(Path.COURSEPLAYER,course);
    }

    public void goHome(){
        this.stageManager.stageRedirect(getLocalPath(),Path.HOME);
    }
}
