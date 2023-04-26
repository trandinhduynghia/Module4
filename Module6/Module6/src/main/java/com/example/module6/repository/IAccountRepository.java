package com.example.module6.repository;

import com.example.module6.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface IAccountRepository extends JpaRepository<Account, String> {
    @Query(value = "select username from account where username = ?1", nativeQuery = true)
    String existsByUserName(String username);

    @Query(value = "select username, password from account where username = ?1 and password = ?2", nativeQuery = true)
    String existsByPassword(String username, String password);

    @Modifying
    @Query(value = "update account set password = ?1 where username = ?2 ",nativeQuery = true)
    void saveNewPassword(String password, String username);
}
