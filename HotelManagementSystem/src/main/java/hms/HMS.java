package hms;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import hms.dao.*;
import hms.model.*;
import hms.DatabaseMode;
import java.sql.Connection;
import java.sql.DriverManager;

public class HMS extends JFrame implements ActionListener{
    JButton b1, b2, b3, b4;
    public static DatabaseMode dbMode = DatabaseMode.MEMORY;
    public static CustomerDAO customerDAO;
    public static RoomDAO roomDAO;

    public void close() {
        WindowEvent winClose = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClose);
    }

    public HMS() {
        setSize(1366, 768);
        setLayout(null);
        setLocation(0, 0);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Enhanced visuals: add a background panel with gradient
        JPanel bgPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                Color color1 = new Color(135, 206, 250);
                Color color2 = new Color(255, 255, 255);
                int w = getWidth();
                int h = getHeight();
                GradientPaint gp = new GradientPaint(0, 0, color1, 0, h, color2);
                g2d.setPaint(gp);
                g2d.fillRect(0, 0, w, h);
            }
        };
        bgPanel.setLayout(null);
        setContentPane(bgPanel);

        JLabel title = new JLabel("Hotel Management System");
        title.setFont(new Font("Arial", Font.BOLD, 36));
        title.setBounds(400, 50, 600, 50);
        title.setForeground(new Color(25, 25, 112));
        bgPanel.add(title);

        b1 = new JButton("Login");
        b1.setBounds(300, 200, 200, 50);
        b1.setBackground(new Color(0, 51, 102));
        b1.setForeground(Color.WHITE);
        b1.setFont(new Font("Arial", Font.BOLD, 15));
        b1.setToolTipText("Login to your account");
        b1.addActionListener(this);
        bgPanel.add(b1);

        b2 = new JButton("Sign Up");
        b2.setBounds(550, 200, 200, 50);
        b2.setBackground(new Color(0, 102, 51));
        b2.setForeground(Color.WHITE);
        b2.setFont(new Font("Arial", Font.BOLD, 15));
        b2.setToolTipText("Create a new account");
        b2.addActionListener(this);
        bgPanel.add(b2);

        b3 = new JButton("Admin Panel");
        b3.setBounds(425, 300, 200, 50);
        b3.setBackground(new Color(102, 0, 51));
        b3.setForeground(Color.WHITE);
        b3.setFont(new Font("Arial", Font.BOLD, 15));
        b3.setToolTipText("Open admin panel");
        b3.addActionListener(this);
        bgPanel.add(b3);

        b4 = new JButton("Exit");
        b4.setBounds(425, 400, 200, 50);
        b4.setBackground(Color.RED);
        b4.setForeground(Color.WHITE);
        b4.setFont(new Font("Arial", Font.BOLD, 15));
        b4.setToolTipText("Exit the application");
        b4.addActionListener(this);
        bgPanel.add(b4);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == b1) {
            try {
                new Login().setVisible(true);
                setVisible(false);
            } catch(Exception e1) {
                e1.printStackTrace();
            }
        } else if(ae.getSource() == b2) {
            try {
                new signup().setVisible(true);
                setVisible(false);
            } catch(Exception e) {
                e.printStackTrace();
            }
        } else if(ae.getSource() == b3) {
            try {
                admin frame = new admin();
                frame.setVisible(true);
                setVisible(false);
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        } else if(ae.getSource() == b4) {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        // Parse command-line argument for db mode
        String mode = null;
        if (args != null && args.length > 0) {
            for (String arg : args) {
                if (arg.startsWith("--db=")) {
                    mode = arg.substring(5);
                }
            }
        }
        dbMode = DatabaseMode.fromString(mode);

        Connection conn = null;
        if (dbMode == DatabaseMode.MYSQL) {
            try {
                // Update with your DB credentials as needed
                conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/hotel_db", "root", "password");
            } catch (Exception e) {
                System.err.println("Failed to connect to MySQL, falling back to memory mode.");
                dbMode = DatabaseMode.MEMORY;
            }
        }
        customerDAO = DAOFactory.getCustomerDAO(dbMode, conn);
        roomDAO = dbMode == DatabaseMode.MYSQL && conn != null ? new RoomDAOMySQLImpl(conn) : new RoomDAOMemoryImpl();

        new HMS().setVisible(true);
    }
}