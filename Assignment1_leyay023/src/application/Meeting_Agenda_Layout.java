
package application;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.text.Text;

import java.util.ArrayList;

public class Meeting_Agenda_Layout {
    private static GridPane Agenda_Pane = new GridPane();
    private static VBox Agenda_vbox = new VBox();
    private static HBox footer = new HBox();
    private static GridPane Agendas = new GridPane();
    private TextField taskname = new TextField();
    private TextField meeting_agenda = new TextField();
    private TextField meeting_sec = new TextField();
    private TextField meeting_hours = new TextField();
    private TextField meeitng_minute = new TextField();
    private Label hoursLabel = new Label();
    private Label agendaLabel = new Label();
    private Label taskLabel  = new Label();
    private Label secLabel = new Label();
    private Label minLabel = new Label();
    private boolean check = true;
    private static ArrayList<Meeting_Agenda> tasksList = new ArrayList<Meeting_Agenda>();



    private Button start;
    private Button restart;
    Button remove ;
    private Button add ;

//    Time time = new Time();

    public static VBox getAgenda_vbox() {
        return Agenda_vbox;
    }

    public static void setAgenda_vbox(VBox agenda_vbox) {
        Agenda_vbox = agenda_vbox;
    }

    public static GridPane getAgendas() {
        return Agendas;
    }

    public static void setAgendas(GridPane agendas) {
        Agendas = agendas;
    }

    public Meeting_Agenda_Layout() {
        remove =  new Button("X");
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

        hoursLabel.setText("H");
        minLabel.setText("Min");
        secLabel.setText("Sec");
        agendaLabel.setText("Agenda");
        taskLabel.setText("Task");

        Agendas.setPrefHeight(500);
        Agendas.setPrefWidth(200);
        Agendas.setVgap(10);
        Agenda_Pane.add(taskLabel,0,0);
        Agenda_Pane.add(new Text("     "),1,0);
        Agenda_Pane.add(hoursLabel,2,0);
        Agenda_Pane.add(new Text(" "),3,0);
        Agenda_Pane.add(minLabel,4,0);
        Agenda_Pane.add(new Text(" "),5,0);
        Agenda_Pane.add(secLabel,6,0);
        Agenda_Pane.add(taskname,0,1);
        Agenda_Pane.add(new Text("     "),1,1);
        Agenda_Pane.add(meeting_hours,2,1);
        Agenda_Pane.add(new Text("  :  "),3,1);
        Agenda_Pane.add(meeitng_minute,4,1);
        Agenda_Pane.add(new Text("  :  "),5,1);
        Agenda_Pane.add(meeting_sec,6,1);
        Agenda_Pane.add(new Text("     "),7,1);
        Agenda_Pane.add(add,8,1);

        Agenda_Pane.setPadding(new Insets(10.0D, 10.0D, 10.0D, 10.0D));

        Agenda_vbox.getChildren().addAll(agendaLabel,meeting_agenda, Agenda_Pane,Agendas);
        Agenda_vbox.setPadding(new Insets(20.0D, 20.0D, 20.0D, 10.0D));


        //Agendas.setBackground(new Background(new BackgroundFill(Color.CHOCOLATE,null,null)));
        Agendas.setStyle("-fx-background-color: chocolate;-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.8), 10, 0, " +
                "0, 0); ");
        Agendas.setPadding(new Insets(10,10,10,10));
        if(tasksList.size()==0 && check == true)
        add.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                    if((validateAgenda(meeting_agenda,"Agenda") && validateAgenda(taskname,"task") )|| validateTime(meeitng_minute, "minute") || validateTime(meeting_hours,"hours") || validateTime(meeting_sec,"secomd")) {
                        Meeting_Agenda agenda = new Meeting_Agenda(taskname.getText(), meeting_agenda.getText(), meeting_sec.getText(), meeting_hours.getText(), meeitng_minute.getText());
                        tasksList.add(agenda);
                        storetask();
                }
                    else
                    {
                        Alert a = new Alert(Alert.AlertType.WARNING, "Please fill all the fields");
                        a.setAlertType(Alert.AlertType.ERROR);
                        a.show();
                    }
                }

        });

    }

    private GridPane storetask() {


//        GridPane taskbox = new GridPane();
//        taskbox.setStyle("-fx-background-color: white;-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.8), 10, 0, " +
//                "0, 0); ");
//        taskbox.setPrefWidth(90);
//        taskbox.setMaxHeight(30);
//        taskbox.setPadding(new Insets(10, 10, 10, 10));
//        taskbox.setHgap(20);
//        taskbox.setVgap(10);

        Agendas.getChildren().clear();

        int col=0;
        int row=1;
        for (int i = 0; i < tasksList.size(); i++){

        Agendas.add(tasksList.get(i).getMeeting_agenda(), col, row);
        Agendas.add(new Text(tasksList.get(i).getTaskname().getText() + "   "), col, row+1);
        Agendas.add(new Text(tomins(tasksList.get(i).getMeeting_hours().getText(),tasksList.get(i).getMeeitng_minute().getText(),tasksList.get(i).getMeeting_sec().getText())+" mins"), col+1, row+1);
        Agendas.add(tasksList.get(i).getSelect(),col+2,row+1);

        int hours = Integer.parseInt(tasksList.get(i).getMeeting_hours().getText());
        int mins = Integer.parseInt(tasksList.get(i).getMeeitng_minute().getText());
        int sec = Integer.parseInt(tasksList.get(i).getMeeting_sec().getText());


            tasksList.get(i).Select.setOnMouseClicked(new EventHandler<MouseEvent>() {
           @Override
           public void handle(MouseEvent mouseEvent) {
               Time time = new Time();
               TimerLayout tml = new TimerLayout();
               tml.playpause.setDisable(false);
               tml.startButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
                   @Override
                   public void handle(MouseEvent mouseEvent) {
                       time.startTimer(hours,mins,sec);
                   }
               });

           }
       });
                row+=2;
    }
        return Agendas;

    }


    public boolean validateTime(TextField txt, String name) {
        try {
            int cnt = Integer.parseInt(txt.getText());

        }   catch (IllegalArgumentException e)
        {return  false;
        }
        return true;
    }

    public boolean validateAgenda(TextField txt, String name) {
        if(txt.getText().compareTo("")==0){

            return false;
        }
        else
            return true;
    }
    public String  tomins(String hours,String minutes,String seconds) {

        double totalsec = 0.0;

        totalsec += Integer.parseInt(hours)*60;
        totalsec +=Integer.parseInt(minutes);
        totalsec +=Integer.parseInt(seconds)/60;

        return (Double.toString(totalsec));
    }

    public void foot(){

    }

}
