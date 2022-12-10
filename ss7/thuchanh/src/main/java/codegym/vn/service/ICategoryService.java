package codegym.vn.service;

import codegym.vn.bean.Category;
import codegym.vn.bean.Province;

public interface ICategoryService {
    Iterable<Category> findAll();

    Category findById(Long id);

    void save(Category category);

    void remove(Long id);
}
