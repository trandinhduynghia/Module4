package com.codegym.demospringboot.repository;

import com.codegym.demospringboot.bean.Blog;
import com.codegym.demospringboot.bean.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

public interface IBlogRepository extends PagingAndSortingRepository<Blog, Long> {
    Iterable<Blog> findAllByCategory(Optional<Category> category);

    Page<Blog> findAllByNameBlogContaining(String nameBlog, Pageable pageable);
}
