package com.codegym.demospringboot.controller;

import com.codegym.demospringboot.bean.Blog;
import com.codegym.demospringboot.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import java.security.Principal;
import java.util.List;
import java.util.Optional;

@Controller
public class SpringSecurityController {
    @Autowired
    private IBlogService blogService;

    @GetMapping("/")
    public String index(Model model) {
        Iterable<Blog> blogs = blogService.findAll();
        model.addAttribute("blogs", blogs);
        return "/index";
    }


    @GetMapping("/user")
    public ModelAndView user(Principal principal) {
        // Get authenticated user name from Principal
        System.out.println(principal.getName());
        return new ModelAndView("/user");
    }

    @GetMapping("/admin")
    public ModelAndView admin() {
        // Get authenticated user name from SecurityContext
        SecurityContext context = SecurityContextHolder.getContext();
        System.out.println(context.getAuthentication().getName());
        return new ModelAndView("/admin");
    }
}
