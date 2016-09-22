package View;


import javax.swing.*;
import javax.swing.table.JTableHeader;
import javax.swing.text.Element;
import java.awt.*;

/**
 * Created by jonas on 2016-08-22.
 */
public class Elements {

    private static Elements instance = null;
    protected Elements() {}
    public static Elements getInstance() {
        if(instance == null) {
            instance = new Elements();
        }
        return instance;
    }

    // JElements
    private JFrame mainFrame = new JFrame();
    private JPanel leftPanel = new JPanel();
    private JPanel rightPanel = new JPanel();
    private JPanel bottomPanel = new JPanel();
    private JPanel topPanel = new JPanel();
    private JList menuList = new JList();
    private JTextField searchField = new JTextField();
    private JLabel searchLabel = new JLabel();
    private JComboBox comboBox = new JComboBox();
    private JTable table = new JTable();
    private JTextField editTextField = new JTextField();
    private JScrollPane scrollPane = new JScrollPane();
    private JScrollBar bar = scrollPane.getVerticalScrollBar();
    private JTableHeader header = getTable().getTableHeader();

    // Dimensions
    private Dimension screen = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
    private int screenWidth = (int) screen.getWidth();
    private int screenHeight = (int) screen.getHeight();
    private int leftPanelWidth = screenWidth/5;
    private int rightPanelWidth = screenWidth-leftPanelWidth;


    public JFrame getMainFrame() {
        return mainFrame;
    }
    public void setMainFrame(JFrame mainFrame) {
        this.mainFrame = mainFrame;
    }
    public JPanel getLeftPanel() {
        return leftPanel;
    }
    public void setLeftPanel(JPanel leftPanel) {
        this.leftPanel = leftPanel;
    }
    public JPanel getRightPanel() {
        return rightPanel;
    }
    public void setRightPanel(JPanel rightPanel) {
        this.rightPanel = rightPanel;
    }
    public JList getMenuList() {
        return menuList;
    }
    public void setMenuList(JList menuList) {
        this.menuList = menuList;
    }
    public JPanel getBottomPanel() {
        return bottomPanel;
    }
    public void setBottomPanel(JPanel bottomPanel) {
        this.bottomPanel = bottomPanel;
    }
    public JPanel getTopPanel() {
        return topPanel;
    }
    public void setTopPanel(JPanel topPanel) {
        this.topPanel = topPanel;
    }
    public JTextField getSearchField() {
        return searchField;
    }
    public void setSearchField(JTextField searchField) {
        this.searchField = searchField;
    }
    public JLabel getSearchLabel() {
        return searchLabel;
    }
    public void setSearchLabel(JLabel searchLabel) {
        this.searchLabel = searchLabel;
    }
    public JComboBox getComboBox() {
        return comboBox;
    }
    public void setComboBox(JComboBox comboBox) {
        this.comboBox = comboBox;
    }
    public JTable getTable() {
        return table;
    }
    public void setTable(JTable table) {
        this.table = table;
    }
    public JScrollPane getScrollPane() {
        return scrollPane;
    }
    public void setScrollPane(JScrollPane scrollPane) {
        this.scrollPane = scrollPane;
    }
    public JScrollBar getBar() {
        return bar;
    }
    public void setBar(JScrollBar bar) {
        this.bar = bar;
    }
    public JTableHeader getHeader() {
        return header;
    }
    public void setHeader(JTableHeader header) {
        this.header = header;
    }
    public JTextField getEditTextField() {
        return editTextField;
    }
    public void setEditTextField(JTextField editTextField) {
        this.editTextField = editTextField;
    }

    public Dimension getScreen() {
        return screen;
    }
    public int getScreenWidth() {
        return screenWidth;
    }
    public int getScreenHeight() {
        return screenHeight;
    }
    public int getLeftPanelWidth() {
        return leftPanelWidth;
    }
    public int getRightPanelWidth() {
        return rightPanelWidth;
    }
}
