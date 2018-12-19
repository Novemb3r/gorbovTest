package GUI.Forms;

import Common.Config;
import DBAuthenticator.AuthData;
import Database.DBException;
import Database.DBQuery;
import Database.DBStatement;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;

public class StatsForm {
    public JPanel panel1;
    public ResultSet data;

    public StatsForm() {
        panel1.setLayout(new GridBagLayout());
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

        JTable table1 = new JTable(buildTableModel(data));
        panel1.add(new JScrollPane(table1));
        //panel1.setPreferredSize(new Dimension(600, 600));
        panel1.revalidate();
        panel1.repaint();


      //  JOptionPane.showMessageDialog(null, new JScrollPane(table1));

    }

    /**
     * Нагло скопированно со StackOverflow
     *
     * @param resultSet
     * @return DefaultTableModel
     */
    private static DefaultTableModel buildTableModel(ResultSet resultSet) {
        try {

            ResultSetMetaData metaData = resultSet.getMetaData();

            // имена колонок
            Vector<String> columnNames = new Vector<>();
            int columnCount = metaData.getColumnCount();
            for (int column = 1; column <= columnCount; column++) {
                columnNames.add(metaData.getColumnName(column));
            }

            // данные таблицы
            Vector<Vector<Object>> data = new Vector<>();
            while (resultSet.next()) {
                Vector<Object> vector = new Vector<>();
                for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
                    vector.add(resultSet.getObject(columnIndex));
                }
                data.add(vector);
            }

            return new DefaultTableModel(data, columnNames);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
