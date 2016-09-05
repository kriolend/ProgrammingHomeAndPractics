package ua.org.oa.rumyancevv.homeTask7.part2;

/**
 * Created by user on 22.02.2016.
 */
public class Interlocking extends Thread {
    private Thread otherThead;

    public Thread getOtherThead() {
        return otherThead;
    }

    public void setOtherThead(Thread otherThead) {
        this.otherThead = otherThead;
    }

    @Override
    public void run() {
        try {
            otherThead.join();
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            System.out.println(e);

        }
    }
}
