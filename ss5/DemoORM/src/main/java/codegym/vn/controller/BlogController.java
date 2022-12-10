package codegym.vn.controller;

import codegym.vn.bean.Blog;
import codegym.vn.bean.Customer;
import codegym.vn.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class BlogController {
    @Autowired
    private IBlogService blogService;

    @GetMapping("/blog/list")
    public String list(Model model){
        List<Blog> blogList = blogService.findAll();
        model.addAttribute("blogList", blogList);
        return "listblog";
    }

    @GetMapping("/blog/create")
    public String showCreateForm(Model model) {
        model.addAttribute("blog", new Blog());
        return "createblog";
    }

    @PostMapping("/blog/create")
    public String save(Blog blog, RedirectAttributes redirect) {
        blogService.save(blog);
        redirect.addFlashAttribute("message", "Create blog successfully!");
        return "redirect:/blog/list";
    }

    @GetMapping("/blog/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Blog blog = blogService.findById(id);
        model.addAttribute("blog", blog);
        return "editblog";

    }

    @PostMapping("/blog/edit")
    public String update(Blog blog, RedirectAttributes redirect) {
        blogService.save(blog);
        redirect.addFlashAttribute("message", "Edit blog successfully!");
        return "redirect:/blog/list";
    }

    @GetMapping("/blog/delete/{id}")
    public String showDeleteForm(@PathVariable Long id, Model model) {
        Blog blog = blogService.findById(id);
        model.addAttribute("blog", blog);
        return "deleteblog";
    }

    @PostMapping("/blog/delete")
    public String delete(Blog blog, RedirectAttributes redirect) {
        blogService.remove(blog.getId());
        redirect.addFlashAttribute("message", "Delete blog successfully!");
        return "redirect:/blog/list";
    }
}
