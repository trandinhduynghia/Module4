package codegym.vn.service;

import codegym.vn.bean.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductServiceImpl implements ProductService {

    private static final Map<Integer, Product> sanpham ;
    static {

        sanpham = new HashMap<>();
        sanpham.put(1, new Product(1, "iphone1", 10000, "iphone1", "apple"));
        sanpham.put(2, new Product(2, "iphone2", 20000, "iphone2", "apple"));
        sanpham.put(3, new Product(3, "iphone3", 30000, "iphone3", "apple"));

    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(sanpham.values());
    }

    @Override
    public void save(Product sanPham) {
        sanpham.put(sanPham.getId(), sanPham);

    }

    @Override
    public Product findById(int id) {
        return sanpham.get(id);
    }

    @Override
    public void update(int id, Product sanPham) {
        sanpham.put(id, sanPham);
    }

    @Override
    public void remove(int id) {
        sanpham.remove(id);
    }
}
