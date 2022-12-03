package codegym.vn.service;

import codegym.vn.bean.Province;
import codegym.vn.repository.IProvinceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProvinceService implements IProvinceService{
    @Autowired
    private IProvinceRepository provinceRepository;

    @Override
    public Iterable<Province> findAll() {
        return provinceRepository.findAll();
    }

    @Override
    public Province findById(Long id) {
        return provinceRepository.findOne(id);
    }

    @Override
    public void save(Province province) {
        provinceRepository.save(province);

    }

    @Override
    public void remove(Long id) {
        provinceRepository.delete(id);

    }
}
