package ua.org.oa.rumyancevv.practics8.service;

import java.sql.SQLException;
import java.sql.Statement;

import static ua.org.oa.rumyancevv.practics8.jdbc.ConnectionProvider.getConnection;
import static ua.org.oa.rumyancevv.practics8.jdbc.SQLs.SQL_CREATE;
import static ua.org.oa.rumyancevv.practics8.jdbc.SQLs.SQL_DROP;

/**
 * Created by dmitr on 26.02.2016.
 */
public class DatabaseService {
    public static void initDatabase() {
        try (Statement st = getConnection().createStatement();) {
            st.execute(SQL_DROP);
            st.execute(SQL_CREATE);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}