package com.codegym.demospringboot.repository;

import com.codegym.demospringboot.bean.Blog;
import com.codegym.demospringboot.bean.User;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IUserRepository extends PagingAndSortingRepository<User, Long> {
}
