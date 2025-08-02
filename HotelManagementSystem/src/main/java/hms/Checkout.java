package hms;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import hms.dao.CustomerFullDAO;
import hms.dao.RoomDAO;
import hms.dao.DAOFactory;
import hms.model.CustomerFull;
import hms.model.Room;
import hms.DatabaseMode;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Checkout extends JFrame {
    private JPanel contentPane;
    private JTextField t0, t1, t2, t3, t4, t5, t6, t7, t8;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Checkout frame = new Checkout();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Checkout() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(270, 125, 800, 600);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblName = new JLabel("CHECK-OUT");
        lblName.setFont(new Font("Yu Mincho", Font.BOLD, 40));
        lblName.setBounds(118, 11, 260, 53);
        contentPane.add(lblName);

        JLabel lblRoomNumber = new JLabel("Room Number:");
        lblRoomNumber.setBounds(35, 80, 200, 14);
        contentPane.add(lblRoomNumber);

        t0 = new JTextField();
        t0.setBounds(250, 80, 150, 20);
        contentPane.add(t0);
        t0.setColumns(10);

        JButton sc = new JButton("Search");
        sc.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    String roomNum = t0.getText();
                    // Get DAOs for dual mode
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
                    CustomerFull found = null;
                    for (CustomerFull c : customers) {
                        if (c.roomNumber.equals(roomNum) && "check in".equalsIgnoreCase(c.status)) {
                            found = c;
                            break;
                        }
                    }
                    if (found != null) {
                        t1.setText(found.name);
                        t2.setText(found.checkInDate);
                        t4.setText(found.mobile);
                        t5.setText(found.roomPrice);
                        t8.setText(found.email);

                        // Set current date as checkout date
                        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                        Calendar cal = Calendar.getInstance();
                        t3.setText(dateFormat.format(cal.getTime()));

                        // Calculate days and total amount (simplified calculation)
                        t6.setText("1"); // Default to 1 day for simplicity
                        int price = Integer.parseInt(found.roomPrice);
                        t7.setText(String.valueOf(price));
                    } else {
                        JOptionPane.showMessageDialog(null, "Room not found or already checked out");
                    }
                } catch(Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        sc.setBounds(420, 80, 100, 20);
        contentPane.add(sc);

        JLabel l1 = new JLabel("Name:");
        l1.setBounds(35, 120, 200, 14);
        contentPane.add(l1);

        t1 = new JTextField();
        t1.setBounds(250, 120, 150, 20);
        t1.setEditable(false);
        contentPane.add(t1);
        t1.setColumns(20);

        JLabel l2 = new JLabel("Check-in Date:");
        l2.setBounds(35, 160, 200, 14);
        contentPane.add(l2);

        t2 = new JTextField();
        t2.setBounds(250, 160, 150, 20);
        t2.setEditable(false);
        contentPane.add(t2);

        JLabel l3 = new JLabel("Check-out Date:");
        l3.setBounds(35, 200, 200, 14);
        contentPane.add(l3);

        t3 = new JTextField();
        t3.setBounds(250, 200, 150, 20);
        t3.setEditable(false);
        contentPane.add(t3);

        JLabel l4 = new JLabel("Mobile Number:");
        l4.setBounds(35, 240, 200, 14);
        contentPane.add(l4);

        t4 = new JTextField();
        t4.setBounds(250, 240, 150, 20);
        t4.setEditable(false);
        contentPane.add(t4);

        JLabel l5 = new JLabel("Room Price:");
        l5.setBounds(35, 280, 200, 14);
        contentPane.add(l5);

        t5 = new JTextField();
        t5.setBounds(250, 280, 150, 20);
        t5.setEditable(false);
        contentPane.add(t5);

        JLabel l6 = new JLabel("Number of Days:");
        l6.setBounds(35, 320, 200, 14);
        contentPane.add(l6);

        t6 = new JTextField();
        t6.setBounds(250, 320, 150, 20);
        t6.setEditable(false);
        contentPane.add(t6);

        JLabel l7 = new JLabel("Total Amount:");
        l7.setBounds(35, 360, 200, 14);
        contentPane.add(l7);

        t7 = new JTextField();
        t7.setBounds(250, 360, 150, 20);
        t7.setEditable(false);
        contentPane.add(t7);

        JLabel l8 = new JLabel("Email:");
        l8.setBounds(35, 400, 200, 14);
        contentPane.add(l8);

        t8 = new JTextField();
        t8.setBounds(250, 400, 150, 20);
        t8.setEditable(false);
        contentPane.add(t8);

        JButton cout = new JButton("Check-out");
        cout.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    String id = t0.getText();
                    String d1 = t3.getText();
                    // Get DAOs for dual mode
                    java.sql.Connection conn = null;
                    if (HMS.dbMode == DatabaseMode.MYSQL) {
                        try {
                            conn = java.sql.DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel_db", "root", "password");
                        } catch (Exception ex) {
                            HMS.dbMode = DatabaseMode.MEMORY;
                        }
                    }
                    CustomerFullDAO customerFullDAO = DAOFactory.getCustomerFullDAO(HMS.dbMode, conn);
                    RoomDAO roomDAO = HMS.dbMode == DatabaseMode.MYSQL && conn != null ? new hms.dao.RoomDAOMySQLImpl(conn) : new hms.dao.RoomDAOMemoryImpl();
                    // Update customer status and room status
                    java.util.List<CustomerFull> customers = customerFullDAO.getAllCustomerFull();
                    for (CustomerFull c : customers) {
                        if (c.roomNumber.equals(id) && "check in".equalsIgnoreCase(c.status)) {
                            c.status = "check out";
                            c.checkOutDate = d1;
                        }
                    }
                    // Update room status to empty
                    java.util.List<Room> rooms = roomDAO.getAllRooms();
                    for (Room r : rooms) {
                        if (String.valueOf(r.getId()).equals(id)) {
                            r.setAvailable(true);
                        }
                    }
                    JOptionPane.showMessageDialog(null, "Check-out Successful");

                    // Clear all fields
                    t0.setText("");
                    t1.setText("");
                    t2.setText("");
                    t3.setText("");
                    t4.setText("");
                    t5.setText("");
                    t6.setText("");
                    t7.setText("");
                    t8.setText("");

                } catch(Exception ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Error during checkout: " + ex.getMessage());
                }
            }
        });
        cout.setBounds(270, 450, 120, 30);
        cout.setBackground(Color.BLACK);
        cout.setForeground(Color.WHITE);
        contentPane.add(cout);

        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
    }
}