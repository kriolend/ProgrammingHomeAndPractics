package ua.org.oa.rumyancevv.practics6.part1;

/**
 * Created by user on 23.02.2016.
 */
public class MyRunable implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(250);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("My name is " + this.getClass().getName().toString());
        }

    }
}
