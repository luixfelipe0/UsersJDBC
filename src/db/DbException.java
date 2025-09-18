package db;

//my personal exception class for this project
public class DbException extends RuntimeException {

    public DbException(String message) {
        super(message);
    }
}
