package codegym.vn.respository;

import codegym.vn.bean.Blog;
import codegym.vn.bean.Customer;

import java.util.List;

public interface IBlogRepository {
    List<Blog> findAll();

    Blog findById(Long id);

    void save(Blog blog);

    void remove(Long id);
}
