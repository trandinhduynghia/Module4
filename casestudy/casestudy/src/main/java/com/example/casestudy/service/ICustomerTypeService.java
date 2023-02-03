package com.example.casestudy.service;

import com.example.casestudy.model.Customer;
import com.example.casestudy.model.CustomerType;

import java.util.Optional;

public interface ICustomerTypeService {
    void add(CustomerType customerType);
    void delete(Integer id);
    void update(CustomerType customerType);

    Iterable<CustomerType> findAll();
    Optional<CustomerType> findById(Integer id);
}
