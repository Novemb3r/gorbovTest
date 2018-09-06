import Authenticator.Authenticator;
import Database.DBConnection;
import Database.DBException;
import Database.DBStatement;

import java.sql.SQLException;

public class RegisExample {

    public static void main(String[] args) throws DBException, SQLException {
        DBConnection conn = new DBConnection();

        conn.open();

        Authenticator auth = new Authenticator(conn);
        DBStatement stat = new DBStatement(conn);

        boolean reg = auth.register("igkutyrev@gmai.com", "mypass");

        System.out.println(reg);

    }
}
