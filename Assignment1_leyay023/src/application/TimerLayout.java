package application;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.*;
import javafx.stage.Stage;
import javafx.util.Duration;

public class TimerLayout {


    private Button Seconds = timebox();
    private Button Minutes = timebox();
    private Button Hours = timebox();
    private VBox dots = new VBox();
    private VBox dots1 = new VBox();
    private Text dot = new Text();
    private Text dot1 = new Text();
    private HBox container = new HBox();
    private VBox timelayout = new VBox();
    public Button startButton;
    public Button stopButton;
    public Button terminateButton;
    public  HBox playpause;


    public Button getStartButton() {
        return startButton;
    }

    public void setStartButton(Button startButton) {
        this.startButton = startButton;
    }

    public Button getStopButton() {
        return stopButton;
    }

    public void setStopButton(Button stopButton) {
        this.stopButton = stopButton;
    }

    public Button getTerminateButton() {
        return terminateButton;
    }

    public void setTerminateButton(Button terminateButton) {
        this.terminateButton = terminateButton;
    }

    public  void setPlaypause(HBox playpause) {
        this.playpause = playpause;
    }

    public  HBox getPlaypause() {
        return playpause;
    }


    public HBox getContainer() {
        return container;
    }

    public Button getSeconds() {
        return Seconds;
    }

    public void setSeconds(Button seconds) {
        Seconds = seconds;
    }

    public Button getMinutes() {
        return Minutes;
    }

    public void setMinutes(Button minutes) {
        Minutes = minutes;
    }

    public Button getHours() {
        return Hours;
    }

    public void setHours(Button hours) {
        Hours = hours;
    }

    public VBox getTimelayout() {
        return timelayout;
    }

    public void setTimelayout(VBox timelayout) {
        this.timelayout = timelayout;
    }

    public  TimerLayout() {

        dot.setText(".");
        dot1.setText(".");
        dot.setStyle("-fx-text-fill : white");
        dot1.setStyle("-fx-text-fill : white");

        dot.prefHeight(5);
        dot.prefWidth(5);
        dot1.prefHeight(5);
        dot1.prefWidth(5);

        dots.getChildren().addAll(dot1, dot);
        dots1.getChildren().addAll(dot1, dot);

        Image start = new Image("/start.png",50,50,true,true);
        Image stop = new Image("/stop.png",50,50,true,true);
        Image terminate = new Image("/terminate.png",50,50,true,true);

        startButton =  tobutton(start);
        stopButton = tobutton(stop);
        terminateButton = tobutton(terminate);

        playpause = new HBox();
        playpause.getChildren().addAll(startButton,stopButton,terminateButton);
        playpause.setSpacing(20);
        playpause.setAlignment(Pos.CENTER);
       // playpause.setDisable(true);

        //dots.setSpacing(5);
        Hours.setText("00");
        Minutes.setText("00");
        Seconds.setText("00");

        container.setSpacing(10);
        container.getChildren().addAll(Hours, dots, Minutes, dots1, Seconds);
        container.setAlignment(Pos.CENTER);

        timelayout.setAlignment(Pos.CENTER);
        timelayout.getChildren().addAll(container,playpause);
        timelayout.setSpacing(20);


    }
    //refernce: http://tutorials.jenkov.com/javafx/button.html
    public Button timebox() {
        Button button = new Button();
        button.setPrefWidth(200);
        button.setPrefHeight(200);
//       button.setTextAlignment(TextAlignment.CENTER);
        button.setStyle(" -fx-background-color:#000000 ; -fx-text-fill : white  ;-fx-font-size: 50pt");

        return button;

    }
    //Referenc - https://www.tutorialspoint.com/how-to-add-an-image-to-a-button-action-in-javafx
    public Button tobutton(Image img){
        ImageView imgView = new ImageView(img);
        Button button = new Button();
        button.setGraphic(imgView);
        button.setStyle("-fx-background-color:#000000 ");
        button.setPrefHeight(25);
        button.setPrefWidth(25);

        return button;
}
}


