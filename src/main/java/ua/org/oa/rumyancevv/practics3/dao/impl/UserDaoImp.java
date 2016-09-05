package ua.org.oa.rumyancevv.practics3.dao.impl;


import ua.org.oa.rumyancevv.practics3.Service.InMemoryDB;
import ua.org.oa.rumyancevv.practics3.dao.DAO;
import ua.org.oa.rumyancevv.practics3.model.User;

/**
 * Created by user on 04.02.2016.
 */
public class UserDaoImp implements DAO<User> {
    @Override
    public long create(User user) {
        int index = InMemoryDB.getInMemoryDB().getUsers().create(user);
        if (index > 0) {
            InMemoryDB.getInMemoryDB().getUsers().read(index).setId(index);
        }
        return index;
    }

    @Override
    public User read(long index) {
        return InMemoryDB.getInMemoryDB().getUsers().read((int) index);
    }

    @Override
    public User update(long index, User user) {
        return InMemoryDB.getInMemoryDB().getUsers().update((int)index, user);
    }

    @Override
    public User delete(long index) {
        return InMemoryDB.getInMemoryDB().getUsers().delete((int)index);
    }

    @Override
    public int size() {
        return InMemoryDB.getInMemoryDB().getUsers().getAll().length;
    }
}
