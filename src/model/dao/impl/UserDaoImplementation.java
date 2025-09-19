package model.dao.impl;

import db.DBConfig;
import db.DbException;
import model.dao.UserDao;
import model.entities.User;

import javax.xml.transform.Result;
import java.sql.*;
import java.text.SimpleDateFormat;
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

        PreparedStatement st = null;

        try {

            st = conn.prepareStatement(
                    "INSERT INTO users "
                            + "(username, email, password, birthDate) "
                            + "VALUES "
                            + "(?,?,?,?)",
                    Statement.RETURN_GENERATED_KEYS
            );

            st.setString(1, u.getUsername());
            st.setString(2, u.getEmail());
            st.setString(3, u.getPassword());
            st.setDate(4, new java.sql.Date(u.getBirthDate().getTime()));

            int rowsAffected = st.executeUpdate();

            if (rowsAffected > 0) {
                ResultSet rs = st.getGeneratedKeys();
                if (rs.next()) {
                    int id = rs.getInt(1);
                    u.setId(id);
                }
                DBConfig.closeResultSet(rs);
            }
            else {
                throw new DbException("Something went wrong. No rows affected.");
            }

        }
        catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
        finally {
            DBConfig.closeStatement(st);
        }

    }

    @Override
    public void update(Integer id, String username, String email, String password) {

        PreparedStatement st = null;

        try {
            st = conn.prepareStatement(
                    "UPDATE users "
                    + "SET username = COALESCE(?, username), email = COALESCE(?, email), password = COALESCE(?, password) "
                    + "WHERE id = ?"
            );

            st.setString(1, username);
            st.setString(2, email);
            st.setString(3, password);
            st.setInt(4, id);
            st.executeUpdate();

        }
        catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
        finally {
            DBConfig.closeStatement(st);
        }

    }

    @Override
    public User findById(Integer id) {

        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            st = conn.prepareStatement(
                    "SELECT * FROM users " +
                            "WHERE id = ?"
            );

            st.setInt(1, id);

            rs = st.executeQuery();

            if (rs.next()) {
                Integer userId = rs.getInt("id");
                String username = rs.getString("username");
                String email = rs.getString("email");
                Date birthDate = rs.getDate("birthDate");
                return new User(userId, username, email, birthDate);
            }
        }
        catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
        finally {
            DBConfig.closeStatement(st);
            DBConfig.closeResultSet(rs);
        }
        return null;
    }

    @Override
    public User findByUsername(String username) {
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            st = conn.prepareStatement(
                    "SELECT * FROM users " +
                            "WHERE username = ?"
            );

            st.setString(1, username);

            rs = st.executeQuery();

            if (rs.next()) {
                Integer userId = rs.getInt("id");
                String name = rs.getString("username");
                String email = rs.getString("email");
                Date birthDate = rs.getDate("birthDate");
                return new User(userId, name, email, birthDate);
            }
        }
        catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
        finally {
            DBConfig.closeStatement(st);
            DBConfig.closeResultSet(rs);
        }
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
