package com.codegym.demospringboot.service;

import com.codegym.demospringboot.bean.Book;
import com.codegym.demospringboot.repository.IBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BookService implements IBookService {
    @Autowired
    private IBookRepository bookRepository;


    @Override
    public List<Book> showAll() {
        return bookRepository.findAll();
    }

    @Override
    public Book getBookById(int id) {
        return bookRepository.getById(id);
    }

    @Override
    public void increaseBookQuantity(Integer id) {
        bookRepository.increaseBookQuantity(id);

    }

    @Override
    public void decreaseBookQuantity(Integer id) {
        bookRepository.decreaseBookQuantity(id);

    }
}
