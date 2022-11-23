package codegym.vn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

@Controller
public class UngDungTuDienDonGian {

    @GetMapping("/TuDien")
    public String tuDien(){
        return "tudien";
    }

    @PostMapping("/TuDien1")
    public String tuDien1(@RequestParam("tim") String tim, Model model){
        Map<String, String> tuDien = new HashMap<>();
        tuDien.put("hello", "xin chao");
        tuDien.put("how", "the nao");
        tuDien.put("book", "quyen vo");
        tuDien.put("computer", "may tinh");

        String ketQua = tuDien.get(tim);
        if(ketQua != null){
            model.addAttribute("tim", tim);
            model.addAttribute("ketqua", ketQua);
        }else{
            model.addAttribute("tim", tim);
            model.addAttribute("ketqua", "khong co trong tu dien");
        }
        return "tudien1";
    }
}
