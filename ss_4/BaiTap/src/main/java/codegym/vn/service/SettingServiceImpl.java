package codegym.vn.service;

import codegym.vn.bean.Setting;

import java.util.HashMap;
import java.util.Map;

public class SettingServiceImpl implements SettingService{
    private static Map<Integer, Setting> settingMap;
    static {
        settingMap =new HashMap<>();
        settingMap.put(1, new Setting(1, "English", 200000, true, "abc"));

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
