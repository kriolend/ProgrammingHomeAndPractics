package ua.org.oa.rumyancevv.homeTask3;

import java.util.Arrays;

/**
 * Created by user on 03.02.2016.
 */
public class App {
    public static void main(String[] args) {
        GenericStorage<Integer> storage = new GenericStorage<>(3);
        System.out.println(storage);
        storage.add(1);
        storage.add(2);
        storage.add(3);
        System.out.println(Arrays.toString(storage.getAll()));
        storage.update(1, 4);
        System.out.println(storage);
        int i = 2;
        storage.delete(i);
        System.out.println(storage);
        Integer j = 1;
        storage.delete(j);
        System.out.println(storage);

    }
}
