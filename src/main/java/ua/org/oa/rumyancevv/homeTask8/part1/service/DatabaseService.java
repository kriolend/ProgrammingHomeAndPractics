package ua.org.oa.rumyancevv.homeTask8.part1.service;

import com.mysql.jdbc.Statement;
import ua.org.oa.rumyancevv.homeTask8.part1.jdbc.ConnectionProvider;
import ua.org.oa.rumyancevv.homeTask8.part1.jdbc.SQLs;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by user on 01.03.2016.
 */
public class DatabaseService {

    public static void initDatabaseStudent() {
        try (Statement st = (Statement) ConnectionProvider.getConnections().createStatement()) {
            st.execute(SQLs.SQL_DROP_STUDENT);
            st.execute(SQLs.SQL_CREATE_STUDENT);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void initDatabaseGroup() {
        try (Statement st = (Statement) ConnectionProvider.getConnections().createStatement()) {
            st.executeQuery(SQLs.SQL_DROP_GROUP);
            st.executeQuery(SQLs.SQL_CREATE_GROUP);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void updeteDBStudent() {
        try (Statement st = (Statement) ConnectionProvider.getConnections().createStatement()) {
            st.executeQuery(SQLs.SQL_UPDATE_BY_ID_STUDENT);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void updateDBGroup() {
        try (Statement st = (Statement) ConnectionProvider.getConnections().createStatement()) {
            st.executeQuery(SQLs.SQL_UPDATE_BY_ID_GROUP);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static ResultSet selectDBStudent() {
        ResultSet rs = null;
        try (Statement s = (Statement) ConnectionProvider.getConnections().createStatement()) {
            rs = null;
            rs = s.executeQuery(SQLs.SQL_SELECT_ALL_STUDENT);
            while (rs.next()) {
                String name = rs.getString("name");
                String surname = rs.getString("surname");
                Date enrolment_date = rs.getDate("enrolment_date");
                int group_id = rs.getInt("group_id");
                System.out.println(name + " " + surname + " " + enrolment_date + " " + group_id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

    public static ResultSet selectDBGroup() {
        ResultSet rs = null;
        try (Statement s = (Statement) ConnectionProvider.getConnections().createStatement()) {
            rs = null;
            rs = s.executeQuery(SQLs.SQL_SELECT_ALL_GROUP);
            while (rs.next()) {
                int number = Integer.parseInt(rs.getString("number"));
                String department = rs.getString("department");
                System.out.println(number + " " + department);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }
}
