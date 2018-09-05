package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Класс реализующий логику подключения к базе данных
 */
public class DBConnection {

    private Connection connection;

    private boolean statusOpen = false;

    /**
     * Конструктор класса
     */
    public DBConnection() throws DBException {
        try {
            Class.forName(Constants.JDBC_DRIVER_NAME);
        } catch (java.lang.ClassNotFoundException exception) {
            throw new DBException("Класс не найден");
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
            this.statusOpen = true;
        } catch (SQLException exception) {
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
            this.statusOpen = false;

            return true;
        } catch (SQLException exception) {
            return false;
        }
    }

    /**
     * Возвращает статус открытости подключения
     *
     * @return bool
     */
    public boolean isOpen() {
        return this.statusOpen;
    }

    /**
     * Возвращает объект statement для SQL запросов
     *
     * @return Statement
     */
    public Statement createStatement() throws DBException {
        try {
            return this.connection.createStatement();
        } catch (SQLException exception) {
            throw new DBException("Ошибка при создании выражения");
        }
    }
}
