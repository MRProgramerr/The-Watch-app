
package application;

public class Timer {
	private int secs;
	private int hours;
	private int minutes;
	TimerLayout timerLayout;

	public Timer(int hour, int minute,int sec){
		this.secs =sec;
		this.hours=hour;
		this.minutes=minute;


	}
	public int getMinutes() {
		return minutes;
	}

	public void setMinutes(int minutes) {
		this.minutes = minutes;
	}

	public int getSecs() {
		return secs;
	}

	public void setSecs(int secs) {
		this.secs = secs;
	}

	public int getHours() {
		return hours;
	}

	public void setHours(int hours) {
		this.hours = hours;
	}

}








