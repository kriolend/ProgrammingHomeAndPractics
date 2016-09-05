package ua.org.oa.rumyancevv.pz3New.Storage;

/**
 * Created by vr on 05.02.16.
 */
public class GenClass implements GenericStorage<Object> {
    @Override
    public int create(int id, Object obj) {
        return 0;
    }

    @Override
    public Object read(int id) {
        return null;
    }

    @Override
    public boolean update(int id, Object obj) {
        return false;
    }

    @Override
    public void delete(Object obj) {

    }
}
