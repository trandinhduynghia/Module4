package com.example.module6.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "full_name", columnDefinition = "varchar(45)")
    private String fullName;
    //    @Column(name = "ngay_sinh", nullable = false)
//    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "birthday", columnDefinition = "Date")
    private String birthday;
    private boolean gender;
    @Column(name = "card_id", columnDefinition = "varchar(45)")
    private String cardId;
    private String email;
    private String address;
    private String phoneNumber;
    @OneToOne
    @JoinColumn(name = "username",unique = true)
    @NotNull
    private Account account;

    public Customer() {
    }

    public Customer(Integer id, String fullName, String birthday, boolean gender, String cardId, String email, String address, String phoneNumber, Account account) {
        this.id = id;
        this.fullName = fullName;
        this.birthday = birthday;
        this.gender = gender;
        this.cardId = cardId;
        this.email = email;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.account = account;
    }

    public Customer(String fullName, String birthday, boolean gender, String cardId, String email, String address, String phoneNumber, Account account) {
        this.fullName = fullName;
        this.birthday = birthday;
        this.gender = gender;
        this.cardId = cardId;
        this.email = email;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.account = account;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
