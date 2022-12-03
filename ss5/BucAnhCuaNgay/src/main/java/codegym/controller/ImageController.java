package codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ImageController {
    @GetMapping("/image")
    public ModelAndView showEdit() {
        return new ModelAndView("image");
    }
}
