package codegym.vn.controller;

import codegym.vn.bean.Customer;
import codegym.vn.bean.SanPham;
import codegym.vn.service.CustomerServiceImpl;
import codegym.vn.service.ICustomerService;
import codegym.vn.service.SanPhamService;
import codegym.vn.service.SanPhamServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class SanPhamController {
    private final SanPhamService sanPhamService = new SanPhamServiceImpl();

    @GetMapping("/sanpham/danhsach")
    public String index(Model model) {
        List<SanPham> sanPhamList = sanPhamService.findAll();
        model.addAttribute("sanphamlist", sanPhamList);
        return "danhsach";
    }

    @GetMapping("/sanpham/themmoi")
    public String create(Model model) {
        model.addAttribute("sanpham", new SanPham());
        return "themmoi";
    }

    @PostMapping("/sanpham/luu")
    public String save(SanPham sanPham) {
        sanPham.setId((int) (Math.random() * 10000));
        sanPhamService.save(sanPham);
        return "redirect:/sanpham/danhsach";
    }

    @GetMapping("/sanpham/{id}/sua")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("sanpham", sanPhamService.findById(id));
        return "sua";
    }

    @PostMapping("/sanpham/sua")
    public String update(SanPham sanPham) {
        sanPhamService.update(sanPham.getId(), sanPham);
        return "redirect:/sanpham/danhsach";
    }

    @GetMapping("/sanpham/{id}/xoa")
    public String delete(@PathVariable int id, Model model) {
        model.addAttribute("sanpham", sanPhamService.findById(id));
        return "xoa";
    }

    @PostMapping("/sanpham/xoa")
    public String delete(SanPham sanPham, RedirectAttributes redirect) {
        sanPhamService.remove(sanPham.getId());
        redirect.addFlashAttribute("success", "Removed customer successfully!");
        return "redirect:/sanpham/danhsach";
    }

    @GetMapping("/sanpham/{id}/thongtin")
    public String view(@PathVariable int id, Model model) {
        model.addAttribute("sanpham", sanPhamService.findById(id));
        return "thongtin";
    }

}
