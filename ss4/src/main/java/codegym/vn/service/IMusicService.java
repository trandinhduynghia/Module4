package codegym.vn.service;

import codegym.vn.bean.music;

import java.util.List;

public interface IMusicService {
    List<music> findAll();

    void save(music nhac);

    music findById(int id);

    void update(int id, music nhac);

    void remove(int id);
}
