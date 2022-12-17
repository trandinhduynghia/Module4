package com.codegym.demospringboot.service;

import com.codegym.demospringboot.bean.Category;
import com.codegym.demospringboot.bean.User;

public interface IUserService {
    Iterable<User> findAll();

    java.util.Optional<User> findById(Long id);

    void save(User user);

    void remove(Long id);
}
