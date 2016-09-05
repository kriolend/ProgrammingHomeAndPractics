package ua.org.oa.rumyancevv.practics6.part2;


import java.util.Map;

/**
 * Created by user on 23.02.2016.
 */
public class MyShedule{

    public static void accept(Map<Long, String> map, int time){

        for (Map.Entry<Long, String> entry : map.entrySet()) {

            new Thread(()->{
                int myTime = time;
                while(0 < myTime) {
                    try {
                        Thread.sleep(entry.getKey());
                    } catch (InterruptedException e) {
                       return;
                    }
                    System.out.println(entry.getKey().toString() + entry.getValue().toString());
                    myTime -= entry.getKey();
                }
            }).start();


        }

    }

}
