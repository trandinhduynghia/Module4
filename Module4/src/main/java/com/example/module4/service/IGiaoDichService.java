package com.example.module4.service;

import com.example.module4.model.GiaoDich;

import java.util.List;
import java.util.Optional;

public interface IGiaoDichService {
    Iterable<GiaoDich> danhSach();
    void them(GiaoDich giaoDich);
    void xoa(Integer id);
    Optional<GiaoDich> findById(Integer id);
    List<GiaoDich> findByKhachHangAndAndLoaiDichVu(String khachHang, String dichVu);
}
