package codegym.vn.service;

import codegym.vn.bean.Music;
import codegym.vn.repository.IMusicRepository;
import codegym.vn.repository.IProvinceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MucsicService implements IMusicService {
    @Autowired
    private IMusicRepository musicRepository;

    @Override
    public Iterable<Music> findAll() {
        return musicRepository.findAll();
    }

    @Override
    public Music findById(Long id) {
        return musicRepository.findOne(id);
    }

    @Override
    public void save(Music music) {
        musicRepository.save(music);

    }

    @Override
    public void remove(Long id) {
        musicRepository.delete(id);

    }
}
