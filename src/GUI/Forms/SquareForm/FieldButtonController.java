package GUI.Forms.SquareForm;

import GUI.Objects.TestFieldButton;
import Models.Stages.StageAbstract;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Контроллер для кнопки.
 * Реализует метод actionPerformed, который говорит о том, что происхдит, когда пользователь нажимает кнопку
 */
public class FieldButtonController implements ActionListener {

    StageAbstract stage;

    public FieldButtonController(StageAbstract stage) {
        this.stage = stage;
    }

    public void actionPerformed(ActionEvent e) {
        TestFieldButton b = (TestFieldButton) e.getSource();
        System.out.println(b.position.toString());
        if (this.stage.playersTurn(b.getNumber(), b.getType())) {
            b.markDisabled();
        }
    }
}
