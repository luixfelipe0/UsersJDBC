package model.dao;

import model.entities.User;

import java.util.List;

public interface UserDao {

    void insert(User u);
    void update(Integer id, String username, String email, String password);
    User findById(Integer id);
    User findByUsername(String username);
    List<User> findAll();
    void deleteById(Integer id);

}
