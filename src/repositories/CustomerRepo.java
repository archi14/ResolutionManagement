package repositories;

import models.Customer;

import java.util.HashMap;
import java.util.Map;

public class CustomerRepo {
    Map<String, Customer> customers;

    public CustomerRepo() {
        customers = new HashMap<>();
    }

    public void addCustomer(Customer customer) {
        customers.put(customer.getId(), customer);
    }

    public Customer getCustomer(String id) {
        return customers.get(id);
    }

    public void removeCustomer(String id) {
        customers.remove(id);
    }

}
