package test.Database;

import Database.DBQuery;
import junit.framework.TestCase;

public class DBQueryTest extends TestCase {

    public void testDBQuerry() {
        DBQuery q = new DBQuery();
        String actual;
        String expected;

        actual = q.select().from("testtable").where("id = 0").getQuery();
        expected = "SELECT * FROM testtable WHERE id = 0";
        assertEquals(expected, actual);

        q.clear();
        actual = q.getQuery();
        expected = "";
        assertEquals(expected, actual);

        q.clear();
        actual = q.select().from("testtable").where("id = 0 AND email = test@test.com").getQuery();
        expected = "SELECT * FROM testtable WHERE id = 0 AND email = test@test.com";
        assertEquals(expected, actual);

        q.clear();
        actual = q.select().from("testtable").where(new String[]{"id = 0", "email = test@test.com"}).getQuery();
        expected = "SELECT * FROM testtable WHERE id = 0 AND email = test@test.com";
        assertEquals(expected, actual);

        q.clear();
        actual = q.select().from("testtable").where("id = ?", 17).getQuery();
        expected = "SELECT * FROM testtable WHERE id = 17";
        assertEquals(expected, actual);

        q.clear();
        actual = q.select().from("testtable").where("id = ?", "17").getQuery();
        expected = "SELECT * FROM testtable WHERE id = '17'";
        assertEquals(expected, actual);

        q.clear();
        actual = q.select().from("testtable").where(new String[]{"id = ?", "email = ?"}, new Double[]{10.0, 11.0}).getQuery();
        expected = "SELECT * FROM testtable WHERE id = 10.0 AND email = 11.0";
        assertEquals(expected, actual);

        q.clear();
        actual = q.insert("users", new String[] {"email", "password"}).values(new String[]{"abc@abc.com", "passsss"}).getQuery();
        expected = "INSERT INTO users (email, password) VALUES ('abc@abc.com', 'passsss') ";
        assertEquals(expected, actual);

    }
}
