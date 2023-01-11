package com.example.smartphone.service;

import com.example.smartphone.model.Smartphone;

import java.util.Optional;

public interface ISmartphoneService {
    Iterable<Smartphone> findAll();

    Optional<Smartphone> findById(Long id);

    Smartphone save(Smartphone smartPhone);

    void update(Smartphone smartphone);

    void remove(Long id);
}
