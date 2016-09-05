package ua.org.oa.rumyancevv.pz3New.model;

import java.util.Date;
import java.util.List;

/**
 * Created by user on 04.02.2016.
 */
public class User {
    private long id;
    private String name;
    private String login;
    private String password;
    private Date birthday;
    private List<Book> books;

    public User(long id, String name, String login, String password, Date birthday, List<Book> books) {
        this.id = id;
        this.name = name;
        this.login = login;
        this.password = password;
        this.birthday = birthday;
        this.books = books;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
