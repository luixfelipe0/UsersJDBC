package model.dao;

import db.DBConfig;
import model.dao.impl.UserDaoImplementation;

public class DaoFactory {

    public static UserDao createUserDao() {
        return new UserDaoImplementation(DBConfig.getConn());
    }

}
