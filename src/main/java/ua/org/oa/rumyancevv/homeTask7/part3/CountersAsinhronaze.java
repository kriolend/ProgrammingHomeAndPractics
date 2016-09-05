package ua.org.oa.rumyancevv.homeTask7.part3;

/**
 * Created by user on 22.02.2016.
 */
public class CountersAsinhronaze implements Runnable {

    public int increment1(){
        int a = (int) Counter.count1++;
        System.out.println("Count1 - " + Counter.count1);
        return a;
    }
    public int increment2(){
        int b = (int) Counter.count2++;
        System.out.println("Count2 - " + Counter.count2);
        return b;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            if (increment1()> increment2()) {
                System.out.println("Count1 - " + Counter.count1 + " more than " + "Count2 - " + Counter.count2);
            } else {
                System.out.println("Count2 - " + Counter.count2 + " more than " + "Count1 - " + Counter.count1);
            }
            increment1();
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        for (int i = 0; i < 10; i++) {
            if (increment1()> increment2()) {
                System.out.println("Count1 - " + Counter.count1 + " more than " + "Count2 - " + Counter.count2);
            } else {
                System.out.println("Count2 - " + Counter.count2 + " more than " + "Count1 - " + Counter.count1);
            }
            increment2();
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }
}
