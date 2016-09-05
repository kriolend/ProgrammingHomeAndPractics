package ua.org.oa.rumyancevv.homeTask8.part1.service;

import ua.org.oa.rumyancevv.homeTask8.part1.model.Student;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by user on 03.03.2016.
 */
public class CsvREader {
    public static BufferedReader bufferedReader;
    public static Student student = new Student();

    public static Student readerFile(){
        String line;
        try {
            bufferedReader = new BufferedReader(new FileReader("Student.csv"));
            while ((line = bufferedReader.readLine()) !=null){
                Pattern pattern = Pattern.compile("(\\w+);(\\w+);(.*);(\\d+)");
                Matcher matcher = pattern.matcher(line);
                while (matcher.find()){
                    student.setName(matcher.group(1));
                    student.setSurname(matcher.group(2));
                    student.setEnrolment_date(Date.valueOf(matcher.group(3)));
                    student.setGroup_id(Integer.parseInt(matcher.group(4)));
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return student;
    }
}
