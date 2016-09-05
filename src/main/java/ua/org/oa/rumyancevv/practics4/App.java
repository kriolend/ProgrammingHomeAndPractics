package ua.org.oa.rumyancevv.practics4;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 09.02.2016.
 */
public class App {
    public static void main(String[] args) {
        List<Student> listStudent = new ArrayList<Student>();
        listStudent.add(new Student("Vasya", "Piatochkin", 1));
        listStudent.add(new Student("Petya", "Ivanov", 2));
        listStudent.add(new Student("Oksana", "Osa", 1));
        listStudent.add(new Student("Valuha", "Volosataya", 2));
StudentUtils.reader();
    }
}
