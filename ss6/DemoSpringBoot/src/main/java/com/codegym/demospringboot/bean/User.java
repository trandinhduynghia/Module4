package com.codegym.demospringboot.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.*;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Họ không được để trống")
    @Size(min = 5, max = 45, message = "Họ có độ dài từ 5 - 45 kí tự")
    @Pattern(regexp = "^[a-zA-Z]*$", message = "Họ chỉ chứa kí tự a-z A-Z")
    private String firstName;

    @NotEmpty(message = "Tên không được để trống")
    @Size(min = 5, max = 45, message = "Tên có độ dài từ 5 - 45 kí tự")
    @Pattern(regexp = "^[a-zA-Z]*$", message = "Tên chỉ chứa kí tự a-z A-Z")
    private String lastName;

    @NotEmpty(message = "Số điện thoại không được để trống")
    @Pattern(regexp = "(^$|[0-9]{10})", message = "Số điện thoại không hợp lệ")
    private String phoneNumBer;

    @Min(value = 18, message = "Tuổi phải lớn hơn 18")
    private int age;

    @NotEmpty(message = "Email không được để trống")
    @Email(message = "Email không đúng định dạng")
    private String email;

    public User() {
    }

    public User(String firstName, String lastName, String phoneNumBer, int age, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumBer = phoneNumBer;
        this.age = age;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumBer() {
        return phoneNumBer;
    }

    public void setPhoneNumBer(String phoneNumBer) {
        this.phoneNumBer = phoneNumBer;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    //    public String getAge() {
//        return age;
//    }
//
//    public void setAge(String age) {
//        this.age = age;
//    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
