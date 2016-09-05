package ua.org.oa.rumyancevv.homeTask8.part1.jdbc;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by user on 29.02.2016.
 */
public class ConnectionProvider {
    private static DataSource dataSource;

    public static Connection getConnections() {
        if (dataSource == null) {
            MysqlDataSource mysqlDataSource = new MysqlDataSource();
            mysqlDataSource.setURL("jdbc:mysql://localhost/test1?useSSL=false");
            mysqlDataSource.setUser("root");
            mysqlDataSource.setPassword("L0g0v2z!");
            dataSource = mysqlDataSource;
        }
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }


}
