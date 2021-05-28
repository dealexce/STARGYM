package UI.Controller;

import Data.Course;
import Data.Trainer;
import Service.SearchService;
import UI.Page;
import UI.Path;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.TriangleMesh;
import javafx.scene.text.Font;
import javafx.scene.control.*;

import java.util.List;

/**
 * @description: Controller of AllTrainersPage
 * @author: Haopu Chen
 **/
public class AllTrainersController extends Page {
    @FXML
    private VBox trainerBox;
    @FXML
    private TextField searchWord;
    @Override
    public String getLocalPath() {
        return Path.ALLTRAINERS;
    }



    @Override
    public void init() {
        genTrainerBox(this.stageManager.getDataService().getAllTrainer());
    }

    @FXML
    void search(){
        List<Trainer> trainers = SearchService.searchTrainer(searchWord.getText(),this.stageManager.getDataService().getAllTrainer());
        genTrainerBox(trainers);
    }

    private void genTrainerBox(List<Trainer> trainers){
        trainerBox.getChildren().clear();
        for(Trainer trainer:trainers){
            BorderPane bp = new BorderPane();
            bp.setPrefSize(600,100);
            bp.setMinSize(600,100);
            bp.setStyle("-fx-border-color: lightgrey; -fx-background-color: FCFCFC;");
            String url = System.getProperty("user.dir")+ "\\Resources\\Trainers\\T1.png";
            javafx.scene.image.Image img = new Image("file:"+url);
            ImageView imgv = new ImageView(img);
            imgv.setFitHeight(80);
            imgv.setFitWidth(80);
            imgv.setPreserveRatio(false);
            imgv.setPickOnBounds(true);
            bp.setLeft(imgv);
            BorderPane.setAlignment(imgv, Pos.CENTER);

            VBox vb = new VBox();
            vb.setPrefSize(100,200);
            Label lbl = new Label(trainer.getUserName());
            lbl.setFont(Font.font(23));
            Line line = new Line();
            line.setStartX(-100);
            line.setEndX(100);
            Label lbl2 = new Label("Level "+ trainer.getLevel());
            lbl2.setTextFill(Color.BLUE);
            Label lbl3 = new Label(trainer.getIntroduction());
            vb.getChildren().addAll(lbl,lbl2,lbl3);
            vb.setAlignment(Pos.CENTER_LEFT);
            BorderPane.setMargin(vb,new Insets(10));
            BorderPane.setAlignment(vb, Pos.CENTER);
            bp.setCenter(vb);

            VBox vb2 = new VBox();
            vb2.setPrefSize(100,200);
            vb2.setSpacing(5);
            Button btn = new Button("Book");
            btn.setOnMouseClicked(e->book(trainer));
            btn.setPrefWidth(70);
            Button btn2 = new Button("Like");
            btn2.setOnMouseClicked(e->like(trainer));
            btn2.setPrefWidth(70);
            vb2.getChildren().addAll(btn,btn2);
            vb2.setAlignment(Pos.CENTER_RIGHT);
            bp.setRight(vb2);

            bp.setPadding(new Insets(20));

            trainerBox.getChildren().add(bp);

        }
    }

    private void like(Trainer trainer){
        if(this.stageManager.getDataService().getTrainee()!=null){
            this.stageManager.getDataService().traineeAddTrainer(trainer.getUserId());
            notice("Success","You like this trainer! You can see this trainer in your personal page then.", Alert.AlertType.INFORMATION);
        }else{
            notice("Fail","Only members can like a course. Please login as a member first.", Alert.AlertType.WARNING);
        }
    }

    public void goHome(){
        this.stageManager.stageRedirect(getLocalPath(),Path.HOME);
    }

    public void book(Trainer trainer){
        this.stageManager.openStage(Path.EXERCISEARRANGE,trainer);
    }

}
