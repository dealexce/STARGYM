package UI.Controller;

import Data.Exercise;
import Data.Trainee;
import Data.Trainer;
import UI.Page;
import UI.Path;
import Util.UserUtil;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.util.Callback;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

/**
 * @description: Controller of AllTrainersPage
 * @author: Haopu Chen
 **/
public class ExerciseArrangeController extends Page {
    @FXML
    private Label trainerInfo;
    @FXML
    private TextField topic;
    @FXML
    private DatePicker datePicker;
    @FXML
    private ComboBox session;
    @FXML
    private TextArea description;

    private Trainer trainer;
    @Override
    public String getLocalPath() {
        return Path.EXERCISEARRANGE;
    }

    public void init(Object o) {
        try{
            trainer = (Trainer)o;
        }catch (Exception e){
            e.printStackTrace();
            return;
        }
        trainerInfo.setText(trainer.getUserName());
        LocalDate availableDate = LocalDate.now().plusDays(1);
        datePicker.setValue(availableDate);
        final Callback<DatePicker, DateCell> dayCellFactory =
                new Callback<DatePicker, DateCell>() {
                    @Override
                    public DateCell call(final DatePicker datePicker) {
                        return new DateCell() {
                            @Override
                            public void updateItem(LocalDate item, boolean empty) {
                                super.updateItem(item, empty);
                                if (item.isBefore(availableDate)) {
                                    setDisable(true);
                                    setStyle("-fx-background-color: dimgray;");
                                }
                            }
                        };
                    }
                };
        datePicker.setDayCellFactory(dayCellFactory);
        datePicker.valueProperty().addListener((observable, oldValue, newValue) -> genSessions(datePicker.getValue()));
        genSessions(availableDate);

    }

    private void genSessions(LocalDate date){
        int[] occupied = new int[12];
        List<Exercise> exercises = trainer.getMyExercises();
        if(exercises!=null){
            for(Exercise exercise:exercises){
                if(exercise.getDate().isEqual(date)){
                    occupied[exercise.getTimeStamp()]=1;
                }
            }
        }
        session.getItems().clear();
        for(int i = 0;i<occupied.length;i++){
            if(occupied[i]==0){

                session.getItems().add(timestamp2Session(i));
            }
        }
    }

    private String timestamp2Session(int timestamp){
        return timestamp*2 + ":00 - "
                + (timestamp+1)*2 + ":00";
    }

    @FXML
    private void save(){
        String validString = infoNotValidString();
        if(!validString.isEmpty()){
            notice("Fail",validString, Alert.AlertType.WARNING);
            return;
        }
        if(trainer==null){
            notice("Fail","Unavailable trainer", Alert.AlertType.ERROR);
            return;
        }
        Trainee trainee = this.stageManager.getDataService().getTrainee();
        if(trainee==null){
            notice("Fail","Please login first.", Alert.AlertType.WARNING);
            return;
        }
        if(!UserUtil.checkExerciseBookable(trainee.getUserType(),trainer.getLevel())){
            notice("Fail","Sorry, your membership can not book trainer of this level.", Alert.AlertType.WARNING);
            return;
        }
        LocalDate date = null;
        date = LocalDate.parse(datePicker.getValue().toString());
        this.stageManager.getDataService().traineeCreateExercise(trainer.getUserId(), date,
                session.getSelectionModel().getSelectedIndex(),description.getText());
        notice("Success","You book a live session this trainer! You can see this session in your personal page then.", Alert.AlertType.INFORMATION);
        this.stageManager.closeStage(getLocalPath());
    }

    private String infoNotValidString(){
        StringBuilder stringBuilder = new StringBuilder();
        if(topic.getText().isEmpty())
            stringBuilder.append("Please determine the topic of this exercise;\n");
        if(session.getSelectionModel().isEmpty())
            stringBuilder.append("Pleas select an exercise session;\n");
        return stringBuilder.toString();
    }

    @FXML
    public void cancel(){
        this.stageManager.closeStage(getLocalPath());
    }

}
