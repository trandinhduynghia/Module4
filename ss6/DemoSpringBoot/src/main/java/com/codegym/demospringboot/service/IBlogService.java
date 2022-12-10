package com.codegym.demospringboot.service;

import com.codegym.demospringboot.bean.Blog;
import com.codegym.demospringboot.bean.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface IBlogService {
    Iterable<Blog> findAll();

    Page<Blog> findAll(Pageable pageable);

    Page<Blog> findAllByNameBlogContaining(String nameBlog, Pageable pageable);

    Optional<Blog> findById(Long id);

    void save(Blog blog);

    void remove(Long id);

    Iterable<Blog> findAllByCategory(Optional<Category> category);
}
