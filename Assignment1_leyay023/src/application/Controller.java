    package application;

    import com.opencsv.exceptions.CsvException;
    import javafx.animation.FadeTransition;
    import javafx.animation.Transition;
    import javafx.event.ActionEvent;
    import javafx.event.EventHandler;
    import javafx.geometry.Insets;
    import javafx.geometry.Pos;
    import javafx.scene.Scene;
    import javafx.scene.control.Button;
    import javafx.scene.control.ColorPicker;
    import javafx.scene.layout.*;
    import javafx.scene.paint.Color;
    import javafx.scene.paint.Paint;
    import javafx.scene.text.Text;
    import javafx.stage.Stage;
    import javafx.util.Duration;

    import java.awt.*;
    import java.io.IOException;

    public class Controller {

        public Controller(double x, double y) {

            Meeting_Agenda_Layout mla = new Meeting_Agenda_Layout();
            TimerLayout tml = new TimerLayout();

            Stage primaryStage = new Stage();

            StackPane p = new StackPane();
            BorderPane bp = new BorderPane();

            HBox header = new HBox();

            mla.add.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    tml.getStartButton().setDisable(false);
                }
            });
            Button importcsv = new Button("Import");
            Button exportcsv = new Button("Export");

            //Reference - //https://docs.oracle.com/javafx/2/ui_controla/color-picker.htm
            final ColorPicker colorPicker = new ColorPicker();
            colorPicker.setValue(Color.BLACK);


            header.getChildren().addAll(importcsv,exportcsv,colorPicker);
            header.setSpacing(5);
            header.setPadding(new Insets(10,10,10,10));
            header.setStyle("-fx-background-color:grey;");

            Scene scene = new Scene(p, x, y);


            Button button1 = new Button();
            button1.setText("Start");
            button1.setLayoutX(500);
            button1.setLayoutY(100);
            StackPane.setAlignment(button1, Pos.CENTER);

            // EventHandler for Button

                Scene mainScene = new Scene(bp, 1200, 700);
                // Start Event


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

                    exportcsv.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent event) {
                            try {
                                mla.exportCsv();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    });


                    Button colorbtn = new Button("Color");


                    colorPicker.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent event) {
                            Paint fill = colorPicker.getValue();
                            bp.setBackground(new Background(new BackgroundFill(fill,CornerRadii.EMPTY, Insets.EMPTY)));
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

    }