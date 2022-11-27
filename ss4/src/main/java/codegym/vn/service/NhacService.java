package codegym.vn.service;

import codegym.vn.bean.Product;
import codegym.vn.bean.nhac;

import java.util.ArrayList;
import java.util.List;

public class NhacService implements INhacService{
    private List<nhac> nhacs = new ArrayList<>();

    @Override
    public List<nhac> findAll() {
        return nhacs;
    }

    @Override
    public void save(nhac nhac) {
        nhacs.add(nhac);

    }

    @Override
    public nhac findById(int id) {
        return nhacs.get(id);
    }

    @Override
    public void update(int id, nhac nhac) {
        for (nhac p : nhacs) {
            if (p.getId() == id) {
                p = nhac;
                break;
            }
        }
    }

    @Override
    public void remove(int id) {
        for (int i = 0; i < nhacs.size(); i++) {
            if (nhacs.get(i).getId() == id) {
                nhacs.remove(i);
                break;
            }
        }
    }
}
