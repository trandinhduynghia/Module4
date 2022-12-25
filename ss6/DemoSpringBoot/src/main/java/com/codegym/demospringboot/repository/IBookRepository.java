package com.codegym.demospringboot.repository;

import com.codegym.demospringboot.bean.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

public interface IBookRepository extends JpaRepository<Book, Integer> {
    @Transactional
    @Modifying
    @Query(value = "update Book b set b.quantity = b.quantity + 1 where b.id =: id")
    void increaseBookQuantity(@Param("id") Integer id);

    @Transactional
    @Modifying
    @Query(value = "update Book b set b.quantity = b.quantity - 1 where b.id =: id")
    void decreaseBookQuantity(@Param("id") Integer id);
}
