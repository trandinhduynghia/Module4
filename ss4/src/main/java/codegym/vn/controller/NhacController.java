package codegym.vn.controller;

import codegym.vn.bean.Product;
import codegym.vn.bean.ProductForm;
import codegym.vn.bean.nhac;
import codegym.vn.bean.nhacForm;
import codegym.vn.service.INhacService;
import codegym.vn.service.IProductService;
import codegym.vn.service.NhacService;
import codegym.vn.service.ProductService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
public class NhacController {
    private final INhacService nhacService = new NhacService();

    @GetMapping("/nhac/danhsach")
    public String index(Model model) {
        List<nhac> nhacs = nhacService.findAll();
        model.addAttribute("nhacs", nhacs);
        return "danhsach";
    }

    @GetMapping("/nhac/themmoi")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("/themmoi");
        modelAndView.addObject("nhactForm", new nhacForm());
        return modelAndView;
    }

    @Value("${file-upload}")
    private String fileUpload;

    @PostMapping("/nhac/luu")
    public ModelAndView luu(@ModelAttribute nhacForm nhacForm) {
        MultipartFile multipartFile = nhacForm.getDuongdan();
        String duongdan = multipartFile.getOriginalFilename();
        try {
            FileCopyUtils.copy(nhacForm.getDuongdan().getBytes(), new File(fileUpload + duongdan));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        nhac nhac = new nhac(nhacForm.getId(), nhacForm.getTenbaihat(),
                nhacForm.getNghesithehien(), nhacForm.getTheloai(), duongdan);
        nhacService.save(nhac);
        ModelAndView modelAndView = new ModelAndView("/themmoi");
        modelAndView.addObject("nhacForm", nhacForm);
        modelAndView.addObject("message", "Created new product successfully !");
        return modelAndView;
    }
}
