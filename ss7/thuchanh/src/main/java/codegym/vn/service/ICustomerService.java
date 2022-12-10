package codegym.vn.service;

import codegym.vn.bean.Customer;
import codegym.vn.bean.Province;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ICustomerService {
    Iterable<Customer> findAll();

    Page<Customer> findAll(Pageable pageable);

    Page<Customer> findAllByFirstNameContaining(String firstname, Pageable pageable);

    Customer findById(Long id);

    void save(Customer customer);

    void remove(Long id);

    Iterable<Customer> findAllByProvince(Province province);
}
