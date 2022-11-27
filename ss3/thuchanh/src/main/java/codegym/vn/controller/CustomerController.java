package codegym.vn.controller;

import codegym.vn.bean.Customer;
import codegym.vn.service.CustomerServiceImpl;
import codegym.vn.service.ICustomerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class CustomerController {
//    @Autowired
//    CustomerService customerService = new CustomerServiceImpl(); @Autowired k can new
//    private   ICustomerService customerService ;
    private final ICustomerService customerService = new CustomerServiceImpl();

    @GetMapping("/customer/list")
    public String index(Model model) {
        List<Customer> customerList = customerService.findAll();
        model.addAttribute("customers", customerList);
        return "index";
    }

    @GetMapping("/customer/create")
    public String create(Model model) {
        model.addAttribute("customer", new Customer());
        return "create";
    }

    @PostMapping("/customer/save")
    public String save(Customer customer) {
        customer.setId((int) (Math.random() * 10000));
        customerService.save(customer);
        return "redirect:/customer/list";
    }

    @GetMapping("/customer/{id}/edit")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("customer", customerService.findById(id));
        return "/edit";
    }

    @PostMapping("/customer/update")
    public String update(Customer customer) {
        customerService.update(customer.getId(), customer);
        return "redirect:/customer/list";
    }

    @GetMapping("/customer/{id}/delete")
    public String delete(@PathVariable int id, Model model) {
        model.addAttribute("customer", customerService.findById(id));
        return "/delete";
    }

    @PostMapping("/customer/delete")
    public String delete(Customer customer, RedirectAttributes redirect) {
        customerService.remove(customer.getId());
        redirect.addFlashAttribute("success", "Removed customer successfully!");
        return "redirect:/customer/list";
    }

    @GetMapping("/customer/{id}/view")
    public String view(@PathVariable int id, Model model) {
        model.addAttribute("customer", customerService.findById(id));
        return "/view";
    }

}
