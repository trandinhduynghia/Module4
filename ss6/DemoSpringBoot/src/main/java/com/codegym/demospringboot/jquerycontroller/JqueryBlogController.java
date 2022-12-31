package com.codegym.demospringboot.jquerycontroller;

import com.codegym.demospringboot.bean.Blog;
import com.codegym.demospringboot.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class JqueryBlogController {
    @Autowired
    private IBlogService blogService;

    @GetMapping("/")
    public ModelAndView listBlog(Pageable pageable) {
        Page<Blog> blogs = blogService.findAll(pageable);
        ModelAndView modelAndView = new ModelAndView("/listblogjquery");
        modelAndView.addObject("blogs", blogs);
        return modelAndView;
    }

    @RequestMapping(value = "/searchByName",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Blog> searchBlog(@RequestParam String name, Pageable pageable) {
        Page<Blog> blogs = blogService.findAllByNameBlogContaining(name, pageable);
        return blogs.getContent();
    }
    }
