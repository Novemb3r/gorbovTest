import Database.DBConnection;
import Database.DBException;
import Database.DBQuery;
import Database.DBStatement;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DBExample {

    public static void main(String[] args) throws DBException, SQLException {
        DBConnection conn = new DBConnection();

        conn.open();

        DBStatement stat = new DBStatement(conn);

        String query = (new DBQuery()).select().from("users").getQuery();

        ResultSet rs = stat.executeQuery(query);

        while(rs.next()){
            String id  = rs.getString("email");
            String age = rs.getString("password");

            System.out.print("email: " + id);
            System.out.print(", password: " + age + "\n");
        }
    }

}
