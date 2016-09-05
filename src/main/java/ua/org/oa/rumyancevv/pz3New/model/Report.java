package ua.org.oa.rumyancevv.pz3New.model;

import java.util.Date;

/**
 * Created by user on 04.02.2016.
 */
public class Report {
    private long id;
    private Book book;
    private User user;
    private Date rent;
    private Date returns;

    public Report(long id, Book book, User user, Date rent, Date returns) {
        this.id = id;
        this.book = book;
        this.user = user;
        this.rent = rent;
        this.returns = returns;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getRent() {
        return rent;
    }

    public void setRent(Date rent) {
        this.rent = rent;
    }

    public Date getReturns() {
        return returns;
    }

    public void setReturns(Date returns) {
        this.returns = returns;
    }
}
