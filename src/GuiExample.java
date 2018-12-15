import Common.Config;
import Database.DBConnection;
import GUI.Controllers.LoginFrameController;
import GUI.Forms.Constants;
import GUI.StateManager;

public class GuiExample {

    public static void main(String[] args) {
        try {
            Config.conn = new DBConnection();
            Config.conn.open();
        } catch (Exception e) {
            e.printStackTrace();
        }

        StateManager.loadController(LoginFrameController.class, Constants.LOGIN_FORM);
//        StateManager.loadController(SquareFormController.class, "123123");
    }
}
