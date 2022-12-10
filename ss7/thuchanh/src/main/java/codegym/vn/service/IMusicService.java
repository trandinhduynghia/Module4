package codegym.vn.service;

import codegym.vn.bean.Music;
import codegym.vn.bean.Province;

public interface IMusicService {
    Iterable<Music> findAll();

    Music findById(Long id);

    void save(Music music);

    void remove(Long id);
}
