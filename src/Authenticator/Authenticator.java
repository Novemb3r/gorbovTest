package Authenticator;

import Database.DBConnection;
import Database.DBException;
import Database.DBQuery;
import Database.DBStatement;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Authenticator {

    private static final String PASSWORD_SALT = "Bpgf38BCZJBIOVQUNYBF";
    private static DBConnection connection;

    public Authenticator (DBConnection conn) {
        connection = conn;
    }

    public boolean isRegistred (String email) throws DBException, SQLException {
        String query = (new DBQuery()).select().from("users").where("email = ?", email).getQuery();
        ResultSet rs = (new DBStatement(connection)).executeQuery(query);

        if (rs.next()){
            return true;
        }
        return false;
    }

}
