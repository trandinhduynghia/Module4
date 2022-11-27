package codegym.vn.controller;

import codegym.vn.bean.Customer;
import codegym.vn.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class CustomerController {
    @Autowired
    private ICustomerService customerService;

    @GetMapping("/customer/list")
    public String list(Model model){
        List<Customer> customerList = customerService.findAll();
        model.addAttribute("customerList", customerList);
        return "list";
    }

    @GetMapping("/customer/create")
    public String showCreateForm(Model model) {
        model.addAttribute("customer", new Customer());
        return "create";
    }

    @PostMapping("/customer/create")
    public String saveCustomer(Customer customer, RedirectAttributes redirect) {
        customerService.save(customer);
        redirect.addFlashAttribute("message", "Create customer successfully!");
        return "redirect:/customer/list";
    }

    @GetMapping("/customer/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Customer customer = customerService.findById(id);
        model.addAttribute("customeredit", customer);
        return "edit";

    }

    @PostMapping("/customer/edit")
    public String updateCustomer(Customer customer, RedirectAttributes redirect) {
        customerService.save(customer);
        redirect.addFlashAttribute("message", "Edit customer successfully!");
        return "redirect:/customer/list";
    }

    @GetMapping("/customer/delete/{id}")
    public String showDeleteForm(@PathVariable Long id, Model model) {
        Customer customer = customerService.findById(id);
        model.addAttribute("customerdelete", customer);
        return "delete";
    }

    @PostMapping("/customer/delete")
    public String deleteCustomer(Customer customer, RedirectAttributes redirect) {
        customerService.remove(customer.getId());
        redirect.addFlashAttribute("message", "Delete customer successfully!");
        return "redirect:/customer/list";
    }
}
