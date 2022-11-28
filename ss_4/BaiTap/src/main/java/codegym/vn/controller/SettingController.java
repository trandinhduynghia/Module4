package codegym.vn.controller;

import codegym.vn.bean.Setting;
import codegym.vn.service.SettingService;
import codegym.vn.service.SettingServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class SettingController {
    SettingService settingService = new SettingServiceImpl();


    @GetMapping("/setting/{id}/edit")
    public ModelAndView showEdit(@PathVariable int id) {
        return new ModelAndView("edit", "settingedit", settingService.findById(id));
    }


    @PostMapping("/setting/update")
    public ModelAndView updateProduct(Setting setting, RedirectAttributes redirectAttributes) {
        settingService.update(setting.getId(), setting);
        redirectAttributes.addFlashAttribute("success", "Modified setting successfully!");
        return new ModelAndView("edit", "settingedit", settingService.findById(setting.getId()));
    }
}
