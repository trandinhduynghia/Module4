package codegym.vn.service;

import codegym.vn.bean.Customer;

import codegym.vn.respository.ICustomerRespository;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.*;

//@Service
public class CustomerService implements ICustomerService{
    @Autowired
    private ICustomerRespository customerRespository;

    @Override
    public List<Customer> findAll() {
        return customerRespository.findAll();
    }

    @Override
    public Customer findById(Long id) {
        return customerRespository.findById(id);
    }

    @Override
    public void save(Customer customer) {
        customerRespository.save(customer);

    }

    @Override
    public void remove(Long id) {
        customerRespository.remove(id);

    }
}
