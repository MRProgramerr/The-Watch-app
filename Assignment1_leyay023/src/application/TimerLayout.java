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

    public HBox getContainer() {
        return container;
    }

    public  TimerLayout(double x, double y){
        dot.setText(".");
        dot1.setText(".");
        dot.setStyle("-fx-text-fill : white");
        dot1.setStyle("-fx-text-fill : white");

        dot.prefHeight(5);
        dot.prefWidth(5);
        dot1.prefHeight(5);
        dot1.prefWidth(5);

        dots.getChildren().addAll(dot1,dot);
        dots1.getChildren().addAll(dot1,dot);
        //dots.setSpacing(5);
        Hours.setText("00");
        Minutes.setText("00");
        Seconds.setText("00");
        container.setSpacing(10);
        container.getChildren().addAll(Hours,dots,Minutes,dots1,Seconds);
        container.setAlignment(Pos.CENTER);

        Stage primaryStage = new Stage();
        StackPane p = new StackPane();
        BorderPane bp = new BorderPane();
        Meeting_Agenda_Layout mla = new Meeting_Agenda_Layout();
        // Background Image
        //
        p.setStyle(
                "-fx-background-image: url(" + "'http://icons.iconarchive.com/icons/iconka/meow/256/cat-box-icon.png'"
                        + "); " + "-fx-background-size: cover;");
        Scene scene = new Scene(p, x, y);

//        // Title Creatio and Configure
//        Text TimerTitle = new Text();
//        TimerTitle.setTextAlignment(TextAlignment.CENTER);
//        TimerTitle.setStrokeWidth(2);
//        TimerTitle.setStroke(Color.BLUE);
//        TimerTitle.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
//        TimerTitle.setFill(Color.BROWN);

        // Button Creation and Configure
        Button button1 = new Button();
        button1.setText("Start");
        button1.setLayoutX(500);
        button1.setLayoutY(100);
        StackPane.setAlignment(button1, Pos.CENTER);

        // EventHandler for Button
        EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() {

            Scene mainScene = new Scene(bp, 1200, 700);

            @Override
            public void handle(ActionEvent arg0){

                // Start Event
                EventHandler<ActionEvent> StartEvent = new EventHandler<ActionEvent>() {

                    @Override
                    public void handle(ActionEvent arg0) {
                        // Check for user input

                        // Algorithym to calculate days, hours, minutes, seconds

//						startButton.setOnAction(new EventHandler<ActionEvent>() {
//							public void handle(ActionEvent event) {
//
//								ProgressBar bar = new ProgressBar(0);
//								ProgressIndicator progressIndicator = new ProgressIndicator();
//
//								bar.setPrefSize(200, 24);
//
//								startButton.setDisable(true);
//								if (timeline != null) {
//									timeline.stop();
//								}
//								timeSeconds.set(STARTTIME);
//								timeline = new Timeline(
//										new KeyFrame(Duration.seconds(2), new KeyValue(bar.progressProperty(), 1)));
//								timeline.getKeyFrames().add(
//										new KeyFrame(Duration.seconds(STARTTIME + 1), new KeyValue(timeSeconds, 0)));
//								timeline.playFromStart();
//								timeline.setOnFinished(endEvent -> progressIndicator.setVisible(false));
//
//								// Add "Start Button" to GridPane
//
//							}
//						});


                        // Restart Button Creation and EventListener

//						Button RestartButton = new Button("Restart");
//
//						RestartButton.setOnAction(new EventHandler<ActionEvent>() {
//							public void handle(ActionEvent event) {
//								if (!(Days.getText().equals(null) && Hours.getText().equals(null)
//										&& Minutes.getText().equals(null) && Seconds.getText().equals(null))) {
//
//									Days.setText(null);
//									Hours.setText(null);
//									Minutes.setText(null);
//									Seconds.setText(null);
//
//								}
//								timeline.stop();
//
//								startButton.setDisable(false);
//
//							}
//						});

                        // Pause_Continue Button
                        Button Stop_ContinueButton = new Button();
                        Stop_ContinueButton.setText("Stop");

                        // EventHandler for Pause_Continue Button
                    }
                };
      //          start.setOnAction(StartEvent);


                bp.setCenter(getContainer());
                bp.setStyle("-fx-background-color:#2a2a2a ");
    			bp.setRight(mla.getAgenda_vbox());
                // MainScreen Focus
                primaryStage.setScene(mainScene);
                primaryStage.setMaximized(true);
                primaryStage.show();
            }
        };

        button1.setOnAction(event);

//        p.getChildren().add(TimerTitle);
        p.getChildren().add(button1);
        scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
        primaryStage.setTitle("Timer-CountDown");
        primaryStage.setScene(scene);
        primaryStage.show();

    }
    public static Button timebox(){
        Button button = new Button();
        button.setPrefWidth(200);
        button.setPrefHeight(200);
        button.setTextAlignment(TextAlignment.CENTER);
        button.setStyle(" -fx-background-color:#2a2a2a ; -fx-text-fill : white  ;-fx-font-size: 50pt");

        return button;

    }
}
