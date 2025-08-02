
package hms.dao;

import hms.model.Customer;
import hms.model.User;
import hms.model.CustomerFull;
import java.sql.Connection;
import hms.DatabaseMode;
public class DAOFactory {
    private static Connection getConnection(Connection conn){
        if (conn == null) {
        try {
            conn = java.sql.DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel_db", "root", "password");
        } catch (Exception ex) {
            throw new RuntimeException("Failed to create a new database connection", ex);
        }
    }
    return conn;
    }
    
    public static CustomerDAO getCustomerDAO(DatabaseMode mode, Connection conn) {
        if (DatabaseMode.MYSQL == mode) {
            return new CustomerDAOMySQLImpl(getConnection(conn));
        } else {
            return new CustomerDAOMemoryImpl();
        }
    }

    public static UserDAO getUserDAO(DatabaseMode mode, Connection conn) {
        if (DatabaseMode.MYSQL == mode) {
            return new UserDAOMySQLImpl(getConnection(conn));
        } else {
            return new UserDAOMemoryImpl();
        }
    }

    public static CustomerFullDAO getCustomerFullDAO(DatabaseMode mode, Connection conn) {
        if (DatabaseMode.MYSQL == mode) {
            return new CustomerFullDAOMySQLImpl(getConnection(conn));
        } else {
            return new CustomerFullDAOMemoryImpl();
        }
    }
}
