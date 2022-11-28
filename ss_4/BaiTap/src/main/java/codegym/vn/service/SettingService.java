package codegym.vn.service;

import codegym.vn.bean.Setting;

public interface SettingService {
    void save(Setting setting);

    Setting findById(int id);


    void update(int id, Setting setting);
}
