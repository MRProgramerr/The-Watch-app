
package application;

import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class Meeting_Agenda_Layout {
    private static HBox Task_Pane = new HBox();
    private static VBox Agenda_vbox = new VBox();
    private static VBox Meeting_vbox = new VBox();
    private TextField meeting_name = new TextField();
    private TextField meeting_agenda = new TextField();
    private TextField meeting_sec = new TextField();
    private TextField meeting_hours = new TextField();
    private TextField meeitng_minute = new TextField();

    public Meeting_Agenda_Layout() {
        new Text("  :  ");
        this.meeting_agenda.setPromptText("Task");
        this.meeting_agenda.setPrefWidth(100.0D);
        this.meeting_agenda.setPrefHeight(30.0D);
        this.meeting_name.setPromptText("Agenda");
        this.meeting_name.setPrefWidth(100.0D);
        this.meeting_sec.setPromptText("00");
        this.meeting_sec.setPrefWidth(30.0D);
        this.meeitng_minute.setPromptText("00");
        this.meeitng_minute.setPrefWidth(30.0D);
        this.meeting_hours.setPromptText("00");
        this.meeting_hours.setPrefWidth(30.0D);

        Task_Pane.getChildren().addAll(new Node[]{this.meeting_name, new Text("    "), this.meeting_hours, new Text("  :  "), this.meeitng_minute, new Text("  :  "), this.meeting_sec});
        Task_Pane.setPadding(new Insets(20.0D, 20.0D, 10.0D, 20.0D));
        Agenda_vbox.getChildren().addAll(new Node[]{Task_Pane, this.meeting_agenda});
        Agenda_vbox.setPadding(new Insets(20.0D, 20.0D, 20.0D, 10.0D));
    }

    public VBox getAgenda_vbox() {
        return Agenda_vbox;
    }

    public static void setAgenda_vbox(VBox agenda_vbox) {
        Agenda_vbox = agenda_vbox;
    }
}
