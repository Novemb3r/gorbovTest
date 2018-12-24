package Models.Authenticator;

import Common.Config;
import DBAuthenticator.AuthData;
import Database.DBException;
import Database.DBQuery;
import Database.DBStatement;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Authenticator {

    /**
     * @param login
     * @param password
     * @return
     */
    public static boolean authUser(String login, String password) {

        try {

            DBAuthenticator.Authenticator auth = new DBAuthenticator.Authenticator();
            return auth.authenticate(login, password);

        } catch (Exception exception) {
            exception.printStackTrace();
        }

        return false;
    }

    /**
     * @return
     */
    public static boolean isUserDoctor() {
        String query = (new DBQuery())
                .select("role")
                .from("users")
                .join("auth")
                .on("users.id = auth.id ")
                .where("email = ? and role = 'doctor'", AuthData.getUserName())
                .getQuery();

        try {
            ResultSet i = (new DBStatement(Config.conn)).executeQuery(query);
            return !i.isBeforeFirst();
        } catch (DBException | SQLException e) {
            return false;
        }


    }
}
