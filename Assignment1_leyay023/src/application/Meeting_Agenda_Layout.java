
package application;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;

public class Meeting_Agenda_Layout {
    private static GridPane Agenda_Pane = new GridPane();
    private TableView table = new TableView();
    private static VBox Agenda_vbox = new VBox();
    private static HBox Navbar = new HBox();
    private static VBox Agendas = new VBox();
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
    private static ObservableList<Meeting_Agenda> tasksList = FXCollections.observableArrayList();


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

    public static VBox getAgendas() {
        return Agendas;
    }

    public static void setAgendas(VBox agendas) {
        Agendas = agendas;
    }

    public Meeting_Agenda_Layout() {
        remove =  new Button("X");
        meeting_agenda.setPromptText("Agenda");
        meeting_agenda.setPrefWidth(100.0D);
        meeting_agenda.setPrefHeight(30.0D);
        taskname.setPromptText("Task");
        taskname.setPrefWidth(100.0D);
        meeting_sec.setPromptText("00");
        meeting_sec.setPrefWidth(30.0D);
        meeitng_minute.setPromptText("00");
        meeitng_minute.setPrefWidth(30.0D);
        meeting_hours.setPromptText("00");
        meeting_hours.setPrefWidth(30.0D);
        add = new Button("Add");

        hoursLabel.setText("H");
        minLabel.setText("Min");
        secLabel.setText("Sec");
        agendaLabel.setText("Agenda");
        taskLabel.setText("Task");

        table.setEditable(true);

        TableColumn agendaCol = new TableColumn("Agendas");
        TableColumn subtaskCol = new TableColumn("Sub-Tasks");
        TableColumn thrs = new TableColumn("H");
        TableColumn tmins = new TableColumn("M");
        TableColumn tsecs = new TableColumn("S");


        agendaCol.setMinWidth(100);
        agendaCol.setCellValueFactory(new PropertyValueFactory<Meeting_Agenda,String>("meeting_agenda"));
        subtaskCol.setMinWidth(200);
        subtaskCol.setCellValueFactory(new PropertyValueFactory<Meeting_Agenda,String>("taskname"));
        thrs.setMinWidth(20);
        thrs.setCellValueFactory(new PropertyValueFactory<Meeting_Agenda,String>("meeting_hours"));
        tmins.setMinWidth(20);
        tmins.setCellValueFactory(new PropertyValueFactory<Meeting_Agenda,String>("meeitng_minute"));
        tsecs.setMinWidth(20);
        tsecs.setCellValueFactory(new PropertyValueFactory<Meeting_Agenda,String>("meeting_sec"));


        // tselect.setMinWidth(20);



        table.getColumns().addAll(agendaCol,subtaskCol,thrs,tmins,tsecs);
        table.setItems(tasksList);


        Agendas.setPadding(new Insets(10,10,10,10));
        Agendas.getChildren().add(table);
        Agendas.setStyle("-fx-background-color: chocolate;-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.8), 10, 0, " +
                "0, 0); ");

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

        Agenda_vbox.getChildren().addAll(agendaLabel,meeting_agenda, Agenda_Pane,table);
        Agenda_vbox.setPadding(new Insets(20.0D, 20.0D, 20.0D, 10.0D));


        //Agendas.setBackground(new Background(new BackgroundFill(Color.CHOCOLATE,null,null)));

        if(tasksList.size()==0 && check == true)
        add.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                    if(validateAgenda(meeting_agenda,"Agenda") && validateAgenda(taskname,"task")  &&validateTime(meeitng_minute, "minute") && validateTime(meeting_hours,"hours") && validateTime(meeting_sec,"secomd")) {
                        tasksList.add(new Meeting_Agenda(meeting_agenda.getText(),taskname.getText(), meeting_hours.getText(),meeitng_minute.getText(),meeting_sec.getText()));
                        meeting_agenda.clear();
                        meeting_sec.clear();
                        meeting_hours.clear();
                        meeitng_minute.clear();
                        taskname.clear();

                    }

                }

        });

        table.getSelectionModel().getSelectedItems().addListener(new ListChangeListener<Meeting_Agenda>() {
            @Override
            public void onChanged(Change<? extends Meeting_Agenda> change) {
                TimerLayout tml = new TimerLayout();
                for(Meeting_Agenda ma : change.getList()){
                    int hours = Integer.parseInt(ma.getMeeting_hours().getText());
                    int mins = Integer.parseInt(ma.getMeeitng_minute().getText());
                    int sec = Integer.parseInt(ma.getMeeting_sec().getText());

                   tml.startTimer(hours,mins,sec);
                }
            }


        });
    }


    private void runtimer() {
        //tml.playpause.setDisable(false);

}




    public boolean validateTime(TextField txt, String name) {
        try {

            int cnt = Integer.parseInt(txt.getText());
            return true;
        }
        catch (IllegalArgumentException e){
            Alert a = new Alert(Alert.AlertType.WARNING, "Please Enters Numeric value only");
            a.setAlertType(Alert.AlertType.ERROR);
            a.showAndWait();

            return  false;
        }

    }

    public boolean validateAgenda(TextField txt, String name) {
        if(txt.getText().compareTo("")==0){

            Alert a = new Alert(Alert.AlertType.WARNING, "Please fill all the fields");
            a.setAlertType(Alert.AlertType.ERROR);
            a.showAndWait();
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

   //reference - https://www.gemboxsoftware.com/spreadsheet-java/examples/javafx-import-export-excel-tableview/5301
    //reference - https://gist.github.com/MenaiAla/7768b89ba27c243cf6477cd9cfc58193
    public  static void importCsv() throws IOException, CsvException {
     try {
         FileChooser chooser = new FileChooser();
         chooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("CSV files(*.csv)","*.csv"));
         chooser.setTitle("Open File");
         File file = chooser.showOpenDialog(new Stage());

         FileReader fileReader = new FileReader(file.getAbsolutePath());
         BufferedReader br = new BufferedReader(fileReader);

         String record;
         while ((record = br.readLine()) != null) {

             String[]records = record.split(",");

             tasksList.add(new Meeting_Agenda(records[0],records[1],records[2],records[3],records[4]));

         }
     }catch (Exception e){
         e.printStackTrace();
     }

    }
    public static void exportCsv() throws IOException {
        Writer writer = null;
        try{
            File file = new File("Agendas.csv");

            writer = new BufferedWriter(new FileWriter(file));

            for(Meeting_Agenda agenda : tasksList){
                String str = agenda.getMeeting_agenda().getText()+", "+agenda.getTaskname().getText()+", "+agenda.getMeeting_hours().getText()+", "+agenda.getMeeitng_minute().getText()+","+agenda.getMeeting_sec().getText()+"\n";
                writer.write(str);
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            writer.flush();
            writer.close();
        }
    }

    public void head(){

    }

}
