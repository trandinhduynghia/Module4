package com.codegym.demospringboot.service;

import com.codegym.demospringboot.bean.ProductType;
import com.codegym.demospringboot.repository.IProductTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductTypeService implements IProductTypeService{
    @Autowired
    IProductTypeRepository productTypeRepository;
    @Override
    public List<ProductType> findAll() {
        return productTypeRepository.findAll();
    }

    @Override
    public ProductType findById(Integer id) {
        return productTypeRepository.findById(id).orElse(null);
    }
}
