package hms;

import javax.swing.*;

import hms.dao.DAOFactory;
import hms.dao.UserDAO;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import hms.HMS;
import hms.dao.CustomerDAO;
import hms.model.Customer;
import hms.model.User;

public class Login extends JFrame implements ActionListener{
    JTextField t1;
    JPasswordField t2;
    JButton b1, b2;
    UserDAO userDAO;
    public Login(){
        setLayout(null);
        setSize(500,300);

        JPanel bgPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                Color color1 = new Color(255, 255, 255);
                Color color2 = new Color(135, 206, 250);
                int w = getWidth();
                int h = getHeight();
                GradientPaint gp = new GradientPaint(0, 0, color1, 0, h, color2);
                g2d.setPaint(gp);
                g2d.fillRect(0, 0, w, h);
            }
        };
        bgPanel.setLayout(null);
        setContentPane(bgPanel);

        JLabel l1 = new JLabel("Username");
        l1.setBounds(40,20,100,30);
        l1.setFont(new Font("Arial", Font.BOLD, 15));
        bgPanel.add(l1);

        JLabel l2 = new JLabel("Password");
        l2.setBounds(40,70,100,30);
        l2.setFont(new Font("Arial", Font.BOLD, 15));
        bgPanel.add(l2);

        t1 = new JTextField();
        t1.setBounds(150,20,200,30);
        t1.setFont(new Font("Arial", Font.PLAIN, 15));
        t1.setToolTipText("Enter your username");
        bgPanel.add(t1);

        t2 = new JPasswordField();
        t2.setBounds(150,70,200,30);
        t2.setFont(new Font("Arial", Font.PLAIN, 15));
        t2.setToolTipText("Enter your password");
        bgPanel.add(t2);

        b1 = new JButton("Login");
        b1.setBounds(60,140,150,40);
        b1.setBackground(new Color(0, 51, 102));
        b1.setForeground(Color.WHITE);
        b1.setFont(new Font("Arial", Font.BOLD, 15));
        b1.setToolTipText("Login to your account");
        b1.addActionListener(this);
        bgPanel.add(b1);

        b2 = new JButton("Cancel");
        b2.setBounds(230,140,150,40);
        b2.setBackground(Color.RED);
        b2.setForeground(Color.WHITE);
        b2.setFont(new Font("Arial", Font.BOLD, 15));
        b2.setToolTipText("Exit the application");
        b2.addActionListener(this);
        bgPanel.add(b2);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(400,200);
        setVisible(true);
    }

    public void close(){
        WindowEvent winClose = new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClose);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b1){
            try{
                if (userDAO == null) {
                    userDAO = DAOFactory.getUserDAO(HMS.dbMode, null); // Initialize userDAO if not already done
                }

                String u = t1.getText();
                String v = new String(t2.getPassword());
                // For demo, use customerDAO for authentication (stub or DB)
                boolean found = false;
                
                User user = userDAO.getUserByUsername(u);

                System.out.println("Attempting login for user: " + user.getUsername() + " with password: " + user.getPassword());
                if (user != null && user.getPassword().equals(v)) {
                    System.out.println("Valid user found: " + user.getUsername());
                    found = true; // Valid user found
                }

                if(found){
                    java.awt.Window win[] = java.awt.Window.getWindows();
                    for(int i=0; i<win.length; i++){
                        win[i].dispose();
                    }
                    try {
                        new hms.ui.Dashboard().setVisible(true);
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        JOptionPane.showMessageDialog(this, "Error opening Dashboard: " + ex.getMessage());
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Invalid login.");
                    t1.setText("");
                    t2.setText("");
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        } else if(ae.getSource()==b2){
            System.exit(0);
        }
    }

    public static void main(String[] arg){
        new Login();
    }
}