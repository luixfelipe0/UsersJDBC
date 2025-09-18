package application;

import model.dao.DaoFactory;
import model.dao.UserDao;

public class Main {
    public static void main(String[] args) {

        UserDao userDao = DaoFactory.createUserDao();

        System.out.println(userDao.findAll());

        System.out.println(userDao.findById(5));
        System.out.println(userDao.findByUsername("João Pereira"));
    }
}