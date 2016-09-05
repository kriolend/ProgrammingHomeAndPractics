package ua.org.oa.rumyancevv.LK8.dao.implJdbc;

import ua.org.oa.rumyancevv.LK8.dao.Dao;
import ua.org.oa.rumyancevv.LK8.model.entity.Human;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static ua.org.oa.rumyancevv.LK8.jdbc.ConnectionProvider.getConnection;
import static ua.org.oa.rumyancevv.LK8.jdbc.SQLs.*;

/**
 * Created by user on 28.02.2016.
 */
public class HumanDao implements Dao<Human> {
    @Override
    public Human create(Human human) {
        try ( PreparedStatement ps = getConnection().prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS)){
            ps.setString(1, human.getName());
            ps.setInt(2, human.getAge());
            System.out.println(ps.executeUpdate());
            ResultSet rs = ps.getGeneratedKeys();
            if(rs.next()) human.setId(rs.getInt(1));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return human;
    }

    @Override
    public List<Human> getAll() {
        List<Human> studentsList = new ArrayList<>();
        try ( Statement st = getConnection().createStatement()) {
            ResultSet rs = st.executeQuery(SQL_SELECT_ALL);
            Human human = null;
            while (rs.next()) {
                human = new Human();
                human.setId(rs.getInt("id"));
                human.setName(rs.getString("name"));
                human.setAge(rs.getInt("age"));
                studentsList.add(human);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return studentsList;
    }

    @Override
    public Human getById(int id) {
        Human std = null;
        try (PreparedStatement pt = getConnection().prepareStatement(SQL_SELECT_BY_ID)) {
            pt.setInt(1, id);
            ResultSet rs = pt.executeQuery();

            if (rs.next()) {
                std = new Human();
                std.setId(rs.getInt("id"));
                std.setName(rs.getString("name"));
                std.setAge(rs.getInt("age"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return std;
    }

    @Override
    public boolean update(Human human) {
        try (PreparedStatement pt = getConnection().prepareStatement(SQL_UPDATE_BY_ID);) {
            pt.setString(1, human.getName());
            pt.setInt(2, human.getAge());
            pt.setInt(3, human.getId());
            return pt.executeUpdate() == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(Human human) {
        try (PreparedStatement pt = getConnection().prepareStatement(SQL_DELETE_BY_ID)) {
            pt.setInt(1, human.getId());
            return pt.executeUpdate() == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
