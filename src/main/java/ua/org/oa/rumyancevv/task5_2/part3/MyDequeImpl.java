package ua.org.oa.rumyancevv.task5_2.part3;

import java.util.Iterator;

/**
 * Created by user on 06.02.2016.
 */
public class MyDequeImpl<E> implements MyDeque {

    Node<E> header = new Node<E>(null, null, null);
    int size = 0;


    public void addFirst(Object o) {
        if (header.next != null & header.prev != null) {
            Node<E> eNode = new Node<E>((E) o, header, header.prev);
            Node<E> node = header.prev;
            node.prev = eNode;
            header.prev = eNode;
            size++;
        } else {
            addFirtsElemetn(o);
        }


    }

    public void addFirtsElemetn(Object o) {
        Node<E> enode = new Node<E>((E) o, null, null);
        header.next = enode;
        header.prev = enode;
        size++;
    }

    public void addLast(Object o) {
        if (header.next != null & header.prev != null) {
            Node<E> eNode = new Node<E>((E) o, header.next, null);
            Node<E> node = header.next;
            node.next = eNode;

            header.next = eNode;

            size++;
        } else addFirtsElemetn(o);


    }

    public E removeFirst() {
        Node<E> temp = header.next;
        header.prev = temp.prev;
        size--;
        return null;

    }

    public Object removeLast() {
        Node<E> temp = header.next;
        header.next = temp.prev;
        size--;


        return null;
    }

    public Object getFirst() {

        return header.prev;

    }

    public Object getLast() {
        return header.next;
    }

    public boolean contains(Object o) {
        Node<E> temp = header.prev;
        Node<E> tempelem = (Node<E>) temp.element;
        while (temp.next != null) {
            if (tempelem.equals(o)) {
                return true;
            }
            tempelem = (Node<E>) tempelem.next;
        }

        return false;

    }

    public void clear() {
        header.prev = null;
        header.next = null;
        size = 0;

    }

    public Object[] toArray() {
        Object[] objects = new Object[size];
        Node<E> elemen = header.prev;
        for (int i = 0; i < size; i++) {

            objects[i] = elemen.element;
            elemen = elemen.next;
        }

        return objects;
    }

    public int size() {
        return size;
    }



    public boolean containsAll(MyDeque deque) {
        int count = 0;
        Node<E> tempobject = header.prev;
        Node<E> first = (Node<E>) tempobject.element;
        for (Node<E> i = (Node<E>) deque.getFirst(); i.next != null; ) {
            if (first.equals(i)) {
                count++;
            }
            first = tempobject.next;

        }
        if (count == deque.size()) {
            return true;


        }


        return false;

    }

    public ListIterator<E> listIterator() {
        return new ListIteratorImpl();
    }

    public Iterator iterator() {
        return null;
    }

    public boolean hasPrevious() {
        return false;
    }

    public Object previous() {
        return null;
    }

    public void set(Object o) {

    }

    public boolean hasNext() {
        return false;
    }

    public Object next() {
        return null;
    }

    public void remove() {

    }

    private class ListIteratorImpl implements ListIterator<E> {
        Node<E> node = (Node<E>) getFirst();
        Node<E> node1 = (Node<E>) getLast();

        public boolean hasPrevious() {
            if (node1.prev != null) {
                return true;
            }
            return false;
        }

        public E previous() {
            Node<E> temp = (Node<E>) node1;
            node1 = temp.prev;


            return (E) temp;

        }

        public void set(E e) {
            Node<E> temp = (Node<E>) node.element;

            Node<E> tempprev = temp.prev;
            Node<E> tempnext = temp.next;
            if (tempprev != null) {
                tempnext.prev = tempprev;
            } else header.prev = tempnext;
            if (tempnext != null) {
                tempprev.next = tempnext;
            } else header.next = tempprev;
            size++;

        }


        public boolean hasNext() {


            if (node.next != null) {
                return true;
            }

            return false;

        }


        public E next() {
            Node<E> temp = (Node<E>) node;
            node = temp.next;
            return (E) temp;

        }

        public void remove() {
            Node<E> element = (Node<E>) next();
            if (element.prev != null) {
                Node<E> elementprev = element.prev;
                elementprev.next = element.next;
            } else {
                header.prev = element;
            }
            if (element.next != null) {
                Node<E> elementnext = element.next;
                elementnext.prev = element.prev;
            } else {
                header.next = element;
            }
            size--;

        }

    }


    public static class Node<E> {

        E element;
        Node<E> next;
        Node<E> prev;

        Node(E element, Node<E> prev, Node<E> next) {
            this.element = element;
            this.next = next;
            this.prev = prev;
        }

        @Override
        public String toString() {
            return
                    "element=" + element ;
        }
    }


}
