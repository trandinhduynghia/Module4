package com.example.casestudy.repository;

import com.example.casestudy.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer, Integer> {
    Page<Customer> findAllByNameContaining(String name, Pageable pageable);

    Page<Customer> findAllByNameAndAddressAndCustomerTypeContaining(String name, String address, String customerType, Pageable pageable);

//    @Query(value = "select * from customer where name like ? and address like ? and customer_type like ?", nativeQuery = true)
//    Page<Customer> searchCustomer(String name, String address, String customerType, Pageable pageable);

    @Query(value = "select * from customer where name like :name and address like :address and customer_type like :customerType",
            nativeQuery = true,
            countQuery = "select * from customer where name like :name and address like :address and customer_type like :customerType")
    Page<Customer> searchCustomer(@Param("name") String name,@Param("address") String address, @Param("customerType") String customerType, Pageable pageable);
}
