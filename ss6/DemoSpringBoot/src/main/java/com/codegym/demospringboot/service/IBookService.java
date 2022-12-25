package com.codegym.demospringboot.service;

import com.codegym.demospringboot.bean.Book;

import java.util.List;

public interface IBookService {
    List<Book> showAll();

    Book getBookById(int id);

    void increaseBookQuantity(Integer id);

    void decreaseBookQuantity(Integer id);
}
