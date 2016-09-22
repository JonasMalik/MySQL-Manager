package Controller;

import Model.Sql;
import View.ElementStyles;
import View.Elements;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

/**
 * Created by jonas on 2016-09-22.
 */
public class MyActionListener implements ActionListener {
    ElementStyles es = ElementStyles.getInstance();
    Elements e = Elements.getInstance();

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getSource() == e.getSearchField() ) {
            try {
                String tableName = e.getMenuList().getSelectedValue().toString();
                String colName = e.getComboBox().getSelectedItem().toString();
                String serach = e.getSearchField().getText();
                es.createTable(Sql.getTablePosts(tableName, colName, serach));
            } catch (ClassNotFoundException e1) {
                e1.printStackTrace();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }

    }
}
