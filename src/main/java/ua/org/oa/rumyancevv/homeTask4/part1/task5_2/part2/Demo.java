package ua.org.oa.rumyancevv.homeTask4.part1.task5_2.part2;

import java.util.Iterator;

/**
 * Created by user on 06.02.2016.
 */
public class Demo {
    public static void main(String[] args) {

        MyDeque<Number> deque = new MyDequeImpl<Number>();

        deque.addFirst(433);

        deque.addLast(8.88);

// ...

        for (Number element : deque) { System.out.println(element); }

        Iterator<Number> it = deque.iterator();

        while (it.hasNext())

            System.out.println(it.next());

// ...

    }
}
