package com.crud.repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBSaveExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ExpectedAttributeValue;
import com.crud.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class CustomerRepository {

    @Autowired
    private DynamoDBMapper dynamoDBMapper;

    public Customer save(Customer customer) {
        dynamoDBMapper.save(customer);
        return customer;
    }

    public Optional<Customer> findById(String customerId) {
        Customer customer = dynamoDBMapper.load(Customer.class, customerId);
        return Optional.ofNullable(customer);
    }

    public void delete(Customer customer) {
        dynamoDBMapper.delete(customer);
    }
}
