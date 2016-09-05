package ua.org.oa.rumyancevv.task5_1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by user on 06.02.2016.
 */
public class App {
    public static void main(String[] args) {
        List<Avto> avtoList = Arrays.asList(
                new Avto("Lada", 12000),
                new Avto("VAZ", 11000),
                new Avto("DAEWO", 15000)
        );

        List<Comp> compList = new ArrayList<>();
        compList.add(new Comp("Intel", 1000));
        compList.add(new Comp("Aple", 5000));
        compList.add(new Comp("AMD", 2000));

        //System.out.println(Collections.max(avtoList, null));
        System.out.println(Collections.max(compList, null));


    }
}
