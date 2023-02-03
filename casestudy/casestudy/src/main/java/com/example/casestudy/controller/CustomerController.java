package com.example.casestudy.controller;

import com.example.casestudy.model.Customer;
import com.example.casestudy.service.ICustomerService;
import com.example.casestudy.service.ICustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Optional;

@Controller
public class CustomerController {
    @Autowired
    ICustomerService customerService;

    @Autowired
    ICustomerTypeService customerTypeService;

//    @GetMapping("/list-customer")
//    public String listCustomer(Model model){
//        model.addAttribute("list", customerService.findAll());
//        return "list";
//    }

    @GetMapping("/list-customer")
    public String listCustomer(@RequestParam("name") Optional<String> name,
                               @RequestParam("address") Optional<String> address,
                               @RequestParam("customerType") Optional<String> customerType,
                               @PageableDefault(value = 3) Pageable pageable,
                               Model model) {
        Page<Customer> list;
        String condition = "";
        if (name.isPresent() || address.isPresent() || customerType.isPresent()){
            list = customerService.searchCustomer(name.get(), address.get(), customerType.get(), pageable);
        }else {
            list = customerService.findAll(pageable);
        }
//        if(name.isPresent()){
//            condition += "&name=" + name.get();
//            model.addAttribute("name", name.get());
//        }
//        if (address.isPresent()) {
//            condition += "&address=" + address.get();
//            model.addAttribute("address", address.get());
//        }
//        if (customerType.isPresent()) {
//            condition += "&customerType=" + customerType.get();
//            model.addAttribute("customerType", customerType.get());
//        }
        model.addAttribute("list", list);
        model.addAttribute("condition", condition);
        return "list";
    }


    @GetMapping("/create-customer")
    public String showCreateForm(Model model) {
        model.addAttribute("customer", new Customer());
        return "create";
    }

    @PostMapping("/create-customer")
    public String saveCustomer(@Valid @ModelAttribute("customer") Customer customer, BindingResult bindingResult, Model model) {
        if(bindingResult.hasFieldErrors()){
            return "create";
        }
        customerService.add(customer);
        model.addAttribute("message", "New customer created successfully");
        return "create";
    }

    @GetMapping("/edit-customer/{id}")
    public String showEditForm(@PathVariable Integer id, Model model) {
        Optional<Customer> customer = customerService.findById(id);
        if (customer != null) {
            model.addAttribute("customer", customer);
            return "edit";
        } else {
            return "/error.404";
        }
    }

    @PostMapping("/edit-customer")
    public String updateCustomer(@ModelAttribute("customer") Customer customer, Model model) {
        customerService.update(customer);
        model.addAttribute("message", "Customer updated successfully");
        return "edit";
    }

    @GetMapping("/delete-customer")
    public String showDeleteForm(@RequestParam("id") Integer id, Model model) {
//        Optional<Customer> customer = customerService.findById(id);
        customerService.delete(id);
        return "redirect:/list-customer";
    }

//    @PostMapping("/delete-customer")
//    public String deleteCustomer(@ModelAttribute("customer") Customer customer) {
//        customerService.delete(customer.getId());
//        return "redirect:/list-customer";
//    }

}
