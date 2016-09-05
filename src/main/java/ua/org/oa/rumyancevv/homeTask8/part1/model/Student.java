package ua.org.oa.rumyancevv.homeTask8.part1.model;

import java.sql.Date;

/**
 * Created by user on 29.02.2016.
 */
public class Student {
    private int id;
    private String name;
    private String surname;
    private Date enrolment_date;
    private int group_id;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Date getEnrolment_date() {
        return enrolment_date;
    }

    public void setEnrolment_date(Date enrolment_date) {
        this.enrolment_date = enrolment_date;
    }

    public int getGroup_id() {
        return group_id;
    }

    public void setGroup_id(int group_id) {
        this.group_id = group_id;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", enrolment_date=" + enrolment_date +
                ", group_id=" + group_id +
                '}';
    }
}
