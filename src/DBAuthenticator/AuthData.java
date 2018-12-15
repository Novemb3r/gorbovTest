package DBAuthenticator;

public class AuthData {

    public static String getUserName() {
        return userName;
    }

    public static void setUserName(String userName) {
        AuthData.userName = userName;
    }

    private static String userName;
}
