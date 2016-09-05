package ua.org.oa.rumyancevv.practics3.dao;

import ua.org.oa.rumyancevv.practics3.model.User;

import java.util.List;

/**
 * Created by user on 02.02.2016.
 */
public interface UserDao {

    boolean createUser(User user);
    User readUser(long id);
    List<User> readAll();
    boolean updateUser(User user);
    boolean deleteUser(long id);
}
