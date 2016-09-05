package ua.org.oa.rumyancevv.homeTask8.part1.DAO;

import com.mysql.jdbc.Statement;
import ua.org.oa.rumyancevv.homeTask8.part1.jdbc.ConnectionProvider;
import ua.org.oa.rumyancevv.homeTask8.part1.jdbc.SQLs;
import ua.org.oa.rumyancevv.homeTask8.part1.model.Group;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 01.03.2016.
 */
public class GroupDAO implements Dao<Group> {

    @Override
    public Group create(Group group) {
        try (PreparedStatement ps = ConnectionProvider.getConnections().prepareStatement(SQLs.SQL_INSERT_GROUP, java.sql.Statement.RETURN_GENERATED_KEYS)) {
            ps.setInt(1, group.getNumber());
            ps.setString(2, group.getDepartment());
            System.out.println(ps.executeUpdate());
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) group.setId(rs.getInt(1));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return group;
    }

    @Override
    public List<Group> getAll() {
        List<Group> groupList = new ArrayList<>();
        try (Statement st = (Statement) ConnectionProvider.getConnections().createStatement()) {
            ResultSet rs = st.executeQuery(SQLs.SQL_SELECT_ALL_GROUP);
            Group group = null;
            while (rs.next()) {
                group = new Group();
                group.setId(rs.getInt("id"));
                group.setNumber(rs.getInt("number"));
                group.setDepartment(rs.getString("department"));
                groupList.add(group);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return groupList;
    }

        @Override
    public Group getById(int id) {
            Group grp = null;
            try (PreparedStatement pt = ConnectionProvider.getConnections().prepareStatement(SQLs.SQL_SELECT_BY_ID_GROUP)) {
                pt.setInt(1, id);
                ResultSet rs = pt.executeQuery();

                if (rs.next()) {
                    grp = new Group();
                    grp.setId(rs.getInt("id"));
                    grp.setNumber(rs.getInt("number"));
                    grp.setDepartment(rs.getString("department"));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return grp;
        }

    @Override
    public boolean update(Group group) {
        try (PreparedStatement pt = ConnectionProvider.getConnections().prepareStatement(SQLs.SQL_UPDATE_BY_ID_GROUP);) {
            pt.setInt(1, group.getNumber());
            pt.setString(2, group.getDepartment());
            pt.setInt(3, group.getId());
            return pt.executeUpdate() == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(Group group) {
        try (PreparedStatement pt = ConnectionProvider.getConnections().prepareStatement(SQLs.SQL_DELETE_BY_ID_GROUP)) {
            pt.setInt(1, group.getId());
            return pt.executeUpdate() == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
