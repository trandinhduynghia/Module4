package com.example.casestudy.service;

import com.example.casestudy.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ICustomerService {
    void add(Customer customer);
    void delete(Integer id);
    void update(Customer customer);

    Page<Customer> findAll(Pageable pageable);
    Optional <Customer> findById(Integer id);
    Page<Customer> findAllByNameContaining(String name, Pageable pageable);
    Page<Customer> findAllByNameAndAddressAndCustomerTypeContaining(String name, String address, String customerType, Pageable pageable);
    Page<Customer> searchCustomer(Pageable pageable, String name, String address, String customerType );
}
