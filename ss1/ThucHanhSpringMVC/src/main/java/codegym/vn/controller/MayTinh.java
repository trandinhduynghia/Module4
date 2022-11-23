package codegym.vn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MayTinh {

    @GetMapping("/MayTinh")
    public String mayTinh(){
        return "maytinh";
    }

    @PostMapping ("/MayTinh1")
    public String mayTinh1(@RequestParam ("so1") double so1, @RequestParam ("so2") double so2, @RequestParam("pheptinh") String phepTinh, Model model){
        double ketQua = 0;
        String ketQua1 = "";
        switch (phepTinh){
            case "cong":
                ketQua = so1 + so2;
                break;
            case "tru":
                ketQua = so1 - so2;
                break;
            case "nhan":
                ketQua = so1 * so2;
                break;
            case "chia":
                if(so2 == 0){
                    ketQua1 = "phép chia không hợp lệ!";
                }else {
                    ketQua = so1 / so2;
                }
                break;
        }
        model.addAttribute("ketqua", ketQua);
        model.addAttribute("ketqua1", ketQua1);
        return "maytinh";
    }


}
