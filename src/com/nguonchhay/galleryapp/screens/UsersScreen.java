package com.nguonchhay.galleryapp.screens;

import com.nguonchhay.galleryapp.services.MySQLServiceSingleton;

import javax.swing.*;
import javax.swing.event.CellEditorListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.EventObject;

public class UsersScreen extends JFrame {

    private JTable tableUser;
    private DefaultTableModel defaultTableModelUser;

    public UsersScreen() {
        super("User Screen");
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        initUI();
    }

    public void initUI() {
        JPanel pContent = new JPanel();
        pContent.setLayout(null);
        add(pContent, BorderLayout.CENTER);

        int initY = 20;
        JLabel lblTitle = new JLabel("Users");
        lblTitle.setFont(new Font("Times New Roman", Font.BOLD, 20));
        lblTitle.setBounds(50, initY, 100, 20);
        pContent.add(lblTitle);

        defaultTableModelUser = getUsers();
        tableUser = new JTable(defaultTableModelUser);
        tableUser.setDefaultEditor(Object.class, null);
        UserTableRenderedAndEditor userTableRenderedAndEditor = new UserTableRenderedAndEditor(tableUser);
        tableUser.getColumn("Action").setCellEditor(userTableRenderedAndEditor);
        tableUser.getColumn("Action").setCellRenderer(userTableRenderedAndEditor);
        tableUser.setRowHeight(30);
        JScrollPane scrollPaneUser = new JScrollPane(tableUser);
        scrollPaneUser.setBounds(50, initY + 40, 800, 400);
        pContent.add(scrollPaneUser);
    }

    private DefaultTableModel getUsers() {
        String[] columns = {"ID", "Full Name", "Email", "Action"};
        defaultTableModelUser = new DefaultTableModel(columns, 0);
        try {
            Connection connection = MySQLServiceSingleton.getConnection();
            String queryUser = "SELECT id, fullname, email FROM users;";
            Statement stm = connection.createStatement();
            ResultSet resultSet = stm.executeQuery(queryUser);
            while (resultSet.next()) {
                defaultTableModelUser.addRow(
                    new Object[] {
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        ""
                    }
                );
            }
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return defaultTableModelUser;
    }

    public void open() {
        super.setVisible(true);
    }

    public void close() {
        super.dispose();
    }

    class UserTableRenderedAndEditor implements TableCellEditor, TableCellRenderer {

        private JPanel pContent;
        private JButton btnEdit, btnDelete;
        private int selectedRow;


        public UserTableRenderedAndEditor(JTable table) {
            DefaultTableModel defaultTableModel = (DefaultTableModel) table.getModel();
            String id = defaultTableModel.getValueAt(selectedRow, 0).toString();

            pContent = new JPanel(new FlowLayout());
            btnEdit = new JButton("Edit");
            btnEdit.addActionListener(e -> {

                System.out.println("Edit at row: " + id);
            });
            pContent.add(btnEdit);

            btnDelete = new JButton("Remove");
            btnDelete.addActionListener(e -> {
                System.out.println("Delete at row: "+ id);
            });
            pContent.add(btnDelete);
        }

        @Override
        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
            selectedRow = row;
            return pContent;
        }

        @Override
        public Object getCellEditorValue() {
            return true;
        }

        @Override
        public boolean isCellEditable(EventObject anEvent) {
            return true;
        }

        @Override
        public boolean shouldSelectCell(EventObject anEvent) {
            return true;
        }

        @Override
        public boolean stopCellEditing() {
            return true;
        }

        @Override
        public void cancelCellEditing() {

        }

        @Override
        public void addCellEditorListener(CellEditorListener l) {

        }

        @Override
        public void removeCellEditorListener(CellEditorListener l) {

        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            return pContent;
        }
    }
}
