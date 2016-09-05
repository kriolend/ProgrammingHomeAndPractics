package ua.org.oa.rumyancevv.homeTask8.part1.DAO;

import com.mysql.jdbc.Statement;
import ua.org.oa.rumyancevv.homeTask8.part1.jdbc.ConnectionProvider;
import ua.org.oa.rumyancevv.homeTask8.part1.jdbc.SQLs;
import ua.org.oa.rumyancevv.homeTask8.part1.model.Student;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static java.sql.Statement.*;

/**
 * Created by user on 01.03.2016.
 */
public class StudentDAO implements Dao<Student> {
    @Override
    public Student create(Student student) {
        try (PreparedStatement ps = ConnectionProvider.getConnections().prepareStatement(SQLs.SQL_INSERT_STUDENT, RETURN_GENERATED_KEYS)) {
            ps.setString(1, student.getName());
            ps.setString(2, student.getSurname());
            ps.setDate(3, student.getEnrolment_date());
            ps.setInt(4, student.getGroup_id());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next())student.setId(rs.getInt(1));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return student;
    }

    @Override
    public List<Student> getAll() {
        List<Student> studentList = new ArrayList<>();
        try (Statement st = (Statement) ConnectionProvider.getConnections().createStatement()) {
            ResultSet rs = st.executeQuery(SQLs.SQL_SELECT_ALL_STUDENT);
            Student student = null;
            while (rs.next()){
                student = new Student();
                student.setId(rs.getInt("id"));
                student.setName(rs.getString("name"));
                student.setSurname(rs.getString("surname"));
                student.setEnrolment_date(rs.getDate("enrolment_date"));
                student.setGroup_id(rs.getInt("group_id"));
                studentList.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return studentList;
    }

    @Override
    public Student getById(int id) {
        Student std = null;
        try (PreparedStatement ps = ConnectionProvider.getConnections().prepareStatement(SQLs.SQL_SELECT_BY_ID_STUDENT)){
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                std = new Student();
                std.setId(rs.getInt("id"));
                std.setName(rs.getString("name"));
                std.setSurname(rs.getString("surname"));
                std.setEnrolment_date(rs.getDate("enrolment_date"));
                std.setGroup_id(rs.getInt("group_id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return std;
    }


    @Override
    public boolean update(Student student) {
        try (PreparedStatement ps = ConnectionProvider.getConnections().prepareStatement(SQLs.SQL_UPDATE_BY_ID_STUDENT)){
            ps.setString(1, student.getName());
            ps.setString(2, student.getSurname());
            ps.setDate(3, student.getEnrolment_date());
            ps.setInt(4, student.getGroup_id());
            ps.setInt(5, student.getId());
            return ps.executeUpdate() == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(Student student) {
        try (PreparedStatement ps = ConnectionProvider.getConnections().prepareStatement(SQLs.SQL_DELETE_BY_ID_STUDENT)) {
            ps.setInt(1, student.getId());
            return ps.executeUpdate() == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
