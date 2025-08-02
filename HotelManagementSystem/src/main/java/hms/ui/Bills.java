package hms.ui;

import hms.HMS;
import hms.DatabaseMode;
import hms.dao.CustomerFullDAO;
import hms.dao.DAOFactory;
import hms.model.CustomerFull;
import hms.ui.DataChangeListener;
import hms.ui.DataChangeNotifier;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;
import java.util.Vector;

public class Bills extends JFrame implements DataChangeListener {
    private JPanel contentPane;
    private JTable table;

    public Bills() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(170, 125, 1100, 600);
        contentPane = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon icon = new ImageIcon(getClass().getResource("/hms/ui/bg-hotel.jpg"));
                g.drawImage(icon.getImage(), 0, 0, getWidth(), getHeight(), this);
            }
        };
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblName = new JLabel("All Customer Information");
        lblName.setFont(new Font("Yu Mincho", Font.BOLD, 30));
        lblName.setBounds(40, 0, 500, 53);
        lblName.setForeground(new Color(25, 25, 112));
        contentPane.add(lblName);

        table = new JTable();
        JTableHeader header = table.getTableHeader();
        header.setBackground(new Color(0, 102, 204));
        header.setForeground(Color.WHITE);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        table.setFont(new Font("Arial", Font.PLAIN, 14));
        table.setRowHeight(24);

        JScrollPane jp = new JScrollPane(table);
        jp.setBounds(0, 60, 1100, 400);
        jp.setVisible(true);
        contentPane.add(jp);

        // Load initial data
        loadData();

        JButton btnLoadData = new JButton("Refresh Data");
        btnLoadData.addActionListener(e -> loadData());
        btnLoadData.setBounds(40, 480, 150, 30);
        btnLoadData.setBackground(new Color(0, 102, 204));
        btnLoadData.setForeground(Color.WHITE);
        contentPane.add(btnLoadData);

        getContentPane().setBackground(Color.WHITE);

        // Register as data change listener
        DataChangeNotifier.addListener(this);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                DataChangeNotifier.removeListener(Bills.this);
            }
        });
    }

    private void loadData() {
        try {
            java.sql.Connection conn = null;
            if (HMS.dbMode == DatabaseMode.MYSQL) {
                try {
                    conn = java.sql.DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel_db", "root", "password");
                } catch (Exception ex) {
                    HMS.dbMode = DatabaseMode.MEMORY;
                }
            }
            CustomerFullDAO customerFullDAO = DAOFactory.getCustomerFullDAO(HMS.dbMode, conn);
            List<CustomerFull> customers = customerFullDAO.getAllCustomerFull();

            Vector<String> columnNames = new Vector<>();
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

            Vector<Vector<String>> data = new Vector<>();
            for (CustomerFull c : customers) {
                Vector<String> row = new Vector<>();
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

    @Override
    public void onDataChanged() {
        loadData();
    }
}
