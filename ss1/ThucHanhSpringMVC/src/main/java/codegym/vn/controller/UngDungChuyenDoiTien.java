package codegym.vn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UngDungChuyenDoiTien {
    private int chuyenDoi = 22000;
    private double vnd;

    @GetMapping("/ChuyenDoiTien")
    public String chuyenDoiTien(){
        return "index";
    }

    @PostMapping("/ChuyenDoiTien1")
    public String chuyenDoiTien1(@RequestParam("usd") double usd, Model model){
        vnd = usd * chuyenDoi;
        model.addAttribute("vnd", vnd);
        model.addAttribute("usd", usd);
        return "chuyendoitien";
    }
}
