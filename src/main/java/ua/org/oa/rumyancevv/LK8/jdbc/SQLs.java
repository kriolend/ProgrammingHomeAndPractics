package ua.org.oa.rumyancevv.LK8.jdbc;

/**
 * Created by user on 28.02.2016.
 */
public class SQLs {
    public static final String SQL_INSERT = "INSERT INTO human(name, age) VALUES (?, ?)";
    public static final String SQL_SELECT_ALL = "SELECT * FROM  human";
    public static final String SQL_SELECT_BY_ID = "SELECT * FROM  human WHERE id = ?";
    public static final String SQL_UPDATE_BY_ID = "UPDATE students SET name = ?, age = ? WHERE id = ?";
    public static final String SQL_DELETE_BY_ID = "DELETE FROM students WHERE id = ?";
    public static final String SQL_DROP = "DROP TABLE IF EXISTS human";
    public static final String SQL_CREATE = "CREATE TABLE IF NOT EXISTS human(" + "id int AUTO_INCREMENT primary key, "
            + "name varchar(256), age int)";
}
