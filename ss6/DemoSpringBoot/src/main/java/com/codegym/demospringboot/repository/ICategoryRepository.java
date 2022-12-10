package com.codegym.demospringboot.repository;

import com.codegym.demospringboot.bean.Category;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ICategoryRepository extends PagingAndSortingRepository<Category, Long> {
}
