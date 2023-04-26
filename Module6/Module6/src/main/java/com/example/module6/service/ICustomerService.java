package com.example.module6.service;

import com.example.module6.model.Customer;

import java.util.List;
import java.util.Optional;

public interface ICustomerService {
    List<Customer> findAll();
    void save(Customer customer);
    void remove(Customer customer);
    Optional<Customer> findById(Integer id);
}
