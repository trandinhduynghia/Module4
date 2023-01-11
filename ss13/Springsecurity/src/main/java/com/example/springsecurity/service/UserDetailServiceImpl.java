package com.example.springsecurity.service;

import com.example.springsecurity.model.Account;
import com.example.springsecurity.repository.AccountRepository;
import com.example.springsecurity.repository.AccountRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailServiceImpl implements UserDetailsService {
    @Autowired
    AccountRepository accountRepository;
    @Autowired
    AccountRoleRepository accountRoleRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = accountRepository.findByAccountName(username);
        if (account == null) {
            throw new UsernameNotFoundException("User không tồn tại");
        }

        List<String> roles = accountRoleRepository.findAllRoleByUser(username);
        List<GrantedAuthority> authorityList = new ArrayList<>();
        for (String roleName: roles) {
            authorityList.add(new SimpleGrantedAuthority(roleName));
        }

        UserDetails userDetails = new User(username, account.getPassword(), authorityList);
        return userDetails;
    }
}
