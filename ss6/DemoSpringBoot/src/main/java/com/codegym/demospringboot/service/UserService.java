package com.codegym.demospringboot.service;

import com.codegym.demospringboot.bean.Category;
import com.codegym.demospringboot.bean.User;
import com.codegym.demospringboot.repository.ICategoryRepository;
import com.codegym.demospringboot.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService implements IUserService{
    @Autowired
    private IUserRepository userRepository;

    @Override
    public Iterable<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public void save(User user) {
        userRepository.save(user);

    }

    @Override
    public void remove(Long id) {
        userRepository.deleteById(id);

    }
}
