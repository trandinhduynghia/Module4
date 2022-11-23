package codegym.vn.controller;

import codegym.vn.bean.Student;
import codegym.vn.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class StudentController {
    @Autowired
    StudentService studentService;

    @GetMapping("/student/list")
    public String displayList(Model model){
        model.addAttribute("students", studentService.findAll());
        return "student/list";
    }

    @GetMapping("/student/delete")
    public String delete(@RequestParam ("id") String id, Model model){
        studentService.deleteById(id);
        model.addAttribute("students", studentService.findAll());
        return "student/list";
    }

    @GetMapping("/student/create")
    public String create(Model model){
        return "student/create";
    }

    @PostMapping("/student/create")
    public String create(@RequestParam ("id") String id, @RequestParam ("name") String name, @RequestParam ("age") int age, @RequestParam ("address") String address, Model model){
        Student student = new Student(id, name, age, address);
        studentService.createOrUpdate(student);

        model.addAttribute("students", studentService.findAll());
        return "student/list";
    }

    @GetMapping("/student/update")
    public String showUpdate(Model model, @RequestParam("id") String id) {
        model.addAttribute("student", studentService.findById(id));
        return "student/update";
    }

    @PostMapping("/student/update")
    public String doUpdate(@RequestParam("id") String id, @RequestParam("name") String name,
                           @RequestParam("age") int age, @RequestParam("address") String address) {
        Student student = new Student(id, name, age, address);
        studentService.createOrUpdate(student);
        return "redirect:/student/list";
    }


}
