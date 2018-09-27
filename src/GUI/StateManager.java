package GUI;

import GUI.Controllers.IFormController;

import java.lang.reflect.InvocationTargetException;

/**
 * Менеджер состояний.
 */
public final class StateManager {

    public static void loadController(Class<? extends IFormController> formClass) {
        try {

            IFormController result = formClass.newInstance();
            result.loadForm();

        } catch (Exception e) {
            System.out.println("Тут бросается тонна исключений. Удачи понять какую ты только что словил :)");
        }

    }

}
