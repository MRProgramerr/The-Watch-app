package application;

public class testing {
	public int days = 0;
	public int hours = 0;
	public int minutes = 0;
	public int seconds = 0;

	public void test(int hours,int minutes, int secs) {


	}

	public void countDown(int sec) {
			for (int i = sec; i >= 0; i--) {
			sec -= 1;
			if(sec==0 && minutes>=0) {
				minutes-=1;
				sec=60;
				sec-=1;
			}
			//System.out.println(days + " days " + hours + " hours " + minutes + " Minutes " + seconds + " Seconds");
			System.out.println( sec + " Seconds");
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		testing and = new testing();
		//and.test(60);
		and.countDown(70);
	}

}
