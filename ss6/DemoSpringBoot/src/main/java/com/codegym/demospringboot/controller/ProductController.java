package com.codegym.demospringboot.controller;

import com.codegym.demospringboot.bean.*;
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
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.io.InputStream;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
@SessionAttributes("cart")
public class ProductController {
    @Autowired
    IProductService productService;
    @Autowired
    IProductTypeService productTypeService;
    @Autowired
    Validate validateProduct;
    @ModelAttribute("cart")
    public Cart setUpUserForm(){
        return new Cart();
    }

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
    @GetMapping("/view-product/{id}")
    public ModelAndView viewProduct(@PathVariable("id") Integer id){
        System.out.println(productService.findById(id).getId());
        return new ModelAndView("viewproduct","product",productService.findById(id));
    }
    @PostMapping("/view-product/{id}")
    public ModelAndView addViewProduct(@PathVariable("id") Integer id,@ModelAttribute("cart") Cart cart){
        Product product=productService.findById(id);
        ModelAndView modelAndView=new ModelAndView("redirect:/cart");
        modelAndView.addObject("product",product);
        if (product==null){
            modelAndView.addObject("message","Error");
        }else{
            cart.addToCart(product);
            modelAndView.addObject("message","Add "+product.getName()+" to cart successfully\nAmount: "+cart.getAmount(product));
        }
        System.out.println("test");
        System.out.println(cart.getCart().toString());
        return modelAndView;
    }
    @GetMapping("/cart")
    public String cart(@ModelAttribute("cart") Cart cart, Model model){
        model.addAttribute("cart", cart);
        return "cart";
    }
    @GetMapping("/cart/add/{id}")
    public ModelAndView goToCart(@ModelAttribute("cart") Cart cart, @PathVariable Integer id){
        Product product = productService.findById(id);
        cart.addToCart(product);
        return new ModelAndView("cart","cart",cart);
    }
    @GetMapping("/cart/remove/{id}")
    public ModelAndView removeProduct(@ModelAttribute("cart") Cart cart, @PathVariable Integer id){
        cart.removeProduct(productService.findById(id));
        return new ModelAndView("cart");
    }
}
