package service;

import model.Customer;

import java.util.Collection;
import java.util.HashSet;

public class CustomerService {

    public static  final Collection<Customer> customerCollection = new HashSet<Customer>();
    private static CustomerService customerService;

    public CustomerService() {
    }


    public static CustomerService getInstance() {
        if (null == customerService) {
            customerService = new CustomerService();
        }
        return customerService;
    }

    public void addCustomer(String firstName, String lastName, String email) {
        Customer newCustomer = new Customer( firstName, lastName, email);
        customerCollection.add(newCustomer);

    }


    public Customer getCustomer(String customerEmail) {
        for (Customer customer : customerCollection) {
            if (customer.getEmail().equals(customerEmail)) {
                return customer;
            }
        }
      //  System.out.println("Customer not found. Please create account");
        return null;
    }


    public Collection<Customer> getAllCustomers() {
        for (Customer customer: customerCollection){
            System.out.println(customer);
        }
        return customerCollection;

    }

    @Override
    public String toString() {
        return "CustomerService{" +
                "customerCollection=" + customerCollection +
                '}';
    }
}


