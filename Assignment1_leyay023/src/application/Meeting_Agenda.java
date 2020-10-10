package application;

import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

public class Meeting_Agenda {
    private Text taskname;
    private Text meeting_agenda;
    private Text meeting_sec;
    private Text meeting_hours;
    private Text meeitng_minute;
    private Button Select;

    public Text getTaskname() {
        return this.taskname;
    }

    public void setTaskname(Text taskname) {
        this.taskname = taskname;
    }

    public Text getMeeting_agenda() {
        return this.meeting_agenda;
    }

    public void setMeeting_agenda(Text meeting_agenda) {
        this.meeting_agenda = meeting_agenda;
    }

    public Text getMeeting_sec() {
        return this.meeting_sec;
    }

    public void setMeeting_sec(Text meeting_sec) {
        this.meeting_sec = meeting_sec;
    }

    public Text getMeeting_hours() {
        return this.meeting_hours;
    }

    public void setMeeting_hours(Text meeting_hours) {
        this.meeting_hours = meeting_hours;
    }

    public Text getMeeitng_minute() {
        return this.meeitng_minute;
    }

    public void setMeeitng_minute(Text meeitng_minute) {
        this.meeitng_minute = meeitng_minute;
    }

    public Button getSelect() {
        return this.Select;
    }

    public Meeting_Agenda(String meeting_name, String meeting_agenda, String meeting_sec, String meeting_hours, String meeitng_minute) {
        this.meeting_agenda = new Text(meeting_agenda);
        this.taskname = new Text(meeting_name);
        this.meeting_hours = new Text(meeting_hours);
        this.meeitng_minute = new Text(meeitng_minute);
        this.meeting_sec = new Text(meeting_sec);
        this.Select = new Button("Select");
    }

   // https://www.gemboxsoftware.com/spreadsheet-java/examples/javafx-import-export-excel-tableview/5301
}
