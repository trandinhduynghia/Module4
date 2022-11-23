package codegym.vn.controller;

import codegym.vn.bean.Customer;
import codegym.vn.service.CustomerService;
import codegym.vn.service.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class CustomerController {

    @Autowired
     CustomerService customerService = new CustomerServiceImpl();

    @GetMapping("/customer/list")
    public String index(Model model) {
        List<Customer> customerList = customerService.findAll();
        model.addAttribute("customers", customerList);
        return "/index";
    }
}
