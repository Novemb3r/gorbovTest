package Authenticator;

import Database.DBConnection;
import Database.DBException;
import Database.DBQuery;
import Database.DBStatement;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Класс для обработки регистрации и аутентификации пользователя
 */
public class Authenticator {

    private static MessageDigest Md5Hasher;
    private static DBConnection connection;

    public Authenticator(DBConnection conn) {
        connection = conn;
    }

    /**
     * Проверяет, зарегистрирован ли пользователь
     *
     * @param email email
     * @return boolean
     * @throws DBException
     * @throws SQLException
     */
    public boolean isRegistred(String email) throws DBException, SQLException {
        String query = (new DBQuery()).select().from("users").where("email = ?", email).getQuery();
        ResultSet rs = (new DBStatement(connection)).executeQuery(query);

        return rs.next();
    }

    /**
     * Проверяет авторизацию
     *
     * @param email email
     * @return boolean
     * @throws DBException
     * @throws SQLException
     */
    public boolean authenticate(String email, String password) throws SQLException, DBException {

        String query = (new DBQuery())
                .select("count *")
                .from("users")
                .where("email = ? AND password = ?", new String[]{email, getMd5Hash(password)})
                .getQuery();

        ResultSet rs = (new DBStatement(connection)).executeQuery(query);

        return rs.next();
    }

    /**
     * Регистрирут нового пользователя
     *
     * @param email email
     * @return boolean
     * @throws DBException
     * @throws SQLException
     */
    public boolean register(String email, String password) throws SQLException, DBException {

        if (this.isRegistred(email)) {
            return false;
        }

        String query = (new DBQuery())
                .insert("users", new String[]{"email", "password"})
                .values(new String[]{email, getMd5Hash(password)})
                .getQuery();

        int i = (new DBStatement(connection)).executeUpdate(query);

        return (i != 0);
    }

    /**
     * Возвращает MD5 от соленого пароля
     * Иногда java заставляет тебя плакать
     *
     * @param password строка-пароль
     * @return String
     */
    public static String getMd5Hash(String password) {
        password += Constants.PASSWORD_SALT;

        try {
            Md5Hasher = MessageDigest.getInstance(Constants.HASH_ALGORITM);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        Md5Hasher.reset();
        Md5Hasher.update(password.getBytes());
        byte[] digest = Md5Hasher.digest();

        BigInteger bigInt = new BigInteger(1, digest);
        String hashtext = bigInt.toString(16);

        while (hashtext.length() < 32) {
            hashtext = "0" + hashtext;
        }

        return hashtext;
    }

}
