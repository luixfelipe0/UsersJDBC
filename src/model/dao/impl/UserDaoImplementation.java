package model.dao.impl;

import db.DBConfig;
import db.DbException;
import model.dao.UserDao;
import model.entities.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserDaoImplementation implements UserDao {

    private static Connection conn;

    public UserDaoImplementation(Connection conn) {
        UserDaoImplementation.conn = conn;
    }

    @Override
    public void insert(User u) {

    }

    @Override
    public void update(User u) {

    }

    @Override
    public User findById(Integer id) {
        return null;
    }

    @Override
    public User findByUsername(String username) {
        return null;
    }

    @Override
    public List<User> findAll() {

        PreparedStatement st = null;
        ResultSet rs = null;

        List<User> list = new ArrayList<>();

        try {
            st = conn.prepareStatement(
                    "SELECT * FROM users"
            );

            rs = st.executeQuery();

            while (rs.next()) {
                Integer id = rs.getInt("id");
                String username = rs.getString("username");
                String email = rs.getString("email");
                Date birthDate = rs.getDate("birthDate");

                list.add(new User(id, username, email, birthDate));
            }
        }
        catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
        finally {
            DBConfig.closeStatement(st);
            DBConfig.closeResultSet(rs);
        }
        return list;
    }

    @Override
    public void deleteById() {

    }
}
