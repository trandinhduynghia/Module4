package com.example.module4.service;

import com.example.module4.model.GiaoDich;
import com.example.module4.repository.IGiaoDichRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GiaoDichService implements IGiaoDichService{
    @Autowired
    IGiaoDichRepository giaoDichRepository;

    @Override
    public Iterable<GiaoDich> danhSach() {
        return giaoDichRepository.findAll();
    }

    @Override
    public void them(GiaoDich giaoDich) {
        giaoDichRepository.save(giaoDich);

    }

    @Override
    public void xoa(Integer id) {
        giaoDichRepository.deleteById(id);
    }

    @Override
    public Optional<GiaoDich> findById(Integer id) {
        return giaoDichRepository.findById(id);
    }

    @Override
    public List<GiaoDich> findByKhachHangAndAndLoaiDichVu(String khachHang, String dichVu) {
        return giaoDichRepository.findByKhachHangAndAndLoaiDichVu(khachHang, dichVu);
    }
}
