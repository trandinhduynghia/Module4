package com.codegym.demospringboot.service;

import com.codegym.demospringboot.bean.ProductType;

import java.util.List;

public interface IProductTypeService {
    List<ProductType> findAll();
    ProductType findById(Integer id);
}
