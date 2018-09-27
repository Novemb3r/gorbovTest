package GUI.Forms.SquareForm;

import GUI.Objects.TestFieldButton;
import Models.Stages.StageAbstract;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
