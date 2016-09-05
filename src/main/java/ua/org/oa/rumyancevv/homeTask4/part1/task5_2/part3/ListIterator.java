package ua.org.oa.rumyancevv.homeTask4.part1.task5_2.part3;

import java.util.Iterator;

/**
 * Created by user on 06.02.2016.
 */
public interface ListIterator<E> extends Iterator<E> {
    // проверяет, есть ли предыдущий элемент для выборки методом previous

    boolean hasPrevious();

// возвращает предыдущий элемент

    E previous();

// заменяет элемент, который на предыдущем шаге был возвращен next/previous на данный элемент

    void set(E e);

// удаляет элемент, который на предыдущем шаге был возвращен next/previous

    void remove();

}
