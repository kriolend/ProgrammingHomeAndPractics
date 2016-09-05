package ua.org.oa.rumyancevv.pz3New.Storage;

/**
 * Created by vr on 05.02.16.
 */
public interface inMemoryInterface<E> {
    int create(int id, E obj);
    E read(int id);
    boolean update(int id, E obj);
    void delete(E obj);
}
