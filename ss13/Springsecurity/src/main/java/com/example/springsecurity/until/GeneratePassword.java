package com.example.springsecurity.until;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class GeneratePassword {
    public static String generatePassword(String rawPass) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder.encode(rawPass);
    }

    public static void main(String[] args) {
        System.out.println(generatePassword("123456"));
    }
}
//$2a$10$ke4kuATWNaoh8A5TfadMde.4nnC0StSeu8fiH8FC1e9bH2Lydawea
