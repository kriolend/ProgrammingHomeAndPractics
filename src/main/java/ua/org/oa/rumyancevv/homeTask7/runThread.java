package ua.org.oa.rumyancevv.homeTask7;

import java.text.DateFormat;
import java.util.Date;

/**
 * Created by vr on 22.02.16.
 */
public class runThread extends Thread {
    private boolean runinng = false;

    public void runT() {
        runinng = true;
        interrupt();
    }

    @Override
    public void run() {
        while (!runinng) {
            Date currentDate = new Date();
            System.out.println(DateFormat.getTimeInstance().format(currentDate) + " Thread");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {

            }
        }
    }
}
