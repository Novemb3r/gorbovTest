package GUI.Forms.InterpretationForm;

import Common.Config;
import DBAuthenticator.AuthData;
import Database.DBException;
import Database.DBQuery;
import Database.DBStatement;
import GUI.Controllers.InterpretationController;
import GUI.Controllers.MainMenuFrameController;
import GUI.Controllers.SquareFormController;
import GUI.Forms.Constants;
import GUI.StateManager;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class InterpretationForm {
    private JButton goBackButton;
    public JPanel panel1;
    private JLabel recom;
    private JLabel markLabel;
    private JLabel errorsLabel;
    private JLabel resultLabel;
    public ResultSet data;

    public InterpretationForm() {
        goBackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StateManager.destroyForm(Constants.INTERPR_FORM);
                StateManager.loadController(MainMenuFrameController.class, Constants.MENU_FORM);
            }
        });

        String query = (new DBQuery())
                .select("*")
                .from("results")
                .where(new String[]{"`userId` = ?"}, new String[]{AuthData.getUserName()})
                .getQuery();

        try {
            data = (new DBStatement(Config.conn)).executeQuery(query);
        } catch (DBException e) {
            e.printStackTrace();
        }
        try {
            ResultSetMetaData metaData = data.getMetaData();
            if (data.last()) {
                Long timeFirst = (Long) data.getObject(4) - (Long) data.getObject(3);
                Long timeSecond = (Long) data.getObject(6) - (Long) data.getObject(5);
                Long timeDelta = timeSecond - timeFirst;
                Long errors = (Long) data.getObject(7) + (Long) data.getObject(8);

                resultLabel.setText("Переключение внимания: " + timeDelta.toString() + " c");
                errorsLabel.setText("Суммарное количество ошибок: " + errors.toString());

                double mark;
                if (timeDelta > 200)
                    mark = 1;
                else if (timeDelta <= 50)
                    mark = 5;
                else mark = (950 - 4 * timeDelta) / 150;
                mark -= errors * 0.1;
                markLabel.setText("Ваша оценка: " + mark);

                if (mark >= 4)
                    recom.setText("Ваше переключение и распределение внимания в норме. Дефектов не обнаружено");
                else
                    recom.setText("Обнаружены некоторые проблемы. Обратитесь к специалисту");
            }
            else
            {
                markLabel.setText("Вы не прошли ни одного теста, интерпретация результатов недоступна");
            }
        }
        catch (SQLException e)
         {
          e.printStackTrace();
         }

    }

}
