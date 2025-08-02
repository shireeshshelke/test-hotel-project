package hms;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class conn {
    Connection c;
    Statement s;
    PreparedStatement pst;

    public conn(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");  // Updated MySQL driver
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/hms","root","");
            s = c.createStatement();
        }catch(Exception e){ 
            System.out.println("Database connection error: " + e);
        }
    }
}