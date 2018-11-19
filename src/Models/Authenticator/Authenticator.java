package Models.Authenticator;

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
}
