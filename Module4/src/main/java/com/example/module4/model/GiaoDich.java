package com.example.module4.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
public class GiaoDich {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull(message = "Không được để trống")
    @ManyToOne
    @JoinColumn(name = "khachHang")
    KhachHang khachHang;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = "Không được để trống")
    private Date ngayGiaoDich;
    @NotEmpty(message = "Không được để trống")
    private String loaiDichVu;
    @NotNull(message = "Không được để trống")
    @Min(value = 0, message = "Phải lớn hơn 0")
    private Double donGia;
    @NotNull(message = "Không được để trống")
    @Min(value = 0, message = "Phải lớn hơn 0")
    private Integer dienTich;

    public GiaoDich() {
    }

    public GiaoDich(KhachHang khachHang, Date ngayGiaoDich, String loaiDichVu, double donGia, int dienTich) {
        this.khachHang = khachHang;
        this.ngayGiaoDich = ngayGiaoDich;
        this.loaiDichVu = loaiDichVu;
        this.donGia = donGia;
        this.dienTich = dienTich;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public KhachHang getKhachHang() {
        return khachHang;
    }

    public void setKhachHang(KhachHang khachHang) {
        this.khachHang = khachHang;
    }

    public Date getNgayGiaoDich() {
        return ngayGiaoDich;
    }

    public void setNgayGiaoDich(Date ngayGiaoDich) {
        this.ngayGiaoDich = ngayGiaoDich;
    }

    public String getLoaiDichVu() {
        return loaiDichVu;
    }

    public void setLoaiDichVu(String loaiDichVu) {
        this.loaiDichVu = loaiDichVu;
    }

    public Double getDonGia() {
        return donGia;
    }

    public void setDonGia(Double donGia) {
        this.donGia = donGia;
    }

    public Integer getDienTich() {
        return dienTich;
    }

    public void setDienTich(Integer dienTich) {
        this.dienTich = dienTich;
    }
}
