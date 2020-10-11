package application;

import com.opencsv.exceptions.CsvException;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Controller {

    public Controller(double x, double y) {
        TimerLayout tml = new TimerLayout();
        Stage primaryStage = new Stage();
        StackPane p = new StackPane();
        BorderPane bp = new BorderPane();
        HBox header = new HBox();

        Button importcsv = new Button("Import");
        Button exportcsv = new Button("Export");

        header.getChildren().addAll(importcsv,exportcsv);
        header.setSpacing(5);

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

        //	public void start(Stage primaryStage) {
        //
        //		StackPane p = new StackPane();
        //
        //		// Background Image
        //		p.setStyle(
        //				"-fx-background-image: url(" + "'http://icons.iconarchive.com/icons/iconka/meow/256/cat-box-icon.png'"
        //						+ "); " + "-fx-background-size: cover;");
        //		Scene scene = new Scene(p, 400, 400);
        //
        //		// Title Creatio and Configure
        //		Text TimerTitle = new Text();
        //		TimerTitle.setText("Countdown-Timer for team meeting");
        //		TimerTitle.setTextAlignment(TextAlignment.CENTER);
        //		TimerTitle.setStrokeWidth(2);
        //		TimerTitle.setStroke(Color.BLUE);
        //		TimerTitle.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
        //		TimerTitle.setFill(Color.BROWN);
        //
        //		// Button Creation and Configure
        //		Button button1 = new Button();
        //		button1.setText("Start");
        //		button1.setLayoutX(500);
        //		button1.setLayoutY(100);
        //		StackPane.setAlignment(TimerTitle, Pos.TOP_CENTER);
        //		StackPane.setAlignment(button1, Pos.CENTER);
        // Button Creation and Configure

        Button button1 = new Button();
        button1.setText("Start");
        button1.setLayoutX(500);
        button1.setLayoutY(100);
        StackPane.setAlignment(button1, Pos.CENTER);

        // EventHandler for Button
        button1.setOnAction(new EventHandler<ActionEvent>() {

            Scene mainScene = new Scene(bp, 1200, 700);
            // Start Event

            @Override
            public void handle(ActionEvent arg0) {

                importcsv.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        try {
                            mla.importCsv();
                        } catch (IOException e) {
                            e.printStackTrace();
                        } catch (CsvException e) {
                            e.printStackTrace();
                        }
                    }
                });
                bp.setCenter(tml.getTimelayout());
                bp.setStyle("-fx-background-color:#000000 ");
                bp.setRight(mla.getAgenda_vbox());
                bp.setTop(header);
                // MainScreen Focus
                primaryStage.setScene(mainScene);
                primaryStage.setMaximized(true);
                primaryStage.show();

            }
        });


        p.getChildren().add(button1);
        scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
        primaryStage.setTitle("Timer-CountDown");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

}

