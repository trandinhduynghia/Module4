package com.codegym.demospringboot.repository;


import com.codegym.demospringboot.bean.ProductType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductTypeRepository extends JpaRepository<ProductType, Integer> {
}
