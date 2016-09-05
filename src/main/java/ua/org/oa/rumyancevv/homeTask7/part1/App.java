package ua.org.oa.rumyancevv.homeTask7.part1;

import java.io.IOException;

/**
 * Created by vr on 22.02.16.
 */
public class App {
    public static void main(String[] args) {
        runThread t = new runThread();
        runRunable runable = new runRunable();
        Thread r = new Thread(runable);
        t.start();
        r.start();
        try {
            System.in.read();
        } catch (IOException e) {
            runThread.class.getName();
            runRunable.class.getName();
        }
        t.runT();
        runable.setRuninng(true);

    }
}
