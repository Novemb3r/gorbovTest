package GUI.SquareForm;

import GUI.Objects.TestFieldButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FieldButtonController implements ActionListener {

    public void actionPerformed(ActionEvent e) {
        TestFieldButton b = (TestFieldButton)e.getSource();
        System.out.println(b.position.toString());
    }
}
