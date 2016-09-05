package ua.org.oa.rumyancevv.practics8.jdbc;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionProvider{
    private static DataSource dataSource;

    public static Connection getConnection(){
        if(dataSource == null) {
            try {
                Context ctx = new InitialContext();
                dataSource = (DataSource) ctx.lookup("java:/comp/env/jdbc/MyDB");
            } catch (NamingException e) {
                e.printStackTrace();
            }
//
//            MysqlDataSource mysqlDataSource = new MysqlDataSource();
//            mysqlDataSource.setUrl(getProperties().getProperty("JDBC_URL") + getProperties().getProperty("JDBC_SCHEMA"));
//            mysqlDataSource.setUser(getProperties().getProperty("JDBC_LOGIN"));
//            mysqlDataSource.setPassword(getProperties().getProperty("JDBC_PASSWORD"));
//            dataSource = mysqlDataSource;
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