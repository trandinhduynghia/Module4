package com.codegym.demospringboot.bean;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Book {
    @Id
    private Integer id;
    private String nameBook;
    private Integer quantity;

    public Book() {
    }

    public Book(String nameBook, Integer quantity) {
        this.nameBook = nameBook;
        this.quantity = quantity;
    }

    public Book(Integer id, String nameBook, Integer quantity) {
        this.id = id;
        this.nameBook = nameBook;
        this.quantity = quantity;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNameBook() {
        return nameBook;
    }

    public void setNameBook(String nameBook) {
        this.nameBook = nameBook;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
