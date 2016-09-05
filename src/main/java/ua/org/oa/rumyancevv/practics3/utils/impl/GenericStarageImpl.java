package ua.org.oa.rumyancevv.practics3.utils.impl;


import ua.org.oa.rumyancevv.practics3.utils.GenericStorage;

/**
 * Created by user on 28.02.2016.
 */
public class GenericStarageImpl<T> implements GenericStorage<T> {
    private T[] element;

    public GenericStarageImpl() {
        element = (T[]) new Object[10];
    }

    @Override
    public int create(Object obj) {
        int marker = 0;
        for (T t1 : element) {
            if (t1.equals(obj)) {
                marker++;
            }
        }
        if (marker == 0) {
            for (int i = 0; i < element.length; i++) {
                if (element[i] == null) {
                    element[i] = (T) obj;
                    return i;
                }
            }
            this.arrRes();
            element[element.length-9] = (T) obj;
            return element.length-9;
        } else {
            return -1;
        }
    }

    private void arrRes() {
        T[] newList =(T[]) new Object [element.length + 10];
        for (int i = 0; i < element.length; i++) {
            newList[i]=element[i];
        }
        element = newList;
    }

    @Override
    public T read(int id) {
        T t = element[id];
        if (t != null){
            return t;
        }
        return null;
    }


    @Override
    public T update(int id, Object obj) {
        if (id < element.length && id >= 0){
            element[id] = (T) obj;
            return (T) obj;
        }else {
            return null;
        }
    }

    @Override
    public T delete(int id) {
        T obj = element[id];
        if (obj != null){
            element[id] = null;
            return obj;
        }
        return null;
    }
    public T[] getAll() {
        return element;
    }

}
