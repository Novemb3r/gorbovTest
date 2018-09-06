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

    public boolean isRegistred(String email) throws DBException, SQLException {
        String query = (new DBQuery()).select().from("users").where("email = ?", email).getQuery();
        ResultSet rs = (new DBStatement(connection)).executeQuery(query);

        if (rs.next()) {
            return true;
        }
        return false;
    }

    public boolean authenticate(String email, String password) {
        // String hash = getMd5Hash();
        return true;
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
