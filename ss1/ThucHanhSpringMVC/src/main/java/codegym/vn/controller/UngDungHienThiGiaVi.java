package codegym.vn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UngDungHienThiGiaVi {

    @GetMapping("/GiaVi")
    public String giaVi(){
        return "giavi";
    }

    @PostMapping("/GiaVi1")
    public String giaVi1(@RequestParam ("giavi") String [] giavi, Model model){
        model.addAttribute("giavi", giavi);
        return "giavi1";
    }
}
