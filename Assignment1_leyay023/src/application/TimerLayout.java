package application;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.text.*;
import javafx.util.Duration;

import java.util.ArrayList;


public class TimerLayout {

    private Integer STARTTIME ;
    private Label SecondsLabel;
    private Label MinutesLabel;
    private Label HoursLabel;


    private Label dot;
    private Label dot1;

    private HBox container = new HBox();
    private VBox timelayout = new VBox();

    private Button startButton;
    private Button stopButton;
    private Button terminateButton;
    private HBox playpause;

    private Integer STARTTIMEsec;
    private Integer STARTTIMEmins;
    private Integer STARTTIMEhours;

    public static ArrayList<Timer> times = new ArrayList<Timer>();


    public HBox getPlaypause() {
        return playpause;
    }

    public void setPlaypause(HBox playpause) {
        this.playpause = playpause;
    }

    public TimerLayout() {

        HoursLabel = timelabel();
        SecondsLabel = timelabel();
        MinutesLabel = timelabel();

        HoursLabel.setText("00");
        HoursLabel.setAlignment(Pos.CENTER);

        SecondsLabel.setText("00");
        SecondsLabel.setAlignment(Pos.CENTER);

        MinutesLabel.setText("00");
        MinutesLabel.setAlignment(Pos.CENTER);

        dot = timelabel();
        dot.setText(":");
        dot.setAlignment(Pos.CENTER);

        dot1 = timelabel();
        dot1.setText(":");
        dot1.setAlignment(Pos.CENTER);

        Image start = new Image("/start.png", 50, 50, true, true);
        Image stop = new Image("/stop.png", 50, 50, true, true);
        Image terminate = new Image("/terminate.png", 50, 50, true, true);

        startButton = tobutton(start);
        startButton.setDisable(true);
        stopButton = tobutton(stop);
        terminateButton = tobutton(terminate);

        playpause = new HBox();
        playpause.getChildren().addAll(startButton, stopButton, terminateButton);
        playpause.setSpacing(10);
        playpause.setAlignment(Pos.CENTER);
        //  playpause.setDisable(true);


        container.setSpacing(2);
        container.getChildren().addAll(HoursLabel, dot, MinutesLabel, dot1, SecondsLabel);
        container.setAlignment(Pos.CENTER);

        timelayout.setAlignment(Pos.CENTER);
        timelayout.getChildren().addAll(container, playpause);
        timelayout.setSpacing(10);

        startButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {

                STARTTIMEsec = times.get(0).getSecs()%60;
                STARTTIMEmins = times.get(0).getMinutes()+times.get(0).getSecs()/60;
                STARTTIMEhours = times.get(0).getHours()+STARTTIMEmins/60;



                SecondsLabel.setText(String.format("%02d",STARTTIMEsec));
                MinutesLabel.setText(String.format("%02d",STARTTIMEmins));
                HoursLabel.setText(String.format("%02d",(STARTTIMEhours)));

                System.out.println(start);
                Timeline timeline = new Timeline();
                KeyFrame keyFrame = new KeyFrame(
                        Duration.seconds(1), new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        STARTTIMEsec--;
                        SecondsLabel.setText(String.format("%02d",STARTTIMEsec));
                        if (STARTTIMEsec == 0 && STARTTIMEmins !=0) {
                            STARTTIMEmins--;
                            MinutesLabel.setText(String.format("%02d",STARTTIMEmins));

                            SecondsLabel.setText(String.format("%02d",STARTTIMEsec));
                            STARTTIMEsec = 60;
                            if(STARTTIMEhours == 0){
                                HoursLabel.setText(String.format("%02d",00));
                            }
                        }

                        if (STARTTIMEmins == 0 && STARTTIMEhours!=0) {
                            STARTTIMEhours--;
                            HoursLabel.setText(String.format("%02d",STARTTIMEhours));
                            STARTTIMEmins = 00;
                            if(STARTTIMEhours==0){
                                MinutesLabel.setText(String.format("%02d",00));
                                STARTTIMEmins = 60;
                                HoursLabel.setText(String.format("%02d",01));}
                            else {
                                STARTTIMEmins = 60;
                                MinutesLabel.setText(String.format("%02d", 00));
                            }
                        }
                        if(STARTTIMEsec ==0 && STARTTIMEhours ==0&& STARTTIMEmins==0) {
                            timeline.stop();
                        }
                    }
                }
                );
                timeline.setCycleCount(Timeline.INDEFINITE);
                timeline.getKeyFrames().add(keyFrame);
                if(timeline!=null){
                    timeline.stop();
                }
                timeline.playFromStart();
            }
        });
    }

    public Label timelabel() {

        Label lbl = new Label();
        lbl.setPrefWidth(150);

        lbl.setPrefHeight(150);
        lbl.setTextAlignment(TextAlignment.CENTER);
        lbl.setStyle("-fx-text-fill : white  ;-fx-font-size: 50pt");

        return lbl;
    }

    //Reference - https://www.tutorialspoint.com/how-to-add-an-image-to-a-button-action-in-javafx
    public  Button tobutton(Image img){
        ImageView imgView = new ImageView(img);
        Button button = new Button();
        button.setGraphic(imgView);
        button.setStyle("-fx-background-color:#000000 ");
        button.setPrefHeight(25);
        button.setPrefWidth(25);

        return button;
    }

    public Label getSecondsLabel() {
        return SecondsLabel;
    }

    public void setSecondsLabel(Label secondsLabel) {
        SecondsLabel = secondsLabel;
    }

    public Label getMinutesLabel() {
        return MinutesLabel;
    }

    public void setMinutesLabel(Label minutesLabel) {
        MinutesLabel = minutesLabel;
    }

    public Label getHoursLabel() {
        return HoursLabel;
    }

    public void setHoursLabel(Label hoursLabel) {
        HoursLabel = hoursLabel;
    }
    public Button getStartButton() {
        return startButton;
    }

    public void setStartButton(Button startButton) {
        this.startButton = startButton;
    }

    public VBox getTimelayout() {
        return timelayout;
    }

    public void setTimelayout(VBox timelayout) {
        this.timelayout = timelayout;
    }

}
