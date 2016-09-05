package ua.org.oa.rumyancevv.practics4;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by user on 09.02.2016.
 */
public class StudentUtils {


    static Map<String, Student> createMapFromList(List<Student> students){
        Map<String , Student> map = new HashMap<>();
        for (Student student : students) {
            map.put(student.getFirstName() + " " + student.getLastName(), student);
        }

        return map;
    }

    static void printStudents(List<Student> students, int course){
        Iterator<Student> iterator = students.iterator();
        Student stu = null;
        while (iterator.hasNext()){
            stu = iterator.next();
            if (stu.getCourse() == course)
            System.out.println(stu);
        }

    }

    static List<Student> sortStudent(List students){
        List<Student> studentList = new ArrayList<>(students);
        studentList.sort((o1, o2) -> o1.getLastName().compareTo(o2.getLastName()));

        return studentList;
    }
    static void reader() {
        Map<String, Integer> map = new HashMap<>();
        String str;
        try {
            BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\user\\Downloads\\Romeo.txt"));
            try {
                while ((str = reader.readLine()) != null){

                    for(String s: str.split("\\W+")) {
                        if(map.containsKey(s)) {
                            map.put(s, map.get(s) + 1);
                        }
                        else {
                            map.put(s, 1);
                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        map.remove("");
        System.out.println(map);
    }


    }
