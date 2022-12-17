package com.codegym.demospringboot.repository;

import com.codegym.demospringboot.bean.Blog;
import com.codegym.demospringboot.bean.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProductRepository extends JpaRepository<Product, Integer> {
    List<Product> findByName(String name);
    Page<Product> findAllByName(String name, Pageable pageable);
}
