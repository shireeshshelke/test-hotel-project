package hms.dao;

import hms.model.Customer;
import java.util.*;

public class CustomerDAOMemoryImpl implements CustomerDAO {
    private final List<Customer> customers = new ArrayList<>();

    public CustomerDAOMemoryImpl() {
        // Stub data
        customers.add(new Customer(1, "Alice Smith", "alice@example.com", "1234567890"));
        customers.add(new Customer(2, "Bob Johnson", "bob@example.com", "0987654321"));
    }

    @Override
    public List<Customer> getAllCustomers() {
        return new ArrayList<>(customers);
    }

    @Override
    public Customer getCustomerById(int id) {
        return customers.stream().filter(c -> c.getId() == id).findFirst().orElse(null);
    }

    @Override
    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    @Override
    public void updateCustomer(Customer customer) {
        for (int i = 0; i < customers.size(); i++) {
            if (customers.get(i).getId() == customer.getId()) {
                customers.set(i, customer);
                return;
            }
        }
    }

    @Override
    public void deleteCustomer(int id) {
        customers.removeIf(c -> c.getId() == id);
    }
}
