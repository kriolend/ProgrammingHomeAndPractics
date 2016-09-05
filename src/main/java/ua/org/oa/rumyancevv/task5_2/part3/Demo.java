package ua.org.oa.rumyancevv.task5_2.part3;

/**
 * Created by user on 06.02.2016.
 */
public class Demo {
    public static void main(String[] args) {


        MyDeque<Number> deque = new MyDequeImpl<Number>();

        deque.addFirst(433);

        deque.addLast(8.88);

// ...

        ListIterator<Number> listIterator = deque.listIterator();

        while (listIterator.hasNext())

            System.out.println(listIterator.next());

        while (listIterator.hasPrevious())

            System.out.println(listIterator.previous());

// ...

    }
}
