package ua.org.oa.rumyancevv.homeTask7.part2;

/**
 * Created by user on 22.02.2016.
 */
public class App {
    public static void main(String[] args) {
        Interlocking t1 = new Interlocking();
        Interlocking t2 = new Interlocking();
        t1.setOtherThead(t2);
        t2.setOtherThead(t1);
        t1.start();
        t2.start();
        System.out.println("The thread runs, waits ");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            Interlocking.class.getName();
        }
        System.out.format("After 5 seconds threads are: %s, %s\n", t1.getState(), t2.getState());
        t1.interrupt();
        t2.interrupt();
    }
}
