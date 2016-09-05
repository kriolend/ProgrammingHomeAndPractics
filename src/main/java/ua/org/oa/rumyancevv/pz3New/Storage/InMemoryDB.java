package ua.org.oa.rumyancevv.pz3New.Storage;

import ua.org.oa.rumyancevv.practics3.model.User;
import ua.org.oa.rumyancevv.pz3New.model.Book;
import ua.org.oa.rumyancevv.pz3New.model.Report;

import java.util.Arrays;
import java.util.Objects;

/**
 * Created by user on 02.02.2016.
 */
public class InMemoryDB<E> implements inMemoryInterface<Object> {
    GenericStorageClass<User> userGenericStorageClass = new GenericStorageClass<>();
    GenericStorageClass<Book> bookGenericStorageClass = new GenericStorageClass<>();
    GenericStorageClass<Report> reportGenericStorageClass = new GenericStorageClass<>();
    private Object[] element;
    private int size;
    private Object[] temp;




    public InMemoryDB() {
        element = new Object[10];
    }

    public InMemoryDB(Object[] element, int size) {
        element = new Object[size];
    }

    @Override
    public int create(int id, Object obj) {
        if (size < element.length) {
            element[size++] = obj;
            for (int i = 0; i < element.length; i++) {
                if (obj.equals(i)) ;
                id = i;
            }
            return id;
        } else {
            temp = new Object[element.length];
            System.arraycopy(element, 0, temp, 0, element.length);
            element = Arrays.copyOf(temp, 10);
            for (int i = 0; i < element.length; i++) {
                if (obj.equals(i)) ;
                id = i;
            }
        }
        return id;
    }

    @Override
    public Object read(int id) {
        Object idElement = null;
        try {
            if (id >= 0 && id < size) {
                idElement = (Objects) element[id];
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e);
        }
        return idElement;
    }

    @Override
    public boolean update(int id, Object obj) {
        boolean elPosition = false;
        if (element[id] != null) {
            element[id] = obj;
            elPosition = true;
        } else {
            elPosition = false;
        }
        return elPosition;
    }

//    public void delete(int index) {
//        int indexEl = element.length - index - 1;
//        try {
//            if (index >= 0 && index < size) {
//                element[index] = null;
//                System.arraycopy(element, index + 1, element, index, indexEl);
//            }
//        } catch (ArrayIndexOutOfBoundsException e) {
//            System.out.println(e);
//        }
//    }
//
//    public void deleteNull() {
//        element[element.length - 1] = null;
//        --size;
//    }

    @Override
    public void delete(Object obj) {
        for (int i = 0; i < element.length; i++) {
            if (obj.equals(element[i])) {
                delete(i);
            }
        }
    }

}

