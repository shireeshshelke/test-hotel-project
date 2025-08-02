package hms;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import hms.dao.*;
import hms.model.User;

public class signup extends JFrame implements ActionListener {
    JLabel l1, l2, l3;
    JTextField t1, t2, t3;
    JButton b1;

    public static UserDAO userDAO;

    signup() {
        super("Signup");
        setLayout(null);

        l1 = new JLabel("Username");
        l1.setBounds(40, 20, 100, 30);
        add(l1);

        l2 = new JLabel("Password");
        l2.setBounds(40, 70, 100, 30);
        add(l2);

        l3 = new JLabel("Re-enter Password");
        l3.setBounds(40, 120, 150, 30);
        add(l3);

        t1 = new JTextField();
        t1.setBounds(200, 20, 150, 30);
        add(t1);

        t2 = new JPasswordField();
        t2.setBounds(200, 70, 150, 30);
        add(t2);

        t3 = new JPasswordField();
        t3.setBounds(200, 120, 150, 30);
        add(t3);

        b1 = new JButton("Signup");
        b1.setBounds(40, 200, 120, 30);
        b1.addActionListener(this);
        add(b1);

        getContentPane().setBackground(Color.WHITE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setSize(600, 300);
        setLocation(400, 200);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == b1){
            String user, password, password2;
            user = t1.getText();
            password = t2.getText();
            password2 = t3.getText();

            if(password2.equals(password)) {
                try {
                    if (userDAO == null) {
                        // Initialize DAO based on HMS.dbMode
                        java.sql.Connection conn = null;
                        if (HMS.dbMode == hms.DatabaseMode.MYSQL) {
                            try {
                                conn = java.sql.DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel_db", "root", "password");
                            } catch (Exception ex) {
                                HMS.dbMode = hms.DatabaseMode.MEMORY;
                            }
                        }
                        userDAO = DAOFactory.getUserDAO(HMS.dbMode, conn);
                    }
                    userDAO.addUser(new User(user, password));
                    JOptionPane.showMessageDialog(null, "Signup done successfully!");
                    t1.setText("");
                    t2.setText("");
                    t3.setText("");
                    t1.requestFocus();
                    setVisible(false);
                    new Login();
                } catch (Exception e1) {
                    JOptionPane.showMessageDialog(null, e1.getMessage());
                    e1.printStackTrace();
                }
            } else {
                JOptionPane.showMessageDialog(null, "Passwords do not match!");
            }
        }
    }

    public static void main (String[]arg) {
        new signup();
    }
}