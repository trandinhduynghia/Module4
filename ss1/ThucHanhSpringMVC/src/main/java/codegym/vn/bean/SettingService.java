package codegym.vn.bean;

import codegym.vn.bean.Setting;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SettingService implements ISettingService {
    private static Map<Integer, Setting> settingMap;

    static {
        settingMap =new HashMap<>();
        settingMap.put(1, new Setting(1, "English", 200000, true, "abc"));

    }


    @Override
    public Map<Integer, Setting> findAll() {
        return settingMap;
    }

    @Override
    public void save(Setting setting) {
        settingMap.put(setting.getId(), setting);
    }

    @Override
    public Setting findById(int id) {
        return settingMap.get(id);
    }

    @Override
    public void update(int id, Setting setting) {
        settingMap.put(id, setting);
    }

}
