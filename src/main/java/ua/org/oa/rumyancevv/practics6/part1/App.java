package ua.org.oa.rumyancevv.practics6.part1;

/**
 * Created by user on 23.02.2016.
 */
public class App {
    public static void main(String[] args) {
        Thread t1 = new Thread(new MyRunable());
        MyThread t2 = new MyThread();
        //t1.start();
        t2.start();
    }
}
