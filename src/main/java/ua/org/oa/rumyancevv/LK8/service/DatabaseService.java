package ua.org.oa.rumyancevv.LK8.service;


import java.sql.SQLException;
import java.sql.Statement;

import static ua.org.oa.rumyancevv.LK8.jdbc.ConnectionProvider.*;
import static ua.org.oa.rumyancevv.LK8.jdbc.SQLs.SQL_CREATE;
import static ua.org.oa.rumyancevv.LK8.jdbc.SQLs.SQL_DROP;

/**
 * Created by user on 28.02.2016.
 */
public class DatabaseService {
    public static void initDatabase() {
        try (Statement st = getConnection().createStatement()) {
            st.execute(SQL_DROP);
            st.execute(SQL_CREATE);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
