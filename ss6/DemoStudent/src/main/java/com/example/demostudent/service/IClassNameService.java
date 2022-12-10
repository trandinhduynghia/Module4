package com.example.demostudent.service;

import com.example.demostudent.entity.ClassName;

import java.util.List;

public interface IClassNameService {
    void create(ClassName className);
    void update(ClassName className);
    void delete(String id);
    List<ClassName> findAll();
    ClassName findById(String id);
}
