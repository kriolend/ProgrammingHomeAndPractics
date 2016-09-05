package ua.org.oa.rumyancevv.homeTask7.part3;

/**
 * Created by user on 22.02.2016.
 */
public class App {
    public static void main(String[] args) {
//        CountersAsinhronaze c1 = new CountersAsinhronaze();
//        Thread t1 = new Thread(c1);
//        Thread t2 = new Thread(c1);
//        t1.start();
//        t2.start();

        CounterSinhronaze c2 = new CounterSinhronaze();
        Thread t3 = new Thread(c2);
        Thread t4 = new Thread(c2);
        t3.start();
        t4.start();
    }
}
