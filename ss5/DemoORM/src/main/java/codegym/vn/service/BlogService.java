package codegym.vn.service;

import codegym.vn.bean.Blog;
import codegym.vn.respository.IBlogRepository;
import codegym.vn.respository.ICustomerRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService implements IBlogService{
    @Autowired
    private IBlogRepository blogRepository;

    @Override
    public List<Blog> findAll() {
        return blogRepository.findAll();
    }

    @Override
    public Blog findById(Long id) {
        return blogRepository.findById(id);
    }

    @Override
    public void save(Blog blog) {
        blogRepository.save(blog);

    }

    @Override
    public void remove(Long id) {
        blogRepository.remove(id);

    }
}
