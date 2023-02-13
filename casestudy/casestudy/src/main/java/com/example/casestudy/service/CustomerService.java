package com.example.casestudy.service;

import com.example.casestudy.model.Customer;
import com.example.casestudy.repository.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService implements ICustomerService{
    @Autowired
    ICustomerRepository customerRepository;

    @Override
    public void add(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public void delete(Integer id) {
        customerRepository.deleteById(id);

    }

    @Override
    public void update(Customer customer) {
        customerRepository.save(customer);

    }

    @Override
    public Page<Customer> findAll(Pageable pageable) {
        return customerRepository.findAll(pageable);
    }

    @Override
    public Optional<Customer> findById(Integer id) {
        return customerRepository.findById(id);
    }

    @Override
    public Page<Customer> findAllByNameContaining(String name, Pageable pageable) {
        return customerRepository.findAllByNameContaining(name, pageable);
    }

    @Override
    public Page<Customer> findAllByNameAndAddressAndCustomerTypeContaining(String name, String address, String customerType, Pageable pageable) {
        return customerRepository.findAllByNameAndAddressAndCustomerTypeContaining(name, address, customerType, pageable);
    }

//    @Override
//    public Page<Customer> searchCustomer(String name, String address, String customerType, Pageable pageable) {
//
//        return customerRepository.searchCustomer(name, address,customerType,pageable);
//    }

    @Override
    public Page<Customer> searchCustomer(String name, String address, String customerType, Pageable pageable) {

        return customerRepository.searchCustomer("%"+name+"%", "%"+address+"%", "%"+customerType+"%", pageable);
    }


}
