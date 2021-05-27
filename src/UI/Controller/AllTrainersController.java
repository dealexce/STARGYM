package UI.Controller;

import Data.Course;
import Data.Trainer;
import UI.ManagedPage;
import UI.Path;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.control.*;

import java.util.List;

/**
 * @description: Controller of AllTrainersPage
 * @author: Haopu Chen
 **/
public class AllTrainersController extends ManagedPage {
    @FXML
    private VBox trainerBox;
    public static final String path = Path.ALLTRAINERS;
    public void goHome(ActionEvent actionEvent) {
        this.stageManager.stageRedirect(path,Path.HOME);
    }

    @Override
    public void init() {
        genTrainerBox();
    }

    private void genTrainerBox(){
        List<Trainer> trainers = this.stageManager.getDataService().getAllTrainer();
        for(Trainer trainer:trainers){
            BorderPane bp = new BorderPane();
            bp.setPrefSize(600,100);
            bp.setMinSize(600,100);
            bp.setStyle("-fx-border-color: lightgrey; -fx-background-color: FCFCFC;");
            String url = System.getProperty("user.dir")+ "\\res\\Trainers\\T1.png";
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
            BorderPane.setMargin(vb,new Insets(10));
            BorderPane.setAlignment(vb, Pos.CENTER);
            bp.setCenter(vb);

            VBox vb2 = new VBox();
            vb2.setPrefSize(100,200);
            Button btn = new Button("Book");
            Button btn2 = new Button("Like");
            vb2.getChildren().addAll(btn,btn2);
            BorderPane.setMargin(vb2,new Insets(15,10,5,15));
            bp.setRight(vb2);



            trainerBox.getChildren().add(bp);

        }
    }

}
