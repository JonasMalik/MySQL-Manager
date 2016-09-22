package Controller;

import Model.Sql;
import View.ElementStyles;
import View.Elements;
import View.MainLayout;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.sql.SQLException;


/**
 * Created by jonas on 2016-09-21.
 */
public class MyListListener implements ListSelectionListener {

    ElementStyles es = ElementStyles.getInstance();
    Elements e = Elements.getInstance();

    @Override
    public void valueChanged(ListSelectionEvent selected) {
        try {
            String tableName = e.getMenuList().getSelectedValue().toString();
            e.getComboBox().removeAllItems();
            es.createTable(Sql.getTablePosts(tableName,"",""));
        } catch (ClassNotFoundException e1) {
            e1.printStackTrace();
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
    }
}
