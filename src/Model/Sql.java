package Model;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.util.ArrayList;

/**
 * Created by jonas on 2016-09-21.
 */
public class Sql {

    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/epic_rpg";

    //  Database login
    static final String USER = "root";
    static final String PASS = "";

    // Clear
    static Connection conn = null;
    static Statement stmt = null;

    public static DefaultListModel getMenuItems() throws ClassNotFoundException, SQLException {
        String sql;
        DefaultListModel menuItems = new DefaultListModel();

            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            sql = "SHOW TABLES";
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                String name = rs.getString(1);
                menuItems.addElement(name);
                System.out.println(name);
            }
            rs.close();
            stmt.close();
            conn.close();
        return menuItems;
    }

    public static DefaultTableModel getTablePosts(String tableName, String col, String search) throws ClassNotFoundException, SQLException {
        String sql;
        String sqlSearch;
        DefaultTableModel tableModel; // = new DefaultListModel();
        ArrayList<ArrayList> rowData = new ArrayList<>();
        ArrayList<String> columnNames = new ArrayList<>();

        Class.forName(JDBC_DRIVER);
        conn = DriverManager.getConnection(DB_URL, USER, PASS);
        stmt = conn.createStatement();
        ResultSet rs;
        sql = "SELECT * FROM "+tableName+";";
        sqlSearch = "SELECT * FROM "+tableName+" WHERE "+col+" LIKE '%"+search+"%';";
        if (search.equals("")) {
            rs = stmt.executeQuery(sql);
        }else {
            rs = stmt.executeQuery(sqlSearch);
        }
        int j = 0;
        while (rs.next()) {
            rowData.add(new ArrayList<String>());
            for (int i = 1; i<=rs.getMetaData().getColumnCount(); i++) {
                rowData.get(j).add(rs.getString(i));
            }
            j++;
        }
        for (int i = 1; i<=rs.getMetaData().getColumnCount(); i++) {
            columnNames.add(rs.getMetaData().getColumnName(i));
        }

        String[][] rowDataArray = new String[rowData.size()][];
        for (int i = 0; i < rowData.size(); i++) {
            ArrayList<String> row = rowData.get(i);
            rowDataArray[i] = row.toArray(new String[row.size()]);
        }

        String []columnNameArray = new String[columnNames.size()];
        columnNames.toArray(columnNameArray);

        tableModel = new DefaultTableModel(rowDataArray,columnNameArray);

        System.out.println(rowDataArray);

        rs.close();
        stmt.close();
        conn.close();
        return tableModel;
    }

    public static String getPrimeryKey(String tableName) throws ClassNotFoundException, SQLException {
        String sql;
        DefaultListModel menuItems = new DefaultListModel();

        Class.forName(JDBC_DRIVER);
        conn = DriverManager.getConnection(DB_URL, USER, PASS);
        stmt = conn.createStatement();
        sql = "show index from "+tableName+" where Key_name = 'PRIMARY'";
        ResultSet rs = stmt.executeQuery(sql);

        rs.next();
        String column = rs.getString("Column_name");
        System.out.println(column);

        rs.close();
        stmt.close();
        conn.close();
        return column ;
    }

}
