package Database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBStatement {

    private Statement statement;

    /**
     * Конструктор класса
     *
     * @param connection DBConnection
     */
    public DBStatement(DBConnection connection) throws DBException {
        this.statement = connection.createStatement();
    }

    /**
     * Выполняет заарос на выборку данных
     *
     * @param query строка SQL запроса
     * @return ResultSet
     * @throws DBException
     */
    public ResultSet executeQuery(String query) throws DBException {
        try {
            return statement.executeQuery(query);
        } catch (SQLException exception) {
            System.out.println(query);
            exception.printStackTrace();
            throw new DBException("Ошибка в запросе");
        }
    }

    /**
     * Выполняет заарос на выборку данных
     *
     * @param query строка SQL запроса
     * @return ResultSet
     * @throws DBException
     */
    public int executeUpdate(String query) throws DBException {
        try {
            return statement.executeUpdate(query);
        } catch (SQLException exception) {
            System.out.println(query);
            exception.printStackTrace();
            throw new DBException("Ошибка в запросе");
        }
    }


}
