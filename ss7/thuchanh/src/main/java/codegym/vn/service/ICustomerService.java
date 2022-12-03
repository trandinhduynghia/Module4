package codegym.vn.service;

import codegym.vn.bean.Customer;

import java.util.List;
import java.util.Optional;

public interface ICustomerService {
    Iterable<Customer> findAll();

    Customer findById(Long id);

    void save(Customer customer);

    void remove(Long id);
}
