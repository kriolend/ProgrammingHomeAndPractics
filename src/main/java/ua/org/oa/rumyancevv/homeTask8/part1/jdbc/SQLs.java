package ua.org.oa.rumyancevv.homeTask8.part1.jdbc;

/**
 * Created by user on 01.03.2016.
 */
public class SQLs {
    public static final String SQL_INSERT_STUDENT = "INSERT INTO student(name, surname, enrolment_date, group_id) VALUES (?, ?, ?, ?)";
    public static final String SQL_SELECT_ALL_STUDENT = "SELECT * FROM  student";
    public static final String SQL_SELECT_BY_ID_STUDENT = "SELECT * FROM  student WHERE id = ?";
    public static final String SQL_UPDATE_BY_ID_STUDENT = "UPDATE students SET surname = ?, enrolment_date = ? group_id = ? WHERE id = ?";
    public static final String SQL_DELETE_BY_ID_STUDENT = "DELETE FROM students WHERE id = ?";
    public static final String SQL_DROP_STUDENT = "DROP TABLE IF EXISTS student";
    public static final String SQL_CREATE_STUDENT = "CREATE TABLE IF NOT EXISTS student(" + "id int AUTO_INCREMENT primary key, "
            + "name varchar(256), surname varchar(256), enrolment_date DATE, group_id int)";
////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public static final String SQL_INSERT_GROUP = "INSERT INTO group1(number, department) VALUES (?, ?)";
    public static final String SQL_SELECT_ALL_GROUP = "SELECT * FROM  group1";
    public static final String SQL_SELECT_BY_ID_GROUP = "SELECT * FROM  group1 WHERE id = ?";
    public static final String SQL_UPDATE_BY_ID_GROUP = "UPDATE group1 SET number = ?, department = ? WHERE id = ?";
    public static final String SQL_DELETE_BY_ID_GROUP = "DELETE FROM group1 WHERE id = ?";
    public static final String SQL_DROP_GROUP = "DROP TABLE IF EXISTS group1";
    public static final String SQL_CREATE_GROUP = "CREATE TABLE IF NOT EXISTS group1(" + "id int AUTO_INCREMENT primary key, "
            + "number int, department varchar(256))";
}
