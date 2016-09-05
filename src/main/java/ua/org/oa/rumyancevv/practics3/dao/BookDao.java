package ua.org.oa.rumyancevv.practics3.dao;

import ua.org.oa.rumyancevv.practics3.model.Book;

import java.util.List;

/**
 * Created by user on 02.02.2016.
 */
public interface BookDao {
    long createBook(Book user);
    Book readBook(long id);
    List<Book> readAll();
    boolean updateBook(Book user);
    boolean deleteBook(long id);
}
