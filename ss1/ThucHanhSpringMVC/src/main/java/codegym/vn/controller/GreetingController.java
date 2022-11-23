package codegym.vn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

// @Controller để đánh dấu class GreetingController là 1 controller xử lý các request
@Controller
public class GreetingController {
    // @GetMapping đánh dấu một phương thức dùng để xử lý request khi có một request GET được gửi đến đường dẫn "/greeting".
    @GetMapping("/greeting")
    public String greeting(@RequestParam String name, Model model){
        model.addAttribute("name", name);
        return "index";
    }
}
