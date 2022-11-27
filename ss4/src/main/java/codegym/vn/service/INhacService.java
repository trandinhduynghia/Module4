package codegym.vn.service;

import codegym.vn.bean.Product;
import codegym.vn.bean.nhac;

import java.util.List;

public interface INhacService {
    List<nhac> findAll();

    void save(nhac nhac);

    nhac findById(int id);

    void update(int id, nhac nhac);

    void remove(int id);
}
