package hms.dao;

import hms.model.CustomerFull;
import java.sql.*;
import java.util.*;

public class CustomerFullDAOMySQLImpl implements CustomerFullDAO {
    private final Connection conn;

    public CustomerFullDAOMySQLImpl(Connection conn) {
        this.conn = conn;
    }

    @Override
    public List<CustomerFull> getAllCustomerFull() {
        List<CustomerFull> customers = new ArrayList<>();
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM customer")) {
            while (rs.next()) {
                customers.add(new CustomerFull(
                    rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
                    rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8),
                    rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12)
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customers;
    }
}
