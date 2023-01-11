package com.example.springsecurity.repository;

import com.example.springsecurity.model.Account;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface AccountRepository extends PagingAndSortingRepository<Account, Long> {
    Account findByAccountName(String accountName);
}
