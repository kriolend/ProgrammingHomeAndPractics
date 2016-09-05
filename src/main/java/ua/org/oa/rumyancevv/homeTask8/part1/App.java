package ua.org.oa.rumyancevv.homeTask8.part1;

import ua.org.oa.rumyancevv.homeTask8.part1.DAO.Dao;
import ua.org.oa.rumyancevv.homeTask8.part1.DAO.StudentDAO;
import ua.org.oa.rumyancevv.homeTask8.part1.model.Student;
import ua.org.oa.rumyancevv.homeTask8.part1.service.CsvREader;
import ua.org.oa.rumyancevv.homeTask8.part1.service.DatabaseService;

import java.sql.Date;


/**
 * Created by user on 29.02.2016.
 */
public class App {
    public static void main(String[] args) {

        DatabaseService.initDatabaseStudent();
        DatabaseService.selectDBStudent();
        Dao<Student> studentDao = new StudentDAO();
        Student student = new Student();
        student.setName("Oksana");
        student.setSurname("Popova");
        student.setEnrolment_date(Date.valueOf("2010-02-01"));
        student.setGroup_id(2);
        studentDao.create(student);
        //------------------------------------------------------------//
        studentDao.create(CsvREader.readerFile());
        System.out.println(student);
        //------------------------------------------------------------//
//        DatabaseService.initDatabaseGroup();
//        DatabaseService.selectDBGroup();
//        Dao<Group> groupDao = new GroupDAO();
//        Group facultete = new Group();
//        facultete.setNumber(3);
//        facultete.setDepartment("Facult");
//        groupDao.create(facultete);

        System.out.println("------------------------------------------");
//        DatabaseService.selectDBGroup();
    }
}
