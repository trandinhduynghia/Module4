package com.example.casestudy.service;

import com.example.casestudy.model.CustomerType;
import com.example.casestudy.repository.ICustomerTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerTypeService implements ICustomerTypeService{
    @Autowired
    ICustomerTypeRepository customerTypeRepository;

    @Override
    public void add(CustomerType customerType) {
        customerTypeRepository.save(customerType);
    }

    @Override
    public void delete(Integer id) {
        customerTypeRepository.deleteById(id);
    }

    @Override
    public void update(CustomerType customerType) {
        customerTypeRepository.save(customerType);

    }

    @Override
    public Iterable<CustomerType> findAll() {
        return customerTypeRepository.findAll();
    }

    @Override
    public Optional<CustomerType> findById(Integer id) {
        return customerTypeRepository.findById(id);
    }
}
