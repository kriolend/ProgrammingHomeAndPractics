package ua.org.oa.rumyancevv.practics3.dao.impl;


import ua.org.oa.rumyancevv.practics3.Service.InMemoryDB;
import ua.org.oa.rumyancevv.practics3.dao.DAO;
import ua.org.oa.rumyancevv.practics3.model.Book;
import ua.org.oa.rumyancevv.practics3.model.Report;
import ua.org.oa.rumyancevv.practics3.model.User;

/**
 * Created by user on 04.02.2016.
 */
public class BookDaoImp implements DAO<Book> {
    @Override
    public long create(Book book) {
        int id = InMemoryDB.getInMemoryDB().getBooks().create(book);
        if (id > 0){
            InMemoryDB.getInMemoryDB().getBooks().read(id).setId(id);
        }
        return id;
    }

    @Override
    public Book read(long id) {
        return InMemoryDB.getInMemoryDB().getBooks().read((int) id);
    }

    @Override
    public Book update(long id, Book book) {
        return InMemoryDB.getInMemoryDB().getBooks().update((int) id, book);
    }

    @Override
    public Book delete(long id) {
        for (Report report : InMemoryDB.getInMemoryDB().getReports().getAll()) {
            if (report.getBook().equals(InMemoryDB.getInMemoryDB().getBooks().read((int) id))) {
                InMemoryDB.getInMemoryDB().getReports().delete((int) report.getId());
            }
        }
        for (User user : InMemoryDB.getInMemoryDB().getUsers().getAll()) {
            user.getBooks().remove(InMemoryDB.getInMemoryDB().getBooks().read((int) id));
        }
        return InMemoryDB.getInMemoryDB().getBooks().delete((int) id);
    }

    @Override
    public int size() {
        return InMemoryDB.getInMemoryDB().getBooks().getAll().length;
    }
}

