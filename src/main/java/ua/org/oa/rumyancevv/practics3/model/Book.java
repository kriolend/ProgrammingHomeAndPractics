package ua.org.oa.rumyancevv.practics3.model;

import ua.org.oa.rumyancevv.practics3.model.Report;
import ua.org.oa.rumyancevv.practics3.model.User;

import java.util.List;

/**
 * Created by user on 02.02.2016.
 */
public class Book {
    private long id;
    private String author;
    private String title;
    private int count;
    private List<User> users;
    private List<Report> reports;

    public Book(String author, String title, int count) {
        this.author = author;
        this.title = title;
        this.count = count;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<Report> getReports() {
        return reports;
    }

    public void setReports(List<Report> reports) {
        this.reports = reports;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", count=" + count +
                ", users=" + users +
                ", reports=" + reports +
                '}';
    }

}
