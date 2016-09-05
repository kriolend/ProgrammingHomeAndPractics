package ua.org.oa.rumyancevv.task5_2.part3;

import java.util.Iterator;

/**
 * Created by vr on 16.02.16.
 */
public interface ListIterator<E> extends Iterator<E> {
// java.util.Iterator // проверяет, есть ли предыдущий элемент для выборки методом previous

    boolean hasPrevious();

    // возвращает предыдущий элемент
    E previous();

    // заменяет элемент, который на предыдущем шаге был возвращен next/previous на данный элемент
    void set(E e);

    // удаляет элемент, который на предыдущем шаге был возвращен next/previous
    void remove();
}