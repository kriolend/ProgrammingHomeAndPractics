package ua.org.oa.rumyancevv.practics3.utils;


/**
 * Created by user on 04.02.2016.
 */
public interface GenericStorage<T> {
    int create (T obj);
    T read (int id);
    T update(int id, T obj);
    T delete(int id);
}
