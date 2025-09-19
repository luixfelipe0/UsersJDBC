package application;

import model.dao.DaoFactory;
import model.dao.UserDao;
import model.entities.User;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {
    public static void main(String[] args) {

        UserDao userDao = DaoFactory.createUserDao();

        System.out.println(userDao.findAll());

        System.out.println(userDao.findById(5));
        System.out.println(userDao.findByUsername("João Pereira"));

//        userDao.insert(new User(null, "luix", "luix.felipe1@email.com", "adminadmin", new Date()));

//        userDao.update(5, "marilove", "mari.love@email.com", null);

    }
}