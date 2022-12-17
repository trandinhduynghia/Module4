package com.codegym.demospringboot.controller;

import com.codegym.demospringboot.bean.Blog;
import com.codegym.demospringboot.bean.Category;
import com.codegym.demospringboot.bean.Product;
import com.codegym.demospringboot.bean.ProductType;
import com.codegym.demospringboot.service.IProductService;
import com.codegym.demospringboot.service.IProductTypeService;
import com.codegym.demospringboot.validate.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.io.InputStream;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
public class ProductController {
    @Autowired
    IProductService productService;
    @Autowired
    IProductTypeService productTypeService;
    @Autowired
    Validate validateProduct;



    @GetMapping("list")
    public String displayAll(Model model){
        model.addAttribute("listProduct",productService.findAll());
        return "listproduct";
    }
    @GetMapping("/listpaging")
    public String listpaging(@RequestParam("search") Optional<String> search,
                             @RequestParam("page") Optional<Integer> page,
                             @RequestParam("size") Optional<Integer> size, Model model) {
        int currentPage = page.orElse(1);
        int pageSize = size.orElse(2);


        if (search.isPresent()){
            Page<Product> products = productService.findAllByName(search.get(), PageRequest.of(currentPage - 1, pageSize));
            model.addAttribute("listProduct", products);
            int totalPages = products.getTotalPages();
            if(totalPages > 1){
                List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages).boxed().collect(Collectors.toList());
                model.addAttribute("pageNumbers", pageNumbers);
            }
        } else {
            Iterable<Product> products = productService.findAll(PageRequest.of(currentPage - 1, pageSize));
            model.addAttribute("listProduct", products);
        }
        return "listproduct";
    }
    @GetMapping("create")
    public String showCreate(Model model){
        model.addAttribute("product",new Product());
        model.addAttribute("listProductType",productTypeService.findAll());
        return "createproduct";
    }
    @PostMapping("create")
    public String doCreate(@Valid @ModelAttribute(value = "product")Product product, BindingResult bindingResult, Model model){
        validateProduct.validate(product,bindingResult);
        if(bindingResult.hasErrors()){
            model.addAttribute("listProductType",productTypeService.findAll());
            return "createproduct";
        }
        productService.addProduct(product);
        return "redirect:/list";
    }
}
