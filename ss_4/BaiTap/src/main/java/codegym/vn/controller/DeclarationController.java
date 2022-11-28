package codegym.vn.controller;

import codegym.vn.bean.Declaration;
import codegym.vn.bean.Setting;
import codegym.vn.service.DeclarationImpl;
import codegym.vn.service.DeclarationService;
import codegym.vn.service.SettingService;
import codegym.vn.service.SettingServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class DeclarationController {
    DeclarationService declarationService = new DeclarationImpl();


    @GetMapping("/declaration/{id}/edit")
    public ModelAndView showEdit(@PathVariable int id) {
        return new ModelAndView("edit1", "declaration", declarationService.findById(id));
    }


    @PostMapping("/declaration/update")
    public ModelAndView update(Declaration declaration, RedirectAttributes redirectAttributes) {
        declarationService.update(declaration.getId(), declaration);
        redirectAttributes.addFlashAttribute("success", "Modified setting successfully!");
        return new ModelAndView("edit1", "declaration", declarationService.findById(declaration.getId()));
    }
}
