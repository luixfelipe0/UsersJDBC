package db;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class DBConfig {

    //initializes a static variable to represents connection in this class
    private static Connection conn = null;

    //method to load properties from db.properties, necessary to establish connection
    private static Properties loadProperties() {
        //file input stream to read bytes from a specified file
        try (FileInputStream fs = new FileInputStream("resources/db.properties")) {
            //initialize a prop object
            Properties props = new Properties();
            //load properties and assign it to props variable, from file input stream read
            props.load(fs);
            //return properties
            return props;
        }
        catch (IOException e) {
            throw new DbException(e.getMessage());
        }
    }

    //method to get connection with db
    public static Connection getConn() {
        //check if conn isn't already established
        if (conn == null) {
            try {
                //loading properties from db.properties, with loadProperties() method assigned above
                Properties props = loadProperties();
                // assign conn variable with the connection established, through the Driver Manager from JDBC, who asks for an url and the props itself to establish the connection properly
                conn = DriverManager.getConnection(props.getProperty("dburl"), props);
            }
            catch (SQLException e) {
                throw new DbException(e.getMessage());
            }
        }
        return conn;
    }

    //the following below methods just for close resources from JDBC

    public static void closeConn() {
        if (conn != null) {
            try {
                conn.close();
            }
            catch (SQLException e) {
                throw new DbException(e.getMessage());
            }
        }
    }

    public static void closeResultSet(ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            }
            catch (SQLException e) {
                throw new DbException(e.getMessage());
            }
        }
    }

    public static void closeStatement(PreparedStatement st) {
        if (st != null) {
            try {
                st.close();
            }
            catch (SQLException e) {
                throw new DbException(e.getMessage());
            }
        }
    }
}
