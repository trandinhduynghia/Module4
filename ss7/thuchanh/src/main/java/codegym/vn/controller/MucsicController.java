package codegym.vn.controller;

import codegym.vn.bean.Customer;
import codegym.vn.bean.Music;
import codegym.vn.service.IMusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class MucsicController {
    @Autowired
    private IMusicService musicService;

    @GetMapping("/music")
    public ModelAndView listMusic() {
        Iterable<Music> musics = musicService.findAll();
        ModelAndView modelAndView = new ModelAndView("listmusic");
        modelAndView.addObject("musics", musics);
        return modelAndView;
    }

    @GetMapping("/create-music")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("createmusic");
        modelAndView.addObject("music", new Music());
        return modelAndView;
    }

    @PostMapping("/create-music")
    public ModelAndView saveMusic(@Validated @ModelAttribute("music") Music music, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView("createmusic");
        if(bindingResult.hasFieldErrors()){
            modelAndView.addObject("customer", new Customer());
            modelAndView.addObject("message", "them bai hat khong thanh cong");
            return modelAndView;
        }
            musicService.save(music);
            modelAndView.addObject("customer", new Customer());
            modelAndView.addObject("message", "them bai hat thanh cong");
            return modelAndView;
    }

//    @GetMapping("/edit-music/{id}")
//    public ModelAndView showEditForm(@PathVariable Long id) {
//        Customer customer = customerService.findById(id);
//        if (customer != null) {
//            ModelAndView modelAndView = new ModelAndView("edit");
//            modelAndView.addObject("customer", customer);
//            return modelAndView;
//        } else {
//            ModelAndView modelAndView = new ModelAndView("/error.404");
//            return modelAndView;
//        }
//    }
//
//    @PostMapping("/edit-customer")
//    public ModelAndView updateCustomer(@ModelAttribute("customer") Customer customer) {
//        customerService.save(customer);
//        ModelAndView modelAndView = new ModelAndView("edit");
//        modelAndView.addObject("customer", customer);
//        modelAndView.addObject("message", "Customer updated successfully");
//        return modelAndView;
//    }
}
