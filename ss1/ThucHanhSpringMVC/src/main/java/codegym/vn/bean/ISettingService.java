package codegym.vn.bean;

import codegym.vn.bean.Setting;

import java.util.List;
import java.util.Map;

public interface ISettingService {

    Map<Integer, Setting> findAll();

    void save(Setting setting);

    Setting findById(int id);


    void update(int id, Setting setting);
}
