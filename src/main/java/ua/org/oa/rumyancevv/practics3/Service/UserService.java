package ua.org.oa.rumyancevv.practics3.Service;


import ua.org.oa.rumyancevv.practics3.dao.DAO;
import ua.org.oa.rumyancevv.practics3.dao.impl.BookDaoImp;
import ua.org.oa.rumyancevv.practics3.dao.impl.ReportDaoImp;
import ua.org.oa.rumyancevv.practics3.dao.impl.UserDaoImp;
import ua.org.oa.rumyancevv.practics3.model.Book;
import ua.org.oa.rumyancevv.practics3.model.Report;
import ua.org.oa.rumyancevv.practics3.model.User;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by user on 04.02.2016.
 */
public class UserService implements ua.org.oa.rumyancevv.practics3.utils.impl.UserService {
    private String userServiceName;
    private InMemoryDB inMemoryDB = InMemoryDB.getInMemoryDB();
    private DAO<User> usersDao = (DAO<User>) new UserDaoImp();
    private DAO<Book> bookDao = (DAO<Book>) new BookDaoImp();
    private DAO<Report> reportDao = (DAO<Report>) new ReportDaoImp();

    public UserService(String libraryName) {
        this.setUserService(libraryName);
    }

    public String getUserService() {
        return userServiceName;
    }

    public void setUserService(String userServiceName) {
        this.userServiceName = userServiceName;
    }

    @Override
    public int createUser(String name, String login, String password, Date birthday) {
        if (usersDao.create(new User(name, login, password, birthday)) < 0) {
            return -1;
        } else {
            return 1;
        }
    }

    @Override
    public int deleteUser(long id) {
        if (usersDao.delete(id) == null) {
            return -1;
        } else {
            return 1;
        }
    }

    @Override
    public int createBook(String author, String title, int count) {
        if (bookDao.create(new Book(author, title, count)) < 0) {
            return -1;
        } else {
            return 1;
        }
    }

    @Override
    public int deleteBook(long index) {
        if (bookDao.delete(index) == null) {
            return -1;
        } else {
            return 1;
        }
    }

    @Override
    public Book findBook(long index) {
        return bookDao.read(index);
    }

    @Override
    public Book findBook(String author, String title) {
        for (long i = 0; i < bookDao.size(); i++) {
            if (bookDao.read(i).getAuthor().equals(author) && bookDao.read(i).getTitle().equals(title)) {
                return bookDao.read(i);
            }
        }
        return null;
    }

    @Override
    public Book takeBook(Book book, Date date, User user) {
        bookDao.read(book.getId()).setCount(book.getCount() - 1);
        Report report = new Report(book, user, date);
        reportDao.create(report);
        bookDao.read(book.getId()).getUsers().add(user);
        bookDao.read(book.getId()).getReports().add(report);
        usersDao.read(user.getId()).getBooks().add(book);
        return book;
    }

    @Override
    public Report returnBackBook(User user, Book book, Date date) {
        Report report = null;
        for (Report r : bookDao.read(book.getId()).getReports()) {
            if (r.getUser().equals(user) && r.getBook().equals(book) && r.getReturns() != null) {
                report = r;
                report.setReturns(date);
                break;
            }
        }
        bookDao.read(book.getId()).setCount(book.getCount() + 1);
        bookDao.read(book.getId()).getUsers().remove(user);
        usersDao.read(user.getId()).getBooks().remove(book);
        return report;
    }

    @Override
    public List<Report> reportsAboutBook(long index) {
        List<Report> reports = new ArrayList<>();
        for (long i = 0; i < reportDao.size(); i++) {
            if (reportDao.read(i).getBook().equals(bookDao.read(index))) {
                reports.add(reportDao.read(i));
            }
        }
        return reports;
    }

    @Override
    public List<Report> reportsAboutUser(long index) {
        List<Report> reports = new ArrayList<>();
        for (long i = 0; i < reportDao.size(); i++) {
            if (reportDao.read(i).getUser().equals(usersDao.read(index))) {
                reports.add(reportDao.read(i));
            }
        }
        return reports;
    }
}
