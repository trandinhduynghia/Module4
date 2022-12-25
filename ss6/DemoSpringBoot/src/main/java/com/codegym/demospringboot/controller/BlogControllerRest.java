package com.codegym.demospringboot.controller;

import com.codegym.demospringboot.bean.Blog;
import com.codegym.demospringboot.bean.Category;
import com.codegym.demospringboot.service.IBlogService;
import com.codegym.demospringboot.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@RestController
public class BlogControllerRest {
    @Autowired
    private IBlogService blogService;
    @Autowired
    private ICategoryService categoryService;

    @GetMapping("/listblog")
    public ResponseEntity<Iterable<Blog>> listBlog() {
        List<Blog> blogs = (List<Blog>) blogService.findAll();
        if (blogs.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogs, HttpStatus.OK);
    }

    @GetMapping("/blog-{id}")
    public ResponseEntity<Blog> findBlogById(@PathVariable Long id) {
        Optional<Blog> blog = blogService.findById(id);
        if (!blog.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(blog.get(), HttpStatus.OK);
    }

    @GetMapping("/listcategory")
    public ResponseEntity<Iterable<Category>> listCategory() {
        List<Category> categorys = (List<Category>) categoryService.findAll();
        if (categorys.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(categorys, HttpStatus.OK);
    }

//    @GetMapping("/blog-category-{id}")
//    public ModelAndView viewCategory(@PathVariable Long id){
//        Optional<Category> category =  categoryService.findById(id);
//        List<Blog> blogs = (List<Blog>) blogService.findAllByCategory(category);
//        if (blogs.isEmpty()) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//        return new ResponseEntity<>(blogs, HttpStatus.OK);
//    }
}
