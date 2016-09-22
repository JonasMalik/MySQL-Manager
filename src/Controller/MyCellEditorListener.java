package Controller;

import View.ElementStyles;
import View.Elements;

import javax.swing.event.CellEditorListener;
import javax.swing.event.ChangeEvent;

/**
 * Created by jonas on 2016-09-22.
 */
public class MyCellEditorListener implements CellEditorListener {
    ElementStyles es = ElementStyles.getInstance();
    Elements e = Elements.getInstance();

    @Override
    public void editingStopped(ChangeEvent changeEvent) {
        int col = e.getTable().getSelectedColumn();
        int row = e.getTable().getSelectedRow();
        String value = e.getTable().getValueAt(row,col).toString();
        e.getSearchLabel().setText(value);
    }

    @Override
    public void editingCanceled(ChangeEvent e) {

    }
}
