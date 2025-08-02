package hms.ui;

import hms.HMS;
import javax.swing.*;
import java.awt.*;

public class Dashboard extends JFrame {
    public Dashboard() {
        super("Hotel Management System - Dashboard");
        setLayout(null);

        JPanel bgPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // Background image
                ImageIcon icon = new ImageIcon(getClass().getResource("/hms/ui/bg-hotel.jpg"));
                g.drawImage(icon.getImage(), 0, 0, getWidth(), getHeight(), this);
            }
        };
        bgPanel.setLayout(null);
        setContentPane(bgPanel);

        JLabel welcome = new JLabel("Welcome to Hotel Management System");
        welcome.setFont(new Font("Arial", Font.BOLD, 28));
        welcome.setBounds(350, 50, 600, 50);
        welcome.setForeground(new Color(25, 25, 112));
        bgPanel.add(welcome);

        JButton btnNewButton_1 = new JButton("New Customer Entry");
        btnNewButton_1.setBounds(100, 200, 250, 60);
        btnNewButton_1.setBackground(new Color(0, 102, 204));
        btnNewButton_1.setForeground(Color.WHITE);
        btnNewButton_1.setFont(new Font("Arial", Font.BOLD, 18));
        btnNewButton_1.setToolTipText("Add a new customer");
        btnNewButton_1.addActionListener(e -> {
            new NewCustomer().setVisible(true);
        });
        bgPanel.add(btnNewButton_1);

        JButton btnNewButton_2 = new JButton("Check-out");
        btnNewButton_2.setBounds(400, 200, 250, 60);
        btnNewButton_2.setBackground(new Color(0, 153, 76));
        btnNewButton_2.setForeground(Color.WHITE);
        btnNewButton_2.setFont(new Font("Arial", Font.BOLD, 18));
        btnNewButton_2.setToolTipText("Check out a customer");
        btnNewButton_2.addActionListener(e -> {
            // TODO: Update to use new Checkout UI if refactored
            try {
                new hms.Checkout().setVisible(true);
            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error opening Checkout: " + ex.getMessage());
            }
        });
        bgPanel.add(btnNewButton_2);

        JButton btnNewButton_3 = new JButton("All Customer Info");
        btnNewButton_3.setBounds(700, 200, 250, 60);
        btnNewButton_3.setBackground(new Color(153, 0, 76));
        btnNewButton_3.setForeground(Color.WHITE);
        btnNewButton_3.setFont(new Font("Arial", Font.BOLD, 18));
        btnNewButton_3.setToolTipText("View all customers");
        btnNewButton_3.addActionListener(e -> {
            try {
                new Bills().setVisible(true);
            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error opening Customer Info: " + ex.getMessage());
            }
        });
        bgPanel.add(btnNewButton_3);

        JButton btnNewButton_5 = new JButton("Exit");
        btnNewButton_5.setBounds(1100, 20, 150, 50);
        btnNewButton_5.setBackground(Color.RED);
        btnNewButton_5.setForeground(Color.WHITE);
        btnNewButton_5.setFont(new Font("Arial", Font.BOLD, 16));
        btnNewButton_5.setToolTipText("Exit the application");
        btnNewButton_5.addActionListener(e -> System.exit(0));
        bgPanel.add(btnNewButton_5);

        JButton logout = new JButton("Logout");
        logout.setBounds(900, 20, 150, 50);
        logout.setBackground(new Color(255, 140, 0));
        logout.setForeground(Color.WHITE);
        logout.setFont(new Font("Arial", Font.BOLD, 16));
        logout.setToolTipText("Logout and return to login");
        logout.addActionListener(e -> {
            java.awt.Window win[] = java.awt.Window.getWindows();
            for(int i1=0; i1<win.length; i1++) {
                win[i1].dispose();
            }
            new hms.Login().setVisible(true);
        });
        bgPanel.add(logout);

        setSize(1366,768);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Dashboard().setVisible(true);
    }
}
