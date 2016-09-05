package ua.org.oa.rumyancevv.pz3New.model;

import java.util.List;

/**
 * Created by user on 04.02.2016.
 */
public class Book {
    private long id;
    private String author;
    private String title;
    private int count;
    private List<User> users;
    private List<Report> report;

    public Book(long id, String author, String title, int count, List<User> users, List<Report> report) {
        this.id = id;
        this.author = author;
        this.title = title;
        this.count = count;
        this.users = users;
        this.report = report;
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

    public List<Report> getReport() {
        return report;
    }

    public void setReport(List<Report> report) {
        this.report = report;
    }
}
