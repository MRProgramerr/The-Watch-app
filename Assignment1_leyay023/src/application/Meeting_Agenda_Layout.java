
package application;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.util.ArrayList;

public class Meeting_Agenda_Layout {
    private static HBox Task_Pane = new HBox();
    private static VBox Agenda_vbox = new VBox();
    private static VBox Agendas = new VBox();
    private TextField taskname = new TextField();
    private TextField meeting_agenda = new TextField();
    private TextField meeting_sec = new TextField();
    private TextField meeting_hours = new TextField();
    private TextField meeitng_minute = new TextField();

    private static ArrayList<Meeting_Agenda> tasksList = new ArrayList<Meeting_Agenda>();



    private Button start;
    private Button restart;
    private Button remove;
    private Button add ;
    private  GridPane taskbox;

    Time time = new Time();

    public static VBox getAgenda_vbox() {
        return Agenda_vbox;
    }

    public static void setAgenda_vbox(VBox agenda_vbox) {
        Agenda_vbox = agenda_vbox;
    }

    public static VBox getAgendas() {
        return Agendas;
    }

    public static void setAgendas(VBox agendas) {
        Agendas = agendas;
    }

    public Meeting_Agenda_Layout() {
        this.meeting_agenda.setPromptText("Agenda");
        this.meeting_agenda.setPrefWidth(100.0D);
        this.meeting_agenda.setPrefHeight(30.0D);
        this.taskname.setPromptText("Task");
        this.taskname.setPrefWidth(100.0D);
        this.meeting_sec.setPromptText("00");
        this.meeting_sec.setPrefWidth(30.0D);
        this.meeitng_minute.setPromptText("00");
        this.meeitng_minute.setPrefWidth(30.0D);
        this.meeting_hours.setPromptText("00");
        this.meeting_hours.setPrefWidth(30.0D);

        this.add = new Button("+");

        add.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if(validate(meeting_agenda, taskname, meeitng_minute, meeting_hours, meeting_sec)){
                    Meeting_Agenda agenda = new Meeting_Agenda(taskname.getText(),meeting_agenda.getText(),meeting_sec.getText(),meeting_hours.getText(),meeitng_minute.getText());
                    tasksList.add(agenda);
                    Agendas.getChildren().add(storetask());
                }
            }
        });

        Task_Pane.getChildren().addAll(this.taskname, new Text("    "), this.meeting_hours, new Text("  :  "), this.meeitng_minute, new Text("  :  "), this.meeting_sec,new Text("  :  "), add);
        Task_Pane.setPadding(new Insets(20.0D, 20.0D, 10.0D, 20.0D));
        Agenda_vbox.getChildren().addAll(meeting_agenda,Task_Pane,Agendas);
        Agenda_vbox.setPadding(new Insets(20.0D, 20.0D, 20.0D, 10.0D));



    }

    private GridPane storetask() {
        taskbox = new GridPane();
//        taskbox.setStyle("-fx-background-color: bisque;-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.8), 10, 0, " +
//                "0, 0); ");
        taskbox.setMaxWidth(150);
        taskbox.setMaxHeight(80);
        taskbox.setPadding(new Insets(10, 10, 10, 10));
        taskbox.setHgap(20);
        taskbox.setVgap(10);
        for (int i = 0; i < tasksList.size(); i++) {
            taskbox.add(tasksList.get(i).getMeeting_agenda(), 0, 0);
            taskbox.add(tasksList.get(i).getTaskname(), 1, 0);
            taskbox.add(tasksList.get(i).getMeeitng_minute(), 1, 1);
        }
        return taskbox;

    }
       private boolean validate(TextField meeting_agenda, TextField taskname,TextField meeitng_minute,TextField meeting_hours,TextField meeting_sec){
        if(meeting_agenda.getText().equals("") || taskname.getText().equals("")  || !ValidateTime(meeting_hours, "hours") || !ValidateTime(meeitng_minute, "minutes") || !ValidateTime(meeting_sec, "seconds")){
            return  true;
        }
        else
            return false;
}
    public boolean ValidateTime(TextField txt, String name) {
        try {
           int cnt = Integer.parseInt(txt.getText());

        }   catch (IllegalArgumentException e)
        {
            Alert a = new Alert(Alert.AlertType.WARNING, "Wrong Input Type for " + name );
            a.setAlertType(Alert.AlertType.ERROR);
            a.show();
        }
        return true;
    }
}
