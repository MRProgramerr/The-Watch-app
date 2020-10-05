package application;

//import javax.swing.JFrame;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

public class Main extends Application {
	// private static int cnt ;
	public static int cnt;
	private static Integer STARTTIME = 0;
	private Timeline timeline;
	private Label timerLabel = new Label();
	private IntegerProperty timeSeconds = new SimpleIntegerProperty(STARTTIME);

	@Override
	public void start(Stage primaryStage) {

		StackPane p = new StackPane();

		// Background Image
		p.setStyle(
				"-fx-background-image: url(" + "'http://icons.iconarchive.com/icons/iconka/meow/256/cat-box-icon.png'"
						+ "); " + "-fx-background-size: cover;");
		Scene scene = new Scene(p, 400, 400);

		// Title Creatio and Configure
		Text TimerTitle = new Text();
		TimerTitle.setText("Countdown-Timer for team meeting");
		TimerTitle.setTextAlignment(TextAlignment.CENTER);
		TimerTitle.setStrokeWidth(2);
		TimerTitle.setStroke(Color.BLUE);
		TimerTitle.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
		TimerTitle.setFill(Color.BROWN);

		// Button Creation and Configure
		Button button1 = new Button();
		button1.setText("Start");
		button1.setLayoutX(500);
		button1.setLayoutY(100);
		StackPane.setAlignment(TimerTitle, Pos.TOP_CENTER);
		StackPane.setAlignment(button1, Pos.CENTER);

		// EventHandler for Button
		EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() {
			GridPane GP = new GridPane();
			ColumnConstraints column4 = new ColumnConstraints();

			Scene mainScene = new Scene(GP, 400, 400);

			@Override
			public void handle(ActionEvent arg0) {

				// TODO Auto-generated method stub
				column4.setPercentWidth(10);
				GP.getColumnConstraints().addAll(column4);

				// Input Label
				Label InputLabel = new Label();
				InputLabel.setText("Times (Second):");

				// TextField Creation
				TextField InputTextField = new TextField();

				// Calculation Button Create
				Button CalButton = new Button();
				CalButton.setText("Calculate");

				// Start Event
				EventHandler<ActionEvent> StartEvent = new EventHandler<ActionEvent>() {

					@Override
					public void handle(ActionEvent arg0) {
						// TODO Auto-generated method stub
						// Check for user input
						try {
							cnt = Integer.parseInt(InputTextField.getText());
						} catch (IllegalArgumentException e) {
							System.out.println("Wrong Input Type");
							System.exit(0);
						}

						// Algorithym to calculate days, hours, minutes, seconds
						int secondsInInt = cnt;
						int days = secondsInInt / (24 * 3600);

						secondsInInt = secondsInInt % (24 * 3600);
						int hours = secondsInInt / 3600;

						secondsInInt %= 3600;
						int minutes = secondsInInt / 60;

						secondsInInt %= 60;
						int seconds = secondsInInt;
						Label Days = new Label();
						Days.setText(String.valueOf(days));
						Label Hours = new Label();
						Hours.setText(String.valueOf(hours));
						Label Minutes = new Label();
						Minutes.setText(String.valueOf(minutes));
						Label Seconds = new Label();
						Seconds.setText(String.valueOf(seconds));

						// Add all labels to GridPane
						GP.add(Days, 0, 3);
						GP.add(Hours, 1, 3);
						GP.add(Minutes, 2, 3);
						GP.add(Seconds, 3, 3);

						timerLabel.textProperty().bind(timeSeconds.asString());
						STARTTIME = Integer.parseInt(InputTextField.getText());

						// Start Button Create and Event Listener
						Button startButton = new Button();
						startButton.setText("Start");
						startButton.setOnAction(new EventHandler<ActionEvent>() {
							public void handle(ActionEvent event) {

								ProgressBar bar = new ProgressBar(0);
								ProgressIndicator progressIndicator = new ProgressIndicator();

								bar.setPrefSize(200, 24);

								startButton.setDisable(true);
								if (timeline != null) {
									timeline.stop();
								}
								timeSeconds.set(STARTTIME);
								timeline = new Timeline(
										new KeyFrame(Duration.seconds(2), new KeyValue(bar.progressProperty(), 1)));
								timeline.getKeyFrames().add(
										new KeyFrame(Duration.seconds(STARTTIME + 1), new KeyValue(timeSeconds, 0)));
								timeline.playFromStart();
								timeline.setOnFinished(endEvent -> progressIndicator.setVisible(false));

								// Add "Start Button" to GridPane
								GP.add(progressIndicator, 5, 5);
							}
						});
						Label timeRemaning = new Label("Time Remaining: ");

						GP.add(timeRemaning, 0, 5);
						GP.add(timerLabel, 1, 5);
						GP.add(startButton, 2, 5);

						// Restart Button Creation and EventListener

						Button RestartButton = new Button("Restart");

						RestartButton.setOnAction(new EventHandler<ActionEvent>() {
							public void handle(ActionEvent event) {
								if (!(Days.getText().equals(null) && Hours.getText().equals(null)
										&& Minutes.getText().equals(null) && Seconds.getText().equals(null))) {

									Days.setText(null);
									Hours.setText(null);
									Minutes.setText(null);
									Seconds.setText(null);

								}
								timeline.stop();

								startButton.setDisable(false);

							}
						});

						GP.add(RestartButton, 3, 0);

						// Pause_Continue Button
						Button Stop_ContinueButton = new Button();
						Stop_ContinueButton.setText("Stop");

						// EventHandler for Pause_Continue Button
						EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() {

							@Override
							public void handle(ActionEvent arg0) {

								if (Stop_ContinueButton.getText().equals("Stop")) {
									Stop_ContinueButton.setText("Continue");

									timeline.pause();
									do {

										System.out.println("Checkpoint: " + timerLabel.getText());

									} while (Stop_ContinueButton.isPressed());

								} else {

									Stop_ContinueButton.setText("Stop");

									timeline.play();
								}
							}
						};
						Stop_ContinueButton.setOnAction(event);
						GP.add(Stop_ContinueButton, 3, 5);
					}
				};
				CalButton.setOnAction(StartEvent);

				// Set Label text for Days, Hours, Minutes, Seconds
				Label DaysLabel = new Label();
				DaysLabel.setText("Days");
				Label HoursLabel = new Label();
				HoursLabel.setText("Hours");
				Label MinutesLabel = new Label();
				MinutesLabel.setText("Minutes");
				Label SecondsLabel = new Label();
				SecondsLabel.setText("Seconds");

				// Setting size for the pane
				GP.setMinSize(400, 200);

				// Setting the padding
				GP.setPadding(new Insets(10, 10, 10, 10));

				// Setting the vertical and horizontal gaps between the columns
				GP.setVgap(10);
				GP.setHgap(10);

				// Setting the Grid alignment and background colour
				GP.setStyle("-fx-background-color: blue;");
				GP.setAlignment(Pos.CENTER);

				// Add all children to GridPane
				GP.add(DaysLabel, 0, 2);
				GP.add(HoursLabel, 1, 2);
				GP.add(MinutesLabel, 2, 2);
				GP.add(SecondsLabel, 3, 2);
				GP.add(InputLabel, 0, 0);
				GP.add(InputTextField, 1, 0);

				// Add Calculation button to GridPane
				GP.add(CalButton, 2, 0);

				// MainScreen Focus
				primaryStage.setScene(mainScene);
				primaryStage.show();
			}
		};

		button1.setOnAction(event);

		p.getChildren().add(TimerTitle);
		p.getChildren().add(button1);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage.setTitle("Timer-CountDown");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
