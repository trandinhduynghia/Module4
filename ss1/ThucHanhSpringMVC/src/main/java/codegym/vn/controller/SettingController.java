package codegym.vn.controller;

import codegym.vn.bean.ISettingService;
import codegym.vn.bean.Setting;
import codegym.vn.bean.SettingService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class SettingController {
    ISettingService settingService = new SettingService();

    @GetMapping("/setting/list")
    public String list (Model model) {
        model.addAttribute("setting", settingService.findAll());
        return "list";
    }

    @GetMapping("/setting/{id}/edit")
    public ModelAndView showEdit(@PathVariable int id) {
        return new ModelAndView("edit", "setting", settingService.findById(id));
    }


    @PostMapping("/setting/update")
    public ModelAndView updateProduct(Setting setting, RedirectAttributes redirectAttributes) {
        settingService.update(setting.getId(), setting);
        redirectAttributes.addFlashAttribute("success", "Modified setting successfully!");
        return new ModelAndView("edit", "setting", settingService.findById(setting.getId()));
    }

}
