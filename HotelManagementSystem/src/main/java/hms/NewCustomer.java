package hms;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class NewCustomer extends JFrame {
    private JPanel contentPane;
    private JTextField t1, t2, t3, t4, t5, t6, t7, t02, t03;
    private Choice c1, comboBox1;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    NewCustomer frame = new NewCustomer();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public NewCustomer() throws SQLException {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(270, 125, 850, 550);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        contentPane.setVisible(true);

        JLabel lblName = new JLabel("New Customer Entry");
        lblName.setFont(new Font("Yu Mincho", Font.BOLD, 20));
        lblName.setBounds(118, 11, 260, 53);
        contentPane.add(lblName);
        lblName.setVisible(true);

        JLabel l3 = new JLabel("ID :");
        l3.setBounds(35, 76, 200, 14);
        contentPane.add(l3);
        l3.setVisible(true);

        comboBox1 = new Choice();
        comboBox1.add("Passport");
        comboBox1.add("Aadhar Card");
        comboBox1.add("Voter Id");
        comboBox1.add("Driving license");
        comboBox1.setBounds(271, 73, 150, 20);
        contentPane.add(comboBox1);
        comboBox1.setVisible(true);

        JLabel lblId = new JLabel("Number :");
        lblId.setBounds(35, 111, 200, 14);
        contentPane.add(lblId);
        lblId.setVisible(true);

        t1 = new JTextField();
        t1.setBounds(271, 111, 150, 20);
        contentPane.add(t1);
        t1.setColumns(10);
        t1.setVisible(true);

        JLabel lblName_1 = new JLabel("Name :");
        lblName_1.setBounds(35, 151, 200, 14);
        contentPane.add(lblName_1);
        lblName_1.setVisible(true);

        t2 = new JTextField();
        t2.setBounds(271, 151, 150, 20);
        contentPane.add(t2);
        t2.setColumns(10);
        t2.setVisible(true);

        JLabel lblGender = new JLabel("Gender :");
        lblGender.setBounds(35, 191, 200, 14);
        contentPane.add(lblGender);
        lblGender.setVisible(true);

        JRadioButton r1 = new JRadioButton("Male");
        r1.setFont(new Font("Raleway", Font.BOLD, 14));
        r1.setBackground(Color.WHITE);
        r1.setBounds(271, 191, 80, 12);
        contentPane.add(r1);
        r1.setVisible(true);

        JRadioButton r2 = new JRadioButton("Female");
        r2.setFont(new Font("Raleway", Font.BOLD, 14));
        r2.setBackground(Color.WHITE);
        r2.setBounds(350, 191, 100, 12);
        contentPane.add(r2);
        r2.setVisible(true);

        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(r1);
        genderGroup.add(r2);

        JLabel lblCountry = new JLabel("Country :");
        lblCountry.setBounds(35, 231, 200, 14);
        contentPane.add(lblCountry);
        lblCountry.setVisible(true);

        t3 = new JTextField();
        t3.setBounds(271, 231, 150, 20);
        contentPane.add(t3);
        t3.setColumns(10);
        t3.setVisible(true);

        JLabel lblReserveRoomNumber = new JLabel("Allocated Room Number :");
        lblReserveRoomNumber.setBounds(35, 274, 200, 14);
        contentPane.add(lblReserveRoomNumber);
        lblReserveRoomNumber.setVisible(true);

        c1 = new Choice();
        try{
            conn c = new conn();
            ResultSet rs = c.s.executeQuery("select * from room where status = 'empty'");
            while(rs.next()){
            c1.add(rs.getString("room_number"));
            }
        }catch(Exception e){ }
        c1.setBounds(271, 274, 150, 20);
        contentPane.add(c1);
        c1.setVisible(true);

        JLabel lblCheckInDate = new JLabel("Check-in-Date :");
        lblCheckInDate.setBounds(35, 316, 200, 14);
        contentPane.add(lblCheckInDate);
        lblCheckInDate.setVisible(true);

        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Calendar cal = Calendar.getInstance();
        JLabel l = new JLabel("" + dateFormat.format(cal.getTime()));
        l.setBounds(271, 316, 200, 14);
        contentPane.add(l);
        l.setVisible(true);

        JLabel lblMobileNumber = new JLabel("Mobile Number :");
        lblMobileNumber.setBounds(35, 356, 200, 14);
        contentPane.add(lblMobileNumber);
        lblMobileNumber.setVisible(true);

        t4 = new JTextField();
        t4.setBounds(271, 356, 150, 20);
        contentPane.add(t4);
        t4.setColumns(10);
        t4.setVisible(true);

        JLabel email = new JLabel("E-mail ID :");
        email.setBounds(35, 396, 200, 14);
        contentPane.add(email);
        email.setVisible(true);

        t7 = new JTextField();
        t7.setBounds(271, 396, 150, 20);
        contentPane.add(t7);
        t7.setColumns(10);
        t7.setVisible(true);

        JLabel lblRoomType = new JLabel("Room Type :");
        lblRoomType.setBounds(450, 274, 100, 14);
        contentPane.add(lblRoomType);
        lblRoomType.setVisible(true);

        t02 = new JTextField();
        t02.setBounds(550, 274, 150, 20);
        contentPane.add(t02);
        t02.setVisible(true);

        JLabel lblBedType = new JLabel("Bed Type :");
        lblBedType.setBounds(450, 316, 100, 14);
        contentPane.add(lblBedType);
        lblBedType.setVisible(true);

        t03 = new JTextField();
        t03.setBounds(550, 316, 150, 20);
        contentPane.add(t03);
        t03.setVisible(true);

        JLabel lblPrice = new JLabel("Price :");
        lblPrice.setBounds(450, 356, 100, 14);
        contentPane.add(lblPrice);
        lblPrice.setVisible(true);

        t6 = new JTextField();
        t6.setBounds(550, 356, 150, 20);
        contentPane.add(t6);
        t6.setVisible(true);

        c1.addItemListener(e -> {
            try {
            conn c = new conn();
            String str = "select * from room where room_number = " + c1.getSelectedItem();
            ResultSet rs = c.s.executeQuery(str);
            while(rs.next()) {
                t02.setText(rs.getString("rtype"));
                t03.setText(rs.getString("bed_type"));
                t6.setText(rs.getString("price"));
            }
            } catch(Exception ex) {
            ex.printStackTrace();
            }
        });

        JButton btnNewButton = new JButton("Add");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            try {
                conn c = new conn();
                String id = (String) comboBox1.getSelectedItem();
                String idno = t1.getText();
                String name = t2.getText();
                String gen = r1.isSelected() ? "Male" : "Female";
                String cont = t3.getText();
                String rno = c1.getSelectedItem();
                String rprice = t6.getText();
                String mob = t4.getText();
                String mail = t7.getText();
                String date = l.getText();
                String check = "check in";
                String dateout = "0";

                String q1 = "insert into customer values('" + id + "','" + idno + "','" + name + 
                       "','" + gen + "','" + cont + "','" + rno + "','" + rprice + "','" + 
                       mob + "','" + mail + "','" + date + "','" + dateout + "','" + check + "')";
                c.s.executeUpdate(q1);

                String q2 = "update room set status = 'booked' where room_number = " + rno;
                c.s.executeUpdate(q2);

                JOptionPane.showMessageDialog(null, "Check-in Successful");
                setVisible(false);
            } catch (SQLException e1) {
                System.out.println(e1.getMessage());
            } catch (NumberFormatException s) {
                JOptionPane.showMessageDialog(null, "Please enter a valid Number");
            }
            }
        });
        btnNewButton.setBounds(140, 430, 120, 30);
        btnNewButton.setBackground(Color.BLACK);
        btnNewButton.setForeground(Color.WHITE);
        contentPane.add(btnNewButton);
        btnNewButton.setVisible(true);

        JButton btnExit = new JButton("Exit");
        btnExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            setVisible(false);
            }
        });
        btnExit.setBounds(260, 430, 120, 30);
        btnExit.setBackground(Color.BLACK);
        btnExit.setForeground(Color.WHITE);
        contentPane.add(btnExit);
        btnExit.setVisible(true);

        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
    }
}