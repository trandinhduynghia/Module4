package codegym.vn.service;

import codegym.vn.bean.Customer;
import codegym.vn.bean.SanPham;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SanPhamServiceImpl implements SanPhamService{

    private static final Map<Integer, SanPham> sanpham ;
    static {

        sanpham = new HashMap<>();
        sanpham.put(1, new SanPham(1, "iphone1", 10000, "iphone1", "apple"));
        sanpham.put(2, new SanPham(2, "iphone2", 20000, "iphone2", "apple"));
        sanpham.put(3, new SanPham(3, "iphone3", 30000, "iphone3", "apple"));

    }

    @Override
    public List<SanPham> findAll() {
        return new ArrayList<>(sanpham.values());
    }

    @Override
    public void save(SanPham sanPham) {
        sanpham.put(sanPham.getId(), sanPham);

    }

    @Override
    public SanPham findById(int id) {
        return sanpham.get(id);
    }

    @Override
    public void update(int id, SanPham sanPham) {
        sanpham.put(id, sanPham);
    }

    @Override
    public void remove(int id) {
        sanpham.remove(id);
    }
}
