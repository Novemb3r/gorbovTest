package GUI.Controllers;

import javax.swing.*;

/**
 * Интерфейс для контроллеров форм.
 * Предполагается, что контроллер содержит всю информацию о том, как создать форму и вывести ее на экран
 */
public interface IFormController {

    void loadForm();

    void destroyForm();
}
