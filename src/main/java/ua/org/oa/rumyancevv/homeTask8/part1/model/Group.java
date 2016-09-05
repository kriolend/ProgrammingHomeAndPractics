package ua.org.oa.rumyancevv.homeTask8.part1.model;

/**
 * Created by user on 29.02.2016.
 */
public class Group {
    private int id;
    private int number;
    private String department;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Group{" +
                "id=" + id +
                ", number=" + number +
                ", department='" + department + '\'' +
                '}';
    }
}
