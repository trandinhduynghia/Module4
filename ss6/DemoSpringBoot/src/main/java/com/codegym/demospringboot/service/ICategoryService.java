package com.codegym.demospringboot.service;

import com.codegym.demospringboot.bean.Category;

public interface ICategoryService {
    Iterable<Category> findAll();

    java.util.Optional<Category> findById(Long id);

    void save(Category category);

    void remove(Long id);
}
