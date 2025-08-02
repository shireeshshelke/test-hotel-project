package hms.ui;

import hms.HMS;
import hms.model.Customer;
import hms.ui.DataChangeNotifier;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewCustomer extends JFrame {
    private JPanel contentPane;
    private JTextField tName, tCountry, tMobile, tEmail;

    public NewCustomer() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(270, 125, 500, 400);
        contentPane = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // Background image
                ImageIcon icon = new ImageIcon(getClass().getResource("/hms/ui/bg-hotel.jpg"));
                g.drawImage(icon.getImage(), 0, 0, getWidth(), getHeight(), this);
            }
        };
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblTitle = new JLabel("New Customer Entry");
        lblTitle.setFont(new Font("Arial", Font.BOLD, 22));
        lblTitle.setBounds(120, 20, 300, 30);
        lblTitle.setForeground(new Color(25, 25, 112));
        contentPane.add(lblTitle);

        JLabel lblName = new JLabel("Name:");
        lblName.setBounds(50, 80, 100, 20);
        contentPane.add(lblName);
        tName = new JTextField();
        tName.setBounds(180, 80, 200, 25);
        contentPane.add(tName);

        JLabel lblCountry = new JLabel("Country:");
        lblCountry.setBounds(50, 120, 100, 20);
        contentPane.add(lblCountry);
        tCountry = new JTextField();
        tCountry.setBounds(180, 120, 200, 25);
        contentPane.add(tCountry);

        JLabel lblMobile = new JLabel("Mobile:");
        lblMobile.setBounds(50, 160, 100, 20);
        contentPane.add(lblMobile);
        tMobile = new JTextField();
        tMobile.setBounds(180, 160, 200, 25);
        contentPane.add(tMobile);

        JLabel lblEmail = new JLabel("Email:");
        lblEmail.setBounds(50, 200, 100, 20);
        contentPane.add(lblEmail);
        tEmail = new JTextField();
        tEmail.setBounds(180, 200, 200, 25);
        contentPane.add(tEmail);

        JButton btnAdd = new JButton("Add Customer");
        btnAdd.setBounds(100, 260, 140, 35);
        btnAdd.setBackground(new Color(0, 102, 204));
        btnAdd.setForeground(Color.WHITE);
        btnAdd.setFont(new Font("Arial", Font.BOLD, 14));
        btnAdd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = tName.getText();
                String country = tCountry.getText();
                String mobile = tMobile.getText();
                String email = tEmail.getText();
                if (name.isEmpty() || country.isEmpty() || mobile.isEmpty() || email.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "All fields are required.");
                    return;
                }
                Customer customer = new Customer(0, name, email, mobile); // ID will be set by DAO
                HMS.customerDAO.addCustomer(customer);
                DataChangeNotifier.notifyDataChanged();
                JOptionPane.showMessageDialog(null, "Customer added successfully!");
                setVisible(false);
            }
        });
        contentPane.add(btnAdd);

        JButton btnExit = new JButton("Exit");
        btnExit.setBounds(260, 260, 100, 35);
        btnExit.setBackground(new Color(153, 0, 0));
        btnExit.setForeground(Color.WHITE);
        btnExit.setFont(new Font("Arial", Font.BOLD, 14));
        btnExit.addActionListener(e -> setVisible(false));
        contentPane.add(btnExit);
    }
}
