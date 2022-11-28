package codegym.vn.controller;

import codegym.vn.bean.music;
import codegym.vn.bean.musicForm;
import codegym.vn.service.IMusicService;
import codegym.vn.service.MusicService;
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
public class MusicController {
    private final IMusicService nhacService = new MusicService();

    @GetMapping("/music/list")
    public String index(Model model) {
        List<music> musics = nhacService.findAll();
        model.addAttribute("musics", musics);
        return "list";
    }

    @GetMapping("/music/create")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("musicForm", new musicForm());
        return modelAndView;
    }

    @Value("${file-upload}")
    private String fileUpload;

    @PostMapping("/music/save")
    public ModelAndView save(@ModelAttribute musicForm musicForm) {
        MultipartFile multipartFile = musicForm.getDuongdan();
        String duongdan = multipartFile.getOriginalFilename();
        try {
            FileCopyUtils.copy(musicForm.getDuongdan().getBytes(), new File(fileUpload + duongdan));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        music nhac = new music(musicForm.getId(), musicForm.getTenbaihat(),
                musicForm.getNghesithehien(), musicForm.getTheloai(), duongdan);
        nhacService.save(nhac);
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("musicForm", musicForm);
        modelAndView.addObject("message", "Created new product successfully !");
        return modelAndView;
    }
}
