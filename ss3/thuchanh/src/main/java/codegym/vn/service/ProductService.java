package codegym.vn.service;

import codegym.vn.bean.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll();

    void save(Product sanPham);

    Product findById(int id);

    void update(int id, Product sanPham);

    void remove(int id);
}
