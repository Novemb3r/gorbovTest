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

    public ResultSet executeQuery(String query) throws DBException {
        try {
            return statement.executeQuery(query);
        } catch (SQLException exception) {
            System.out.println(exception);
            throw new DBException("Ошибка в запросе");
        }
    }


}
