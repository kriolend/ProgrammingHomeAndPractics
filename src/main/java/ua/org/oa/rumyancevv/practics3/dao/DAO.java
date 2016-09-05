package ua.org.oa.rumyancevv.practics3.dao;

/**
 * Created by user on 28.02.2016.
 */
public interface DAO<T> {
    long create (T t);
    T read (long index);
    T update(long index, T t);
    T delete(long index);
    int size ();
}
