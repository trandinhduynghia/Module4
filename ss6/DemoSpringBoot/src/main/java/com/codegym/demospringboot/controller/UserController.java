package com.codegym.demospringboot.controller;

import com.codegym.demospringboot.bean.User;
import com.codegym.demospringboot.service.IUserService;
import com.codegym.demospringboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {
    @Autowired
    private IUserService userService;

//    @GetMapping("/user")
//    public ModelAndView listUser() {
//        Iterable<User> users = userService.findAll();
//        ModelAndView modelAndView = new ModelAndView("listuser");
//        modelAndView.addObject("users", users);
//        return modelAndView;
//    }

    @GetMapping("/create-user")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("createuser");
        modelAndView.addObject("user", new User());
        return modelAndView;
    }

    @PostMapping("/create-user")
    public ModelAndView saveUser(@Validated @ModelAttribute("user") User user, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView("createuser");
        if(bindingResult.hasFieldErrors()){
            modelAndView.addObject("user", user);
            modelAndView.addObject("message", "Thêm user không thành công");
            return modelAndView;
        }
        userService.save(user);
        modelAndView.addObject("user", new User());
        modelAndView.addObject("message", "Thêm user thành công");
        return modelAndView;
    }
}
