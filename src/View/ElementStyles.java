package View;

import Controller.MyCellEditorListener;
import Controller.MyKeyListner;
import Controller.MyMouseListener;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

/**
 * Created by jonas on 2016-09-21.
 */
public class ElementStyles {
    Elements e = Elements.getInstance();

    private static ElementStyles instance = null;
    protected ElementStyles() {}
    public static ElementStyles getInstance() {
        if(instance == null) {
            instance = new ElementStyles();
        }
        return instance;
    }

    public void createTable(DefaultTableModel tableModel) {
        int count = tableModel.getColumnCount();
        for (int i = 0; i< count; i++){
            e.getComboBox().addItem(tableModel.getColumnName(i));
        }
        e.getTable().addKeyListener(new MyKeyListner());
        e.getTable().addMouseListener(new MyMouseListener());

        e.getTable().setModel(tableModel);
        e.getTable().setRowHeight(e.getScreenHeight()/30);
        e.getTable().setFont(new Font("", Font.CENTER_BASELINE, 30));
        e.getTable().setBackground(Color.WHITE);
        e.getTable().getColumnModel().setColumnMargin(3);

        e.getScrollPane().setViewportView(e.getTable());
        e.getScrollPane().setBounds(0,0,e.getRightPanelWidth(),e.getScreenHeight());
        e.getHeader().setPreferredSize(new Dimension(100, e.getScreenHeight()/28));
        e.getHeader().setFont(new Font("", Font.CENTER_BASELINE,e.getScreenHeight()/40));
        e.getBar().setPreferredSize(new Dimension(40, 0));
        e.getRightPanel().add(e.getScrollPane());

        e.getEditTextField().setFont(new Font("Verdana", 1, 30));
        DefaultCellEditor dce = new DefaultCellEditor(e.getEditTextField());
        dce.addCellEditorListener(new MyCellEditorListener());
        for (int i = 0; i < e.getTable().getColumnCount(); i++) {
            e.getTable().getColumnModel().getColumn(i).setCellEditor(dce);
        }
    }
}
