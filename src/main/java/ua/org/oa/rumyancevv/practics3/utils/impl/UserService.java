package ua.org.oa.rumyancevv.practics3.utils.impl;

import ua.org.oa.rumyancevv.practics3.model.Book;
import ua.org.oa.rumyancevv.practics3.model.Report;
import ua.org.oa.rumyancevv.practics3.model.User;

import java.util.Date;
import java.util.List;

/**
 * Created by user on 28.02.2016.
 */
public interface UserService {
    int createUser(String name, String login, String password, Date birthday);
    int deleteUser(long index);
    int createBook(String author, String title, int count);
    int deleteBook(long id);
    Book findBook(long index);
    Book findBook(String author, String title);
    Book takeBook(Book book, Date date, User user);
    Report returnBackBook(User user, Book book, Date date);
    List<Report> reportsAboutBook(long index);
    List<Report> reportsAboutUser(long index);
}
