package ua.org.oa.rumyancevv.practics6.part2;


import java.util.HashMap;
import java.util.Map;

/**
 * Created by user on 23.02.2016.
 */
public class App {
    public static void main(String[] args) {
        Map<Long, String> map = new HashMap<Long, String>();
        map.put((long) 2000, " = 2 mc");
        map.put((long) 5000, " = 5 mc");
        map.put((long) 600, " = 0,6 mc");
        map.put((long) 1000, " = 1 mc");

        MyShedule.accept(map, 10000);

    }
}
