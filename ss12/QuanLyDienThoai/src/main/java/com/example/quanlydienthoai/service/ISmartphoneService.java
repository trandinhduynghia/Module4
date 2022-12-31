package com.example.quanlydienthoai.service;

import com.example.quanlydienthoai.model.Smartphone;

import java.util.Optional;

public interface ISmartphoneService {
    Iterable<Smartphone> findAll();

    Optional<Smartphone> findById(Long id);

    Smartphone save(Smartphone smartPhone);

    void update(Smartphone smartphone);

    void remove(Long id);
}
