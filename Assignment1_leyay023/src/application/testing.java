package application;

public class testing {
	public int days = 0;
	public int hours = 0;
	public int minutes = 0;
	public int seconds = 0;

	public void test(int sec) {

		int secondsInInt = sec;
		days = secondsInInt / (24 * 3600);

		secondsInInt = secondsInInt % (24 * 3600);
		hours = secondsInInt / 3600;

		secondsInInt %= 3600;
		minutes = secondsInInt / 60;

		secondsInInt %= 60;
		seconds = secondsInInt;
		System.out.println(days + " days " + hours + " hours " + minutes + " Minutes " + seconds + " Seconds");
	}

	public void countDown(int sec) {
		int secondsInInt = sec;
		days = secondsInInt / (24 * 3600);

		secondsInInt = secondsInInt % (24 * 3600);
		hours = secondsInInt / 3600;

		secondsInInt %= 3600;
		minutes = secondsInInt / 60;

		secondsInInt %= 60;
		seconds = secondsInInt;
		System.out.println(days + " days " + hours + " hours " + minutes + " Minutes " + seconds + " Seconds");

		for (int i = sec; i >= 0; i--) {
			sec -= 1;
//			if(sec==0 && minutes>=0) {
//				minutes-=1;
//				sec=60;
//				sec-=1;
//			}
			//System.out.println(days + " days " + hours + " hours " + minutes + " Minutes " + seconds + " Seconds");
			System.out.println( sec + " Seconds");
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		testing and = new testing();
		and.test(60);
		and.countDown(70);
	}

}
