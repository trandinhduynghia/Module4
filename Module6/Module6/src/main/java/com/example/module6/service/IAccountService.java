package com.example.module6.service;

import com.example.module6.model.Account;

public interface IAccountService {
    void save(Account account);
    String existsByUserName(String username);
    String existsByPassword(String username, String password);
    void saveNewPassword(String password,String username);
}
