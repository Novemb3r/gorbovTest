package GUI;

import GUI.Controllers.IFormController;

import java.util.HashMap;
import java.util.Map;

/**
 * Менеджер состояний
 * По задумке - по переданному классу контроллера формы создаст контроллер и дернет loadForm(),
 * что приведет к отображению новой формы.
 * <p>
 * Статический, да него можно безболезненно дотянуться из любого метода
 */
public final class StateManager {

    private static Map<String, IFormController> loadedForms = new HashMap<String, IFormController>();

    public static void loadController(Class<? extends IFormController> formClass, String alias) {
        try {

            IFormController result = formClass.newInstance();
            loadedForms.put(alias, result);
            result.loadForm();

        } catch (Exception e) {
            System.out.println("Тут бросается тонна исключений. Удачи понять какую ты только что словил :)");
        }
    }

    /**
     * Убивает форму
     *
     * @param alias - алиас формы
     */
    public static void destroyForm(String alias) {
        IFormController form = loadedForms.get(alias);
        form.destroyForm();
    }
}
