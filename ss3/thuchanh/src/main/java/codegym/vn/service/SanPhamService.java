package codegym.vn.service;

import codegym.vn.bean.Customer;
import codegym.vn.bean.SanPham;

import java.util.List;

public interface SanPhamService {
    List<SanPham> findAll();

    void save(SanPham sanPham);

    SanPham findById(int id);

    void update(int id, SanPham sanPham);

    void remove(int id);
}
