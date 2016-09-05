package ua.org.oa.rumyancevv.homeTask4.part1;

/**
 * Created by vr on 15.02.16.
 */
public class Demo {
    public static void main(String[] args) {

        MyDeque<Number> deque = new MyDequeImpl<Number>();

        deque.addFirst(433);

        deque.addLast(8.88);


// демонстрация всех методов MyDeque

        System.out.println("list contains 433 --> " + deque.contains(433));
        System.out.println(deque.getLast());
        System.out.println(deque.getFirst());
        System.out.println(deque.size());
        System.out.println(deque.containsAll(deque));
        //System.out.println(deque.toArray());

// ...

    }
}
