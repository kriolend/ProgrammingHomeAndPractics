package ua.org.oa.rumyancevv.task5_2.part2;

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

    public Object removeFirst() {
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

    public Iterator<E> iterator() {
        return new IteratorImpl();
    }


    class IteratorImpl<E> implements Iterator<E> {

        private Node<E> node = (Node<E>) header.prev;


        public boolean hasNext() {


            if (node.next != null) {
                return true;
            }


            return false;

        }


        public E next() {
            Node<E> temp = node;
            node = temp.next;


            return (E) temp;

        }




    }


    public static class Node<E> {

        E element;

// бббаЛаКаА аНаА баЛаЕаДбббаИаЙ баЛаЕаМаЕаНб баПаИбаКаА

        Node<E> next;

// бббаЛаКаА аНаА аПбаЕаДбаДббаИаЙ баЛаЕаМаЕаНб баПаИбаКаА

        Node<E> prev;

        Node(E element, Node<E> prev, Node<E> next) {
            this.element = element;
            this.next = next;
            this.prev = prev;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "element=" + element +
                    '}';
        }
    }


}
