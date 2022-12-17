package com.codegym.demospringboot.repository;


import com.codegym.demospringboot.bean.ProductType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductTypeRepository extends JpaRepository<ProductType, Integer> {
}
