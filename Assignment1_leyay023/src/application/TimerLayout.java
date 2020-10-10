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
    import javafx.scene.input.MouseEvent;
    import javafx.scene.layout.*;
    import javafx.scene.paint.Color;
    import javafx.scene.text.*;
    import javafx.stage.Stage;
    import javafx.util.Duration;
    import org.w3c.dom.events.Event;

    import java.util.Timer;
    import java.util.TimerTask;

    public class TimerLayout {


        private Label Seconds = timelabel();
        private Label Minutes = timelabel();
        private Label Hours = timelabel();

        private Label dot;
        private Label dot1;

        private HBox container = new HBox();
        private VBox timelayout = new VBox();

        public Button startButton;
        public Button stopButton;
        public Button terminateButton;
        public HBox playpause;

        private Integer STARTTIMEsec;
        private Integer STARTTIMEhours;
        private Integer STARTTIMEmins;

        private Timeline timelinesecs;
        private Timeline timelinehours;
        private Timeline timelinemins;


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

        public void setPlaypause(HBox playpause) {
            this.playpause = playpause;
        }

        public HBox getPlaypause() {
            return playpause;
        }


        public HBox getContainer() {
            return container;
        }


        public VBox getTimelayout() {
            return timelayout;
        }

        public void setTimelayout(VBox timelayout) {
            this.timelayout = timelayout;
        }

        public TimerLayout() {

            Hours.setText("00");
            Hours.setAlignment(Pos.CENTER);

            Seconds.setText("00");
            Seconds.setAlignment(Pos.CENTER);

            Minutes.setText("00");
            Minutes.setAlignment(Pos.CENTER);

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

            stopButton = tobutton(stop);
            terminateButton = tobutton(terminate);

            playpause = new HBox();
            playpause.getChildren().addAll(startButton, stopButton, terminateButton);
            playpause.setSpacing(10);
            playpause.setAlignment(Pos.CENTER);
            // playpause.setDisable(true);

            //dots.setSpacing(5);

            container.setSpacing(2);
            container.getChildren().addAll(Hours, dot, Minutes, dot1, Seconds);
            container.setAlignment(Pos.CENTER);

            timelayout.setAlignment(Pos.CENTER);
            timelayout.getChildren().addAll(container, playpause);
            timelayout.setSpacing(10);


        }

        public Label timelabel() {
            Label lbl = new Label();
            lbl.setPrefWidth(150);
            lbl.setPrefHeight(150);
            lbl.setTextAlignment(TextAlignment.CENTER);
            lbl.setStyle("-fx-text-fill : white  ;-fx-font-size: 50pt");

            return lbl;

        }
        public void startTimer(int hours,int minutes,int secs) {
             System.out.println(hours+minutes+secs);
            STARTTIMEsec = secs;
            STARTTIMEhours = hours;
            STARTTIMEmins = minutes;
            getStartButton().setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
            System.out.println("clcick");
            Timer timer = new Timer();
            TimerTask task = new TimerTask() {
                @Override
                public void run() {
                    Seconds.setText(Integer.toString(STARTTIMEsec));
                    System.out.println(STARTTIMEsec);
                    STARTTIMEsec--;
                    if(STARTTIMEsec == -1){
                        timer.cancel();
                    }
                }
            } ;

                }
            });

//            Timeline timelinesecs;
//            timelinesecs = new Timeline(new KeyFrame(Duration.seconds(1), actionEvent -> countDown(secs,hours,minutes)));
//            timelinesecs.setCycleCount(Timeline.INDEFINITE);
//            timelinesecs.playFromStart();


    //
    //        if (timelinesecs != null  && timelinehours != null&& timelinemins != null) {
    //            timelinesecs.stop();
    //            timelinehours.stop();
    //            timelinemins.stop();
    //        }
    //
            //timelinesecs.playFromStart();

        }
            //Reference - https://www.tutorialspoint.com/how-to-add-an-image-to-a-button-action-in-javafx
        public static Button tobutton(Image img){
            ImageView imgView = new ImageView(img);
            Button button = new Button();
            button.setGraphic(imgView);
            button.setStyle("-fx-background-color:#000000 ");
            button.setPrefHeight(25);
            button.setPrefWidth(25);

            return button;
    }
    public void countDown(int secs, int hours, int minutes) {

        if(secs <= 0)
        {
            secs--;
        }
        System.out.println(secs);
        String tmpsec = secs + "";
        Seconds.setText(tmpsec);

        if (secs == 0) {
            minutes--;
            Minutes.setText(String.valueOf(minutes));
            if (minutes != 0) {
                secs = 60;
                Seconds.setText(String.valueOf(secs));
            }
        }

        if (minutes == 0) {
            hours--;
            Hours.setText(String.valueOf(hours));
            if (hours != 0) {
                minutes = 60;
                Minutes.setText(String.valueOf(minutes));
            }
        }


    }
    }


