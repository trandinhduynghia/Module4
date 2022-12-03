package codegym.vn.controller;

import codegym.vn.bean.Product;
import codegym.vn.service.ProductService;
import codegym.vn.service.ProductServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class ProductController {
    private final ProductService productService = new ProductServiceImpl();

    @GetMapping("/product/list")
    public String index(Model model) {
        List<Product> productList = productService.findAll();
        model.addAttribute("productList", productList);
        return "list";
    }

    @GetMapping("/product/create")
    public String create(Model model) {
        model.addAttribute("product", new Product());
        return "create1";
    }

    @PostMapping("/product/save")
    public String save(Product product) {
        product.setId((int) (Math.random() * 10000));
        productService.save(product);
        return "redirect:/product/list";
    }

    @GetMapping("/product/{id}/edit")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "edit1";
    }

    @PostMapping("/product/update")
    public String update(Product product) {
        productService.update(product.getId(), product);
        return "redirect:/product/list";
    }

    @GetMapping("/product/{id}/delete")
    public String delete(@PathVariable int id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "delete1";
    }

    @PostMapping("/product/delete")
    public String delete(Product product, RedirectAttributes redirect) {
        productService.remove(product.getId());
        redirect.addFlashAttribute("success", "Removed customer successfully!");
        return "redirect:/product/list";
    }

    @GetMapping("/product/{id}/view")
    public String view(@PathVariable int id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "view1";
    }

}
