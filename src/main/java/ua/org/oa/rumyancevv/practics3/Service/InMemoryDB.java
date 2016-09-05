package ua.org.oa.rumyancevv.practics3.Service;

import ua.org.oa.rumyancevv.practics3.model.Book;
import ua.org.oa.rumyancevv.practics3.model.Report;
import ua.org.oa.rumyancevv.practics3.model.User;
import ua.org.oa.rumyancevv.practics3.utils.impl.GenericStarageImpl;

/**
 * Created by user on 28.02.2016.
 */
public class InMemoryDB {
    private GenericStarageImpl<Book> books = new GenericStarageImpl<>();
    private GenericStarageImpl<User> users = new GenericStarageImpl<>();
    private GenericStarageImpl<Report> reports = new GenericStarageImpl<>();
    private static InMemoryDB inMemoryDB = new InMemoryDB();

    private InMemoryDB() {    }

    public static InMemoryDB getInMemoryDB() {
        return inMemoryDB;
    }

    public GenericStarageImpl<Book> getBooks() {
        return books;
    }

    public void setBooks(GenericStarageImpl<Book> books) {
        this.books = books;
    }

    public GenericStarageImpl<User> getUsers() {
        return users;
    }

    public void setUsers(GenericStarageImpl<User> users) {
        this.users = users;
    }

    public GenericStarageImpl<Report> getReports() {
        return reports;
    }

    public void setReports(GenericStarageImpl<Report> reports) {
        this.reports = reports;
    }
}
