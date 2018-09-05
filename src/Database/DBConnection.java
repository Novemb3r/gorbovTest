package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Класс реализующий логику подключения к базе данных
 */
public class DBConnection {

    private Connection connection;

    /**
     * Конструктор класса
     */
    public DBConnection() {
        try {
            Class.forName(Constants.JDBC_DRIVER_NAME);
        } catch (java.lang.ClassNotFoundException exception) {
            System.out.println("ERROR: database connection class load error!");
        }
    }

    /**
     * Подключается к удаленной базе данных
     *
     * @return bool
     */
    public boolean open() {
        try {
            this.connection = DriverManager.getConnection(Constants.DATABASE_URL, Constants.DATABSE_LOGIN, Constants.DATABASE_PASSWORD);
        } catch (java.sql.SQLException exception) {
            exception.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * Закрывает подключение к удаленной базе данных
     *
     * @return bool
     */
    public boolean close() {
        try {
            if (this.connection.isClosed()) {
                return true;
            }

            this.connection.close();
            return true;
        } catch (java.sql.SQLException exception) {
            return false;
        }
    }
}
