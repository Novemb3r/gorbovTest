package Models.Registrator;

import DBAuthenticator.Authenticator;

public class Registrator {

    /**
     * @param login
     * @param password
     * @param name
     * @param surname
     * @param dateOfBirth
     * @param gender
     * @return
     */
    public static boolean registerUser(String login, String password, String name, String surname, String patronym, String dateOfBirth, String gender) {
        Authenticator auth = new Authenticator();

        //@TODO: проверки параметров
        //@TODO: распаралелить
        //@TODO: отправлять данные пользователя в базу
        try {
            auth.register(login, password);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}
