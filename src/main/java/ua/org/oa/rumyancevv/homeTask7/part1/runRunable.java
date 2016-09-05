package ua.org.oa.rumyancevv.homeTask7.part1;

import java.text.DateFormat;
import java.util.Date;

/**
 * Created by vr on 22.02.16.
 */
public class runRunable implements Runnable {
    private boolean runinng = false;



    @Override
    public void run() {
        while (!runinng) {
            Date currentDate = new Date();
            System.out.println(DateFormat.getTimeInstance().format(currentDate) + " Runable");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {

            }
        }
    }

    public boolean isRuninng() {
        return runinng;
    }

    public void setRuninng(boolean runinng) {
        this.runinng = runinng;
    }
}
