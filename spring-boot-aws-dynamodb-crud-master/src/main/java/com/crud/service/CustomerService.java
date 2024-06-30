package com.crud.service;

import com.amazonaws.services.dynamodbv2.model.ResourceNotFoundException;
import com.crud.entity.Customer;
import com.crud.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public Customer getCustomerById(String customerId) {
        return customerRepository.findById(customerId)
                .orElseThrow(() -> new ResourceNotFoundException("Customer not found with id: " + customerId));
    }

    public void deleteCustomerById(String customerId) {
        Customer customer = getCustomerById(customerId);
        customerRepository.delete(customer);
    }

    public Customer updateCustomer(String customerId, Customer customer) {
        Customer existingCustomer = getCustomerById(customerId);
        // Assuming you have setters in Customer to update fields
        existingCustomer.setName(customer.getName());
        existingCustomer.setEmail(customer.getEmail());
        // other fields
        return customerRepository.save(existingCustomer);
    }
}
