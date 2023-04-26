package com.example.module6.service;

import com.example.module6.model.Account;
import com.example.module6.repository.IAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService implements IAccountService {
    @Autowired
    IAccountRepository accountRepository;

    @Override
    public void save(Account account) {
        accountRepository.save(account);
    }

    @Override
    public String existsByUserName(String username) {
        return accountRepository.existsByUserName(username);
    }

    @Override
    public String existsByPassword(String username, String password) {
        return accountRepository.existsByPassword(username, password);
    }

    @Override
    public void saveNewPassword(String password, String username) {
        accountRepository.saveNewPassword(password, username);
    }
}
