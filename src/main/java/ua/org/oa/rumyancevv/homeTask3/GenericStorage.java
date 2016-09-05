package ua.org.oa.rumyancevv.homeTask3;

import java.util.Arrays;

/**
 * Created by user on 03.02.2016.
 */
public class GenericStorage<T> {
    private Object[] element;
    private int size;

    public GenericStorage(){
        element = new Object[10];
    }
    public GenericStorage(int size){
        element = new Object[size];
    }
    public void add(T obj) {
        try {
            if (size < element.length) {
                element[size++] = obj;
            }
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println(e);
        }
    }

    public T get(int index) {
        T indexEl = null;
        try {
            if (index >= 0 && index < size) {
                indexEl = (T) element[index];
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e);
        }
        return indexEl;
    }

    public T[] getAll(){
        return (T[])element;
    }

    public boolean update(int index, T obj){
        boolean elPosition = false;
        if (element[index] != null){
            element[index] = obj;
            elPosition = true;
        } else {
            elPosition = false;
        }
        return elPosition;
    }

    public void delete(int index){
        int indexEl = element.length - index -1;
        try {
            if (index >= 0 && index < size){
                element[index] = null;
                System.arraycopy(element, index + 1, element, index, indexEl);
            }
        } catch (ArrayIndexOutOfBoundsException e){
            System.out.println(e);
        }
    }

    public void deleteNull(){
        element[element.length - 1] = null;
        --size;
    }

    public void delete(T obj){
        for (int i = 0; i < element.length; i++) {
            if (obj.equals(element[i])){
                delete(i);
            }
        }
    }
    public int getSize(){
        return size;
    }

    public String toString(){
        return Arrays.toString(element);
    }
}
