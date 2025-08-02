package hms.dao;

import hms.model.CustomerFull;
import java.util.*;

public class CustomerFullDAOMemoryImpl implements CustomerFullDAO {
    private final List<CustomerFull> customers = new ArrayList<>();

    public CustomerFullDAOMemoryImpl() {
        customers.add(new CustomerFull("Passport", "A12345", "Alice Smith", "Female", "USA", "101", "1000", "1234567890", "alice@example.com", "2025/08/01 12:00:00", "0", "check in"));
        customers.add(new CustomerFull("Aadhar Card", "B67890", "Bob Johnson", "Male", "India", "102", "1200", "0987654321", "bob@example.com", "2025/08/01 13:00:00", "0", "check in"));
    }

    @Override
    public List<CustomerFull> getAllCustomerFull() {
        return new ArrayList<>(customers);
    }
}
