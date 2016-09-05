package ua.org.oa.rumyancevv.pz3New.Storage;


/**
 * Created by user on 02.02.2016.
 */
public interface GenericStorage<E>{
    int create(int id, E obj);
    E read(int id);
    boolean update(int id, E obj);
    void delete(E obj);


}
