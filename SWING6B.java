import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class prac5c {

    public static void main(String[] args) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("CONNECTED SUCCCESSFULLY ");
        } catch (Exception c) {
            c.getStackTrace();
        }
        JFrame frame = new JFrame("Display Table");
        JButton forward = new JButton("FORWARD");
        JButton backward = new JButton("BACKWARD");
        JTable table = new JTable();
        frame.setLayout(new FlowLayout());
        JScrollPane scrollPane = new JScrollPane(table);
        frame.add(scrollPane);
        frame.add(forward);
        frame.add(backward);
        frame.setSize(500, 500);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);

        forward.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Connection connection;
                try {
                    connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/firstDB", "root", "root");
                    Statement statement = connection.createStatement();
                    ResultSet resultSet = statement.executeQuery("SELECT * FROM expenses");
                    ResultSetMetaData metaData = resultSet.getMetaData();
                    int columnCount = metaData.getColumnCount();
                    String[] columnNames = new String[columnCount];
                    for (int i = 0; i < columnCount; i++) {
                        columnNames[i] = metaData.getColumnName(i + 1);
                    }
                    DefaultTableModel model = new DefaultTableModel(columnNames, 0);
                    while (resultSet.next()) {
                        Object[] rowData = new Object[columnCount];
                        for (int i = 0; i < columnCount; i++) {
                            rowData[i] = resultSet.getObject(i + 1);
                        }
                        model.addRow(rowData);
                    }
                    table.setModel(model);
                    resultSet.close();
                    statement.close();
                    connection.close();
                } catch (SQLException se) {
                    se.printStackTrace();
                }

            }
        });


        backward.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Connection connection;
                try {
                    connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/firstDB", "root", "root");
                    Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
                    ResultSet resultSet = statement.executeQuery("SELECT * FROM expenses");
                    ResultSetMetaData metaData = resultSet.getMetaData();
                    int columnCount = metaData.getColumnCount();
                    String[] columnNames = new String[columnCount];
                    for (int i = 0; i < columnCount; i++) {
                        columnNames[i] = metaData.getColumnName(i + 1);
                    }
                    DefaultTableModel model = new DefaultTableModel(columnNames, 0);
                    resultSet.afterLast();
                    while (resultSet.previous()) {
                        Object[] rowData = new Object[columnCount];
                        for (int i = 0; i < columnCount; i++) {
                            rowData[i] = resultSet.getObject(i + 1);
                        }
                        model.addRow(rowData);
                    }
                    table.setModel(model);
                    resultSet.close();
                    statement.close();
                    connection.close();
                } catch (SQLException se) {
                    se.printStackTrace();
                } 
            }
            
        });

    }
}

