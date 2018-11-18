import GUI.Controllers.LoginFrameController;
import GUI.Forms.Constants;
import GUI.StateManager;

public class GuiExample {
    public static void main(String[] args) {
        StateManager.loadController(LoginFrameController.class, Constants.LOGIN_FORM);

    }
}
