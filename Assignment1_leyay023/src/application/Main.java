package application;

//import javax.swing.JFrame;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.stage.Stage;

import javafx.scene.control.Label;

public class Main extends Application {
	// private static int cnt ;
	public static int cnt;
	private static Integer STARTTIME = 0;
	private Timeline timeline;
	private Label timerLabel = new Label();
	private IntegerProperty timeSeconds = new SimpleIntegerProperty(STARTTIME);

	@Override
	public void start(Stage primaryStage) {

		Controller control = new Controller(1200,700);

}

	public static void main(String[] args) {
		launch(args);
	}
}
