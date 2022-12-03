package codegym.vn.service;


import codegym.vn.bean.Province;

public interface IProvinceService {
    Iterable<Province> findAll();

    Province findById(Long id);

    void save(Province province);

    void remove(Long id);
}
