package ua.org.oa.rumyancevv.task5_2.part2;

import ua.org.oa.rumyancevv.homeTask4.part1.task5_2.part3.ListIterator;

import java.util.Iterator;

/**
 * Created by user on 06.02.2016.
 */
public class Demo {
    public static void main(String[] args) {


        MyDequeImpl<Number> deque = new MyDequeImpl<Number>();

        deque.addFirst(433);

        deque.addLast(8.88);

        Object[] deque1 =  deque.toArray();

        for (Object element : deque1) {
            System.out.println(element); }


        Iterator<Number> it = deque.iterator();

        while (it.hasNext())

            System.out.println(it.next());


// ...

    }
}
