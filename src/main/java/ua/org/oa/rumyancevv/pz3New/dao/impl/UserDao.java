package ua.org.oa.rumyancevv.pz3New.dao.impl;

import ua.org.oa.rumyancevv.homeTask8.part1.model.Student;
import ua.org.oa.rumyancevv.pz3New.dao.DAO;
import ua.org.oa.rumyancevv.pz3New.model.User;

/**
 * Created by user on 04.02.2016.
 */
public class UserDao implements DAO<User> {
    private User[] users;
    private int size;


    public UserDao(){
        users = new User[10];
    }

    public UserDao(User[] users, int size) {
        users = new User[size];
    }


    @Override
    public Student create(Student user) {

        return null;
    }

    @Override
    public User read(long id) {
        User idElement = null;
        try {
            if (id >= 0 && id < size) {
                idElement = (User) users[((int) id)];
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e);
        }
        return idElement;
    }

    @Override
    public boolean update(User element) {
        return false;
    }

    @Override
    public boolean delete(long id) {
        return false;
    }
}
