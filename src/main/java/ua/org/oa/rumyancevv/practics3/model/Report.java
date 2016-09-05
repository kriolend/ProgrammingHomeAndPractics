package ua.org.oa.rumyancevv.practics3.model;


import java.util.Date;

/**
 * Created by user on 02.02.2016.
 */
public class Report {
    private long id;
    private Book book;
    private User user;
    private Date rent;
    private Date returns;

    public Report(Book book, User user, Date rent) {
        this.book = book;
        this.user = user;
        this.rent = rent;
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

    @Override
    public String toString() {
        return "Report{" +
                "id=" + id +
                ", book=" + book +
                ", user=" + user +
                ", rent=" + rent +
                ", returns=" + returns +
                '}';
    }
}
