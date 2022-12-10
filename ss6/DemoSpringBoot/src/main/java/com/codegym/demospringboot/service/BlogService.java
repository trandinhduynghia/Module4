package com.codegym.demospringboot.service;

import com.codegym.demospringboot.bean.Blog;
import com.codegym.demospringboot.bean.Category;
import com.codegym.demospringboot.repository.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BlogService implements IBlogService {
    @Autowired
    private IBlogRepository blogRepository;

    @Override
    public Iterable<Blog> findAll() {
        return blogRepository.findAll();
    }

    @Override
    public Page<Blog> findAll(Pageable pageable) {
        return blogRepository.findAll(pageable);
    }

    @Override
    public Page<Blog> findAllByNameBlogContaining(String nameBlog, Pageable pageable) {
        return blogRepository.findAllByNameBlogContaining(nameBlog, pageable);
    }

    @Override
    public Optional<Blog> findById(Long id) {
        return blogRepository.findById(id);
    }


    @Override
    public void save(Blog blog) {
        blogRepository.save(blog);

    }

    @Override
    public void remove(Long id) {
        blogRepository.deleteById(id);
    }

    @Override
    public Iterable<Blog> findAllByCategory(Optional<Category> category) {
        return blogRepository.findAllByCategory(category);
    }
}
