import DBAuthenticator.Authenticator;
import Database.DBConnection;
import Database.DBException;
import Database.DBStatement;

import java.sql.SQLException;

public class AuthExample {


    public static void main(String[] args) throws DBException, SQLException {
        DBConnection conn = new DBConnection();

        conn.open();

        Authenticator auth = new Authenticator();
        DBStatement stat = new DBStatement(conn);
        
        if (auth.isRegistred("i@i.ru")) {
            System.out.println("i@i.ru is registred");
        } else {
            System.out.println("i@i.ru is not registred");
        }

        if (auth.isRegistred("a@a.ru")) {
            System.out.println("a@a.ru is registred");
        } else {
            System.out.println("a@a.ru is not registred");
        }

    }
}
