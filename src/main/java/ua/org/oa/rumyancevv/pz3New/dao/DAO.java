package ua.org.oa.rumyancevv.pz3New.dao;

import ua.org.oa.rumyancevv.homeTask8.part1.model.Student;

/**
 * Created by user on 04.02.2016.
 */
public interface DAO<E> {
    Student create(Student student);
    E read(long id);
    boolean update(E element);
    boolean delete(long id);
}
