package com.example.module4.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class KhachHang {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String ten;
    private String sdt;
    private String email;

    @OneToMany(mappedBy = "khachHang")
    private Set<GiaoDich> giaoDich;

    public KhachHang() {
    }

    public KhachHang(Integer id, String ten, String sdt, String email) {
        this.id = id;
        this.ten = ten;
        this.sdt = sdt;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }



}
