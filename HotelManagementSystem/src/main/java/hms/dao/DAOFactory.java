
package hms.dao;

import hms.model.Customer;
import hms.model.User;
import hms.model.CustomerFull;
import java.sql.Connection;
import hms.DatabaseMode;
public class DAOFactory {
    public static CustomerDAO getCustomerDAO(DatabaseMode mode, Connection conn) {
        if (DatabaseMode.MYSQL == mode && conn != null) {
            return new CustomerDAOMySQLImpl(conn);
        } else {
            return new CustomerDAOMemoryImpl();
        }
    }

    public static UserDAO getUserDAO(DatabaseMode mode, Connection conn) {
        if (DatabaseMode.MYSQL == mode && conn != null) {
            return new UserDAOMySQLImpl(conn);
        } else {
            return new UserDAOMemoryImpl();
        }
    }

    public static CustomerFullDAO getCustomerFullDAO(DatabaseMode mode, Connection conn) {
        if (DatabaseMode.MYSQL == mode && conn != null) {
            return new CustomerFullDAOMySQLImpl(conn);
        } else {
            return new CustomerFullDAOMemoryImpl();
        }
    }
}
