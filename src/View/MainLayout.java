package View;

import Controller.MyActionListener;
import Controller.MyListListener;
import Model.Sql;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import static javax.swing.BorderFactory.createEmptyBorder;


public class MainLayout extends JFrame{

    public MainLayout() throws ClassNotFoundException, SQLException {
        super();
        createFrame();
    }


    public void createFrame() throws ClassNotFoundException, SQLException {
        Elements e = Elements.getInstance();
        ElementStyles es = ElementStyles.getInstance();

        e.getLeftPanel().setLayout(null);
        e.getLeftPanel().setBackground(new Color(60, 63, 65));
        e.getLeftPanel().setPreferredSize(new Dimension(e.getLeftPanelWidth(), e.getScreenHeight()));

        e.getRightPanel().setLayout(null);
        e.getRightPanel().setBackground(new Color(43, 43, 43));
        e.getRightPanel().setPreferredSize(new Dimension(e.getRightPanelWidth(), e.getScreenHeight()));

        e.getBottomPanel().setLayout(null);
        e.getBottomPanel().setBackground(new Color(43, 43, 43));
        e.getBottomPanel().setPreferredSize(new Dimension(e.getScreenWidth(), e.getScreenHeight()/30));

        e.getTopPanel().setLayout(null);
        e.getTopPanel().setBackground(new Color(43, 43, 43));
        e.getTopPanel().setPreferredSize(new Dimension(e.getScreenWidth(), e.getScreenHeight()/30));

        e.getMainFrame().add(e.getLeftPanel(),BorderLayout.WEST);
        e.getMainFrame().add(e.getRightPanel(),BorderLayout.CENTER);
        e.getMainFrame().add(e.getBottomPanel(),BorderLayout.SOUTH);
        e.getMainFrame().add(e.getTopPanel(),BorderLayout.NORTH);

        // Left menu list with scroll view
        e.getMenuList().setModel(Sql.getMenuItems());
        e.getMenuList().addListSelectionListener(new MyListListener());
        e.getMenuList().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        e.getMenuList().setSelectedIndex(0);
        e.getMenuList().setForeground(Color.WHITE);
        e.getMenuList().setBorder(createEmptyBorder(0,10,0,10));
        e.getMenuList().setSelectedIndex(0);
        e.getMenuList().setBackground(new Color(60, 63, 65));
        e.getMenuList().setFont(new Font("", Font.CENTER_BASELINE, e.getScreenHeight()/40));

        JScrollPane menuListScrollPane = new JScrollPane(e.getMenuList());
        menuListScrollPane.setBounds(0,0,e.getLeftPanelWidth(),e.getScreenHeight());
        menuListScrollPane.setBorder(null);
        e.getLeftPanel().add(menuListScrollPane);

        // Botom Widgets
        e.getSearchField().addActionListener(new MyActionListener());
        e.getSearchField().setVisible(true);
        e.getSearchField().setBounds((e.getScreenWidth()/4) + e.getScreenWidth()/6, 5, e.getScreenWidth()/5, e.getScreenHeight()/30);
        e.getSearchField().setFont(new Font("", Font.CENTER_BASELINE, e.getScreenHeight()/45));
        e.getBottomPanel().add(e.getSearchField());

        e.getComboBox().setVisible(true);
        e.getComboBox().setBounds((e.getScreenWidth()/4) + e.getScreenWidth()/20, 5, e.getScreenWidth()/10, e.getScreenHeight()/30);
        e.getComboBox().setFont(new Font("", Font.CENTER_BASELINE, e.getScreenHeight()/45));
        e.getBottomPanel().add(e.getComboBox());

        e.getSearchLabel().setVisible(true);
        e.getSearchLabel().setText("Sök i");
        e.getSearchLabel().setForeground(Color.WHITE);
        e.getSearchLabel().setFont(new Font("", Font.CENTER_BASELINE, e.getScreenHeight()/40));
        e.getSearchLabel().setBounds(e.getScreenWidth()/4, 0, e.getScreenWidth()/5, e.getScreenHeight()/30);
        e.getBottomPanel().add(e.getSearchLabel());


        e.getMainFrame().setTitle("Mini Projekt JDBC (Jonas Malik)");
        e.getMainFrame().setDefaultCloseOperation(e.getMainFrame().DISPOSE_ON_CLOSE);
        e.getMainFrame().setResizable(true);
        e.getMainFrame().setExtendedState(JFrame.MAXIMIZED_BOTH);
        e.getMainFrame().setUndecorated(false);
        e.getMainFrame().setVisible(true);
        }
}


