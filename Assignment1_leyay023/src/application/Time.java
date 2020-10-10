	package application;

	import javafx.animation.KeyFrame;
	import javafx.animation.KeyValue;
	import javafx.animation.Timeline;
	import javafx.beans.property.IntegerProperty;
	import javafx.beans.property.SimpleIntegerProperty;
	import javafx.event.ActionEvent;
	import javafx.event.EventHandler;
	import javafx.scene.control.Button;
	import javafx.scene.control.Label;
	import javafx.scene.image.Image;
	import javafx.scene.image.ImageView;
	import javafx.scene.layout.HBox;
	import javafx.util.Duration;

	public class Time {
		// private static int cnt ;
		public static int cnt;
		private  Integer STARTTIMEsec = 0;
		private  Integer STARTTIMEhours = 0;
		private  Integer STARTTIMEmins = 0;
		private Timeline timelinesecs;
		private Timeline timelinehours;
		private Timeline timelinemins;
		public Time() {
//			System.out.print(hours+minutes+secs);

			TimerLayout tml = new TimerLayout();
			timelinesecs = new Timeline();
			timelinemins = new Timeline();
			timelinehours = new Timeline();


			// Algorithym to calculate days, hour
			// s, minutes, seconds
		}
			public void startTimer(int hours,int minutes,int secs){

			TimerLayout tml = new TimerLayout();
			STARTTIMEsec = secs;
			STARTTIMEhours = hours;
			STARTTIMEmins = minutes;

			tml.getSeconds().setText(STARTTIMEsec.toString());
			tml.getHours().setText(STARTTIMEhours.toString());
			tml.getMinutes().setText(STARTTIMEmins.toString());


//			ProgressBar bar = new ProgressBar(0);
//			ProgressIndicator progressIndicator = new ProgressIndicator();
///			bar.setPrefSize(200, 24);
			if (timelinesecs != null  && timelinehours != null&& timelinemins != null) {
			timelinesecs.stop();
			timelinehours.stop();
			timelinemins.stop();
			}


			timelinesecs.setCycleCount(Timeline.INDEFINITE);
			timelinesecs.getKeyFrames().add(

			new KeyFrame(Duration.seconds(1), new EventHandler<ActionEvent>() {
			@Override
				public void handle(ActionEvent actionEvent) {
					STARTTIMEsec--;
					tml.getSeconds().setText(STARTTIMEsec.toString());
					if(STARTTIMEsec <=0 ){
						timelinesecs.stop();
					}
				}
			}));
			timelinesecs.playFromStart();

									//timeline.setOnFinished(endEvent -> progressIndicator.setVisible(false));
		}

//

							// Restart Button Creation and EventListener

//							Button RestartButton = new Button("Restart");
//
//							RestartButton.setOnAction(new EventHandler<ActionEvent>() {
//								public void handle(ActionEvent event) {
//									if (!(Days.getText().equals(null) && Hours.getText().equals(null)
//											&& Minutes.getText().equals(null) && Seconds.getText().equals(null))) {
//
//										Days.setText(null);
//										Hours.setText(null);
//										Minutes.setText(null);
//										Seconds.setText(null);
//
//									}
//									timeline.stop();
//
//									startButton.setDisable(false);
//
//								}
//							});


							// Pause_Continue Button
//							Button Stop_ContinueButton = new Button();
//							Stop_ContinueButton.setText("Stop");
//
//							// EventHandler for Pause_Continue Button
//							EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() {
//
//								@Override
//								public void handle(ActionEvent arg0) {
//
//									if (Stop_ContinueButton.getText().equals("Stop")) {
//										Stop_ContinueButton.setText("Continue");
//
//										timelinesecs.pause();
//										do {
//
//
//										} while (Stop_ContinueButton.isPressed());
//
//									} else {
//
//										Stop_ContinueButton.setText("Stop");
//
//										timelinesecs.play();
//									}
//								}
//							};
//							Stop_ContinueButton.setOnAction(event);
//							GP.add(Stop_ContinueButton, 3, 5);
//
//
//					CalButton.setOnAction(StartEvent);

					// Set Label text for Days, Hours, Minutes, Seconds
					// MainScreen Focus



			}









