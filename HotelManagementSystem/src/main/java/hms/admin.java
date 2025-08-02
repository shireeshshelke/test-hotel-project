package hms;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import hms.dao.UserDAO;
import hms.dao.DAOFactory;
import hms.model.User;
import hms.DatabaseMode;

public class admin extends JFrame {
    private JPanel contentPane;
    private JTable table;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    admin frame = new admin();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public admin() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(170, 125, 1100, 600);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        contentPane.setVisible(true);

        JLabel lblName = new JLabel("Admins");
        lblName.setFont(new Font("Yu Mincho", Font.BOLD, 40));
        lblName.setBounds(40, 0, 260, 53);
        lblName.setVisible(true);
        contentPane.add(lblName);

        table = new JTable();
        table.setVisible(true);
        JTableHeader header = table.getTableHeader();
        header.setBackground(Color.BLUE);
        header.setForeground(Color.WHITE);
        header.setVisible(true);
        table.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        JScrollPane jp = new JScrollPane(table);
        jp.setBounds(0, 60, 1100, 400);
        jp.setVisible(true);
        contentPane.add(jp);

        // Load initial data
        loadData();

        JButton btnLoadData = new JButton("Refresh Data");
        btnLoadData.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                loadData();
            }
        });
        btnLoadData.setBounds(40, 480, 150, 30);
        btnLoadData.setBackground(Color.BLACK);
        btnLoadData.setForeground(Color.WHITE);
        btnLoadData.setVisible(true);
        contentPane.add(btnLoadData);

        getContentPane().setBackground(Color.WHITE);
        getContentPane().setVisible(true);
    }

    private void loadData() {
        try {
            table.setModel(new javax.swing.table.DefaultTableModel());
            // Get DAO for dual mode
            UserDAO userDAO = DAOFactory.getUserDAO(HMS.dbMode, null);
            java.util.List<User> users = userDAO.getAllUsers();

            java.util.Vector<String> columnNames = new java.util.Vector<String>();
            columnNames.add("Username");
            columnNames.add("Password");

            java.util.Vector<java.util.Vector<String>> data = new java.util.Vector<>();
            for (User u : users) {
                java.util.Vector<String> row = new java.util.Vector<>();
                row.add(u.getUsername());
                row.add(u.getPassword());
                data.add(row);
            }
            table.setModel(new javax.swing.table.DefaultTableModel(data, columnNames));
            table.setVisible(true);
        } catch(Exception e1) {
            e1.printStackTrace();
        }
    }
}