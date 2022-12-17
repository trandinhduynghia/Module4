package com.codegym.demospringboot.service;

import com.codegym.demospringboot.bean.Blog;
import com.codegym.demospringboot.bean.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IProductService {
    void addProduct(Product product);
    void delete(Integer id);
    void update(Product product);
    List<Product> findAll();
    Product findById(Integer id);
    List<Product> findByName(String name);
    Page<Product> findAllByName(String name, Pageable pageable);
    Page<Product> findAll(Pageable pageable);
}
