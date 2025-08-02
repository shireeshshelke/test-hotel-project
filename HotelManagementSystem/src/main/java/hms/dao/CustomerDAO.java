package hms.dao;

import java.util.List;
import hms.model.Customer;

public interface CustomerDAO {
    List<Customer> getAllCustomers();
    Customer getCustomerById(int id);
    void addCustomer(Customer customer);
    void updateCustomer(Customer customer);
    void deleteCustomer(int id);
}
