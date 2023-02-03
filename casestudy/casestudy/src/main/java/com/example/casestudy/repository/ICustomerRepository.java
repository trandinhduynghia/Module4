package com.example.casestudy.repository;

import com.example.casestudy.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICustomerRepository extends PagingAndSortingRepository<Customer, Integer> {
    Page<Customer> findAllByNameContaining(String name, Pageable pageable);
    Page<Customer> findAllByNameAndAddressAndCustomerTypeContaining(String name, String address, String customerType, Pageable pageable);

    @Query(value = "select * from customer where name like ? and address like ? and customer_type like ?", nativeQuery = true)
    Page<Customer> searchCustomer(String name, String address, String customerType, Pageable pageable);
}
