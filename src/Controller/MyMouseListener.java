package Controller;

import Model.Sql;
import View.ElementStyles;
import View.Elements;
import org.w3c.dom.events.MouseEvent;

import java.awt.event.MouseListener;
import java.sql.SQLException;

/**
 * Created by jonas on 2016-09-22.
 */
public class MyMouseListener implements MouseListener {
    ElementStyles es = ElementStyles.getInstance();
    Elements e = Elements.getInstance();

    @Override
    public void mouseClicked(java.awt.event.MouseEvent mouseEvent) {
        if (mouseEvent.getSource() == e.getTable()){
            try {
                String pkColumn = Sql.getPrimeryKey(e.getMenuList().getSelectedValue().toString());
                int col = e.getTable().getSelectedColumn();
                int row = e.getTable().getSelectedRow();
                String value = e.getTable().getValueAt(row,col).toString();
                e.getSearchLabel().setText(pkColumn);
            } catch (ClassNotFoundException e1) {
                e1.printStackTrace();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }
    }




    @Override
    public void mousePressed(java.awt.event.MouseEvent e) {

    }

    @Override
    public void mouseReleased(java.awt.event.MouseEvent e) {

    }

    @Override
    public void mouseEntered(java.awt.event.MouseEvent e) {

    }

    @Override
    public void mouseExited(java.awt.event.MouseEvent e) {

    }
}
