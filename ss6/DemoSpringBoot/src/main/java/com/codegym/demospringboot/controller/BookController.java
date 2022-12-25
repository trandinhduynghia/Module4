package com.codegym.demospringboot.controller;

import com.codegym.demospringboot.bean.Book;
import com.codegym.demospringboot.exception.GiveBookBackException;
import com.codegym.demospringboot.exception.RentBookException;
import com.codegym.demospringboot.service.IBookService;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Controller
public class BookController {
    private Map<Integer, Book> bookMap=new HashMap<>();

    @Autowired
    private IBookService bookService;

    @GetMapping("/books")
    public ModelAndView viewAllBook() {
        return new ModelAndView("listbook","books",bookService.showAll());
    }

    @GetMapping("/toRentBook/{id}")
    public ModelAndView viewRentBook(@PathVariable int id) {
        Book book =bookService.getBookById(id);
        Random rand = new Random();
        int random = rand.nextInt(99999- 10000) + 10000;
        if(book==null) {
            return new ModelAndView("error");
        }
        ModelAndView modelAndView= new ModelAndView("RentBook","book",book);
        modelAndView.addObject("random",random);
        return modelAndView;
    }

    @PostMapping("/rentBook/{random}/{id}")
    public ModelAndView rentBook(@ModelAttribute Book book, @PathVariable int random, @PathVariable int id) throws RentBookException {
            bookService.increaseBookQuantity(id);
            bookMap.put(random, book);
            return new ModelAndView("listbook","books",bookService.showAll());
    }

    @GetMapping("/give_book_back")
    public ModelAndView viewGiveBookBack() {
        return new ModelAndView("GiveBookBack","random", new Integer("0"));
    }

    @PostMapping("/give_book_back")
    public ModelAndView giveBookBack(@RequestParam int random) throws GiveBookBackException {
        System.out.println(random);
        if(bookMap.containsKey(random)) {
            Book book= bookMap.get(random);
            bookService.decreaseBookQuantity(book.getId());
            bookMap.remove(random);
            return new ModelAndView("listBook","books",bookService.showAll());
        }
        throw new GiveBookBackException();
    }

}
