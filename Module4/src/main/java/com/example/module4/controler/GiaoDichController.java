package com.example.module4.controler;

import com.example.module4.model.GiaoDich;
import com.example.module4.service.IGiaoDichService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
public class GiaoDichController {
    @Autowired
    IGiaoDichService giaoDichService;

    @GetMapping("/list")
    public String danhSachGiaoDich(Model model){
        model.addAttribute("list", giaoDichService.danhSach());
        return "list";
    }

    @GetMapping("/find")
    public String find(@RequestParam("khachhang") String khachHang, @RequestParam("dichvu") String dichVu, Model model) {
        if ("".equals(dichVu) && "".equals(khachHang)) {
            return "redirect:/list";
        }
        List<GiaoDich> giaoDichs = giaoDichService.findByKhachHangAndAndLoaiDichVu(khachHang, dichVu);
        model.addAttribute("list", giaoDichs);
        return "list";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("giaoDich", new GiaoDich());
        return "create";
    }

    @PostMapping("/create")
    public String save(@Valid @ModelAttribute("giaoDich") GiaoDich giaoDich, BindingResult bindingResult, Model model) {
        if(bindingResult.hasFieldErrors()){
            return "create";
        }
        giaoDichService.them(giaoDich);
        model.addAttribute("message", "Thêm giao dịch thành công");
        return "create";
    }

    @GetMapping("/view/{id}")
    public String showEditForm(@PathVariable Integer id, Model model) {
        Optional<GiaoDich> giaoDich = giaoDichService.findById(id);
        if (giaoDich != null) {
            model.addAttribute("giaoDich", giaoDich);
            return "edit";
        } else {
            return "/error.404";
        }
    }

    @GetMapping("/delete")
    public String showDeleteForm(@RequestParam("id") Integer id, Model model) {
        giaoDichService.xoa(id);
        return "redirect:/list";
    }
}
