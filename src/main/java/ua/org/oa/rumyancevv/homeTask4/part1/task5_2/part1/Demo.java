package ua.org.oa.rumyancevv.homeTask4.part1.task5_2.part1;

/**
 * Created by user on 06.02.2016.
 */
public class Demo {
    public static void main(String[] args) {

        MyDeque<Number> deque = new MyDequeImpl<Number>();

        deque.addFirst(433);

        deque.addLast(8.88);

// демонстрация всех методов MyDeque

        System.out.println("list contains 433 --> " + deque.contains(433));
        System.out.println(deque.containsAll(deque));
        System.out.println(deque.size());
        System.out.println(deque.toArray());

// ...

    }
}
