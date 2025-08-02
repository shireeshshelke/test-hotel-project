package hms;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import hms.dao.CustomerFullDAO;
import hms.dao.DAOFactory;
import hms.model.CustomerFull;
import hms.DatabaseMode;

public class Bills extends JFrame {
    private JPanel contentPane;
    private JTable table;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Bills frame = new Bills();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Bills() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(170, 125, 1100, 600);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        contentPane.setVisible(true);

        JLabel lblName = new JLabel("All Customer Information");
        lblName.setFont(new Font("Yu Mincho", Font.BOLD, 30));
        lblName.setBounds(40, 0, 500, 53);
        lblName.setVisible(true);
        contentPane.add(lblName);

        table = new JTable();
        JTableHeader header = table.getTableHeader();
        header.setBackground(Color.BLUE);
        header.setForeground(Color.WHITE);
        table.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        table.setVisible(true);
        header.setVisible(true);

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
        setVisible(true);
    }

    private void loadData() {
        try {
            // Get DAO for dual mode
            java.sql.Connection conn = null;
            if (HMS.dbMode == DatabaseMode.MYSQL) {
                try {
                    conn = java.sql.DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel_db", "root", "password");
                } catch (Exception ex) {
                    HMS.dbMode = DatabaseMode.MEMORY;
                }
            }
            CustomerFullDAO customerFullDAO = DAOFactory.getCustomerFullDAO(HMS.dbMode, conn);
            java.util.List<CustomerFull> customers = customerFullDAO.getAllCustomerFull();

            java.util.Vector<String> columnNames = new java.util.Vector<String>();
            columnNames.add("ID Type");
            columnNames.add("ID Number");
            columnNames.add("Name");
            columnNames.add("Gender");
            columnNames.add("Country");
            columnNames.add("Room Number");
            columnNames.add("Room Price");
            columnNames.add("Mobile 1");
            columnNames.add("Email");
            columnNames.add("Check-in Date");
            columnNames.add("Check-out Date");
            columnNames.add("Status");

            java.util.Vector<java.util.Vector<String>> data = new java.util.Vector<>();
            for (CustomerFull c : customers) {
                java.util.Vector<String> row = new java.util.Vector<>();
                row.add(c.idType);
                row.add(c.idNumber);
                row.add(c.name);
                row.add(c.gender);
                row.add(c.country);
                row.add(c.roomNumber);
                row.add(c.roomPrice);
                row.add(c.mobile);
                row.add(c.email);
                row.add(c.checkInDate);
                row.add(c.checkOutDate);
                row.add(c.status);
                data.add(row);
            }
            table.setModel(new javax.swing.table.DefaultTableModel(data, columnNames));
        } catch(Exception e1) {
            e1.printStackTrace();
        }
    }
}