package ua.org.oa.rumyancevv.task5_2.part1;

import java.util.NoSuchElementException;

/**
 * Created by user on 06.02.2016.
 */
public class MyDequeImpl<E> implements MyDeque<E> {

    Node<E> node = new Node<E>(null, null, null);
    int size = 0;

    @Override
    public void addFirst(E e) {
        if (node.prev != null && node.next != null){
            Node<E> eNode = new Node<E>((E) e, node, node.prev);
            Node<E> eNode1 = node.prev;
            eNode1.prev = eNode;
            node.prev = eNode;
            size++;
        }
        else {
            addFirtsElemetn(e);
        }

        }
    public void addFirtsElemetn(Object e) {
        Node<E> enode = new Node<E>((E) e, null, null);
        node.next = enode;
        node.prev = enode;
        size++;
    }


    @Override
    public void addLast(E e) {
        if (node.next != null & node.prev != null) {
            Node<E> eNode = new Node<E>((E) e, node.next, null);
            Node<E> eNode1 = node.next;
            eNode1.next = eNode;

            node.next = eNode;

            size++;
        }
        else addFirtsElemetn(e);

    }

    @Override
    public E removeFirst() {
        Node<E> temp = node.next;
        node.prev = temp.prev;
        size--;
        return null;
    }

    @Override
    public E removeLast() {
        Node<E> temp = node.next;
        node.next = temp.prev;
        size--;
        return null;
    }

    @Override
    public E getFirst() {
        return (E) node.prev;
    }

    @Override
    public E getLast() {
        return (E) node.next;
    }

    @Override
    public boolean contains(Object o) {
        Node<E> eNode = node.prev;
        Node<E> eNode1 = (Node<E>) eNode.element;
        while (eNode.next != null) {
            if (eNode1.equals(o)) {
                return true;
            }
            eNode1 = eNode1.next;
        }

        return false;
    }

    @Override
    public void clear() {
        node.prev = null;
        node.next = null;
        size = 0;
    }

    @Override
    public Object[] toArray() {
        Object[] objects = new Object[size];
        Node<E> eNode = node.prev;
        for (int i = 0; i < size; i++) {

            objects[i] = eNode.element;
            eNode = eNode.next;
        }

        return objects;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean containsAll(MyDeque<? extends E> deque) {
        int count = 0;
        Node<E> nodePrev = node.prev;
        Node<E> first = (Node<E>) nodePrev.element;
        for (Node<E> i = (Node<E>) deque.getFirst(); i.next != null; ) {
            if (first.equals(i)) {
                count++;
            }
            first = nodePrev.next;

        }
        if (count == deque.size()) {
            return true;

        }

        return false;
    }

    private static class Node<E> {

// хранимый элемент

        E element;

// ссылка на следующий элемент списка

        Node<E> next;

// ссылка на предыдущий элемент списка

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
