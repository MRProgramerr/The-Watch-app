
package application;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import javax.swing.*;

public class Meeting_Agenda_Layout {
    private static HBox Task_Pane = new HBox();
    private static VBox Agenda_vbox = new VBox();
    private static VBox Meeting_vbox = new VBox();
    private TextField taskname = new TextField();
    private TextField meeting_agenda = new TextField();
    private TextField meeting_sec = new TextField();
    private TextField meeting_hours = new TextField();
    private TextField meeitng_minute = new TextField();
    private Button start;
    private Button restart;
    private Button remove;
    private Button add ;
    private  GridPane taskbox;


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
                validate(meeting_agenda,taskname,meeitng_minute,meeting_hours,meeting_sec);
            }
        });

        Task_Pane.getChildren().addAll(new Node[]{this.taskname, new Text("    "), this.meeting_hours, new Text("  :  "), this.meeitng_minute, new Text("  :  "), this.meeting_sec,new Text("  :  "), add});
        Task_Pane.setPadding(new Insets(20.0D, 20.0D, 10.0D, 20.0D));
        Agenda_vbox.getChildren().addAll(new Node[]{meeting_agenda,Task_Pane});
        Agenda_vbox.setPadding(new Insets(20.0D, 20.0D, 20.0D, 10.0D));



    }

    public VBox getAgenda_vbox() {
        return Agenda_vbox;
    }

    public static void setAgenda_vbox(VBox agenda_vbox) {
        Agenda_vbox = agenda_vbox;
    }



    public  GridPane taskArea(){

        taskbox = new GridPane();
//        taskbox.setStyle("-fx-background-color: bisque;-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.8), 10, 0, " +
//                "0, 0); ");
        taskbox.setMaxWidth(250);
        taskbox.setMaxHeight(80);
        taskbox.setPadding(new Insets(10, 10, 10, 10));
        taskbox.setHgap(20);
        taskbox.setVgap(10);

        // Apply the column headings to the task area
        storetasks();

        return taskbox;
    }
    private void storetasks(){

    }
    private void validate(TextField meeting_agenda, TextField taskname,TextField meeitng_minute,TextField meeting_hours,TextField meeting_sec){
        if((meeting_agenda.getText().equals("") && taskname.getText().equals("") ) || !isNumeric(meeting_hours.getText()) || !isNumeric(minutes.getText()) || !isNumeric(seconds.getText()) ){

        }
}
