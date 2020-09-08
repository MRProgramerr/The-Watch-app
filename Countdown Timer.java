import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

// Referenced from Stackoverflow, will be changed and developed further once we get a full idea on how we want to structure the software.
/** * * @author Edric Kenneth Gilberto Laitly * */

public class main {
static int betweenchanges;
static Timer currenttimer;

public static void main(String[] args) 
{
    Scanner scanner1 = new Scanner(System.in);
    System.out.print("Enter Amount of Time >>  ");
    String seconds = scanner1.nextLine();
    int delay = 2500;
    int period = 2500;
    currenttimer = new Timer();
    betweenchanges = Integer.parseInt(seconds);
    System.out.println(seconds);
    currenttimer.scheduleAtFixedRate(new TimerTask()
    {

        public void run() 
        {
            System.out.println(setChanges());

        }
    }, delay, period);
}

private static final int setChanges() 
{
    if (betweenchanges == 1)
        currenttimer.cancel();
    return --betweenchanges;
}
}