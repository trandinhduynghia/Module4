package com.example.module6.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

@Entity(name = "account")
public class Account {
    @Id
    @Column(name = "username")
    private String username;
    @Column(name = "password", nullable = false, columnDefinition = "varchar(45)")
    private String password;
    @OneToOne(mappedBy = "account")
    @JsonBackReference
    private Customer customer;

    public Account() {
    }

    public Account(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
