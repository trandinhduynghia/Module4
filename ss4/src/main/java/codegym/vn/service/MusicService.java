package codegym.vn.service;

import codegym.vn.bean.music;

import java.util.ArrayList;
import java.util.List;

public class MusicService implements IMusicService {
    private List<music> nhacs = new ArrayList<>();

    @Override
    public List<music> findAll() {
        return nhacs;
    }

    @Override
    public void save(music nhac) {
        nhacs.add(nhac);

    }

    @Override
    public music findById(int id) {
        return nhacs.get(id);
    }

    @Override
    public void update(int id, music nhac) {
        for (music p : nhacs) {
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
