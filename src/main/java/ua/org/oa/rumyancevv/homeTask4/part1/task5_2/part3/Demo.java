package ua.org.oa.rumyancevv.homeTask4.part1.task5_2.part3;

/**
 * Created by user on 06.02.2016.
 */
public class Demo {
    public static void main(String[] args) {

        MyDeque<Number> deque = new MyDequeImpl<Number>();

        deque.addFirst(433);

        deque.addLast(8.88);

// ...

        ListIterator<Number> listIt = deque.listIterator();

        while (listIt.hasNext())

            System.out.println(listIt.next());

        while (listIt.hasPrevious())

            System.out.println(listIt.previous());

    }
}
