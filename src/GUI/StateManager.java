package GUI;

import GUI.Controllers.IFormController;

/**
 * Менеджер состояний
 * По задумке - по переданному классу контроллера формы создаст контроллер и дернет loadForm(),
 * что приведет к отображению новой формы.
 *
 * Статический, да него можно безболезненно дотянуться из любого метода
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
