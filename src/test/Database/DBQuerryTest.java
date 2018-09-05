package test.Database;

import Database.DBQuerry;
import junit.framework.TestCase;

public class DBQuerryTest extends TestCase {

    DBQuerry q = new DBQuerry();

    public void testDBQuerry() {
        DBQuerry q = new DBQuerry();
        String actual;
        String expected;

        actual = q.select().from("testtable").where("id = 0").getQuerry();
        expected = "SELECT * FROM testtable WHERE id = 0";
        assertEquals(expected, actual);

        q.clear();
        actual = q.getQuerry();
        expected = "";
        assertEquals(expected, actual);

        q.clear();
        actual = q.select().from("testtable").where("id = 0, email = test@test.com").getQuerry();
        expected = "SELECT * FROM testtable WHERE id = 0, email = test@test.com";
        assertEquals(expected, actual);

    }
}
