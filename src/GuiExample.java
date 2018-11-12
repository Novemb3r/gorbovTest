import GUI.Controllers.LoginFormController;
import GUI.Controllers.SquareFormController;
import GUI.StateManager;

public class GuiExample {
    public static void main(String[] args) {
        StateManager.loadController(LoginFormController.class);

    }
}
