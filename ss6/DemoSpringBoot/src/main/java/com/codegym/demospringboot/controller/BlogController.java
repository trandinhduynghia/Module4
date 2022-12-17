package com.codegym.demospringboot.controller;

import com.codegym.demospringboot.bean.Blog;
import com.codegym.demospringboot.bean.Category;
import com.codegym.demospringboot.service.IBlogService;
import com.codegym.demospringboot.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class BlogController {
    @Autowired
    private IBlogService blogService;

    @Autowired
    private ICategoryService categoryService;

    //    @ModelAttribyte("provinces") là cách để gắn danh sách provinces vào tất cả các model của view, có thể sử dụng ở phần view.
    @ModelAttribute("category")
    public Iterable<Category> category() {
        return categoryService.findAll();
    }

    @GetMapping("/blog-category/{id}")
    public ModelAndView viewCategory(@PathVariable("id") Long id){
        Optional<Category> category = categoryService.findById(id);
        if(category == null){
            return new ModelAndView("/error.404");
        }

        Iterable<Blog> blogs = blogService.findAllByCategory(category);
        ModelAndView modelAndView = new ModelAndView("/listblog");
        modelAndView.addObject("blogs", blogs);
        return modelAndView;
    }

    @GetMapping("/create-blog")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("createblog");
        modelAndView.addObject("blog", new Blog());
        return modelAndView;
    }

    @PostMapping("/create-blog")
    public ModelAndView saveBlog(@ModelAttribute("blog") Blog blog) {
        blogService.save(blog);
        ModelAndView modelAndView = new ModelAndView("createblog");
        modelAndView.addObject("blog", new Blog());
        modelAndView.addObject("message", "New blog created successfully");
        return modelAndView;
    }

    @GetMapping("/blog")
    public ModelAndView listBlog(@RequestParam("search") Optional<String> search,
                                 @RequestParam("page") Optional<Integer> page,
                                 @RequestParam("size") Optional<Integer> size) {
//        Iterable<Customer> customers = customerService.findAll();
        int currentPage = page.orElse(1);
        int pageSize = size.orElse(10);
        Page<Blog> blogs;
        if (search.isPresent()){
            blogs = blogService.findAllByNameBlogContaining(search.get(), PageRequest.of(currentPage - 1, pageSize));
        } else {
            blogs = blogService.findAll(PageRequest.of(currentPage - 1, pageSize));
        }
        ModelAndView modelAndView = new ModelAndView("/listblog");
        modelAndView.addObject("blogs", blogs);
        return modelAndView;
    }

    @GetMapping("/edit-blog/{id}")
    public ModelAndView showEditForm(@PathVariable Long id) {
        Optional<Blog> blog = blogService.findById(id);
        if (blog != null) {
            ModelAndView modelAndView = new ModelAndView("editblog");
            modelAndView.addObject("blog", blog);
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/edit-blog")
    public ModelAndView updateBlog(@ModelAttribute("blog") Blog blog) {
        blogService.save(blog);
        ModelAndView modelAndView = new ModelAndView("editblog");
        modelAndView.addObject("blog", blog);
        modelAndView.addObject("message", "Blog updated successfully");
        return modelAndView;
    }

    @GetMapping("/delete-blog/{id}")
    public ModelAndView showDeleteForm(@PathVariable Long id) {
        Optional<Blog> blog = blogService.findById(id);
        if (blog != null) {
            ModelAndView modelAndView = new ModelAndView("deleteblog");
            modelAndView.addObject("blog", blog);
            return modelAndView;

        } else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/delete-blog")
    public String deleteBlog(@ModelAttribute("blog") Blog blog) {
        blogService.remove(blog.getId());
        return "redirect:blog";
    }
}
