package com.codegym.demospringboot.controller;

import com.codegym.demospringboot.bean.Product;
import com.codegym.demospringboot.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
//@RequestMapping("/product")
public class ProductJqueryController {
    @Autowired
    private IProductService productService;

    @GetMapping("/productjquery")
    public ModelAndView listProduct(){
        ModelAndView modelAndView = new ModelAndView("productjquery");
        modelAndView.addObject("products", productService.findAll());
        return modelAndView;
    }

//    @PostMapping
//    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
//        return new ResponseEntity<>(productService.addProduct(product), HttpStatus.CREATED);
//    }


}
